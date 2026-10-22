package com.obric.oui.toast;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.larus.nova.R;
import com.obric.oui.color.h0;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vma.i;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "", "getCornerRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f403685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f403686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f403687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f403688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f403689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f403690f;

    public static final class a {
    }

    static {
    }

    public ToastBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ToastBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setupBackground(int r100) {
        a(this, r100);
    }

    public final int getCornerRadius() {
        return this.f403685a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f403685a * 1.0f;
        this.f403686b.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f403689e == false) goto L5;
        r100.drawRoundRect(this.f403686b, r101, r101, this.f403688d);
    L5:
        super.onDraw(r100);
    }

    public static void a(ToastBackgroundView r100, int r101) {
        if (r100.f403690f == false) goto L10;
        r100.f403689e = false;
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setCornerRadius(r100.f403685a);
        r102.setColor(0);
        r100.setBackground(r102);
        r100.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Function1<Boolean, com.obric.oui.material.c[]> r103 = MaterialToken.OUI_Bg_Popup;
        int r104 = r100.f403687c;
        if (r104 != 0) goto L7;
        boolean r105 = i.a(r100);
    L8:
        p.d(r100, r103.invoke(Boolean.valueOf(!r105)), false, 3, 10);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OMaterialHelper.t(r100, null);
        return;
    L7:
        r105 = h0.b(r104);
        goto L8
    L10:
        if (r101 != (r100.f403685a * 2)) goto L12;
        r100.setBackground(ResourcesCompat.getDrawable(r100.getResources(), R.drawable.o_toast_background_capsule_form, r100.getContext().getTheme()));
        r100.f403689e = false;
    L13:
        wma.b.a("ToastBackgroundView", "setupBackground: drawSelf = " + r100.f403689e + ", height = " + r101);
        r100.invalidate();
        return;
    L12:
        r100.f403689e = true;
        goto L13
    }

    public ToastBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403685a = pla.d.m(this, 24.0f);
        this.f403686b = new RectF();
        boolean r103 = true;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        this.f403688d = r104;
        new Paint(1).setStyle(Paint.Style.STROKE);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OMaterialHelper.j(r100) == true) goto L5;
    L7:
        r103 = false;
    L8:
        this.f403690f = r103;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((getBackground() instanceof ColorDrawable) == false) goto L16;
        Drawable r105 = getBackground();
        if (r105 == null) goto L14;
        Integer r106 = Integer.valueOf(((ColorDrawable) r105).getColor());
    L28:
        setBackgroundColor(0);
        if (r106 != null) goto L31;
        int r107 = ResourcesCompat.getColor(getResources(), R.color.oui_toast_background, getContext().getTheme());
        if (r104.getColor() == r107) goto L39;
        r104.setColor(r107);
        this.f403687c = r107;
        wma.b.a("ToastBackgroundView", Intrinsics.stringPlus("resolveColors: bg=", Integer.valueOf(r107)));
        return;
    L39:
        return;
    L31:
        if (r104.getColor() == r106.intValue()) goto L37;
        r104.setColor(r106.intValue());
        this.f403687c = r106.intValue();
        wma.b.a("ToastBackgroundView", "resolveColors: bg=" + r106 + " from originBgColor");
        return;
    L37:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L16:
        if ((getBackground() instanceof GradientDrawable) == true) goto L18;
    L27:
        r106 = null;
        goto L28
    L18:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        Drawable r108 = getBackground();
        if (r108 == null) goto L26;
        ColorStateList r109 = ((GradientDrawable) r108).getColor();
        if (r109 == null) goto L27;
        r106 = Integer.valueOf(r109.getDefaultColor());
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        goto L7
    }

    public /* synthetic */ ToastBackgroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
