package com.larus.livetutor.impl.view;

import com.larus.settings.tutor.VoiceConfig;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class n0<T> implements Comparator {
    public n0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((VoiceConfig) r100).getValue(), ((VoiceConfig) r101).getValue());
    }
}
