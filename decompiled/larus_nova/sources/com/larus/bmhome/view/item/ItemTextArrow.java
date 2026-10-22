package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import it8.a;
import it8.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020#J\b\u0010(\u001a\u00020%H\u0002J\u001f\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020%2\u0006\u0010*\u001a\u00020+J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\u0006\u00103\u001a\u00020%J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J'\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\n2\u0006\u0010*\u001a\u0002092\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020#H\u0002J\u000e\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\nJ\u0006\u0010?\u001a\u00020%J\u000e\u0010@\u001a\u00020%2\u0006\u0010*\u001a\u000209J\u0006\u0010A\u001a\u00020%R&\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextArrow;", "Lcom/larus/bmhome/view/item/ItemTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "style", "getStyle", "()I", "setStyle", "(I)V", "subTextView", "Landroid/widget/TextView;", "getSubTextView", "()Landroid/widget/TextView;", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "redDot", "waringImg", "loadingView", "Landroid/widget/ProgressBar;", "iconView", "getIconView", "setIconView", "(Landroid/widget/ImageView;)V", "isLongSubText", "", "init", "", "setVisible", "visible", "updateSubTextviewMaxWidth", "setSubText", "text", "", "textColor", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "setSubTextColor", "(Ljava/lang/Integer;)V", "socialSetSubText", "setGrayStyle", "setOriginStyle", DyPayConstant.KEY_SHOW_LOADING, "isLoading", "resetTextColor", "hideLoading", "showIconWithText", "icon", "", "(ILjava/lang/String;Ljava/lang/Integer;)V", "updateLongSubTextLayout", "compact", "showWaringDot", "sourceId", "disMissWardingImg", "showRedDot", "disMissRedDot", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextArrow extends ItemTextView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f316958k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f316959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f316960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f316961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f316962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f316963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProgressBar f316964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f316965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f316966j;

    public static /* synthetic */ void T5(ItemTextArrow r100) {
        setVisible$lambda$14(r100);
    }

    public final void U5() {
        this.f316962f.setVisibility(8);
        ViewGroup.LayoutParams r100 = this.f316960d.getLayoutParams();
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) r100;
    L6:
        if (r101 == null) goto L8;
        r101.setMarginEnd(0);
    L8:
        this.f316960d.setLayoutParams(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void V5() {
        ImageView r100 = this.f316965i;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f316963g.setVisibility(8);
        k6(false);
        this.f316960d.setVisibility(0);
        this.f316964h.setVisibility(8);
    }

    public final void Y5() {
        this.f316960d.setTextColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50)));
    }

    public final void c6() {
        ImageView r100 = this.f316965i;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f316962f.setVisibility(8);
        this.f316963g.setVisibility(8);
        k6(false);
        this.f316960d.setVisibility(8);
        this.f316964h.setVisibility(0);
    }

    public final void n6() {
        int r100 = ((((getWidth() - getImageView().getWidth()) - this.f316961e.getWidth()) - i5.h()) - (i5.q() * 2)) / 2;
        this.f316960d.setMaxWidth(r100);
    }

    public final ImageView getArrowView() {
        return this.f316961e;
    }

    public final ImageView getIconView() {
        return this.f316965i;
    }

    public final int getStyle() {
        return this.f316959c;
    }

    public final TextView getSubTextView() {
        return this.f316960d;
    }

    public ItemTextArrow(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f316959c = 1;
        TextView r101 = new TextView(getContext());
        r101.setId(R.id.view_id_sub_text);
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), c.b(R.attr.larus_neutral_50, r101.getContext(), R.color.larus_neutral_50)));
        r101.setTextSize(0, i5.t());
        r101.setGravity(16);
        this.f316960d = r101;
        ImageView r102 = new ImageView(getContext());
        r102.setId(R.id.view_id_arrow);
        r102.setImageResource(c.b(R.attr.larus_ic_arrow, r102.getContext(), R.drawable.larus_ic_arrow));
        r102.setVisibility(0);
        this.f316961e = r102;
        ImageView r103 = new ImageView(getContext());
        r103.setId(R.id.view_id_red_dot);
        r103.setImageResource(R.drawable.larus_ic_voice_mix_red_dot);
        r103.setVisibility(8);
        this.f316962f = r103;
        ImageView r104 = new ImageView(getContext());
        r104.setId(R.id.view_id_waring_dot);
        r104.setVisibility(8);
        this.f316963g = r104;
        ProgressBar r105 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r105.setId(R.id.view_id_loading);
        r105.setVisibility(8);
        this.f316964h = r105;
        R5(r100, null);
    }

    private static final void setVisible$lambda$14(ItemTextArrow r100) {
        r100.n6();
    }

    public final void i6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        k6(false);
        this.f316962f.setVisibility(0);
        ViewGroup.LayoutParams r101 = this.f316960d.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L6:
        if (r102 == null) goto L8;
        r102.endToStart = this.f316962f.getId();
        r102.setMarginEnd(i5.r0());
    L8:
        this.f316960d.setLayoutParams(r102);
        this.f316960d.setText(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void k6(boolean r100) {
        if (this.f316966j == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.f316960d.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L9:
        if (r102 != null) goto L11;
    L37:
        this.f316960d.setLayoutParams(r102);
        return;
    L11:
        if (r100 == false) goto L13;
        int r103 = -2;
    L14:
        ((ViewGroup.MarginLayoutParams) r102).width = r103;
        int r104 = -1;
        if (r100 == false) goto L17;
        int r105 = -1;
    L18:
        r102.startToEnd = r105;
        r102.startToStart = -1;
        if (r100 == false) goto L21;
        int r106 = 0;
    L22:
        r102.setMarginStart(r106);
        boolean r107 = true;
        if (this.f316961e.getVisibility() != 0) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == false) goto L28;
        int r109 = this.f316961e.getId();
    L29:
        r102.endToStart = r109;
        if (this.f316961e.getVisibility() == 0) goto L33;
        r107 = false;
    L33:
        if (r107 == true) goto L36;
        r104 = 0;
    L36:
        r102.endToEnd = r104;
        r102.setMarginEnd(0);
        goto L37
    L28:
        r109 = -1;
        goto L29
    L25:
        r108 = false;
        goto L26
    L21:
        r106 = i5.h();
        goto L22
    L17:
        r105 = getTextView().getId();
        goto L18
    L13:
        r103 = 0;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public final void setIconView(ImageView r100) {
        this.f316965i = r100;
    }

    public final void setStyle(int r100) {
        this.f316959c = r100;
        if (r100 != 0) goto L5;
        getImageView().setAlpha(0.5f);
        getTextView().setAlpha(0.3f);
        this.f316960d.setAlpha(0.6f);
        this.f316961e.setAlpha(0.6f);
        this.f316964h.setVisibility(8);
        return;
    L5:
        if (r100 != 1) goto L11;
        getImageView().setAlpha(1.0f);
        getTextView().setAlpha(1.0f);
        this.f316960d.setAlpha(1.0f);
        this.f316961e.setAlpha(1.0f);
        return;
    }

    public final void setSubTextColor(Integer r100) {
        TextView r101 = this.f316960d;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        r101.setTextColor(r102);
        return;
    L5:
        r102 = ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50));
        goto L6
    }

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        if (r100 == true) goto L8;
        return;
    L8:
        if (this.f316960d.getMaxWidth() > 0) goto L12;
        post(new b(this));
        return;
    L12:
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public ItemTextArrow(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f316959c = 1;
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_sub_text);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50)));
        r102.setTextSize(0, i5.t());
        r102.setGravity(16);
        this.f316960d = r102;
        ImageView r103 = new ImageView(getContext());
        r103.setId(R.id.view_id_arrow);
        r103.setImageResource(c.b(R.attr.larus_ic_arrow, r103.getContext(), R.drawable.larus_ic_arrow));
        r103.setVisibility(0);
        this.f316961e = r103;
        ImageView r104 = new ImageView(getContext());
        r104.setId(R.id.view_id_red_dot);
        r104.setImageResource(R.drawable.larus_ic_voice_mix_red_dot);
        r104.setVisibility(8);
        this.f316962f = r104;
        ImageView r105 = new ImageView(getContext());
        r105.setId(R.id.view_id_waring_dot);
        r105.setVisibility(8);
        this.f316963g = r105;
        ProgressBar r106 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r106.setId(R.id.view_id_loading);
        r106.setVisibility(8);
        this.f316964h = r106;
        R5(r100, r101);
    }

    private final void R5(Context r110, AttributeSet r111) {
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.larus_long_sub_text, R.attr.larus_sub_text, R.attr.larus_sub_text_force_ltr});
        boolean r100 = r112.getBoolean(0, false);
        this.f316966j = r100;
        boolean r101 = r112.getBoolean(2, false);
        View r102 = this.f316961e;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-2, -2);
        r103.topToTop = 0;
        r103.bottomToBottom = 0;
        r103.endToEnd = 0;
        Unit r104 = Unit.INSTANCE;
        addView(r102, r103);
        View r105 = this.f316962f;
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(i5.r0(), i5.r0());
        r106.topToTop = 0;
        r106.bottomToBottom = 0;
        r106.endToStart = this.f316961e.getId();
        addView(r105, r106);
        View r107 = this.f316960d;
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(-2, -2);
        r108.topToTop = 0;
        r108.bottomToBottom = 0;
        boolean r109 = true;
        if (this.f316961e.getVisibility() != 0) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == false) goto L8;
        int r114 = this.f316961e.getId();
    L9:
        r108.endToStart = r114;
        if (r100 == false) goto L12;
        ((ViewGroup.MarginLayoutParams) r108).width = 0;
        r108.startToEnd = getTextView().getId();
        r108.setMarginStart(i5.h());
        this.f316960d.setGravity(8388629);
        this.f316960d.setTextAlignment(6);
        this.f316960d.setMaxLines(1);
        this.f316960d.setEllipsize(TextUtils.TruncateAt.END);
    L12:
        if (r101 == false) goto L14;
        this.f316960d.setTextDirection(3);
    L14:
        addView(r107, r108);
        View r115 = this.f316963g;
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(-2, -2);
        r116.topToTop = 0;
        r116.bottomToBottom = 0;
        r116.endToStart = this.f316960d.getId();
        addView(r115, r116);
        View r117 = this.f316964h;
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r118.topToTop = 0;
        r118.bottomToBottom = 0;
        if (this.f316961e.getVisibility() != 0) goto L17;
        boolean r119 = true;
    L18:
        if (r119 == false) goto L20;
        r118.endToStart = this.f316961e.getId();
    L21:
        addView(r117, r118);
        TextView r120 = this.f316960d;
        r120.setEllipsize(TextUtils.TruncateAt.END);
        r120.setSingleLine(true);
        String r121 = r112.getString(1);
        if (r121 != null) goto L24;
        r121 = "";
    L24:
        r120.setText(r121);
        r120.setGravity(GravityCompat.END);
        if (r100 == true) goto L27;
        post(new a(this));
    L27:
        TextView r122 = getTextView();
        if (r100 == false) goto L30;
        int r123 = -2;
    L31:
        ConstraintLayout.LayoutParams r124 = new ConstraintLayout.LayoutParams(r123, -2);
        r124.topToTop = 0;
        r124.bottomToBottom = 0;
        r124.startToEnd = getImageView().getId();
        if (getImageView().getVisibility() != 0) goto L34;
        boolean r125 = true;
    L35:
        if (r125 == false) goto L37;
        r124.setMarginStart(i5.q());
        r124.setMarginEnd(0);
    L38:
        if (r100 == false) goto L40;
    L52:
        r122.setLayoutParams(r124);
        r112.recycle();
        return;
    L40:
        if (this.f316960d.getVisibility() != 0) goto L42;
        boolean r126 = true;
    L43:
        if (r126 == false) goto L46;
        r124.endToStart = this.f316960d.getId();
        r124.setMarginEnd(i5.h());
        goto L52
    L46:
        if (this.f316961e.getVisibility() == 0) goto L49;
        r109 = false;
    L49:
        if (r109 == false) goto L51;
        r124.endToStart = this.f316961e.getId();
        goto L52
    L51:
        r124.endToEnd = 0;
        goto L52
    L42:
        r126 = false;
        goto L43
    L37:
        r124.setMarginStart(0);
        r124.setMarginEnd(0);
        goto L38
    L34:
        r125 = false;
        goto L35
    L30:
        r123 = 0;
        goto L31
    L20:
        r118.endToEnd = 0;
        goto L21
    L17:
        r119 = false;
        goto L18
    L8:
        r114 = 0;
        goto L9
    L5:
        r113 = false;
        goto L6
    }

    public final void Z5(CharSequence r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        ImageView r102 = this.f316965i;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        this.f316962f.setVisibility(8);
        this.f316963g.setVisibility(8);
        k6(false);
        this.f316960d.setText(r100);
        TextView r103 = this.f316960d;
        if (r101 == null) goto L8;
        int r104 = r101.intValue();
    L9:
        r103.setTextColor(r104);
        ViewGroup.LayoutParams r105 = this.f316960d.getLayoutParams();
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L12;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
    L13:
        if (r106 == null) goto L15;
        r106.setMarginEnd(0);
    L15:
        this.f316960d.setLayoutParams(r106);
        return;
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50));
        goto L9
    }

    public final void b6(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (this.f316966j == false) goto L6;
        k6(true);
    L6:
        if (this.f316965i != null) goto L8;
        ImageView r102 = new ImageView(getContext());
        r102.setId(R.id.view_id_icon);
        this.f316965i = r102;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r103.topToTop = 0;
        r103.bottomToBottom = 0;
        r103.endToStart = this.f316960d.getId();
        r103.setMarginEnd(i5.z());
        Unit r104 = Unit.INSTANCE;
        addView(r102, r103);
    L8:
        ImageView r105 = this.f316965i;
        if (r105 == null) goto L11;
        r105.setImageResource(R.drawable.larus_ic_message_failed_retry);
    L11:
        this.f316964h.setVisibility(8);
        this.f316962f.setVisibility(8);
        this.f316963g.setVisibility(8);
        ImageView r106 = this.f316965i;
        if (r106 == null) goto L14;
        r106.setVisibility(0);
    L14:
        this.f316960d.setVisibility(0);
        if (r101 == null) goto L17;
        this.f316960d.setTextColor(r101.intValue());
    L17:
        this.f316960d.setText(r100);
    }

    public ItemTextArrow(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f316959c = 1;
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_sub_text);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_50, r103.getContext(), R.color.larus_neutral_50)));
        r103.setTextSize(0, i5.t());
        r103.setGravity(16);
        this.f316960d = r103;
        ImageView r104 = new ImageView(getContext());
        r104.setId(R.id.view_id_arrow);
        r104.setImageResource(c.b(R.attr.larus_ic_arrow, r104.getContext(), R.drawable.larus_ic_arrow));
        r104.setVisibility(0);
        this.f316961e = r104;
        ImageView r105 = new ImageView(getContext());
        r105.setId(R.id.view_id_red_dot);
        r105.setImageResource(R.drawable.larus_ic_voice_mix_red_dot);
        r105.setVisibility(8);
        this.f316962f = r105;
        ImageView r106 = new ImageView(getContext());
        r106.setId(R.id.view_id_waring_dot);
        r106.setVisibility(8);
        this.f316963g = r106;
        ProgressBar r107 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r107.setId(R.id.view_id_loading);
        r107.setVisibility(8);
        this.f316964h = r107;
        R5(r100, r101);
    }
}
