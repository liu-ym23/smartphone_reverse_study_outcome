package com.bytedance.lark.sdk;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/sdk/InvokeResponse;", "", "statusCode", "", "meta", "", WsConstants.KEY_PAYLOAD, "<init>", "(J[B[B)V", "rust-interop_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvokeResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f254047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f254048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f254049c;

    public InvokeResponse(long r100, byte[] r101, byte[] r102) {
        Intrinsics.checkNotNullParameter(r101, "meta");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        this.f254047a = r100;
        this.f254048b = r101;
        this.f254049c = r102;
    }
}
