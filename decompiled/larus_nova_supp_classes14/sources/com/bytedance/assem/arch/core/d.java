package com.bytedance.assem.arch.core;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.assem.arch.extensions.HostInjector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final Map<l, com.bytedance.assem.arch.service.c> a;
    public final Map<l, MutableLiveData<? extends com.bytedance.assem.arch.service.a>> b;
    public final d c;

    public static final class a {
    }

    static {
    }

    public d() {
        this(null);
    }

    public d(d r1) {
        this.c = r1;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final void a(Class<?> r5, com.bytedance.assem.arch.service.c r6) throws IllegalStateException {
        if (Intrinsics.areEqual(r5, com.bytedance.assem.arch.service.c.class) == true) goto L26;
        if (Intrinsics.areEqual(r5, com.bytedance.assem.arch.service.b.class) == true) goto L26;
        r6.f();
        l r0 = new l(r5, null);
        Objects.toString(r5);
        r6.toString();
        this.a.size();
        Objects.toString(this.a);
        if (this.a.containsKey(r0) == true) goto L9;
    L13:
        this.a.put(r0, r6);
        if ((r6 instanceof com.bytedance.assem.arch.service.b) == false) goto L27;
        com.bytedance.assem.arch.service.a r7 = ((com.bytedance.assem.arch.service.b) r6).g();
        MutableLiveData<? extends com.bytedance.assem.arch.service.a> r8 = (MutableLiveData) ((LinkedHashMap) this.b).get(r0);
        if (r8 != null) goto L19;
        r8 = new MutableLiveData();
        this.b.put(r0, r8);
    L19:
        if (r8.getValue() == null) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L23;
        r8.setValue(r7);
        return;
    L23:
        r8.postValue(r7);
        return;
    L27:
        return;
    L9:
        if (r6 == ((com.bytedance.assem.arch.service.c) ((LinkedHashMap) this.a).get(r0))) goto L13;
        Lazy r1 = HostInjector.a;
        StringBuilder r2 = new StringBuilder("(service=");
        r2.append(r5);
        r2.append(", serviceKey =null) has been already registered on service store. the service real instance is ");
        r6.f();
        r2.append(r6);
        r2.append(", the registered service real instance is ");
        r2.append((com.bytedance.assem.arch.service.c) ((LinkedHashMap) this.a).get(r0));
        throw new IllegalStateException(r2.toString());
    L26:
        throw new IllegalArgumentException("{" + r5 + " - " + r6 + "}: AssemService or AssemObservableService can't be registered directly, use subclass instead");
    }
}
