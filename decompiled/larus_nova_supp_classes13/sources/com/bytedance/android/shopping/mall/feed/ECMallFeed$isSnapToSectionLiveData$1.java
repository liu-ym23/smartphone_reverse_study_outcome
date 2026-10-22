package com.bytedance.android.shopping.mall.feed;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/shopping/mall/feed/ECMallFeed$isSnapToSectionLiveData$1", "Landroidx/lifecycle/MutableLiveData;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeed$isSnapToSectionLiveData$1 extends MutableLiveData<Boolean> {
    public ECMallFeed$isSnapToSectionLiveData$1(Object r1) {
        super(r1);
    }

    public final void setValue(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L5;
        super.setValue(r4);
        return;
    L5:
        super.postValue(r4);
    }
}
