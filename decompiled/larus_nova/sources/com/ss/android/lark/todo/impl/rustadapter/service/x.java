package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetSharedTodosResponse;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.todo.impl.utils.LogMessageUtilKt;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements RustLog.a<GetSharedTodosResponse> {
    public x() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetSharedTodosResponse r100) {
        GetSharedTodosResponse r101 = r100;
        if (r101 == null) goto L9;
        List<Todo> r102 = r101.todos;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if ((!r102.isEmpty()) != true) goto L9;
    L10:
        if (r103 == false) goto L17;
        List<Todo> r104 = r101.todos;
        if (r104 == null) goto L17;
        Todo r105 = (Todo) ListProtector.get(r104, 0);
        if (r105 == null) goto L17;
        String r106 = LogMessageUtilKt.a(r105);
        if (r106 == null) goto L17;
        return r106;
    L17:
        return "NULL";
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return GetSharedTodosResponse.ADAPTER.decode(r100);
    }
}
