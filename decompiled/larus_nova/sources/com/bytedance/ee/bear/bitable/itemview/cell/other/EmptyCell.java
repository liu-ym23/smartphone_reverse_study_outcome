package com.bytedance.ee.bear.bitable.itemview.cell.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordCellEmptyBinding;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCell;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordCellEmptyBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordCellEmptyBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordCellEmptyBinding;)V", "setData", "", "data", "extra", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EmptyCell extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableItemViewRecordCellEmptyBinding f213948a;

    public final BitableItemViewRecordCellEmptyBinding getBinding() {
        return this.f213948a;
    }

    public EmptyCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBinding(BitableItemViewRecordCellEmptyBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213948a = r100;
    }

    public EmptyCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_record_cell_empty, this);
        int r102 = R.id.empty_add_view;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.empty_add_view);
        if (r103 == null) goto L11;
        r102 = R.id.empty_dashline;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.empty_dashline);
        if (r104 == null) goto L11;
        r102 = R.id.empty_placeholder;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.empty_placeholder);
        if (r105 == null) goto L11;
        this.f213948a = new BitableItemViewRecordCellEmptyBinding(this, r103, r104, r105);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public void a(EmptyCellData r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmptyIcon() == false) goto L11;
        e.j(this.f213948a.f210869b, r100.getIcon());
        BitableItemViewRecordCellEmptyBinding r102 = this.f213948a;
        m.y(new View[]{r102.f210869b}, new View[]{r102.f210870c, r102.f210871d});
        if (r101.f534784a >= n.d(32)) goto L9;
        m.B(this.f213948a.f210869b, r101.f534787d, true);
        this.f213948a.f210869b.setBackgroundResource(R.drawable.bitable_page_field_empty_value_icon_big_bg);
        return;
    L9:
        m.B(this.f213948a.f210869b, n.d(32), true);
        this.f213948a.f210869b.setBackgroundResource(R.drawable.bitable_page_field_empty_value_icon_bg);
        return;
    L11:
        if (r100.isDashLine() == false) goto L14;
        BitableItemViewRecordCellEmptyBinding r103 = this.f213948a;
        m.y(new View[]{r103.f210870c}, new View[]{r103.f210869b, r103.f210871d});
        return;
    L14:
        if (r100.isTextPlaceholder() == false) goto L21;
        this.f213948a.f210871d.setText(r100.getText());
        BitableItemViewRecordCellEmptyBinding r104 = this.f213948a;
        m.y(new View[]{r104.f210871d}, new View[]{r104.f210869b, r104.f210870c});
        return;
    }
}
