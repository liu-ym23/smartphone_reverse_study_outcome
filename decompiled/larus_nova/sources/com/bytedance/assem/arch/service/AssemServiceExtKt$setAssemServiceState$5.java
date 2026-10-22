package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/fragment/app/Fragment;", "Lcom/bytedance/assem/arch/service/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/assem/arch/service/a;", "DATA", "Landroidx/lifecycle/LifecycleOwner;", "<anonymous parameter 0>", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class AssemServiceExtKt$setAssemServiceState$5 implements GenericLifecycleObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        if (d.f193044b[r101.ordinal()] == 1) goto L6;
        return;
    L6:
        throw null;
    }
}
