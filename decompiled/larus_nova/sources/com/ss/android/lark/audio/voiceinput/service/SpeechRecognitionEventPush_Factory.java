package com.ss.android.lark.audio.voiceinput.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class SpeechRecognitionEventPush_Factory implements Factory<w> {
    private final Provider<p> pushRepoProvider;

    @Override // javax.inject.Provider
    public w get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SpeechRecognitionEventPush_Factory(Provider<p> r100) {
        this.pushRepoProvider = r100;
    }

    public static SpeechRecognitionEventPush_Factory create(Provider<p> r100) {
        return new SpeechRecognitionEventPush_Factory(r100);
    }

    public static w newInstance(p r100) {
        return new w(r100);
    }
}
