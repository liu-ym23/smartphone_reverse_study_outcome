package com.ss.ugc.effectplatform;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class g {
    public static List a(final j r100, List r101) {
        if (r101 == null) goto L4;
        final String r102 = "760.0.0.269-alpha.24";
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r101), new EffectPlatformEncryptorKt$decryptList$1(r100, r102)), EffectPlatformEncryptorKt$decryptList$2.INSTANCE));
    L4:
        return null;
    }
}
