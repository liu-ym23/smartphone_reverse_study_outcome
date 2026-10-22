package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u000501234B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010,\u001a\u00020-J\b\u0010/\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBoxContainer", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "checkBoxText", "Landroid/widget/TextView;", "colorsRange", "", "", "[Ljava/lang/String;", "selectedColor", "colorRecyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "colorAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter;", "colorUpdateListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;", "getColorUpdateListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;", "setColorUpdateListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;)V", "onCheckedChangeListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;)V", "initView", "", "updateView", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "updateSelectedColor", "color", "openColorSelection", "checked", "", "setChecked", "getParentViewWidth", "ColorUpdateListener", "OnCheckedChangeListener", "SelectColorAdapter", "SelectColorDecoration", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterPanelColorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f237695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDCheckBox f237696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f237697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f237698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f237699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseRecyclerView f237700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SelectColorAdapter f237701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f237702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f237703i;

    public static final class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f237704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f237705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f237706c;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter;Landroid/view/View;)V", "outerLayer", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "getOuterLayer", "()Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "setOuterLayer", "(Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;)V", "innerLayer", "getInnerLayer", "setInnerLayer", "isSelected", "", "()Z", "setSelected", "(Z)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ColorViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LKUIRoundableLayout f237707a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final LKUIRoundableLayout f237708b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f237709c;

            public ColorViewHolder(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
                this.f237707a = (LKUIRoundableLayout) r100.findViewById(R.id.outer_layer);
                this.f237708b = (LKUIRoundableLayout) r100.findViewById(R.id.inner_layer);
            }
        }

        public interface a {
            void a(String r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            String[] r100 = this.f237704a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.length;
        }

        public SelectColorAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
            ColorViewHolder r101 = (ColorViewHolder) r100;
            Intrinsics.checkNotNullParameter(r101, "holder");
            if (this.f237704a == null) goto L44;
            if (r110 >= 0) goto L6;
            return;
        L6:
            if (r110 >= getItemCount()) goto L46;
            String[] r102 = this.f237704a;
            if (r102 == null) goto L11;
            String r111 = r102[r110];
        L13:
            if (TextUtils.isEmpty(r111) == true) goto L47;
            Resources r103 = r101.itemView.getContext().getResources();
            boolean r104 = true;
            boolean r105 = StringsKt.equals(r111, this.f237705b, true);
            r101.f237709c = r105;
            LKUIRoundableLayout r106 = r101.f237707a;
            int r107 = R.color.bg_body;
            if (r105 == false) goto L18;
            int r108 = R.color.primary_fill_default;
        L19:
            r106.setBorderColor(r103.getColor(r108));
            LKUIRoundableLayout r109 = r101.f237708b;
            if (r101.f237709c == false) goto L22;
            int r112 = r103.getDimensionPixelSize(R.dimen.space_kit_len_2);
        L36:
            float r113 = r112;
        L38:
            r109.setBorderWidthInPx(r113);
            LKUIRoundableLayout r114 = r101.f237708b;
            if (r101.f237709c == true) goto L42;
            r107 = R.color.line_border_component;
        L42:
            r114.setBorderColor(r103.getColor(r107));
            LKUIRoundableLayout r115 = r101.f237708b;
            Intrinsics.checkNotNull(r111);
            r115.setBackgroundColor(ColorUtils.h(r111));
            r101.itemView.setOnClickListener(new k(r101, r111, this));
            return;
        L22:
            Context r116 = r101.itemView.getContext();
            boolean r117 = false;
            if (r111 == null) goto L34;
            int r118 = ColorUtils.h(r111);
            boolean r119 = ColorUtils.b(r116);
            if (ColorUtils.e(r118) == false) goto L29;
            if (r119 == false) goto L29;
        L33:
            r117 = r104;
        L29:
            if (ColorUtils.g(r118) == false) goto L32;
            if (r119 == false) goto L33;
        L32:
            r104 = false;
        L34:
            if (r117 == false) goto L37;
            r112 = r103.getDimensionPixelSize(R.dimen.space_kit_len_half);
            goto L36
        L37:
            r113 = 0.0f;
            goto L38
        L18:
            r108 = R.color.bg_body;
            goto L19
        L47:
            return;
        L11:
            r111 = null;
            goto L13
        L46:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_filter_select_color_item, null);
            Intrinsics.checkNotNull(r102);
            return new ColorViewHolder(r102);
        }
    }

    public interface a {
        void a(String r100);
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    public final class d extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterPanelColorView f237710a;

        public d(FilterPanelColorView r100) {
            this.f237710a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            if (r102.getAdapter() == null) goto L10;
            int r104 = this.f237710a.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_34);
            int r105 = (FilterPanelColorView.a(this.f237710a) - (r104 * 7)) / 7;
            int r106 = r102.getChildAdapterPosition(r101);
            int r107 = r105 / 2;
            r100.left = r107;
            r100.right = r107;
            if (r106 >= 7) goto L7;
            int r108 = this.f237710a.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_4);
        L8:
            r100.top = r108;
            r100.bottom = this.f237710a.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_12);
            return;
        L7:
            r108 = 0;
            goto L8
        }
    }

    static {
    }

    public FilterPanelColorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FilterPanelColorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getParentViewWidth() {
        BaseRecyclerView r100 = this.f237700f;
        View r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r100 = null;
    L6:
        if (r100.getParent() == null) goto L8;
        BaseRecyclerView r102 = this.f237700f;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r102 = null;
    L12:
        Object r103 = r102.getParent();
        if ((r103 instanceof View) == false) goto L15;
        r101 = (View) r103;
    L15:
        if (r101 == null) goto L17;
        int r104 = r101.getWidth();
    L18:
        if (r104 <= 0) goto L21;
        return r104;
    L21:
        return com.bytedance.ee.util.ui.n.w(getContext());
    L17:
        r104 = 0;
        goto L18
    L8:
        return com.bytedance.ee.util.ui.n.w(getContext());
    }

    public final a getColorUpdateListener() {
        return this.f237702h;
    }

    public final c getOnCheckedChangeListener() {
        return this.f237703i;
    }

    public static final /* synthetic */ int a(FilterPanelColorView r100) {
        return r100.getParentViewWidth();
    }

    public final void b(FilterData.FilterOptionItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        TextView r101 = this.f237697c;
        SelectColorAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxText");
        r101 = null;
    L5:
        r101.setText(r100.getTitle());
        UDCheckBox r103 = this.f237696b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r103 = null;
    L8:
        r103.setChecked(r100.isSelect());
        this.f237698d = r100.getColors();
        this.f237699e = r100.getColorValue();
        SelectColorAdapter r104 = this.f237701g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r104 = null;
    L11:
        String[] r105 = this.f237698d;
        String r106 = this.f237699e;
        r104.f237704a = r105;
        r104.f237705b = r106;
        r104.notifyDataSetChanged();
        SelectColorAdapter r107 = this.f237701g;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L15:
        r102.notifyDataSetChanged();
        return;
    L14:
        r102 = r107;
        goto L15
    }

    public final void setChecked(boolean r100) {
        UDCheckBox r101 = this.f237696b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r101 = null;
    L5:
        r101.setChecked(r100);
    }

    public final void setColorUpdateListener(a r100) {
        this.f237702h = r100;
    }

    public final void setOnCheckedChangeListener(c r100) {
        this.f237703i = r100;
    }

    public FilterPanelColorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.sheet_filter_panel_color_view, this, true);
        this.f237695a = (LinearLayout) findViewById(R.id.checkbox_container);
        this.f237696b = (UDCheckBox) findViewById(R.id.checkbox);
        this.f237697c = (TextView) findViewById(R.id.checkbox_text);
        UDCheckBox r103 = this.f237696b;
        SelectColorAdapter r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r103 = null;
    L5:
        r103.setOnCheckedChangeListener(new vm5.a(this));
        LinearLayout r105 = this.f237695a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxContainer");
        r105 = null;
    L8:
        r105.setOnClickListener(new l(this));
        UDCheckBox r106 = this.f237696b;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r106 = null;
    L11:
        r106.setOnClickListener(new m(this));
        BaseRecyclerView r107 = (BaseRecyclerView) findViewById(R.id.color_recycler_view);
        this.f237700f = r107;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r107 = null;
    L14:
        r107.setLayoutManager(new GridLayoutManager(getContext(), 7, 1, false));
        BaseRecyclerView r108 = this.f237700f;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r108 = null;
    L17:
        r108.addItemDecoration(new d(this));
        this.f237701g = new SelectColorAdapter();
        BaseRecyclerView r109 = this.f237700f;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r109 = null;
    L20:
        SelectColorAdapter r110 = this.f237701g;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r110 = null;
    L23:
        r109.setAdapter(r110);
        SelectColorAdapter r111 = this.f237701g;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L27:
        r104.f237706c = new n(this);
        return;
    L26:
        r104 = r111;
        goto L27
    }

    public /* synthetic */ FilterPanelColorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
