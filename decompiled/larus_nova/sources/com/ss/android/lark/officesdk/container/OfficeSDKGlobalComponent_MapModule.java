package com.ss.android.lark.officesdk.container;

import androidx.lifecycle.ViewModel;
import dagger.Module;
import dagger.multibindings.Multibinds;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
@Module
interface OfficeSDKGlobalComponent_MapModule {
    @Multibinds
    Map<String, Object> hiltViewModelAssistedMap();

    @Multibinds
    Map<String, ViewModel> hiltViewModelMap();
}
