package vrc;

import androidx.compose.animation.core.Easing;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.m;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import orc.p;
import wrc.h;
import wrc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f556948g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f556949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f556950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f556951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f556952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f556953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Easing f556954f;

    public static final class a {
        public static d a(Easing r110, List r111) {
            Intrinsics.checkNotNullParameter(r110, "easing");
            Intrinsics.checkNotNullParameter(r111, "args");
            int r100 = r111.size();
            if (r100 != 3) goto L5;
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101 = m.b(r111, 0, new String[]{"t"});
            Intrinsics.checkNotNull(r101);
            h r102 = i.a(Float.valueOf(0.0f));
            h r103 = i.a(Float.valueOf(1.0f));
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r112 = m.b(r111, 1, new String[]{"value1"});
            Intrinsics.checkNotNull(r112);
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104 = m.b(r111, 2, new String[]{"value2"});
            Intrinsics.checkNotNull(r104);
            return new d(r101, r102, r103, r112, r104, r110);
        L5:
            if (r100 != 5) goto L8;
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = m.b(r111, 0, new String[]{"t"});
            Intrinsics.checkNotNull(r105);
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r106 = m.b(r111, 1, new String[]{"tMin"});
            Intrinsics.checkNotNull(r106);
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r107 = m.b(r111, 2, new String[]{"tMax"});
            Intrinsics.checkNotNull(r107);
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r108 = m.b(r111, 3, new String[]{"value1"});
            Intrinsics.checkNotNull(r108);
            io.github.alexzhirkevich.compottie.internal.animation.expressions.f r109 = m.b(r111, 4, new String[]{"value2"});
            Intrinsics.checkNotNull(r109);
            return new d(r105, r106, r107, r108, r109, r110);
        L8:
            throw new IllegalStateException(("interpolation function can take 3 or 5 arguments but got " + r111.size()).toString());
        }
    }

    static {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f556949a.a(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Number");
        float r104 = ((Number) r103).floatValue();
        Object r105 = this.f556950b.a(r100, r101, r102);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Number");
        float r106 = ((Number) r105).floatValue();
        Object r107 = this.f556951c.a(r100, r101, r102);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Number");
        float r108 = ((Number) r107).floatValue();
        Object r109 = this.f556952d.a(r100, r101, r102);
        Object r110 = this.f556953e.a(r100, r101, r102);
        if (r104 > r106) goto L6;
        return r109;
    L6:
        if (r104 >= r108) goto L18;
        float r111 = this.f556954f.transform((r104 - r106) / (r108 - r106));
        if ((r109 instanceof Number) == false) goto L14;
        if ((r110 instanceof Number) == false) goto L14;
        r110 = Float.valueOf(MathHelpersKt.lerp(((Number) r109).floatValue(), ((Number) r110).floatValue(), r111));
    L14:
        if ((r109 instanceof Offset) == false) goto L20;
        if ((r110 instanceof Offset) == false) goto L20;
        long r112 = ((Offset) r109).m4592unboximpl();
        int r113 = p.f525004a;
        r110 = Offset.m4571boximpl(OffsetKt.m4605lerpWko1d7g(r112, ((Offset) r110).m4592unboximpl(), r111));
    L20:
        throw new IllegalStateException(("Cant interpolate between " + r109 + " and " + r110).toString());
    L18:
        return r110;
    }

    public d(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104, Easing r105) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "tMin");
        Intrinsics.checkNotNullParameter(r102, "tMax");
        Intrinsics.checkNotNullParameter(r103, "value1");
        Intrinsics.checkNotNullParameter(r104, "value2");
        Intrinsics.checkNotNullParameter(r105, "easing");
        this.f556949a = r100;
        this.f556950b = r101;
        this.f556951c = r102;
        this.f556952d = r103;
        this.f556953e = r104;
        this.f556954f = r105;
    }
}
