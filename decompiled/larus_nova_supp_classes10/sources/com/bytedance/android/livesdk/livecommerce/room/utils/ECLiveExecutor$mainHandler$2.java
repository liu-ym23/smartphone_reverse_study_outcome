package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECLiveExecutor$mainHandler$2 extends Lambda implements Function0<Handler> {
    public static final ECLiveExecutor$mainHandler$2 INSTANCE = null;

    static {
        INSTANCE = new ECLiveExecutor$mainHandler$2();
    }

    public ECLiveExecutor$mainHandler$2() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1151invoke() {
        return invoke();
    }
}
