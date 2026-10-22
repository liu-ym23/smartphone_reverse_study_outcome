package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class b implements nua.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGlobalActiveUserManager f408622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.ss.android.lark.active.user.api.a> f408623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f408624c;

    @Inject
    public b(IGlobalActiveUserManager r100) {
        Intrinsics.checkNotNullParameter(r100, "activeUserManager");
        this.f408622a = r100;
        this.f408623b = new LinkedHashSet();
        this.f408624c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
