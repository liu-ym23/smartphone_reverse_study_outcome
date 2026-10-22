package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.SearchTaskResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class a0<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0<T> f444254a = null;

    static {
        f444254a = new a0();
    }

    public a0() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SearchTaskResponse.ADAPTER.decode(r100);
    }
}
