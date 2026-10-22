package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.ScaleFactor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AnimatedVector2Kt$dynamicScale$2 extends FunctionReferenceImpl implements Function1<Offset, ScaleFactor> {
    public static final AnimatedVector2Kt$dynamicScale$2 INSTANCE = null;

    static {
        INSTANCE = new AnimatedVector2Kt$dynamicScale$2();
    }

    public AnimatedVector2Kt$dynamicScale$2() {
        super(1, orc.p.class, "toScaleFactor", "toScaleFactor-k-4lQ0M(J)J", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ScaleFactor invoke(Offset r100) {
        return ScaleFactor.m6343boximpl(m9438invokeuYPg7_4(r100.m4592unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-uYPg7_4, reason: not valid java name */
    public final long m9438invokeuYPg7_4(long r100) {
        int r101 = orc.p.f525004a;
        float r102 = Float.intBitsToFloat((int) (r100 >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        long r104 = Float.floatToRawIntBits(r102);
        return ScaleFactor.m6346constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r104 << 32));
    }
}
