package com.ss.android.lark.widget.light.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/widget/light/image/ImageGalleryItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageParent", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "imageView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "captionText", "Landroid/widget/TextView;", "longImageText", "setupConstraints", "", "dp2px", "", "setImageSize", "width", "height", "setCaption", "text", "", "setLongImageTextVisible", "visible", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageGalleryItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LKUIRoundedImageView2 f446039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f446040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f446041c;

    public ImageGalleryItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImageGalleryItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int R5(float r100) {
        return UIUtils.dp2px(getContext(), r100);
    }

    public final void setCaption(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f446040b.setText(r100);
    }

    public final void setLongImageTextVisible(boolean r100) {
        TextView r101 = this.f446041c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public ImageGalleryItemView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LKUIRoundableLayout r113 = new LKUIRoundableLayout(r110, null, 6, 0);
        r113.setId(ViewGroup.generateViewId());
        r113.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        r113.setRadius(4.0f);
        r113.setBorderMode(0);
        r113.setBorderWidth(0.5f);
        r113.setBorderColor(UIUtils.getColor(r110, R.color.line_divider_default));
        LKUIRoundedImageView2 r100 = new LKUIRoundedImageView2(r110, null, 0, 6, null);
        r100.setId(ViewGroup.generateViewId());
        r100.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        r100.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r100.setBackgroundResource(R.color.N900_5);
        this.f446039a = r100;
        TextView r101 = new TextView(r110);
        r101.setId(ViewGroup.generateViewId());
        r101.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        r101.setTextColor(UIUtils.getColor(r110, R.color.text_caption));
        r101.setTextSize(14.0f);
        this.f446040b = r101;
        TextView r102 = new TextView(r110);
        r102.setId(ViewGroup.generateViewId());
        r102.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        r102.setTextColor(UIUtils.getColor(r110, R.color.static_white));
        r102.setTextSize(10.0f);
        r102.setText(r110.getString(R.string.Lark_Groups_PostPhotostrip));
        r102.setPadding(R5(4.0f), R5(1.0f), R5(4.0f), R5(1.0f));
        this.f446041c = r102;
        addView(r113);
        r113.addView(r100);
        addView(r101);
        addView(r102);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        r115.topToTop = 0;
        r115.startToStart = 0;
        r115.endToEnd = 0;
        ViewGroup.LayoutParams r116 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        r117.topToBottom = r113.getId();
        r117.startToStart = r113.getId();
        r117.endToEnd = r113.getId();
        ((ViewGroup.MarginLayoutParams) r117).topMargin = R5(6.0f);
        ViewGroup.LayoutParams r118 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        r119.endToEnd = r113.getId();
        r119.bottomToBottom = r113.getId();
        ((ViewGroup.MarginLayoutParams) r119).bottomMargin = R5(4.0f);
        r119.setMarginEnd(R5(4.0f));
    }

    public /* synthetic */ ImageGalleryItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
