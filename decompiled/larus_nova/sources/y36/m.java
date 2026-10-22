package y36;

import com.bytedance.ies.bullet.service.sdk.param.SecStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m extends i<SecStrategy> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        SecStrategy r100 = (SecStrategy) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public static SecStrategy e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        SecStrategy[] r101 = SecStrategy.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SecStrategy r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    @Override // y36.i
    public final SecStrategy c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L10;
        SecStrategy r102 = e(String.valueOf(r101.intValue()));
        if (r102 == null) goto L10;
        return r102;
    L10:
        return (SecStrategy) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final /* bridge */ /* synthetic */ SecStrategy d(String r100) {
        return e(r100);
    }

    public m(t36.d r100, SecStrategy r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter("sec_strategy", "key");
        super(null);
        b(r100, "sec_strategy", r101);
    }
}
