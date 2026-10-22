package com.ss.android.lark.officesdk.contact.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ContactOfficeImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ContactOfficeImpl_Factory f433140a = null;

        static {
            f433140a = new ContactOfficeImpl_Factory();
        }
    }

    public ContactOfficeImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static ContactOfficeImpl_Factory create() {
        return a.f433140a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
