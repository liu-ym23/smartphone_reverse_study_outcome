package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.UpsertTaskSectionsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements RustLog.a<UpsertTaskSectionsResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<TaskSection> f444265a;

    public u(List<TaskSection> r100) {
        this.f444265a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(UpsertTaskSectionsResponse r100) {
        StringBuilder r101 = new StringBuilder("update task sections, section_guids = ");
        List<TaskSection> r102 = this.f444265a;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        TaskSection r105 = (TaskSection) r104.next();
        String r106 = r105.guid + ": " + r105.rank;
        if (r106 == null) goto L4;
        r103.add(r106);
        goto L4
    L8:
        r101.append(r103);
        return r101.toString();
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UpsertTaskSectionsResponse.ADAPTER.decode(r100);
    }
}
