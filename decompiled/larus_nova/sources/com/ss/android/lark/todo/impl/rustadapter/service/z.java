package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.UpdateTaskViewResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements RustLog.a<UpdateTaskViewResponse> {
    public z() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final /* bridge */ /* synthetic */ String a(UpdateTaskViewResponse r100) {
        return "TRUE";
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UpdateTaskViewResponse.ADAPTER.decode(r100);
    }
}
