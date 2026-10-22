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
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u000501234B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010,\u001a\u00020-J\b\u0010/\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBoxContainer", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "checkBoxText", "Landroid/widget/TextView;", "colorsRange", "", "", "[Ljava/lang/String;", "selectedColor", "colorRecyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "colorAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter;", "colorUpdateListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;", "getColorUpdateListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;", "setColorUpdateListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$ColorUpdateListener;)V", "onCheckedChangeListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$OnCheckedChangeListener;)V", "initView", "", "updateView", "item", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "updateSelectedColor", "color", "openColorSelection", "checked", "", "setChecked", "getParentViewWidth", "ColorUpdateListener", "OnCheckedChangeListener", "SelectColorAdapter", "SelectColorDecoration", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterPanelColorView extends LinearLayout {
    public LinearLayout a;
    public UDCheckBox b;
    public TextView c;
    public String[] d;
    public String e;
    public BaseRecyclerView f;
    public SelectColorAdapter g;
    public a h;
    public c i;

    public static final class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
        public String[] a;
        public String b;
        public a c;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView$SelectColorAdapter;Landroid/view/View;)V", "outerLayer", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "getOuterLayer", "()Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "setOuterLayer", "(Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;)V", "innerLayer", "getInnerLayer", "setInnerLayer", "isSelected", "", "()Z", "setSelected", "(Z)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ColorViewHolder extends RecyclerView.ViewHolder {
            public final LKUIRoundableLayout a;
            public final LKUIRoundableLayout b;
            public boolean c;

            public ColorViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
                this.a = r2.findViewById(2131381755);
                this.b = r2.findViewById(2131375313);
            }
        }

        public interface a {
            void a(String r1);
        }

        public final int getItemCount() {
            String[] r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.length;
        }

        public SelectColorAdapter() {
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
            ColorViewHolder r11 = (ColorViewHolder) r9;
            Intrinsics.checkNotNullParameter(r11, "holder");
            if (this.a == null) goto L44;
            if (r10 >= 0) goto L6;
            return;
        L6:
            if (r10 >= getItemCount()) goto L46;
            String[] r0 = this.a;
            if (r0 == null) goto L11;
            String r12 = r0[r10];
        L13:
            if (TextUtils.isEmpty(r12) == true) goto L47;
            Resources r1 = ((RecyclerView.ViewHolder) r11).itemView.getContext().getResources();
            boolean r2 = true;
            boolean r3 = StringsKt.equals(r12, this.b, true);
            r11.c = r3;
            LKUIRoundableLayout r4 = r11.a;
            int r5 = 2131100548;
            if (r3 == false) goto L18;
            int r6 = 2131105548;
        L19:
            r4.setBorderColor(r1.getColor(r6));
            LKUIRoundableLayout r7 = r11.b;
            if (r11.c == false) goto L22;
            int r8 = r1.getDimensionPixelSize(2131168326);
        L36:
            float r13 = r8;
        L38:
            r7.setBorderWidthInPx(r13);
            LKUIRoundableLayout r14 = r11.b;
            if (r11.c == true) goto L42;
            r5 = 2131103352;
        L42:
            r14.setBorderColor(r1.getColor(r5));
            LKUIRoundableLayout r15 = r11.b;
            Intrinsics.checkNotNull(r12);
            r15.setBackgroundColor(ColorUtils.h(r12));
            ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new k(r11, r12, this));
            return;
        L22:
            Context r16 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
            boolean r17 = false;
            if (r12 == null) goto L34;
            int r18 = ColorUtils.h(r12);
            boolean r19 = ColorUtils.b(r16);
            if (ColorUtils.e(r18) == false) goto L29;
            if (r19 == false) goto L29;
        L33:
            r17 = r2;
        L29:
            if (ColorUtils.g(r18) == false) goto L32;
            if (r19 == false) goto L33;
        L32:
            r2 = false;
        L34:
            if (r17 == false) goto L37;
            r8 = r1.getDimensionPixelSize(2131168377);
            goto L36
        L37:
            r13 = 0.0f;
            goto L38
        L18:
            r6 = 2131100548;
            goto L19
        L47:
            return;
        L11:
            r12 = null;
            goto L13
        L46:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            View r4 = LayoutInflater.from(r2.getContext()).inflate(2131564559, null);
            Intrinsics.checkNotNull(r4);
            return new ColorViewHolder(r4);
        }
    }

    public interface a {
        void a(String r1);
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    public final class d extends RecyclerView.ItemDecoration {
        public final /* synthetic */ FilterPanelColorView a;

        public d(FilterPanelColorView r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
            Intrinsics.checkNotNullParameter(r3, "outRect");
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r6, "state");
            if (r5.getAdapter() == null) goto L10;
            int r7 = this.a.getContext().getResources().getDimensionPixelSize(2131168336);
            int r0 = (FilterPanelColorView.a(this.a) - (r7 * 7)) / 7;
            int r8 = r5.getChildAdapterPosition(r4);
            int r1 = r0 / 2;
            r3.left = r1;
            r3.right = r1;
            if (r8 >= 7) goto L7;
            int r9 = this.a.getContext().getResources().getDimensionPixelSize(2131168340);
        L8:
            r3.top = r9;
            r3.bottom = this.a.getContext().getResources().getDimensionPixelSize(2131168304);
            return;
        L7:
            r9 = 0;
            goto L8
        }
    }

    static {
    }

    public FilterPanelColorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FilterPanelColorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getParentViewWidth() {
        CommonRecyclerView r0 = this.f;
        View r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r0 = null;
    L6:
        if (r0.getParent() == null) goto L8;
        CommonRecyclerView r1 = this.f;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r1 = null;
    L12:
        Object r3 = r1.getParent();
        if ((r3 instanceof View) == false) goto L15;
        r2 = (View) r3;
    L15:
        if (r2 == null) goto L17;
        int r4 = r2.getWidth();
    L18:
        if (r4 <= 0) goto L21;
        return r4;
    L21:
        return com.bytedance.ee.util.ui.n.w(getContext());
    L17:
        r4 = 0;
        goto L18
    L8:
        return com.bytedance.ee.util.ui.n.w(getContext());
    }

    public final a getColorUpdateListener() {
        return this.h;
    }

    public final c getOnCheckedChangeListener() {
        return this.i;
    }

    public static final /* synthetic */ int a(FilterPanelColorView r0) {
        return r0.getParentViewWidth();
    }

    public final void b(FilterData.FilterOptionItem r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        TextView r0 = this.c;
        SelectColorAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxText");
        r0 = null;
    L5:
        r0.setText(r5.getTitle());
        UDCheckBox r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r2 = null;
    L8:
        r2.setChecked(r5.isSelect());
        this.d = r5.getColors();
        this.e = r5.getColorValue();
        SelectColorAdapter r6 = this.g;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r6 = null;
    L11:
        String[] r3 = this.d;
        String r4 = this.e;
        r6.a = r3;
        r6.b = r4;
        r6.notifyDataSetChanged();
        SelectColorAdapter r7 = this.g;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L15:
        r1.notifyDataSetChanged();
        return;
    L14:
        r1 = r7;
        goto L15
    }

    public final void setChecked(boolean r2) {
        UDCheckBox r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r0 = null;
    L5:
        r0.setChecked(r2);
    }

    public final void setColorUpdateListener(a r1) {
        this.h = r1;
    }

    public final void setOnCheckedChangeListener(c r1) {
        this.i = r1;
    }

    public FilterPanelColorView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        LayoutInflater.from(r6).inflate(2131564558, this, true);
        this.a = (LinearLayout) findViewById(2131365642);
        this.b = findViewById(2131365640);
        this.c = (TextView) findViewById(2131365655);
        UDCheckBox r9 = this.b;
        SelectColorAdapter r0 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r9 = null;
    L5:
        r9.setOnCheckedChangeListener(new vm5.a(this));
        LinearLayout r10 = this.a;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxContainer");
        r10 = null;
    L8:
        r10.setOnClickListener(new l(this));
        View r11 = this.b;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r11 = null;
    L11:
        r11.setOnClickListener(new m(this));
        RecyclerView r12 = (BaseRecyclerView) findViewById(2131367180);
        this.f = r12;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r12 = null;
    L14:
        r12.setLayoutManager(new GridLayoutManager(getContext(), 7, 1, false));
        RecyclerView r13 = this.f;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r13 = null;
    L17:
        r13.addItemDecoration(new d(this));
        this.g = new SelectColorAdapter();
        RecyclerView r14 = this.f;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r14 = null;
    L20:
        SelectColorAdapter r15 = this.g;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r15 = null;
    L23:
        r14.setAdapter(r15);
        SelectColorAdapter r16 = this.g;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L27:
        r0.c = new n(this);
        return;
    L26:
        r0 = r16;
        goto L27
    }

    public /* synthetic */ FilterPanelColorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
