package y36;

import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends i<NavBtnType> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        NavBtnType r100 = (NavBtnType) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public static NavBtnType e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        NavBtnType[] r101 = NavBtnType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        NavBtnType r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L10;
        if (Intrinsics.areEqual(r100, r104.getAliasValue()) == true) goto L10;
        r103 = r103 + 1;
    L10:
        return r104;
    L11:
        return null;
    }

    @Override // y36.i
    public final NavBtnType c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L10;
        NavBtnType r102 = e(String.valueOf(r101.intValue()));
        if (r102 == null) goto L10;
        return r102;
    L10:
        return (NavBtnType) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final /* bridge */ /* synthetic */ NavBtnType d(String r100) {
        return e(r100);
    }

    public g(t36.d r100, NavBtnType r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter("nav_btn_type", "key");
        super(null);
        b(r100, "nav_btn_type", r101);
    }
}
