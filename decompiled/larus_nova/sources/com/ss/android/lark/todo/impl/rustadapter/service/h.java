package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.UpdateTaskListMembersResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f444257a = null;

    static {
        f444257a = new h();
    }

    public h() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return UpdateTaskListMembersResponse.ADAPTER.decode(r100);
    }
}
