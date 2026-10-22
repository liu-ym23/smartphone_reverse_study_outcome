package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Provider<e<?, ?>>> f408564a;

    @Override // com.ss.android.lark.active.user.bridge.f
    public final Map<Class<?>, Provider<e<?, ?>>> a() {
        return new HashMap(this.f408564a);
    }

    @Inject
    public d() {
        this.f408564a = new ConcurrentHashMap();
    }
}
