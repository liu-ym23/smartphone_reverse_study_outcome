package com.ss.android.lark.chat.api.service.impl.smartreply;

import b38.b;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class SmartApplyAnswerService_Factory implements Factory<SmartApplyAnswerService> {
    private final Provider<b> rucketProvider;

    @Override // javax.inject.Provider
    public SmartApplyAnswerService get() {
        return newInstance(this.rucketProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SmartApplyAnswerService_Factory(Provider<b> r100) {
        this.rucketProvider = r100;
    }

    public static SmartApplyAnswerService_Factory create(Provider<b> r100) {
        return new SmartApplyAnswerService_Factory(r100);
    }

    public static SmartApplyAnswerService newInstance(b r100) {
        return new SmartApplyAnswerService(r100);
    }
}
