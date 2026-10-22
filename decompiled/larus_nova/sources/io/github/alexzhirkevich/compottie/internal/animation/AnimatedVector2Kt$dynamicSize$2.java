package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AnimatedVector2Kt$dynamicSize$2 extends FunctionReferenceImpl implements Function1<Offset, Size> {
    public static final AnimatedVector2Kt$dynamicSize$2 INSTANCE = null;

    static {
        INSTANCE = new AnimatedVector2Kt$dynamicSize$2();
    }

    public AnimatedVector2Kt$dynamicSize$2() {
        super(1, orc.p.class, "toSize", "toSize-k-4lQ0M(J)J", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Size invoke(Offset r100) {
        return Size.m4639boximpl(m9440invokeR8KW5pk(r100.m4592unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-R8KW5pk, reason: not valid java name */
    public final long m9440invokeR8KW5pk(long r100) {
        return orc.p.c(r100);
    }
}
