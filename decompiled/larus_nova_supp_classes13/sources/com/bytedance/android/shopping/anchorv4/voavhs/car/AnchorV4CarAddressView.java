package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.extensions.k;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/car/AnchorV4CarAddressView;", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "j", "Lkotlin/Lazy;", "getCurrentRootView", "()Landroid/widget/LinearLayout;", "currentRootView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CarAddressView extends LinearLayout {
    public final LongContentLabelComponentView a;
    public final TextElementView b;
    public final TextElementView c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b d;
    public AnchorV4CarAddressDisplay e;
    public boolean f;
    public boolean g;
    public e h;
    public boolean i;
    public final Lazy j;
    public int k;
    public final int l;

    public static final class a implements Runnable {
        public final /* synthetic */ AnchorV4CarAddressView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(AnchorV4CarAddressView r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.a.b.getWidth() != 0) goto L11;
            AnchorV4CarAddressView r0 = this.a;     // Catch: Throwable -> L8
            if (r0.f == false) goto L15;
            r0.b(this.b, this.c);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    public AnchorV4CarAddressView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4CarAddressView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final LinearLayout getCurrentRootView() {
        return (LinearLayout) this.j.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = false;
    }

    public static final /* synthetic */ LinearLayout a(AnchorV4CarAddressView r0) {
        return r0.getCurrentRootView();
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.d.e(r2);
        super.draw(r2);
        this.d.d(r2);
    }

    public final void b(String r22, String r23) {
        String r1 = r22;
        this.b.post(new a(this, r1, r23));
        StringBuilder r3 = new StringBuilder();
        TextElement r5 = null;
        if (r1 == null) goto L5;
        Boolean r6 = Boolean.valueOf(StringsKt.contains$default(r1, "已选：", false, 2, null));
    L7:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == true) goto L9;
    L15:
        r3.append(r1);
        r3.append(" ");
        r3.append(r23);
        String r11 = r3.toString();
        float r4 = this.b.getPaint().measureText(r11);
        float r8 = n1.f;
        if (r4 >= r8) goto L23;
        TextElementView r2 = this.b;
        AnchorV4CarAddressDisplay r7 = this.e;
        if (r7 == null) goto L22;
        TextElement r9 = r7.getCarAddress();
        if (r9 == null) goto L22;
        r5 = TextElement.copy$default(r9, null, null, r11, null, null, null, null, null, 0, null, 1019, null);
    L22:
        r2.x(r5);
        return;
    L23:
        StringBuilder r10 = new StringBuilder();
        r10.append("已选： ");
        r10.append(r1);
        r10.append(" ");
        r10.append(r23);
    L25:
        if (this.b.getPaint().measureText(r10.toString()) <= r8) goto L31;
        StringsKt.clear(r10);
        r10.append("已选： ");
        if (r1 == null) goto L29;
        r1 = r1.substring(0, r1.length() - 1);
    L30:
        r10.append(r1);
        r10.append("...");
        r10.append(r23);
        goto L25
    L29:
        r1 = null;
        goto L30
    L31:
        TextElementView r12 = this.b;
        AnchorV4CarAddressDisplay r13 = this.e;
        if (r13 == null) goto L36;
        TextElement r14 = r13.getCarAddress();
        if (r14 == null) goto L36;
        r5 = TextElement.copy$default(r14, null, null, r10.toString(), null, null, null, null, null, 0, null, 1019, null);
    L36:
        r12.x(r5);
        return;
    L9:
        if (this.g == true) goto L15;
        if (k.c(r22) == false) goto L15;
        if (a2.a(r1, j.c(2131913790)) == true) goto L15;
        r3.append("已选： ");
        goto L15
    L5:
        r6 = null;
        goto L7
    }

    public AnchorV4CarAddressView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r7 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.d = r7;
        this.g = true;
        this.j = LazyKt.lazy(new AnchorV4CarAddressView$currentRootView$2(this));
        this.k = 8;
        int r1 = vf4.a.b(12);
        this.l = r1;
        LayoutInflater r8 = LayoutInflater.from(r4);
        if (r8 == null) goto L5;
        r8.inflate(2131560606, this, true);
    L5:
        setPadding(r1, r1, r1, r1);
        setBackgroundColor(-1);
        this.a = (LongContentLabelComponentView) findViewById(2131362761);
        this.b = (TextElementView) findViewById(2131362759);
        this.c = (TextElementView) findViewById(2131362760);
        r7.f(new Radius(8, 8, 8, 8));
    }

    public /* synthetic */ AnchorV4CarAddressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void c(b r12, AnchorV4CarAddressDisplay r13, e r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "viewModel");
        if (r13 != null) goto L6;
        return;
    L6:
        if (r14.i() == false) goto L9;
        if (r15 == true) goto L9;
        return;
    L9:
        this.h = r14;
        CommonMeta r16 = r14.a();
        if (r16 != null) goto L12;
    L20:
        this.e = r13;
        this.a.bind(r13.getCarTitle());
        TextElement r17 = r13.getCarAddress();
        ViewGroup.LayoutParams r3 = null;
        if (r17 == null) goto L23;
        String r18 = r17.getText();
    L24:
        TextElement r4 = r13.getCarDistance();
        if (r4 == null) goto L27;
        String r5 = r4.getText();
    L28:
        b(r18, r5);
        this.c.x(r13.getCarAddressDetail());
        AppCompatTextView r19 = this.c;
        TextElement r110 = r13.getCarAddressDetail();
        if (r110 == null) goto L35;
        String r111 = r110.getText();
        if (r111 == null) goto L35;
        if (k.c(r111) != true) goto L35;
        boolean r112 = true;
    L36:
        wg.a.h(r19, r112);
        CommonMeta r113 = r14.a();
        if (r113 == null) goto L39;
        Boolean r114 = Boolean.valueOf(r113.getEnablePDPOptimize());
    L41:
        if (k.i(r114) == false) goto L56;
        AppCompatTextView r115 = this.c;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r116 = null;
    L45:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        if (r117 == null) goto L48;
        r117.topMargin = vf4.a.b(8);
        r115.setLayoutParams(r117);
    L48:
        AppCompatTextView r118 = this.b;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == false) goto L52;
        r3 = r119;
    L52:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r3;
        if (r6 == null) goto L55;
        r6.topMargin = vf4.a.b(16);
        r118.setLayoutParams(r6);
    L55:
        this.d.f(new Radius(12, 12, 12, 12));
        this.k = 12;
    L56:
        this.g = false;
        if (r12 == null) goto L60;
        int r120 = q.a;
        q.a(this, r12.e, this.d, this.k, -1, CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.l), Integer.valueOf(this.l), Integer.valueOf(this.l), Integer.valueOf(this.l)}));
        return;
    L60:
        return;
    L39:
        r114 = null;
    L35:
        r112 = false;
        goto L36
    L27:
        r5 = null;
        goto L28
    L23:
        r18 = null;
        goto L24
    L12:
        if (Intrinsics.areEqual(r16.getNeedEnlarged(), Boolean.TRUE) == false) goto L20;
        if (this.i == true) goto L20;
        Float r7 = r16.getHorizontalPadding();
        if (r7 == null) goto L18;
        int r8 = vf4.a.b(r7);
    L19:
        int r121 = vf4.a.b(Float.valueOf(h73.a.f(r16))) - r8;
        int r9 = k1.m(getContext()) - r8;
        LinearLayout r10 = getCurrentRootView();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        r11.width = r121;
        Unit r20 = Unit.INSTANCE;
        r10.setLayoutParams(r11);
        this.i = true;
        getCurrentRootView().getViewTreeObserver().addOnGlobalLayoutListener(new c(r9, r121, this));
        goto L20
    L18:
        r8 = vf4.a.b(16) + (this.l * 2);
        goto L19
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d.c(r1, r2);
    }
}
