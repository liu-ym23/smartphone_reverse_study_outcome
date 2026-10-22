package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.common.util.j;
import com.larus.bot.impl.databinding.LarusLayoutBotEditImageDragAjustBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.w0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;
import yu8.a;
import yu8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\"\u0010\u0017\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0013\u0010\u0018\u001a\u00020\u000f2\u000b\u0010\u0019\u001a\u00070\u0007¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotEditImageDragAjustBinding;", "centerMargin", "onClickPlus", "Lkotlin/Function0;", "", "onClickDelete", "preUIState", "getPreUIState$annotations", "()V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initListener", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer$ReferenceImageUIState;", "getIllustrationHeight", "width", "showEmpty", "showUploading", "onImageFilled", "ReferenceImageUIState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceImageContainer extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f318861f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutBotEditImageDragAjustBinding f318862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f318863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f318864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f318865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f318866e;

    @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer$ReferenceImageUIState;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReferenceImageUIState {
        public static final a Companion = null;
        public static final int EMPTY = 0;
        public static final int FILLED = 2;
        public static final int UPLOADING = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f318867a = null;

            static {
                f318867a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f318867a;
        }
    }

    public ReferenceImageContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReferenceImageContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @ReferenceImageUIState
    private static /* synthetic */ void getPreUIState$annotations() {
    }

    public final void R5(int r100) {
        if (this.f318866e != r100) goto L5;
        return;
    L5:
        this.f318866e = r100;
        if (r100 != 0) goto L8;
        this.f318862a.f317857c.setEnabled(true);
        e1.o(this.f318862a.f317858d);
        e1.x(this.f318862a.f317856b);
        e1.o(this.f318862a.f317862h);
        e1.x(this.f318862a.f317861g);
        LarusLayoutBotEditImageDragAjustBinding r101 = this.f318862a;
        r101.f317859e.setText(r101.f317855a.getContext().getString(R.string.larus_ref_image_btn));
        this.f318862a.f317859e.setTextColor(ContextCompat.getColor(getContext(), R.color.larus_primary_50));
        this.f318862a.f317860f.setText(getContext().getString(R.string.larus_enhance_image_tip));
        return;
    L8:
        if (r100 != 1) goto L10;
        this.f318862a.f317857c.setEnabled(false);
        e1.x(this.f318862a.f317856b);
        e1.o(this.f318862a.f317858d);
        e1.o(this.f318862a.f317861g);
        e1.x(this.f318862a.f317862h);
        this.f318862a.f317859e.setText(getContext().getString(R.string.larus_ref_image_uploading));
        this.f318862a.f317859e.setTextColor(ContextCompat.getColor(getContext(), R.color.larus_neutral_30));
        return;
    L10:
        if (r100 != 2) goto L18;
        this.f318862a.f317857c.setEnabled(false);
        e1.o(this.f318862a.f317856b);
        e1.x(this.f318862a.f317858d);
        this.f318862a.f317860f.setText(getContext().getString(R.string.larus_reposition_image_tip));
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = j.b(this.f318862a.f317860f, getContext().getString(R.string.larus_enhance_image_tip), r102).getHeight();
        int r105 = RangesKt.coerceAtMost(r102 - c7.b(32), (r103 - r104) - this.f318863b);
        MyClickablePassThroughView r106 = this.f318862a.f317857c;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L7;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r108.width = r105;
        r108.height = r105;
        r106.setLayoutParams(r108);
        w0.e(this.f318862a.f317857c, (int) ((((double) r105) * 0.1d) + 0.5d));
        super.onMeasure(r100, r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public ReferenceImageContainer(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_bot_edit_image_drag_ajust, this);
        int r113 = R.id.center_button;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.center_button);
        if (r100 == null) goto L19;
        r113 = R.id.crop_fragment_container;
        MyClickablePassThroughView r114 = (MyClickablePassThroughView) ViewBindings.findChildViewById(this, R.id.crop_fragment_container);
        if (r114 == null) goto L19;
        r113 = R.id.delete_btn;
        FrameLayout r115 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.delete_btn);
        if (r115 == null) goto L19;
        r113 = R.id.desc;
        TextView r101 = (TextView) ViewBindings.findChildViewById(this, R.id.desc);
        if (r101 == null) goto L19;
        r113 = R.id.illustration;
        TextView r102 = (TextView) ViewBindings.findChildViewById(this, R.id.illustration);
        if (r102 == null) goto L19;
        r113 = R.id.plus;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(this, R.id.plus);
        if (r103 == null) goto L19;
        r113 = R.id.uploading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.uploading);
        if (r104 == null) goto L19;
        this.f318862a = new LarusLayoutBotEditImageDragAjustBinding(this, r100, r114, r115, r101, r102, r103, r104);
        this.f318863b = c7.b(16);
        Function0<Unit> r116 = new a(this);
        Intrinsics.checkNotNullParameter(r116, "onInvoke");
        r114.f318858e = r116;
        e1.d(r115, new b(this));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ ReferenceImageContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
