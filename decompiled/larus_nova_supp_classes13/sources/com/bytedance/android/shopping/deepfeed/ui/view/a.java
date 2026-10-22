package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static a e;
    public float a;
    public final int b;
    public final boolean c;
    public final Context d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.ui.view.a$a, reason: collision with other inner class name */
    public static final class C0061a {
        public static int a(Context r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            DeepFeedFoldHelper.d();
            int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
            return com.bytedance.android.ec.hybrid.list.util.c.c(Integer.valueOf(r2), r1, true);
        }
    }

    static {
    }

    public final void a() {
        DeepFeedFoldHelper.d();
        int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.a = com.bytedance.android.ec.hybrid.list.util.c.f(this.d);
    }

    public a(Context r6) {
        this.d = r6;
        int r7 = com.bytedance.android.ec.hybrid.tools.f.a;
        Object r0 = 0;
        int r1 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L81
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_ui_adapter");     // Catch: Throwable -> L54
        if (r4 != null) goto L9;
    L51:
        Object r5 = null;
    L52:
        Object r8 = Result.constructor-impl(r5);     // Catch: Throwable -> L54
    L56:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L81
        if (r9 == null) goto L60;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L81
    L60:
        if (Result.isFailure-impl(r8) == false) goto L63;
        r8 = null;
    L63:
        if ((r8 instanceof Integer) == true) goto L65;
        r8 = null;
    L65:
        Integer r10 = (Integer) r8;     // Catch: Throwable -> L81
        if (r10 == null) goto L68;
        r0 = r10;
    L89:
        this.b = ((Number) r0).intValue();
        this.c = true;
        int r11 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.a = com.bytedance.android.ec.hybrid.list.util.c.f(this.d);
        return;
    L68:
        IHybridHostService r12 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L81
        if (r12 == null) goto L71;
        Object r13 = r12.getHostABValue("mall_deep_feed_ui_adapter", r0);     // Catch: Throwable -> L81
    L72:
        if (r13 == null) goto L89;
        if ((r13 instanceof Integer) == false) goto L77;
        r3 = r13;
    L77:
        Integer r14 = (Integer) r3;     // Catch: Throwable -> L81
        if (r14 == null) goto L89;
        r0 = r14;
        goto L89
    L71:
        r13 = null;
        goto L72
    L9:
        if ((r4 instanceof Integer) == true) goto L11;
        Object r15 = null;
    L12:
        r5 = (Integer) r15;     // Catch: Throwable -> L54
        if (r5 != null) goto L52;
        if ((r4 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r16 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L54
        if ((r16 instanceof Integer) == true) goto L22;
        r16 = null;
    L22:
        r5 = (Integer) r16;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r17 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L54
        if ((r17 instanceof Integer) == true) goto L28;
        r17 = null;
    L28:
        r5 = (Integer) r17;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r5 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r18 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L54
        if ((r18 instanceof Integer) == true) goto L37;
        r18 = null;
    L37:
        r5 = (Integer) r18;     // Catch: Throwable -> L54
    L39:
        if ((r4 instanceof JSONObject) == false) goto L41;
    L91:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r19 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r19 instanceof Integer) == true) goto L45;
        r19 = null;
    L45:
        Object r20 = Result.constructor-impl((Integer) r19);     // Catch: Throwable -> L47
    L49:
        r5 = r20;
        if (Result.isFailure-impl(r5) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L54
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r4 instanceof JSONArray) == false) goto L51;
    L11:
        r15 = r4;
    L54:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L81
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L86;
        EnsureManager.ensureNotReachHere(r25);
    L86:
        if (Result.isFailure-impl(r24) == true) goto L89;
        r0 = r24;
        goto L89
    }

    public final Pair<Integer, Integer> b(int r7, int r8) {
        if (this.b == 1) goto L6;
        return null;
    L6:
        int r0 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getSize(r8);
        int r2 = View.MeasureSpec.getMode(r7);
        int r3 = View.MeasureSpec.getMode(r8);
        int r4 = Math.round(r0 * this.a);
        int r5 = Math.round(r1 * this.a);
        DeepFeedFoldHelper.d();
        int r6 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.e(this.d);
        DeepFeedFoldHelper.d();
        int r10 = com.bytedance.android.ec.hybrid.list.util.c.e(this.d);
        int r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r4, r9), r2);
        int r12 = View.MeasureSpec.makeMeasureSpec(Math.min(r5, r10), r3);
        if (r11 <= 0) goto L12;
        if (r12 <= 0) goto L12;
        return TuplesKt.to(Integer.valueOf(r11), Integer.valueOf(r12));
    L12:
        return TuplesKt.to(Integer.valueOf(r7), Integer.valueOf(r8));
    }
}
