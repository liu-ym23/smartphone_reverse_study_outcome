package com.ss.android.lark.audio.voiceinput.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class NewAudio2TextPush_Factory implements Factory<NewAudio2TextPush> {
    private final Provider<m> pushRepoProvider;

    @Override // javax.inject.Provider
    public NewAudio2TextPush get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NewAudio2TextPush_Factory(Provider<m> r100) {
        this.pushRepoProvider = r100;
    }

    public static NewAudio2TextPush_Factory create(Provider<m> r100) {
        return new NewAudio2TextPush_Factory(r100);
    }

    public static NewAudio2TextPush newInstance(m r100) {
        return new NewAudio2TextPush(r100);
    }
}
