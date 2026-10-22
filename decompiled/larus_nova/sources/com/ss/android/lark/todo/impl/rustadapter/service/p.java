package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.TodoComment;
import com.bytedance.lark.pb.todo.v1.UpdateCommentResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements RustLog.a<UpdateCommentResponse> {
    public p() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(UpdateCommentResponse r100) {
        UpdateCommentResponse r101 = r100;
        if (r101 == null) goto L8;
        TodoComment r102 = r101.comment;
        if (r102 == null) goto L8;
        String r103 = r102.cid;
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "";
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UpdateCommentResponse.ADAPTER.decode(r100);
    }
}
