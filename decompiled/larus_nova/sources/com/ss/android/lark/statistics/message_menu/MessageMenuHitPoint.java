package com.ss.android.lark.statistics.message_menu;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import o5c.b;
import q5c.a;

/* JADX INFO: loaded from: classes38.dex */
public final class MessageMenuHitPoint extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageMenuHitPoint f440732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440733b = null;

    static {
        f440732a = new MessageMenuHitPoint();
        f440733b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MessageMenuHitPoint$statistics$2.INSTANCE);
    }

    public final b a() {
        return (b) f440733b.getValue();
    }

    public MessageMenuHitPoint() {
    }
}
