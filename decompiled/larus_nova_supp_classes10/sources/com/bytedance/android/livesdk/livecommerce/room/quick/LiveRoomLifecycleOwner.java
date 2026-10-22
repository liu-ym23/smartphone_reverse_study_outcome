package com.bytedance.android.livesdk.livecommerce.room.quick;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/quick/LiveRoomLifecycleOwner;", "Lcom/bytedance/android/ec/core/utils/ECLifecycleOwnerAdapter;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomLifecycleOwner implements ECLifecycleOwnerAdapter {
    public final LifecycleRegistry a;

    public LiveRoomLifecycleOwner() {
        this.a = new LifecycleRegistry(this);
    }

    public final Lifecycle getLifecycle() {
        return rK();
    }

    public final Lifecycle rK() {
        return this.a;
    }
}
