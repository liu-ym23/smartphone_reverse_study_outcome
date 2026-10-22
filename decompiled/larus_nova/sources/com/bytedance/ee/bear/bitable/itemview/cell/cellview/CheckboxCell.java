package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.cell.checkbox.InterruptCheckableCheckbox;
import com.bytedance.ee.bear.bitable.databinding.BitableCellCheckboxItemBinding;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u0006B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/CheckboxCell;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/CheckboxCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ObserveCellStatus;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ObserveRecycled;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCellCheckboxItemBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableCellCheckboxItemBinding;", "mData", "getMData", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/CheckboxCellValue;", "setMData", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/CheckboxCellValue;)V", "isFixClickEnable", "", "onViewRecycled", "", "setData", "data", "extra", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "enterEditModeWhenCellClicked", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckboxCell extends FrameLayout implements qt4.l, qt4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableCellCheckboxItemBinding f213821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckboxCellValue f213822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f213823c;

    @Override // qt4.l
    public final void a() {
        boolean r100 = !this.f213821a.f210728b.isChecked();
        InterruptCheckableCheckbox r101 = this.f213821a.f210728b;
        r101.f207630b = true;
        r101.setChecked(r100);
        r101.f207630b = false;
        CheckboxCellValue r102 = this.f213822b;
        if (r102 == null) goto L12;
        Boolean r103 = Boolean.valueOf(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.isEmpty() == false) goto L8;
        return;
    L8:
        if (r102.size() <= 0) goto L14;
        ListProtector.set(r102, 0, r103);
        return;
    L14:
        return;
    }

    @Override // qt4.m
    public final void onViewRecycled() {
        if (this.f213823c == false) goto L6;
        this.f213821a.f210728b.setSetCheckedInterceptor(null);
        this.f213821a.f210728b.setEnableUserSetChecked(false);
        this.f213821a.f210728b.setClickable(false);
        InterruptCheckableCheckbox r100 = this.f213821a.f210728b;
        r100.f207630b = true;
        r100.setChecked(false);
        r100.f207630b = false;
        this.f213821a.f210729c.removeAllViews();
        return;
    }

    public final BitableCellCheckboxItemBinding getBinding() {
        return this.f213821a;
    }

    public final CheckboxCellValue getMData() {
        return this.f213822b;
    }

    public CheckboxCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setMData(CheckboxCellValue r100) {
        this.f213822b = r100;
    }

    public CheckboxCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_cell_checkbox_item, this, false);
        addView(r102);
        int r103 = R.id.checkbox_type_content;
        InterruptCheckableCheckbox r104 = (InterruptCheckableCheckbox) ViewBindings.findChildViewById(r102, R.id.checkbox_type_content);
        if (r104 == null) goto L11;
        r103 = R.id.reference_type_content;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.reference_type_content);
        if (r105 == null) goto L11;
        this.f213821a = new BitableCellCheckboxItemBinding((LinearLayout) r102, r104, r105);
        int r106 = com.bytedance.ee.bear.bitable.c.f207079a;
        boolean r107 = com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.checkbox_cell_click_fix_enable");
        this.f213823c = r107;
        if (r107 == false) goto L12;
        r104.setClickable(false);
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
