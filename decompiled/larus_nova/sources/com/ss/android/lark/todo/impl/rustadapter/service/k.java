package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.SaveCommentDraftResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements RustLog.a<SaveCommentDraftResponse> {
    public k() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final /* bridge */ /* synthetic */ String a(SaveCommentDraftResponse r100) {
        return "TRUE";
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return SaveCommentDraftResponse.ADAPTER.decode(r100);
    }
}
