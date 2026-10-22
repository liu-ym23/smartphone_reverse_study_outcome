package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.todo.v1.GetServerTaskRefAndSectionsResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements RustLog.a<GetServerTaskRefAndSectionsResponse> {
    public d() {
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
    public final String a(GetServerTaskRefAndSectionsResponse r100) {
        GetServerTaskRefAndSectionsResponse r101 = r100;
        StringBuilder r102 = new StringBuilder("get server task ref and sections, sections size ");
        if (r101 == null) goto L7;
        Map<String, GetServerTaskRefAndSectionsResponse.TaskSectionsAndRefsResult> r103 = r101.results;
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
        return GetServerTaskRefAndSectionsResponse.ADAPTER.decode(r100);
    }
}
