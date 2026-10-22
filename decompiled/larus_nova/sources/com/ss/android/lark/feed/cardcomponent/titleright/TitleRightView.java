package com.ss.android.lark.feed.cardcomponent.titleright;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/titleright/TitleRightView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "flagView", "Landroidx/appcompat/widget/AppCompatImageView;", "setTextViewColorRes", "", "timeColorRes", "", "setTextViewTextSize", "textSize", "init", "createTimeOrStatusView", "createFlagView", "bind", "text", "", "flagDrawable", "Landroid/graphics/drawable/Drawable;", "status", "Lcom/ss/android/lark/feed/cardcomponent/titleright/TitleRightComponent$Status;", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightView extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f420989c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f420990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f420991b;

    public static final class a {
    }

    static {
        f420989c = UIHelper.dp2px(3.0f);
    }

    public TitleRightView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setTextViewColorRes(int r100) {
        TextView r101 = this.f420990a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r101 = null;
    L5:
        r101.setTextColor(UDColorUtils.getColor(getContext(), r100));
    }

    public final void setTextViewTextSize(int r100) {
        TextView r101 = this.f420990a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r101 = null;
    L5:
        r101.setTextSize(0, b.h(getContext(), r100));
    }

    public TitleRightView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        TextView r102 = new TextView(r100);
        r102.setTextColor(UDColorUtils.getColor(r100, R.color.text_placeholder));
        r102.setTextSize(0, b.h(r100, 14));
        this.f420990a = r102;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-2, -2);
        r103.startToStart = 0;
        r103.endToEnd = 0;
        r103.topToTop = 0;
        r103.bottomToBottom = 0;
        View r104 = this.f420990a;
        View r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r104 = null;
    L5:
        addView(r104, r103);
        AppCompatImageView r106 = new AppCompatImageView(r100);
        r106.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f420991b = r106;
        int r107 = b.g(r100, 12);
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(r107, r107);
        r108.startToStart = 0;
        r108.endToEnd = 0;
        r108.topToTop = 0;
        r108.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = f420989c;
        View r109 = this.f420991b;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
    L9:
        addView(r105, r108);
        return;
    L8:
        r105 = r109;
        goto L9
    }
}
