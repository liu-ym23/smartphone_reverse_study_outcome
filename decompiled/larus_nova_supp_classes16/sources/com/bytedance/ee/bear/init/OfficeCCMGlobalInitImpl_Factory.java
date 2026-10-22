package com.bytedance.ee.bear.init;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeCCMGlobalInitImpl_Factory implements Factory<c> {

    public static final class a {
        public static final OfficeCCMGlobalInitImpl_Factory a = null;

        static {
            a = new OfficeCCMGlobalInitImpl_Factory();
        }
    }

    public OfficeCCMGlobalInitImpl_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static OfficeCCMGlobalInitImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m405get() {
        return get();
    }
}
