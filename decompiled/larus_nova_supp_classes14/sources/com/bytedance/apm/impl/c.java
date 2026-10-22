package com.bytedance.apm.impl;

import com.bytedance.apm.util.k;
import com.bytedance.apm.util.s;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.utils.RetrofitUtils;
import ff7.g;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements g {
    public final String a;
    public final Map<String, String> b;
    public final Map<String, TypedOutput> c;

    public final ff7.b finish() throws IOException {
        String r0 = this.a;
        Map<String, TypedOutput> r1 = this.c;
        Map<String, String> r2 = this.b;
        RetrofitMonitorService r3 = (RetrofitMonitorService) RetrofitUtils.createSsService(r0, RetrofitMonitorService.class);
        HashMap r4 = new HashMap();
        SsResponse r5 = r3.uploadFiles(r0, r1, DefaultTTNetImpl.convertHeaderMap(r2)).execute();     // Catch: Throwable -> L11
        byte[] r6 = DefaultTTNetImpl.toByteArray(((TypedInput) r5.body()).in());     // Catch: Throwable -> L11
        List r7 = r5.headers();     // Catch: Throwable -> L11
        if (k.b(r7) == true) goto L9;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L11
    L7:
        if (r8.hasNext() == false) goto L9;
        Header r9 = (Header) r8.next();     // Catch: Throwable -> L11
        r4.put(r9.getName(), r9.getValue());     // Catch: Throwable -> L11
    L9:
        int r10 = r5.code();     // Catch: Throwable -> L11
    L19:
        return new ff7.b(r10, r4, r6);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r11 = new JSONObject();
        r11.put("message", th.getMessage());     // Catch: Exception -> L15
        r11.put("exception", th.getMessage() + s.a(th, 30));     // Catch: Exception -> L15
        r11.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r6 = r11.toString().getBytes();
        r10 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public c(String r2, Map r3) {
        this.c = new HashMap();
        this.a = r2;
        this.b = r3;
    }

    public final void a(String r3, String r4) {
        Map<String, TypedOutput> r0 = this.c;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, new TypedString(r4));
    }

    public final void c(String r3, Map r4) throws IOException {
        Map<String, TypedOutput> r0 = this.c;
        HashMap r1 = (HashMap) r0;
        r1.put("params.txt", new a(r3, r4));
    }

    public final void b(String r4, File r5, String r6, Map<String, String> r7) throws IOException {
        Map<String, TypedOutput> r8 = this.c;
        HashMap r9 = (HashMap) r8;
        r9.put(r4, new b(r7, new TypedFile(null, r5)));
    }
}
