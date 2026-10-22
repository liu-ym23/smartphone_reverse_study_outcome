package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetTasksResponse;
import com.bytedance.lark.pb.todo.v1.Todo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements RustLog.a<GetTasksResponse> {
    public r() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetTasksResponse r100) {
        GetTasksResponse r101 = r100;
        if (r101 != null) goto L5;
        return "getTasks = null";
    L5:
        StringBuilder r102 = new StringBuilder("get all tasks, tasks_size = ");
        r102.append(r101.tasks.size());
        r102.append(", tasks_complete_size = ");
        List<Todo> r103 = r101.tasks;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (((Todo) r106).completed_milli_time.longValue() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        r107 = false;
        goto L12
    L14:
        r102.append(r104);
        r102.append(", ");
        return r102.toString();
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return GetTasksResponse.ADAPTER.decode(r100);
    }
}
