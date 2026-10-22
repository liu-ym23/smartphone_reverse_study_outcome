package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo.SearchTaskListsResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f444255a = null;

    static {
        f444255a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SearchTaskListsResponse.ADAPTER.decode(r100);
    }
}
