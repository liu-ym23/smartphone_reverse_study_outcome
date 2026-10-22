package com.bytedance.android.shopping.card_list.utils;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListExtentionsKt {
    public static final boolean a(Object r2) {
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "true") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r2, 1) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final Integer b(Object r2) {
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

    public static final RecyclerView e(View r2) {
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
        r1 = e(r0);
        if (r1 == null) goto L9;
        return r1;
    L20:
        return r0;
    L21:
        return r1;
    L15:
        return null;
    }

    public static final void h(final View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$hideSoftKeyBoard");
        CardListRunCatchExtKt.a(null, "hideSoftKeyBoard", new CardListExtentionsKt$hideSoftKeyBoard$1(r2));
    }

    public static final void i(final RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$scrollToTop");
        CardListRunCatchExtKt.a(null, "scrollToTop", new CardListExtentionsKt$scrollToTop$1(r2));
    }

    public static List g(Map r2, String r3) {
        List r0 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r2, "$this$getStringList");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r0, "default");
        Object r4 = r2.get(r3);
        if ((r4 instanceof List) == true) goto L5;
        r4 = null;
    L5:
        List r5 = (List) r4;
        if (r5 != null) goto L9;
        return r0;
    L9:
        return r5;
    }

    public static final void j(TextView r2, Integer r3) {
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

    public static final boolean c(Map<String, ? extends Object> r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(r2);
        if (r4 != null) goto L9;
        r4 = Boolean.valueOf(r3);
    L9:
        return a(r4);
    }

    public static final int d(Map<String, ? extends Object> r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(r2);
        if (r4 != null) goto L9;
        r4 = Integer.valueOf(r3);
    L9:
        return mq.b.b(r4, 0);
    }

    public static final String f(Map<String, ? extends Object> r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "default");
        if (r1 == null) goto L15;
        Object r4 = r1.get(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        if ((r4 instanceof String) == true) goto L10;
        r4 = null;
    L10:
        String r5 = (String) r4;
        if (r5 != null) goto L14;
        return r3;
    L14:
        return r5;
    L15:
        return r3;
    }
}
