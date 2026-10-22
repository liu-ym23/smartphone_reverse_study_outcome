package com.larus.canvas.feature.component.title.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.impl.databinding.LarusCanvasTitleBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ly8.a;
import ly8.b;
import ly8.c;
import ly8.d;
import ly8.e;
import ly8.f;
import v19.c7;
import v19.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J'\u0010\u001b\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010#\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010%\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010'\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/canvas/feature/component/title/widget/CanvasTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/canvas/impl/databinding/LarusCanvasTitleBinding;", "getBinding", "()Lcom/larus/canvas/impl/databinding/LarusCanvasTitleBinding;", "onClickLeftIcon", "Lkotlin/Function0;", "", "onClickRightIcon", "onClickCenterText", "onLongClickCenterText", "setCenterText", "text", "", "setCenterImgResource", "resId", "(Ljava/lang/Integer;)V", "setLeftIcon", "setRightButton", "textColor", DyPayConstant.KEY_SHOW_LOADING, "", "(Ljava/lang/String;Ljava/lang/Integer;Z)V", "setRightVisibility", "visible", "setCenterVisibility", "setOnClickLeftIcon", "block", "setOnClickRightIcon", "setOnClickCenterText", "setOnLongClickCenterText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasTitleView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f323717f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCanvasTitleBinding f323718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f323719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f323720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f323721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f323722e;

    public CanvasTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CanvasTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LarusCanvasTitleBinding getBinding() {
        return this.f323718a;
    }

    public final void setCenterImgResource(Integer r100) {
        if (r100 != null) goto L4;
        this.f323718a.f323754b.setVisibility(8);
        return;
    L4:
        this.f323718a.f323754b.setVisibility(0);
        this.f323718a.f323754b.setImageResource(r100.intValue());
    }

    public final void setCenterText(String r100) {
        this.f323718a.f323755c.setText(r100);
    }

    public final void setCenterVisibility(boolean r100) {
        TextView r101 = this.f323718a.f323755c;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        ImageView r104 = this.f323718a.f323754b;
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        r104.setVisibility(r102);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final void setLeftIcon(Integer r100) {
        if (r100 != null) goto L4;
        this.f323718a.f323756d.setVisibility(8);
        return;
    L4:
        boolean r101 = false;
        this.f323718a.f323756d.setVisibility(0);
        AppCompatImageView r102 = this.f323718a.f323756d;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L24;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r100.intValue() != R.drawable.larus_ic_canvas_button_back) goto L10;
        r101 = true;
    L10:
        if (r101 == false) goto L12;
        int r105 = 36;
    L13:
        r104.width = c7.b(r105);
        if (r101 == false) goto L16;
        int r106 = 36;
    L17:
        r104.height = c7.b(r106);
        if (r101 == false) goto L20;
        int r107 = 12;
    L21:
        r104.setMarginStart(c7.b(Integer.valueOf(r107)));
        r102.setLayoutParams(r104);
        this.f323718a.f323756d.setImageResource(r100.intValue());
        return;
    L20:
        r107 = 16;
        goto L21
    L16:
        r106 = 44;
        goto L17
    L12:
        r105 = 44;
        goto L13
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnClickCenterText(Function0<Unit> r100) {
        this.f323721d = r100;
    }

    public final void setOnClickLeftIcon(Function0<Unit> r100) {
        this.f323719b = r100;
    }

    public final void setOnClickRightIcon(Function0<Unit> r100) {
        this.f323720c = r100;
    }

    public final void setOnLongClickCenterText(Function0<Unit> r100) {
        this.f323722e = r100;
    }

    public final void setRightVisibility(boolean r100) {
        TextView r101 = this.f323718a.f323758f;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public CanvasTitleView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_canvas_title, this);
        int r113 = R.id.center_img;
        ImageView r114 = (ImageView) ViewBindings.findChildViewById(this, R.id.center_img);
        if (r114 == null) goto L22;
        r113 = R.id.center_text;
        TextView r100 = (TextView) ViewBindings.findChildViewById(this, R.id.center_text);
        if (r100 == null) goto L22;
        r113 = R.id.left_img;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.left_img);
        if (r101 == null) goto L22;
        r113 = R.id.right_loading;
        ProgressBar r102 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.right_loading);
        if (r102 == null) goto L22;
        r113 = R.id.right_text;
        TextView r115 = (TextView) ViewBindings.findChildViewById(this, R.id.right_text);
        if (r115 == null) goto L22;
        this.f323718a = new LarusCanvasTitleBinding(this, r114, r100, r101, r102, r115);
        if (Build.VERSION.SDK_INT >= 28) goto L15;
        r100.setTypeface(r100.getTypeface(), 1);
    L15:
        r100.getPaint().setFakeBoldText(true);
        e1.d(r101, new a(this));
        e1.d(r115, new b(this));
        e1.d(r100, new c(this));
        e1.d(r114, new d(this));
        r100.setOnLongClickListener(new e(this));
        r114.setOnLongClickListener(new f(this));
        r100.setHapticFeedbackEnabled(false);
        r114.setHapticFeedbackEnabled(false);
        boolean r116 = h.f552477a;
        if (h.a(null) == false) goto L18;
        Drawable r117 = ContextCompat.getDrawable(r110, R.drawable.larus_ic_common_download_loading_animated);
    L19:
        r102.setIndeterminateDrawable(r117);
        return;
    L18:
        r117 = ContextCompat.getDrawable(r110, R.drawable.larus_ic_common_download_loading_animated_black);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ CanvasTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
