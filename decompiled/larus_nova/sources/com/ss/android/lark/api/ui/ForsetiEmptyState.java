package com.ss.android.lark.api.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/api/ui/ForsetiEmptyState;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "imageSize", "textImageSpacing", "textSize", "", "setImageResource", "", "resId", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageSize", "dpSize", "setTextImageSpacing", "dp", "setTextSize", CloudControlInf.SP, "setDescColor", "color", "setDesc", "text", "", "dpToPx", "Companion", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiEmptyState extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f408682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f408683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f408684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f408685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f408686e;

    public static final class a {
    }

    static {
    }

    public ForsetiEmptyState(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ForsetiEmptyState(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setDesc(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f408683b.setText(r100);
    }

    public final void setDescColor(int r100) {
        this.f408683b.setTextColor(r100);
    }

    public final void setImageDrawable(Drawable r100) {
        this.f408682a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f408682a.setImageDrawable(r100);
    }

    public final void setImageResource(int r100) {
        setImageDrawable(UDIconUtils.getIconDrawable(getContext(), r100, getContext().getResources().getColor(R.color.ud_N900_08)));
    }

    public final void setImageSize(int r100) {
        this.f408684c = UIHelper.dp2px(r100);
        ImageView r101 = this.f408682a;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        int r103 = this.f408684c;
        r102.width = r103;
        r102.height = r103;
        r101.setLayoutParams(r102);
        requestLayout();
    }

    public final void setTextImageSpacing(int r100) {
        this.f408685d = UIHelper.dp2px(r100);
        ViewGroup.LayoutParams r101 = this.f408683b.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r101).topMargin = this.f408685d;
        requestLayout();
    }

    public final void setTextSize(float r100) {
        this.f408686e = r100;
        this.f408683b.setTextSize(r100);
        requestLayout();
    }

    public final void setDesc(int r100) {
        this.f408683b.setText(r100);
    }

    public ForsetiEmptyState(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f408684c = UIHelper.dp2px(65);
        this.f408685d = UIHelper.dp2px(30);
        this.f408686e = 14.0f;
        setOrientation(1);
        setGravity(17);
        ImageView r103 = new ImageView(r100);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 1;
        int r105 = this.f408684c;
        r104.width = r105;
        r104.height = r105;
        r103.setLayoutParams(r104);
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f408682a = r103;
        addView(r103);
        TextView r106 = new TextView(r100);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.topMargin = this.f408685d;
        r107.gravity = 1;
        r106.setLayoutParams(r107);
        r106.setGravity(17);
        r106.setTextColor(ContextCompat.getColor(r100, android.R.color.darker_gray));
        r106.setTextSize(this.f408686e);
        this.f408683b = r106;
        addView(r106);
    }

    public /* synthetic */ ForsetiEmptyState(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
