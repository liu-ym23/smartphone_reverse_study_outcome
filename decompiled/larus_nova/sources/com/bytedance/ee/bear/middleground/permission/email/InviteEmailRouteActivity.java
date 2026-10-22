package com.bytedance.ee.bear.middleground.permission.email;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import ax4.f;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010&\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "commonLoadingFromXml", "Landroid/widget/LinearLayout;", "getCommonLoadingFromXml", "()Landroid/widget/LinearLayout;", "setCommonLoadingFromXml", "(Landroid/widget/LinearLayout;)V", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "routeBean", "Lcom/bytedance/ee/bear/route/RouteBean;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "loading", "Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity$Loading;", "getLoading", "()Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity$Loading;", "loading$delegate", "Lkotlin/Lazy;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isArgsIllegal", "", "onNewIntent", "intent", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, CloudControlInf.ROUTE, "saveLocal", RuleConditionBean.OPEN_URL_KEY, "authorization", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/contract/net/SimpleRequestResult;", VideoEventOneOutSync.END_TYPE_FINISH, "Companion", "Loading", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteEmailRouteActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f233833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BearUrl f233834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RouteBean f233835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f233836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f233837g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LinearLayout> f233838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CompositeDisposable f233839b;

        public b(LinearLayout r100) {
            this.f233838a = new WeakReference(r100);
            this.f233839b = new CompositeDisposable();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteEmailRouteActivity f233840a;

        public c(InviteEmailRouteActivity r100) {
            this.f233840a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SimpleRequestResult r101 = (SimpleRequestResult) r100;
            tt5.a.h("InviteEmailRouteActivity", "authorization()...success.");
            InviteEmailRouteActivity.C1(this.f233840a);
            InviteEmailRouteActivity r102 = this.f233840a;
            r102.getClass();
            tt5.a.h("InviteEmailRouteActivity", "saveLocal()...");
            com.ss.android.lark.storage.kv.repo.a r103 = ay4.b.d("scene_invite_email", 6);
            if (r103.b().length <= 100) goto L5;
            tt5.a.h("InviteEmailRouteActivity", "saveLocal()...exceed limit.");
            r103.clear();
        L5:
            BearUrl r104 = r102.f233834d;
            if (r104 == null) goto L9;
            String r105 = r104.f222561b;
            if (r105 == null) goto L9;
        L10:
            if (r104 == null) goto L12;
            String r106 = r104.f222574o;
        L13:
            r103.putString(r105, r106);
            return;
        L12:
            r106 = null;
        L9:
            r105 = "";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteEmailRouteActivity f233841a;

        public d(InviteEmailRouteActivity r100) {
            this.f233841a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("InviteEmailRouteActivity", "authorization()...failed, error = " + ((Throwable) r100));
            InviteEmailRouteActivity.C1(this.f233841a);
        }
    }

    static {
    }

    public final void D1() {
        tt5.a.h("InviteEmailRouteActivity", "route()...");
        this.f233836f.clear();
        b r100 = (b) this.f233837g.getValue();
        r100.f233839b.add(Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new com.bytedance.ee.bear.middleground.permission.email.a(r100)).subscribe(com.bytedance.ee.bear.middleground.permission.email.b.f233843a, com.bytedance.ee.bear.middleground.permission.email.c.f233844a));
        NetService.f r101 = new NetService.f("/space/api/user/email_invite_relation/create/");
        r101.f216906c = 1;
        JSONObject r102 = new JSONObject();
        BearUrl r103 = this.f233834d;
        if (r103 == null) goto L5;
        String r104 = r103.f222560a;
    L6:
        r102.put("obj_type", e.g(r104));
        BearUrl r105 = this.f233834d;
        if (r105 == null) goto L9;
        String r106 = r105.f222561b;
    L10:
        r102.put("token", r106);
        BearUrl r107 = this.f233834d;
        if (r107 == null) goto L13;
        String r108 = r107.f222574o;
    L14:
        r102.put("invite_token", r108);
        r101.f216913j = r102.toString();
        this.f233836f.add(((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r101).subscribe(new c(this), new d(this)));
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(InviteEmailRouteActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(InviteEmailRouteActivity.class.getName()));
    L5:
        tt5.a.h("InviteEmailRouteActivity", "onDestroy()...");
        super.onDestroy();
        b r100 = (b) this.f233837g.getValue();
        r100.f233839b.clear();
        LinearLayout r101 = r100.f233838a.get();
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f233836f.clear();
    }

    public InviteEmailRouteActivity() {
        this.f233836f = new CompositeDisposable();
        this.f233837g = LazyKt.lazy(new InviteEmailRouteActivity$loading$2(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public static final void C1(InviteEmailRouteActivity r100) {
        r100.getClass();
        tt5.a.h("InviteEmailRouteActivity", "openUrl()...");
        b r101 = (b) r100.f233837g.getValue();
        r101.f233839b.clear();
        LinearLayout r102 = r101.f233838a.get();
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        String r103 = null;
        h r104 = (h) org.koin.java.a.c(h.class, null, null, 6);
        BearUrl r105 = r100.f233834d;
        if (r105 == null) goto L8;
        r103 = r105.f222564e;
    L8:
        r104.m9(r103, r100.f233835e);
        r100.finish();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        tt5.a.h("InviteEmailRouteActivity", "onDoCreate()...");
        setContentView(com.larus.nova.R.layout.activity_invite_email_route);
        if (r100 != null) goto L21;
        Intent r101 = getIntent();
        RouteBean r102 = null;
        if (r101 == null) goto L7;
        BearUrl r103 = (BearUrl) r101.getParcelableExtra("key_bear_url");
    L8:
        this.f233834d = r103;
        Intent r104 = getIntent();
        if (r104 == null) goto L11;
        r102 = (RouteBean) r104.getParcelableExtra("extra_intent_data");
    L11:
        this.f233835e = r102;
        if (this.f233834d == null) goto L16;
        if (r102 == null) goto L16;
        boolean r105 = false;
    L17:
        if (r105 == true) goto L21;
        D1();
        return;
    L16:
        r105 = true;
        goto L17
    L7:
        r103 = null;
    L21:
        tt5.a.h("InviteEmailRouteActivity", "onDoCreate()...parse bundle illegal");
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        D1();
    }
}
