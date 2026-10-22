package com.ss.android.lark.chat.component.task;

import com.ss.android.lark.passportc.api.i;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class SetLoginChatterTask_Factory implements Factory<SetLoginChatterTask> {
    private final Provider<i> multiOnlineFGProvider;

    @Override // javax.inject.Provider
    public SetLoginChatterTask get() {
        return newInstance(this.multiOnlineFGProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SetLoginChatterTask_Factory(Provider<i> r100) {
        this.multiOnlineFGProvider = r100;
    }

    public static SetLoginChatterTask_Factory create(Provider<i> r100) {
        return new SetLoginChatterTask_Factory(r100);
    }

    public static SetLoginChatterTask newInstance(i r100) {
        return new SetLoginChatterTask(r100);
    }
}
