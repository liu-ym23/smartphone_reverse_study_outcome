package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.TaskView;
import com.bytedance.lark.pb.todo.v1.UpdateTaskViewRequest;
import com.bytedance.lark.pb.todo.v1.UpdateTaskViewResponse;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements RustLog.a<UpdateTaskViewResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskView f444266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<UpdateTaskViewRequest.UpdateField> f444267b;

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(UpdateTaskViewResponse r100) {
        return "update task view, container_guid = " + this.f444266a.container_guid + ", updateField = " + this.f444267b;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UpdateTaskViewResponse.ADAPTER.decode(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(TaskView r100, List<? extends UpdateTaskViewRequest.UpdateField> r101) {
        this.f444266a = r100;
        this.f444267b = r101;
    }
}
