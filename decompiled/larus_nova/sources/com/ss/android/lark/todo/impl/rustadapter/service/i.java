package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.UpdateTaskListMembersResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class i<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f444258a = null;

    static {
        f444258a = new i();
    }

    public i() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return UpdateTaskListMembersResponse.ADAPTER.decode(r100);
    }
}
