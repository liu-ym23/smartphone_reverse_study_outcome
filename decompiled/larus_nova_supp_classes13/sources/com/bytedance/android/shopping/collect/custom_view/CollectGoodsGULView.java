package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.mall.MallGylUtil;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.api.mall.feed.SaasGulException;
import com.bytedance.android.shopping.api.mall.feed.h;
import com.bytedance.android.shopping.api.mall.feed.i;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\r¢\u0006\u0004\bK\u0010LJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010(\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u00101RA\u0010@\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0005\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010B\u001a\u00020.2\u0006\u0010A\u001a\u00020.8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006M"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsGULView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/shopping/api/mall/feed/f;", "listener", "", "setFeedStateListener", "Landroid/view/View;", "getView", "Landroidx/recyclerview/widget/RecyclerView;", "getFeedView", "", "getSceneId", "", "height", "setSafeHeight", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "b", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "getCollectParams", "()Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "setCollectParams", "(Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;)V", "collectParams", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "Lcom/bytedance/kmp/ec/yata/YaTaInstance;", "c", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "getYaTaInstance", "()Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "setYaTaInstance", "(Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;)V", "yaTaInstance", "d", "Lkotlin/Lazy;", "getPreloadThreshold", "()I", "preloadThreshold", "", "e", "getGylStraightOut", "()Z", "gylStraightOut", "f", "getImagePrefetchEnable", "imagePrefetchEnable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rev", "i", "Lkotlin/jvm/functions/Function1;", "getSetUpCallBack", "()Lkotlin/jvm/functions/Function1;", "setSetUpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "setUpCallBack", "value", "isShow", "Z", "setShow", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectGoodsGULView extends FrameLayout implements com.bytedance.android.shopping.api.mall.feed.d {
    public LifecycleOwner a;
    public CollectParams b;
    public AndroidYaTaInstance c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public com.bytedance.android.shopping.api.mall.feed.d g;
    public boolean h;
    public Function1<? super RecyclerView, Unit> i;

    public static final class a {
    }

    static {
    }

    public CollectGoodsGULView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CollectGoodsGULView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean getGylStraightOut() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    private final boolean getImagePrefetchEnable() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    private final int getPreloadThreshold() {
        return ((Number) this.d.getValue()).intValue();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void e(Long r1) {
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public String getSceneId() {
        return "";
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void h() {
    }

    public void setIsInSplit(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void b() {
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void g() {
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public RecyclerView getFeedView() {
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFeedView();
    }

    public final void j() {
        if (this.g != null) goto L11;
        SaasGulException r0 = new SaasGulException("feed component is null, need init");
        String r1 = r0.getMessage();
        if (r1 == null) goto L8;
        EnsureManager.ensureNotReachHere(r1);
    L8:
        if (ECAppInfoService.e.isLocalTest() == false) goto L12;
        throw r0;
    L12:
        return;
    }

    public final void k() {
        CollectParams r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        setShow(false);
        setSafeHeight(0);
        return;
    L5:
        if (r0.isFromPersonal() != true) goto L7;
    }

    public final void l() {
        CollectParams r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        CollectParams r2 = this.b;
        if (r2 == null) goto L10;
        String r3 = r2.getPreviousPage();
    L12:
        if (StringUtils.isEmpty(r3) == false) goto L14;
        String r4 = "personal_homepage";
    L17:
        final String r5 = r4;
    L19:
        LifecycleOwner r8 = this.a;
        if (r8 == null) goto L96;
        CollectParams r6 = this.b;
        if (r6 == null) goto L24;
        String r7 = r6.getEcomSceneId();
    L25:
        d r9 = new d(this.c, new CollectGoodsGULView$tryDoInitGul$$inlined$let$lambda$1(this, r5));
        if (ECAppInfoService.e.isNightMode() == false) goto L32;
        CollectParams r10 = this.b;
        if (r10 == null) goto L32;
        if (r10.isFromPersonal() != true) goto L32;
        boolean r11 = true;
    L33:
        h r12 = new h(r5, r7, r11, r8, r9);
        Intrinsics.checkNotNullParameter(r12, "config");
        int r13 = ECSdk.a;
        g r14 = (g) ECSdk.a(g.class);
        if (r14 == null) goto L37;
        r14.z();
    L37:
        if (this.h == true) goto L96;
        this.h = true;
        removeAllViews();
        IECMallFeedService r15 = (IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class);
        if (r15 == null) goto L86;
        Context r16 = getContext();
        IECHostService r17 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r17 == null) goto L43;
        Boolean r18 = Boolean.valueOf(r17.getRecommendStatus());
    L44:
        if (r18 != null) goto L46;
    L49:
        String r19 = "你可能还会喜欢";
    L50:
        String r110 = r19;
        String r111 = r12.a;
        Integer r112 = Integer.valueOf(getPreloadThreshold());
        if (getGylStraightOut() == false) goto L53;
        com.bytedance.android.shopping.api.mall.feed.a r113 = new com.bytedance.android.shopping.api.mall.feed.a(r12.a, 1, null);
    L55:
        if (getImagePrefetchEnable() == false) goto L84;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.putAll(((IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class)).c().a());
        Object r21 = r20.get("image_prefetch_first_screen_enable");
        if ((r21 instanceof Boolean) == true) goto L59;
        r21 = null;
    L59:
        Boolean r114 = Boolean.TRUE;
        boolean r115 = Intrinsics.areEqual((Boolean) r21, r114);
        Object r22 = r20.get("image_prefetch_first_screen_count");
        if ((r22 instanceof Number) == true) goto L62;
        r22 = null;
    L62:
        Number r23 = (Number) r22;
        if (r23 == null) goto L65;
        int r116 = r23.intValue();
    L66:
        Object r24 = r20.get("image_prefetch_load_more_enable");
        if ((r24 instanceof Boolean) == true) goto L69;
        r24 = null;
    L69:
        boolean r117 = Intrinsics.areEqual((Boolean) r24, r114);
        Object r25 = r20.get("image_prefetch_load_more_count");
        if ((r25 instanceof Number) == true) goto L72;
        r25 = null;
    L72:
        Number r26 = (Number) r25;
        if (r26 == null) goto L75;
        int r27 = r26.intValue();
    L76:
        Object r28 = r20.get("image_prefetch_load_more_immediate");
        if ((r28 instanceof Number) == true) goto L79;
        r28 = null;
    L79:
        Number r29 = (Number) r28;
        if (r29 == null) goto L82;
        int r210 = r29.intValue();
    L83:
        com.bytedance.android.shopping.api.mall.feed.c r118 = new com.bytedance.android.shopping.api.mall.feed.c(r115, r116, r117, r27, r210);
    L85:
        i r30 = new i(CollectionsKt.listOf(new Integer[]{8, 24, 12, 16}));
        Lazy r31 = MallGylUtil.a;
        com.bytedance.android.shopping.api.mall.feed.d r32 = r15.createFeedComponent(r16, new com.bytedance.android.shopping.api.mall.feed.b(r111, r110, r112, r113, r118, r30, MallGylUtil.b(r12.a), MallGylUtil.a(), null, null, false, null, 15872), new e(r12), r12.h);
    L87:
        if (r32 == null) goto L96;
        this.g = r32;
        View r33 = r32.getView();
        ViewParent r34 = r33.getParent();
        if ((r34 instanceof ViewGroup) == true) goto L91;
        ViewParent r35 = null;
    L92:
        ViewGroup r36 = (ViewGroup) r35;
        if (r36 == null) goto L95;
        r36.removeView(r33);
    L95:
        addView(r33, new FrameLayout.LayoutParams(-1, k1.j(getContext())));
        goto L96
    L91:
        r35 = r34;
        goto L92
    L82:
        r210 = 0;
        goto L83
    L75:
        r27 = 0;
        goto L76
    L65:
        r116 = 0;
        goto L66
    L84:
        r118 = null;
        goto L85
    L53:
        r113 = null;
        goto L55
    L46:
        if (r18.booleanValue() == true) goto L49;
        r19 = "看了又看";
        goto L50
    L43:
        r18 = null;
        goto L44
    L86:
        r32 = null;
    L32:
        r11 = false;
        goto L33
    L24:
        r7 = null;
    L96:
        c();
        return;
    L14:
        CollectParams r37 = this.b;
        if (r37 == null) goto L18;
        r4 = r37.getPreviousPage();
        goto L17
    L18:
        r5 = null;
        goto L19
    L10:
        r3 = null;
        goto L12
    L5:
        if (r1.isFromPersonal() != true) goto L7;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void c() {
        j();
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        g();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void d() {
        j();
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final CollectParams getCollectParams() {
        return this.b;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.a;
    }

    public final Function1<RecyclerView, Unit> getSetUpCallBack() {
        return this.i;
    }

    public final AndroidYaTaInstance getYaTaInstance() {
        return this.c;
    }

    public static final void i(CollectGoodsGULView r4) {
        boolean r0 = true;
        r4.setShow(true);
        r4.setSafeHeight(k1.j(r4.getContext()));
        RecyclerView r5 = r4.getFeedView();
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$scrollToTop");
        RecyclerView.Adapter r1 = r5.getAdapter();
        if (r1 == null) goto L17;
        Integer r2 = Integer.valueOf(r1.getItemCount());
        if (r2.intValue() > 0) goto L10;
        r0 = false;
    L10:
        if (r0 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L18;
        r2.intValue();
        r5.scrollToPosition(0);
        return;
    L18:
        return;
    L17:
        return;
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

    private final void setShow(boolean r2) {
        if (r2 == false) goto L8;
        RecyclerView r3 = getFeedView();
        if (r3 == null) goto L12;
        Function1<? super RecyclerView, Unit> r0 = this.i;
        if (r0 == null) goto L13;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    L13:
        return;
    L12:
        return;
    L8:
        Function1<? super RecyclerView, Unit> r5 = this.i;
        if (r5 == null) goto L15;
        Unit r6 = (Unit) r5.invoke(null);
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void a(Integer r1) {
        c();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        j();
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final void setCollectParams(CollectParams r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public void setFeedStateListener(com.bytedance.android.shopping.api.mall.feed.f r2) {
        j();
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.setFeedStateListener(r2);
        return;
    }

    public final void setLifecycleOwner(LifecycleOwner r1) {
        this.a = r1;
    }

    public final void setSetUpCallBack(Function1<? super RecyclerView, Unit> r1) {
        this.i = r1;
    }

    public final void setYaTaInstance(AndroidYaTaInstance r1) {
        this.c = r1;
    }

    public CollectGoodsGULView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(CollectGoodsGULView$preloadThreshold$2.INSTANCE);
        this.e = LazyKt.lazy(CollectGoodsGULView$gylStraightOut$2.INSTANCE);
        this.f = LazyKt.lazy(CollectGoodsGULView$imagePrefetchEnable$2.INSTANCE);
    }

    public /* synthetic */ CollectGoodsGULView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
