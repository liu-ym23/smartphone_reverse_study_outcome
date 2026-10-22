package kk3;

import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final TabKitAnnieXTabFragment a;

    public final TabKitViewModel b() {
        return this.a.getTabKitViewModel();
    }

    public final TabkitSwitchTabPref a() {
        ok3.a r0 = b().getTabKitMonitor();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(this.a.getTabId());
    }

    public a(TabKitAnnieXTabFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "tabFragment");
        this.a = r2;
    }

    public final void c(String r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.a.isLandingTab() == false) goto L9;
        ok3.a r0 = b().getTabKitMonitor();
        if (r0 == null) goto L13;
        TabkitFirstFramePref r1 = r0.d;
        if (r1 == null) goto L14;
        r1.recordTime(r2, r3);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        TabkitSwitchTabPref r4 = a();
        if (r4 == null) goto L16;
        r4.recordTime(r2, r3);
        return;
    }
}
