package com.bytedance.dux.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.amap.api.col.s.ce;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import em4.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u00042345J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/bytedance/dux/selection/DuxSelectionPanelView;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/dux/selection/DuxSelectionPanelView$e;", "items", "", "setItems", "", "height", "setScrollViewHeight", "Lcom/bytedance/dux/selection/DuxSelectionPanelView$d;", "loader", "setIconLoader", "Landroid/view/View;", "h", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "bottomDivider", "", "Lcom/bytedance/dux/selection/DuxSelectionPanelItemView;", RXScreenCaptureService.KEY_INDEX, "Ljava/util/List;", "getItemViews", "()Ljava/util/List;", "itemViews", "", ce.f26395j, "Z", "getAdaptLargeFont", "()Z", "setAdaptLargeFont", "(Z)V", "adaptLargeFont", "Lcom/bytedance/dux/selection/DuxSingleSelectionPanelView$a;", "onItemSelectListener", "Lcom/bytedance/dux/selection/DuxSingleSelectionPanelView$a;", "getOnItemSelectListener", "()Lcom/bytedance/dux/selection/DuxSingleSelectionPanelView$a;", "setOnItemSelectListener", "(Lcom/bytedance/dux/selection/DuxSingleSelectionPanelView$a;)V", "Lcom/bytedance/dux/selection/DuxMultiSelectionPanelView$a;", "onMultiItemSelectListener", "Lcom/bytedance/dux/selection/DuxMultiSelectionPanelView$a;", "getOnMultiItemSelectListener", "()Lcom/bytedance/dux/selection/DuxMultiSelectionPanelView$a;", "setOnMultiItemSelectListener", "(Lcom/bytedance/dux/selection/DuxMultiSelectionPanelView$a;)V", "b", "c", "d", "e", "dux_release"}, k = 1, mv = {1, 7, 1})
public abstract class DuxSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DuxComponent f205590k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f205592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f205593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f205594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f205595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f205596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f205597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f205598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<DuxSelectionPanelItemView> f205599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f205600j;

    public static final class a implements jm4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxSelectionPanelView f205601a;

        public a(DuxSelectionPanelView r100) {
            this.f205601a = r100;
        }

        @Override // jm4.b
        public final void a(hm4.d r100) {
            Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
            DuxSelectionPanelView r101 = this.f205601a;
            DuxComponent r102 = DuxSelectionPanelView.f205590k;
            r101.a();
        }
    }

    public static final class b {
    }

    public static final class c implements d {
        public c() {
        }

        @Override // com.bytedance.dux.selection.DuxSelectionPanelView.d
        public final void a(DuxImageView r100, e r101, Context r102) {
            Intrinsics.checkNotNullParameter(r100, "iconImageView");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            r100.setImageDrawable(r101.f205602a);
        }
    }

    public interface d {
        void a(DuxImageView r100, e r101, Context r102);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f205602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f205603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f205604c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f205602a, r101.f205602a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f205603b, r101.f205603b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f205604c, r101.f205604c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Drawable r100 = this.f205602a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f205603b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f205604c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectionItemData(iconDrawable=" + this.f205602a + ", title=" + this.f205603b + ", iconUrl=" + this.f205604c + ')';
        }

        public e() {
            this.f205602a = null;
            this.f205603b = null;
            this.f205604c = null;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxSelectionPanelView f205605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DuxSelectionPanelItemView f205606b;

        public f(DuxSelectionPanelView r100, DuxSelectionPanelItemView r101, int r102) {
            this.f205605a = r100;
            this.f205606b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f205605a.c() == false) goto L8;
            DuxSelectionPanelItemView r101 = this.f205606b;
            r101.setItemSelected(!r101.R5());
            this.f205605a.c();
            if (this.f205606b.R5() == false) goto L16;
            this.f205605a.getClass();
            return;
        L16:
            return;
        L8:
            if (this.f205606b.R5() == true) goto L13;
            Iterator<T> r102 = this.f205605a.getItemViews().iterator();
        L11:
            if (r102.hasNext() == false) goto L13;
            DuxSelectionPanelItemView r103 = (DuxSelectionPanelItemView) r102.next();
            r103.setItemSelected(Intrinsics.areEqual(r100, r103));
        L13:
            this.f205605a.c();
        }
    }

    public DuxSelectionPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 30);
    }

    public DuxSelectionPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public DuxSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    public abstract void b();

    public abstract boolean c();

    public final DuxSingleSelectionPanelView.a getOnItemSelectListener() {
        return null;
    }

    public final DuxMultiSelectionPanelView.a getOnMultiItemSelectListener() {
        return null;
    }

    public final void setOnItemSelectListener(DuxSingleSelectionPanelView.a r100) {
    }

    public final void setOnMultiItemSelectListener(DuxMultiSelectionPanelView.a r100) {
    }

    static {
        f205590k = DuxComponent.SELECTION;
    }

    public final void a() {
        Map<PadAdaptScene, Boolean> r100 = DuxConfig.f204897a;
        if (DuxConfig.a(PadAdaptScene.SELECTION_PANEL) == true) goto L5;
        return;
    L5:
        this.f205595e.setMinHeight(0);
        this.f205595e.setMinimumHeight(0);
        this.f205597g = false;
        int r101 = im4.a.f490534a;
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        hm4.a r103 = gm4.a.d(r102);
        if (MathKt.roundToInt(TypedValue.applyDimension(1, r103.f485915b, im4.a.a(Resources.getSystem()))) < MathKt.roundToInt(TypedValue.applyDimension(1, 705, im4.a.a(Resources.getSystem())))) goto L8;
        int r104 = -1;
    L9:
        if (r104 != (-1)) goto L11;
        b();
        return;
    L11:
        setScrollViewHeight(r104);
        return;
    L8:
        r104 = (int) ((((double) MathKt.roundToInt(TypedValue.applyDimension(1, r103.f485915b, im4.a.a(Resources.getSystem())))) * 0.73d) - ((double) MathKt.roundToInt(TypedValue.applyDimension(1, 138, im4.a.a(Resources.getSystem())))));
        goto L9
    }

    public final View getBottomDivider() {
        View r100 = this.f205598h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
        return null;
    }

    public final boolean getAdaptLargeFont() {
        return this.f205600j;
    }

    public final List<DuxSelectionPanelItemView> getItemViews() {
        return this.f205599i;
    }

    public final void setAdaptLargeFont(boolean r100) {
        this.f205600j = r100;
    }

    public final void setBottomDivider(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f205598h = r100;
    }

    public final void setIconLoader(d r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.f205596f = r100;
    }

    public final void setItems(List<e> r110) {
        Intrinsics.checkNotNullParameter(r110, "items");
        Iterator<T> r111 = r110.iterator();
        int r100 = 0;
    L4:
        if (r111.hasNext() == false) goto L15;
        Object r101 = r111.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        e r103 = (e) r101;
        List<DuxSelectionPanelItemView> r104 = this.f205599i;
        DuxSelectionPanelItemView r112 = new DuxSelectionPanelItemView(getContext(), null, Boolean.valueOf(this.f205600j), this.f205591a, 6);
        r112.setSelectMode(c());
        if (r103.f205602a == null) goto L11;
    L13:
        n.f(r112.getIconView());
        this.f205596f.a(r112.getIconView(), r103, r112.getContext());
    L14:
        r112.getTextView().setText(r103.f205603b);
        r112.setOnClickListener(new f(this, r112, r100));
        this.f205592b.addView(r112);
        ((ArrayList) r104).add(r112);
        r100 = r102;
        goto L4
    L11:
        if (TextUtils.isEmpty(r103.f205604c) == false) goto L13;
        n.e(r112.getIconView());
        goto L14
    L15:
        n.e(((DuxSelectionPanelItemView) CollectionsKt.last(this.f205599i)).f205588g);
        b();
        a();
    }

    public final void setScrollViewHeight(int r100) {
        if (this.f205600j == false) goto L11;
        ViewGroup.LayoutParams r101 = this.f205594d.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L8:
        if (r102 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r102).width = -1;
        ((ViewGroup.MarginLayoutParams) r102).height = r100;
    L13:
        if (((ArrayList) this.f205599i).size() < 4) goto L15;
    L17:
        this.f205594d.setLayoutParams(r102);
        return;
    L15:
        if (this.f205597g == false) goto L17;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-1, -2);
        r103.topToBottom = -1;
        r103.bottomToBottom = 0;
        this.f205593c.setLayoutParams(r103);
        r102.bottomToTop = -1;
        goto L17
    L10:
        r102 = new ConstraintLayout.LayoutParams(-1, r100);
        goto L13
    L7:
        r102 = null;
        goto L8
    L11:
        r102 = new ConstraintLayout.LayoutParams(-1, r100);
        goto L13
    }

    public /* synthetic */ DuxSelectionPanelView(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = null;
    L5:
        AttributeSet r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        int r104 = R.style.DuxSelectionPanel;
    L9:
        this(r100, r103, r104, null, false);
        return;
    L8:
        r104 = r102;
        goto L9
    }

    public DuxSelectionPanelView(Context r100, AttributeSet r101, int r102, Boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new ContextThemeWrapper(r100, r102), r101);
        this.f205591a = r104;
        this.f205596f = new c();
        this.f205597g = true;
        this.f205599i = new ArrayList();
        Lazy r105 = DuxLargeFontHelper.f205243a;
        this.f205600j = DuxLargeFontHelper.a(f205590k, r103);
        LinearLayout.inflate(getContext(), R.layout.dux_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        LinearLayout r106 = (LinearLayout) findViewById(R.id.item_container);
        this.f205592b = r106;
        this.f205593c = (FrameLayout) findViewById(R.id.btn_container);
        NestedScrollView r107 = (NestedScrollView) findViewById(R.id.item_scroll_view);
        this.f205594d = r107;
        this.f205595e = (ConstraintLayout) findViewById(R.id.root_constraint);
        setBottomDivider(findViewById(R.id.bottom_divider));
        if (this.f205600j == false) goto L5;
        r106.setPadding(0, 0, 0, 0);
    L5:
        DuxBreakPointController r108 = gm4.a.f481672a;
        gm4.a.b(new hm4.c(r107), new a(this));
    }
}
