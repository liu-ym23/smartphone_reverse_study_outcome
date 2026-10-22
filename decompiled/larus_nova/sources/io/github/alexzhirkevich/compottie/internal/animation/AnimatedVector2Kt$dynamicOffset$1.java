package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AnimatedVector2Kt$dynamicOffset$1 extends FunctionReferenceImpl implements Function1<Offset, Offset> {
    public static final AnimatedVector2Kt$dynamicOffset$1 INSTANCE = null;

    static {
        INSTANCE = new AnimatedVector2Kt$dynamicOffset$1();
    }

    public AnimatedVector2Kt$dynamicOffset$1() {
        super(1, orc.p.class, "toVec2", "toVec2-k-4lQ0M(J)J", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Offset invoke(Offset r100) {
        return Offset.m4571boximpl(m9435invokeMKHz9U(r100.m4592unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
    public final long m9435invokeMKHz9U(long r100) {
        int r101 = orc.p.f525004a;
        return r100;
    }
}
