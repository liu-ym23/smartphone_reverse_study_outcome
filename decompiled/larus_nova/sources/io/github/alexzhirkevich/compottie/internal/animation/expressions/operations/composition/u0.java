package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.facebook.keyframes.model.KFAnimation;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random.OpTemporalWiggle;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random.OpWiggle;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class u0 implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f, io.github.alexzhirkevich.compottie.internal.animation.expressions.l<k2<?>> {
    public u0() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(String r210, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r211) {
        if (r210 != null) goto L5;
    L90:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100 = null;
    L91:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101 = r100;
    L93:
        return r101;
    L5:
        switch(r210.hashCode()) {
            case -2001200486: goto L86;
            case -1940822415: goto L81;
            case -1097091351: goto L77;
            case -1039878147: goto L73;
            case -1016619565: goto L68;
            case -982754077: goto L61;
            case -902405357: goto L54;
            case -898533970: goto L50;
            case -787957717: goto L46;
            case -683486410: goto L39;
            case -192395842: goto L35;
            case 111972721: goto L32;
            case 349912586: goto L29;
            case 387230189: goto L25;
            case 434991005: goto L22;
            case 921641873: goto L19;
            case 1181469756: goto L12;
            case 1369086785: goto L8;
            default: goto L90;
        };
    L35:
        r100 = null;
        if (r210.equals("loopOutDuration") == false) goto L91;
    L38:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 0, new String[]{"type"});
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 1, new String[]{"numKeyframes"});
        final boolean r104 = Intrinsics.areEqual(r210, "loopOutDuration");
        Intrinsics.checkNotNullParameter(this, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r101 = new vrc.f(this, r102, r103, r104);
        goto L93
    L39:
        r100 = null;
        if (r210.equals("isClosed") == false) goto L91;
        if (r211 == null) goto L44;
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 0);
    L45:
        final Function4 r106 = new s0();
        Intrinsics.checkNotNullParameter(r106, "block");
        return new io.github.alexzhirkevich.compottie.internal.animation.expressions.j(this, r105, r106);
    L44:
        r105 = null;
        goto L45
    L46:
        r100 = null;
        if (r210.equals("wiggle") == false) goto L91;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r107 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 0, new String[]{"freq"});
        Intrinsics.checkNotNull(r107);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r108 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 1, new String[]{"amp"});
        Intrinsics.checkNotNull(r108);
        return new OpWiggle(this, r107, r108, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 2, new String[]{"octaves"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 3, new String[]{"amp_mult"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 4, new String[]{"t"}));
    L50:
        r100 = null;
        if (r210.equals("smooth") == false) goto L91;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r109 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 0, new String[]{"width"});
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r110 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 1, new String[]{"samples"});
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r111 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 2, new String[]{"t"});
        Intrinsics.checkNotNullParameter(this, "prop");
        r100 = new io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random.d(this, r109, r110, r111);
        goto L91
    L54:
        r100 = null;
        if (r210.equals("inTangents") == false) goto L91;
        if (r211 == null) goto L59;
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r112 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 0);
    L60:
        final Function4 r113 = new q0();
        Intrinsics.checkNotNullParameter(r113, "block");
        return new io.github.alexzhirkevich.compottie.internal.animation.expressions.j(this, r112, r113);
    L59:
        r112 = null;
        goto L60
    L61:
        r100 = null;
        if (r210.equals("points") == false) goto L91;
        if (r211 == null) goto L66;
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r114 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 0);
    L67:
        final Function4 r115 = new p0();
        Intrinsics.checkNotNullParameter(r115, "block");
        return new io.github.alexzhirkevich.compottie.internal.animation.expressions.j(this, r114, r115);
    L66:
        r114 = null;
        goto L67
    L68:
        r100 = null;
        if (r210.equals("getVelocityAtTime") == false) goto L91;
    L72:
        throw new IllegalStateException(r210.concat(" is not yet supported").toString());
    L73:
        r100 = null;
        if (r210.equals("propertyIndex") == false) goto L91;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new t0());
    L77:
        r100 = null;
        if (r210.equals("loopIn") == false) goto L91;
    L80:
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r116 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 0);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r117 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 1);
        final boolean r118 = Intrinsics.areEqual(r210, "loopInDuration");
        Intrinsics.checkNotNullParameter(this, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return new vrc.e(this, r116, r117, r118);
    L81:
        r100 = null;
        if (r210.equals("valueAtTime") == false) goto L91;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.a(r211, 1, r210);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r119 = new wrc.q(this, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.a(r211, 0));
    L101:
        return r119;
    L86:
        r100 = null;
        if (r210.equals("numKeys") == false) goto L91;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new o0());
    L8:
        if (r210.equals("createPath") == false) goto L90;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        r119 = new wrc.j(io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 0, new String[]{"points"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 1, new String[]{"inTangents"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 2, new String[]{"outTangents"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 3, new String[]{"is_closed"}));
        goto L101
    L12:
        if (r210.equals("outTangents") == false) goto L90;
        if (r211 == null) goto L16;
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r120 = (io.github.alexzhirkevich.compottie.internal.animation.expressions.f) CollectionsKt.getOrNull(r211, 0);
    L17:
        final Function4 r121 = new r0();
        Intrinsics.checkNotNullParameter(r121, "block");
        return new io.github.alexzhirkevich.compottie.internal.animation.expressions.j(this, r120, r121);
    L16:
        r120 = null;
        goto L17
    L19:
        if (r210.equals("getSpeedAtTime") == true) goto L72;
    L22:
        if (r210.equals("loopInDuration") == true) goto L80;
    L25:
        if (r210.equals("temporalWiggle") == false) goto L90;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.b(r211, r210);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r122 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 0, new String[]{"freq"});
        Intrinsics.checkNotNull(r122);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r123 = io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 1, new String[]{"amp"});
        Intrinsics.checkNotNull(r123);
        r119 = new OpTemporalWiggle(r122, r123, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 2, new String[]{"octaves"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 3, new String[]{"amp_mult"}), io.github.alexzhirkevich.compottie.internal.animation.expressions.m.b(r211, 4, new String[]{"t"}));
        goto L101
    L29:
        if (r210.equals("loopOut") == true) goto L38;
    L32:
        if (r210.equals("value") == false) goto L90;
        r119 = new wrc.q(this, null);
        goto L101
    }
}
