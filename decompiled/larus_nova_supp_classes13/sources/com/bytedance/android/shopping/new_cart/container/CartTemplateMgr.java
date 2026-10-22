package com.bytedance.android.shopping.new_cart.container;

import android.content.Context;
import com.bytedance.android.ec.core.slice.ectag.ECTagTemplatePreload;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/container/CartTemplateMgr;", "", "Landroid/content/Context;", "context", "", "preload", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "component", "updateCurrentAdapter", "injectCustomWidget", "", "CHANNEL", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInjectWidgets", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/ref/WeakReference;", "adapterComponent", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function0;", "Lcom/bytedance/android/shopping/new_cart/container/CurrentAdapterComponentProvider;", "currentAdapterComponentProvider", "Lkotlin/jvm/functions/Function0;", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/g;", "preloadInfo$delegate", "Lkotlin/Lazy;", "getPreloadInfo", "()Lcom/bytedance/android/ecom/slice/ext/template/gecko/g;", "preloadInfo", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartTemplateMgr {
    public static final String CHANNEL = "ecom_cart_card_template";
    public static final CartTemplateMgr INSTANCE = null;
    private static WeakReference<CartSliceCustomWidgetAdapterComponent> adapterComponent;
    private static final Function0<CartSliceCustomWidgetAdapterComponent> currentAdapterComponentProvider = null;
    private static final AtomicBoolean isInjectWidgets = null;
    private static final Lazy preloadInfo$delegate = null;

    private CartTemplateMgr() {
    }

    private final com.bytedance.android.ecom.slice.ext.template.gecko.g getPreloadInfo() {
        return (com.bytedance.android.ecom.slice.ext.template.gecko.g) preloadInfo$delegate.getValue();
    }

    static {
        INSTANCE = new CartTemplateMgr();
        isInjectWidgets = new AtomicBoolean(false);
        currentAdapterComponentProvider = CartTemplateMgr$currentAdapterComponentProvider$1.INSTANCE;
        preloadInfo$delegate = LazyKt.lazy(CartTemplateMgr$preloadInfo$2.INSTANCE);
    }

    public final void injectCustomWidget() {
        if (isInjectWidgets.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECCartSlideContainer", r3);
        ElementTypes.b("ECCartCounter", AnonymousClass2.INSTANCE);
        ElementTypes.b("ECCartCountDown", AnonymousClass3.INSTANCE);
        ElementTypes.b("ECCartTabContainer", AnonymousClass4.INSTANCE);
        ElementTypes.b("ECCartLoadingCircle", AnonymousClass5.INSTANCE);
        ElementTypes.b("ECCartLynxPendant", AnonymousClass6.INSTANCE);
        ElementTypes.b("ECCartProgressView", AnonymousClass7.INSTANCE);
        ElementTypes.b("ECCartScrollNumber", AnonymousClass8.INSTANCE);
        ElementTypes.b("ECCartBottomButtonContainer", AnonymousClass9.INSTANCE);
        ElementTypes.b("ECCartDiscountCalculator", AnonymousClass10.INSTANCE);
        ElementTypes.b("ECCartDiscountBubble", AnonymousClass11.INSTANCE);
        if (((Boolean) CartSettingUtils.a.getValue()).booleanValue() == false) goto L8;
        List r1 = CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new ag3.d(), new ag3.e(), new ag3.a(), new ag3.c(), new ag3.b()});
    L9:
        ElementTypes.c("yata_cart", r1);
        return;
    L8:
        r1 = CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new ag3.d(), new ag3.e()});
        goto L9
    }

    public static final /* synthetic */ WeakReference access$getAdapterComponent$p(CartTemplateMgr r0) {
        return adapterComponent;
    }

    public static final /* synthetic */ Function0 access$getCurrentAdapterComponentProvider$p(CartTemplateMgr r0) {
        return currentAdapterComponentProvider;
    }

    public static final /* synthetic */ com.bytedance.android.ecom.slice.ext.template.gecko.g access$getPreloadInfo$p(CartTemplateMgr r0) {
        return r0.getPreloadInfo();
    }

    @JvmStatic
    public static final void preload(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_cart_template_preload");
        ECTagTemplatePreload.a(r4, false);
        Lazy r0 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", C02781.INSTANCE);
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "yata_cart", CHANNEL, wh.a.b(r4), C02792.INSTANCE);
    }

    public final void updateCurrentAdapter(CartSliceCustomWidgetAdapterComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        adapterComponent = new WeakReference(r2);
    }

    public static final /* synthetic */ void access$setAdapterComponent$p(CartTemplateMgr r0, WeakReference r1) {
        adapterComponent = r1;
    }
}
