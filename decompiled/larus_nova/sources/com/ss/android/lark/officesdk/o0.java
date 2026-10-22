package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import dagger.Lazy;
import dagger.hilt.dwarf.spi.DwarfSPI;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKGlobalScope
public final class o0 implements DwarfSPI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public Lazy<Map<Class<?>, Provider<Object>>> f437122a;

    @Inject
    public o0() {
    }

    @Override // dagger.hilt.dwarf.spi.DwarfSPI
    public final <T> T get(Class<T> r100) {
        Provider<Object> r101 = this.f437122a.get().get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return (T) r101.get();
    }
}
