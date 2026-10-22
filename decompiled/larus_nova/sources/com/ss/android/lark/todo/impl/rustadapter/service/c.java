package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetPagingTaskListsResponse;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements RustLog.a<GetPagingTaskListsResponse> {
    public c() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetPagingTaskListsResponse r100) {
        GetPagingTaskListsResponse r101 = r100;
        StringBuilder r102 = new StringBuilder("has_more:");
        Integer r103 = null;
        if (r101 == null) goto L5;
        Boolean r104 = r101.has_more;
    L6:
        r102.append(r104);
        r102.append(" last_token:");
        if (r101 == null) goto L9;
        Long r105 = r101.last_token;
    L10:
        r102.append(r105);
        r102.append(" size:");
        if (r101 == null) goto L15;
        List<TaskContainer> r106 = r101.task_lists;
        if (r106 == null) goto L15;
        r103 = Integer.valueOf(r106.size());
    L15:
        r102.append(r103);
        return r102.toString();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return GetPagingTaskListsResponse.ADAPTER.decode(r100);
    }
}
