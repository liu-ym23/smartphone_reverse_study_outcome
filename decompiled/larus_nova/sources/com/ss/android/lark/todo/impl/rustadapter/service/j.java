package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.TaskContainerSectionRef;
import com.bytedance.lark.pb.todo.v1.UpsertTaskContainerSectionRefsResponse;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements RustLog.a<UpsertTaskContainerSectionRefsResponse> {
    public j() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(UpsertTaskContainerSectionRefsResponse r100) {
        UpsertTaskContainerSectionRefsResponse r101 = r100;
        StringBuilder r102 = new StringBuilder("refs:");
        if (r101 == null) goto L7;
        List<TaskContainerSectionRef> r103 = r101.updated_refs;
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.size());
    L8:
        r102.append(r104);
        return r102.toString();
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UpsertTaskContainerSectionRefsResponse.ADAPTER.decode(r100);
    }
}
