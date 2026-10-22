package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0003123B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0007¢\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00064"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "", "Lcom/obric/oui/selection/OSelectionPanelView$c;", "items", "", "setItems", "", "height", "setScrollViewHeight", "Lcom/obric/oui/selection/OSelectionPanelView$b;", "loader", "setIconLoader", "Landroid/view/View;", ce.f26391f, "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "bottomDivider", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "h", "Ljava/util/List;", "getItemViews", "()Ljava/util/List;", "itemViews", "Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "onItemSelectListener", "Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "getOnItemSelectListener", "()Lcom/obric/oui/selection/OSingleSelectionPanelView$a;", "setOnItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$a;)V", "Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "onMultiItemSelectListener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "getOnMultiItemSelectListener", "()Lcom/obric/oui/selection/OMultiSelectionPanelView$a;", "setOnMultiItemSelectListener", "(Lcom/obric/oui/selection/OMultiSelectionPanelView$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f402780i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f402781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f402782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f402783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f402784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f402785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f402786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f402787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<OSelectionPanelItemView> f402788h;

    public static final class a implements b {
        public a() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.b
        public final void a(ImageView r100, c r101, Context r102) {
            Intrinsics.checkNotNullParameter(r100, "iconImageView");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            r100.setImageDrawable(r101.f402789a);
        }
    }

    public interface b {
        void a(ImageView r100, c r101, Context r102);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f402789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f402790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f402791c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f402789a, r101.f402789a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f402790b, r101.f402790b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f402791c, r101.f402791c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Drawable r100 = this.f402789a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f402790b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f402791c;
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
            return "SelectionItemData(iconDrawable=" + this.f402789a + ", title=" + this.f402790b + ", iconUrl=" + this.f402791c + ')';
        }

        public c() {
            this.f402789a = null;
            this.f402790b = null;
            this.f402791c = null;
        }
    }

    public OSelectionPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSelectionPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract boolean b();

    public final OSingleSelectionPanelView.a getOnItemSelectListener() {
        return null;
    }

    public final OMultiSelectionPanelView.a getOnMultiItemSelectListener() {
        return null;
    }

    public final void setOnItemSelectListener(OSingleSelectionPanelView.a r100) {
    }

    public final void setOnMultiItemSelectListener(OMultiSelectionPanelView.a r100) {
    }

    public final View getBottomDivider() {
        View r100 = this.f402787g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
        return null;
    }

    public final List<OSelectionPanelItemView> getItemViews() {
        return this.f402788h;
    }

    public final void setBottomDivider(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402787g = r100;
    }

    public final void setIconLoader(b r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.f402785e = r100;
    }

    public final void setItems(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Iterator<T> r101 = r100.iterator();
        final int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L19;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        c r105 = (c) r103;
        List<OSelectionPanelItemView> r106 = getItemViews();
        final OSelectionPanelItemView r107 = new OSelectionPanelItemView(getContext(), null, 6);
        r107.setSelectMode(b());
        boolean r108 = this.f402781a;
        r107.f402778o = r108;
        if (r108 == false) goto L11;
        r107.setSelectMode(r107.f402771h);
    L13:
        if (r105.f402789a == null) goto L15;
    L17:
        j.f(r107.getIconView());
        this.f402785e.a(r107.getIconView(), r105, r107.getContext());
    L18:
        r107.getTextView().setText(r105.f402790b);
        r107.setOnClickListener(new mma.b(this, r107, r102));
        this.f402782b.addView(r107);
        r106.add(r107);
        r102 = r104;
        goto L4
    L15:
        if (TextUtils.isEmpty(r105.f402791c) == false) goto L17;
        j.e(r107.getIconView());
        goto L18
    L11:
        j.e(r107.f402776m);
        j.e(r107.f402775l);
        goto L13
    L19:
        j.e(((OSelectionPanelItemView) CollectionsKt.last(this.f402788h)).f402777n);
        a();
    }

    public final void setScrollViewHeight(int r100) {
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-1, r100);
        if (((ArrayList) this.f402788h).size() < 4) goto L5;
    L7:
        this.f402784d.setLayoutParams(r101);
        return;
    L5:
        if (this.f402786f == false) goto L7;
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, -2);
        r102.topToBottom = -1;
        r102.bottomToBottom = 0;
        this.f402783c.setLayoutParams(r102);
        r101.bottomToTop = -1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new ContextThemeWrapper(r100, r102), r101);
        this.f402781a = true;
        this.f402785e = new a();
        this.f402786f = true;
        this.f402788h = new ArrayList();
        LinearLayout.inflate(getContext(), R.layout.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        this.f402782b = (LinearLayout) findViewById(R.id.item_container);
        this.f402783c = (FrameLayout) findViewById(R.id.btn_container);
        this.f402784d = (NestedScrollView) findViewById(R.id.item_scroll_view);
        ConstraintLayout r103 = (ConstraintLayout) findViewById(R.id.root_constraint);
        setBottomDivider(findViewById(R.id.bottom_divider));
    }

    public /* synthetic */ OSelectionPanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.style.OSelectionPanel;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
