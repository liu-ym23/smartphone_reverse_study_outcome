package com.bytedance.ee.bear.contract;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes16.dex */
public final class u implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f217197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f217198b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f217199c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f217200d = null;

    static {
        f217197a = new MutableLiveData();
        f217198b = new MutableLiveData();
        f217199c = new MutableLiveData();
        f217200d = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean a() {
        StringBuilder r100 = new StringBuilder("appIsVisible()... isAppFront = ");
        MutableLiveData<Boolean> r101 = f217197a;
        r100.append(r101.getValue());
        tt5.a.h("SdkVisibleServiceImpl", r100.toString());
        if (r101.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean f() {
        if (f217198b.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public u() {
        eu5.a.b(eu5.b.f474075a);
        final MediatorLiveData r100 = new MediatorLiveData();
        r100.addSource(f217197a, new q(r100));
        r100.addSource(f217198b, new q(r100));
        com.bytedance.ee.util.ui.m.a(new s(this, r100));
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
        return eu5.a.a().f474074b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData b() {
        return f217200d;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData c() {
        return f217197a;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData d() {
        return f217198b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData e() {
        return f217199c;
    }
}
