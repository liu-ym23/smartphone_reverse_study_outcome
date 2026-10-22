package com.ss.android.lark.contact.customized.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.x.d;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J2\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017H\u0007J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(J\u0016\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(J\u0006\u0010/\u001a\u00020\u001aJ\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/view/ContactOfficeTitleBar;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultTitleColor", "defaultRightTintColor", "defaultLeftTintColor", "ivLeftIcon", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "rightCustomContainer", "ivRightIcon", "leftButtonContainer", "Landroid/widget/FrameLayout;", "rightButtonContainer", "leftIconClickListener", "Landroid/view/View$OnClickListener;", "rightIconClickListener", d.f25925o, "", "title", "", "setLeftIcon", "iconResId", "setLeftIconClickListener", "listener", "setRightIcon", "setRightIconClickListener", "setTitleColor", "color", "setLeftIconColor", "setRightIconColor", "addRightIconButton", "Landroid/view/View;", "iconTint", "contentDescription", "addRightCustomButton", "button", "index", "removeRightCustomButton", "clearRightCustomButtons", "dp", "value", "resolveColor", "colorOrResId", "updateTitleMaxWidth", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactOfficeTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f418974i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f418975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f418976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f418977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f418978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f418979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f418980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f418981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f418982h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactOfficeTitleBar f418983a;

        public a(ContactOfficeTitleBar r100) {
            this.f418983a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f418983a.f418981g;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactOfficeTitleBar f418984a;

        public b(ContactOfficeTitleBar r100) {
            this.f418984a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f418984a.f418982h;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactOfficeTitleBar f418985a;

        public c(ContactOfficeTitleBar r100) {
            this.f418985a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            ContactOfficeTitleBar r109 = this.f418985a;
            int r110 = ContactOfficeTitleBar.f418974i;
            int r111 = (r109.getWidth() - r109.getPaddingLeft()) - r109.getPaddingRight();
            if (r111 > 0) goto L6;
            return;
        L6:
            if (r109.f418979e.getVisibility() != 8) goto L8;
            int r112 = 0;
        L10:
            if (r109.f418977c.getVisibility() != 8) goto L12;
            int r113 = 0;
        L14:
            if (r109.f418980f.getVisibility() != 8) goto L16;
            int r114 = 0;
        L17:
            int r115 = RangesKt.coerceAtLeast(r111 - (Math.max(r112, r113 + r114) * 2), 0);
            if (r109.f418976b.getMaxWidth() == r115) goto L21;
            r109.f418976b.setMaxWidth(r115);
            return;
        L21:
            return;
        L16:
            r114 = r109.f418980f.getMeasuredWidth();
            goto L17
        L12:
            r113 = r109.f418977c.getMeasuredWidth();
            goto L14
        L8:
            r112 = r109.f418979e.getMeasuredWidth();
            goto L10
        }
    }

    public ContactOfficeTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ContactOfficeTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final int b(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(ContextCompat.getColor(getContext(), r100)));     // Catch: Throwable -> L4
    L6:
        Integer r103 = Integer.valueOf(r100);
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = r103;
    L10:
        return ((Number) r102).intValue();
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void setLeftIcon(int r100) {
        this.f418975a.setImageResource(r100);
    }

    public final void setLeftIconClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f418981g = r100;
    }

    public final void setLeftIconColor(int r100) {
        this.f418975a.setColorFilter(b(r100));
    }

    public final void setRightIcon(int r100) {
        this.f418978d.setImageResource(r100);
    }

    public final void setRightIconClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f418982h = r100;
    }

    public final void setRightIconColor(int r100) {
        this.f418978d.setColorFilter(b(r100));
    }

    public final void setTitle(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f418976b.setText(r100);
    }

    public final void setTitleColor(int r100) {
        this.f418976b.setTextColor(r100);
    }

    public ContactOfficeTitleBar(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r100 = UIUtils.getColor(r110, R.color.flow_ud_neutral_100);
        int r101 = UIUtils.getColor(r110, R.color.flow_ud_neutral_100);
        int r102 = UIUtils.getColor(r110, R.color.flow_ud_neutral_100);
        View r103 = LayoutInflater.from(r110).inflate(R.layout.contact_db_common_title_bar_layout, this, true);
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.fl_left_button);
        this.f418979e = r104;
        ImageView r105 = (ImageView) r103.findViewById(R.id.iv_left_icon);
        this.f418975a = r105;
        TextView r106 = (TextView) r103.findViewById(R.id.tv_title);
        this.f418976b = r106;
        this.f418977c = (LinearLayout) r103.findViewById(R.id.ll_right_custom_container);
        FrameLayout r107 = (FrameLayout) r103.findViewById(R.id.fl_right_button);
        this.f418980f = r107;
        ImageView r108 = (ImageView) r103.findViewById(R.id.iv_right_icon);
        this.f418978d = r108;
        r104.setOnClickListener(new a(this));
        r107.setOnClickListener(new b(this));
        addOnLayoutChangeListener(new c(this));
        if (r111 == null) goto L15;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.leftIcon, R.attr.leftIconTint, R.attr.rightIcon, R.attr.rightIconTint, R.attr.title, R.attr.titleColor}, r112, 0);
        String r114 = r113.getString(4);
        if (TextUtils.isEmpty(r114) == true) goto L7;
        r106.setText(r114);
    L7:
        r106.setTextColor(r113.getColor(5, r100));
        int r115 = r113.getResourceId(0, R.drawable.contact_db_icon_back);
        if (r115 == (-1)) goto L10;
        r105.setImageResource(r115);
    L10:
        r105.setColorFilter(r113.getColor(1, r102));
        int r116 = r113.getResourceId(2, -1);
        if (r116 == (-1)) goto L13;
        r108.setImageResource(r116);
    L13:
        r108.setColorFilter(r113.getColor(3, r101));
        r113.recycle();
        return;
    }

    public /* synthetic */ ContactOfficeTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
