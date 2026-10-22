package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartViewExtentionsKt {

    public static final class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r0 = this.a.getContext().getSystemService("input_method");     // Catch: Throwable -> L9
            if ((r0 instanceof InputMethodManager) == true) goto L5;
            r0 = null;
        L5:
            InputMethodManager r1 = (InputMethodManager) r0;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            r1.hideSoftInputFromWindow(this.a.getWindowToken(), 0);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ CartViewExtentionsKt$scaleImageToFitWidth$1 a;

        public b(CartViewExtentionsKt$scaleImageToFitWidth$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.m1775invoke();
        }
    }

    public static final Integer a(Object r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        if ((r2 instanceof Number) == false) goto L7;
        return Integer.valueOf(((Number) r2).intValue());
    L7:
        if ((r2 instanceof String) == true) goto L9;
        return null;
    L9:
        return Integer.valueOf(CastIntegerProtector.parseInt((String) r2));
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static final RecyclerView b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getRecyclerView");
        RecyclerView r1 = null;
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L15;
        Iterator r4 = com.bytedance.commerce.base.view.b.a(r3).iterator();
    L9:
        if (r4.hasNext() == false) goto L21;
        RecyclerView r0 = (View) r4.next();
        if ((r0 instanceof RecyclerView) == true) goto L20;
        r1 = b(r0);
        if (r1 == null) goto L9;
        return r1;
    L20:
        return r0;
    L21:
        return r1;
    L15:
        return null;
    }

    public static final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$hideSoftKeyBoard");
        com.bytedance.android.shopping.new_cart.utils.a.c.d("hideSoftKeyBoard", new a(r2));
    }

    public static final void d(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$scaleImageToFitWidth");
        r2.setScaleType(ImageView.ScaleType.MATRIX);
        CartViewExtentionsKt$scaleImageToFitWidth$1 r0 = new CartViewExtentionsKt$scaleImageToFitWidth$1(r2);
        if (r2.getWidth() > 0) goto L5;
    L7:
        r2.addOnLayoutChangeListener(new b(r0));
        return;
    L5:
        if (r2.getDrawable() == null) goto L7;
        r0.m1775invoke();
        goto L7
    }

    public static final void e(TextView r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setWeightAsSlc");
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r2.setTypeface(Typeface.create(r2.getTypeface(), r4, r2.getTypeface().isItalic()));
        return;
    L10:
        if (com.bytedance.android.ecom.arch.slice.render.h.a(Integer.valueOf(r4)) == false) goto L12;
        r2.setTypeface(null, 1);
        return;
    L12:
        r2.setTypeface(null, 0);
        return;
    L5:
        r4 = 400;
        goto L7
    }
}
