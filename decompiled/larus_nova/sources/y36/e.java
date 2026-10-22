package y36;

import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends i<LaunchMode> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        LaunchMode r100 = (LaunchMode) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    @Override // y36.i
    public final LaunchMode d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        LaunchMode[] r101 = LaunchMode.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LaunchMode r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public e(t36.d r100, LaunchMode r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter("bdx_launch_mode", "key");
        super(null);
        b(r100, "bdx_launch_mode", r101);
    }
}
