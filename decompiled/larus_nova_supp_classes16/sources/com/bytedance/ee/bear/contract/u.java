package com.bytedance.ee.bear.contract;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements f {
    public static final MutableLiveData<Boolean> a = null;
    public static final MutableLiveData<Boolean> b = null;
    public static final MutableLiveData<Boolean> c = null;
    public static final MutableLiveData<Boolean> d = null;

    static {
        a = new MutableLiveData();
        b = new MutableLiveData();
        c = new MutableLiveData();
        d = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean a() {
        StringBuilder r0 = new StringBuilder("appIsVisible()... isAppFront = ");
        MutableLiveData<Boolean> r1 = a;
        r0.append(r1.getValue());
        tt5.a.h("SdkVisibleServiceImpl", r0.toString());
        if (r1.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean f() {
        if (b.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public u() {
        eu5.a.b(eu5.b.a);
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(a, new q(r0));
        r0.addSource(b, new q(r0));
        com.bytedance.ee.util.ui.m.a(new s(this, r0));
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final long g() {
        if (f() != true) goto L5;
        return 0;
    L5:
        return 300000;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData h() {
        return eu5.a.a().b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData b() {
        return d;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData c() {
        return a;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData d() {
        return b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData e() {
        return c;
    }
}
