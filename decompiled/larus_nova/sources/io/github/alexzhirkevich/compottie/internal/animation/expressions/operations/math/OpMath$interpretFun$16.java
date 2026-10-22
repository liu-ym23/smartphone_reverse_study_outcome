package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$16 extends FunctionReferenceImpl implements Function1<List<? extends Double>, Double> {
    public static final OpMath$interpretFun$16 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$16();
    }

    public OpMath$interpretFun$16() {
        super(1, v.class, "hypotN", "hypotN(Ljava/util/List;)D", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Double invoke2(List<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        double r105 = ((Number) ListProtector.get(r100, r104)).doubleValue();
        r101.add(Double.valueOf(r105 * r105));
        r104 = r104 + 1;
        goto L3
    L5:
        int r106 = r101.size();
        double r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r103 >= r106) goto L9;
        r107 = r107 + ((Number) ListProtector.get(r101, r103)).doubleValue();
        r103 = r103 + 1;
        goto L6
    L9:
        return Double.valueOf(Math.sqrt(r107));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Double invoke(List<? extends Double> r100) {
        return invoke2(r100);
    }
}
