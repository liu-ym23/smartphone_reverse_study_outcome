package com.bytedance.locallife.groupon.basic.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/groupon/basic/utils/AutoDisposableObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3})
public final class AutoDisposableObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        throw null;
    }
}
