package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetOwnedContainerTaskRefAndSectionsResponse;
import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements RustLog.a<GetOwnedContainerTaskRefAndSectionsResponse> {
    public w() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetOwnedContainerTaskRefAndSectionsResponse r100) {
        GetOwnedContainerTaskRefAndSectionsResponse r101 = r100;
        StringBuilder r102 = new StringBuilder("ref = {GetOwnedContainerTaskRefAndSections: section_guid=");
        Integer r103 = null;
        if (r101 == null) goto L7;
        TaskContainerRef r104 = r101.ref;
        if (r104 == null) goto L7;
        String r105 = r104.section_guid;
    L8:
        r102.append(r105);
        r102.append(", task_guid=");
        if (r101 == null) goto L13;
        TaskContainerRef r106 = r101.ref;
        if (r106 == null) goto L13;
        String r107 = r106.task_guid;
    L14:
        r102.append(r107);
        r102.append(", container_guid=");
        if (r101 == null) goto L19;
        TaskContainerRef r108 = r101.ref;
        if (r108 == null) goto L19;
        String r109 = r108.container_guid;
    L20:
        r102.append(r109);
        r102.append(", rank=");
        if (r101 == null) goto L25;
        TaskContainerRef r110 = r101.ref;
        if (r110 == null) goto L25;
        String r111 = r110.rank;
    L26:
        r102.append(r111);
        r102.append("}, sectionsSize=");
        if (r101 == null) goto L31;
        List<TaskSection> r112 = r101.sections;
        if (r112 == null) goto L31;
        r103 = Integer.valueOf(r112.size());
    L31:
        r102.append(r103);
        return r102.toString();
    L25:
        r111 = null;
    L19:
        r109 = null;
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
        return GetOwnedContainerTaskRefAndSectionsResponse.ADAPTER.decode(r100);
    }
}
