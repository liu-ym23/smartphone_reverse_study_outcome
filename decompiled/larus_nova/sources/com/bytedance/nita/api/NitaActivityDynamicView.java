package com.bytedance.nita.api;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/nita/api/NitaActivityDynamicView;", "Lcom/bytedance/nita/api/d;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class NitaActivityDynamicView extends d implements LifecycleObserver {
    @Override // com.bytedance.nita.api.d, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return 0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        o37.c r100 = o37.c.f521918e;
        Intrinsics.throwNpe();
        r100.getClass();
        q37.a.f531525i.getClass();
        q37.a.e(null, null);
    }

    public NitaActivityDynamicView() {
    }

    @Override // com.bytedance.nita.api.c
    public NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
