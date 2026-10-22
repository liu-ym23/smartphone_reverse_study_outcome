package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.l;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class OpWiggle implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f490957j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Long> f490964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Object> f490965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Object> f490966i;

    public static final class a {
        public static Object b(Object r110, float r111, float r112, int r113, float r210, prc.f r211, Map r212, Map r213, Map r214) {
            Object r100 = r110;
            int r101 = 0;
        L3:
            if (r101 >= r113) goto L59;
            if (r101 != 0) goto L7;
            float r102 = 1.0f;
        L8:
            float r103 = r112 / r102;
            if (r101 != 0) goto L11;
            float r104 = 1.0f;
        L12:
            Long r114 = (Long) r212.get(Integer.valueOf(r101));
            float r115 = 1000.0f / (r104 * r111);
            long r116 = Duration.m10811getInWholeMillisecondsimpl(r211.d());
            if (r114 == null) goto L15;
            long r117 = r114.longValue();
        L16:
            float r105 = Math.abs(r116 - r117);
            float r118 = 0.0f;
            if (r114 != null) goto L19;
        L22:
            r212.put(Integer.valueOf(r101), Long.valueOf(Duration.m10811getInWholeMillisecondsimpl(r211.d())));
            Offset r119 = null;
            Float r120 = null;
            if ((r100 instanceof Float) == false) goto L32;
            Integer r106 = Integer.valueOf(r101);
            Object r121 = r213.get(Integer.valueOf(r101));
            if ((r121 instanceof Float) == false) goto L27;
            r120 = (Float) r121;
        L27:
            if (r120 == null) goto L29;
            float r122 = r120.floatValue();
        L30:
            r214.put(r106, Float.valueOf(r122));
            r213.put(Integer.valueOf(r101), Float.valueOf((-r103) + ((Random.Default.nextFloat() * 2) * r103)));
        L40:
            Object r107 = r214.get(Integer.valueOf(r101));
            Object r108 = r213.get(Integer.valueOf(r101));
            if ((r100 instanceof Float) == false) goto L48;
            if ((r107 instanceof Float) == false) goto L48;
            if ((r108 instanceof Float) == false) goto L48;
            r100 = Float.valueOf(((Number) r100).floatValue() + MathHelpersKt.lerp(((Number) r107).floatValue(), ((Number) r108).floatValue(), r118));
        L54:
            r101 = r101 + 1;
        L48:
            if ((r100 instanceof Offset) == false) goto L56;
            if ((r107 instanceof Offset) == false) goto L56;
            if ((r108 instanceof Offset) == false) goto L56;
            r100 = Offset.m4571boximpl(Offset.m4587plusMKHz9U(((Offset) r100).m4592unboximpl(), OffsetKt.m4605lerpWko1d7g(((Offset) r107).m4592unboximpl(), ((Offset) r108).m4592unboximpl(), r118)));
        L56:
            throw new IllegalStateException((Reflection.getOrCreateKotlinClass(r100.getClass()) + " can't be wiggled").toString());
        L29:
            r122 = 0.0f;
            goto L30
        L32:
            if ((r100 instanceof Offset) == false) goto L58;
            Integer r109 = Integer.valueOf(r101);
            Object r123 = r213.get(Integer.valueOf(r101));
            if ((r123 instanceof Offset) == false) goto L36;
            r119 = (Offset) r123;
        L36:
            if (r119 == null) goto L38;
            long r124 = r119.m4592unboximpl();
        L39:
            r214.put(r109, Offset.m4571boximpl(r124));
            Integer r125 = Integer.valueOf(r101);
            float r126 = -r103;
            Random.Default r127 = Random.Default;
            float r128 = 2;
            float r129 = ((r127.nextFloat() * r128) * r103) + r126;
            float r130 = r126 + ((r127.nextFloat() * r128) * r103);
            r213.put(r125, Offset.m4571boximpl(Offset.m4574constructorimpl((Float.floatToRawIntBits(r129) << 32) | (((long) Float.floatToRawIntBits(r130)) & BodyPartID.bodyIdMax))));
            goto L40
        L38:
            r124 = Offset.Companion.m4598getZeroF1C5BW0();
            goto L39
        L58:
            throw new IllegalStateException((Reflection.getOrCreateKotlinClass(r100.getClass()) + " can't be wiggled").toString());
        L19:
            if (r105 > r115) goto L22;
            r118 = RangesKt.coerceIn(r105 / r115, 0.0f, 1.0f);
            goto L40
        L15:
            r117 = 0;
            goto L16
        L11:
            r104 = (float) Math.pow(r210, r101);
            goto L12
        L7:
            r102 = (float) Math.pow(r210, r101);
            goto L8
        L59:
            return r100;
        }

        public static Object a(final Function1 r110, final float r111, final float r112, final Integer r113, final Float r114, Float r115, prc.f r116, final Map r117, final Map r210, final Map r211) {
            Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r116, "state");
            Intrinsics.checkNotNullParameter(r117, "lastChange");
            Intrinsics.checkNotNullParameter(r210, "wiggle");
            Intrinsics.checkNotNullParameter(r211, "prevWigle");
            if (r115 != null) goto L13;
            Object r100 = r110.invoke(r116);
            if (r113 == null) goto L7;
            int r101 = r113.intValue();
        L8:
            if (r114 == null) goto L10;
            float r102 = r114.floatValue();
        L14:
            return b(r100, r111, r112, r101, r102, r116, r117, r210, r211);
        L10:
            r102 = 0.5f;
            goto L14
        L7:
            r101 = 1;
            goto L8
        L13:
            return r116.e(r115.floatValue(), new h(r110, r111, r112, r113, r114, r117, r210, r211));
        }
    }

    static {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(final k2<? extends Object> r100, final io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490963f;
        if ((!(r103 instanceof vrc.c)) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L10;
        Object r104 = r103.a(r100, r101, r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        return r102.e(((Number) r104).floatValue(), new g(this, r100, r101));
    L10:
        return c(r100, r101, r102);
    }

    public final Object c(k2<? extends Object> r110, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r111, prc.f r112) {
        Object r100 = this.f490958a.a(r110, r111, r112);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.animation.RawProperty<kotlin.Any>");
        OpWiggle$wiggle$1 r101 = new OpWiggle$wiggle$1((k2) r100);
        Object r102 = this.f490959b.a(r110, r111, r112);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        float r103 = ((Number) r102).floatValue();
        Object r104 = this.f490960c.a(r110, r111, r112);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        float r105 = ((Number) r104).floatValue();
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r106 = this.f490961d;
        if (r106 == null) goto L5;
        Object r107 = r106.a(r110, r111, r112);
    L6:
        Number r108 = (Number) r107;
        if (r108 == null) goto L9;
        Integer r109 = Integer.valueOf(r108.intValue());
    L10:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r113 = this.f490962e;
        if (r113 == null) goto L13;
        Object r114 = r113.a(r110, r111, r112);
    L14:
        Number r115 = (Number) r114;
        if (r115 == null) goto L17;
        Float r116 = Float.valueOf(r115.floatValue());
    L18:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r117 = this.f490963f;
        if (r117 == null) goto L21;
        Object r118 = r117.a(r110, r111, r112);
    L23:
        if ((r118 instanceof Number) == false) goto L25;
        Number r119 = (Number) r118;
    L26:
        if (r119 == null) goto L28;
        Float r120 = Float.valueOf(r119.floatValue());
    L30:
        return a.a(r101, r103, r105, r109, r116, r120, r112, this.f490964g, this.f490965h, this.f490966i);
    L28:
        r120 = null;
        goto L30
    L25:
        r119 = null;
        goto L26
    L21:
        r118 = null;
        goto L23
    L17:
        r116 = null;
        goto L18
    L13:
        r114 = null;
        goto L14
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    public OpWiggle(l r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "freq");
        Intrinsics.checkNotNullParameter(r102, "amp");
        this.f490958a = r100;
        this.f490959b = r101;
        this.f490960c = r102;
        this.f490961d = r103;
        this.f490962e = r104;
        this.f490963f = r105;
        this.f490964g = new LinkedHashMap();
        this.f490965h = new LinkedHashMap();
        this.f490966i = new LinkedHashMap();
    }
}
