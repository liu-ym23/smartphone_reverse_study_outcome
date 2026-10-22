package com.bytedance.ee.bear.wikiv2;

import android.R;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.bear.lark.dependency.p;
import com.bytedance.ee.bear.wikiv2.extension.LoadDataToCacheExtension;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.intent.export.entity.donate.DocDonateEntity;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiActivity extends BaseActivity implements com.bytedance.ee.bear.m, d0c.c {
    public String F1() {
        return "WikiActivity";
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void C1() {
        com.bytedance.ee.bear.wikiv2.extension.c r0 = (com.bytedance.ee.bear.wikiv2.extension.c) vb(com.bytedance.ee.bear.wikiv2.extension.c.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b != null) goto L7;
        return;
    L7:
        if (vb(xj5.a.class) != null) goto L12;
        Xi(new xj5.a(this, r0.b));
        return;
    }

    public final msb.a Z() {
        com.bytedance.ee.bear.wikiv2.extension.c r0 = (com.bytedance.ee.bear.wikiv2.extension.c) vb(com.bytedance.ee.bear.wikiv2.extension.c.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
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

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        tt5.a.h(F1(), "onDestroy");
        super.onDestroy();
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
    L4:
        tt5.a.k(F1(), "provideUserSession fail, use top window userSession");
        return new ce5.a().b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Intent getIntent() {
        Intent r0 = super/*android.app.Activity*/.getIntent();
        if (r0 != null) goto L6;
        Intent r1 = new Intent();
        setIntent(r1);
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        setResult(205);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m662provideComponent() {
        return provideComponent();
    }

    public WikiActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1(Bundle r6) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.A1(r6);
        Parcelable r4 = null;
        getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), 2131100548, null)));
        if (r6 == null) goto L7;
        r4 = r6.getParcelable("SavedIntent");
    L7:
        if ((r4 instanceof Bundle) == false) goto L10;
        getIntent().putExtras((Bundle) r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r3) {
        tt5.a.h(F1(), "onCreate version is " + ((b0) org.koin.java.a.a(b0.class)).getVersionName());
        if (TextUtils.isEmpty(getIntent().getStringExtra(ResourceData.KEY_URL)) == false) goto L5;
        tt5.a.d(F1(), "validateIntent EMPTY URL");
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        tt5.a.k(F1(), "Bad intent !");
        finish();
        return;
    L9:
        FrameLayout r5 = new FrameLayout(this);
        r5.setId(2131369388);
        setContentView(r5);
        G1(getIntent(), false);
        Xi(new com.bytedance.ee.bear.wikiv2.extension.c(this));
        Xi(new xp5.a(this));
        Xi(new LoadDataToCacheExtension(this, new ce5.a(this)));
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void D1(Resources.Theme r4) {
        if (r4 != null) goto L6;
        tt5.a.k(F1(), "applyFlowTheme theme is null");
        return;
    L6:
        if (DowngradeSettingUtil.a("downgradeDocFlowTheme") == false) goto L14;
        return;
    L14:
        yz4.b.a(null).a(r4, F1());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e(F1(), "applyFlowTheme failed", e, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r6) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r6);
        boolean r1 = false;
        boolean r0 = r6.getBooleanExtra("popLastDocument", false);
        tt5.a.h(F1(), "onNewIntent popLastDocument?" + r0);
        if (TextUtils.isEmpty(r6.getStringExtra(ResourceData.KEY_URL)) == false) goto L6;
        tt5.a.d(F1(), "validateIntent EMPTY URL");
        r1 = true;
    L6:
        if ((!r1) == true) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        List r2 = ((BaseCommonActivity) this).b.a;
        if (r2 == null) goto L16;
        Iterator r3 = ((ArrayList) r2).iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        sa5.e r4 = (sa5.e) r3.next();
        if ((r4 instanceof xp5.g) == false) goto L12;
        ((xp5.g) r4).k(r6);
    L16:
        C1();
        setIntent(r6);
        G1(r6, r0);
    }

    public final void onPostCreate(Bundle r4) {
        super/*com.larksuite.component.air.AirActivity*/.onPostCreate(r4);
        tt5.a.h(F1(), "onPostCreate");
        Intrinsics.checkNotNullParameter(this, "<this>");
        List r0 = ((BaseCommonActivity) this).b.a;
        if (r0 == null) goto L10;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        sa5.e r2 = (sa5.e) r1.next();
        if ((r2 instanceof xp5.g) == false) goto L6;
        ((xp5.g) r2).l(r4);
    L10:
        C1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProvideAssistContent(AssistContent r7) {
        super/*android.app.Activity*/.onProvideAssistContent(r7);
        WikiFragment r0 = getSupportFragmentManager().findFragmentById(2131369388);
        if ((r0 instanceof WikiFragment) == true) goto L5;
        return;
    L5:
        WikiFragment r1 = r0;
        r1.getClass();
        if (new ce5.a(r1).d.isEnable("im.intent.available.reverse") == false) goto L8;
        tt5.a.h("WikiFragment", "close intent fg for wiki");
        return;
    L8:
        DocumentFragment r2 = r1.getChildFragmentManager().findFragmentById(2131393212);
        if ((r2 instanceof DocumentFragment) == false) goto L11;
        DocumentFragment r3 = r2;
    L12:
        if (r3 == null) goto L14;
        DocViewModel r4 = r3.H0();
    L15:
        if (r4 != null) goto L17;
        tt5.a.d(r1.getTag(), "donate doc viewModel is null");
        return;
    L17:
        if (r7 != null) goto L19;
        tt5.a.d(r1.getTag(), "donate assistContent is null");
        return;
    L19:
        String r5 = r4.getDocTitle();
        String r6 = r4.getUrl();
        String r8 = String.valueOf(r6.hashCode());
        Intrinsics.checkNotNull(r5);
        DocDonateEntity r9 = new DocDonateEntity(r8, r5, r6);
        tt5.a.h(r1.getTag(), "donate entity success: " + r9);
        p r10 = (p) org.koin.java.a.c(p.class, null, null, 6);
        ArrayList r11 = new ArrayList();
        r11.add(r9);
        r10.a(r7, r11);
        return;
    L14:
        r4 = null;
        goto L15
    L11:
        r3 = null;
        goto L12
    }

    public final void onSaveInstanceState(Bundle r3) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r3);
        r3.clear();
        Intent r0 = getIntent();
        r0.removeExtra("bear_url");
        r3.putBundle("SavedIntent", r0.getExtras());
    }

    public final void setTheme(int r1) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.setTheme(r1);
        D1(getTheme());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTheme(Resources.Theme r1) {
        super/*android.app.Activity*/.setTheme(r1);
        D1(r1);
    }

    public final void G1(Intent r7, boolean r8) {
        FragmentManager r0 = getSupportFragmentManager();
        Fragment r2 = r0.findFragmentById(2131369388);
        String r3 = r7.getStringExtra(ResourceData.KEY_URL);
        Bundle r4 = r7.getExtras();
        int r5 = WikiFragment.l;
        WikiFragment r6 = WikiFragment.a.a(r3, r4);
        if (r2 != null) goto L10;
        FragmentTransaction r9 = r0.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131369388) == true) goto L8;
        r9 = r9.add(2131369388, r6);
    L8:
        r9.commit();
        return;
    L10:
        if (r8 == false) goto L12;
        r0.beginTransaction().remove(r2).commitNowAllowingStateLoss();
    L12:
        FragmentTransaction r1 = r0.beginTransaction();
        if (r7.getBooleanExtra("addToBackStack", true) == false) goto L17;
        if (r8 == true) goto L17;
        r1.addToBackStack("document_stack");
    L17:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131369388) == true) goto L20;
        r1 = r1.replace(2131369388, r6);
    L20:
        r1.commitAllowingStateLoss();
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onActivityResult(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).v(this, r2) == true) goto L6;
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(r2, r3, r4);
        return;
    }
}
