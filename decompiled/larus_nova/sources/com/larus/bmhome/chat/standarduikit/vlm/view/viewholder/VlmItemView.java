package com.larus.bmhome.chat.standarduikit.vlm.view.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ao8.e;
import co8.b;
import co8.c;
import co8.d;
import co8.i;
import co8.j;
import co8.k;
import co8.m;
import co8.n;
import co8.o;
import co8.p;
import co8.q;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.bmhome.chat.standarduikit.vlm.view.l;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusVlmImageItemViewMergeBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 N2\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ³\u0001\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00112:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u000202\u0018\u0001082\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>2:\b\u0002\u0010?\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(@\u0012\u0004\u0012\u000202\u0018\u000108¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J!\u0010D\u001a\u0002022\u0006\u0010C\u001a\u0002052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0003J\u0010\u0010H\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J^\u0010J\u001a\u0002022\u0006\u00103\u001a\u00020\u00072:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u000202\u0018\u0001082\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>H\u0002J:\u0010K\u001a\u0002022\b\u0010L\u001a\u0004\u0018\u0001052\b\b\u0002\u0010M\u001a\u00020\u00072\u001c\b\u0002\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u000202\u0018\u000108H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b \u0010\u0018R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010/¨\u0006O"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/vlm/view/viewholder/VlmItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewMergeBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewMergeBinding;", "binding$delegate", "Lkotlin/Lazy;", "enableNewStyle", "", "getEnableNewStyle", "()Z", "enableNewStyle$delegate", "sourceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getSourceView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "sourceView$delegate", "moreImageSize", "Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "getMoreImageSize", "()Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "moreImageSize$delegate", "mainImage", "getMainImage", "mainImage$delegate", "maskView", "Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "getMaskView", "()Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "maskView$delegate", "descriptionTitle", "Landroid/widget/TextView;", "getDescriptionTitle", "()Landroid/widget/TextView;", "descriptionTitle$delegate", "videoIcon", "Landroid/view/View;", "getVideoIcon", "()Landroid/view/View;", "videoIcon$delegate", "bindView", "", "position", "vlmRenderInfo", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;", "enableShimmer", "onClickCard", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/util/Size;", "size", "onLongClickCard", "Lkotlin/Function0;", "onMobCardShow", "itemSize", "(ILcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "setupVideoIcon", "vlmVlmRenderInfo", "setupLoadMainImage", "(Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;Ljava/lang/Boolean;)V", "setupSourceImage", "setupMoreImageIcon", "setupVideoCaptionView", "setupLayout", "setupLayoutClick", "setupCardShow", "imageItem", "index", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f309928i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f309931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f309932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f309933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f309934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f309935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f309936h;

    public static final class a {
    }

    static {
    }

    public VlmItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VlmItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusVlmImageItemViewMergeBinding getBinding() {
        return (LarusVlmImageItemViewMergeBinding) this.f309929a.getValue();
    }

    private final TextView getDescriptionTitle() {
        return (TextView) this.f309935g.getValue();
    }

    private final boolean getEnableNewStyle() {
        return ((Boolean) this.f309930b.getValue()).booleanValue();
    }

    private final SimpleDraweeView getMainImage() {
        return (SimpleDraweeView) this.f309933e.getValue();
    }

    private final ShimmerMaskView getMaskView() {
        return (ShimmerMaskView) this.f309934f.getValue();
    }

    private final RoundTextView getMoreImageSize() {
        return (RoundTextView) this.f309932d.getValue();
    }

    private final SimpleDraweeView getSourceView() {
        return (SimpleDraweeView) this.f309931c.getValue();
    }

    private final View getVideoIcon() {
        return (View) this.f309936h.getValue();
    }

    public static View S5(VlmItemView r100) {
        return r100.getBinding().f358833g;
    }

    public static SimpleDraweeView T5(VlmItemView r100) {
        return r100.getBinding().f358828b;
    }

    public static ShimmerMaskView U5(VlmItemView r100) {
        return r100.getBinding().f358829c;
    }

    public static TextView V5(VlmItemView r100) {
        return r100.getBinding().f358832f;
    }

    public static SimpleDraweeView Y5(VlmItemView r100) {
        return r100.getBinding().f358831e;
    }

    public static RoundTextView k6(VlmItemView r100) {
        return r100.getBinding().f358830d;
    }

    private final void setupLayout(l r100) {
        e1.x(getBinding().f358827a);
        View r101 = getBinding().f358827a;
        Size r102 = r100.f309918c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getWidth();
    L6:
        Size r105 = r100.f309918c;
        if (r105 == null) goto L9;
        r103 = r105.getHeight();
    L9:
        r101.setLayoutParams(new ViewGroup.LayoutParams(r104, r103));
        return;
    L5:
        r104 = 0;
        goto L6
    }

    private final void setupMoreImageIcon(l r100) {
        Integer r101 = r100.f309920e;
        if (r101 != null) goto L5;
    L9:
        e1.o(getMoreImageSize());
        return;
    L5:
        if (r101.intValue() <= 0) goto L9;
        e1.x(getMoreImageSize());
        getMoreImageSize().setText(Marker.ANY_NON_NULL_MARKER + r100.f309920e);
    }

    private final void setupSourceImage(l r100) {
        String r101 = r100.f309921f;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        e1.o(getSourceView());
        return;
    L12:
        e1.x(getSourceView());
        e.c(getSourceView(), r100, r100.f309921f, null, null, null);
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    private final void setupVideoCaptionView(l r100) {
        String r101 = r100.f309919d;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        e1.o(getDescriptionTitle());
        return;
    L12:
        e1.x(getDescriptionTitle());
        getDescriptionTitle().setText(r100.f309919d);
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    private final void setupVideoIcon(l r100) {
        if (r100.f309923h != RenderType.Picture) goto L6;
        e1.o(getVideoIcon());
        return;
    L6:
        e1.x(getVideoIcon());
    }

    public static Unit Z5(Boolean r100, VlmItemView r101) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.getMaskView().a();
    L6:
        return Unit.INSTANCE;
    }

    public static Unit b6(Boolean r100, VlmItemView r101) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.getMaskView().c();
    L6:
        return Unit.INSTANCE;
    }

    public static Unit i6(Boolean r100, VlmItemView r101) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.getMaskView().a();
    L6:
        return Unit.INSTANCE;
    }

    public VlmItemView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f309929a = LazyKt.lazy(new co8.l(r100, this));
        this.f309930b = LazyKt.lazy(new m());
        this.f309931c = LazyKt.lazy(new n(this));
        this.f309932d = LazyKt.lazy(new o(this));
        this.f309933e = LazyKt.lazy(new p(this));
        this.f309934f = LazyKt.lazy(new q(this));
        this.f309935g = LazyKt.lazy(new b(this));
        this.f309936h = LazyKt.lazy(new c(this));
    }

    public static void c6(Function2 r100, int r101, VlmItemView r102) {
        if (r100 == null) goto L5;
        r100.invoke(Integer.valueOf(r101), new Size(r102.getMainImage().getWidth(), r102.getMainImage().getHeight()));
        return;
    }

    public /* synthetic */ VlmItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static Unit R5(Function2 r100, int r101, VlmItemView r102, View r103) {
        Intrinsics.checkNotNullParameter(r103, "it");
        if (r100 == null) goto L6;
        r100.invoke(Integer.valueOf(r101), new Size(r102.getMainImage().getWidth(), r102.getMainImage().getHeight()));
    L6:
        return Unit.INSTANCE;
    }

    public final void n6(final int r100, final l r101, final Boolean r110, final Function2<? super Integer, ? super Size, Unit> r111, final Function0<Boolean> r112, final Function2<? super Integer, ? super Size, Unit> r113) {
        if (r101 != null) goto L5;
        e1.o(getBinding().f358827a);
        return;
    L5:
        setupLayout(r101);
        if (getEnableNewStyle() == false) goto L8;
    L9:
        GenericDraweeHierarchy r102 = getMainImage().getHierarchy();
        RoundingParams r103 = r102.getRoundingParams();
        if (r103 != null) goto L12;
        r103 = new RoundingParams();
    L12:
        r103.setCornersRadius(c7.a(v19.c.b(R.attr.larus_dp_4, null, R.dimen.larus_dp_4)));
        r102.setRoundingParams(r103);
    L13:
        String r104 = r101.f309922g;
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        e.c(getMainImage(), r101, r104, new i(r110, this), new j(r110, this), new k(r110, this));
        setupSourceImage(r101);
        setupMoreImageIcon(r101);
        setupVideoCaptionView(r101);
        setupVideoIcon(r101);
        e1.d(getRootView(), new d(r111, r100, this));
        getRootView().setOnLongClickListener(new co8.e(r112));
        ExposureTrackerExtKt.a(getMainImage(), new co8.a(this, r101, r113, r100));
        return;
    L8:
        if (r101.f309926k == false) goto L13;
        goto L9
    }
}
