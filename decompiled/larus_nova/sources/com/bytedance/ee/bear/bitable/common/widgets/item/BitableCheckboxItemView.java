package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableCheckboxItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnCheckedChangeListener", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableCheckboxItemView$OnCheckedChangeListener;", "checkCB", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "titleTV", "Landroid/widget/TextView;", "badgeView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "initViews", "", "initListener", "badgeViewVisible", "visible", "", com.alipay.sdk.m.x.d.f25925o, "title", "", "setChecked", "checked", "setOnCheckedChangeListener", "listener", "OnCheckedChangeListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableCheckboxItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDCheckBox f209978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f209979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBadgeView f209980c;

    public interface a {
    }

    public BitableCheckboxItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableCheckboxItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOnCheckedChangeListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setChecked(boolean r100) {
        UDCheckBox r101 = this.f209978a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
        r101 = null;
    L5:
        r101.setChecked(r100);
    }

    public final void setTitle(CharSequence r100) {
        TextView r101 = this.f209979b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public BitableCheckboxItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setGravity(16);
        setOrientation(0);
        setBackgroundTintList(getResources().getColorStateList(R.color.facade_selector_item_float));
        setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.space_kit_len_52)));
        setPadding(0, 0, n.d(16), 0);
        UDCheckBox r103 = new UDCheckBox(getContext());
        this.f209978a = r103;
        r103.setClickable(false);
        UDCheckBox r104 = this.f209978a;
        View r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
        r104 = null;
    L5:
        r104.setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
        UDCheckBox r106 = this.f209978a;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
        r106 = null;
    L8:
        r106.setType(UDCheckBox.CheckBoxType.RADIO);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.gravity = 16;
        r107.setMarginStart(n.d(4));
        View r108 = this.f209978a;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
        r108 = null;
    L11:
        addView(r108, r107);
        TextView r109 = new TextView(getContext());
        this.f209979b = r109;
        r109.setIncludeFontPadding(false);
        TextView r110 = this.f209979b;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r110 = null;
    L14:
        r110.setEllipsize(TextUtils.TruncateAt.END);
        TextView r111 = this.f209979b;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r111 = null;
    L17:
        r111.setMaxLines(1);
        TextView r112 = this.f209979b;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r112 = null;
    L20:
        r112.setSingleLine(true);
        TextView r113 = this.f209979b;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r113 = null;
    L23:
        r113.setTextSize(0, a08.b.a(getResources().getDimension(R.dimen.space_kit_font_16), getContext()));
        TextView r114 = this.f209979b;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r114 = null;
    L26:
        r114.setTextColor(getResources().getColor(R.color.text_title));
        TextView r115 = this.f209979b;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r115 = null;
    L29:
        r115.setGravity(16);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, n.d(52));
        r116.setMarginStart(n.d(4));
        r116.gravity = 16;
        View r117 = this.f209979b;
        if (r117 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        r117 = null;
    L32:
        addView(r117, r116);
        Context r118 = getContext();
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDBadgeView r119 = new UDBadgeView(r118, null, 0, R.style.bitable_dot_badge);
        String r120 = r119.f284529h;
        if (r120 == null) goto L35;
        r119.setText(r120);
    L35:
        Drawable r121 = r119.f284534m;
        if (r121 == null) goto L38;
        r119.setIcon(r121);
    L38:
        r119.b();
        this.f209980c = r119;
        r119.setVisibility(8);
        View r122 = this.f209980c;
        if (r122 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("badgeView");
    L42:
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(-2, -2);
        r123.setMarginStart(n.d(8));
        Unit r124 = Unit.INSTANCE;
        addView(r105, r123);
        setOnClickListener(new com.bytedance.ee.bear.bitable.common.widgets.item.a(this));
        return;
    L41:
        r105 = r122;
        goto L42
    }

    public /* synthetic */ BitableCheckboxItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
