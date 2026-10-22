package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LiveData;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordFooterChild4Binding;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.ButtonCell;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.ButtonCellValue;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterChild4;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/FooterChild;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild4Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild4Binding;", "hasObserve", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "clickComment", "it", "needFollowScroll", "", "showMoreActionSheet", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterChild4 extends FooterChild {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordFooterChild4Binding f214182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f214183b;

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.FooterChild
    public final boolean a() {
        return false;
    }

    public final BitableItemViewRecordFooterChild4Binding getBinding() {
        return this.f214182a;
    }

    public ItemViewRecordFooterChild4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewRecordFooterChild4(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.bitable_item_view_record_footer_child4, this);
        int r112 = R.id.bottomInnerContainer;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.bottomInnerContainer)) == null) goto L23;
        r112 = R.id.commentCount;
        TextView r100 = (TextView) ViewBindings.findChildViewById(this, R.id.commentCount);
        if (r100 == null) goto L23;
        r112 = R.id.commentCountAlone;
        TextView r101 = (TextView) ViewBindings.findChildViewById(this, R.id.commentCountAlone);
        if (r101 == null) goto L23;
        r112 = R.id.commentLayout;
        ConstraintLayout r102 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.commentLayout);
        if (r102 == null) goto L23;
        r112 = R.id.inputHolderTv;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.inputHolderTv);
        if (r103 == null) goto L23;
        r112 = R.id.main_button;
        ButtonCell r104 = (ButtonCell) ViewBindings.findChildViewById(this, R.id.main_button);
        if (r104 == null) goto L23;
        r112 = R.id.more_button;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.more_button);
        if (r105 == null) goto L23;
        r112 = R.id.sub_button;
        ButtonCell r106 = (ButtonCell) ViewBindings.findChildViewById(this, R.id.sub_button);
        if (r106 == null) goto L23;
        r112 = R.id.switch_card_view;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.switch_card_view)) == null) goto L23;
        this.f214182a = new BitableItemViewRecordFooterChild4Binding(this, r100, r101, r102, r103, r104, r105, r106);
        this.f214183b = new AtomicBoolean(false);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    @Override // gv4.b
    public final void iq(Object r100, t r110) {
        ItemViewRecordFooterData r101 = (ItemViewRecordFooterData) r100;
        if (r101 == null) goto L39;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterChild4.setData", null, null, null, 14);
        int r102 = r101.getButtonList().size();
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L9;
        BitableItemViewRecordFooterChild4Binding r103 = this.f214182a;
        com.bytedance.ee.bear.bitable.m.y(new View[]{r103.f210910h, r103.f210908f, r103.f210909g}, new View[]{r103.f210906d, r103.f210905c});
        this.f214182a.f210909g.setOnClickListener(new n(this, r101, r110));
    L26:
        if (Intrinsics.areEqual(r101.getShouldShowCommentView(), Boolean.TRUE) == true) goto L28;
        com.bytedance.ee.bear.bitable.m.z(this.f214182a.f210906d, false);
        com.bytedance.ee.bear.bitable.m.z(this.f214182a.f210905c, false);
    L28:
        ArrayList<ButtonCellValue> r104 = r101.getButtonList();
        if (r104 == null) goto L33;
        ButtonCellValue r105 = (ButtonCellValue) com.bytedance.ee.bear.bitable.m.j(r104, 0, null);
        if (r105 == null) goto L33;
        this.f214182a.f210908f.a(r105, new qt4.a(new o(r101, r110), EFieldUIType.BUTTON));
    L33:
        ArrayList<ButtonCellValue> r106 = r101.getButtonList();
        if (r106 == null) goto L40;
        ButtonCellValue r107 = (ButtonCellValue) com.bytedance.ee.bear.bitable.m.j(r106, 1, null);
        if (r107 == null) goto L41;
        this.f214182a.f210910h.a(r107, new qt4.a(new p(r101, r110), EFieldUIType.BUTTON));
        return;
    L41:
        return;
    L40:
        return;
    L9:
        BitableItemViewRecordFooterChild4Binding r108 = this.f214182a;
        com.bytedance.ee.bear.bitable.m.y(new View[]{r108.f210910h, r108.f210908f, r108.f210905c}, new View[]{r108.f210906d, r108.f210909g});
        this.f214182a.f210905c.setText(String.valueOf(r101.getCommentCount()));
        this.f214182a.f210905c.setOnClickListener(new m(this, r101, r110));
    L10:
        BitableItemViewRecordFooterChild4Binding r109 = this.f214182a;
        com.bytedance.ee.bear.bitable.m.y(new View[]{r109.f210906d}, new View[]{r109.f210905c, r109.f210909g, r109.f210910h});
        if (this.f214183b.compareAndSet(false, true) == false) goto L17;
        com.bytedance.ee.bear.bitable.itemview.b r111 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r111 == null) goto L17;
        LiveData<Boolean> r112 = r111.getCommentAble();
        if (r112 == null) goto L17;
        r112.observe(r111.getFragment().getViewLifecycleOwner(), new j(this));
    L17:
        this.f214182a.f210907e.setOnClickListener(new k(r110));
        Drawable r113 = ResourcesCompat.getDrawable(getResources(), R.drawable.ud_icon_add_comment_outlined, getContext().getTheme());
        if (r113 == null) goto L20;
        r113.setBounds(0, 0, com.bytedance.ee.util.ui.n.d(20), com.bytedance.ee.util.ui.n.d(20));
        this.f214182a.f210904b.setCompoundDrawables(r113, null, null, null);
    L20:
        this.f214182a.f210904b.setText(String.valueOf(r101.getCommentCount()));
        this.f214182a.f210904b.setOnClickListener(new l(this, r101, r110));
        ButtonCell r114 = this.f214182a.f210908f;
        if (r101.getButtonList().size() != 1) goto L23;
        boolean r115 = true;
    L24:
        com.bytedance.ee.bear.bitable.m.z(r114, r115);
        goto L26
    L23:
        r115 = false;
        goto L24
    }

    public static final void b(ItemViewRecordFooterChild4 r100, ItemViewRecordFooterData r101, gv4.a r102) {
        r100.getClass();
        if (r101.getCommentCount() <= 0) goto L8;
        if (r102 == null) goto L6;
        Action.Companion.getClass();
        r102.a(new Action(null, Action.access$getTYPE_OPEN_COMMENT$cp()));
    L6:
        if (r102 == null) goto L13;
        r102.a(new ReportActionPayload("ItemViewClickComment"));
        return;
    L13:
        return;
    L8:
        if (r102 == null) goto L10;
        Action.Companion.getClass();
        r102.a(new Action(null, Action.access$getTYPE_ADD_COMMENT$cp()));
    L10:
        if (r102 == null) goto L15;
        r102.a(new ReportActionPayload("ItemViewClickCommentInput"));
        return;
    }
}
