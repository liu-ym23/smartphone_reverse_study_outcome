package com.bytedance.android.shopping.deepfeed.ui;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import tc3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductSnapHelper extends PagerSnapHelper {
    public final boolean a;
    public final int b;
    public final int c;
    public int d;
    public boolean e;
    public RecyclerView f;

    public static final class a {
    }

    static {
    }

    public DeepFeedProductSnapHelper() {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        boolean r2 = false;
        Object r1 = new e(0);
        Integer r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L163
        Object r5 = d.c.get("deep_feed_slide_threshold");     // Catch: Throwable -> L56
        if (r5 != null) goto L8;
    L53:
        Object r6 = null;
    L54:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L56
    L58:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L62;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L62:
        if (Result.isFailure-impl(r7) == false) goto L65;
        r7 = null;
    L65:
        if ((r7 instanceof e) == true) goto L67;
        r7 = null;
    L67:
        Object r9 = (e) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L74;
        Object r10 = d.a.get("deep_feed_slide_threshold");     // Catch: Throwable -> L163
        if ((r10 instanceof e) == true) goto L73;
        r10 = null;
    L73:
        r9 = (e) r10;     // Catch: Throwable -> L163
    L74:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("deep_feed_slide_threshold");     // Catch: Throwable -> L129
        if (r12 != null) goto L81;
    L126:
        Object r13 = null;
    L127:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L129
    L131:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L135;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L135:
        if (Result.isFailure-impl(r14) == false) goto L138;
        r14 = null;
    L138:
        if ((r14 instanceof e) == true) goto L140;
        r14 = null;
    L140:
        r9 = (e) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L146;
        Object r17 = r16.getHostABValue("deep_feed_slide_threshold", r1);     // Catch: Throwable -> L154
    L147:
        if (r17 != null) goto L149;
    L160:
        r9 = r1;
        goto L161
    L149:
        if ((r17 instanceof e) == true) goto L151;
        r17 = null;
    L151:
        r9 = (e) r17;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
    L154:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r19 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r19 == null) goto L159;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L146:
        r17 = null;
    L161:
        d.d("deep_feed_slide_threshold", r9);     // Catch: Throwable -> L163
        goto L172
    L81:
        if ((r12 instanceof e) == true) goto L83;
        Object r20 = null;
    L84:
        r13 = (e) r20;     // Catch: Throwable -> L129
        if (r13 != null) goto L127;
        if ((r12 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r21 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L129
        if ((r21 instanceof e) == true) goto L94;
        r21 = null;
    L94:
        r13 = (e) r21;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r22 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L129
        if ((r22 instanceof e) == true) goto L100;
        r22 = null;
    L100:
        r13 = (e) r22;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r23 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L129
        if ((r23 instanceof e) == true) goto L106;
        r23 = null;
    L106:
        r13 = (e) r23;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L129
        if ((r24 instanceof e) == true) goto L112;
        r24 = null;
    L112:
        r13 = (e) r24;     // Catch: Throwable -> L129
    L114:
        if ((r12 instanceof JSONObject) == false) goto L116;
    L196:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), e.class);     // Catch: Throwable -> L122
        if ((r25 instanceof e) == true) goto L120;
        r25 = null;
    L120:
        Object r26 = Result.constructor-impl((e) r25);     // Catch: Throwable -> L122
    L124:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L129
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r12 instanceof JSONArray) == false) goto L126;
    L83:
        r20 = r12;
    L129:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        e r29 = (e) r9;
        this.a = Intrinsics.areEqual(r29.b(), Boolean.TRUE);
        Integer r30 = r29.a();
        if (r30 != null) goto L175;
    L183:
        int r31 = 50;
    L184:
        this.b = r31;
        Integer r32 = r29.c();
        if (r32 != null) goto L187;
    L193:
        int r33 = 100;
    L194:
        this.c = r33;
        this.d = -1;
        return;
    L187:
        if (r32.intValue() <= 0) goto L189;
        r2 = true;
    L189:
        if (r2 == false) goto L191;
        r3 = r32;
    L191:
        if (r3 == null) goto L193;
        r33 = r3.intValue();
        goto L194
    L175:
        if (r30.intValue() <= 0) goto L177;
        boolean r34 = true;
    L178:
        if (r34 == true) goto L181;
        r30 = null;
    L181:
        if (r30 == null) goto L183;
        r31 = r30.intValue();
        goto L184
    L177:
        r34 = false;
        goto L178
    L8:
        if ((r5 instanceof e) == true) goto L10;
        Object r35 = null;
    L11:
        r6 = (e) r35;     // Catch: Throwable -> L56
        if (r6 != null) goto L54;
        if ((r5 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r36 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L56
        if ((r36 instanceof e) == true) goto L21;
        r36 = null;
    L21:
        r6 = (e) r36;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r37 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L56
        if ((r37 instanceof e) == true) goto L27;
        r37 = null;
    L27:
        r6 = (e) r37;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r38 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L56
        if ((r38 instanceof e) == true) goto L33;
        r38 = null;
    L33:
        r6 = (e) r38;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r39 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L56
        if ((r39 instanceof e) == true) goto L39;
        r39 = null;
    L39:
        r6 = (e) r39;     // Catch: Throwable -> L56
    L41:
        if ((r5 instanceof JSONObject) == false) goto L43;
    L204:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r40 = SDKSettingsCacheManager.a().fromJson(r5.toString(), e.class);     // Catch: Throwable -> L49
        if ((r40 instanceof e) == true) goto L47;
        r40 = null;
    L47:
        Object r41 = Result.constructor-impl((e) r40);     // Catch: Throwable -> L49
    L51:
        r6 = r41;
        if (Result.isFailure-impl(r6) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L56
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r5 instanceof JSONArray) == false) goto L53;
    L10:
        r35 = r5;
    L56:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L168;
        EnsureManager.ensureNotReachHere(r46);
    L168:
        if (Result.isFailure-impl(r45) == true) goto L171;
        r1 = r45;
    L171:
        r9 = r1;
        goto L172
    }

    public final void a(RecyclerView.LayoutManager r2) {
        if (this.a == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L12;
        View r0 = super.findSnapView(r2);
        if (r0 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getPosition(r0));
    L10:
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        this.d = r4;
        this.e = false;
        return;
    L9:
        r3 = null;
    L12:
        r4 = -1;
        goto L13
    }

    public final void attachToRecyclerView(RecyclerView r1) {
        super/*androidx.recyclerview.widget.SnapHelper*/.attachToRecyclerView(r1);
        this.f = r1;
    }

    public final View findSnapView(RecyclerView.LayoutManager r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutManager");
        if (this.a == false) goto L35;
        if (r4.canScrollVertically() == false) goto L35;
        RecyclerView r0 = this.f;
        if (r0 == null) goto L35;
        if (r0.getScrollState() != 0) goto L35;
        if (this.e == true) goto L35;
        int r1 = this.d;
        if (r1 == (-1)) goto L35;
        View r2 = r4.findViewByPosition(r1);
        if (r2 != null) goto L20;
        return super.findSnapView(r4);
    L20:
        if (r4.getItemCount() <= 0) goto L22;
        OrientationHelper r3 = OrientationHelper.createVerticalHelper(r4);
        int r5 = r3.getDecoratedStart(r2) - r3.getStartAfterPadding();
        if (r5 > (-this.b)) goto L27;
        int r6 = this.d + 1;
    L30:
        View r7 = r4.findViewByPosition(RangesKt.coerceIn(r6, 0, r4.getItemCount() - 1));
        if (r7 == null) goto L33;
        return r7;
    L33:
        return super.findSnapView(r4);
    L27:
        if (r5 < this.c) goto L29;
        r6 = this.d - 1;
        goto L30
    L29:
        r6 = this.d;
        goto L30
    L22:
        return super.findSnapView(r4);
    L35:
        return super.findSnapView(r4);
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        int[] r0 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L5;
        OrientationHelper r1 = OrientationHelper.createHorizontalHelper(r5);
        r0[0] = r1.getDecoratedStart(r6) - r1.getStartAfterPadding();
    L7:
        if (r5.canScrollVertically() == false) goto L9;
        OrientationHelper r7 = OrientationHelper.createVerticalHelper(r5);
        r0[1] = r7.getDecoratedStart(r6) - r7.getStartAfterPadding();
    L10:
        RecyclerView r8 = this.f;
        if (r8 != null) goto L13;
    L15:
        return r0;
    L13:
        if (r8.getScrollState() != 0) goto L15;
        this.d = -1;
        this.e = false;
        goto L15
    L9:
        r0[1] = 0;
        goto L10
    L5:
        r0[0] = 0;
        goto L7
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        if (this.a == false) goto L8;
        if (r3 != 0) goto L6;
        if (r4 == 0) goto L8;
    L6:
        this.e = true;
    L8:
        return super.findTargetSnapPosition(r2, r3, r4);
    }
}
