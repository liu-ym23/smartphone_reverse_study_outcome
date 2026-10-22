package com.bytedance.ee.bear.diskmanager.container;

import by4.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMUserFileStorage_Factory implements Factory<a> {
    private final Provider<String> uidProvider;

    public a get() {
        return newInstance((String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m130get() {
        return get();
    }

    public CCMUserFileStorage_Factory(Provider<String> r1) {
        this.uidProvider = r1;
    }

    public static CCMUserFileStorage_Factory create(Provider<String> r1) {
        return new CCMUserFileStorage_Factory(r1);
    }

    public static a newInstance(String r1) {
        return new a(r1);
    }
}
