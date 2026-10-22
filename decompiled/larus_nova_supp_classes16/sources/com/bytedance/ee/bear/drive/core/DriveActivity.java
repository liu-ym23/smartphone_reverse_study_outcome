package com.bytedance.ee.bear.drive.core;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import t75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveActivity extends DriveRootActivity {
    public static final /* synthetic */ int i = 0;
    public msb.a c;
    public ArrayList<BaseOpenEntity> d;
    public Bundle e;
    public int f;
    public int g;
    public int h;

    public String G1() {
        return "DriveComponent";
    }

    public final boolean F1() {
        ArrayList<BaseOpenEntity> r0 = this.d;
        if (r0 == null) goto L14;
        Iterator<BaseOpenEntity> r1 = r0.iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L11;
        if (r1.next().getBizType() != 2) goto L15;
        r2 = true;
        goto L6
    L15:
        return false;
    L11:
        return r2;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H1() {
        getIntent().setExtrasClassLoader(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L12
        this.d = getIntent().getParcelableArrayListExtra("extra_drive_sdk_open_entity");     // Catch: Exception -> L12
        this.f = getIntent().getIntExtra("extra_drive_sdk_open_index", 0);     // Catch: Exception -> L12
        this.e = getIntent().getExtras();     // Catch: Exception -> L12
        if (c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L6;
        this.g = getIntent().getIntExtra("extra_drive_sdk_enter_anime", -1);     // Catch: Exception -> L12
        this.h = getIntent().getIntExtra("extra_drive_sdk_exit_anime", -1);     // Catch: Exception -> L12
    L6:
        String r2 = G1();     // Catch: Exception -> L12
        StringBuilder r3 = new StringBuilder("readExtra() mOpenEntities size=");     // Catch: Exception -> L12
        if (this.d != null) goto L9;
        Object r0 = 0;     // Catch: Exception -> L12
    L10:
        r3.append(r0);     // Catch: Exception -> L12
        tt5.a.h(r2, r3.toString());     // Catch: Exception -> L12
        return;
    L9:
        r0 = this.d.size() + " index=" + this.f;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f(G1(), e, false);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public DriveActivity() {
        this.g = -1;
        this.h = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r4) {
        setContentView(2131560178);
        H1();
        if (this.d != null) goto L7;
        tt5.a.d(G1(), "null open data, finish page...");
        finish();
        return;
    L7:
        if (c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L11;
        int r0 = this.g;
        if (r0 == (-1)) goto L11;
        overridePendingTransition(r0, this.h);
    L11:
        I1(this.d, this.f, r4);
    }

    public final void C1(Resources.Theme r4) {
        if (r4 != null) goto L6;
        tt5.a.k(G1(), "applyFlowTheme theme is null");
        return;
    L6:
        if (DowngradeSettingUtil.a("downgradeDocFlowTheme") == false) goto L14;
        return;
    L14:
        b.a(null).a(r4, G1());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e(G1(), "applyFlowTheme failed", e, false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.drive.core.a] */
    public final com.bytedance.ee.bear.drive.biz.multitask.a D1(Intent r4) {
        if (r4 != null) goto L5;
        r4 = new Intent();
    L5:
        if (hu5.a.d(this.d) == true) goto L11;
        int r0 = this.f;
        if (r0 < 0) goto L11;
        if (r0 >= this.d.size()) goto L11;
        String r1 = ((BaseOpenEntity) ListProtector.get(this.d, this.f)).getFileId();
    L13:
        return new com.bytedance.ee.bear.drive.biz.multitask.a(this, r4, r1, new a(this));
    L11:
        r1 = "";
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r4);
        setIntent(r4);
        H1();
        ArrayList<BaseOpenEntity> r0 = this.d;
        if (r0 != null) goto L6;
        tt5.a.d(G1(), "null open data, finish page...");
        finish();
        return;
    L6:
        I1(r0, this.f, null);
        if (this.c != null) goto L9;
        return;
    L9:
        if (F1() == false) goto L17;
        msb.a r1 = this.c;
        com.bytedance.ee.bear.drive.biz.multitask.a r5 = D1(r4);
        r1.getClass();
        this.c = msb.a.d(r5);
        if (vb(xj5.a.class) == null) goto L13;
        return;
    L13:
        if (F1() == false) goto L19;
        Xi(new xj5.a(this, this.c));
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPostCreate(Bundle r2) {
        super/*com.larksuite.component.air.AirActivity*/.onPostCreate(r2);
        if (F1() == false) goto L10;
        this.c = msb.a.a(D1(getIntent()));
        if (vb(xj5.a.class) == null) goto L7;
        return;
    L7:
        if (F1() == false) goto L12;
        Xi(new xj5.a(this, this.c));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void setTheme(int r1) {
        super.setTheme(r1);
        C1(getTheme());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTheme(Resources.Theme r1) {
        super/*android.app.Activity*/.setTheme(r1);
        C1(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K1(ArrayList<BaseOpenEntity> r5, int r6) {
        j r0 = ((f) org.koin.java.a.a(f.class)).U4(this);
        UserContainerDriveMainFragment r1 = new UserContainerDriveMainFragment();
        Bundle r2 = new Bundle();
        Bundle r3 = this.e;
        if (r3 == null) goto L5;
        r2.putAll(r3);
    L5:
        PassportcConvention.f(r2, LarkContext.getApplication());
        r2.putParcelableArrayList("extra_drive_sdk_open_entity", r5);
        r2.putInt("extra_drive_sdk_open_index", r6);
        r2.putString("drive_open_strategy_key", x75.a.b(r0));
        r1.setArguments(r2);
        FragmentTransaction r7 = getSupportFragmentManager().beginTransaction();
        int r8 = DriveMainFragment.l;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "DriveMainFragment", 2131370247) == true) goto L9;
        r7 = r7.replace(2131370247, r1, "DriveMainFragment");
    L9:
        r7.commitAllowingStateLoss();
    }

    public final void I1(ArrayList<BaseOpenEntity> r2, int r3, Bundle r4) {
        if (r4 != null) goto L4;
        tt5.a.h(G1(), "setUpPreview: default");
        K1(r2, r3);
        return;
    L4:
        FragmentManager r5 = getSupportFragmentManager();
        int r0 = DriveMainFragment.l;
        Fragment r6 = r5.findFragmentByTag("DriveMainFragment");
        if (r6 != null) goto L8;
        tt5.a.h(G1(), "setUpPreview: restore not found Any fragment");
        K1(r2, r3);
        return;
    L8:
        if ((r6 instanceof DriveMainFragment) == true) goto L10;
        tt5.a.h(G1(), "setUpPreview: restore not found DriveMainFragment");
        K1(r2, r3);
        return;
    L10:
        tt5.a.h(G1(), "setUpPreview: restore DriveMainFragment");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).v(this, r2) == true) goto L6;
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(r2, r3, r4);
        return;
    }
}
