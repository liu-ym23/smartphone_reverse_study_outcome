package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetTodoResponse;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.todo.impl.utils.LogMessageUtilKt;

/* JADX INFO: loaded from: classes38.dex */
public final class y implements RustLog.a<GetTodoResponse> {
    public y() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetTodoResponse r100) {
        GetTodoResponse r101 = r100;
        if (r101 == null) goto L8;
        Todo r102 = r101.todo;
        if (r102 == null) goto L8;
        String r103 = LogMessageUtilKt.a(r102);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "NULL";
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return GetTodoResponse.ADAPTER.decode(r100);
    }
}
