package com.bytedance.lark.policy.observer;

import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.event.InnerEvent;
import com.bytedance.lark.policy.manager.FactorManager;
import com.bytedance.lark.policy.model.y;
import com.bytedance.lark.policy.utils.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements com.bytedance.lark.policy.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f253876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f253877b;

    /* JADX INFO: renamed from: com.bytedance.lark.policy.observer.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C3607a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253878a = null;

        static {
            int[] r100 = new int[Event.values().length];
            r100[Event.EVENT_APP_STATE_ON_FRONT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Event.EVENT_APP_STATE_ON_BACKGROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253878a = r100;
        }
    }

    static {
        f253876a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.lark.policy.event.a
    public final void a(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = C3607a.f253878a[r100.ordinal()];
        ke6.a r102 = null;
        if (r101 != 1) goto L5;
        int r103 = Logger.f253883a;
        Logger.c("AppStateObserver", "on event: currentState = " + f253877b);
        if (f253877b == 0) goto L38;
        f253877b = 0;
        if (com.bytedance.lark.policy.utils.c.a() == false) goto L17;
        List<String> r104 = FactorManager.f253806a;
        FactorManager.a(true);
    L18:
        long r105 = System.currentTimeMillis();
        y r106 = com.bytedance.lark.policy.manager.a.f253814a;
        long r107 = r105 - com.bytedance.lark.policy.manager.a.f253819f;
        long r108 = ke6.b.f503031b;
        if (r107 < r108) goto L28;
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r109 = EventManager.f253801a;
        EventManager.b(InnerEvent.EVENT_TIMER);
        ke6.a r110 = ke6.b.f503030a;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r110 = null;
    L23:
        r110.removeMessages(100);
        ke6.a r111 = ke6.b.f503030a;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L27:
        r102.sendEmptyMessageDelayed(100, r108);
        return;
    L26:
        r102 = r111;
        goto L27
    L28:
        long r112 = r108 - r107;
        ke6.a r113 = ke6.b.f503030a;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r113 = null;
    L31:
        r113.removeMessages(100);
        ke6.a r114 = ke6.b.f503030a;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L35:
        r102.sendEmptyMessageDelayed(100, r112);
        return;
    L34:
        r102 = r114;
        goto L35
    L17:
        List<String> r115 = FactorManager.f253806a;
        FactorManager.c();
        goto L18
    L38:
        return;
    L5:
        if (r101 != 2) goto L40;
        f253877b = 1;
        ke6.a r116 = ke6.b.f503030a;
        if (r116 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L11:
        r102.removeMessages(100);
        return;
    L10:
        r102 = r116;
        goto L11
    }
}
