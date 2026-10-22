package f1b;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.officesdk.utils.di.t;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import swb.j;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends y0b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qpc.a f475094a;

    public d() {
        this.f475094a = (qpc.a) ApiUtils.getApi(qpc.a.class);
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r210) {
        if (r210 == null) goto L41;
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = r210.getEncodedQuery();
        String r102 = "";
        boolean r110 = true;
        if (r101 == null) goto L17;
        Iterator r103 = StringsKt.split$default(r101, new String[]{"&"}, false, 0, 6, null).iterator();
    L9:
        if (r103.hasNext() == false) goto L17;
        List r104 = StringsKt.split$default((String) r103.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 2, 2, null);
        int r105 = r104.size();
        if (r105 != 1) goto L13;
        r100.put(ListProtector.get(r104, 0), "");
        goto L9
    L13:
        if (r105 != 2) goto L9;
        r100.put((String) ListProtector.get(r104, 0), (String) ListProtector.get(r104, 1));
    L17:
        String r106 = (String) r100.get("crypto");
        String r111 = (String) r100.get("fsUnit");
        String r107 = (String) r100.get("key");
        if (r107 == null) goto L41;
        if (r106 == null) goto L21;
        ByteString.Companion.getClass();
        ByteString r112 = ByteString.a.a(r106);
    L22:
        qpc.a r113 = this.f475094a;
        String r108 = t.f437235a.get();
        if (r108 == null) goto L26;
        r102 = r108;
    L26:
        Intrinsics.checkNotNullParameter(r102, "traceId");
        if (r102.length() == 0) goto L31;
        r110 = false;
    L31:
        if (r110 == false) goto L33;
        String r109 = StringsKt.replace$default(String.valueOf(t.a()), "-", "", false, 4, null).substring(0, 10);
    L34:
        Resource r114 = r113.getEncryptImage(null, r107, r111, r112, r109, false);
        if (r114 == null) goto L41;
        String r115 = r114.f461377b;
        if (r115 == null) goto L41;
        return new WebResourceResponse(j.i(r107), Charset.defaultCharset().name(), VFSFiles.f444819b.k(r115));
    L33:
        r109 = r102 + '_' + StringsKt.replace$default(String.valueOf(t.a()), "-", "", false, 4, null).substring(0, 10);
        goto L34
    L21:
        r112 = null;
    L41:
        return null;
    }
}
