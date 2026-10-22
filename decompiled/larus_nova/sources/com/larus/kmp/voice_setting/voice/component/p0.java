package com.larus.kmp.voice_setting.voice.component;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes30.dex */
public final class p0 implements Function0<com.larus.kmp.voice_setting.voice.feature.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f352450a;

    public p0(AttachReceiver r100) {
        this.f352450a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.kmp.voice_setting.voice.feature.l, t1a.c] */
    @Override // kotlin.jvm.functions.Function0
    public final com.larus.kmp.voice_setting.voice.feature.l invoke() {
        AttachReceiver r100 = this.f352450a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(com.larus.kmp.voice_setting.voice.feature.l.class));
    }
}
