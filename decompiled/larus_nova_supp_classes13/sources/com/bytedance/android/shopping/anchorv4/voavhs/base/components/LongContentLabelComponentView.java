package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.GradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxAirCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiCouponButtonComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiGradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.c;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.CouponButtonElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.CouponButtonElementViewV2;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.IconsWithSpaceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.InlineLongTitleComponentView;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001`\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB)\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bh\u0010iJ\u001a\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010#\u001a\u00020\"J\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016J(\u0010-\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\b\u0010.\u001a\u00020\u000eH\u0014J\u000f\u00101\u001a\u00020\u000eH\u0001¢\u0006\u0004\b/\u00100J\u0012\u00104\u001a\u0004\u0018\u0001032\u0006\u00102\u001a\u00020\nH\u0016R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000203058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010@R#\u0010M\u001a\n H*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010c¨\u0006l"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "component", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "background", "bindLynxCard", "", "paddingTop", "paddingBottom", "height", "", "addHybridView", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxAirCardComponent;", "bindLynxAirCard", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "description", "bind", "update", "getHeadLayout", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "actionHub", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "showEvent", "", "descriptionVO", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "associatedAction", "", "isLynxView", "", "getSchema", "Landroid/graphics/Canvas;", "canvas", "draw", "w", "h", "oldw", "oldh", "onSizeChanged", "onAttachedToWindow", "destroy$ec_shopping_impl_saasRelease", "()V", "destroy", "id", "Landroid/view/View;", "_$_findCachedViewById", "", "_$_findViewCache", "Ljava/util/Map;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "radiusHelper", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "Lti/l;", "hybridComponent", "Lti/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "headButtonView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiCouponButtonComponentView;", "couponButtonView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiCouponButtonComponentView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiGradientTextWithIconsComponentView;", "headLabelView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiGradientTextWithIconsComponentView;", "tailButtonView", "kotlin.jvm.PlatformType", "root$delegate", "Lkotlin/Lazy;", "getRoot", "()Landroid/widget/LinearLayout;", "root", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "isLynx", "Z", "schema", "Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "skuSpecText", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "getSkuSpecText", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "setSkuSpecText", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;)V", "Landroidx/lifecycle/Lifecycle;", "cachedLifecycle", "Landroidx/lifecycle/Lifecycle;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "com/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView$b", "cardLifeCycle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView$b;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongContentLabelComponentView extends LinearLayout implements ActionHubAccessor, d, LifecycleObserver {
    public static final a Companion = null;
    private static final String TAG = null;
    private Map<Integer, View> _$_findViewCache;
    private com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub;
    private Lifecycle cachedLifecycle;
    private final b cardLifeCycle;
    private MultiCouponButtonComponentView couponButtonView;
    private LongContentLabelComponent descriptionVO;
    private TagsScrollBoxComponentView headButtonView;
    private MultiGradientTextWithIconsComponentView headLabelView;
    private l hybridComponent;
    private boolean isLynx;
    private ECLynxCard lynxCard;
    private final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b radiusHelper;
    private final Lazy root$delegate;
    private String schema;
    private c skuSpecText;
    private TagsScrollBoxComponentView tailButtonView;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends IECLynxCardLifeCycle.Base {
        public final /* synthetic */ LongContentLabelComponentView a;

        public final void onRuntimeReady() {
            ECLynxCard r0 = LongContentLabelComponentView.access$getLynxCard$p(this.a);
            if (r0 == null) goto L5;
            r0.n();
        L5:
            dm.a.b r1 = dm.a.a;
            dm.a.a(LongContentLabelComponentView.access$getTAG$cp()).i("IECLynxCardLifeCycle onRuntimeReady");
        }

        public b(LongContentLabelComponentView r1) {
            this.a = r1;
        }

        public final void onLoadFailed(ECLynxCardErrorType r4, Integer r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            dm.a.b r0 = dm.a.a;
            dm.a.a(LongContentLabelComponentView.access$getTAG$cp()).i("IECLynxCardLifeCycle onLoadFailed: type:" + r4.name() + ", errorCode: " + r5 + ", errorMsg: " + r6);
        }
    }

    public LongContentLabelComponentView(Context r7) {
        this(r7, null, null, 6, null);
    }

    public LongContentLabelComponentView(Context r7, AttributeSet r8) {
        this(r7, r8, null, 4, null);
    }

    private final LinearLayout getRoot() {
        return (LinearLayout) this.root$delegate.getValue();
    }

    static {
        Companion = new a();
        TAG = com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.b.class.getSimpleName();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public Action associatedAction() {
        LongContentLabelComponent r0 = this.descriptionVO;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAction();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy$ec_shopping_impl_saasRelease() {
        l r0 = this.hybridComponent;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        Lifecycle r1 = this.cachedLifecycle;
        if (r1 == null) goto L9;
        r1.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public List<ShowEvent> showEvent() {
        LongContentLabelComponent r0 = this.descriptionVO;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowEvent();
    }

    public final LinearLayout getHeadLayout() {
        return (LinearLayout) _$_findCachedViewById(2131379191);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = za3.a.a;
        Intrinsics.checkNotNullParameter(this, FreqActions.ACTION_VIEW);
        Object r1 = getTag(2131371248);
        Lifecycle r3 = null;
        if ((r1 instanceof LifecycleOwner) == true) goto L5;
        r1 = null;
    L5:
        LifecycleOwner r2 = (LifecycleOwner) r1;
        if (r2 != null) goto L16;
        Object r4 = getParent();
    L9:
        if (r2 != null) goto L16;
        if ((r4 instanceof View) == false) goto L16;
        View r5 = (View) r4;
        Object r6 = r5.getTag(2131371248);
        if ((r6 instanceof LifecycleOwner) == true) goto L15;
        r6 = null;
    L15:
        r2 = (LifecycleOwner) r6;
        r4 = r5.getParent();
    L16:
        if (r2 == null) goto L18;
        r3 = r2.getLifecycle();
    L18:
        if (r3 == null) goto L20;
    L26:
        this.cachedLifecycle = r3;
        if (r3 == null) goto L34;
        r3.addObserver(this);
        return;
    L34:
        return;
    L20:
        if ((getContext() instanceof LifecycleOwner) == false) goto L26;
        LifecycleOwner r7 = getContext();
        if (r7 == null) goto L25;
        r3 = r7.getLifecycle();
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.actionHub;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public Object descriptionVO() {
        return this.descriptionVO;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final String getSchema() {
        return this.schema;
    }

    public final c getSkuSpecText() {
        return this.skuSpecText;
    }

    public final boolean isLynxView() {
        return this.isLynx;
    }

    public static final /* synthetic */ ECLynxCard access$getLynxCard$p(LongContentLabelComponentView r0) {
        return r0.lynxCard;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new LinkedHashMap();
    L5:
        View r0 = this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.CouponButtonElementView] */
    public final LongContentLabelComponentView bind(LongContentLabelComponent r22) {
        this.descriptionVO = r22;
        if (r22 != null) goto L6;
        setVisibility(8);
        return this;
    L6:
        ExtensionsKt.j(this, r22.getBackground());
        int r4 = 1;
        if (r22.getLynxCard() == null) goto L11;
        this.isLynx = true;
        return bindLynxCard(r22.getLynxCard(), r22.getBackground());
    L11:
        if (r22.getLynxAirCard() == null) goto L14;
        this.isLynx = true;
        return bindLynxAirCard(r22.getLynxAirCard(), r22.getBackground());
    L14:
        ExtensionsKt.a(this, r22.getAlignStrategy());
        ExtensionsKt.a((LinearLayout) _$_findCachedViewById(2131379190), r22.getAlignStrategy());
        ExtensionsKt.a((LinearLayout) _$_findCachedViewById(2131379191), r22.getAlignStrategy());
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r5 = this.radiusHelper;
        Background r6 = r22.getBackground();
        AttributeSet r7 = null;
        if (r6 == null) goto L17;
        Radius r8 = r6.getRadius();
    L18:
        r5.f(r8);
        ((LinearLayout) _$_findCachedViewById(2131379191)).removeAllViews();
        ((LinearLayout) _$_findCachedViewById(2131379193)).removeAllViews();
        ((LinearLayout) _$_findCachedViewById(2131379192)).removeAllViews();
        TagsScrollBoxComponent r9 = r22.getHeadButtons();
        int r10 = 14;
        int r11 = 0;
        if (r9 == null) goto L21;
        TagsScrollBoxComponentView r12 = new TagsScrollBoxComponentView(getContext(), null, 0, 14);
        r12.setSkuSpecText(this.skuSpecText);
        r12.setOverflowContainer((ViewGroup) _$_findCachedViewById(2131379192));
        this.headButtonView = r12;
        TagsScrollBoxComponentView.b(r12, r9, null, 14);
        ((LinearLayout) _$_findCachedViewById(2131379191)).addView(r12);
    L21:
        MultiCouponButtonComponent r13 = r22.getHeadCouponButtons();
        int r14 = -2;
        if (r13 == null) goto L51;
        MultiCouponButtonComponentView r15 = new MultiCouponButtonComponentView(getContext(), null, 0, 14);
        this.couponButtonView = r15;
        r15.a = r13;
        List r16 = r13.getButtonList();
        if (r16 != null) goto L27;
        r15.setVisibility(8);
    L50:
        ((LinearLayout) _$_findCachedViewById(2131379191)).addView(r15);
        goto L51
    L27:
        ExtensionsKt.a(r15, r13.getAlignStrategy());
        Iterator r17 = r16.iterator();
        int r18 = 0;
    L29:
        if (r17.hasNext() == false) goto L49;
        Object r19 = r17.next();
        int r110 = r18 + 1;
        if (r18 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        CouponButtonElement r20 = (CouponButtonElement) r19;
        if (r13.getCouponType() != 0) goto L40;
        ?? r2 = new CouponButtonElementView(r15.getContext(), r7, r11, r10);
        r2.R5(r20);
        ViewGroup.MarginLayoutParams r3 = new ViewGroup.MarginLayoutParams(r14, r14);
        if (r18 <= 0) goto L38;
        r3.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.getSpace()));
    L38:
        Unit r21 = Unit.INSTANCE;
        r15.addView(r2, r3);
    L48:
        r18 = r110;
        r4 = 1;
        r7 = null;
        r14 = -2;
        r10 = 14;
        r11 = 0;
        goto L29
    L40:
        if (r13.getCouponType() != r4) goto L48;
        int r23 = r16.size();
        double r24 = n1.f - (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.getSpace())) * (r23 - 1));
        double r111 = (1.0d / ((double) r23)) * r24;
        if (r23 != r4) goto L44;
        r111 = r24 * 0.5d;
    L44:
        CouponButtonElementViewV2 r25 = new CouponButtonElementViewV2(r15.getContext(), null, 0, 14);
        r25.a(r20);
        ViewGroup.MarginLayoutParams r26 = new ViewGroup.MarginLayoutParams((int) r111, -2);
        if (r18 <= 0) goto L47;
        r26.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.getSpace()));
    L47:
        Unit r27 = Unit.INSTANCE;
        r15.addView(r25, r26);
        goto L48
    L49:
        ViewGroup.MarginLayoutParams r28 = new ViewGroup.MarginLayoutParams(-2, -2);
        r28.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.getLeftSpace()));
        Unit r29 = Unit.INSTANCE;
        r15.setLayoutParams(r28);
        Action r30 = r13.getAction();
        Intrinsics.checkNotNullParameter(r15, "theView");
        ActionHubAccessor.DefaultImpls.a(r15, r15, r30);
    L51:
        MultiGradientTextWithIconsComponent r31 = r22.getHeadLabels();
        if (r31 == null) goto L107;
        MultiGradientTextWithIconsComponentView r32 = new MultiGradientTextWithIconsComponentView(getContext(), null, 0, 14);
        this.headLabelView = r32;
        r32.a = r31;
        List r33 = r31.getLabelList();
        if (r33 != null) goto L57;
        r32.setVisibility(8);
    L106:
        ((LinearLayout) _$_findCachedViewById(2131379191)).addView(r32);
        goto L107
    L57:
        ExtensionsKt.a(r32, r31.getAlignStrategy());
        Iterator r34 = r33.iterator();
        int r112 = 0;
    L59:
        if (r34.hasNext() == false) goto L105;
        Object r35 = r34.next();
        int r36 = r112 + 1;
        if (r112 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        GradientTextWithIconsComponent r37 = (GradientTextWithIconsComponent) r35;
        GradientTextWithIconsComponentView r38 = new GradientTextWithIconsComponentView(r32.getContext(), null, 6);
        r38.b = r37;
        if (r37 == null) goto L66;
        Background r39 = r37.getBackground();
    L67:
        ExtensionsKt.j(r38, r39);
        if (r37 == null) goto L97;
        LongTitleComponent r40 = r37.getContent();
        if (r40 == null) goto L97;
        if (r40.getInline() == false) goto L74;
        ((InlineLongTitleComponentView) r38.a(2131375304)).x(r40);
        r38.a(2131375304).setVisibility(0);
        r38.a(2131379196).setVisibility(8);
        int r41 = 0;
    L96:
        r38.setVisibility(r41);
    L98:
        if (r37 == null) goto L100;
        Action r42 = r37.getAction();
    L101:
        Intrinsics.checkNotNullParameter(r38, "theView");
        ActionHubAccessor.DefaultImpls.a(r38, r38, r42);
        ViewGroup.MarginLayoutParams r43 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r112 <= 0) goto L104;
        r43.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r31.getSpace()));
    L104:
        Unit r44 = Unit.INSTANCE;
        r32.addView(r38, r43);
        r112 = r36;
        goto L59
    L100:
        r42 = null;
        goto L101
    L74:
        LongTitleComponentView r113 = (LongTitleComponentView) r38.a(2131379196);
        r113.b = r40;
        ExtensionsKt.a(r113, r40.getAlignStrategy());
        IconsWithSpaceElement r114 = r40.getHeadIcons();
        if (r114 == null) goto L77;
        ((IconsWithSpaceElementView) r113.a(2131379198)).a(r114);
        ((IconsWithSpaceElementView) r113.a(2131379198)).setVisibility(0);
    L78:
        TextElement r45 = r40.getContent();
        if (r45 == null) goto L81;
        ((TextElementView) r113.a(2131379197)).x(r45);
        ((TextElementView) r113.a(2131379197)).setVisibility(0);
    L82:
        IconsWithSpaceElement r46 = r40.getTailIcons();
        if (r46 == null) goto L94;
        ((IconsWithSpaceElementView) r113.a(2131379199)).a(r46);
        ((IconsWithSpaceElementView) r113.a(2131379199)).setVisibility(0);
        ViewGroup.LayoutParams r115 = ((IconsWithSpaceElementView) r113.a(2131379199)).getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == true) goto L87;
        r115 = null;
    L87:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        if (r116 == null) goto L90;
        r116.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r46.getSpace()));
        Unit r47 = Unit.INSTANCE;
    L91:
        if (r47 == null) goto L94;
        int r117 = 8;
    L95:
        Action r48 = r40.getAction();
        Intrinsics.checkNotNullParameter(r113, "theView");
        ActionHubAccessor.DefaultImpls.a(r113, r113, r48);
        r41 = 0;
        r38.a(2131379196).setVisibility(0);
        r38.a(2131375304).setVisibility(r117);
        goto L96
    L90:
        r47 = null;
    L94:
        r117 = 8;
        ((IconsWithSpaceElementView) r113.a(2131379199)).setVisibility(8);
        Unit r49 = Unit.INSTANCE;
        goto L95
    L81:
        ((TextElementView) r113.a(2131379197)).setVisibility(8);
        goto L82
    L77:
        ((IconsWithSpaceElementView) r113.a(2131379198)).setVisibility(8);
    L97:
        r38.setVisibility(8);
        goto L98
    L66:
        r39 = null;
        goto L67
    L105:
        ViewGroup.MarginLayoutParams r50 = new ViewGroup.MarginLayoutParams(-2, -2);
        r50.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r31.getLeftSpace()));
        Unit r51 = Unit.INSTANCE;
        r32.setLayoutParams(r50);
        Action r52 = r31.getAction();
        Intrinsics.checkNotNullParameter(r32, "theView");
        ActionHubAccessor.DefaultImpls.a(r32, r32, r52);
    L107:
        TagsScrollBoxComponent r53 = r22.getTailButtons();
        if (r53 == null) goto L110;
        TagsScrollBoxComponentView r54 = new TagsScrollBoxComponentView(getContext(), null, 0, 14);
        this.tailButtonView = r54;
        TagsScrollBoxComponentView.b(r54, r53, null, 14);
        ((LinearLayout) _$_findCachedViewById(2131379193)).addView(r54);
    L110:
        configPossibleAction(this, r22.getAction());
        return this;
    L17:
        r8 = null;
        goto L18
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.radiusHelper.e(r2);
        super.draw(r2);
        this.radiusHelper.d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.actionHub = r2;
    }

    public final void setSkuSpecText(c r1) {
        this.skuSpecText = r1;
    }

    public final void update(LongContentLabelComponent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.descriptionVO = r3;
        TagsScrollBoxComponent r0 = r3.getHeadButtons();
        if (r0 == null) goto L9;
        TagsScrollBoxComponentView r1 = this.headButtonView;
        if (r1 == null) goto L9;
        r1.update(r0);
    L9:
        MultiCouponButtonComponent r2 = r3.getHeadCouponButtons();
        if (r2 == null) goto L14;
        MultiCouponButtonComponentView r4 = this.couponButtonView;
        if (r4 == null) goto L14;
        r4.update(r2);
    L14:
        MultiGradientTextWithIconsComponent r5 = r3.getHeadLabels();
        if (r5 == null) goto L19;
        MultiGradientTextWithIconsComponentView r6 = this.headLabelView;
        if (r6 == null) goto L19;
        r6.update(r5);
    L19:
        TagsScrollBoxComponent r7 = r3.getTailButtons();
        if (r7 == null) goto L25;
        TagsScrollBoxComponentView r8 = this.tailButtonView;
        if (r8 == null) goto L26;
        r8.update(r7);
        return;
    L26:
        return;
    }

    public static final /* synthetic */ void access$setLynxCard$p(LongContentLabelComponentView r0, ECLynxCard r1) {
        r0.lynxCard = r1;
    }

    private final LongContentLabelComponentView bindLynxAirCard(LynxAirCardComponent r4, Background r5) {
        this.schema = r4.getSchema();
        String r6 = r4.getSchema();
        if (r6 != null) goto L5;
    L13:
        return this;
    L5:
        if (this.lynxCard != null) goto L7;
        this.lynxCard = new ECLynxCard();
    L7:
        ECLynxLoadParam.a r0 = new ECLynxLoadParam.a(getContext(), r6, this);
        r0.j(2000);
        r0.j = r4.getData();
        r0.f(this.cardLifeCycle);
        LinkedHashMap r7 = new LinkedHashMap();
        String r8 = AnchorV4DataManager.d;
        if (r8 == null) goto L10;
        r7.put("identifier", r8);
    L10:
        Unit r9 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "ecGlobalProps");
        r0.p = r7;
        ECLynxLoadParam r10 = new ECLynxLoadParam(r0);
        ECLynxCard r11 = this.lynxCard;
        if (r11 == null) goto L13;
        r11.j(r10);
        goto L13
    }

    private final LongContentLabelComponentView bindLynxCard(LynxCardComponent r17, Background r18) {
        this.schema = r17.getSchema();
        String r1 = r17.getSchema();
        if (r1 == null) goto L37;
        String r2 = r17.getData();
        if (r2 == null) goto L9;
        JSONObject r3 = k.w(r2);
        if (r3 == null) goto L9;
        Map<String, Object> r6 = com.bytedance.android.shopping.hybrid.a.b(r3);
    L10:
        Uri.Builder r4 = UriProtector.parse(r1).buildUpon();
        if (r6 == null) goto L16;
        Iterator<Map.Entry<String, Object>> r5 = r6.entrySet().iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<String, Object> r7 = r5.next();
        r4.appendQueryParameter(r7.getKey(), r7.getValue().toString());
    L16:
        String r8 = AnchorV4DataManager.d;
        if (r8 == null) goto L19;
        r4.appendQueryParameter("identifier", r8);
    L19:
        String r9 = r4.build().toString();
        l r10 = this.hybridComponent;
        if (r10 == null) goto L22;
        r10.renderTemplate(r9, r6);
        goto L37
    L22:
        l r11 = ECLiveHybridUtil.b(getContext(), r9, r6, null, null, null, null, false, null, null, false, 4088);
        this.hybridComponent = r11;
        w.a.e(w.b, r11, getContext(), null, 12);
        int r12 = 0;
        if (r18 == null) goto L27;
        Padding r13 = r18.getPadding();
        if (r13 == null) goto L27;
        int r14 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.getTop()));
    L28:
        if (r18 == null) goto L32;
        Padding r15 = r18.getPadding();
        if (r15 == null) goto L32;
        r12 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r15.getBottom()));
    L32:
        int r16 = r17.getHeight();
        if (r16 != null) goto L36;
        r16 = 60;
    L36:
        addHybridView(r14, r12, com.bytedance.android.shopping.extensions.b.b(r16));
        Unit r19 = Unit.INSTANCE;
    L27:
        r14 = 0;
    L9:
        r6 = null;
    L37:
        return this;
    }

    public void configPossibleAction(View r2, Action r3) {
        Intrinsics.checkNotNullParameter(r2, "theView");
        ActionHubAccessor.DefaultImpls.a(this, r2, r3);
    }

    public LongContentLabelComponentView(Context r2, AttributeSet r3, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.actionHub = r4;
        this._$_findViewCache = new LinkedHashMap();
        this.radiusHelper = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.root$delegate = LazyKt.lazy(new LongContentLabelComponentView$root$2(this));
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564609, this, true);
        this.cardLifeCycle = new b(this);
    }

    private final void addHybridView(int r4, int r5, int r6) {
        l r0 = this.hybridComponent;
        if (r0 == null) goto L7;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L7;
        getRoot().addView(r1, new LinearLayout.LayoutParams(-1, (r6 - r5) - r4));
        return;
    L7:
        setVisibility(8);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.radiusHelper.c(r1, r2);
    }

    public /* synthetic */ LongContentLabelComponentView(Context r2, AttributeSet r3, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
