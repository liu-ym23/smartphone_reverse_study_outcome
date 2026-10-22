package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo_comments.CreateTodoCommentReactionResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class l<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f444259a = null;

    static {
        f444259a = new l();
    }

    public l() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return CreateTodoCommentReactionResponse.ADAPTER.decode(r100);
    }
}
