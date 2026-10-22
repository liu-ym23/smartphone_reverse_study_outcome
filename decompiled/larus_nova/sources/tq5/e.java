package tq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T1, T2, R> f547151a = null;

    static {
        f547151a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        SpaceInfo r102 = (SpaceInfo) r100;
        SpaceInfo r103 = (SpaceInfo) r101;
        Intrinsics.checkNotNullParameter(r102, "srcSpaceInfo");
        Intrinsics.checkNotNullParameter(r103, "destSpaceInfo");
        tt5.a.h("Wiki_WikiMovToFragment", "needShowSinglePageOwnerTips()...src_owner_perm_type = " + r102.owner_perm_type + ", dest_owner_perm_type = " + r103.owner_perm_type);
        int r104 = hj5.a.f485431a;
        int r105 = r102.owner_perm_type;
        boolean r106 = false;
        if (r105 == 0) goto L7;
        if (r105 == 1) goto L7;
        boolean r107 = false;
    L8:
        if (r107 == false) goto L16;
        if (r103.owner_perm_type != 2) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L16;
        r106 = true;
        goto L16
    L12:
        r108 = false;
    L16:
        return Boolean.valueOf(r106);
    L7:
        r107 = true;
        goto L8
    }
}
