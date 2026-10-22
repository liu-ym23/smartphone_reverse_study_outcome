package com.larksuite.component.card.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/service/LifecycleCardServiceHolder;", "Lcom/larksuite/component/card/service/BaseCardServiceHolder;", "Landroidx/lifecycle/LifecycleObserver;", LocationMonitorConst.IDENTIFIER, "", "<init>", "(I)V", LiveCommonConstants.REASON_ON_DEDTROY, "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleCardServiceHolder extends com.larksuite.component.card.service.a implements LifecycleObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f283924d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, LifecycleCardServiceHolder> f283925e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f283926c;

    public static final class a {
        public a() {
        }

        private final int getIdentifier(Lifecycle r100) {
            return r100.hashCode();
        }

        public final LifecycleCardServiceHolder a(Lifecycle r100) {
            Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
            int r101 = getIdentifier(r100);
            Map<Integer, LifecycleCardServiceHolder> r102 = LifecycleCardServiceHolder.f283925e;
            HashMap r103 = (HashMap) r102;
            LifecycleCardServiceHolder r104 = (LifecycleCardServiceHolder) r103.get(Integer.valueOf(r101));
            if (r104 != null) goto L6;
            LifecycleCardServiceHolder r105 = new LifecycleCardServiceHolder(r101);
            r103.put(Integer.valueOf(r101), r105);
            r100.addObserver(r105);
            return r105;
        L6:
            return r104;
        }
    }

    static {
        f283924d = new a();
        f283925e = new HashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        a();
        Map<Integer, LifecycleCardServiceHolder> r100 = f283925e;
        HashMap r101 = (HashMap) r100;
        r101.remove(Integer.valueOf(this.f283926c));
    }

    public LifecycleCardServiceHolder(int r100) {
        this.f283926c = r100;
    }
}
