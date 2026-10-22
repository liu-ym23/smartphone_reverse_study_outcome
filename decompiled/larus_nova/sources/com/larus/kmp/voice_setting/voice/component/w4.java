package com.larus.kmp.voice_setting.voice.component;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w4 {
    public static final LifecycleCoroutineScope a(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return LifecycleOwnerKt.getLifecycleScope(r100);
    }
}
