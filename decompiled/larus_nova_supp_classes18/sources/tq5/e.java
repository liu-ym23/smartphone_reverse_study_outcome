package tq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T1, T2, R> implements BiFunction {
    public static final e<T1, T2, R> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r3, Object r4) {
        SpaceInfo r5 = (SpaceInfo) r3;
        SpaceInfo r6 = (SpaceInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "srcSpaceInfo");
        Intrinsics.checkNotNullParameter(r6, "destSpaceInfo");
        tt5.a.h("Wiki_WikiMovToFragment", "needShowSinglePageOwnerTips()...src_owner_perm_type = " + r5.owner_perm_type + ", dest_owner_perm_type = " + r6.owner_perm_type);
        int r0 = hj5.a.a;
        int r7 = r5.owner_perm_type;
        boolean r1 = false;
        if (r7 == 0) goto L7;
        if (r7 == 1) goto L7;
        boolean r8 = false;
    L8:
        if (r8 == false) goto L16;
        if (r6.owner_perm_type != 2) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        r1 = true;
        goto L16
    L12:
        r9 = false;
    L16:
        return Boolean.valueOf(r1);
    L7:
        r8 = true;
        goto L8
    }
}
