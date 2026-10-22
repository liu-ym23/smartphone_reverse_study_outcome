package com.ss.android.lark.officesdk.feed.impl;

import com.ss.android.lark.flow.feed.sidebar.human.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowFeedApiProxy implements qtb.b {

    public static final class a {
    }

    static {
    }

    public FlowFeedApiProxy() {
    }

    public static qtb.b X0() {
        qtb.b r100 = (qtb.b) OfficeSDKManager.getHostGlobalService(qtb.b.class);
        if (r100 != null) goto L5;
        Log.e("FlowFeedApiProxy", "IOfficeSDKFeedApi is null");
    L5:
        return r100;
    }

    @Override // qtb.b
    public final boolean P0() {
        qtb.b r100 = X0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.P0();
    }

    @Override // qtb.b
    public final boolean Y1() {
        qtb.b r100 = X0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.Y1();
    }

    @Override // qtb.b
    public final boolean getIsImFeatureOpenedByHostManual() {
        qtb.b r100 = X0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getIsImFeatureOpenedByHostManual();
    }

    @Override // qtb.b
    public final boolean K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        qtb.b r101 = X0();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.K(r100);
    }

    @Override // qtb.b
    public final void M(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        qtb.b r101 = X0();
        if (r101 == null) goto L6;
        r101.M(r100);
        return;
    }

    @Override // qtb.b
    public final void a0(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        qtb.b r101 = X0();
        if (r101 == null) goto L6;
        r101.a0(r100);
        return;
    }

    @Override // qtb.b
    public final Object N1(byte[] r100, Continuation<? super byte[]> r101) {
        if ((r101 instanceof FlowFeedApiProxy$packFeedChannel$1) == false) goto L7;
        FlowFeedApiProxy$packFeedChannel$1 r102 = (FlowFeedApiProxy$packFeedChannel$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L19:
        byte[] r107 = (byte[]) r104;
        if (r107 != null) goto L23;
    L21:
        Log.e("FlowFeedApiProxy", "packFeedChannel delegate is null");
        return new byte[0];
    L23:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        qtb.b r108 = X0();
        if (r108 == null) goto L21;
        r102.label = 1;
        r104 = r108.N1(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new FlowFeedApiProxy$packFeedChannel$1(this, r101);
        goto L8
    }

    @Override // qtb.b
    public final Object g0(byte[] r100, Continuation<? super byte[]> r101) {
        if ((r101 instanceof FlowFeedApiProxy$packFeedPreview$1) == false) goto L7;
        FlowFeedApiProxy$packFeedPreview$1 r102 = (FlowFeedApiProxy$packFeedPreview$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L19:
        byte[] r107 = (byte[]) r104;
        if (r107 != null) goto L23;
    L21:
        Log.e("FlowFeedApiProxy", "packFeedPreview delegate is null");
        return new byte[0];
    L23:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        qtb.b r108 = X0();
        if (r108 == null) goto L21;
        r102.label = 1;
        r104 = r108.g0(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new FlowFeedApiProxy$packFeedPreview$1(this, r101);
        goto L8
    }

    @Override // qtb.b
    public final Object z1(byte[] r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowFeedApiProxy$verifyFeedData$1) == false) goto L7;
        FlowFeedApiProxy$verifyFeedData$1 r102 = (FlowFeedApiProxy$verifyFeedData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        qtb.b r107 = X0();
        if (r107 == null) goto L19;
        r102.label = 1;
        if (r107.z1(r100, r102) != r105) goto L21;
        return r105;
    L19:
        Log.e("FlowFeedApiProxy", "verifyFeedData delegate is null");
    L7:
        r102 = new FlowFeedApiProxy$verifyFeedData$1(this, r101);
        goto L8
    }

    @Override // qtb.b
    public final boolean X1(String r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        qtb.b r103 = X0();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.X1(r100, r101, r102);
    }
}
