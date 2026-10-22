package com.ss.android.lark.officesdk;

import com.ss.android.lark.passportc.dwarf.UserScope;
import dagger.Lazy;
import dagger.hilt.dwarf.spi.DwarfSPI;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class h0 implements DwarfSPI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public Lazy<Map<Class<?>, Provider<Object>>> f433252a;

    @Inject
    public h0() {
    }

    @Override // dagger.hilt.dwarf.spi.DwarfSPI
    public final <T> T get(Class<T> r100) {
        Provider<Object> r101 = this.f433252a.get().get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return (T) r101.get();
    }
}
