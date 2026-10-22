package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.FieldModel;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.FormGridRecord;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.FormGridUIData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView;
import com.bytedance.ee.bear.bitable.m;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mt4.d;
import mt4.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00172\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridAdapter$BaseViewHolder;", "rowScrollManager", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;)V", "getRowScrollManager", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "setRowScrollManager", "formGridData", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;", "getFormGridData", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;", "setFormGridData", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;)V", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "setData", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "BaseViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f207682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FormGridUIData f207683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gv4.a f207684c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridAdapter;Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(BaseRowView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L4;
        return 1;
    L4:
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        FormGridUIData r100 = this.f207683b;
        if (r100 == null) goto L5;
        int r101 = r100.getRecordCount();
    L7:
        return r101 + 1;
    L5:
        r101 = 1;
        goto L7
    }

    public FormGridAdapter(d r100) {
        Intrinsics.checkNotNullParameter(r100, "rowScrollManager");
        this.f207682a = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        BaseViewHolder r112 = (BaseViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        FormGridRecord r100 = null;
        ArrayList<FieldModel> r101 = null;
        r100 = null;
        r100 = null;
        if (r111 != 0) goto L14;
        View r113 = r112.itemView;
        if ((r113 instanceof FormGridHeaderView) == false) goto L7;
        FormGridHeaderView r114 = (FormGridHeaderView) r113;
    L8:
        if (r114 == null) goto L36;
        d r115 = this.f207682a;
        Intrinsics.checkNotNullParameter(r115, "rowScrollManager");
        r114.setRowScrollManager(r115);
        r115.a(r114);
        e r116 = r115.f515638b;
        r114.b(r116.f515644f, r116.f515643e, -1, 0, 0);
        FormGridUIData r117 = this.f207683b;
        if (r117 == null) goto L12;
        r101 = r117.getFieldsHeader();
    L12:
        if (r101 == null) goto L37;
        r114.getAdapter().y2(r101, 0);
        r114.getAdapter().notifyDataSetChanged();
        return;
    L37:
        return;
    L36:
        return;
    L7:
        r114 = null;
        goto L8
    L14:
        View r118 = r112.itemView;
        if ((r118 instanceof FormGridRecordView) == false) goto L17;
        FormGridRecordView r119 = (FormGridRecordView) r118;
    L18:
        if (r119 == null) goto L39;
        int r120 = r111 - 1;
        d r102 = this.f207682a;
        Intrinsics.checkNotNullParameter(r102, "rowScrollManager");
        r119.setRowScrollManager(r102);
        r102.a(r119);
        e r103 = r102.f515638b;
        r119.b(r103.f515644f, r103.f515643e, -1, 0, 0);
        FormGridUIData r104 = this.f207683b;
        if (r104 == null) goto L26;
        ArrayList<FormGridRecord> r105 = r104.getRecords();
        if (r105 == null) goto L26;
        FormGridRecord r106 = (FormGridRecord) m.j(r105, r120, null);
        if (r106 == null) goto L26;
        r106.setTextIndex(Integer.valueOf(r120 + 1));
        r100 = r106;
    L26:
        if (r100 == null) goto L34;
        BaseRowView.RowAdapter r107 = r119.getAdapter();
        ArrayList<GridCellData> r108 = r100.getFields();
        if (r108 != null) goto L31;
        r108 = new ArrayList();
    L31:
        r107.y2(r108, 0);
        r119.getAdapter().notifyDataSetChanged();
        NumberFixedCellView r109 = (NumberFixedCellView) r119.getFixCol();
        Integer r121 = r100.getTextIndex();
        r109.getClass();
        if (r121 == null) goto L34;
        r109.f207699a.setText(String.valueOf(r121.intValue()));
    L34:
        r119.setOnClickListener(new a(this, r120));
        return;
    L39:
        return;
    L17:
        r119 = null;
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = 0;
        int r103 = 6;
        AttributeSet r104 = null;
        if (r101 != 1) goto L5;
        BaseRowView r105 = new FormGridHeaderView(r100.getContext(), r104, r103, r102);
    L6:
        r105.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new BaseViewHolder(r105);
    L5:
        r105 = new FormGridRecordView(r100.getContext(), r104, r103, r102);
        goto L6
    }
}
