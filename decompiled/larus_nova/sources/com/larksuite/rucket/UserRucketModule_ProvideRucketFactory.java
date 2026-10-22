package com.larksuite.rucket;

import b38.a;
import b38.b;
import b38.c;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.core.RucketImpl;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jdb.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UserRucketModule_ProvideRucketFactory implements Factory<b> {
    private final Provider<l> clientProvider;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideRucket(this.clientProvider.get(), this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserRucketModule_ProvideRucketFactory(Provider<l> r100, Provider<String> r101) {
        this.clientProvider = r100;
        this.uidProvider = r101;
    }

    public static UserRucketModule_ProvideRucketFactory create(Provider<l> r100, Provider<String> r101) {
        return new UserRucketModule_ProvideRucketFactory(r100, r101);
    }

    public static b provideRucket(l r100, String r101) {
        int r102 = c.f17385a;
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "uid");
        RucketImpl r103 = new RucketImpl();
        int r104 = a.f17381a;
        Intrinsics.checkNotNullParameter(r101, "uid");
        if (((e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class)).B0(r101, "messenger.im.scoped_rucket") == false) goto L6;
        r103.a(new d38.a(r100));
        r103.a(new d38.c(r100));
        r103.a(new d38.e(r100));
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r103);
    }
}
