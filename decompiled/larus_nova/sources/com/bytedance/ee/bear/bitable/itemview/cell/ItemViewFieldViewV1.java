package com.bytedance.ee.bear.bitable.itemview.cell;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import bq4.d;
import com.bytedance.ee.bear.bitable.card.view.cell.title.TitleTextView;
import com.bytedance.ee.bear.bitable.card.view.cell.title.record.span.DescriptionIconSpan;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.databinding.BitablePageCellTitleLayoutBinding;
import com.bytedance.ee.bear.bitable.itemview.util.i;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewFieldViewV1;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/IFieldView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitablePageCellTitleLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitablePageCellTitleLayoutBinding;", "descriptionIconSpan", "Lcom/bytedance/ee/bear/bitable/card/view/cell/title/record/span/DescriptionIconSpan;", "iconSizeResId", "", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewRecordCellData;", "extra", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellRenderItemData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "updateRightContent", "titleRightVisible", "", "getFieldViewMeasureWidth", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewFieldViewV1 extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitablePageCellTitleLayoutBinding f213780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f213781b;

    public static final class a extends dq4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordCellData f213782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f213783b;

        @Override // dq4.b
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
        }

        @Override // dq4.b
        public final void b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            ActionPayload r101 = this.f213782a.getClickDescAction();
            if (r101 == null) goto L8;
            gv4.a r102 = this.f213783b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        L9:
            return;
        }

        public a(ItemViewRecordCellData r100, gv4.a r101) {
            this.f213782a = r100;
            this.f213783b = r101;
        }
    }

    public static final class b extends dq4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordCellData f213784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ItemViewFieldViewV1 f213785b;

        @Override // dq4.b
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
        }

        @Override // dq4.b
        public final void b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            String r101 = this.f213784a.getFieldWarning();
            if (r101 == null) goto L6;
            UDToast.show(this.f213785b.getContext(), r101);
            return;
        }

        public b(ItemViewRecordCellData r100, ItemViewFieldViewV1 r101) {
            this.f213784a = r100;
            this.f213785b = r101;
        }
    }

    @Override // qt4.c
    public int getFieldViewMeasureWidth() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return getMeasuredWidth() + n.d(12);
    }

    public final BitablePageCellTitleLayoutBinding getBinding() {
        return this.f213780a;
    }

    public ItemViewFieldViewV1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // qt4.c
    public final void b(boolean r100) {
        if (r100 == false) goto L5;
        m.z(this.f213780a.f211002e, true);
        i.i(this, true);
        m.B(this.f213780a.f210999b, -1, false);
        return;
    L5:
        m.z(this.f213780a.f211002e, false);
        i.i(this, false);
        m.B(this.f213780a.f210999b, -2, false);
    }

    public ItemViewFieldViewV1(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_page_cell_title_layout, this, false);
        addView(r102);
        int r103 = R.id.cell_title_add_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.cell_title_add_icon)) == null) goto L15;
        ConstraintLayout r104 = (ConstraintLayout) r102;
        r103 = R.id.cell_title_icon;
        SyncIconImageView r105 = (SyncIconImageView) ViewBindings.findChildViewById(r102, R.id.cell_title_icon);
        if (r105 == null) goto L15;
        r103 = R.id.cell_title_name;
        TitleTextView r106 = (TitleTextView) ViewBindings.findChildViewById(r102, R.id.cell_title_name);
        if (r106 == null) goto L15;
        r103 = R.id.cell_title_right_container;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.cell_title_right_container);
        if (r107 == null) goto L15;
        r103 = R.id.single_line_temp;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.single_line_temp)) == null) goto L15;
        this.f213780a = new BitablePageCellTitleLayoutBinding(r104, r104, r105, r106, r107);
        this.f213781b = R.dimen.bitable_descrpition_page_icon_size;
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    @Override // qt4.c
    public final void a(ItemViewRecordCellData r100, ItemViewCellRenderItemData r101, gv4.a r110) {
        if (r100 == null) goto L29;
        String r102 = r100.getName();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        SpannableStringBuilder r103 = new SpannableStringBuilder(r102);
        if (r100.showDescIcon() == false) goto L10;
        r103.append("<doc.at.~#_%=`>");
        r103.setSpan(new DescriptionIconSpan(getContext(), this.f213781b), r102.length(), r103.length(), 33);
        r103.setSpan(new a(r100, r110), r102.length(), r103.length(), 33);
    L10:
        if (r101 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L18;
        r103.append("*");
        r103.setSpan(new d(getContext()), r103.length() - 1, r103.length(), 33);
    L18:
        if (r100.showWarningIcon() == false) goto L20;
        dq4.a r105 = new dq4.a(getContext(), this.f213781b);
        int r111 = r103.length();
        r103.append("<doc.at.~#_%=`>");
        r103.setSpan(r105, r111, r103.length(), 33);
        r103.setSpan(new b(r100, this), r111, r103.length(), 33);
    L20:
        this.f213780a.f211001d.setText(r103);
        TitleTextView r106 = this.f213780a.f211001d;
        if (r100.showDescIcon() == false) goto L23;
    L26:
        dq4.c r112 = new dq4.c();
    L27:
        r106.setMovementMethod(r112);
        this.f213780a.f211000c.setImageResource(r100.getOriginalFieldUIType().getIconRes());
        this.f213780a.f211000c.setSyncIconVisible(r100.isSync());
        return;
    L23:
        if (r100.showWarningIcon() == true) goto L26;
        r112 = null;
        goto L27
    L12:
        if (r101.getShowRequired() != true) goto L14;
        r104 = true;
        goto L15
    }
}
