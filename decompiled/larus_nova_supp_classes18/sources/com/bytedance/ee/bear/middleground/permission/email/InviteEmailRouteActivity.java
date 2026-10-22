package com.bytedance.ee.bear.middleground.permission.email;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010&\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "commonLoadingFromXml", "Landroid/widget/LinearLayout;", "getCommonLoadingFromXml", "()Landroid/widget/LinearLayout;", "setCommonLoadingFromXml", "(Landroid/widget/LinearLayout;)V", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "routeBean", "Lcom/bytedance/ee/bear/route/RouteBean;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "loading", "Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity$Loading;", "getLoading", "()Lcom/bytedance/ee/bear/middleground/permission/email/InviteEmailRouteActivity$Loading;", "loading$delegate", "Lkotlin/Lazy;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isArgsIllegal", "", "onNewIntent", "intent", "Landroid/content/Intent;", "onDestroy", "route", "saveLocal", "openUrl", "authorization", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/contract/net/SimpleRequestResult;", "finish", "Companion", "Loading", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteEmailRouteActivity extends BaseActivity {
    public LinearLayout c;
    public BearUrl d;
    public RouteBean e;
    public final CompositeDisposable f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b {
        public final WeakReference<LinearLayout> a;
        public final CompositeDisposable b;

        public b(LinearLayout r2) {
            this.a = new WeakReference(r2);
            this.b = new CompositeDisposable();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ InviteEmailRouteActivity a;

        public c(InviteEmailRouteActivity r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            SimpleRequestResult r6 = (SimpleRequestResult) r5;
            tt5.a.h("InviteEmailRouteActivity", "authorization()...success.");
            InviteEmailRouteActivity.C1(this.a);
            InviteEmailRouteActivity r7 = this.a;
            r7.getClass();
            tt5.a.h("InviteEmailRouteActivity", "saveLocal()...");
            com.ss.android.lark.storage.kv.repo.a r1 = ay4.b.d("scene_invite_email", 6);
            if (r1.b().length <= 100) goto L5;
            tt5.a.h("InviteEmailRouteActivity", "saveLocal()...exceed limit.");
            r1.clear();
        L5:
            BearUrl r8 = r7.d;
            if (r8 == null) goto L9;
            String r0 = r8.b;
            if (r0 == null) goto L9;
        L10:
            if (r8 == null) goto L12;
            String r9 = r8.o;
        L13:
            r1.putString(r0, r9);
            return;
        L12:
            r9 = null;
        L9:
            r0 = "";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ InviteEmailRouteActivity a;

        public d(InviteEmailRouteActivity r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("InviteEmailRouteActivity", "authorization()...failed, error = " + ((Throwable) r3));
            InviteEmailRouteActivity.C1(this.a);
        }
    }

    static {
    }

    public final void D1() {
        tt5.a.h("InviteEmailRouteActivity", "route()...");
        this.f.clear();
        b r0 = (b) this.g.getValue();
        r0.b.add(Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new com.bytedance.ee.bear.middleground.permission.email.a(r0)).subscribe(com.bytedance.ee.bear.middleground.permission.email.b.a, com.bytedance.ee.bear.middleground.permission.email.c.a));
        NetService.f r1 = new NetService.f("/space/api/user/email_invite_relation/create/");
        ((NetService.e) r1).c = 1;
        JSONObject r2 = new JSONObject();
        BearUrl r3 = this.d;
        if (r3 == null) goto L5;
        String r4 = r3.a;
    L6:
        r2.put("obj_type", e.g(r4));
        BearUrl r5 = this.d;
        if (r5 == null) goto L9;
        String r6 = r5.b;
    L10:
        r2.put(ResourceData.KEY_TOKEN, r6);
        BearUrl r7 = this.d;
        if (r7 == null) goto L13;
        String r8 = r7.o;
    L14:
        r2.put("invite_token", r8);
        ((NetService.e) r1).j = r2.toString();
        this.f.add(((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r1).subscribe(new c(this), new d(this)));
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(InviteEmailRouteActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(InviteEmailRouteActivity.class.getName()));
    L5:
        tt5.a.h("InviteEmailRouteActivity", "onDestroy()...");
        super.onDestroy();
        b r0 = (b) this.g.getValue();
        r0.b.clear();
        LinearLayout r1 = r0.a.get();
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        this.f.clear();
    }

    public InviteEmailRouteActivity() {
        this.f = new CompositeDisposable();
        this.g = LazyKt.lazy(new InviteEmailRouteActivity$loading$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public static final void C1(InviteEmailRouteActivity r3) {
        r3.getClass();
        tt5.a.h("InviteEmailRouteActivity", "openUrl()...");
        b r0 = (b) r3.g.getValue();
        r0.b.clear();
        LinearLayout r1 = r0.a.get();
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        String r2 = null;
        h r4 = (h) org.koin.java.a.c(h.class, null, null, 6);
        BearUrl r5 = r3.d;
        if (r5 == null) goto L8;
        r2 = r5.e;
    L8:
        r4.m9(r2, r3.e);
        r3.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r4) {
        tt5.a.h("InviteEmailRouteActivity", "onDoCreate()...");
        setContentView(2131558488);
        if (r4 != null) goto L21;
        Intent r5 = getIntent();
        RouteBean r0 = null;
        if (r5 == null) goto L7;
        BearUrl r6 = (BearUrl) r5.getParcelableExtra("key_bear_url");
    L8:
        this.d = r6;
        Intent r7 = getIntent();
        if (r7 == null) goto L11;
        r0 = (RouteBean) r7.getParcelableExtra("extra_intent_data");
    L11:
        this.e = r0;
        if (this.d == null) goto L16;
        if (r0 == null) goto L16;
        boolean r8 = false;
    L17:
        if (r8 == true) goto L21;
        D1();
        return;
    L16:
        r8 = true;
        goto L17
    L7:
        r6 = null;
    L21:
        tt5.a.h("InviteEmailRouteActivity", "onDoCreate()...parse bundle illegal");
        finish();
    }

    public final void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        D1();
    }
}
