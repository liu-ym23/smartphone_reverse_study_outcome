package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashPermissionInfoResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CoreRequests$queryFlashPermissionInfo$1 extends FunctionReferenceImpl implements Function1<ECFlashPermissionInfoResponse, Unit> {
    public CoreRequests$queryFlashPermissionInfo$1(v0 r8) {
        super(1, r8, v0.class, "onSuccess", "onSuccess(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECFlashPermissionInfoResponse) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(ECFlashPermissionInfoResponse r2) {
        ((v0) ((CallableReference) this).receiver).onSuccess(r2);
    }
}
