package com.bytedance.assem.arch.core;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.assem.arch.extensions.HostInjector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<l, com.bytedance.assem.arch.service.c> f192888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<l, MutableLiveData<? extends com.bytedance.assem.arch.service.a>> f192889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f192890c;

    public static final class a {
    }

    static {
    }

    public d() {
        this(null);
    }

    public d(d r100) {
        this.f192890c = r100;
        this.f192888a = new LinkedHashMap();
        this.f192889b = new LinkedHashMap();
    }

    public final void a(Class<?> r100, com.bytedance.assem.arch.service.c r101) throws IllegalStateException {
        if (Intrinsics.areEqual(r100, com.bytedance.assem.arch.service.c.class) == true) goto L26;
        if (Intrinsics.areEqual(r100, com.bytedance.assem.arch.service.b.class) == true) goto L26;
        r101.f();
        l r102 = new l(r100, null);
        Objects.toString(r100);
        r101.toString();
        this.f192888a.size();
        Objects.toString(this.f192888a);
        if (this.f192888a.containsKey(r102) == true) goto L9;
    L13:
        this.f192888a.put(r102, r101);
        if ((r101 instanceof com.bytedance.assem.arch.service.b) == false) goto L27;
        com.bytedance.assem.arch.service.a r103 = ((com.bytedance.assem.arch.service.b) r101).g();
        MutableLiveData<? extends com.bytedance.assem.arch.service.a> r104 = (MutableLiveData) ((LinkedHashMap) this.f192889b).get(r102);
        if (r104 != null) goto L19;
        r104 = new MutableLiveData();
        this.f192889b.put(r102, r104);
    L19:
        if (r104.getValue() == null) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L23;
        r104.setValue(r103);
        return;
    L23:
        r104.postValue(r103);
        return;
    L27:
        return;
    L9:
        if (r101 == ((com.bytedance.assem.arch.service.c) ((LinkedHashMap) this.f192888a).get(r102))) goto L13;
        Lazy r105 = HostInjector.f192919a;
        StringBuilder r106 = new StringBuilder("(service=");
        r106.append(r100);
        r106.append(", serviceKey =null) has been already registered on service store. the service real instance is ");
        r101.f();
        r106.append(r101);
        r106.append(", the registered service real instance is ");
        r106.append((com.bytedance.assem.arch.service.c) ((LinkedHashMap) this.f192888a).get(r102));
        throw new IllegalStateException(r106.toString());
    L26:
        throw new IllegalArgumentException("{" + r100 + " - " + r101 + "}: AssemService or AssemObservableService can't be registered directly, use subclass instead");
    }
}
