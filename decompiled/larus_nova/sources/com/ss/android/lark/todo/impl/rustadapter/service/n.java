package com.ss.android.lark.todo.impl.rustadapter.service;

import com.ss.android.lark.pb.todo_comments.DeleteTodoCommentReactionResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class n<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T> f444260a = null;

    static {
        f444260a = new n();
    }

    public n() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return DeleteTodoCommentReactionResponse.ADAPTER.decode(r100);
    }
}
