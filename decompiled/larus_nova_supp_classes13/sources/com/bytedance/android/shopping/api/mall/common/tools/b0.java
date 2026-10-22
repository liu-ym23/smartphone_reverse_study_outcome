package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 {

    public static final class a implements ParameterizedType {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Type[] b;

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.a;
        }

        public a(Class r1, Type[] r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final String f() {
        HybridAppInfoService r0 = HybridAppInfoService.p;
        if (HybridAppInfoService.j() == false) goto L6;
        return "ecom_mall_dylite";
    L6:
        String r1 = r0.getAppId();
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        return "ecom_mall_".concat(r1);
    }

    public static final List<View> b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$children");
        if ((r3 instanceof ViewGroup) == false) goto L10;
        ViewGroup r4 = (ViewGroup) r3;
        IntRange r0 = RangesKt.until(0, r4.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        r1.add(r4.getChildAt(r2.nextInt()));
        goto L6
    L12:
        return CollectionsKt.toList(r1);
    L10:
        return CollectionsKt.emptyList();
    }

    public static final int c(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final void e(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$gone");
        r1.setVisibility(8);
    }

    public static final <T> String i(List<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$seriesString");
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(r4.next() + "  ");
        goto L4
    L7:
        return r0.toString();
    }

    public static final String k(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        return r1;
    }

    public static final String m(Object r0) {
        if (r0 != null) goto L6;
        return (String) r0;
    L6:
        return p.c(r0);
    }

    public static final void n(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$visible");
        r1.setVisibility(0);
    }

    public static final ParameterizedType getType(Class<?> r1, Type... r2) {
        Intrinsics.checkNotNullParameter(r1, "raw");
        Intrinsics.checkNotNullParameter(r2, "args");
        return new a(r1, r2);
    }

    public static final void j(View r1, Drawable r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setBackgroundCompat");
        r1.setBackground(r2);
    }

    public static final void l(String r1, Exception r2) {
        if (HybridAppInfoService.p.isLocalTest() == true) goto L7;
        EnsureManager.ensureNotReachHere(r2, r1);
        return;
    L7:
        throw new RuntimeException(r1, r2);
    }

    public static final <T, R> void a(Map<T, List<R>> r2, T r3, R r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$addNewValue");
        if (r2.containsKey(r3) == false) goto L7;
        List r5 = (List) ((LinkedHashMap) r2).get(r3);
        if (r5 == null) goto L9;
        r5.add(r4);
        return;
    L9:
        return;
    L7:
        r2.put(r3, CollectionsKt.mutableListOf(new Object[]{r4}));
    }

    public static final Object d(Map<String, ? extends Object> r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$getOrDefaultValue");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "default");
        if (r1.containsKey(r2) == false) goto L9;
        Object r4 = r1.get(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4;
    L9:
        return r3;
    }

    public static final int g(Map<String, ? extends Object> r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$optInt");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1.containsKey(r2) == false) goto L11;
        Object r4 = r1.get(r2);
        if ((r4 instanceof Integer) == true) goto L7;
        r4 = null;
    L7:
        Integer r5 = (Integer) r4;
        if (r5 != null) goto L10;
        return r3;
    L10:
        return r5.intValue();
    L11:
        return r3;
    }

    public static final String h(Map<String, ? extends Object> r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$optString");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "default");
        if (r1.containsKey(r2) == false) goto L12;
        Object r4 = r1.get(r2);
        if ((r4 instanceof String) == true) goto L7;
        r4 = null;
    L7:
        String r5 = (String) r4;
        if (r5 != null) goto L11;
        return r3;
    L11:
        return r5;
    L12:
        return r3;
    }
}
