package com.bytedance.timonkit.media_observer;

import android.os.Handler;
import android.util.Log;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TimonMediaObserverManager$processRegister$task$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ boolean $isImages;

    public TimonMediaObserverManager$processRegister$task$1(boolean r100) {
        this.$isImages = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.$isImages == false) goto L7;
        if (TimonMediaObserverManager.f270917b.get() == false) goto L7;
    L21:
        return Unit.INSTANCE;
    L7:
        if (this.$isImages == false) goto L9;
    L19:
    L17:
        Function0<? extends Handler> r100 = TimonMediaObserverManager.f270916a;
        return null;
    L12:
        if (this.$isImages == false) goto L14;
        Function0<? extends Handler> r101 = TimonMediaObserverManager.f270916a;     // Catch: Throwable -> L17
        TimonMediaObserverManager.f270917b.set(true);     // Catch: Throwable -> L17
    L15:
        return Integer.valueOf(Log.i("TimonMediaObserver", "lazy register"));
    L14:
        Function0<? extends Handler> r102 = TimonMediaObserverManager.f270916a;     // Catch: Throwable -> L17
        TimonMediaObserverManager.f270918c.set(true);     // Catch: Throwable -> L17
        goto L15
    L9:
        if (TimonMediaObserverManager.f270918c.get() == false) goto L19;
        goto L19
    }
}
