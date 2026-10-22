package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0001FB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000bH\u0002J5\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0018\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0004H\u0017J\u001a\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u000fH\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b072\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0003J\"\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<2\u0006\u0010>\u001a\u00020\u000bH\u0002J,\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<2\u0006\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000fH\u0002J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0BH\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000bH\u0002J\u001a\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<H\u0002R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/vlm/view/VLMContainerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/FlowVLMContainerViewInput;", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/FlowVLMContainerViewOutput;", "Lcom/larus/business/markdown/api/view/IMarkdownMarginFreeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableNewStyle", "", "getEnableNewStyle", "()Z", "enableNewStyle$delegate", "Lkotlin/Lazy;", "IMAGE_BETWEEN_MARGIN", "getIMAGE_BETWEEN_MARGIN", "()I", "IMAGE_BETWEEN_MARGIN$delegate", "IMAGE_CONTINAER_MARGIN", "WIDGET_EXTRA_HEIGHT", "spanSize", "Landroid/util/Size;", "haveInit", "vlmImageAdapter", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmImageAdapter;", BdpAppEventConstant.PARAMS_OUTPUT, "isExtraHeightForbidden", "reduceMarginStart", "isVideoGroup", "reducedMarginStart", "updateReducedMarginStart", "newValue", "onMarkdownMarginChanged", "", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getWidgetExtraHeight", "getImageContainerMargin", "bindData", "input", "sizeThatFits", "preferredMaxWidth", "tryInitRecyclerView", "setupRecyclerViewItemDecoration", "isSingleImage", "calPaddingValues", "Lkotlin/Pair;", "uiConfig", "Lcom/larus/bmhome/chat/standarduikit/vlm/viewmodel/VLMContainerUIConfig;", "getWidgetHeight", "dynamicGetRestoreView", "", "Landroid/view/View;", "indexInImageList", "doDynamicGetRestoreView", "enableScroll", "generateImageIndexToViewHolderIndex", "", "onUserScrollImage", "userScrollPos", "generateImageViews", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VLMContainerView extends RecyclerView implements nw8.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f309880k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f309883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f309884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f309885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VlmImageAdapter f309886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f309887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f309888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f309889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f309890j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309891a = null;

        static {
            int[] r100 = new int[FlowVLMContainerViewType.values().length];
            r100[FlowVLMContainerViewType.SingleItem.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FlowVLMContainerViewType.MultipleItem.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f309891a = r100;
        }
    }

    static {
    }

    public VLMContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VLMContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final boolean getEnableNewStyle() {
        return ((Boolean) this.f309881a.getValue()).booleanValue();
    }

    private final int getIMAGE_BETWEEN_MARGIN() {
        return ((Number) this.f309882b.getValue()).intValue();
    }

    private final int getWidgetExtraHeight() {
        if (this.f309887g == false) goto L6;
        return 0;
    L6:
        return this.f309884d;
    }

    public final Map<Integer, Integer> y() {
        LinkedHashMap r100 = new LinkedHashMap();
        VlmImageAdapter r101 = this.f309886f;
        if (r101 == null) goto L19;
        List<l> r102 = r101.f309894a;
        if (r102 == null) goto L19;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L19;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        l r107 = (l) r105;
        if (r107.f309923h != RenderType.Picture) goto L18;
        Integer r108 = Integer.valueOf(r104);
        r100.put(Integer.valueOf(r107.f309924i.f309905c), r108);
        Iterator<T> r109 = r107.f309924i.f309906d.iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        r100.put(Integer.valueOf(((Number) r109.next()).intValue()), Integer.valueOf(r104));
    L18:
        r104 = r106;
    L19:
        return r100;
    }

    public final List<Pair<Integer, View>> z() {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r101 = (LinearLayoutManager) r100;
    L6:
        if (r101 == null) goto L8;
        int r102 = r101.findFirstVisibleItemPosition();
        int r103 = r101.findLastVisibleItemPosition();
        ArrayList r104 = new ArrayList();
        if (r102 > r103) goto L30;
    L11:
        RecyclerView.ViewHolder r105 = findViewHolderForAdapterPosition(r102);
        if (r105 == null) goto L29;
        View r106 = r105.itemView;
        if (r106 == null) goto L29;
        VlmImageAdapter r107 = this.f309886f;
        if (r107 == null) goto L27;
        l r108 = (l) CollectionsKt.getOrNull(r107.f309894a, r102);
        if (r108 == null) goto L27;
        if (r108.f309923h != RenderType.Picture) goto L24;
        r104.add(new Pair(Integer.valueOf(r108.f309924i.f309905c), r106));
    L24:
        if (r102 == r103) goto L30;
        r102 = r102 + 1;
    L27:
        return CollectionsKt.emptyList();
    L29:
        return CollectionsKt.emptyList();
    L30:
        return r104;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    private final int getImageContainerMargin() {
        return this.f309883c;
    }

    public static int r(VLMContainerView r100) {
        if (r100.getEnableNewStyle() == false) goto L5;
    L8:
        int r101 = 4;
    L10:
        return c7.b(Integer.valueOf(r101));
    L5:
        if (r100.f309889i == true) goto L8;
        r101 = 8;
        goto L10
    }

    private final void setupRecyclerViewItemDecoration(final boolean r100) {
        addItemDecoration(new AnonymousClass1(r100, this));
    }

    public static final /* synthetic */ int t(VLMContainerView r100) {
        return r100.getIMAGE_BETWEEN_MARGIN();
    }

    public static final /* synthetic */ int u(VLMContainerView r100) {
        return r100.getImageContainerMargin();
    }

    public static Pair w(do8.j r100) {
        if (r100.f469454b == true) goto L6;
        return TuplesKt.to(0, 0);
    L6:
        if (r100.f469455c == false) goto L9;
        return TuplesKt.to(Integer.valueOf(i5.Y()), Integer.valueOf(i5.q()));
    L9:
        if (r100.f469456d == false) goto L12;
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.Y()));
    L12:
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.r0()));
    }

    public final int A(com.larus.bmhome.chat.standarduikit.vlm.view.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        FlowVLMContainerViewType r101 = r100.f309900b;
        int r102 = b.f309891a[r101.ordinal()];
        int r103 = 0;
        if (r102 != 1) goto L5;
    L7:
        l r104 = (l) CollectionsKt.firstOrNull(r100.f309901c);
        if (r104 == null) goto L13;
        Size r105 = r104.f309918c;
        if (r105 == null) goto L13;
        r103 = r105.getHeight();
    L13:
        return r103 + getWidgetExtraHeight();
    L5:
        if (r102 == 2) goto L7;
        return 0;
    }

    public final Size B(com.larus.bmhome.chat.standarduikit.vlm.view.a r100, int r101) {
        int r102 = 0;
        if (r100 == null) goto L5;
        Function0<Integer> r103 = r100.f309902d.f469458f;
        if (r103 == null) goto L9;
        r101 = Math.min(r101, r103.invoke().intValue());
    L9:
        Pair r104 = w(r100.f309902d);
        FlowVLMContainerViewType r105 = r100.f309900b;
        int r106 = b.f309891a[r105.ordinal()];
        if (r106 != 1) goto L12;
    L14:
        l r107 = (l) CollectionsKt.getOrNull(r100.f309901c, 0);
        if (r107 == null) goto L20;
        Size r108 = r107.f309918c;
        if (r108 == null) goto L20;
        r102 = r108.getHeight();
    L20:
        return new Size(r101, ((r102 + getWidgetExtraHeight()) + ((Number) r104.getFirst()).intValue()) + ((Number) r104.getSecond()).intValue());
    L12:
        if (r106 == 2) goto L14;
        return new Size(0, 0);
    L5:
        return new Size(0, 0);
    }

    public final void v(com.larus.bmhome.chat.standarduikit.vlm.view.a r100, final com.larus.bmhome.chat.standarduikit.vlm.view.b r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        do8.j r102 = r100.f309902d;
        this.f309889i = r102.f469457e;
        this.f309887g = r102.f469454b;
        this.f309888h = r102.f469453a;
        Pair r103 = w(r102);
        int r104 = ((Number) r103.getFirst()).intValue();
        int r105 = ((Number) r103.getSecond()).intValue();
        setPaddingRelative(getPaddingStart(), r104, getPaddingEnd(), r105);
        if (this.f309885e == true) goto L8;
        VlmImageAdapter r106 = new VlmImageAdapter();
        this.f309886f = r106;
        setAdapter(r106);
        boolean r107 = false;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ExposeXTrackerExtKt.c(this);
        if (r100.f309900b != FlowVLMContainerViewType.SingleItem) goto L7;
        r107 = true;
    L7:
        setupRecyclerViewItemDecoration(r107);
        this.f309885e = true;
    L8:
        invalidateItemDecorations();
        VlmImageAdapter r108 = this.f309886f;
        if (r108 == null) goto L11;
        List<l> r109 = r100.f309901c;
        Intrinsics.checkNotNullParameter(r109, "vlmVlmRenderInfoList");
        r108.f309894a = r109;
    L11:
        VlmImageAdapter r110 = this.f309886f;
        if (r110 == null) goto L14;
        r110.f309898e = r100.f309899a;
    L14:
        if (r110 == null) goto L16;
        r110.f309895b = new g(this, r101);
    L16:
        if (r110 == null) goto L18;
        r110.f309896c = new h(r101);
    L18:
        if (r110 == null) goto L20;
        r110.f309897d = new i(r101);
    L20:
        if (r110 == null) goto L23;
        r110.notifyDataSetChanged();
        return;
    }

    public final List<Pair<Integer, View>> x(int r100, boolean r101) {
        RecyclerView.LayoutManager r102 = getLayoutManager();
        Integer r103 = null;
        if ((r102 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r104 = (LinearLayoutManager) r102;
    L6:
        Map<Integer, Integer> r105 = y();
        if (r104 == null) goto L9;
        Integer r106 = Integer.valueOf(r104.findFirstCompletelyVisibleItemPosition());
    L10:
        if (r104 == null) goto L12;
        r103 = Integer.valueOf(r104.findLastCompletelyVisibleItemPosition());
    L12:
        if (r106 == null) goto L30;
        if (r103 == null) goto L30;
        Integer r107 = (Integer) ((LinkedHashMap) r105).get(Integer.valueOf(r100));
        if (r107 == null) goto L28;
        int r108 = r107.intValue();
        if (r108 >= r106.intValue()) goto L20;
    L23:
        if (r101 == false) goto L26;
        scrollToPosition(r108);
    L26:
        return z();
    L20:
        if (r108 > r103.intValue()) goto L23;
        return z();
    L28:
        return CollectionsKt.emptyList();
    L30:
        return CollectionsKt.emptyList();
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public VLMContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f309881a = LazyKt.lazy(new d());
        this.f309882b = LazyKt.lazy(new e(this));
        this.f309883c = c7.b(16);
        this.f309884d = c7.b(12);
        new Size(0, 0);
    }

    public /* synthetic */ VLMContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // nw8.a
    public final void k(Integer r100, Integer r101, Integer r110, Integer r111) {
        ViewGroup.LayoutParams r112 = getLayoutParams();
        Integer r102 = null;
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
    L6:
        boolean r103 = true;
        if (getLayoutDirection() != 0) goto L28;
        if (r100 == null) goto L28;
        if (r100.intValue() <= 0) goto L28;
        if (this.f309888h == false) goto L20;
        int r104 = r100.intValue();
        if (this.f309888h == false) goto L28;
        int r114 = Math.max(r104 - this.f309883c, 0);
        if (this.f309890j == r114) goto L28;
        FLogger.f375446a.i("VLMContainerView", "updateReducedMarginStart, margin[" + r104 + "] -> reducedMargin[" + r114 + ']');
        this.f309890j = r114;
        post(new k(this));
        boolean r105 = true;
    L29:
        boolean r115 = false;
    L30:
        if (r101 == null) goto L38;
        if (r113 == null) goto L34;
        r102 = Integer.valueOf(r113.topMargin);
    L34:
        if (Intrinsics.areEqual(r101, r102) == true) goto L38;
        if (r113 == null) goto L37;
        r113.topMargin = r101.intValue();
    L37:
        FLogger.f375446a.i("VLMContainerView", "onMarkdownMarginChanged: top = " + r101);
        r105 = true;
        r115 = true;
    L38:
        if (r115 == false) goto L41;
        requestLayout();
    L41:
        if (r105 == false) goto L44;
        setVisibility(4);
        post(new j(this));
        return;
    L44:
        if (getVisibility() == 4) goto L47;
        r103 = false;
    L47:
        if (r103 == false) goto L51;
        setVisibility(0);
        return;
    L51:
        return;
    L20:
        if (r113 == null) goto L22;
        Integer r116 = Integer.valueOf(r113.leftMargin);
    L24:
        if (Intrinsics.areEqual(r100, r116) == true) goto L28;
        if (r113 == null) goto L27;
        r113.leftMargin = r100.intValue();
    L27:
        FLogger.f375446a.i("VLMContainerView", "onMarkdownMarginChanged: left = " + r100);
        r105 = true;
        r115 = true;
        goto L30
    L22:
        r116 = null;
    L28:
        r105 = false;
        goto L29
    L5:
        r113 = null;
        goto L6
    }
}
