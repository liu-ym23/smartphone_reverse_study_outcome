package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.sdk.plugin.c;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.WebpAnimatedWidget;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.n;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB'\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u000201\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J1\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0016R$\u0010&\u001a\u0004\u0018\u00010\b8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R*\u0010!\u001a\u00020 2\u0006\u0010:\u001a\u00020 8\u0014@VX\u0094\u000e¢\u0006\u0012\n\u0004\b!\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00103R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/shoppingcart/ShoppingCart;", "Lak2/a;", "", "onViewAttachedInner", "", "staticIcon", "", "customStaticIcon", "Landroid/view/View;", "createShoppingCartView", "", "feature", "configAnimation", "", "isD3Room", "roomCart", "liveMode", "", "createImageModel", "(ZLjava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "getTargetButtonName", "getButtonViewInMore", "onLoad", "onUnload", "getView", "getViewSafe", "hideNumber", "Lwd/c;", "viewContainerLayoutParam", "onViewAttached", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/Rect;", "onViewWillDetach", "Landroid/content/Context;", "context", "updateContext", "", "callbackTime", "onTriggerAnimation", "realView", "Landroid/view/View;", "getRealView", "()Landroid/view/View;", "setRealView", "(Landroid/view/View;)V", "hideShoppingNumber", "Z", "Lyk2/a;", "animatedController", "Lyk2/a;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/EntryController;", "entryController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/EntryController;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/shoppingcart/webp/e;", "defaultAnimateImageAdapter$delegate", "Lkotlin/Lazy;", "getDefaultAnimateImageAdapter", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/shoppingcart/webp/e;", "defaultAnimateImageAdapter", "<set-?>", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;", "ecContext", "Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;", "entryControllerFromOutside", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "contextControllerFromOutside", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/EntryController;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingCart extends ak2.a {
    public static final a Companion = null;
    private static final Lazy isEnableCartAnimControl$delegate = null;
    private yk2.a animatedController;
    private Context context;
    private final RoomContextController contextControllerFromOutside;
    private final Lazy defaultAnimateImageAdapter$delegate;
    private final ECContext ecContext;
    private final EntryController entryController;
    private final EntryController entryControllerFromOutside;
    private boolean hideShoppingNumber;
    private View realView;

    public static final class a {
        public a() {
        }
    }

    private final e getDefaultAnimateImageAdapter() {
        return (e) this.defaultAnimateImageAdapter$delegate.getValue();
    }

    public String getTargetButtonName() {
        return "COMMERCE";
    }

    public final void hideNumber() {
        this.hideShoppingNumber = true;
        View r0 = getRealView();
        if ((r0 instanceof WebpAnimatedWidget) == true) goto L5;
        r0 = null;
    L5:
        WebpAnimatedWidget r1 = (WebpAnimatedWidget) r0;
        if (r1 == null) goto L9;
        r1.f(false, 0);
        return;
    }

    static {
        Companion = new a();
        isEnableCartAnimControl$delegate = LazyKt.lazy(ShoppingCart$Companion$isEnableCartAnimControl$2.INSTANCE);
    }

    private final void onViewAttachedInner() {
        yk2.a r0 = this.animatedController;
        if (r0 == null) goto L5;
        r0.start();
    L5:
        EntryController r1 = this.entryController;
        View r2 = getView();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "view");
        PageFinder r3 = PageFinder.via(r2);
        BcmParams.a r4 = BcmParams.Companion;
        JSONObject r5 = new JSONObject();
        r5.put("room_id", r1.B());
        r5.put("request_id", l0.j("request_id", r1.A().m));
        r5.put("enter_from_merge", l0.j("enter_from_merge", r1.A().m));
        Unit r6 = Unit.INSTANCE;
        r4.getClass();
        b.e(r3, "live_guide_mall", BcmParams.a.b(r5));
        PageFinder r7 = PageFinder.via(r2);
        JSONObject r8 = new JSONObject();
        r8.put("room_id", r1.B());
        r8.put("author_id", r1.y());
        b.e(r7, "ecom_sec", BcmParams.a.b(r8));
        String r9 = null;
        if (r1.w() == false) goto L8;
        PageFinder r10 = PageFinder.via(r2);
        ECEventUtilsV2 r11 = ECEventUtilsV2.b;
        Map r12 = r1.C().m;
        r11.getClass();
        b.e(r10, "live_guide_info", BcmParams.a.b(ECEventUtilsV2.d(r12)));
    L9:
        PageFinder r13 = PageFinder.via(r2);
        BcmParams r14 = new BcmParams();
        r14.put("room_id", r1.B());
        LiveRoomParams r15 = r1.l();
        if (r15 == null) goto L12;
        r9 = r15.getRequestId();
    L12:
        r14.put("request_id", r9);
        b.d(r13, r14, false);
        ECLiveEntranceMonitor.trace("onViewAttached", "ShoppingCart", false);
        return;
    L8:
        dm.a.a("EntryController").b("shoppingCartViewAttached: isRoomStateAttached: " + r1.w() + " generate live_guide_info error", null);
        goto L9
    }

    @Override // ak2.a
    public View getButtonViewInMore() {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(2131234236);
        return r0;
    }

    @Override // ak2.a
    public void onLoad() {
        boolean r0 = ((Bundle) this.ecContext.getExtras().getValue()).getBoolean("EXTRA_IS_D_ROOM", false);
        Companion.getClass();
        if (r0 == false) goto L6;
        int r1 = 2131234563;
    L9:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a r2 = (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a) this.ecContext.getCartConfig().getValue();
        View r3 = null;
        if (r2 == null) goto L14;
        de.a r4 = r2.a;
        if (r4 == null) goto L14;
        String r5 = r4.staticIconUrl;
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        View r6 = createShoppingCartView(r1, r5);
        setRealView(r6);
        EntryController r7 = this.entryController;
        ShoppingCart r8 = r7.s;
        if (r8 == null) goto L20;
        r3 = r8.getViewSafe();
    L20:
        if (r3 == null) goto L22;
        r7.A().v.H("shopping_cart", r3);
    L22:
        this.entryController.d0(r6.getContext(), r6);
        configAnimation(r6);
        com.bytedance.android.livesdk.livecommerce.utils.a.a(r6, th.a.g(r6.getContext(), 2131896685));
        boolean r9 = ECServiceManager.a;
        ((c) ECServiceManager.c(c.class)).a();
        return;
    L14:
        r5 = null;
        goto L15
    L6:
        if (EComABUtils.isToolbarIconOpt() == false) goto L8;
        r1 = 2131243760;
        goto L9
    L8:
        r1 = 2131234565;
        goto L9
    }

    @Override // ak2.a
    public void onUnload() {
        yk2.a r0 = this.animatedController;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        Object r1 = null;
        this.animatedController = null;
        View r2 = getRealView();
        if ((r2 instanceof yk2.c) == false) goto L9;
        r1 = r2;
    L9:
        yk2.c r3 = (yk2.c) r1;
        if (r3 == null) goto L13;
        r3.unload();
        return;
    }

    @Override // ak2.a
    public void onViewWillDetach() {
        yk2.a r0 = this.animatedController;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public View getView() {
        View r0 = getRealView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final View getViewSafe() {
        return getRealView();
    }

    public static final /* synthetic */ Lazy access$isEnableCartAnimControl$cp() {
        return isEnableCartAnimControl$delegate;
    }

    @Override // ak2.a
    public Context getContext() {
        return this.context;
    }

    @Override // ak2.a
    public View getRealView() {
        return this.realView;
    }

    public static final /* synthetic */ ECContext access$getEcContext$p(ShoppingCart r0) {
        return r0.ecContext;
    }

    private final void configAnimation(Object r2) {
        if ((r2 instanceof yk2.b) == true) goto L5;
        r2 = null;
    L5:
        yk2.b r3 = (yk2.b) r2;
        if (r3 != null) goto L8;
        return;
    L8:
        this.animatedController = r3.getController();
    }

    @Override // ak2.a
    public boolean onTriggerAnimation(long r8) {
        long r0 = 10;
        if ((r8 % r0) == 0) goto L5;
        return false;
    L5:
        if (r8 < r0) goto L19;
        Companion.getClass();
        if (((Boolean) access$isEnableCartAnimControl$cp().getValue()).booleanValue() == false) goto L20;
        KeyEvent.Callback r9 = getRealView();
        if ((r9 instanceof yk2.b) == true) goto L11;
        r9 = null;
    L11:
        yk2.b r10 = (yk2.b) r9;
        if (r10 == null) goto L18;
        r10.playAnimation();
        return true;
    L18:
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    public void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        onViewAttachedInner();
    }

    public void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    @Override // ak2.a
    public void setRealView(View r1) {
        this.realView = r1;
    }

    public final void updateContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        setContext(r2);
    }

    public void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        onViewAttachedInner();
    }

    private final View createShoppingCartView(int r8, String r9) {
        int r2 = 0;
        ECLiveEntranceMonitor.trace("createShoppingCartView", "ShoppingCart", false);
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        RoomContextController r0 = this.contextControllerFromOutside;
    L9:
        com.bytedance.android.ec.adapter.api.state.a r1 = r0.L();
        WebpAnimatedWidget r3 = new WebpAnimatedWidget(getContext(), this.contextControllerFromOutside);
        if (r0.s() == false) goto L12;
    L28:
        Companion.getClass();
        if (((Boolean) access$isEnableCartAnimControl$cp().getValue()).booleanValue() == true) goto L34;
        if (r1 == null) goto L34;
        if (r1.c == true) goto L34;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.b r4 = new com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.b(r3);
        r4.f.setController(r4);
        r3.setController(r4);
    L34:
        Lazy r5 = ECSettingKeys.a;
        int r6 = p.a;
        Object r7 = 0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L39
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L39
        Object r12 = jj4.a.a("ec_live_cart_show_red_dot", Integer.class, r7, false);     // Catch: Throwable -> L39
        if (r12 != null) goto L46;
        Intrinsics.throwNpe();     // Catch: Throwable -> L39
    L46:
        if (((Number) r12).intValue() != 1) goto L60;
        if (r1 == null) goto L49;
        boolean r13 = r1.c;
    L50:
        if (r13 == false) goto L52;
    L54:
        boolean r14 = false;
    L55:
        if (r1 == null) goto L59;
        Bundle r15 = r1.n;
        if (r15 == null) goto L59;
        r2 = r15.getInt("EXTRA_INT_TOTAL_SHOPPING_GOOD", 0);
    L59:
        r3.f(r14, r2);
        goto L60
    L52:
        if (this.hideShoppingNumber == true) goto L54;
        r14 = true;
        goto L55
    L49:
        r13 = false;
    L60:
        r3.setDefaultImageAdapter(getDefaultAnimateImageAdapter());
        r3.setId(2131371249);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (r1 != null) goto L63;
    L65:
        r3.b = true;
        if (TextUtils.isEmpty(r9) == false) goto L68;
        ((ECNetImageView) r3.d(2131376634)).setImageResource(r8);
    L71:
        return r3;
    L68:
        ECLiveImageUtils.j((SimpleDraweeView) r3.d(2131376634), r9);
        if (((ECNetImageView) r3.d(2131376634)).getHierarchy() == null) goto L71;
        ((ECNetImageView) r3.d(2131376634)).getHierarchy().setFailureImage(r8);
        ((ECNetImageView) r3.d(2131376634)).getHierarchy().setPlaceholderImage(2131234300);
        goto L71
    L63:
        if (r1.c != true) goto L65;
        r8 = 2131234544;
        r9 = null;
    L39:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L44;
        r7 = r17;
    L44:
        r12 = r7;
        goto L46
    L12:
        if (((Bundle) this.ecContext.getExtras().getValue()).getBoolean("EXTRA_IS_D_ROOM", false) == false) goto L14;
        r3.setD3Room(true);
        r3.setEnableLinkedAnimation(false);
        goto L28
    L14:
        Integer r18 = (Integer) this.ecContext.getStreamType().getValue();
        int r19 = ECLiveMode.MEDIA.ordinal();
        if (r18 != null) goto L18;
    L20:
        int r20 = ECLiveMode.AUDIO.ordinal();
        if (r18 != null) goto L24;
    L26:
        boolean r21 = true;
    L27:
        r3.setEnableLinkedAnimation(r21);
        goto L28
    L24:
        if (r18.intValue() != r20) goto L26;
    L25:
        r21 = false;
        goto L27
    L18:
        if (r18.intValue() != r19) goto L20;
    L6:
        if (this.contextControllerFromOutside.v() == false) goto L8;
        r0 = this.contextControllerFromOutside;
        goto L9
    L8:
        int r22 = RoomContextController.h;
        r0 = RoomContextController.a.a();
        goto L9
    }

    private final List<String> createImageModel(boolean r3, String r4, Integer r5) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        RoomContextController r0 = this.contextControllerFromOutside;
    L10:
        if (r0.s() == false) goto L12;
        return null;
    L12:
        if (r3 == true) goto L14;
        int r6 = ECLiveMode.MEDIA.ordinal();
        if (r5 != null) goto L19;
    L20:
        int r7 = ECLiveMode.AUDIO.ordinal();
        if (r5 == null) goto L27;
        if (r5.intValue() != r7) goto L27;
        return null;
    L27:
        if (r4.length() <= 0) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L33;
        return CollectionsKt.listOf(r4);
    L33:
        if (n.c() == false) goto L36;
        return null;
    L36:
        if (EComABUtils.isToolbarIconOpt() == false) goto L39;
        return (List) CartCardLinkedAnimController.h.getValue();
    L39:
        return CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp"});
    L29:
        r8 = false;
        goto L30
    L19:
        if (r5.intValue() != r6) goto L20;
        return null;
    L14:
        return CollectionsKt.listOf("https://lf3-cdn-tos.douyinstatic.com/obj/aweme-client-static-resource/d3_store.webp");
    L6:
        if (this.contextControllerFromOutside.v() == false) goto L8;
        r0 = this.contextControllerFromOutside;
        goto L10
    L8:
        int r1 = RoomContextController.h;
        r0 = RoomContextController.a.a();
        goto L10
    }

    public ShoppingCart(Context r2, ECContext r3, EntryController r4, RoomContextController r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ecContext");
        Intrinsics.checkNotNullParameter(r4, "entryControllerFromOutside");
        Intrinsics.checkNotNullParameter(r5, "contextControllerFromOutside");
        this.context = r2;
        this.ecContext = r3;
        this.entryControllerFromOutside = r4;
        this.contextControllerFromOutside = r5;
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
    L9:
        this.entryController = r4;
        this.defaultAnimateImageAdapter$delegate = LazyKt.lazy(new ShoppingCart$defaultAnimateImageAdapter$2(this));
        return;
    L6:
        if (r4.v() == true) goto L9;
        boolean r6 = EntryController.M1;
        r4 = EntryController.a.b((String) r3.getRoomId().getValue(), r4.D());
        goto L9
    }

    public static final /* synthetic */ List access$createImageModel(ShoppingCart r0, boolean r1, String r2, Integer r3) {
        return r0.createImageModel(r1, r2, r3);
    }
}
