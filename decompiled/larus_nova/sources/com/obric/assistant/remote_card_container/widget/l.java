package com.obric.assistant.remote_card_container.widget;

import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<RemoteCardContainer> f391332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f391333b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f391334c;

    static {
        f391332a = new AtomicReference(null);
        f391333b = CoroutineScopeKt.MainScope();
    }
}
