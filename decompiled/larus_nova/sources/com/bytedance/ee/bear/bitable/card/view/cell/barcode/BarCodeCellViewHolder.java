package com.bytedance.ee.bear.bitable.card.view.cell.barcode;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor;
import com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.record.BaseCellAdapter;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.larus.nova.R;
import gp4.h;
import jq4.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kp4.b;
import kp4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0018\u0010\u0013\u001a\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\b\u0010\u001c\u001a\u00020\u0011H\u0014J\"\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000bH\u0014J\b\u0010#\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/barcode/BarCodeCellViewHolder;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/TextCellViewHolder;", "itemView", "Landroid/view/View;", "cellTitlePresenter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "editPanelVisibleListener", "Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;", "isPageRecord", "", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;Z)V", "barCodeEditPanel", "Lcom/bytedance/ee/bear/bitable/card/view/cell/barcode/BarCodeEditPanel;", "initEditor", "", "enterEditMode", "setData", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "Lcom/bytedance/ee/bear/function/AtContent;", "isSupportSystemKeyboardToolbar", "showBarcodeEditPanel", "shouldForbidTextOpt", "exitEditModeByEditPanel", "exitEditMode", "updateTextEditorUI", "correctCellTextViewHint", "textView", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", "content", "", "editable", "needEmptyAddView", "needScrollCellToVisible", "onSpanClicked", "span", "Lcom/bytedance/ee/bear/span/AbsSpan;", "getRightIconRes", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BarCodeCellViewHolder extends TextCellViewHolder {
    public static final /* synthetic */ int X = 0;
    public c W;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BarCodeCellViewHolder f207493a;

        public a(BarCodeCellViewHolder r100) {
            this.f207493a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BarCodeCellViewHolder r101 = this.f207493a;
            int r102 = BarCodeCellViewHolder.X;
            if (r101.Q4() == false) goto L5;
        L7:
            this.f207493a.a4();
            return;
        L5:
            if (this.f207493a.R4() == false) goto L7;
            this.f207493a.Z4();
        }
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder, un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void Z3() {
        this.L = null;
        this.f207234f = true;
        ((BaseCellAdapter) this.f207253y).M2(this);
        U3();
        J4(false);
        E4(true);
        if (u4() == false) goto L10;
        if (Q4() == true) goto L10;
        if (R4() == false) goto L10;
        Z4();
        c4();
        return;
    L10:
        if (this.W != null) goto L12;
        this.W = new c(W4().getContext(), this);
    L12:
        c r100 = this.W;
        if (r100 == null) goto L17;
        r100.f486401e = new kp4.a(this);
        r100.f486402f = new b(this);
        r100.o(Boolean.valueOf(u4()));
        r100.w(this.f207233e.f478256c, S4().s(), Q4(), true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder
    public final boolean b5() {
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean C4() {
        if (this.C == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void c4() {
        c r100 = this.W;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        super.c4();
        return;
    L5:
        if (r100.s() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder
    public final void X4() {
        super.X4();
        if (this.C == false) goto L6;
        W4().setHint("");
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder
    public final void g5() {
        super.g5();
        if (this.C == true) goto L5;
        return;
    L5:
        if (this.f207235g.f486413e == true) goto L7;
    L23:
        this.f207248t.setVisibility(8);
        BitableTextFieldEditor.Q(W4(), 4);
    L24:
        W4().setHint("");
        return;
    L7:
        if (u4() == false) goto L23;
        AppCompatImageView r100 = this.f207248t;
        boolean r101 = false;
        if (r100 == null) goto L11;
        r100.setVisibility(0);
    L11:
        AppCompatImageView r102 = this.f207248t;
        if (r102 == null) goto L20;
        AllowedEditModes r103 = this.f208221J;
        if (r103 == null) goto L16;
        r101 = Intrinsics.areEqual(r103.getManual(), Boolean.TRUE);
    L16:
        if (r101 == false) goto L18;
        int r104 = R.drawable.ud_icon_add_outlined;
    L19:
        r102.setImageResource(r104);
        goto L20
    L18:
        r104 = R.drawable.ud_icon_scan_outlined;
    L20:
        AppCompatImageView r105 = this.f207248t;
        if (r105 == null) goto L24;
        r105.setOnClickListener(new a(this));
        goto L24
    }

    public static final void h5(BarCodeCellViewHolder r100) {
        super.c4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.TextCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void l2(dp4.a<db5.a> r100) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        super.l2(r100);
        c r101 = this.W;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L12;
        c r103 = this.W;
        if (r103 == null) goto L13;
        r103.y(this.f207233e.f478256c, S4().s(), Q4(), true);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r101.s() != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void Y3(BitableAtEditText r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (this.C == true) goto L6;
        super.Y3(r100, r101, r102);
        return;
    }

    public BarCodeCellViewHolder(View r100, aq4.a r101, h r102, j r110) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101, r102, r110, true);
    }
}
