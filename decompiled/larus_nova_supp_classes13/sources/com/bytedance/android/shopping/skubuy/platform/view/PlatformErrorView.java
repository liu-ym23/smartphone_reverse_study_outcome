package com.bytedance.android.shopping.skubuy.platform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.i;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformErrorView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Lx43/a;", "viewModel", "", "setState", "Lkotlin/Function0;", "callback", "setOnRetryClickedCallback", "setOnCloseClickCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformErrorView extends RoundConstraintLayout {
    public Function0<Unit> a;
    public Function0<Unit> b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;

    public PlatformErrorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlatformErrorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5(final com.bytedance.android.ecom.arch.slice.render.context.b r6) {
        Intrinsics.checkNotNullParameter(r6, "displayMetrics");
        SimpleDraweeView r0 = this.c;
        ConstraintLayout.LayoutParams r1 = null;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L7;
        r2.height = SlcDimensExtensionsKt.a(80, r6);
        r2.width = SlcDimensExtensionsKt.a(80, r6);
        Unit r3 = Unit.INSTANCE;
    L8:
        r0.setLayoutParams(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        TextView r4 = this.d;
        if (r4 == null) goto L19;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == true) goto L14;
        r5 = null;
    L14:
        ViewGroup.MarginLayoutParams r7 = (ConstraintLayout.LayoutParams) r5;
        if (r7 == null) goto L17;
        r7.topMargin = SlcDimensExtensionsKt.a(8, r6);
        Unit r8 = Unit.INSTANCE;
    L18:
        r4.setLayoutParams(r7);
        goto L19
    L17:
        r7 = null;
    L19:
        TextView r9 = this.d;
        if (r9 == null) goto L22;
        i.e(r9, 500);
    L22:
        TextView r10 = this.e;
        if (r10 == null) goto L25;
        i.e(r10, 400);
    L25:
        TextView r11 = this.f;
        if (r11 == null) goto L34;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == true) goto L30;
        r12 = null;
    L30:
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        if (r13 == null) goto L33;
        ((ViewGroup.MarginLayoutParams) r13).topMargin = SlcDimensExtensionsKt.a(40, r6);
        ((ViewGroup.MarginLayoutParams) r13).width = SlcDimensExtensionsKt.a(165, r6);
        ((ViewGroup.MarginLayoutParams) r13).height = SlcDimensExtensionsKt.a(44, r6);
        Unit r14 = Unit.INSTANCE;
        r1 = r13;
    L33:
        r11.setLayoutParams(r1);
    L34:
        TextView r15 = this.f;
        if (r15 == null) goto L38;
        i.e(r15, 500);
        ViewCompat.setBackground(r15, com.bytedance.commerce.base.drawable.a.a(new PlatformErrorView$adapterUIScale$$inlined$let$lambda$1(this, r6)));
        return;
    }

    public final void setOnCloseClickCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void setOnRetryClickedCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setState(x43.a r8) {
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        SimpleDraweeView r1 = this.c;
        if (r1 == null) goto L5;
        h0.e(r1, r8.c, new r("ec_buy_now", "buy_now_error_icon"), -1, -1, 96);
    L5:
        String r0 = r8.d;
        int r2 = 0;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L19;
        TextView r4 = this.d;
        if (r4 == null) goto L16;
        r4.setText(r8.d);
    L16:
        TextView r5 = this.d;
        if (r5 == null) goto L19;
        wg.a.h(r5, true);
    L19:
        String r6 = r8.e;
        if (r6 != null) goto L22;
    L25:
        boolean r7 = true;
    L26:
        if (r7 == true) goto L33;
        TextView r9 = this.e;
        if (r9 == null) goto L30;
        r9.setText(r8.e);
    L30:
        TextView r10 = this.e;
        if (r10 == null) goto L33;
        wg.a.h(r10, true);
    L33:
        TextView r11 = this.f;
        if (r11 == null) goto L36;
        r11.setText(r8.f);
    L36:
        TextView r12 = this.f;
        if (r12 == null) goto L39;
        r12.setOnClickListener(new a(this));
    L39:
        ImageView r13 = this.g;
        if (r13 == null) goto L42;
        wg.a.h(r13, r8.b);
    L42:
        ImageView r14 = this.g;
        if (r14 == null) goto L46;
        r14.setOnClickListener(new b(this));
    L46:
        if (r8.a == true) goto L49;
        r2 = 8;
    L49:
        setVisibility(r2);
        return;
    L22:
        if (r6.length() == 0) goto L25;
        r7 = false;
        goto L26
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlatformErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564883, this, true);
        this.c = findViewById(2131371757);
        this.d = (TextView) findViewById(2131371776);
        this.e = (TextView) findViewById(2131371770);
        this.f = (TextView) findViewById(2131371750);
        this.g = (ImageView) findViewById(2131371752);
        setVisibility(8);
    }

    public /* synthetic */ PlatformErrorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
