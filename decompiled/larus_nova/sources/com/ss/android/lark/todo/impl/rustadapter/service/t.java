package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.UpsertTaskSectionRequest;
import com.bytedance.lark.pb.todo.v1.UpsertTaskSectionResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444263a = 0;

    public static final class a implements RustLog.a<UpsertTaskSectionResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskSection f444264a;

        public a(TaskSection r100) {
            this.f444264a = r100;
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(UpsertTaskSectionResponse r100) {
            return "update or create task section, section_guid = " + this.f444264a.guid;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return UpsertTaskSectionResponse.ADAPTER.decode(r100);
        }
    }

    static {
    }

    public static Object a(TaskSection r100, TaskSection r101, Continuation r102) {
        UpsertTaskSectionRequest.Builder r103 = new UpsertTaskSectionRequest.Builder().old_section(r100).new_section(r101);
        int r104 = RustLog.f444237a;
        Command r105 = Command.UPSERT_TASK_SECTION;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new a(r101), "", r102);
    }
}
