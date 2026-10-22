package com.larksuite.component.card.component.text;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes24.dex */
public final class UniversalCardTextPerfOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f283588a = null;

    static {
        f283588a = LazyKt.lazy(UniversalCardTextPerfOpt$enable$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) f283588a.getValue()).booleanValue();
    }
}
