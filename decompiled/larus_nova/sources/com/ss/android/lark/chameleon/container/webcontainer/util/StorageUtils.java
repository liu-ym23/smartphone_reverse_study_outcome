package com.ss.android.lark.chameleon.container.webcontainer.util;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/util/StorageUtils;", "", "()V", "composeStoragePath", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bizRootDictionary", "bizChildPath", "type", "Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;[Ljava/lang/Object;)Ljava/lang/String;", "getFilePath", "getInnerCachePath", "getInnerFilePath", "getOuterCachePath", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StorageUtils {
    public static final StorageUtils INSTANCE = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Storage.Type.values().length];
            r100[Storage.Type.INNER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Storage.Type.INNER_FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Storage.Type.FILES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new StorageUtils();
    }

    private StorageUtils() {
    }

    public final String getFilePath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getExternalFilesDir(null);
        if (r101 != null) goto L5;
        r101 = r100.getFilesDir();
    L5:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getPath();
    }

    public final String getInnerCachePath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public final String getInnerFilePath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public final String getOuterCachePath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getExternalCacheDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    @JvmStatic
    public static final String composeStoragePath(Context r100, String r101, String r102, Storage.Type r103, Object[] r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizRootDictionary");
        Intrinsics.checkNotNullParameter(r102, "bizChildPath");
        Intrinsics.checkNotNullParameter(r103, "type");
        int r105 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        boolean r106 = true;
        if (r105 != 1) goto L5;
        String r107 = INSTANCE.getInnerCachePath(r100) + File.separator;
    L12:
        String r108 = r107 + r101;
        if (TextUtils.isEmpty(r102) == true) goto L16;
        r108 = r108 + File.separator + r102;
    L16:
        if (r104 != null) goto L18;
    L24:
        r106 = false;
    L25:
        if (r106 == false) goto L30;
        Iterator r109 = ArrayIteratorKt.iterator(r104);
    L28:
        if (r109.hasNext() == false) goto L30;
        r108 = r108 + File.separator + r109.next();
    L30:
        return r108;
    L18:
        if (r104.length != 0) goto L20;
        boolean r110 = true;
    L22:
        if ((!r110) != true) goto L24;
    L20:
        r110 = false;
        goto L22
    L5:
        if (r105 != 2) goto L7;
        r107 = INSTANCE.getInnerFilePath(r100) + File.separator;
        goto L12
    L7:
        if (r105 == 3) goto L9;
        r107 = INSTANCE.getOuterCachePath(r100) + File.separator;
        goto L12
    L9:
        r107 = INSTANCE.getFilePath(r100) + File.separator;
        goto L12
    }
}
