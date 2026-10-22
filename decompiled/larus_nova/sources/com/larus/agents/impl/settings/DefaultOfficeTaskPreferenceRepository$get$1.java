package com.larus.agents.impl.settings;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.settings.DefaultOfficeTaskPreferenceRepository", f = "OfficeTaskPreferenceRepository.kt", i = {0, 0, 1, 1, 2, 2, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7}, l = {164, 45, 46, 48, 52, 174, 56, 63}, m = MonitorConstants.CONNECT_TYPE_GET, n = {"accountId", "$this$withLock_u24default$iv", "accountId", "$this$withLock_u24default$iv", "accountId", "cachedRevision", "accountId", "remotePreference", "$this$withLock_u24default$iv", "cachedRevision", "accountId", "remotePreference", "$this$withLock_u24default$iv", "cachedRevision", "remotePreference", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1"})
public final class DefaultOfficeTaskPreferenceRepository$get$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultOfficeTaskPreferenceRepository this$0;

    public DefaultOfficeTaskPreferenceRepository$get$1(DefaultOfficeTaskPreferenceRepository r100, Continuation<? super DefaultOfficeTaskPreferenceRepository$get$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
