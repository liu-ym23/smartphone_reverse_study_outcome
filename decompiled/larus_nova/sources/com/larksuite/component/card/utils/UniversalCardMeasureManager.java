package com.larksuite.component.card.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes24.dex */
public final class UniversalCardMeasureManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<UniversalCardMeasureManager> f283959a = null;

    public static final class a {
    }

    public UniversalCardMeasureManager() {
    }

    static {
        f283959a = LazyKt.lazy(LazyThreadSafetyMode.NONE, UniversalCardMeasureManager$Companion$instance$2.INSTANCE);
    }
}
