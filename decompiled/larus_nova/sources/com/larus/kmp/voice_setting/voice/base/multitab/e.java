package com.larus.kmp.voice_setting.voice.base.multitab;

import com.larus.kmp.voice_setting.voice.list.VoiceListLoadTriggerKind;
import eh9.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final MultiTabVoiceRequestKind a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f472737b != VoiceListLoadTriggerKind.LOAD_MORE) goto L6;
        return MultiTabVoiceRequestKind.LOAD_MORE;
    L6:
        return MultiTabVoiceRequestKind.INIT;
    }
}
