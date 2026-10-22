package com.bytedance.ee.bear.bitable.itemview.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewFieldViewLayoutBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldView;
import com.bytedance.ee.bear.bitable.itemview.util.i;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.IconGif;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewFieldViewV2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/IFieldView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewFieldViewLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewFieldViewLayoutBinding;", "addIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getAddIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "getFieldViewMeasureWidth", "", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewRecordCellData;", "extra", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellRenderItemData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "updateRightContent", "titleRightVisible", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewFieldViewV2 extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewFieldViewLayoutBinding f213786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f213787b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordCellData f213788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f213789b;

        public a(ItemViewRecordCellData r100, AppCompatImageView r101) {
            this.f213788a = r100;
            this.f213789b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f213788a.getFieldWarning();
            if (r101 == null) goto L6;
            UDToast.show(this.f213789b.getContext(), r101);
            return;
        }
    }

    @Override // qt4.c
    public int getFieldViewMeasureWidth() {
        return getMeasuredWidth();
    }

    public final AppCompatImageView getAddIcon() {
        return this.f213787b;
    }

    public final BitableItemViewFieldViewLayoutBinding getBinding() {
        return this.f213786a;
    }

    public ItemViewFieldViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // qt4.c
    public final void b(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = -1;
    L6:
        int r102 = 0;
        m.B(this, r101, false);
        if (r100 == false) goto L16;
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == false) goto L11;
        ViewGroup r104 = (ViewGroup) r103;
    L12:
        if (r104 == null) goto L16;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L16;
        r105.width = -1;
        goto L16
    L11:
        r104 = null;
    L16:
        m.z(this.f213787b, r100);
        AdaptiveRowLayout r106 = this.f213786a.f210850c;
        if (r100 == false) goto L19;
        r102 = n.d(28) + n.d(16);
    L19:
        m.t(r106, r102);
        return;
    L5:
        r101 = -2;
        goto L6
    }

    public ItemViewFieldViewV2(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        View r112 = LayoutInflater.from(r110).inflate(R.layout.bitable_item_view_field_view_layout, this, false);
        addView(r112);
        int r100 = R.id.cell_title_icon;
        SyncIconImageView r101 = (SyncIconImageView) ViewBindings.findChildViewById(r112, R.id.cell_title_icon);
        if (r101 == null) goto L23;
        AdaptiveRowLayout r102 = (AdaptiveRowLayout) r112;
        r100 = R.id.desc_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r112, R.id.desc_icon);
        if (r103 == null) goto L23;
        r100 = R.id.field_content_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r112, R.id.field_content_container)) == null) goto L23;
        r100 = R.id.field_icon_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r112, R.id.field_icon_container)) == null) goto L23;
        r100 = R.id.field_name;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r112, R.id.field_name);
        if (r104 == null) goto L23;
        r100 = R.id.field_require;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r112, R.id.field_require);
        if (r105 == null) goto L23;
        r100 = R.id.field_tag;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r112, R.id.field_tag);
        if (r113 == null) goto L23;
        r100 = R.id.loading_icon;
        SyncIconImageView r114 = (SyncIconImageView) ViewBindings.findChildViewById(r112, R.id.loading_icon);
        if (r114 == null) goto L23;
        r100 = R.id.warning_icon;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r112, R.id.warning_icon);
        if (r115 == null) goto L23;
        this.f213786a = new BitableItemViewFieldViewLayoutBinding(r102, r101, r102, r103, r104, r105, r113, r114, r115);
        AppCompatImageView r116 = new AppCompatImageView(r110);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(n.d(28), n.d(24));
        r106.gravity = 5;
        r116.setLayoutParams(r106);
        r116.setBackground(ContextCompat.getDrawable(r110, R.drawable.facade_round_around_s));
        r116.setBackgroundTintList(ContextCompat.getColorStateList(r110, R.color.bg_body_overlay));
        r116.setPadding(n.d(4), n.d(4), n.d(4), n.d(4));
        r116.setImageTintList(ContextCompat.getColorStateList(r110, R.color.icon_n3));
        r116.setImageResource(R.drawable.ud_icon_add_middle_outlined);
        m.z(r116, false);
        this.f213787b = r116;
        addView(r116);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r100)));
    }

    @Override // qt4.c
    public final void a(ItemViewRecordCellData r100, ItemViewCellRenderItemData r101, gv4.a r102) {
        if (r100 == null) goto L47;
        AdaptiveRowLayout r103 = this.f213786a.f210848a;
        if (r101 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        r103.setFieldIconFlowAligned(r104);
        if (r101 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L18;
        m.z(this, false);
        return;
    L18:
        m.z(this, true);
        this.f213786a.f210850c.setTouchDelegate(null);
        i.a(this.f213786a.f210851d);
        i.a(this.f213786a.f210856i);
        SyncIconImageView r106 = this.f213786a.f210849b;
        Intrinsics.checkNotNull(r106);
        if (r101 != null) goto L21;
    L23:
        boolean r107 = false;
    L24:
        m.z(r106, r107);
        r106.setImageResource(r100.getOriginalFieldUIType().getIconRes());
        r106.setSyncIconVisible(r100.isSync());
        TextView r108 = this.f213786a.f210852e;
        r108.setText(r100.getName());
        r108.setMinWidth(0);
        TextView r109 = this.f213786a.f210854g;
        Boolean r110 = r100.getShowAITag();
        Boolean r111 = Boolean.TRUE;
        if (Intrinsics.areEqual(r110, r111) == false) goto L27;
        Intrinsics.checkNotNull(r109);
        m.z(r109, true);
        this.f213786a.f210854g.setText(GridFieldView.f213552i);
    L28:
        AppCompatImageView r112 = this.f213786a.f210851d;
        if (r100.showDescIcon() == false) goto L31;
        Intrinsics.checkNotNull(r112);
        m.z(r112, true);
        m.c(this.f213786a.f210851d, r100.getClickDescAction(), r102, null);
    L32:
        TextView r113 = this.f213786a.f210853f;
        r113.setText("*");
        Intrinsics.checkNotNull(r113);
        if (r101 != null) goto L35;
    L37:
        boolean r114 = false;
    L38:
        m.z(r113, r114);
        AppCompatImageView r115 = this.f213786a.f210856i;
        if (r100.showWarningIcon() == false) goto L41;
        Intrinsics.checkNotNull(r115);
        m.z(r115, true);
        this.f213786a.f210856i.setOnClickListener(new a(r100, r115));
    L42:
        SyncIconImageView r116 = this.f213786a.f210855h;
        if (Intrinsics.areEqual(r100.getShowFieldLoading(), r111) == false) goto L45;
        Intrinsics.checkNotNull(r116);
        m.z(r116, true);
        e.h(this.f213786a.f210855h, Integer.valueOf(IconGif.Loading.getValue()), r116.getContext(), null);
        return;
    L45:
        Intrinsics.checkNotNull(r116);
        m.z(r116, false);
        return;
    L41:
        Intrinsics.checkNotNull(r115);
        m.z(r115, false);
        goto L42
    L35:
        if (r101.getShowRequired() != true) goto L37;
        r114 = true;
        goto L38
    L31:
        Intrinsics.checkNotNull(r112);
        m.z(r112, false);
        goto L32
    L27:
        Intrinsics.checkNotNull(r109);
        m.z(r109, false);
        goto L28
    L21:
        if (r101.getShowFieldIcon() != true) goto L23;
        r107 = true;
        goto L24
    L12:
        if (r101.getShowFieldName() == true) goto L14;
        r105 = true;
        goto L15
    L6:
        if (r101.isHorizontalLayout() != true) goto L8;
        r104 = true;
        goto L9
    }
}
