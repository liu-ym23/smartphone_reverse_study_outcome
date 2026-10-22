package f14;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.im.serviceapi.AoImService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements z24.a {
    public a() {
    }

    @Override // k24.a
    public final void x0() {
    }

    @Override // z24.a
    public final boolean isAvailable() {
        AoImService r100 = d44.a.f466822a;
        AoImService r101 = d44.a.f466822a;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isAvailable();
    }

    @Override // z24.a
    public final void s0(FragmentActivity r100, HashMap r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extraMap");
        AoImService r102 = d44.a.f466822a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extraMap");
        AoImService r103 = d44.a.f466822a;
        if (r103 == null) goto L6;
        r103.x1();
        return;
    }
}
