package com.larus.avlink.simulInterpret.page.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.dtf.face.config.IConstValues;
import com.larus.avlink.impl.databinding.LayoutTitleViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u000fJ\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/TitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutTitleViewBinding;", "thumbAnimator", "Landroid/animation/ValueAnimator;", "isCurrentThumbRight", "", "onBackButtonClick", "Lkotlin/Function0;", "", "getOnBackButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "onSettingIconClick", "getOnSettingIconClick", "setOnSettingIconClick", "onSwitchButtonClick", "Lkotlin/Function1;", "getOnSwitchButtonClick", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchButtonClick", "(Lkotlin/jvm/functions/Function1;)V", "updateForOnBoarding", "updateForListening", "updateForTranslating", "updateSwitchButtonTextColor", "isThumbRight", "applyThumbPositionWhenLaidOut", "setTitleBar", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "animateThumbTo", "toRight", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f294542g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutTitleViewBinding f294543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f294544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f294545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f294546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f294547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f294548f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294549a = null;

        static {
            int[] r100 = new int[DoraDeviceType.values().length];
            r100[DoraDeviceType.DEVICE_G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f294549a = r100;
        }
    }

    public TitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnBackButtonClick() {
        return this.f294546d;
    }

    public final Function0<Unit> getOnSettingIconClick() {
        return this.f294547e;
    }

    public final Function1<Boolean, Unit> getOnSwitchButtonClick() {
        return this.f294548f;
    }

    public final void R5(final boolean r100) {
        ValueAnimator r101 = this.f294544b;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        if (r100 == false) goto L7;
        TextView r102 = this.f294543a.f293351d;
    L8:
        Intrinsics.checkNotNull(r102);
        if (r102.getWidth() != 0) goto L11;
    L15:
        this.f294543a.f293349b.post(new v(this, r100));
        return;
    L11:
        if (this.f294543a.f293349b.getWidth() == 0) goto L15;
        S5(r100);
        final int r103 = r102.getWidth();
        final int r104 = r102.getLeft();
        final int r105 = this.f294543a.f293352e.getWidth();
        final int r106 = this.f294543a.f293352e.getLeft();
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r107.setDuration(300);
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        r107.addUpdateListener(new w(this, r105, r103, r106, r104));
        r107.start();
        this.f294544b = r107;
        return;
    L7:
        r102 = this.f294543a.f293350c;
        goto L8
    }

    public final void S5(boolean r100) {
        int r101 = ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100));
        int r102 = ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50));
        if (r100 == false) goto L5;
        this.f294543a.f293350c.setTextColor(r102);
        this.f294543a.f293351d.setTextColor(r101);
        return;
    L5:
        this.f294543a.f293350c.setTextColor(r101);
        this.f294543a.f293351d.setTextColor(r102);
    }

    public final void setOnBackButtonClick(Function0<Unit> r100) {
        this.f294546d = r100;
    }

    public final void setOnSettingIconClick(Function0<Unit> r100) {
        this.f294547e = r100;
    }

    public final void setOnSwitchButtonClick(Function1<? super Boolean, Unit> r100) {
        this.f294548f = r100;
    }

    public TitleView(Context r110, AttributeSet r210, int r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r210, r211);
        View r100 = LayoutInflater.from(r110).inflate(R.layout.layout_title_view, this, false);
        addView(r100);
        int r101 = R.id.back_button;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.back_button);
        if (r102 == null) goto L23;
        r101 = R.id.right_setting_icon;
        ImageView r111 = (ImageView) ViewBindings.findChildViewById(r100, R.id.right_setting_icon);
        if (r111 == null) goto L23;
        r101 = R.id.switch_button_group;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.switch_button_group);
        if (r103 == null) goto L23;
        r101 = R.id.switch_button_left_text;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r100, R.id.switch_button_left_text);
        if (r112 == null) goto L23;
        r101 = R.id.switch_button_right_text;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r100, R.id.switch_button_right_text);
        if (r113 == null) goto L23;
        r101 = R.id.switch_button_thumb;
        View r114 = ViewBindings.findChildViewById(r100, R.id.switch_button_thumb);
        if (r114 == null) goto L23;
        r101 = R.id.toolbar_sub_title;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.toolbar_sub_title);
        if (r115 == null) goto L23;
        r101 = R.id.toolbar_title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.toolbar_title);
        if (r116 == null) goto L23;
        r101 = R.id.toolbar_title_group;
        ConstraintLayout r117 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.toolbar_title_group);
        if (r117 == null) goto L23;
        this.f294543a = new LayoutTitleViewBinding((ConstraintLayout) r100, r102, r111, r103, r112, r113, r114, r115, r116, r117);
        r102.setOnClickListener(new r(this));
        r111.setOnClickListener(new s(this));
        r112.setOnClickListener(new t(this));
        r113.setOnClickListener(new u(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public /* synthetic */ TitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
