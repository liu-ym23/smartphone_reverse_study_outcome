package com.larus.business.multitask_management.impl;

import androidx.fragment.app.Fragment;
import com.larus.business.multitask_management.impl.fullscreen.MultiTaskManagementFullscreenFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Fragment r101 = (Fragment) r100;
        int r102 = MultiTaskServiceImpl.f320734e;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Boolean.valueOf(r101 instanceof MultiTaskManagementFullscreenFragment);
    }
}
