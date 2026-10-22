package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedStickyConfig;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020\b¢\u0006\u0004\b_\u0010`J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100RA\u0010<\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\n\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010M\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010\u0013\"\u0004\bN\u0010AR*\u0010U\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR*\u0010Y\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010P\u001a\u0004\bW\u0010R\"\u0004\bX\u0010T¨\u0006a"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CartGULView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedStickyConfig;", "getStickyConfig", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lorg/json/JSONObject;", "", "getMethod", "", "height", "", "setSafeHeight", "getShowHeight", "Landroidx/recyclerview/widget/RecyclerView;", "getGULRecyclerView", "", "a", "Lkotlin/Lazy;", "getMallFeedEnable", "()Z", "mallFeedEnable", "b", "getMallFeedApiCacheEnable", "mallFeedApiCacheEnable", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "d", "getMallFeedComponent", "()Lcom/bytedance/android/shopping/api/mall/feed/d;", "mallFeedComponent", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "e", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "getObjectContainer", "()Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "setObjectContainer", "(Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;)V", "objectContainer", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "f", "getSliceCustomWidgetAdapterComponent", "()Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "sliceCustomWidgetAdapterComponent", "Lti/l;", "g", "Lti/l;", "getLiveComponent", "()Lti/l;", "setLiveComponent", "(Lti/l;)V", "liveComponent", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rev", "h", "Lkotlin/jvm/functions/Function1;", "getSetUpCallBack", "()Lkotlin/jvm/functions/Function1;", "setSetUpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "setUpCallBack", "i", "Z", "getUseListV2Feat", "setUseListV2Feat", "(Z)V", "useListV2Feat", "Lcom/bytedance/android/shopping/new_cart/widgets/j;", "j", "Lcom/bytedance/android/shopping/new_cart/widgets/j;", "getOuterScrollView", "()Lcom/bytedance/android/shopping/new_cart/widgets/j;", "setOuterScrollView", "(Lcom/bytedance/android/shopping/new_cart/widgets/j;)V", "outerScrollView", "value", "k", "isShow", "setShow", "l", "I", "getOuterHeight", "()I", "setOuterHeight", "(I)V", "outerHeight", "m", "getFooterRoundCornerExtraHeight", "setFooterRoundCornerExtraHeight", "footerRoundCornerExtraHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartGULView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public CartObjectContainer e;
    public final Lazy f;
    public ti.l g;
    public Function1<? super RecyclerView, Unit> h;
    public boolean i;
    public j j;
    public boolean k;
    public int l;
    public int m;

    public static final class a {
    }

    static {
    }

    public CartGULView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartGULView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean getMallFeedApiCacheEnable() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    private final com.bytedance.android.shopping.api.mall.feed.d getMallFeedComponent() {
        return (com.bytedance.android.shopping.api.mall.feed.d) this.d.getValue();
    }

    private final boolean getMallFeedEnable() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    private final CartSliceCustomWidgetAdapterComponent getSliceCustomWidgetAdapterComponent() {
        return (CartSliceCustomWidgetAdapterComponent) this.f.getValue();
    }

    public final void j() {
        setShow(false);
        setSafeHeight(0);
    }

    public final void k() {
        setShow(true);
        if (this.i == false) goto L5;
        setSafeHeight(getShowHeight());
    L6:
        g();
        RecyclerView r0 = getGULRecyclerView();
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r0, "$this$scrollToTop");
        com.bytedance.android.shopping.new_cart.utils.a.c.d("scrollToTop", new com.bytedance.android.shopping.new_cart.utils.h(r0));
        return;
    L10:
        return;
    L5:
        setSafeHeight(-1);
        goto L6
    }

    private final com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> getMethod() {
        boolean r0 = ECServiceManager.a;
        pd.e r1 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r1 == null) goto L7;
        pd.f r2 = r1.getExternalJsBridgeMethodInjectorAdapter();
        if (r2 == null) goto L7;
        return r2.d(new AnonymousClass1(this));
    L7:
        return null;
    }

    private final ECMallFeedStickyConfig getStickyConfig() {
        return new ECMallFeedStickyConfig(new C02841(this), new AnonymousClass2(this), AnonymousClass3.INSTANCE);
    }

    public final void i() {
        setSafeHeight(com.bytedance.android.shopping.extensions.b.b(12));
        setShow(false);
    }

    private final int getShowHeight() {
        if (CartSettingUtils.a() == false) goto L6;
        return this.l + this.m;
    L6:
        return this.l;
    }

    public final void g() {
        if (CartSettingUtils.a() == true) goto L5;
        return;
    L5:
        RecyclerView r0 = getGULRecyclerView();
        if (r0 == null) goto L13;
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), this.m);
        if (this.m > 0) goto L10;
        boolean r1 = true;
    L11:
        r0.setClipToPadding(r1);
        return;
    L10:
        r1 = false;
        goto L11
    }

    public final RecyclerView getGULRecyclerView() {
        return CartViewExtentionsKt.b(this);
    }

    public final int getFooterRoundCornerExtraHeight() {
        return this.m;
    }

    public final ti.l getLiveComponent() {
        return this.g;
    }

    public final CartObjectContainer getObjectContainer() {
        return this.e;
    }

    public final int getOuterHeight() {
        return this.l;
    }

    public final j getOuterScrollView() {
        return this.j;
    }

    public final Function1<RecyclerView, Unit> getSetUpCallBack() {
        return this.h;
    }

    public final boolean getUseListV2Feat() {
        return this.i;
    }

    public static final String a(CartGULView r4) {
        r4.getClass();
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r2 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_reactlynx_ecommerce_yata_cart/gul/template/template.js";
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L7
        Object r6 = jj4.a.a("cart_recommend_lynx_resource", String.class, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_reactlynx_ecommerce_yata_cart/gul/template/template.js", false);     // Catch: Throwable -> L7
        if (r6 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        Uri.Builder r7 = UriProtector.parse((String) r6).buildUpon();
        CartObjectContainer r8 = r4.e;
        if (r8 == null) goto L25;
        com.bytedance.android.shopping.new_cart.container.b r9 = r8.e;
        if (r9 == null) goto L25;
        CartParams r10 = r9.c;
        if (r10 == null) goto L25;
        HashMap<String, String> r11 = r10.getSchemaParams();
        if (r11 == null) goto L25;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        Map.Entry<String, String> r13 = r12.next();
        r7.appendQueryParameter(r13.getKey(), r13.getValue());
    L25:
        CartObjectContainer r14 = r4.e;
        if (r14 == null) goto L34;
        com.bytedance.android.shopping.new_cart.container.b r15 = r14.e;
        if (r15 == null) goto L34;
        CartParams r16 = r15.c;
        if (r16 == null) goto L34;
        String r17 = r16.getHistoryPath();
        if (r17 == null) goto L34;
        r7.appendQueryParameter(SimilarProductParam.ENTER_FROM, r17);
    L34:
        CartSliceCustomWidgetAdapterComponent r18 = r4.getSliceCustomWidgetAdapterComponent();
        if (r18 == null) goto L38;
        String r19 = r18.c;
        if (r19 == null) goto L38;
    L39:
        r7.appendQueryParameter("current_tab", r19);
        j r20 = r4.j;
        if (r20 == null) goto L46;
        Object r21 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(r20.getOffsetToBottomScreen()));
        if (r21 == null) goto L46;
        Integer r22 = CartViewExtentionsKt.a(r21);
        if (r22 == null) goto L46;
        r7.appendQueryParameter("bottom_offset", String.valueOf(r22.intValue()));
    L46:
        Lazy r23 = ECAppInfoService.a;
        if (ECAppInfoService.m() == false) goto L66;
        CartObjectContainer r24 = r4.e;
        if (r24 == null) goto L54;
        com.bytedance.android.shopping.new_cart.container.b r25 = r24.e;
        if (r25 == null) goto L54;
        if (r25.k == true) goto L66;
    L54:
        if (r24 == null) goto L64;
        com.bytedance.android.shopping.new_cart.container.b r26 = r24.e;
        if (r26 == null) goto L64;
        if (ECAppInfoService.m() == true) goto L60;
    L63:
        String r27 = "b4001";
    L65:
        r7.appendQueryParameter("btmb", r27);
        goto L66
    L60:
        if (r26.k == true) goto L63;
        int r28 = s.a;
        r27 = "b98956";
    L64:
        r27 = null;
    L66:
        r7.appendQueryParameter("technology", "YATA_Android");
        return r7.build().toString();
    L38:
        r19 = "";
    L7:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Object r30 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r30) == true) goto L12;
        r2 = r30;
    L12:
        r6 = r2;
        goto L13
    }

    public static final /* synthetic */ boolean b(CartGULView r0) {
        return r0.getMallFeedApiCacheEnable();
    }

    public static final /* synthetic */ com.bytedance.android.shopping.api.mall.feed.d c(CartGULView r0) {
        return r0.getMallFeedComponent();
    }

    public static final /* synthetic */ boolean d(CartGULView r0) {
        return r0.getMallFeedEnable();
    }

    public static final /* synthetic */ com.bytedance.ies.web.jsbridge2.f e(CartGULView r0) {
        return r0.getMethod();
    }

    public static final /* synthetic */ ECMallFeedStickyConfig f(CartGULView r0) {
        return r0.getStickyConfig();
    }

    private final void setSafeHeight(int r3) {
        if (getLayoutParams() == null) goto L5;
        getLayoutParams().height = r3;
    L6:
        requestLayout();
        invalidate();
        return;
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, r3));
        goto L6
    }

    public final void h(boolean r5) {
        ti.l r0 = this.g;
        if (r0 == null) goto L6;
        JSONObject r1 = new JSONObject();
        r1.put("visible", r5);
        r1.put("timestamp", System.currentTimeMillis());
        Unit r6 = Unit.INSTANCE;
        r0.sendJsEvent("H5_visibilityChange", r1);
        return;
    }

    public final void setFooterRoundCornerExtraHeight(int r2) {
        this.m = RangesKt.coerceAtLeast(r2, 0);
        g();
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.i == false) goto L9;
        setSafeHeight(getShowHeight());
        return;
    }

    public final void setLiveComponent(ti.l r1) {
        this.g = r1;
    }

    public final void setObjectContainer(CartObjectContainer r1) {
        this.e = r1;
    }

    public final void setOuterHeight(int r2) {
        this.l = r2;
        if (this.k == false) goto L8;
        int r3 = getShowHeight();
        if (getLayoutParams().height == r3) goto L9;
        getLayoutParams().height = r3;
        requestLayout();
        return;
    L9:
        return;
    }

    public final void setOuterScrollView(j r1) {
        this.j = r1;
    }

    public final void setSetUpCallBack(Function1<? super RecyclerView, Unit> r1) {
        this.h = r1;
    }

    public final void setShow(boolean r2) {
        this.k = r2;
        if (r2 == false) goto L10;
        RecyclerView r3 = getGULRecyclerView();
        if (r3 == null) goto L14;
        Function1<? super RecyclerView, Unit> r0 = this.h;
        if (r0 == null) goto L9;
        Unit r4 = (Unit) r0.invoke(r3);
    L9:
        g();
        return;
    L14:
        return;
    L10:
        Function1<? super RecyclerView, Unit> r5 = this.h;
        if (r5 == null) goto L16;
        Unit r6 = (Unit) r5.invoke(null);
        return;
    }

    public final void setUseListV2Feat(boolean r1) {
        this.i = r1;
    }

    public CartGULView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(CartGULView$mallFeedEnable$2.INSTANCE);
        this.b = LazyKt.lazy(CartGULView$mallFeedApiCacheEnable$2.INSTANCE);
        this.c = LazyKt.lazy(new CartGULView$isInSplitScreen$2(this));
        this.d = LazyKt.lazy(new CartGULView$mallFeedComponent$2(this, r2));
        this.f = LazyKt.lazy(new CartGULView$sliceCustomWidgetAdapterComponent$2(this));
        this.i = true;
    }

    public /* synthetic */ CartGULView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
