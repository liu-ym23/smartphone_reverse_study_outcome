package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.apm.util.u;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/ECCartErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/shopping/new_cart/widgets/ECCartErrorView$a;", "callback", "", "setCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartErrorView extends ConstraintLayout implements View.OnClickListener {
    public final Handler a;
    public a b;
    public View c;
    public CartLinkedScrollViewV2 d;
    public final View e;
    public final View f;

    public interface a {
        void a();

        void b();

        void onBack();
    }

    public ECCartErrorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCartErrorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        int r3 = r2.getId();
        if (r3 != 2131376031) goto L8;
        a r4 = this.b;
        if (r4 == null) goto L18;
        r4.onBack();
        return;
    L18:
        return;
    L8:
        if (r3 != 2131391305) goto L13;
        a r5 = this.b;
        if (r5 == null) goto L20;
        r5.a();
        return;
    L20:
        return;
    L13:
        if (r3 != 2131390122) goto L22;
        a r6 = this.b;
        if (r6 == null) goto L23;
        r6.b();
        return;
    L23:
        return;
    }

    public final void setCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECCartErrorView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        Handler r9 = new Handler(Looper.getMainLooper());
        this.a = r9;
        View r10 = LayoutInflater.from(r6).inflate(2131563708, this, true);
        this.f = r10;
        View r11 = LayoutInflater.from(r6).inflate(2131560394, this, false);
        this.e = r11;
        ImageView r0 = null;
        if (r10 == null) goto L5;
        CartLinkedScrollViewV2 r3 = (CartLinkedScrollViewV2) r10.findViewById(2131378044);
    L6:
        this.d = r3;
        if (r3 == null) goto L9;
        r3.setTopView(r11);
    L9:
        int r4 = com.bytedance.ies.xbridge.base.utils.c.a;
        int r5 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        if (r10 == null) goto L12;
        View r12 = r10.findViewById(2131384675);
    L13:
        this.c = r12;
        if (r12 == null) goto L17;
        r12.setPadding(0, r5, 0, 0);
    L17:
        if (r11 == null) goto L21;
        TextView r13 = (TextView) r11.findViewById(2131391305);
        if (r13 == null) goto L21;
        bg3.a r14 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r13, "button", r13.getText().toString(), false);
        Unit r15 = Unit.INSTANCE;
    L22:
        if (r13 == null) goto L24;
        r13.setOnClickListener(this);
    L24:
        if (r10 == null) goto L26;
        r0 = (ImageView) r10.findViewById(2131376031);
    L26:
        if (r0 == null) goto L28;
        bg3.a r16 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r0, "button", "返回", false);
    L28:
        Unit r17 = Unit.INSTANCE;
        if (r0 == null) goto L31;
        r0.setOnClickListener(this);
    L31:
        if (r10 == null) goto L35;
        TextView r18 = (TextView) r10.findViewById(2131371743);
        if (r18 == null) goto L35;
        bg3.a r19 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r18, "text", r18.getText().toString(), true);
    L35:
        setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        c r20 = new c(this);
        if (u.a() == false) goto L38;
        r20.run();
        return;
    L38:
        r9.post(r20);
        return;
    L21:
        r13 = null;
        goto L22
    L12:
        r12 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public /* synthetic */ ECCartErrorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
