package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import qxa.b;

/* JADX INFO: loaded from: classes36.dex */
public final class ExtensionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f427932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f427933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f427934c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f427935d = null;

    static {
        f427932a = new ArrayList();
        f427933b = new ArrayList();
        f427934c = LazyKt.lazy(ExtensionManager$imContext$2.INSTANCE);
        f427935d = new AtomicBoolean(false);
    }

    public static ImContextImpl a() {
        return (ImContextImpl) f427934c.getValue();
    }

    public static gya.a b(MessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        if (r100 == MessageType.UNKNOWN) goto L7;
        Object r101 = ((ConcurrentHashMap) a().f427939d).get(r100);
        if ((r101 instanceof gya.a) == false) goto L7;
        return (gya.a) r101;
    L7:
        return null;
    }
}
