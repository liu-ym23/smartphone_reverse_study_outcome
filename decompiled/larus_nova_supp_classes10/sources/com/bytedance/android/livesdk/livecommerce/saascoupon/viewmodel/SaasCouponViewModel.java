package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import bl2.g;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import el2.k;
import el2.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010E\u001a\u00020\u0002\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J#\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0005H\u0014J\u0006\u0010!\u001a\u00020\u0012J\u001a\u0010$\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\"R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R\u001d\u00104\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/saascoupon/viewmodel/SaasCouponViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/saascoupon/viewmodel/c;", "Landroid/app/Activity;", "activity", "", "requestLogin", "requestAuth", "", "userAgreeAuth", "requestLoginAndAuth", "doDouyinAuth", "postCouponPopup", "", "Lbl2/c;", "couponCard", "handleCouponPostSuccess", "openPromotionList", "", "eventTag", "buttonType", "postCouponStatus", "reportCouponLog", "ackCouponPopup", "logAuthDialogShow", "isOneClickParam", "logAuthDialogClick", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Landroid/content/Context;", "context", "toast", "showToast", "onCleared", "getStartAuthType", "Lkotlin/Function1;", "callback", "getCurrentAccountPhoneNumber", "Ldl2/e;", "registry", "Ldl2/e;", "isAuthOnStart", "Z", "isLoginOnStart", "authType", "Ljava/lang/String;", "currentAccountPhoneNumber", "isRequestLogin", "Lod/a;", "authReport$delegate", "Lkotlin/Lazy;", "getAuthReport", "()Lod/a;", "authReport", "Lio/reactivex/disposables/Disposable;", "mPostCouponDispose", "Lio/reactivex/disposables/Disposable;", "mAckCouponDisposable", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "mAutoDismissRunnable", "Ljava/lang/Runnable;", "Lbl2/g;", "requestParams", "Lbl2/g;", "Lel2/k;", "liveService", "Lel2/k;", "initialize", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/saascoupon/viewmodel/c;Lbl2/g;Lel2/k;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasCouponViewModel extends QStateViewModel<com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.c> {
    private final Lazy authReport$delegate;
    private String authType;
    private String currentAccountPhoneNumber;
    private boolean isAuthOnStart;
    private boolean isLoginOnStart;
    private boolean isRequestLogin;
    private final k liveService;
    private Disposable mAckCouponDisposable;
    private Runnable mAutoDismissRunnable;
    private Handler mHandler;
    private Disposable mPostCouponDispose;
    private final dl2.e registry;
    private final g requestParams;

    public static final class a implements Runnable {
        public final /* synthetic */ SaasCouponViewModel a;

        public a(SaasCouponViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            bl2.a r2 = (bl2.a) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements zk.b {
        public d() {
        }

        public final String entryName() {
            return "coupon_dialog";
        }

        public final String getCouponId() {
            return null;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SaasCouponViewModel a;
        public final /* synthetic */ Activity b;

        public e(SaasCouponViewModel r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            bl2.f r11 = (bl2.f) r10;
            SaasCouponViewModel.access$setRequestLogin$p(this.a, false);
            if (r11 != null) goto L5;
        L30:
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
            if (SaasCouponViewModel.access$isAuthOnStart$p(this.a) == false) goto L33;
            SaasCouponViewModel.access$showToast(this.a, this.b, "领券失败");
        L34:
            SaasCouponViewModel.reportCouponLog$default(this.a, "livesdk_coupon_result", null, "fail_coupon_get", 2, null);
            return;
        L33:
            SaasCouponViewModel.access$showToast(this.a, this.b, "授权完成，领券失败");
            goto L34
        L5:
            if (r11.c() != 0) goto L30;
            long r3 = r11.a();
            if (r3 != 1) goto L11;
            SaasCouponViewModel.access$handleCouponPostSuccess(this.a, this.b, r11.b());
            return;
        L11:
            if (r3 != 2) goto L14;
            SaasCouponViewModel.access$handleCouponPostSuccess(this.a, this.b, r11.b());
            return;
        L14:
            if (r3 != 3) goto L21;
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
            if (SaasCouponViewModel.access$isAuthOnStart$p(this.a) == false) goto L18;
            SaasCouponViewModel.access$showToast(this.a, this.b, "领券失败");
        L19:
            SaasCouponViewModel.reportCouponLog$default(this.a, "livesdk_coupon_result", null, "fail_coupon_get", 2, null);
            return;
        L18:
            SaasCouponViewModel.access$showToast(this.a, this.b, "授权完成，领券失败");
            goto L19
        L21:
            if (r3 != 4) goto L24;
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
            ECLiveHybridUtil.f("ECOM_FEED_COUPON_CARD_HIDDEN", new JSONObject());
            SaasCouponViewModel.access$showToast(this.a, this.b, "你已不是新人, 无法享受新人福利");
            SaasCouponViewModel.reportCouponLog$default(this.a, "livesdk_coupon_result", null, "fail_coupon_get", 2, null);
            return;
        L24:
            if (r3 != 5) goto L40;
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
            if (SaasCouponViewModel.access$isAuthOnStart$p(this.a) == false) goto L28;
            SaasCouponViewModel.access$showToast(this.a, this.b, "领券失败");
        L29:
            ECLiveHybridUtil.f("ECOM_FEED_COUPON_CARD_HIDDEN", new JSONObject());
            SaasCouponViewModel.reportCouponLog$default(this.a, "livesdk_coupon_result", null, "fail_coupon_get", 2, null);
            return;
        L28:
            SaasCouponViewModel.access$showToast(this.a, this.b, "授权完成，领券失败");
            goto L29
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ SaasCouponViewModel a;
        public final /* synthetic */ Activity b;

        public f(SaasCouponViewModel r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            SaasCouponViewModel.access$setRequestLogin$p(this.a, false);
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
            SaasCouponViewModel.access$showToast(this.a, this.b, "领券失败");
            SaasCouponViewModel.reportCouponLog$default(this.a, "livesdk_coupon_result", null, "fail_coupon_get", 2, null);
        }
    }

    private final od.a getAuthReport() {
        return (od.a) this.authReport$delegate.getValue();
    }

    private final void ackCouponPopup() {
        dl2.e r0 = this.registry;
        g r1 = this.requestParams;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "requestParams");
        FilterNullArrayList<si2.k> r2 = new FilterNullArrayList();
        Uri.Builder r3 = UriProtector.parse(si2.g.T).buildUpon();
        r3.appendQueryParameter("enter_from", r1.a);
        r3.appendQueryParameter("popup_key", r1.b);
        r3.appendQueryParameter("coupon_key", r1.c);
        r3.appendQueryParameter("room_id", r1.d);
        r3.appendQueryParameter("anchor_open_id", r1.e);
        r3.appendQueryParameter("is_inner", String.valueOf(r1.q));
        String r4 = r3.build().toString();
        l r5 = r0.a;
        if (r5 == null) goto L6;
        Observable r6 = r5.a(r4, r2, bl2.a.class, new dl2.a());
        if (r6 == null) goto L6;
    L7:
        this.mPostCouponDispose = r6.subscribeOn(Schedulers.io()).subscribe(b.a, c.a);
        return;
    L6:
        r6 = Observable.create(dl2.b.a);
        goto L7
    }

    private final void logAuthDialogShow() {
        if ((!Intrinsics.areEqual(this.authType, "login_auth")) == false) goto L6;
        getCurrentAccountPhoneNumber(new C03311(this));
        return;
    }

    public void onCleared() {
        super/*com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel*/.onCleared();
        Disposable r0 = this.mPostCouponDispose;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.mAckCouponDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Runnable r2 = this.mAutoDismissRunnable;
        if (r2 == null) goto L12;
        this.mHandler.removeCallbacks(r2);
        return;
    }

    public final String getStartAuthType() {
        return this.authType;
    }

    public static final /* synthetic */ void access$ackCouponPopup(SaasCouponViewModel r0) {
        r0.ackCouponPopup();
    }

    public static final /* synthetic */ od.a access$getAuthReport$p(SaasCouponViewModel r0) {
        return r0.getAuthReport();
    }

    public static final /* synthetic */ String access$getCurrentAccountPhoneNumber$p(SaasCouponViewModel r0) {
        return r0.currentAccountPhoneNumber;
    }

    public static final /* synthetic */ boolean access$isAuthOnStart$p(SaasCouponViewModel r0) {
        return r0.isAuthOnStart;
    }

    public static final /* synthetic */ boolean access$isRequestLogin$p(SaasCouponViewModel r0) {
        return r0.isRequestLogin;
    }

    public static final /* synthetic */ void access$logAuthDialogShow(SaasCouponViewModel r0) {
        r0.logAuthDialogShow();
    }

    private final void doDouyinAuth(Activity r4) {
        if (this.isRequestLogin == false) goto L5;
        return;
    L5:
        logAuthDialogClick("other_aweme_account", Boolean.FALSE);
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L9;
        r1.doDouyinAuth(r4, "coupon_popup", new C03281(this));
        return;
    }

    private final void openPromotionList(Activity r4) {
        this.liveService.c(r4, new d(), null);
    }

    private final void postCouponPopup(Activity r8) {
        g r0 = this.requestParams;
        if (r0.k == false) goto L12;
        this.isRequestLogin = false;
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(true));
        openPromotionList(r8);
        if ((!Intrinsics.areEqual(this.requestParams.b, "preview_benefit_coupon_popup")) == true) goto L7;
        return;
    L7:
        if (this.isAuthOnStart == false) goto L9;
        showToast(r8, "恭喜你，领券成功");
    L10:
        reportCouponLog$default(this, "livesdk_coupon_result", null, "success", 2, null);
        return;
    L9:
        showToast(r8, "授权完成，领券成功");
        goto L10
    L12:
        dl2.e r1 = this.registry;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "requestParams");
        FilterNullArrayList<si2.k> r2 = new FilterNullArrayList();
        Uri.Builder r3 = UriProtector.parse(si2.g.S).buildUpon();
        r3.appendQueryParameter("enter_from", r0.a);
        r3.appendQueryParameter("popup_key", r0.b);
        r3.appendQueryParameter("coupon_key", r0.c);
        r3.appendQueryParameter("room_id", r0.d);
        r3.appendQueryParameter("anchor_open_id", r0.e);
        r3.appendQueryParameter("reqid", r0.f);
        r3.appendQueryParameter("token", r0.g);
        r3.appendQueryParameter("cid", String.valueOf(r0.h));
        r3.appendQueryParameter("ad_id", String.valueOf(r0.i));
        r3.appendQueryParameter("prize_activity_id", r0.l);
        r3.appendQueryParameter("prize_id", r0.m);
        r3.appendQueryParameter("is_inner", String.valueOf(r0.q));
        String r4 = r3.build().toString();
        l r5 = r1.a;
        if (r5 == null) goto L16;
        Observable r6 = r5.a(r4, r2, bl2.f.class, new dl2.d());
        if (r6 == null) goto L16;
    L17:
        this.mPostCouponDispose = r6.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r8), new f(this, r8));
        return;
    L16:
        r6 = Observable.create(dl2.b.a);
        goto L17
    }

    private final void requestAuth(final Activity r3) {
        int r0 = ECSdk.a;
        final IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L6;
        r1.isPhoneNumberUsedInDouyin(new C03321(this, r3, r1));
        return;
    }

    private final void requestLogin(final Activity r6) {
        if (this.isRequestLogin == false) goto L5;
        return;
    L5:
        this.isRequestLogin = true;
        r r0 = r.a;
        if (r0.isLogin() == false) goto L8;
        postCouponPopup(r6);
        return;
    L8:
        logAuthDialogClick$default(this, "immediate_relevance", null, 2, null);
        if (r0.a() == 0) goto L11;
        getCurrentAccountPhoneNumber(new C03331(this, r6));
        return;
    L11:
        requestLoginAndAuth(r6, false);
    }

    public final void getCurrentAccountPhoneNumber(final Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        String r0 = this.currentAccountPhoneNumber;
        if (r0 != null) goto L5;
    L14:
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L17;
        r2.getCurrentAccountPhoneNumber(new C03293(this, r3));
        return;
    L17:
        Unit r4 = (Unit) r3.invoke("");
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        r3.invoke(r0);
        return;
    L7:
        r5 = false;
        goto L8
    }

    public static final /* synthetic */ void access$doDouyinAuth(SaasCouponViewModel r0, Activity r1) {
        r0.doDouyinAuth(r1);
    }

    public static final /* synthetic */ void access$postCouponPopup(SaasCouponViewModel r0, Activity r1) {
        r0.postCouponPopup(r1);
    }

    public static final /* synthetic */ void access$requestAuth(SaasCouponViewModel r0, Activity r1) {
        r0.requestAuth(r1);
    }

    public static final /* synthetic */ void access$requestLogin(SaasCouponViewModel r0, Activity r1) {
        r0.requestLogin(r1);
    }

    public static final /* synthetic */ void access$setAuthOnStart$p(SaasCouponViewModel r0, boolean r1) {
        r0.isAuthOnStart = r1;
    }

    public static final /* synthetic */ void access$setCurrentAccountPhoneNumber$p(SaasCouponViewModel r0, String r1) {
        r0.currentAccountPhoneNumber = r1;
    }

    public static final /* synthetic */ void access$setRequestLogin$p(SaasCouponViewModel r0, boolean r1) {
        r0.isRequestLogin = r1;
    }

    public static final /* synthetic */ void access$setState(SaasCouponViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private final void handleCouponPostSuccess(Activity r7, List<bl2.c> r8) {
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(true));
        if (r8 == null) goto L19;
        Iterator<bl2.c> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L19;
        String r0 = r9.next().c();
        if (r0 == null) goto L6;
        if (r0.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L6;
        g r3 = this.requestParams;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r3.n = r0;
        goto L6
    L12:
        r2 = false;
    L19:
        if (this.isAuthOnStart == false) goto L21;
        openPromotionList(r7);
        showToast(r7, "恭喜你，领券成功");
    L22:
        reportCouponLog$default(this, "livesdk_coupon_result", null, "success", 2, null);
        return;
    L21:
        openPromotionList(r7);
        showToast(r7, "授权完成，领券成功");
        goto L22
    }

    private final void logAuthDialogClick(final String r3, final Boolean r4) {
        if ((!Intrinsics.areEqual(this.authType, "login_auth")) == false) goto L6;
        getCurrentAccountPhoneNumber(new C03301(this, r4, r3));
        return;
    }

    private final void requestLoginAndAuth(final Activity r10, boolean r11) {
        if (r11 == true) goto L4;
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
    L4:
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L8;
        r1.loginUserAgreeAuth(r10, "", "", "coupon_popup", r11, new C03341(this, r10), new C03352(this, r10));
        return;
    }

    private final void showToast(Context r3, String r4) {
        i.a.e(r3, r4, false, false);
    }

    public SaasCouponViewModel(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.c r6, g r7, k r8) {
        Intrinsics.checkNotNullParameter(r6, "initialize");
        Intrinsics.checkNotNullParameter(r7, "requestParams");
        Intrinsics.checkNotNullParameter(r8, "liveService");
        super(r6);
        this.requestParams = r7;
        this.liveService = r8;
        this.registry = new dl2.e();
        r r9 = r.a;
        this.isAuthOnStart = r9.isLogin();
        boolean r10 = false;
        if (r9.a() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.isLoginOnStart = r11;
        if (r11 == true) goto L9;
        String r12 = "nologin";
    L13:
        this.authType = r12;
        this.authReport$delegate = LazyKt.lazy(SaasCouponViewModel$authReport$2.INSTANCE);
        this.mHandler = new Handler(Looper.getMainLooper());
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.h.class), Dispatchers.getMain(), new AnonymousClass2(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.c.class), Dispatchers.getMain(), new AnonymousClass3(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.C0127a.class), new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.f.class), Dispatchers.getMain(), new AnonymousClass5(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.e.class), Dispatchers.getMain(), new AnonymousClass6(this));
        Long r13 = Long.valueOf(((com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.c) getState()).a.c());
        if (r13.longValue() <= 0) goto L16;
        r10 = true;
    L16:
        if (r10 == true) goto L19;
        r13 = null;
    L19:
        if (r13 == null) goto L22;
        long r14 = r13.longValue();
        a r15 = new a(this);
        this.mAutoDismissRunnable = r15;
        this.mHandler.postDelayed(r15, r14 * 1000);
        return;
    L22:
        return;
    L9:
        if (this.isAuthOnStart == false) goto L11;
        r12 = "login_auth";
        goto L13
    L11:
        r12 = "login_no_auth";
        goto L13
    L5:
        r11 = false;
        goto L6
    }

    public static final /* synthetic */ void access$handleCouponPostSuccess(SaasCouponViewModel r0, Activity r1, List r2) {
        r0.handleCouponPostSuccess(r1, r2);
    }

    public static final /* synthetic */ void access$requestLoginAndAuth(SaasCouponViewModel r0, Activity r1, boolean r2) {
        r0.requestLoginAndAuth(r1, r2);
    }

    public static final /* synthetic */ void access$showToast(SaasCouponViewModel r0, Context r1, String r2) {
        r0.showToast(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.bytedance.android.livesdk.livecommerce.event.ECEventV3, com.bytedance.android.livesdk.livecommerce.event.k] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    private final void reportCouponLog(String r17, String r18, String r19) {
        List<bl2.c> r4 = ((com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.c) getState()).a.a();
        Integer r5 = null;
        boolean r6 = false;
        if (r4 == null) goto L5;
        bl2.c r7 = (bl2.c) CollectionsKt.getOrNull(r4, 0);
    L6:
        if (r7 == null) goto L8;
        r5 = Integer.valueOf(r7.b());
    L8:
        if (r7 == null) goto L10;
        ?? r8 = r7.h();
    L11:
        el2.i r9 = zk2.a.a;
        String r10 = this.authType;
        g r11 = this.requestParams;
        String r12 = r11.c;
        String r13 = r11.n;
        String r14 = r11.o;
        String r15 = r11.b;
        Intrinsics.checkNotNullParameter(r17, "eventTag");
        Intrinsics.checkNotNullParameter(r10, "authType");
        Intrinsics.checkNotNullParameter(r18, "buttonType");
        Intrinsics.checkNotNullParameter(r19, "postCouponStatus");
        Intrinsics.checkNotNullParameter(r12, "couponKey");
        Intrinsics.checkNotNullParameter(r13, "couponID");
        Intrinsics.checkNotNullParameter(r14, "couponMetaID");
        Intrinsics.checkNotNullParameter(r15, "popupKey");
        el2.i r16 = zk2.a.a;
        if (r16 == null) goto L44;
        ?? r110 = r16.a(r17);
        if (r110 == 0) goto L45;
        r110.c("kol_user_tag", r12);
        if (al2.a.b.length() <= 0) goto L19;
        r6 = true;
    L19:
        if (r6 == false) goto L21;
        String r20 = al2.a.b;
    L24:
        r110.c("page_name", "live");
        r110.c("coupon_id", r13);
        r110.c("coupon_meta_id", r14);
        if (r15.hashCode() == (-1942716910)) goto L28;
    L30:
        String r21 = "live_popup";
    L31:
        r110.c("source", r21);
        r110.c("enter_from", r20);
        r110.c("previous_page", al2.a.c);
        r110.a(al2.a.d);
        r110.b("is_coupon_get_pre_live", al2.a.e);
        if ((!Intrinsics.areEqual(r17, "livesdk_coupon_banner_show")) == false) goto L35;
        r110.c("user_auth_type", r10);
    L35:
        if (Intrinsics.areEqual(r17, "livesdk_coupon_window_click") == false) goto L38;
        r110.c("button_type", r18);
    L38:
        if (Intrinsics.areEqual(r17, "livesdk_coupon_result") == false) goto L40;
        r110.c("coupon_result", r19);
    L40:
        if (r5 == null) goto L42;
        r110.b("coupon_discount_type", r5.intValue());
    L42:
        r110.c("window_type", "one");
        r110.c("card_type", al2.a.a);
        r110.c("organize_type", r12);
        r110.c("module_label", "live");
        r110.b("is_coupon_get_pre_show", r8);
        r110.k();
        return;
    L28:
        if (r15.equals("preview_benefit_coupon_popup") == false) goto L30;
        r21 = "prelive_popup";
        goto L31
    L21:
        r20 = r110.i("enter_from");
        if (r20 != null) goto L24;
        r20 = "";
        goto L24
    L45:
        return;
    L44:
        return;
    L10:
        r8 = 0;
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    public static final /* synthetic */ void access$reportCouponLog(SaasCouponViewModel r0, String r1, String r2, String r3) {
        r0.reportCouponLog(r1, r2, r3);
    }

    public static /* synthetic */ void logAuthDialogClick$default(SaasCouponViewModel r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.logAuthDialogClick(r1, r2);
    }

    public static /* synthetic */ void requestLoginAndAuth$default(SaasCouponViewModel r0, Activity r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.requestLoginAndAuth(r1, r2);
    }

    public static /* synthetic */ void reportCouponLog$default(SaasCouponViewModel r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = "";
    L8:
        r1.reportCouponLog(r2, r3, r4);
    }
}
