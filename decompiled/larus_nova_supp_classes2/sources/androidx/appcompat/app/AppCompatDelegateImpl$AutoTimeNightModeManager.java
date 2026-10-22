package androidx.appcompat.app;

import android.content.IntentFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$AutoTimeNightModeManager extends AppCompatDelegateImpl$AutoNightModeManager {
    private final TwilightManager mTwilightManager;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.TIME_SET");
        r0.addAction("android.intent.action.TIMEZONE_CHANGED");
        r0.addAction("android.intent.action.TIME_TICK");
        return r0;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public int getApplyableNightMode() {
        if (this.mTwilightManager.isNight() == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public void onChange() {
        this.this$0.applyDayNight();
    }

    public AppCompatDelegateImpl$AutoTimeNightModeManager(AppCompatDelegateImpl r1, TwilightManager r2) {
        this.this$0 = r1;
        super(r1);
        this.mTwilightManager = r2;
    }
}
