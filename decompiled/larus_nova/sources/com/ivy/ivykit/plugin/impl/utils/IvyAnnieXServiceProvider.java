package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;

/* JADX INFO: loaded from: classes23.dex */
public final class IvyAnnieXServiceProvider extends AnnieXServiceProvider {
    @Override // com.bytedance.android.anniex.base.service.AnnieXServiceProvider
    public final IAnnieXAccountService createIAnnieXAccountService() {
        return new AnonymousClass1();
    }

    public IvyAnnieXServiceProvider() {
    }
}
