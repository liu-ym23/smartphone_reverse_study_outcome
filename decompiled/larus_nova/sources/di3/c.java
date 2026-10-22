package di3;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468736a = 0;

    static {
    }

    public static StatTagItem b(Map r310) {
        if (r310 == null) goto L29;
        Object r100 = r310.get("id");
        if (r100 == null) goto L29;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.m(r100) == 1) goto L9;
        boolean r101 = true;
    L10:
        Object r102 = null;
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L29;
        long r103 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r310.get("id"));
        long r110 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r310.get("sentiment"));
        long r104 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r310.get("count_number"));
        Object r105 = r310.get("tag_name");
        if ((r105 instanceof String) == true) goto L19;
        r105 = null;
    L19:
        String r106 = (String) r105;
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        String r111 = r106;
        String r112 = r111 + ' ' + r104;
        Object r107 = r310.get(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE);
        if ((r107 instanceof String) == false) goto L27;
        r102 = r107;
    L27:
        return new StatTagItem(r103, r104, r112, r111, r110, Intrinsics.areEqual((String) r102, "1"), null, 0, 192, null);
    L9:
        r101 = false;
    L29:
        return new StatTagItem(1, 0, null, "全部", 0, false, null, 0, 246, null);
    }

    public static Object a(Map r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "objectClass");
        if (r100 != null) goto L5;
    L9:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L9;
        return u0.b(k.d(r100), r101);
    }
}
