package com.bytedance.android.ui.ec.widget.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.ui.base.widget.icon.IconImageView;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 :2\u00020\u0001:\u0001:B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011J\u000e\u00100\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u00101\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00102\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u0010\u00103\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00104\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u00105\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011J\u000e\u00106\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u00107\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00108\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u00109\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0013R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/titlebar/ECTitleBar;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_$_findViewCache", "", "Landroid/view/View;", "hideDividerLine", "", "leftIconColorStateList", "Landroid/content/res/ColorStateList;", "leftIconDrawable", "Landroid/graphics/drawable/Drawable;", "leftText", "", "leftTextColorStateList", "leftTextSize", "", "rightIconColorStateList", "rightIconDrawable", "rightText", "rightTextColorStateList", "rightTextSize", "showLeftIcon", "showLeftText", "showRightIcon", "showRightText", "titleText", "titleTextSize", "_$_findCachedViewById", "id", "applyIconState", "", "applyState", "applyTextState", "onAttachedToWindow", "setLeftIconClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setLeftIconColor", "color", "setLeftIconDrawable", "drawable", "setLeftText", "setLeftTextClickListener", "setLeftTextColor", "setRightIconClickListener", "setRightIconColor", "setRightIconDrawable", "setRightText", "setRightTextClickListener", "setRightTextColor", "setTitleText", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTitleBar extends RoundConstraintLayout {
    public static final Companion Companion = null;
    private static final float DEFAULT_BUTTON_TEXT_SIZE = 15.0f;
    private static final float DEFAULT_TITLE_TEXT_SIZE = 17.0f;
    private Map<Integer, View> _$_findViewCache;
    private boolean hideDividerLine;
    private ColorStateList leftIconColorStateList;
    private Drawable leftIconDrawable;
    private CharSequence leftText;
    private ColorStateList leftTextColorStateList;
    private float leftTextSize;
    private ColorStateList rightIconColorStateList;
    private Drawable rightIconDrawable;
    private CharSequence rightText;
    private ColorStateList rightTextColorStateList;
    private float rightTextSize;
    private boolean showLeftIcon;
    private boolean showLeftText;
    private boolean showRightIcon;
    private boolean showRightText;
    private CharSequence titleText;
    private float titleTextSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/titlebar/ECTitleBar$Companion;", "", "()V", "DEFAULT_BUTTON_TEXT_SIZE", "", "DEFAULT_TITLE_TEXT_SIZE", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECTitleBar(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECTitleBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    private final void applyIconState() {
        if (this.showLeftIcon == false) goto L13;
        ColorStateList r0 = this.leftIconColorStateList;
        if (r0 == null) goto L9;
        IconImageView r5 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r5 == null) goto L13;
        r5.setIconColor(r0);
        goto L13
    L9:
        IconImageView r1 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r1 == null) goto L13;
        IconImageView.setIconColor$default(r1, 2131101730, 0, 2, null);
    L13:
        if (this.showRightIcon == false) goto L23;
        ColorStateList r2 = this.rightIconColorStateList;
        if (r2 == null) goto L19;
        IconImageView r3 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r3 == null) goto L24;
        r3.setIconColor(r2);
        return;
    L24:
        return;
    L19:
        IconImageView r4 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r4 == null) goto L26;
        IconImageView.setIconColor$default(r4, 2131101730, 0, 2, null);
        return;
    L26:
        return;
    }

    private final void applyTextState() {
        ColorStateList r0 = this.leftTextColorStateList;
        if (r0 == null) goto L7;
        TextView r1 = (TextView) _$_findCachedViewById(2131390853);
        if (r1 == null) goto L7;
        r1.setTextColor(r0);
    L7:
        ColorStateList r2 = this.rightTextColorStateList;
        if (r2 == null) goto L13;
        TextView r3 = (TextView) _$_findCachedViewById(2131391310);
        if (r3 == null) goto L14;
        r3.setTextColor(r2);
        return;
    L14:
        return;
    }

    private final void applyState() {
        TextView r0 = (TextView) _$_findCachedViewById(2131391606);
        if (r0 == null) goto L6;
        r0.setText(this.titleText);
        r0.setTextSize(0, this.titleTextSize);
    L6:
        if (this.showLeftText == false) goto L14;
        AppCompatImageView r1 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        TextView r2 = (TextView) _$_findCachedViewById(2131390853);
        if (r2 == null) goto L28;
        r2.setVisibility(0);
        r2.setText(this.leftText);
        r2.setTextSize(0, this.leftTextSize);
    L28:
        if (this.showRightText == false) goto L36;
        AppCompatImageView r3 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r3 == null) goto L32;
        r3.setVisibility(8);
    L32:
        TextView r4 = (TextView) _$_findCachedViewById(2131391310);
        if (r4 == null) goto L50;
        r4.setVisibility(0);
        r4.setText(this.rightText);
        r4.setTextSize(0, this.rightTextSize);
    L50:
        if (this.hideDividerLine == false) goto L54;
        View r5 = _$_findCachedViewById(2131369232);
        if (r5 == null) goto L58;
        r5.setVisibility(8);
    L58:
        if (this.leftIconDrawable == null) goto L63;
        IconImageView r6 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r6 == null) goto L63;
        r6.setImageDrawable(this.leftIconDrawable);
    L63:
        if (this.rightIconDrawable == null) goto L67;
        IconImageView r7 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r7 == null) goto L67;
        r7.setImageDrawable(this.rightIconDrawable);
    L67:
        applyIconState();
        applyTextState();
        return;
    L54:
        View r8 = _$_findCachedViewById(2131369232);
        if (r8 == null) goto L58;
        r8.setVisibility(0);
        goto L58
    L36:
        if (this.showRightIcon == false) goto L43;
        AppCompatImageView r9 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r9 == null) goto L40;
        r9.setVisibility(0);
    L40:
        TextView r10 = (TextView) _$_findCachedViewById(2131391310);
        if (r10 == null) goto L50;
        r10.setVisibility(8);
        goto L50
    L43:
        AppCompatImageView r11 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r11 == null) goto L46;
        r11.setVisibility(8);
    L46:
        TextView r12 = (TextView) _$_findCachedViewById(2131391310);
        if (r12 == null) goto L50;
        r12.setVisibility(8);
        goto L50
    L14:
        if (this.showLeftIcon == false) goto L21;
        AppCompatImageView r13 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r13 == null) goto L18;
        r13.setVisibility(0);
    L18:
        TextView r14 = (TextView) _$_findCachedViewById(2131390853);
        if (r14 == null) goto L28;
        r14.setVisibility(8);
        goto L28
    L21:
        AppCompatImageView r15 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r15 == null) goto L24;
        r15.setVisibility(8);
    L24:
        TextView r16 = (TextView) _$_findCachedViewById(2131390853);
        if (r16 == null) goto L28;
        r16.setVisibility(8);
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        ArrayList r1 = new ArrayList();
        AppCompatImageView r0 = (IconImageView) _$_findCachedViewById(2131376346);
        TextView r2 = null;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L13:
        TextView r4 = (TextView) _$_findCachedViewById(2131390853);
        if (r4 != null) goto L16;
    L24:
        AppCompatImageView r5 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r5 != null) goto L27;
    L35:
        TextView r6 = (TextView) _$_findCachedViewById(2131391310);
        if (r6 != null) goto L38;
    L45:
        ViewExtensionsKt.increaseHitAreaForViews$default(this, r1, 0, 0, 6, null);
        return;
    L38:
        if (r6.getVisibility() == 0) goto L41;
        r3 = false;
    L41:
        if (r3 == false) goto L43;
        r2 = r6;
    L43:
        if (r2 == null) goto L45;
        r1.add(r2);
        goto L45
    L27:
        if (r5.getVisibility() != 0) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == true) goto L33;
        r5 = null;
    L33:
        if (r5 == null) goto L35;
        r1.add(r5);
        goto L35
    L29:
        r7 = false;
        goto L30
    L16:
        if (r4.getVisibility() != 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
        r1.add(r4);
        goto L24
    L18:
        r8 = false;
        goto L19
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r1.add(r0);
        goto L13
    L7:
        r9 = false;
        goto L8
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new LinkedHashMap();
    L5:
        View r0 = this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setLeftIconClickListener(View.OnClickListener r2) {
        AppCompatImageView r0 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setLeftIconColor(int r2) {
        if (r2 == 0) goto L4;
        this.leftIconColorStateList = ColorStateList.valueOf(r2);
    L4:
        ColorStateList r3 = this.leftIconColorStateList;
        if (r3 == null) goto L10;
        IconImageView r0 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r0 == null) goto L11;
        r0.setIconColor(r3);
        return;
    L11:
        return;
    }

    public final void setLeftIconDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.leftIconDrawable = r2;
        IconImageView r0 = (IconImageView) _$_findCachedViewById(2131376346);
        if (r0 == null) goto L5;
        r0.setImageDrawable(r2);
    L5:
        applyIconState();
    }

    public final void setLeftText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "leftText");
        this.leftText = r2;
        TextView r0 = (TextView) _$_findCachedViewById(2131390853);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setLeftTextClickListener(View.OnClickListener r2) {
        TextView r0 = (TextView) _$_findCachedViewById(2131390853);
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setLeftTextColor(int r2) {
        if (r2 == 0) goto L4;
        this.leftTextColorStateList = ColorStateList.valueOf(r2);
    L4:
        ColorStateList r3 = this.leftTextColorStateList;
        if (r3 == null) goto L10;
        TextView r0 = (TextView) _$_findCachedViewById(2131390853);
        if (r0 == null) goto L11;
        r0.setTextColor(r3);
        return;
    L11:
        return;
    }

    public final void setRightIconClickListener(View.OnClickListener r2) {
        AppCompatImageView r0 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setRightIconColor(int r2) {
        if (r2 == 0) goto L4;
        this.rightIconColorStateList = ColorStateList.valueOf(r2);
    L4:
        ColorStateList r3 = this.rightIconColorStateList;
        if (r3 == null) goto L10;
        IconImageView r0 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r0 == null) goto L11;
        r0.setIconColor(r3);
        return;
    L11:
        return;
    }

    public final void setRightIconDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.rightIconDrawable = r2;
        IconImageView r0 = (IconImageView) _$_findCachedViewById(2131376557);
        if (r0 == null) goto L5;
        r0.setImageDrawable(r2);
    L5:
        applyIconState();
    }

    public final void setRightText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "rightText");
        this.rightText = r2;
        TextView r0 = (TextView) _$_findCachedViewById(2131391310);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setRightTextClickListener(View.OnClickListener r2) {
        TextView r0 = (TextView) _$_findCachedViewById(2131391310);
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setRightTextColor(int r2) {
        if (r2 == 0) goto L4;
        this.rightTextColorStateList = ColorStateList.valueOf(r2);
    L4:
        ColorStateList r3 = this.rightTextColorStateList;
        if (r3 == null) goto L10;
        TextView r0 = (TextView) _$_findCachedViewById(2131391310);
        if (r0 == null) goto L11;
        r0.setTextColor(r3);
        return;
    L11:
        return;
    }

    public final void setTitleText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "titleText");
        this.titleText = r2;
        TextView r0 = (TextView) _$_findCachedViewById(2131391606);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECTitleBar(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this._$_findViewCache = new LinkedHashMap();
        String r7 = "";
        this.titleText = "";
        this.rightText = "";
        this.leftText = "";
        this.showLeftIcon = true;
        LayoutInflater.from(r4).inflate(2131560678, this, true);
        if (r5 == null) goto L17;
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130970205, 2130972501, 2130972502, 2130972509, 2130972510, 2130972511, 2130973782, 2130973783, 2130973789, 2130973790, 2130973791, 2130974066, 2130974067, 2130974075, 2130974076, 2130974574, 2130974591});
        String r9 = r8.getString(15);
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        this.titleText = r9;
        this.titleTextSize = r8.getDimension(16, TypedValue.applyDimension(1, DEFAULT_TITLE_TEXT_SIZE, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.leftTextSize = r8.getDimension(5, TypedValue.applyDimension(1, DEFAULT_BUTTON_TEXT_SIZE, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.rightTextSize = r8.getDimension(10, TypedValue.applyDimension(1, DEFAULT_BUTTON_TEXT_SIZE, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        String r10 = r8.getString(3);
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        this.leftText = r10;
        String r11 = r8.getString(8);
        if (r11 == null) goto L15;
        r7 = r11;
    L15:
        this.rightText = r7;
        this.showLeftText = r8.getBoolean(12, this.showLeftText);
        this.showLeftIcon = r8.getBoolean(11, this.showLeftIcon);
        this.showRightText = r8.getBoolean(14, this.showRightText);
        this.showRightIcon = r8.getBoolean(13, this.showRightIcon);
        this.hideDividerLine = r8.getBoolean(0, this.hideDividerLine);
        this.leftIconColorStateList = r8.getColorStateList(1);
        this.rightIconColorStateList = r8.getColorStateList(6);
        this.leftTextColorStateList = r8.getColorStateList(4);
        this.rightTextColorStateList = r8.getColorStateList(9);
        this.leftIconDrawable = r8.getDrawable(2);
        this.rightIconDrawable = r8.getDrawable(7);
        r8.recycle();
        applyState();
        return;
    }

    public static /* synthetic */ void setLeftIconColor$default(ECTitleBar r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.setLeftIconColor(r1);
    }

    public static /* synthetic */ void setLeftTextColor$default(ECTitleBar r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.setLeftTextColor(r1);
    }

    public static /* synthetic */ void setRightIconColor$default(ECTitleBar r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.setRightIconColor(r1);
    }

    public static /* synthetic */ void setRightTextColor$default(ECTitleBar r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.setRightTextColor(r1);
    }

    public /* synthetic */ ECTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
