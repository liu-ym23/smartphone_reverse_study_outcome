package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.ScaleFactor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AnimatedVector2Kt$dynamicScale$1 extends FunctionReferenceImpl implements Function1<ScaleFactor, Offset> {
    public static final AnimatedVector2Kt$dynamicScale$1 INSTANCE = null;

    static {
        INSTANCE = new AnimatedVector2Kt$dynamicScale$1();
    }

    public AnimatedVector2Kt$dynamicScale$1() {
        super(1, orc.p.class, "toVec2", "toVec2-FK8aYYs(J)J", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Offset invoke(ScaleFactor r100) {
        return Offset.m4571boximpl(m9437invokeBn_dLeM(r100.m6357unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-Bn_dLeM, reason: not valid java name */
    public final long m9437invokeBn_dLeM(long r100) {
        int r101 = orc.p.f525004a;
        return h1.a(Float.intBitsToFloat((int) (r100 >> 32)) * 100.0f, Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) * 100.0f);
    }
}
