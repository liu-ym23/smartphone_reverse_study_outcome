package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridViewV2;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewCellAttachmentItemV2Binding;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentLargeIconCell;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCommonCell;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewCellAttachmentItemV2Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewCellAttachmentItemV2Binding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewCellAttachmentItemV2Binding;)V", "setAdapterParams", "", "needFullWidth", "", "editable", "remainWidth", "", "getAddView", "Landroid/view/View;", "setData", "data", "extra", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentLargeIconCell extends AttachmentCommonCell {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitableItemViewCellAttachmentItemV2Binding f213805i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qt4.a f213806a;

        public a(qt4.a r100) {
            this.f213806a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f213806a.f534789f.run();
        }
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.AttachmentCommonCell
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.AttachmentCommonCell
    public View getAddView() {
        return null;
    }

    public final BitableItemViewCellAttachmentItemV2Binding getBinding() {
        return this.f213805i;
    }

    public AttachmentLargeIconCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBinding(BitableItemViewCellAttachmentItemV2Binding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213805i = r100;
    }

    public AttachmentLargeIconCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 12);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_cell_attachment_item_v2, this);
        AttachmentGridViewV2 r102 = (AttachmentGridViewV2) ViewBindings.findChildViewById(this, R.id.attachment_content);
        if (r102 == null) goto L7;
        this.f213805i = new BitableItemViewCellAttachmentItemV2Binding(this, r102);
        r102.b(10.0f);
        setMAttachmentGridView(this.f213805i.f210822b);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.attachment_content)));
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.AttachmentCommonCell
    public final boolean d(boolean r100, int r101) {
        if ((!getMShowList().isEmpty()) == true) goto L8;
        if (r100 == true) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.AttachmentCommonCell
    public final void g(AttachmentCellValue r100, qt4.a r101, gv4.a r102) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        super.g(r100, r101, r102);
        AttachmentGridView r103 = getMAttachmentGridView();
        AttachmentGridViewV2 r104 = null;
        if ((r103 instanceof AttachmentGridViewV2) == false) goto L5;
        AttachmentGridViewV2 r105 = (AttachmentGridViewV2) r103;
    L6:
        if (r105 == null) goto L8;
        r105.setShowAddButton(r101.f534788e);
    L8:
        AttachmentGridView r106 = getMAttachmentGridView();
        if ((r106 instanceof AttachmentGridViewV2) == false) goto L11;
        AttachmentGridViewV2 r107 = (AttachmentGridViewV2) r106;
    L12:
        if (r107 != null) goto L14;
    L18:
        AttachmentGridView r108 = getMAttachmentGridView();
        if ((r108 instanceof AttachmentGridViewV2) == false) goto L21;
        r104 = (AttachmentGridViewV2) r108;
    L21:
        if (r104 == null) goto L24;
        r104.setOnAddClickListener(new a(r101));
        return;
    L24:
        return;
    L14:
        if (r101.f534788e == false) goto L16;
        Icon r109 = r101.f534798o;
    L17:
        r107.setAddIcon(r109);
        goto L18
    L16:
        r109 = null;
        goto L17
    L11:
        r107 = null;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
