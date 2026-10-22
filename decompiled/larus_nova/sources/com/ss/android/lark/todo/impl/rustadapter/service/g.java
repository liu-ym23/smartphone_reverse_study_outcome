package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.SendTodoHeartbeatResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f444256a = null;

    static {
        f444256a = new g();
    }

    public g() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SendTodoHeartbeatResponse.ADAPTER.decode(r100);
    }
}
