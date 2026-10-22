package com.bytedance.ee.bear.drive.core;

import android.R;
import android.app.Activity;
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

/* JADX INFO: loaded from: classes16.dex */
public class DriveActivity extends DriveRootActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f224111i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public msb.a f224112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<BaseOpenEntity> f224113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f224114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f224115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f224116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f224117h;

    public String G1() {
        return "DriveComponent";
    }

    public final boolean F1() {
        ArrayList<BaseOpenEntity> r100 = this.f224113d;
        if (r100 == null) goto L14;
        Iterator<BaseOpenEntity> r101 = r100.iterator();
        boolean r102 = false;
    L6:
        if (r101.hasNext() == false) goto L11;
        if (r101.next().getBizType() != 2) goto L15;
        r102 = true;
        goto L6
    L15:
        return false;
    L11:
        return r102;
    L14:
        return false;
    }

    public final void H1() {
        getIntent().setExtrasClassLoader(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L12
        this.f224113d = getIntent().getParcelableArrayListExtra("extra_drive_sdk_open_entity");     // Catch: Exception -> L12
        this.f224115f = getIntent().getIntExtra("extra_drive_sdk_open_index", 0);     // Catch: Exception -> L12
        this.f224114e = getIntent().getExtras();     // Catch: Exception -> L12
        if (c.a.f206237a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L6;
        this.f224116g = getIntent().getIntExtra("extra_drive_sdk_enter_anime", -1);     // Catch: Exception -> L12
        this.f224117h = getIntent().getIntExtra("extra_drive_sdk_exit_anime", -1);     // Catch: Exception -> L12
    L6:
        String r100 = G1();     // Catch: Exception -> L12
        StringBuilder r101 = new StringBuilder("readExtra() mOpenEntities size=");     // Catch: Exception -> L12
        if (this.f224113d != null) goto L9;
        Object r102 = 0;     // Catch: Exception -> L12
    L10:
        r101.append(r102);     // Catch: Exception -> L12
        tt5.a.h(r100, r101.toString());     // Catch: Exception -> L12
        return;
    L9:
        r102 = this.f224113d.size() + " index=" + this.f224115f;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.f(G1(), e, false);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public DriveActivity() {
        this.f224116g = -1;
        this.f224117h = -1;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(com.larus.nova.R.layout.drive_activity_main);
        H1();
        if (this.f224113d != null) goto L7;
        tt5.a.d(G1(), "null open data, finish page...");
        finish();
        return;
    L7:
        if (c.a.f206237a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L11;
        int r101 = this.f224116g;
        if (r101 == (-1)) goto L11;
        overridePendingTransition(r101, this.f224117h);
    L11:
        I1(this.f224113d, this.f224115f, r100);
    }

    public final void C1(Resources.Theme r100) {
        if (r100 != null) goto L6;
        tt5.a.k(G1(), "applyFlowTheme theme is null");
        return;
    L6:
        if (DowngradeSettingUtil.a("downgradeDocFlowTheme") == false) goto L14;
        return;
    L14:
        b.a(null).a(r100, G1());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e(G1(), "applyFlowTheme failed", e, false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.drive.core.a] */
    public final com.bytedance.ee.bear.drive.biz.multitask.a D1(Intent r100) {
        if (r100 != null) goto L5;
        r100 = new Intent();
    L5:
        if (hu5.a.d(this.f224113d) == true) goto L11;
        int r101 = this.f224115f;
        if (r101 < 0) goto L11;
        if (r101 >= this.f224113d.size()) goto L11;
        String r102 = ((BaseOpenEntity) ListProtector.get(this.f224113d, this.f224115f)).getFileId();
    L13:
        return new com.bytedance.ee.bear.drive.biz.multitask.a(this, r100, r102, new a(this));
    L11:
        r102 = "";
        goto L13
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        setIntent(r100);
        H1();
        ArrayList<BaseOpenEntity> r101 = this.f224113d;
        if (r101 != null) goto L6;
        tt5.a.d(G1(), "null open data, finish page...");
        finish();
        return;
    L6:
        I1(r101, this.f224115f, null);
        if (this.f224112c != null) goto L9;
        return;
    L9:
        if (F1() == false) goto L17;
        msb.a r102 = this.f224112c;
        com.bytedance.ee.bear.drive.biz.multitask.a r103 = D1(r100);
        r102.getClass();
        this.f224112c = msb.a.d(r103);
        if (vb(xj5.a.class) == null) goto L13;
        return;
    L13:
        if (F1() == false) goto L19;
        Xi(new xj5.a(this, this.f224112c));
        return;
    L19:
        return;
    }

    @Override // com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public final void onPostCreate(Bundle r100) {
        super.onPostCreate(r100);
        if (F1() == false) goto L10;
        this.f224112c = msb.a.a(D1(getIntent()));
        if (vb(xj5.a.class) == null) goto L7;
        return;
    L7:
        if (F1() == false) goto L12;
        Xi(new xj5.a(this, this.f224112c));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r100) {
        super.setTheme(r100);
        C1(getTheme());
    }

    @Override // android.view.ContextThemeWrapper
    public final void setTheme(Resources.Theme r100) {
        super.setTheme(r100);
        C1(r100);
    }

    public final void K1(ArrayList<BaseOpenEntity> r100, int r101) {
        j r102 = ((f) org.koin.java.a.a(f.class)).U4(this);
        UserContainerDriveMainFragment r103 = new UserContainerDriveMainFragment();
        Bundle r104 = new Bundle();
        Bundle r105 = this.f224114e;
        if (r105 == null) goto L5;
        r104.putAll(r105);
    L5:
        PassportcConvention.f(r104, LarkContext.getApplication());
        r104.putParcelableArrayList("extra_drive_sdk_open_entity", r100);
        r104.putInt("extra_drive_sdk_open_index", r101);
        r104.putString("drive_open_strategy_key", x75.a.b(r102));
        r103.setArguments(r104);
        FragmentTransaction r106 = getSupportFragmentManager().beginTransaction();
        int r107 = DriveMainFragment.f224144l;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "DriveMainFragment", com.larus.nova.R.id.drive_activity_container) == true) goto L9;
        r106 = r106.replace(com.larus.nova.R.id.drive_activity_container, r103, "DriveMainFragment");
    L9:
        r106.commitAllowingStateLoss();
    }

    public final void I1(ArrayList<BaseOpenEntity> r100, int r101, Bundle r102) {
        if (r102 != null) goto L4;
        tt5.a.h(G1(), "setUpPreview: default");
        K1(r100, r101);
        return;
    L4:
        FragmentManager r103 = getSupportFragmentManager();
        int r104 = DriveMainFragment.f224144l;
        Fragment r105 = r103.findFragmentByTag("DriveMainFragment");
        if (r105 != null) goto L8;
        tt5.a.h(G1(), "setUpPreview: restore not found Any fragment");
        K1(r100, r101);
        return;
    L8:
        if ((r105 instanceof DriveMainFragment) == true) goto L10;
        tt5.a.h(G1(), "setUpPreview: restore not found DriveMainFragment");
        K1(r100, r101);
        return;
    L10:
        tt5.a.h(G1(), "setUpPreview: restore DriveMainFragment");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).v(this, r100) == true) goto L6;
        super.startActivityForResult(r100, r101, r102);
        return;
    }
}
