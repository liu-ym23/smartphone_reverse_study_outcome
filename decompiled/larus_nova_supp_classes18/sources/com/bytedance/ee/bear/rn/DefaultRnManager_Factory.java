package com.bytedance.ee.bear.rn;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DefaultRnManager_Factory implements Factory<b> {

    public static final class a {
        public static final DefaultRnManager_Factory a = null;

        static {
            a = new DefaultRnManager_Factory();
        }
    }

    public DefaultRnManager_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static DefaultRnManager_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m465get() {
        return get();
    }
}
