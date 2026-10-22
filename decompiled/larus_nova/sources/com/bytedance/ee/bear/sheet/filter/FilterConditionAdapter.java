package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005)*+,-B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J#\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "filterActionListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "getFilterActionListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "setFilterActionListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemViewType", "observeSelectedPosition", "clickEditorAction", "value", "", "", "(I[Ljava/lang/String;)V", "notifyKeyboardClosed", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "BaseViewHolder", "RangeViewHolder", "SingleViewHolder", "OnFilterActionListener", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterConditionAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f237671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FilterData.FilterOptionItem> f237672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f237673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f237674d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "checkBoxContainer", "Landroid/widget/LinearLayout;", "getCheckBoxContainer", "()Landroid/widget/LinearLayout;", "setCheckBoxContainer", "(Landroid/widget/LinearLayout;)V", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setCheckBox", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "checkBoxText", "Landroid/widget/TextView;", "getCheckBoxText", "()Landroid/widget/TextView;", "setCheckBoxText", "(Landroid/widget/TextView;)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class BaseViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f237675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UDCheckBox f237676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f237677c;

        public BaseViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f237675a = (LinearLayout) r100.findViewById(R.id.filter_value_check_box_container);
            this.f237676b = (UDCheckBox) r100.findViewById(R.id.filter_value_check_box);
            this.f237677c = (TextView) r100.findViewById(R.id.filter_value_check_box_text);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$RangeViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "rangeInputView", "getRangeInputView", "()Landroid/view/View;", "setRangeInputView", "(Landroid/view/View;)V", "rangeTextLeft", "Landroid/widget/TextView;", "getRangeTextLeft", "()Landroid/widget/TextView;", "setRangeTextLeft", "(Landroid/widget/TextView;)V", "rangeTextRight", "getRangeTextRight", "setRangeTextRight", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RangeViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f237678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f237679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f237680f;

        public RangeViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f237678d = r100.findViewById(R.id.range_input);
            this.f237679e = (TextView) r100.findViewById(R.id.range_input_text_left);
            this.f237680f = (TextView) r100.findViewById(R.id.range_input_text_right);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$SingleViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "singleText", "Landroid/widget/TextView;", "getSingleText", "()Landroid/widget/TextView;", "setSingleText", "(Landroid/widget/TextView;)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SingleViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f237681d;

        public SingleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f237681d = (TextView) r100.findViewById(R.id.single_input_text);
        }
    }

    public static final class a {
    }

    public interface b {
        void c60();

        void sK(String r100, String[] r101);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f237672b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (Intrinsics.areEqual(((FilterData.FilterOptionItem) ListProtector.get(this.f237672b, r100)).getId(), "noCondition") == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(((FilterData.FilterOptionItem) ListProtector.get(this.f237672b, r100)).getType(), FilterData.FilterOptionItem.Type.RANGE) == false) goto L8;
        return 1;
    L8:
        return 2;
    }

    public FilterConditionAdapter(Context r100, List<FilterData.FilterOptionItem> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "valueList");
        this.f237671a = r100;
        this.f237672b = r101;
        this.f237673c = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        FilterData.FilterOptionItem r103 = (FilterData.FilterOptionItem) ListProtector.get(this.f237672b, r101);
        if ((r102 instanceof RangeViewHolder) == false) goto L12;
        RangeViewHolder r104 = (RangeViewHolder) r102;
        r104.f237676b.setOnCheckedChangeListener(new c(r104, this, r101));
        r104.f237675a.setOnClickListener(new d(r104));
        String[] r105 = r103.getConditionValue();
        if (r105 != null) goto L7;
    L10:
        r104.f237679e.setOnEditorActionListener(new e(this));
        r104.f237680f.setOnEditorActionListener(new f(this));
    L24:
        r102.f237677c.setText(r103.getTitle());
        if (r103.isSelect() == false) goto L30;
        if (this.f237673c != (-1)) goto L30;
        r102.f237676b.setChecked(true);
        this.f237673c = r101;
        return;
    L30:
        if (this.f237673c != r101) goto L32;
        r102.f237676b.setChecked(true);
        return;
    L32:
        r102.f237676b.setChecked(false);
        return;
    L7:
        if (r105.length < 2) goto L9;
        r104.f237679e.setText(r105[0]);
        r104.f237680f.setText(r105[1]);
        goto L10
    L9:
        r104.f237679e.setText("");
        r104.f237680f.setText("");
        goto L10
    L12:
        if ((r102 instanceof SingleViewHolder) == false) goto L23;
        SingleViewHolder r106 = (SingleViewHolder) r102;
        r106.f237676b.setOnCheckedChangeListener(new g(r106, this, r101));
        r106.f237675a.setOnClickListener(new h(r106));
        String[] r107 = r103.getConditionValue();
        if (r107 != null) goto L16;
    L22:
        r106.f237681d.setOnEditorActionListener(new i(this));
        goto L24
    L16:
        if (r107.length != 0) goto L18;
        boolean r108 = true;
    L20:
        if ((!r108) == false) goto L22;
        r106.f237681d.setText(r107[0]);
        goto L22
    L18:
        r108 = false;
        goto L20
    L23:
        r102.f237675a.setOnClickListener(new j(r102, this, r101, r103));
        goto L24
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return new BaseViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_filter_condition_single_item, r100, false));
    L11:
        return new SingleViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_filter_condition_single_item, r100, false));
    L9:
        return new RangeViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_filter_condition_range_item, r100, false));
    }

    public final void y2(int r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if ((r101 instanceof SingleViewHolder) == false) goto L8;
        String[] r102 = {((SingleViewHolder) r101).f237681d.getText().toString()};
        b r103 = this.f237674d;
        if (r103 == null) goto L13;
        r103.sK(((FilterData.FilterOptionItem) ListProtector.get(this.f237672b, r100)).getId(), r102);
        return;
    L13:
        return;
    L8:
        if ((r101 instanceof RangeViewHolder) == false) goto L15;
        RangeViewHolder r104 = (RangeViewHolder) r101;
        String[] r105 = {r104.f237679e.getText().toString(), r104.f237680f.getText().toString()};
        b r106 = this.f237674d;
        if (r106 == null) goto L16;
        r106.sK(((FilterData.FilterOptionItem) ListProtector.get(this.f237672b, r100)).getId(), r105);
        return;
    L16:
        return;
    }
}
