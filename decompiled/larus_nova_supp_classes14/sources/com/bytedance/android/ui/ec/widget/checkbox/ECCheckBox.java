package com.bytedance.android.ui.ec.widget.checkbox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.ui.ec.widget.tools.DrawableHelper;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0014J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0012\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\u0018J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\nJ\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "checkedColorFilter", "Landroid/graphics/ColorFilter;", "colorChecked", "colorUnchecked", "disableClick", "iconSize", "isChecked", "onCheckedChangeListener", "Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$OnCheckedChangeListener;", "shape", "size", "uncheckedColorFilter", "createColorFilter", "", "init", "onAttachedToWindow", "onCreateDrawableState", "", "extraSpace", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "setChecked", "newValue", "setOnCheckedChangeListener", "listener", "setShape", "type", "setSize", "syncButtonCheckState", "syncDrawableStyle", "toggle", "Companion", "OnCheckedChangeListener", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int CIRCLE = 0;
    public static final Companion Companion = null;
    public static final int LARGE = 1;
    public static final int SMALL = 0;
    public static final int SQUARE = 1;
    private boolean adaptForCSR;
    private Drawable buttonDrawable;
    private ColorFilter checkedColorFilter;
    private int colorChecked;
    private int colorUnchecked;
    private boolean disableClick;
    private int iconSize;
    private boolean isChecked;
    private OnCheckedChangeListener onCheckedChangeListener;
    private int shape;
    private int size;
    private ColorFilter uncheckedColorFilter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$Companion;", "", "()V", "CHECKED_STATE_SET", "", "CIRCLE", "", "LARGE", "SMALL", "SQUARE", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "buttonView", "Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox;", "isChecked", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnCheckedChangeListener {
        void onCheckedChanged(ECCheckBox r1, boolean r2);
    }

    static {
        Companion = new Companion(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    private final void createColorFilter() {
        int r0 = this.colorChecked;
        if (r0 == (-1)) goto L6;
        this.checkedColorFilter = DrawableHelper.INSTANCE.createTintBlackColorFilter(r0);
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void syncDrawableStyle() {
        int r0 = this.shape;
        if (r0 != 0) goto L5;
        Drawable r1 = getResources().getDrawable(2131234486);
    L8:
        this.buttonDrawable = r1;
        setImageDrawable(r1);
        return;
    L5:
        if (r0 == 0) goto L7;
        r1 = getResources().getDrawable(2131234487);
        goto L8
    L7:
        r1 = getResources().getDrawable(2131234486);
        goto L8
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void syncButtonCheckState() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L5;
        r0.clearColorFilter();
    L5:
        createColorFilter();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.isChecked == false) goto L10;
        ColorFilter r2 = this.checkedColorFilter;
    L11:
        r1.setColorFilter(r2);
        return;
    L10:
        r2 = this.uncheckedColorFilter;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.ImageView*/.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        ViewExtensionsKt.expandTouchArea(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean performClick() {
        toggle();
        boolean r0 = super/*android.widget.ImageView*/.performClick();
        if (r0 == true) goto L5;
        playSoundEffect(0);
    L5:
        return r0;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    public ECCheckBox(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r8, null, 0, 4, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super/*android.widget.ImageView*/.onCreateDrawableState(r2 + 1);
        if (this.isChecked == false) goto L5;
        access$mergeDrawableStates$s2666181(r3, CHECKED_STATE_SET);
    L5:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.disableClick == false) goto L7;
        return false;
    L7:
        return super/*android.widget.ImageView*/.onTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.isChecked == r2) goto L8;
        this.isChecked = r2;
        syncButtonCheckState();
        refreshDrawableState();
        OnCheckedChangeListener r3 = this.onCheckedChangeListener;
        if (r3 == null) goto L9;
        r3.onCheckedChanged(this, this.isChecked);
        return;
    L9:
        return;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.onCheckedChangeListener = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setShape(int r1) {
        this.shape = r1;
        syncDrawableStyle();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSize(int r3) {
        this.size = r3;
        if (r3 != 0) goto L5;
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    L6:
        this.iconSize = r4;
        requestLayout();
        return;
    L5:
        r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        goto L6
    }

    public ECCheckBox(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "attrs");
        super(r8, r9);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r8, r9, 0, 4, null);
    }

    public static final /* synthetic */ int[] access$mergeDrawableStates$s2666181(int[] r0, int[] r1) {
        return View.mergeDrawableStates(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r3, int r4) {
        int r0 = this.iconSize;
        if (r0 <= 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L5:
        int r1 = this.iconSize;
        if (r1 <= 0) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
    L8:
        super/*android.widget.ImageView*/.onMeasure(r3, r4);
    }

    public ECCheckBox(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130968754, 2130969176, 2130969177, 2130969178, 2130969179, 2130969180, 2130969756}, r5, 0);
        this.shape = r6.getInt(3, 0);
        this.size = r6.getInt(4, 0);
        this.adaptForCSR = r6.getBoolean(0, true);
        this.colorChecked = r6.getColor(2, -1);
        this.colorUnchecked = r6.getColor(5, -1);
        Drawable r7 = r6.getDrawable(1);
        if (r7 != null) goto L5;
        r7 = getResources().getDrawable(2131234486);
    L5:
        this.buttonDrawable = r7;
        this.disableClick = r6.getBoolean(6, false);
        r6.recycle();
        createColorFilter();
        setShape(this.shape);
        setSize(this.size);
        setBackgroundDrawable(null);
        syncButtonCheckState();
        setClickable(true);
    }

    public static /* synthetic */ void init$default(ECCheckBox r0, Context r1, AttributeSet r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 2130968641;
    L5:
        r0.init(r1, r2, r3);
    }
}
