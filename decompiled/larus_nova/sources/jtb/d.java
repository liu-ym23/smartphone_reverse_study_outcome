package jtb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import itb.f;
import itb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements itb.e {
    public d() {
    }

    @Override // itb.e
    public final boolean M0(FragmentActivity r100, g r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        itb.e r103 = (itb.e) OfficeSDKManager.getHostGlobalService(itb.e.class);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.M0(r100, r101, r102);
    }

    @Override // itb.e
    public final boolean f0(FragmentActivity r100, g r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        itb.e r103 = (itb.e) OfficeSDKManager.getHostGlobalService(itb.e.class);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.f0(r100, r101, r102);
    }
}
