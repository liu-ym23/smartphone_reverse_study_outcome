package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.ApplyTaskListPermissionResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f444253a = null;

    static {
        f444253a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return ApplyTaskListPermissionResponse.ADAPTER.decode(r100);
    }
}
