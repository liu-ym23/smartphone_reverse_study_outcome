package y36;

import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n extends i<SoftInputMode> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        SoftInputMode r100 = (SoftInputMode) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public n(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter("soft_input_mode", "key");
        super(null);
        b(r100, "soft_input_mode", null);
    }

    @Override // y36.i
    public final SoftInputMode d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        SoftInputMode[] r101 = SoftInputMode.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SoftInputMode r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public n(SoftInputMode r100) {
        super(r100);
    }
}
