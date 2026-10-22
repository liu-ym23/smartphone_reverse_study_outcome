package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.DeleteTaskSectionResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements RustLog.a<DeleteTaskSectionResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f444262a;

    public q(String r100) {
        this.f444262a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(DeleteTaskSectionResponse r100) {
        return "delete task section, section_guid = " + this.f444262a;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return DeleteTaskSectionResponse.ADAPTER.decode(r100);
    }
}
