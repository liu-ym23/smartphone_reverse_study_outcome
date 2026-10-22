package com.ss.android.lark.officesdk.container;

import dagger.Module;
import dagger.multibindings.Multibinds;
import java.util.Set;

/* JADX INFO: loaded from: classes37.dex */
@Module
interface OfficeSDKGlobalComponent_KeySetModule {
    @Multibinds
    Set<String> viewModelAssistedKeys();

    @Multibinds
    Set<String> viewModelKeys();
}
