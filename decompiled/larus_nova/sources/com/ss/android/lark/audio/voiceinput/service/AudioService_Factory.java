package com.ss.android.lark.audio.voiceinput.service;

import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AudioService_Factory implements Factory<i> {
    private final Provider<k> audioRepoProvider;
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.audioRepoProvider.get(), this.userSessionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AudioService_Factory(Provider<k> r100, Provider<UserSession> r101) {
        this.audioRepoProvider = r100;
        this.userSessionProvider = r101;
    }

    public static AudioService_Factory create(Provider<k> r100, Provider<UserSession> r101) {
        return new AudioService_Factory(r100, r101);
    }

    public static i newInstance(k r100, UserSession r101) {
        return new i(r100, r101);
    }
}
