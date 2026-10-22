package com.ss.android.lark.integrator.im.impl.chat;

import dagger.internal.Factory;
import smb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeChatService_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeChatService_Factory f427975a = null;

        static {
            f427975a = new OfficeChatService_Factory();
        }
    }

    public OfficeChatService_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeChatService_Factory create() {
        return a.f427975a;
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }
}
