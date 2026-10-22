package com.larus.paging;

import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class RemoteMediatorAccessImpl<Key, Value> implements x0<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f363735a = 0;

    public static final class a {
    }

    static {
    }

    public RemoteMediatorAccessImpl() {
        throw null;
    }

    @Override // com.larus.paging.x0
    public final StateFlowImpl getState() {
        throw null;
    }

    @Override // com.larus.paging.x0
    public final Object a(Continuation<? super RemoteMediator.InitializeAction> r100) {
        if ((r100 instanceof RemoteMediatorAccessImpl$initialize$1) == false) goto L7;
        RemoteMediatorAccessImpl$initialize$1 r101 = (RemoteMediatorAccessImpl$initialize$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        RemoteMediatorAccessImpl r105 = (RemoteMediatorAccessImpl) r101.L$0;
        ResultKt.throwOnFailure(r103);
        if (((RemoteMediator.InitializeAction) r103) == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) goto L14;
        return r103;
    L14:
        r105.getClass();
        RemoteMediatorAccessImpl$initialize$2$1 r106 = RemoteMediatorAccessImpl$initialize$2$1.INSTANCE;
        throw null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r101.L$0 = this;
        r101.label = 1;
        throw null;
    L7:
        r101 = new RemoteMediatorAccessImpl$initialize$1(this, r100);
        goto L8
    }

    @Override // com.larus.paging.y0
    public final void b(w0<Key, Value> r100) {
        Intrinsics.checkNotNullParameter(r100, "pagingState");
        final ArrayList r101 = new ArrayList();
        new RemoteMediatorAccessImpl$retryFailed$1(r101);
        throw null;
    }

    @Override // com.larus.paging.y0
    public final void c(final LoadType r100, final w0<Key, Value> r101) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        Intrinsics.checkNotNullParameter(r101, "pagingState");
        new RemoteMediatorAccessImpl$requestLoad$newRequest$1(r100, r101);
        throw null;
    }
}
