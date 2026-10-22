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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005)*+,-B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J#\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "filterActionListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "getFilterActionListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "setFilterActionListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemViewType", "observeSelectedPosition", "clickEditorAction", "value", "", "", "(I[Ljava/lang/String;)V", "notifyKeyboardClosed", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "BaseViewHolder", "RangeViewHolder", "SingleViewHolder", "OnFilterActionListener", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterConditionAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public final Context a;
    public final List<FilterData.FilterOptionItem> b;
    public int c;
    public b d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "checkBoxContainer", "Landroid/widget/LinearLayout;", "getCheckBoxContainer", "()Landroid/widget/LinearLayout;", "setCheckBoxContainer", "(Landroid/widget/LinearLayout;)V", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setCheckBox", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "checkBoxText", "Landroid/widget/TextView;", "getCheckBoxText", "()Landroid/widget/TextView;", "setCheckBoxText", "(Landroid/widget/TextView;)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final UDCheckBox b;
        public final TextView c;

        public BaseViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131372523);
            this.b = r2.findViewById(2131372522);
            this.c = (TextView) r2.findViewById(2131372524);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$RangeViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "rangeInputView", "getRangeInputView", "()Landroid/view/View;", "setRangeInputView", "(Landroid/view/View;)V", "rangeTextLeft", "Landroid/widget/TextView;", "getRangeTextLeft", "()Landroid/widget/TextView;", "setRangeTextLeft", "(Landroid/widget/TextView;)V", "rangeTextRight", "getRangeTextRight", "setRangeTextRight", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RangeViewHolder extends BaseViewHolder {
        public final View d;
        public final TextView e;
        public final TextView f;

        public RangeViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.d = r2.findViewById(2131383653);
            this.e = (TextView) r2.findViewById(2131383654);
            this.f = (TextView) r2.findViewById(2131383655);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$SingleViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$BaseViewHolder;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;Landroid/view/View;)V", "singleText", "Landroid/widget/TextView;", "getSingleText", "()Landroid/widget/TextView;", "setSingleText", "(Landroid/widget/TextView;)V", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SingleViewHolder extends BaseViewHolder {
        public final TextView d;

        public SingleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.d = (TextView) r2.findViewById(2131386661);
        }
    }

    public static final class a {
    }

    public interface b {
        void c60();

        void sK(String r1, String[] r2);
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final int getItemViewType(int r3) {
        if (Intrinsics.areEqual(((FilterData.FilterOptionItem) ListProtector.get(this.b, r3)).getId(), "noCondition") == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(((FilterData.FilterOptionItem) ListProtector.get(this.b, r3)).getType(), FilterData.FilterOptionItem.Type.RANGE) == false) goto L8;
        return 1;
    L8:
        return 2;
    }

    public FilterConditionAdapter(Context r2, List<FilterData.FilterOptionItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "valueList");
        this.a = r2;
        this.b = r3;
        this.c = -1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        BaseViewHolder r10 = (BaseViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        FilterData.FilterOptionItem r0 = (FilterData.FilterOptionItem) ListProtector.get(this.b, r9);
        if ((r10 instanceof RangeViewHolder) == false) goto L12;
        RangeViewHolder r1 = (RangeViewHolder) r10;
        r1.b.setOnCheckedChangeListener(new c(r1, this, r9));
        r1.a.setOnClickListener(new d(r1));
        String[] r4 = r0.getConditionValue();
        if (r4 != null) goto L7;
    L10:
        r1.e.setOnEditorActionListener(new e(this));
        r1.f.setOnEditorActionListener(new f(this));
    L24:
        r10.c.setText(r0.getTitle());
        if (r0.isSelect() == false) goto L30;
        if (this.c != (-1)) goto L30;
        r10.b.setChecked(true);
        this.c = r9;
        return;
    L30:
        if (this.c != r9) goto L32;
        r10.b.setChecked(true);
        return;
    L32:
        r10.b.setChecked(false);
        return;
    L7:
        if (r4.length < 2) goto L9;
        r1.e.setText(r4[0]);
        r1.f.setText(r4[1]);
        goto L10
    L9:
        r1.e.setText("");
        r1.f.setText("");
        goto L10
    L12:
        if ((r10 instanceof SingleViewHolder) == false) goto L23;
        SingleViewHolder r2 = (SingleViewHolder) r10;
        r2.b.setOnCheckedChangeListener(new g(r2, this, r9));
        r2.a.setOnClickListener(new h(r2));
        String[] r5 = r0.getConditionValue();
        if (r5 != null) goto L16;
    L22:
        r2.d.setOnEditorActionListener(new i(this));
        goto L24
    L16:
        if (r5.length != 0) goto L18;
        boolean r6 = true;
    L20:
        if ((!r6) == false) goto L22;
        r2.d.setText(r5[0]);
        goto L22
    L18:
        r6 = false;
        goto L20
    L23:
        r10.a.setOnClickListener(new j(r10, this, r9, r0));
        goto L24
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L11;
        return new BaseViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564556, r4, false));
    L11:
        return new SingleViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564556, r4, false));
    L9:
        return new RangeViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564555, r4, false));
    }

    public final void y2(int r5, RecyclerView.ViewHolder r6) {
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        if ((r6 instanceof SingleViewHolder) == false) goto L8;
        String[] r0 = {((SingleViewHolder) r6).d.getText().toString()};
        b r7 = this.d;
        if (r7 == null) goto L13;
        r7.sK(((FilterData.FilterOptionItem) ListProtector.get(this.b, r5)).getId(), r0);
        return;
    L13:
        return;
    L8:
        if ((r6 instanceof RangeViewHolder) == false) goto L15;
        RangeViewHolder r8 = (RangeViewHolder) r6;
        String[] r3 = {r8.e.getText().toString(), r8.f.getText().toString()};
        b r9 = this.d;
        if (r9 == null) goto L16;
        r9.sK(((FilterData.FilterOptionItem) ListProtector.get(this.b, r5)).getId(), r3);
        return;
    L16:
        return;
    }
}
