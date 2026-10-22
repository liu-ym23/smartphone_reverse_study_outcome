package com.ss.android.lark.scs.policy.engine.manage;

import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.ss.android.lark.appcontext.applifecycle.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f439849a = null;

    static {
        f439849a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.y
    public final void f(y.a r100, y.a r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        if (b.f439850a == false) goto L7;
        b.f439850a = false;
        return;
    L7:
        if (r100.f408860c == true) goto L12;
        if (r101.f408860c == false) goto L12;
        Event r102 = Event.EVENT_APP_STATE_ON_FRONT;
        ke6.d r103 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r102, "event");
        EventManager.a(r102);
    L12:
        if (r100.f408860c == true) goto L14;
        return;
    L14:
        if (r101.f408860c == true) goto L18;
        Event r104 = Event.EVENT_APP_STATE_ON_BACKGROUND;
        ke6.d r105 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r104, "event");
        EventManager.a(r104);
        return;
    }
}
