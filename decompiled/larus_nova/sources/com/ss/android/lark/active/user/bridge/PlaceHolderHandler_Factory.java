package com.ss.android.lark.active.user.bridge;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class PlaceHolderHandler_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PlaceHolderHandler_Factory f408557a = null;

        static {
            f408557a = new PlaceHolderHandler_Factory();
        }
    }

    public PlaceHolderHandler_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }

    public static PlaceHolderHandler_Factory create() {
        return a.f408557a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
