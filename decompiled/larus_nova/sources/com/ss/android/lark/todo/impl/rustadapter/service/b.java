package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetPagingTaskContainerRelatedDataResponse;
import com.bytedance.lark.pb.todo.v1.PageResult;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements RustLog.a<GetPagingTaskContainerRelatedDataResponse> {
    public b() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetPagingTaskContainerRelatedDataResponse r100) {
        GetPagingTaskContainerRelatedDataResponse r101 = r100;
        StringBuilder r102 = new StringBuilder("getPagingTaskContainerRelatedData: size=");
        String r103 = null;
        if (r101 == null) goto L7;
        List<TaskContainer> r104 = r101.containers;
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(r104.size());
    L8:
        r102.append(r105);
        r102.append(",hasMore=");
        if (r101 == null) goto L13;
        PageResult r106 = r101.page_result;
        if (r106 == null) goto L13;
        Boolean r107 = r106.has_more;
    L14:
        r102.append(r107);
        r102.append(",lastToken=");
        if (r101 == null) goto L19;
        PageResult r108 = r101.page_result;
        if (r108 == null) goto L19;
        r103 = r108.last_token;
    L19:
        r102.append(r103);
        return r102.toString();
    L13:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return GetPagingTaskContainerRelatedDataResponse.ADAPTER.decode(r100);
    }
}
