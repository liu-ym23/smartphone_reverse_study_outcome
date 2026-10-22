package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$AutoBatteryNightModeManager extends AppCompatDelegateImpl$AutoNightModeManager {
    private final PowerManager mPowerManager;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return r0;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public int getApplyableNightMode() {
        if (AppCompatDelegateImpl$Api21Impl.isPowerSaveMode(this.mPowerManager) == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public void onChange() {
        this.this$0.applyDayNight();
    }

    public AppCompatDelegateImpl$AutoBatteryNightModeManager(AppCompatDelegateImpl r1, Context r2) {
        this.this$0 = r1;
        super(r1);
        this.mPowerManager = (PowerManager) r2.getApplicationContext().getSystemService("power");
    }
}
