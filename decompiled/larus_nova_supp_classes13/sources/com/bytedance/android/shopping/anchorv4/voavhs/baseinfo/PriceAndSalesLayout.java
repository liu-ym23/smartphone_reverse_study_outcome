package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.PriceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/PriceAndSalesLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceAndSalesLayout extends ConstraintLayout {
    public Map<Integer, View> a;

    public static final class a implements Runnable {
        public final /* synthetic */ PriceAndSalesLayout a;

        public a(PriceAndSalesLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((AnchorV4PriceViewContainer) this.a._$_findCachedViewById(2131363998)).setMaxWidth((k1.m(this.a.getContext()) - com.bytedance.android.shopping.extensions.b.b(30)) - ((TextElementView) this.a._$_findCachedViewById(2131363999)).getMeasuredWidth());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public PriceAndSalesLayout(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceAndSalesLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564612, this, true);
    }

    public final void R5(PriceElement r3, PriceElement r4, PriceElement r5) {
        if (r3 == null) goto L28;
        Intrinsics.checkNotNullParameter(r3, "$this$setPriceTextToExperimentColor");
        g73.a r0 = r3.getFont();
        if (r0 == null) goto L8;
        FontStyle r1 = r0.b();
        if (r1 == null) goto L8;
        r1.setTextColor("#FE2C55");
    L8:
        g73.a r2 = r3.getFont();
        if (r2 == null) goto L13;
        FontStyle r6 = r2.a();
        if (r6 == null) goto L13;
        r6.setTextColor("#FE2C55");
    L13:
        g73.a r7 = r3.getFont();
        if (r7 == null) goto L18;
        FontStyle r8 = r7.c();
        if (r8 == null) goto L18;
        r8.setTextColor("#FE2C55");
    L18:
        TextElement r9 = r3.getPrefix();
        if (r9 == null) goto L23;
        FontStyle r10 = r9.getFontStyle();
        if (r10 == null) goto L23;
        r10.setTextColor("#FE2C55");
    L23:
        TextElement r11 = r3.getSuffix();
        if (r11 == null) goto L28;
        FontStyle r12 = r11.getFontStyle();
        if (r12 == null) goto L28;
        r12.setTextColor("#FE2C55");
    L28:
        ((TextElementView) _$_findCachedViewById(2131363999)).post(new a(this));
        ((PriceElementView) _$_findCachedViewById(2131363997)).D(r3);
        ((PriceElementView) _$_findCachedViewById(2131363997)).C(PriceAndSalesLayout$bindPrice$2.INSTANCE);
        ((PriceElementView) _$_findCachedViewById(2131363994)).D(r4);
        ((PriceElementView) _$_findCachedViewById(2131363994)).C(PriceAndSalesLayout$bindPrice$3.INSTANCE);
        if (r4 != null) goto L31;
    L33:
        if (r4 != null) goto L35;
    L42:
        ((PriceElementView) _$_findCachedViewById(2131363996)).D(r5);
        return;
    L35:
        if (r4.getBgType() != 0) goto L42;
        View r13 = _$_findCachedViewById(2131363994);
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L39;
        r14 = null;
    L39:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L42;
        r15.setMarginStart(0);
        r13.setLayoutParams(r15);
        goto L42
    L31:
        if (r4.getBgType() != 1) goto L33;
        ((PriceElementView) _$_findCachedViewById(2131363994)).setBackground(com.bytedance.commerce.base.drawable.a.a(PriceAndSalesLayout$bindPrice$4.INSTANCE));
        goto L33
    }
}
