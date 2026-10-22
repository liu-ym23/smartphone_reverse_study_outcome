package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SafeCushionThreadExecutor$mainHandler$2 extends Lambda implements Function0<Handler> {
    public static final SafeCushionThreadExecutor$mainHandler$2 INSTANCE = null;

    static {
        INSTANCE = new SafeCushionThreadExecutor$mainHandler$2();
    }

    public SafeCushionThreadExecutor$mainHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Handler invoke() {
        return invoke();
    }
}
