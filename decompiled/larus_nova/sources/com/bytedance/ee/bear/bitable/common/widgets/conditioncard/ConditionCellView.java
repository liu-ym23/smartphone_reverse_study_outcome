package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020!J)\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00132\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010'\u001a\u00020\u0017¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00132\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0017J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0017J\u000e\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u000207R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionCellView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cellTitle", "Landroid/widget/TextView;", "leftIcon", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "rightIcon", "Landroid/widget/ImageView;", "lockIcon", "checkbox", "Landroidx/appcompat/widget/AppCompatCheckBox;", "toPx", "", "setEnabled", "", "enabled", "", "setCellHintText", "text", "", "setCellText", "cellText", "setCellDisable", "disable", "setCellPlaceHolderText", "placeHolderText", "", "setCellDisableText", "disableText", "setLeftIcon", "icon", "color", "isSync", "(ILjava/lang/Integer;Z)V", "setRightIcon", "(ILjava/lang/Integer;)V", "setLeftIconVisible", "visible", "setCellTextVisible", "setLockIconVisible", "setRightIconVisible", "setCheckBoxChecked", "checked", "setOnCheckBoxListener", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setData", "conditionItem", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionCellView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f209899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SyncIconImageView f209900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f209901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f209902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatCheckBox f209903e;

    public ConditionCellView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setCellDisable(boolean r100) {
        SyncIconImageView r101 = this.f209900b;
        Context r102 = getContext();
        if (r100 == false) goto L5;
        int r103 = R.color.icon_n3;
    L6:
        r101.setImageTintList(AppCompatResources.getColorStateList(r102, r103));
        TextView r104 = this.f209899a;
        Context r105 = getContext();
        if (r100 == false) goto L9;
        int r106 = R.color.text_placeholder;
    L10:
        r104.setTextColor(AppCompatResources.getColorStateList(r105, r106));
        return;
    L9:
        r106 = R.color.bitable_field_titlecolor_with_disable;
        goto L10
    L5:
        r103 = R.color.icon_n1;
        goto L6
    }

    public final void setCellDisableText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "disableText");
        this.f209899a.setHint("");
        this.f209899a.setText(r100);
        this.f209899a.setTextColor(getContext().getResources().getColor(R.color.text_disable));
    }

    public final void setCellHintText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f209899a.setHint(r100);
    }

    public final void setCellPlaceHolderText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "placeHolderText");
        this.f209899a.setHint("");
        this.f209899a.setText(r100);
        this.f209899a.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
    }

    public final void setCellText(CharSequence r100) {
        this.f209899a.setHint("");
        this.f209899a.setText(r100);
        this.f209899a.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.bitable_field_titlecolor_with_disable));
    }

    public final void setCellTextVisible(boolean r100) {
        TextView r101 = this.f209899a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setCheckBoxChecked(boolean r100) {
        this.f209903e.setVisibility(0);
        this.f209903e.setChecked(r100);
    }

    public final void setData(ConditionListView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionItem");
        Boolean r101 = r100.isChecked();
        if (r101 == null) goto L6;
        setCheckBoxChecked(r101.booleanValue());
        setLeftIconVisible(false);
        setCellTextVisible(false);
        setRightIconVisible(false);
        setLockIconVisible(false);
        return;
    L6:
        Integer r102 = r100.getIconRes();
        if (r102 == null) goto L9;
        a(this, r102.intValue(), false, 6);
    L10:
        CharSequence r103 = r100.getTitle();
        if (r103 == null) goto L13;
        setCellText(r103);
    L13:
        CharSequence r104 = r100.getHintTitle();
        if (r104 == null) goto L16;
        setCellHintText(r104);
    L16:
        Integer r105 = r100.getRightIconRes();
        if (r105 == null) goto L19;
        b(this, r105.intValue());
        return;
    L19:
        setRightIconVisible(false);
        return;
    L9:
        setLeftIconVisible(false);
        goto L10
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f209899a.setEnabled(r100);
        this.f209900b.setEnabled(r100);
        this.f209901c.setEnabled(r100);
    }

    public final void setLeftIconVisible(boolean r100) {
        SyncIconImageView r101 = this.f209900b;
        Integer r102 = 0;
        r102.intValue();
        if (r100 == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        r101.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    }

    public final void setLockIconVisible(boolean r100) {
        ImageView r101 = this.f209902d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setOnCheckBoxListener(CompoundButton.OnCheckedChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f209903e.setOnCheckedChangeListener(r100);
    }

    public final void setRightIconVisible(boolean r100) {
        ImageView r101 = this.f209901c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public ConditionCellView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setBackground(AppCompatResources.getDrawable(r100, R.drawable.facade_round_around_m));
        setBackgroundTintList(AppCompatResources.getColorStateList(r100, R.color.facade_selector_item_filler));
        setPadding(n.d(8), n.d(5), n.d(8), n.d(5));
        setGravity(16);
        setOrientation(0);
        SyncIconImageView r102 = new SyncIconImageView(r100);
        this.f209900b = r102;
        r102.setVisibility(8);
        r102.setImageTintList(AppCompatResources.getColorStateList(r100, R.color.icon_n1));
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(n.d(18), n.d(18));
        r103.setMargins(0, 0, n.d(6), 0);
        Unit r104 = Unit.INSTANCE;
        addView(r102, r103);
        TextView r105 = new TextView(r100);
        this.f209899a = r105;
        r105.setTextSize(2, 16.0f);
        r105.setGravity(17);
        r105.setMaxLines(1);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r105.setTextColor(r100.getResources().getColor(R.color.text_placeholder));
        r105.setHintTextColor(AppCompatResources.getColorStateList(r100, R.color.bitalbe_field_placeholder_color_with_disabled));
        if (fq4.d.f478415b != null) goto L5;
        fq4.d.f478415b = new fq4.d();
    L5:
        r105.setMovementMethod(fq4.d.f478415b);
        r105.setClickable(false);
        r105.setLongClickable(false);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.weight = 1.0f;
        addView(r105, r106);
        ImageView r107 = new ImageView(r100);
        this.f209902d = r107;
        r107.setVisibility(8);
        r107.setImageDrawable(AppCompatResources.getDrawable(r100, R.drawable.ud_icon_lock_filled));
        r107.setImageTintList(AppCompatResources.getColorStateList(r100, R.color.icon_n3));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(n.d(14), n.d(14));
        r108.setMargins(n.d(4), 0, 0, 0);
        addView(r107, r108);
        ImageView r109 = new ImageView(r100);
        this.f209901c = r109;
        r109.setImageDrawable(AppCompatResources.getDrawable(r100, R.drawable.ud_icon_down_bold_outlined));
        r109.setImageTintList(AppCompatResources.getColorStateList(r100, R.color.icon_n3));
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(n.d(14), n.d(14));
        r110.setMargins(n.d(9), 0, 0, 0);
        addView(r109, r110);
        AppCompatCheckBox r111 = new AppCompatCheckBox(r100);
        this.f209903e = r111;
        r111.setButtonDrawable(null);
        r111.setBackground(AppCompatResources.getDrawable(r100, R.drawable.bitable_card_checkbox_item_selector));
        r111.setVisibility(8);
        addView(r111, new LinearLayout.LayoutParams(n.d(24), n.d(24)));
    }

    public static void b(ConditionCellView r100, int r101) {
        r100.f209901c.setVisibility(0);
        r100.f209901c.setImageResource(r101);
    }

    public static void a(ConditionCellView r100, int r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        r100.f209900b.setVisibility(0);
        r100.f209900b.setImageResource(r101);
        r100.f209900b.setSyncIconVisible(r102);
    }
}
