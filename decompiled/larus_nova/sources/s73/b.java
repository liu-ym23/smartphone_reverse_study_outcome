package s73;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.k;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f540922a;

    public static boolean b() {
        if (h.a() == false) goto L7;
        return true;
    L7:
        return f540922a;
    }

    static {
    }

    public static boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        k r101 = ECSettingKeys.A0();
        boolean r102 = r100.f540921e;
        boolean r103 = r101.b();
        Object r104 = ECSettingKeys.p0().get(r100.f540917a);
        Object r105 = null;
        if ((r104 instanceof Map) == true) goto L5;
        r104 = null;
    L5:
        Map r106 = (Map) r104;
        Float r107 = r100.f540919c;
        if (r107 == null) goto L11;
        if (Intrinsics.areEqual(r107, 0.75f) == false) goto L11;
        return true;
    L11:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == false) goto L14;
        return true;
    L14:
        if (r101.a() == false) goto L29;
        if (r100.f540918b == null) goto L29;
        if (r106 == null) goto L19;
        Object r108 = r106.get("no_optimize_header_first_category_id_list");
    L21:
        if ((r108 instanceof List) == true) goto L23;
        r108 = null;
    L23:
        List r109 = (List) r108;
        if (r109 == null) goto L29;
        if (CollectionsKt.contains(r109, r100.f540918b) != true) goto L29;
        return false;
    L19:
        r108 = null;
    L29:
        if (Intrinsics.areEqual(r100.f540920d, "1") == false) goto L31;
    L49:
        return true;
    L31:
        if (Intrinsics.areEqual(r100.f540920d, "3") == true) goto L49;
        if (r102 == false) goto L36;
        if (r103 == false) goto L36;
        return true;
    L36:
        if (r106 != null) goto L38;
        return false;
    L38:
        if (r100.f540918b == null) goto L47;
        Object r110 = r106.get("show_optimize_header_first_category_id_list");
        if ((r110 instanceof List) == false) goto L43;
        r105 = r110;
    L43:
        List r111 = (List) r105;
        if (r111 != null) goto L46;
        return false;
    L46:
        return CollectionsKt.contains(r111, r100.f540918b);
    L47:
        return true;
    }
}
