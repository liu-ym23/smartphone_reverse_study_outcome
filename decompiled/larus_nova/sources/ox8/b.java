package ox8;

import com.larus.camera.impl.edulibs.cameraapi.idl.RpcErrorCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public static final e a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.l();
        RpcErrorCode r101 = r110.j();
        Integer r102 = r110.d();
        Integer r103 = r110.g();
        String r104 = r110.e();
        String r111 = r110.f();
        Long r112 = r110.b();
        i r113 = r110.k();
        String r114 = r110.c();
        List<Integer> r105 = r110.a();
        if (r105 == null) goto L5;
        List r106 = CollectionsKt.filterNotNull(r105);
    L6:
        List r107 = r106;
        List<h> r108 = r110.h();
        if (r108 == null) goto L16;
        List r109 = CollectionsKt.filterNotNull(r108);
        if (r109 == null) goto L16;
        h r115 = (h) CollectionsKt.firstOrNull(r109);
        if (r115 == null) goto L16;
        List<g> r116 = r115.a();
        if (r116 == null) goto L16;
        Object r117 = CollectionsKt.filterNotNull(r116);
        if (r117 == null) goto L16;
    L17:
        List r118 = CollectionsKt.listOf(r117);
        List<f> r119 = r110.i();
        if (r119 == null) goto L27;
        List r120 = CollectionsKt.filterNotNull(r119);
        if (r120 == null) goto L27;
        f r121 = (f) CollectionsKt.firstOrNull(r120);
        if (r121 == null) goto L27;
        List<String> r122 = r121.a();
        if (r122 == null) goto L27;
        Object r123 = CollectionsKt.filterNotNull(r122);
        if (r123 == null) goto L27;
    L29:
        return new e(r100, r101, r102, r118, CollectionsKt.listOf(r123), r107, r103, r104, r111, r112, r113, null, r114, null, 10240);
    L27:
        r123 = new ArrayList();
    L16:
        r117 = new ArrayList();
        goto L17
    L5:
        r106 = null;
        goto L6
    }
}
