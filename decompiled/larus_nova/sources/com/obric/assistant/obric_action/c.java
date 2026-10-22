package com.obric.assistant.obric_action;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f390402a = null;

    static {
        f390402a = LazyKt.lazy(new b());
    }

    public static final IObricActionService a() {
        return (IObricActionService) f390402a.getValue();
    }
}
