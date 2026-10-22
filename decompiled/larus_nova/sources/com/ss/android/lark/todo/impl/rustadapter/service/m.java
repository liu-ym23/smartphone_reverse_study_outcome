package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.DeleteCommentDraftResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements RustLog.a<DeleteCommentDraftResponse> {
    public m() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final /* bridge */ /* synthetic */ String a(DeleteCommentDraftResponse r100) {
        return "";
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return DeleteCommentDraftResponse.ADAPTER.decode(r100);
    }
}
