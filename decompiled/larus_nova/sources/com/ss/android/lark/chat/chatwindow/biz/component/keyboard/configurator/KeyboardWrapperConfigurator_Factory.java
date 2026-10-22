package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class KeyboardWrapperConfigurator_Factory implements Factory<KeyboardWrapperConfigurator> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final KeyboardWrapperConfigurator_Factory f412066a = null;

        static {
            f412066a = new KeyboardWrapperConfigurator_Factory();
        }
    }

    public KeyboardWrapperConfigurator_Factory() {
    }

    public static KeyboardWrapperConfigurator newInstance() {
        return new KeyboardWrapperConfigurator();
    }

    @Override // javax.inject.Provider
    public KeyboardWrapperConfigurator get() {
        return newInstance();
    }

    public static KeyboardWrapperConfigurator_Factory create() {
        return a.f412066a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
