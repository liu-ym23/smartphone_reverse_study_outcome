package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatMemberPickerDependencyImpl_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatMemberPickerDependencyImpl_Factory f433279a = null;

        static {
            f433279a = new ChatMemberPickerDependencyImpl_Factory();
        }
    }

    public ChatMemberPickerDependencyImpl_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static ChatMemberPickerDependencyImpl_Factory create() {
        return a.f433279a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
