package com.suite.lark.platform.component.storage.clean;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/platform/component/storage/clean/ResourceEraser$EraserResult;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CleanEngine$cleanFiles$1 extends Lambda implements Function0<m.a> {
    final /* synthetic */ List<String> $filePaths;
    final /* synthetic */ boolean $skipSafeDelete;
    final /* synthetic */ d this$0;

    public CleanEngine$cleanFiles$1(List<String> r100, boolean r101, d r102) {
        this.$filePaths = r100;
        this.$skipSafeDelete = r101;
        this.this$0 = r102;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final m.a invoke() {
        i r100 = i.f460606a;
        List<String> r101 = this.$filePaths;
        boolean r102 = this.$skipSafeDelete;
        d r103 = this.this$0;
        Iterator<T> r104 = r101.iterator();
        List r105 = null;
        long r106 = 0;
        i r110 = r100;
        String r111 = null;
        long r112 = 0;
        boolean r107 = false;
    L4:
        if (r104.hasNext() == false) goto L49;
        PolarisFileWrapper r113 = new PolarisFileWrapper((String) r104.next());
        String r114 = "";
        if (r113.exists() == false) goto L39;
        if (r102 == true) goto L50;
        r103.getClass();     // Catch: IOException -> L34
        Pair r108 = d.a(r113, r105);     // Catch: IOException -> L34
        boolean r115 = ((Boolean) r108.component1()).booleanValue();     // Catch: IOException -> L34
        r112 = r112 + ((Number) r108.component2()).longValue();
    L52:
        boolean r116 = !r113.isDirectory();
        if (r115 == false) goto L54;
    L38:
        String r109 = r114;
        boolean r117 = true;
    L40:
        if (r116 == false) goto L42;
        String r118 = "file";
    L44:
        if (r115 == false) goto L46;
        Log.i("StorageCleaner", "erase " + r118 + " success, exist:" + r117 + ", path:" + r113.getAbsolutePath() + ' ' + r109);
    L47:
        r105 = null;
        r106 = 0;
        goto L4
    L46:
        Log.e("StorageCleaner", "erase " + r118 + " failed, path:" + r113.getAbsolutePath() + ' ' + r109);
        r107 = true;
        goto L47
    L42:
        r118 = MapBundleKey.MapObjKey.OBJ_DIR;
        goto L44
    L54:
        r110 = i.f460607b;     // Catch: IOException -> L30
    L30:
        e = e;
    L37:
        r110 = i.f460608c;
        r111 = r113.getAbsolutePath();
        Log.e("StorageCleaner", "delete file has io exception:" + e.getMessage() + ", file:" + r113.getAbsolutePath());
    L32:
        e = e;
    L36:
        r116 = true;
        goto L37
    L50:
        r114 = "ignore whitelist";
        Iterator<File> r119 = FilesKt.walkBottomUp(r113).iterator();     // Catch: IOException -> L34
    L9:
        r115 = true;
    L11:
        if (r119.hasNext() == false) goto L52;
        File r120 = r119.next();     // Catch: IOException -> L34
        long r210 = r120.length();     // Catch: IOException -> L34
        if (r120.delete() == true) goto L16;
        r210 = r106;
    L16:
        r112 = r112 + r210;     // Catch: IOException -> L34
        if (r210 == r106) goto L19;
    L20:
        if (r115 == true) goto L9;
    L22:
        r115 = false;
        goto L11
    L19:
        if (r120.exists() == true) goto L22;
    L34:
        e = e;
        r115 = true;
        goto L36
    L39:
        r109 = "";
        r117 = false;
        r115 = true;
        r116 = true;
        goto L40
    L49:
        return new m.a(!r107, r110, "file paths: " + this.$filePaths, r112, r111, 24);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ m.a invoke() {
        return invoke();
    }
}
