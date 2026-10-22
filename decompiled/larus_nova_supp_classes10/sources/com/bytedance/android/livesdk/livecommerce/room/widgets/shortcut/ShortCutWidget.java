package com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleKt;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.event.y0;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.api.e;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.y;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.f;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ql2.d;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B'\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0003J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001fH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/shortcut/ShortCutWidget;", "Lak2/b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/y;", "", "goShowLiveFlashFragment", "Lio/reactivex/disposables/Disposable;", "disposeOnClear", "", "canShow", "", "callFrom", "handleShortCutOpen", "onViewAttached", "reportAnchorFlashSaleEntranceShow", "isFlashOpen", "hasFlashAuth", "isInKtv", "isInDrawGuessGame", "canShowFlashEntrance", "handleGuide", "dismissPopup", "Landroid/view/View;", "getView", "onLoad", "onUnload", "Lsg2/a;", "message", "onReceive", "Lwd/c;", "viewContainerLayoutParam", "onViewWillAttach", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/Rect;", "Landroidx/fragment/app/DialogFragment;", "fragment", "Landroidx/fragment/app/DialogFragment;", "", "lastClickTime", "J", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "Lql2/d;", "popup", "Lql2/d;", "realView", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "flashController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/bytedance/android/livesdk/livecommerce/room/api/e;", "iLiveRoomViewHandler", "Lcom/bytedance/android/livesdk/livecommerce/room/api/e;", "Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;", "ecContext", "Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "roomContextController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/livecommerce/room/api/e;Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortCutWidget extends ak2.b implements y {
    public static final a Companion = null;
    private static final String EC_CREATE_FLASH_GUIDE = "ec_create_flash_guide";
    public static final String TAG = "ShortCutWidget";
    private final Context context;
    private CompositeDisposable disposables;
    private final ECContext ecContext;
    private final FlashController flashController;
    private DialogFragment fragment;
    private final e iLiveRoomViewHandler;
    private long lastClickTime;
    private d<?> popup;
    private View realView;
    private final RoomContextController roomContextController;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T1, T2, T3, T4, R> implements Function4 {
        public final /* synthetic */ ShortCutWidget a;

        public b(ShortCutWidget r1) {
            this.a = r1;
        }

        public final Object apply(Object r2, Object r3, Object r4, Object r5) {
            Boolean r6 = (Boolean) r2;
            Boolean r7 = (Boolean) r3;
            Boolean r8 = (Boolean) r4;
            Boolean r9 = (Boolean) r5;
            Intrinsics.checkNotNullParameter(r6, "isFlashOpen");
            Intrinsics.checkNotNullParameter(r7, "hasFlashAuth");
            Intrinsics.checkNotNullParameter(r8, "isInKtv");
            Intrinsics.checkNotNullParameter(r9, "isInDrawGuessGame");
            return Boolean.valueOf(ShortCutWidget.access$canShowFlashEntrance(this.a, r6.booleanValue(), r7.booleanValue(), r8.booleanValue(), r9.booleanValue()));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ShortCutWidget a;

        public c(ShortCutWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            ShortCutWidget.access$handleShortCutOpen(this.a, r4, "observable");
        }
    }

    static {
        Companion = new a();
    }

    private final void dismissPopup() {
        d<?> r0 = this.popup;
        if (r0 == null) goto L17;
        PopupWindow r1 = r0.a;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L18;
        PopupWindow r3 = r0.a;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.isShowing() == false) goto L20;
        PopupWindow r4 = r0.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
        return;
    L20:
        return;
    L18:
        return;
    L7:
        if (r1.isShowing() == false) goto L9;
        r2 = true;
        goto L10
    }

    private final void goShowLiveFlashFragment() {
        int r0 = lh.b.a;
        lh.b.c(ProcessDomain.LIVE, "开播页", "打开闪购列表");
        long r1 = SystemClock.elapsedRealtime();
        if ((System.currentTimeMillis() - ((long) 2500)) < this.lastClickTime) goto L6;
        this.lastClickTime = System.currentTimeMillis();
        FlashController r2 = this.flashController;
        Context r3 = this.context;
        Bundle r4 = new Bundle();
        r4.putString("enter_from", "sg_float");
        Unit r5 = Unit.INSTANCE;
        r2.J(r3, r4, Long.valueOf(r1), new AnonymousClass2(this));
        return;
    }

    private final void handleGuide() {
        dm.a.a(TAG).a("handleGuide");
        q r1 = q.a;
        if (r1.getBoolean(EC_CREATE_FLASH_GUIDE, false) == true) goto L13;
        dm.a.a(TAG).a("handleGuide show success");
        r1.c(EC_CREATE_FLASH_GUIDE, true);
        View r2 = th.a.d(this.context, 2131560658, null, 4);
        ql2.e r3 = new ql2.e(this.context);
        r3.c = r2;
        r3.h = true;
        r3.a();
        this.popup = r3;
        View r4 = this.realView;
        if (r4 == null) goto L12;
        r3.e(r4, 2, 1, w0.a(40.0f), w0.a(5.0f));
        FragmentActivity r0 = this.context;
        if (r0 == null) goto L10;
        f.a(5000, LifecycleKt.getCoroutineScope(r0.getLifecycle()), new ShortCutWidget$handleGuide$$inlined$let$lambda$1(this));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L12:
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void onViewAttached() {
        dm.a.a(TAG).a("onViewAttached");
        handleGuide();
        reportAnchorFlashSaleEntranceShow();
    }

    private final void reportAnchorFlashSaleEntranceShow() {
        LiveRoomParams r0 = this.roomContextController.l();
        if (r0 == null) goto L6;
        v r1 = new v("livesdk_show_anchor_flash_sale_entrance", r0);
        r1.c("page_name", "live_stream");
        r1.c("entrance_name", "flash_buy");
        r1.i(null);
        return;
    }

    public View getView() {
        View r0 = this.realView;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ak2.b
    public void onLoad() {
        super.onLoad();
        this.realView = th.a.d(this.context, 2131560657, null, 4);
        ControllerExtensionsKt.c(this.roomContextController, (String) this.ecContext.getRoomId().getValue()).A().p("LiveCommonMessage", this);
        bg4.b.b(Observable.combineLatest(this.ecContext.isFlashOpen().a(), this.ecContext.getHasFlashAuth().a(), this.ecContext.isInKtv().a(), this.ecContext.isInDrawGuessGame().a(), new b(this))).subscribe(new c(this));
        View r0 = this.realView;
        if (r0 == null) goto L5;
        com.bytedance.android.ec.core.widget.f.c(r0, null, null, new AnonymousClass3(this), 3);
    L5:
        handleShortCutOpen(canShowFlashEntrance(((Boolean) this.ecContext.isFlashOpen().getValue()).booleanValue(), ((Boolean) this.ecContext.getHasFlashAuth().getValue()).booleanValue(), ((Boolean) this.ecContext.isInKtv().getValue()).booleanValue(), ((Boolean) this.ecContext.isInDrawGuessGame().getValue()).booleanValue()), "onLoad");
    }

    @Override // ak2.b
    public void onUnload() {
        super.onUnload();
        this.disposables.clear();
        DialogFragment r0 = this.fragment;
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_room_widgets_shortcut_ShortCutWidget_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(r0);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_room_widgets_shortcut_ShortCutWidget_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(DialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ void access$dismissPopup(ShortCutWidget r0) {
        r0.dismissPopup();
    }

    public static final /* synthetic */ DialogFragment access$getFragment$p(ShortCutWidget r0) {
        return r0.fragment;
    }

    public static final /* synthetic */ void access$goShowLiveFlashFragment(ShortCutWidget r0) {
        r0.goShowLiveFlashFragment();
    }

    private final Disposable disposeOnClear(Disposable r2) {
        this.disposables.add(r2);
        return r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.y
    public void onReceive(sg2.a r6) {
        if ((r6 instanceof si2.v) == false) goto L12;
        int r7 = ((si2.v) r6).msgType;
        if (r7 != 1) goto L7;
        this.iLiveRoomViewHandler.O(this);
        ECLiveEntranceMonitor.trace$default("message show flash", TAG, false, 4, null);
        return;
    L7:
        if (r7 != 2) goto L14;
        this.iLiveRoomViewHandler.K(this);
        dismissPopup();
        ECLiveEntranceMonitor.trace$default("message hide flash", TAG, false, 4, null);
        return;
    L14:
        return;
    }

    @Override // ak2.b
    public void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        super.onViewAttached(r2);
        onViewAttached();
    }

    @Override // ak2.b
    public void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    @Override // ak2.b
    public void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        super.onViewAttached(r2);
        onViewAttached();
    }

    @Override // ak2.b
    public void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    public static final /* synthetic */ void access$setFragment$p(ShortCutWidget r0, DialogFragment r1) {
        r0.fragment = r1;
    }

    private final void handleShortCutOpen(boolean r5, String r6) {
        ECLiveEntranceMonitor.trace$default("handleShortCutOpen canShow=" + r5 + " callFrom=" + r6 + " open=" + ((Boolean) this.ecContext.isFlashOpen().getValue()).booleanValue() + " auth=" + ((Boolean) this.ecContext.getHasFlashAuth().getValue()).booleanValue() + " ktv=" + ((Boolean) this.ecContext.isInKtv().getValue()).booleanValue() + " draw=" + ((Boolean) this.ecContext.isInDrawGuessGame().getValue()).booleanValue(), TAG, false, 4, null);
        if (r5 == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.event.w0 r7 = new com.bytedance.android.livesdk.livecommerce.event.w0();
        r7.f("biz_name", "展现闪购入口");
        r7.k();
        this.iLiveRoomViewHandler.O(this);
        return;
    L5:
        this.iLiveRoomViewHandler.K(this);
    }

    public static final /* synthetic */ void access$handleShortCutOpen(ShortCutWidget r0, boolean r1, String r2) {
        r0.handleShortCutOpen(r1, r2);
    }

    public ShortCutWidget(Context r2, e r3, ECContext r4, RoomContextController r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r4, "ecContext");
        Intrinsics.checkNotNullParameter(r5, "roomContextController");
        this.context = r2;
        this.iLiveRoomViewHandler = r3;
        this.ecContext = r4;
        this.roomContextController = r5;
        this.disposables = new CompositeDisposable();
        this.flashController = ControllerExtensionsKt.c(r5, (String) r4.getRoomId().getValue()).A().p;
    }

    private final boolean canShowFlashEntrance(boolean r2, boolean r3, boolean r4, boolean r5) {
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        if (r4 == true) goto L7;
        if (r5 == true) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L16;
        if (r2 == false) goto L16;
        if (r3 == false) goto L16;
        y0 r7 = new y0();
        r7.f("anchor_id", (String) this.ecContext.getAnchorId().getValue());
        if (r4 == false) goto L14;
        String r8 = "KTV";
    L15:
        r7.f("replace_reason", r8);
        r7.k();
        goto L16
    L14:
        r8 = "DrawGuessGame";
    L16:
        return r6;
    L7:
        r6 = false;
        goto L8
    }

    public static final /* synthetic */ boolean access$canShowFlashEntrance(ShortCutWidget r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        return r0.canShowFlashEntrance(r1, r2, r3, r4);
    }
}
