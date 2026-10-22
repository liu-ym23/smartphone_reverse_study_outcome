package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.SendTodoHeartbeatResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class o<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<T> f444261a = null;

    static {
        f444261a = new o();
    }

    public o() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SendTodoHeartbeatResponse.ADAPTER.decode(r100);
    }
}
