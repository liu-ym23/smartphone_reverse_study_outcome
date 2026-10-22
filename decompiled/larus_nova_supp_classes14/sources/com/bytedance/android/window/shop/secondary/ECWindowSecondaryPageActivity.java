package com.bytedance.android.window.shop.secondary;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.t;
import com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.api.WindowAuthorRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowAuthorInfoResponseDTO;
import com.bytedance.android.window.shop.secondary.module.ECWindowSecondaryCategoryModule;
import com.bytedance.android.window.shop.secondary.module.ECWindowSecondaryRootModule;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fo.b;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/secondary/ECWindowSecondaryPageActivity;", "Lcom/bytedance/android/ec/window/base/common/activity/ECWindowBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSecondaryPageActivity extends ECWindowBaseActivity implements QViewModelOwner {
    public static final /* synthetic */ int o = 0;
    public ImmersionBar l;
    public final Lazy m;
    public final com.bytedance.commerce.base.viewmodel.a n;

    public static final class a {
    }

    static {
    }

    public ECWindowSecondaryPageActivity() {
        super(0);
        this.m = LazyKt.lazy(ECWindowSecondaryPageActivity$uiManager$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ECWindowSecondaryPageActivity$viewModel$2(this);
        this.n = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(ECWindowViewModel.class), new ECWindowSecondaryPageActivity$$special$$inlined$viewModels$1(this), r0);
    }

    public final ECWindowViewModel A1() {
        return (ECWindowViewModel) this.n.getValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECWindowSecondaryPageActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECWindowSecondaryPageActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.y1();
        if (this.l != null) goto L5;
        this.l = ImmersionBar.with(this);
    L5:
        ImmersionBar r0 = this.l;
        if (r0 == null) goto L11;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L12;
        r1.init();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(2130772245, 2130772253);
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r10);
        t.b(this, A1().getImageCallerContext());
        Intent r11 = getIntent();
        if (r11 == null) goto L13;
        Serializable r12 = r11.getSerializableExtra("shop_param");
    L15:
        if ((r12 instanceof ECWindowParam) == true) goto L17;
        r12 = null;
    L17:
        ECWindowParam r13 = (ECWindowParam) r12;
        if (r13 == null) goto L89;
        A1().init(r13, getIntent().getData(), xn.c.d(this));
        A1().getSecondaryPageParams().b = getIntent().getData();
        A1().getSecondaryPageParams().c = r13.isFromWindowInner();
        com.bytedance.android.window.shop.home.c r14 = A1().getSecondaryPageParams();
        Integer r1 = A1().getShopParam().getTargetTabType();
        if (r1 == null) goto L22;
        int r2 = r1.intValue();
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r3 = com.bytedance.android.window.shop.c.b;
        com.bytedance.android.window.shop.c r4 = com.bytedance.android.window.shop.c.a.a(r2);
    L23:
        r14.a = r4;
        if (Intrinsics.areEqual(A1().getSecondaryPageParams().a, com.bytedance.android.window.shop.c.g) == false) goto L26;
        A1().appendEventParams(new Pair[]{TuplesKt.to("tab_name", "classification")});
    L26:
        ECWindowViewModel r15 = A1();
        Pair[] r5 = new Pair[4];
        Integer r6 = A1().getShopParam().getTargetTabType();
        if (r6 == null) goto L29;
        String r7 = String.valueOf(r6.intValue());
    L30:
        r5[0] = TuplesKt.to("page_type", r7);
        if (A1().getSecondaryPageParams().c == false) goto L33;
        String r8 = "0";
    L34:
        r5[1] = TuplesKt.to("is_show_window_icon", r8);
        String r9 = "102";
        if (A1().getSecondaryPageParams().c == false) goto L37;
        String r16 = CommentServiceId.HOT_SPOT;
    L38:
        r5[2] = TuplesKt.to("page_from", r16);
        Integer r17 = A1().getShopParam().getTargetTabType();
        if (r17 != null) goto L42;
    L44:
        r9 = "103";
    L45:
        r5[3] = TuplesKt.to("icon_page", r9);
        r15.appendEventParams(r5);
        Integer r18 = A1().getShopParam().getTargetTabType();
        if (r18 != null) goto L49;
    L51:
        if (r18 != null) goto L54;
    L56:
        if (r18 != null) goto L59;
    L61:
        String r19 = "a1.b692466";
    L62:
        b r20 = A1().getSecondaryPageParams().d;
        r20.b(wn.a.b, r19);
        if (r19.hashCode() == 1073167850) goto L66;
    L68:
        BtmSDK r21 = BtmSDK.INSTANCE;
        Uri r22 = getIntent().getData();
        if (r22 == null) goto L71;
        String r23 = UriProtector.getQueryParameter(r22, "source_btm_token");
    L72:
        r21.registerBtmPageOnCreate(this, r19, r23);
        PageFinder r110 = PageFinder.via(this);
        BcmParams.a r24 = BcmParams.Companion;
        Map r25 = MapsKt.mapOf(new Pair[]{TuplesKt.to("author_id", A1().getShopParam().getAuthorId()), TuplesKt.to("sec_author_id", A1().getShopParam().getSecAuthorId())});
        r24.getClass();
        r21.setBcmPageParams(r110, BcmParams.a.c(r25), true);
        com.bytedance.android.window.shop.home.c r111 = A1().getSecondaryPageParams();
        r111.g.getLoadStatus().setValue(WindowLoadStatus.Initialize);
        ShopRepository r26 = ShopRepository.a;
        WindowAuthorRequestParam r27 = new WindowAuthorRequestParam();
        r27.setSecAuthorId(r111.g.getShopParam().getSecAuthorId());
        Integer r28 = r111.g.getShopParam().getTargetTabType();
        if (r28 == null) goto L75;
        int r29 = r28.intValue();
    L76:
        r27.setTabType(r29);
        r27.setPassThroughApi(String.valueOf(r111.g.getShopParam().getPassThroughParams().get("pass_through_api")));
        Unit r30 = Unit.INSTANCE;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "reqParam");
        ReplaySubject r31 = ReplaySubject.a();
        int r32 = kq3.a.a;
        Intrinsics.checkNotNullParameter(r27, "reqParam");
        ECWindowApi.a.getClass();
        ECWindowApi r33 = ECWindowApi.a.a;
        if (r33 == null) goto L80;
        Observable<WindowAuthorInfoResponseDTO> r34 = r33.getAuthorInfo(r27.getSecAuthorId(), r27.getTabType(), r27.getPassThroughApi());
        if (r34 == null) goto L80;
    L81:
        r34.subscribeOn(Schedulers.io()).subscribe(r31);
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r31).subscribe(new com.bytedance.android.window.shop.home.a(r111), new com.bytedance.android.window.shop.home.b(r111)), r111.g);
        r111.g.loadTabInfo(true);
        View r112 = com.bytedance.android.ec.opt.asyncInflate.c.a(z1(), 2131560377, null, 6);
        Integer r35 = A1().getShopParam().getTargetTabType();
        if (r35 != null) goto L85;
    L87:
        QUIModule r36 = new ECWindowSecondaryRootModule(r112);
    L88:
        d.a((QUIManager) this.m.getValue(), r36, this, null);
        setContentView(((QUIManager) this.m.getValue()).p());
        ((QUIManager) this.m.getValue()).c(r36.getClass(), null);
        goto L89
    L85:
        if (r35.intValue() != 500) goto L87;
        r36 = new ECWindowSecondaryCategoryModule(r112);
    L80:
        r34 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L81
    L75:
        r29 = 100;
        goto L76
    L71:
        r23 = null;
        goto L72
    L66:
        if (r19.equals("a1.b983703") == false) goto L68;
        r20.b(wn.a.c, "a1.b983703.c247086");
        goto L68
    L59:
        if (r18.intValue() != 500) goto L61;
        r19 = "a1.b983703";
        goto L62
    L54:
        if (r18.intValue() != 300) goto L56;
    L49:
        if (r18.intValue() != 200) goto L51;
        r19 = "a1.b309667";
        goto L62
    L42:
        if (r17.intValue() != 200) goto L44;
    L37:
        r16 = "102";
        goto L38
    L33:
        r8 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L34
    L29:
        r7 = null;
        goto L30
    L22:
        r4 = null;
    L89:
        A1().getShopParam().setBtmPageId(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        return;
    L13:
        r12 = null;
        goto L15
    }
}
