package com.larus.voicecall.impl.component.feedback;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f377464a = null;

    static {
        f377464a = LazyKt.lazy(new t());
    }

    public static Keva a() {
        return (Keva) f377464a.getValue();
    }
}
