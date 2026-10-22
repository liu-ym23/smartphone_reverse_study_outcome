package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class DoraAudioService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f365699a = null;

    static {
        f365699a = LazyKt.lazy(new h0());
    }

    public static com.larus.platform.api.j2 c() {
        return (com.larus.platform.api.j2) f365699a.getValue();
    }

    public static void a() {
        com.larus.platform.api.j2 r100 = c();
        if (r100 == null) goto L10;
        Integer r101 = r100.l();
        if (r101 == null) goto L10;
        if (r101.intValue() != 2) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraAudioService$disableVuiForMicOccupy$1(null), 3, null);
        return;
    L10:
        r102 = false;
        goto L11
    }

    public static void b() {
        com.larus.platform.api.j2 r100 = c();
        if (r100 == null) goto L10;
        Integer r101 = r100.l();
        if (r101 == null) goto L10;
        if (r101.intValue() != 2) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraAudioService$enableVuiAfterMicRelease$1(null), 3, null);
        return;
    L10:
        r102 = false;
        goto L11
    }
}
