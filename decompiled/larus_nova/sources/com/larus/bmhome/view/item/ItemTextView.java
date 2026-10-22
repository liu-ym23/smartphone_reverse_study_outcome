package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\nH\u0016J\u001e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nJ\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/GenericDraweeView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "init", "", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setTextColor", "color", "setTextFontWeight", "weight", "loadImage", "url", "", "setImageSrc", "resId", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "widthDp", "heightDp", "setEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GenericDraweeView f316980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f316981b;

    public final CharSequence getText() {
        return this.f316981b.getText();
    }

    public final GenericDraweeView getImageView() {
        return this.f316980a;
    }

    public final TextView getTextView() {
        return this.f316981b;
    }

    public ItemTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        GenericDraweeView r101 = new GenericDraweeView(getContext());
        r101.setId(R.id.view_id_image);
        this.f316980a = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_text);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_100, r102.getContext(), R.color.larus_neutral_100)));
        r102.setTextSize(0, i5.t());
        r102.setGravity(16);
        this.f316981b = r102;
        R5(r100, null);
    }

    public final void S5(String r100) {
        if (o0.d(null) == false) goto L5;
        ImageLoaderKt.u(this.f316980a, null, "citation_item_icon");
        this.f316980a.setVisibility(0);
    L6:
        ViewGroup.LayoutParams r101 = this.f316981b.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (this.f316980a.getVisibility() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r102.setMarginStart(i5.q());
        r102.setMarginEnd(0);
    L13:
        this.f316981b.setLayoutParams(r102);
        return;
    L12:
        r102.setMarginStart(0);
        r102.setMarginEnd(0);
        goto L13
    L9:
        r103 = false;
        goto L10
    L5:
        this.f316980a.setVisibility(8);
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        setAlpha(r101);
        super.setEnabled(r100);
        return;
    L4:
        r101 = 0.3f;
        goto L5
    }

    public void setImageSrc(int r100) {
        if (r100 <= 0) goto L5;
        this.f316980a.setImageResource(r100);
        this.f316980a.setVisibility(0);
    L6:
        ViewGroup.LayoutParams r101 = this.f316981b.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (this.f316980a.getVisibility() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r102.setMarginStart(i5.q());
        r102.setMarginEnd(0);
    L13:
        this.f316981b.setLayoutParams(r102);
        return;
    L12:
        r102.setMarginStart(0);
        r102.setMarginEnd(0);
        goto L13
    L9:
        r103 = false;
        goto L10
    L5:
        this.f316980a.setVisibility(8);
        goto L6
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f316981b.setText(r100);
    }

    public final void setTextColor(int r100) {
        this.f316981b.setTextColor(r100);
    }

    public final void setTextFontWeight(int r100) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r101 = Typeface.create(this.f316981b.getTypeface(), r100, this.f316981b.getTypeface().isItalic());
        this.f316981b.setTypeface(r101);
        return;
    }

    public ItemTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        GenericDraweeView r102 = new GenericDraweeView(getContext());
        r102.setId(R.id.view_id_image);
        this.f316980a = r102;
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_text);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_100, r103.getContext(), R.color.larus_neutral_100)));
        r103.setTextSize(0, i5.t());
        r103.setGravity(16);
        this.f316981b = r103;
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textColor, android.R.attr.text, android.R.attr.textFontWeight, R.attr.larus_image_height, R.attr.larus_image_src, R.attr.larus_image_width});
        View r103 = this.f316980a;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(r102.getDimensionPixelSize(5, -2), r102.getDimensionPixelSize(3, -2));
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.startToStart = 0;
        r104.setMargins(0, i5.h(), 0, i5.h());
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
        int r106 = r102.getResourceId(4, 0);
        if (r106 <= 0) goto L5;
        this.f316980a.setImageResource(r106);
        this.f316980a.setVisibility(0);
    L6:
        View r107 = this.f316981b;
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(0, -2);
        r108.topToTop = 0;
        r108.bottomToBottom = 0;
        r108.startToEnd = this.f316980a.getId();
        if (this.f316980a.getVisibility() != 0) goto L9;
        boolean r109 = true;
    L10:
        if (r109 == false) goto L12;
        r108.setMarginStart(i5.q());
        r108.setMarginEnd(0);
    L13:
        r108.endToEnd = 0;
        addView(r107, r108);
        TextView r110 = this.f316981b;
        String r111 = r102.getString(1);
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r110.setText(r111);
        this.f316981b.setTextColor(ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100)));
        if (Build.VERSION.SDK_INT < 28) goto L19;
        this.f316981b.setTypeface(Typeface.create(this.f316981b.getTypeface(), r102.getInteger(2, 400), this.f316981b.getTypeface().isItalic()));
    L19:
        this.f316981b.setSingleLine(false);
        this.f316981b.setMaxLines(2);
        this.f316981b.setEllipsize(TextUtils.TruncateAt.END);
        this.f316981b.setTextAlignment(5);
        int r112 = r102.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        int r113 = getPaddingTop();
        int r114 = getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r112 + ",top:" + r113 + ",end:" + r112 + ",bottom:" + r114);
        setPaddingRelative(r112, r113, r112, r114);
        setMinHeight(i5.h0());
        r102.recycle();
        return;
    L12:
        r108.setMarginStart(0);
        r108.setMarginEnd(0);
        goto L13
    L9:
        r109 = false;
        goto L10
    L5:
        this.f316980a.setVisibility(8);
        goto L6
    }

    public ItemTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        GenericDraweeView r103 = new GenericDraweeView(getContext());
        r103.setId(R.id.view_id_image);
        this.f316980a = r103;
        TextView r104 = new TextView(getContext());
        r104.setId(R.id.view_id_text);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), c.b(R.attr.larus_neutral_100, r104.getContext(), R.color.larus_neutral_100)));
        r104.setTextSize(0, i5.t());
        r104.setGravity(16);
        this.f316981b = r104;
        R5(r100, r101);
    }
}
