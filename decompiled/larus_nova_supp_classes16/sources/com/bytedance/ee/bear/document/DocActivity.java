package com.bytedance.ee.bear.document;

import android.R;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.intent.export.entity.donate.DocDonateEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocActivity extends BaseActivity {
    public static final /* synthetic */ int d = 0;
    public msb.a c;

    public class a extends sa5.e {
        public final /* synthetic */ DocActivity a;

        @Override // sa5.e
        public final boolean j() {
            FragmentManager r0 = this.a.getSupportFragmentManager();
            DocActivity r1 = this.a;
            int r2 = DocActivity.d;
            r1.getClass();
            int r3 = r0.getBackStackEntryCount();
            if (r3 <= 0) goto L5;
            boolean r4 = "document_stack".equals(r0.getBackStackEntryAt(r3 - 1).getName());
        L6:
            tt5.a.h(this.a.G1(), "onDispatchFragmentBackPress , documentAtTopBackStack:" + r4);
            if (r4 == false) goto L10;
            com.bytedance.ee.util.ui.i.a(r0);
            r0.popBackStack();
            return true;
        L10:
            return false;
        L5:
            r4 = false;
            goto L6
        }

        public a(DocActivity r1) {
            this.a = r1;
        }
    }

    public String G1() {
        return "DocActivity";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
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

    public final void init() {
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).h();
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        r0.h("start_open");
        r0.j("start_open", "start_time", String.valueOf(System.currentTimeMillis()));
        DocBridgeWebViewV2.w3 = System.currentTimeMillis();
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this, new w(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        tt5.a.h(G1(), "onDestroy");
    }

    public final boolean D1() {
        BearUrl r0 = (BearUrl) getIntent().getParcelableExtra("bear_url");
        if (r0 != null) goto L5;
    L7:
        boolean r1 = fx4.a.a(getIntent().getStringExtra("url"));
    L9:
        return !r1;
    L5:
        if (r0.e == null) goto L7;
        r1 = TextUtils.equals(r0.c, DocViewModel.ANNOUNCE);
        goto L9
    }

    public final DocViewModel F1() {
        Fragment r0 = getSupportFragmentManager().findFragmentById(2131369388);
        if ((r0 instanceof DocumentFragment) == false) goto L5;
        DocumentFragment r1 = (DocumentFragment) r0;
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.H0();
    L5:
        r1 = null;
        goto L6
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

    public DocActivity() {
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void A1(Bundle r6) {
        super.A1(r6);
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
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r3) {
        tt5.a.h(G1(), "onCreate version is " + ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).getVersionName());
        if (TextUtils.isEmpty(getIntent().getStringExtra("url")) == false) goto L5;
        tt5.a.d(G1(), "validateIntent EMPTY URL");
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        tt5.a.k(G1(), "Bad intent !");
        finish();
        return;
    L9:
        init();
        FrameLayout r5 = new FrameLayout(this);
        r5.setId(2131369388);
        setContentView(r5);
        H1(getIntent(), false);
        Xi(new a(this));
        setResult(205);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void C1(Resources.Theme r4) {
        if (r4 != null) goto L6;
        tt5.a.k(G1(), "applyFlowTheme theme is null");
        return;
    L6:
        if (DowngradeSettingUtil.a("downgradeDocFlowTheme") == false) goto L14;
        return;
    L14:
        yz4.b.a(null).a(r4, G1());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e(G1(), "applyFlowTheme failed", e, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L17;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r6 = Integer.valueOf(r5.orientation);     // Catch: Throwable -> L14
        if (r6 != null) goto L9;
    L11:
        if (r2 != 3) goto L17;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L14
        goto L17
    L9:
        if (r6.intValue() != r2) goto L11;
    L17:
        if (ku5.c.k(this) == false) goto L22;
        com.bytedance.ee.util.ui.j.d(new v(this), 100);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r7) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r7);
        boolean r1 = false;
        boolean r0 = r7.getBooleanExtra("popLastDocument", false);
        tt5.a.h(G1(), "onNewIntent popLastDocument?" + r0);
        if (TextUtils.isEmpty(r7.getStringExtra("url")) == false) goto L5;
        tt5.a.d(G1(), "validateIntent EMPTY URL");
        boolean r3 = true;
    L6:
        if (r3 == true) goto L20;
        BearUrl r2 = s45.p.a().Z(r7.getStringExtra("url"));
        if (r2 != null) goto L11;
        tt5.a.d(G1(), "Empty bear url ,ignore !");
        goto L20
    L11:
        DocViewModel r4 = F1();
        if (r4 != null) goto L15;
        tt5.a.d(G1(), "No top document found !");
    L19:
        r1 = true;
        goto L20
    L15:
        if (TextUtils.equals(r2.b, r4.getToken()) == false) goto L19;
        if (r7.getBooleanExtra("force_load_same", false) == true) goto L19;
        tt5.a.k(G1(), "Same document, ignore !");
    L20:
        if (r1 == true) goto L23;
        return;
    L23:
        if (this.c != null) goto L25;
    L29:
        setIntent(r7);
        H1(r7, r0);
        return;
    L25:
        if (D1() == false) goto L29;
        msb.a r5 = this.c;
        com.bytedance.ee.bear.document.multitask.a r6 = new com.bytedance.ee.bear.document.multitask.a(this, r7, new t(this), new u(this));
        r5.getClass();
        this.c = msb.a.d(r6);
        if (vb(xj5.a.class) != null) goto L29;
        Xi(new xj5.a(this, this.c));
        goto L29
    L5:
        r3 = false;
        goto L6
    }

    public final void onPostCreate(Bundle r5) {
        super/*com.larksuite.component.air.AirActivity*/.onPostCreate(r5);
        if (D1() == false) goto L11;
        getIntent().putExtra("clear_res", false);
        this.c = msb.a.a(new com.bytedance.ee.bear.document.multitask.a(this, getIntent(), new t(this), new u(this)));
        if (vb(xj5.a.class) == null) goto L7;
    L9:
        getIntent().putExtra("clear_res", true);
        return;
    L7:
        if (D1() == false) goto L9;
        Xi(new xj5.a(this, this.c));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProvideAssistContent(AssistContent r5) {
        super/*android.app.Activity*/.onProvideAssistContent(r5);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.intent.available.reverse") == false) goto L6;
        tt5.a.h("DocActivity", "close intent fg for doc");
        return;
    L6:
        DocViewModel r0 = F1();
        if (r0 != null) goto L10;
        tt5.a.d(G1(), "donate doc viewModel is null");
        return;
    L10:
        if (r5 != null) goto L13;
        tt5.a.d(G1(), "donate assistContent is null");
        return;
    L13:
        String r1 = r0.getDocTitle();
        String r2 = r0.getUrl();
        DocDonateEntity r3 = new DocDonateEntity(Integer.toString(r2.hashCode()), r1, r2);
        tt5.a.h(G1(), "donate entity success: " + r3);
        com.bytedance.ee.bear.lark.dependency.p r4 = (com.bytedance.ee.bear.lark.dependency.p) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.p.class);
        ArrayList r6 = new ArrayList();
        r6.add(r3);
        r4.a(r5, r6);
    }

    public final void onSaveInstanceState(Bundle r3) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r3);
        r3.clear();
        Intent r0 = getIntent();
        r0.removeExtra("bear_url");
        r3.putBundle("SavedIntent", r0.getExtras());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRequestedOrientation(int r1) {
        super/*android.app.Activity*/.setRequestedOrientation(r1);
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

    public final void H1(Intent r8, boolean r9) {
        FragmentManager r0 = getSupportFragmentManager();
        Fragment r2 = r0.findFragmentById(2131369388);
        String r3 = r8.getStringExtra("url");
        BearUrl r4 = (BearUrl) r8.getParcelableExtra("bear_url");
        Bundle r5 = r8.getExtras();
        if (r4 != null) goto L5;
    L7:
        BaseFragment r6 = DocumentFragment.ka0(r3, r5);
    L9:
        if (r2 != null) goto L16;
        FragmentTransaction r10 = r0.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131369388) == true) goto L14;
        r10 = r10.add(2131369388, r6);
    L14:
        r10.commit();
        return;
    L16:
        if (r9 == false) goto L18;
        r0.beginTransaction().remove(r2).commitNowAllowingStateLoss();
    L18:
        FragmentTransaction r1 = r0.beginTransaction();
        if (r8.getBooleanExtra("addToBackStack", true) == false) goto L23;
        if (r9 == true) goto L23;
        r1.addToBackStack("document_stack");
    L23:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131369388) == true) goto L26;
        r1 = r1.replace(2131369388, r6);
    L26:
        r1.commitAllowingStateLoss();
        return;
    L5:
        if (r4.e == null) goto L7;
        r6 = DocumentFragment.ja0(r4, r5);
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        if (r4 == 16) goto L5;
        return;
    L5:
        if (r5 != (-1)) goto L21;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getExtras() == null) goto L23;
        Iterator<String> r7 = r6.getExtras().keySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L24;
        String r8 = r7.next();
        Object r0 = r6.getExtras().get(r8);
        if (r0 == null) goto L11;
        ((DocViewModel) ViewModelProviders.of(this).get(DocViewModel.class)).setExtraData(r8, r0);
        goto L11
    L24:
        return;
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).v(this, r2) == true) goto L6;
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(r2, r3, r4);
        return;
    }
}
