package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class QrColor$CrossingGradient$invoke$order$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final QrColor$CrossingGradient$invoke$order$1 INSTANCE = null;

    static {
        INSTANCE = new QrColor$CrossingGradient$invoke$order$1();
    }

    public QrColor$CrossingGradient$invoke$order$1() {
        super(2, ComparisonsKt.class, "minOf", "minOf(II)I", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100, Integer r101) {
        return invoke(r100.intValue(), r101.intValue());
    }

    public final Integer invoke(int r100, int r101) {
        return Integer.valueOf(Math.min(r100, r101));
    }
}
