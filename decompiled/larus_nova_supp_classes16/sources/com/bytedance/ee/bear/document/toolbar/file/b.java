package com.bytedance.ee.bear.document.toolbar.file;

import android.util.Pair;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.bytedance.ee.bear.h;
import com.bytedance.ee.util.io.FileUtils;
import fo5.d;
import j25.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends za5.b {
    public final /* synthetic */ SelectFilePlugin.a a;

    public b(SelectFilePlugin.a r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r12, boolean r13) {
        final SelectFilePlugin.a r0 = this.a;
        if (SelectFilePlugin.access$300(r0.b).a != null) goto L6;
        tt5.a.k("SelectFilePlugin", "callback is null.");
        return;
    L6:
        if (hu5.a.d(r12) == false) goto L8;
        tt5.a.d("SelectFilePlugin", "handleResult, filePointerList is empty");
        return;
    L8:
        HashMap r1 = new HashMap();
        final JSONArray r3 = new JSONArray();
        Iterator r14 = ((ArrayList) r12).iterator();     // Catch: Exception -> L20
    L10:
        if (r14.hasNext() == false) goto L19;
        String r4 = (String) r14.next();     // Catch: Exception -> L20
        long r5 = FileUtils.z(r13, r4);     // Catch: Exception -> L20
        String r7 = UUID.randomUUID().toString();     // Catch: Exception -> L20
        String r8 = SelectFilePlugin.access$400(r0.b, r7, FileUtils.s(FileUtils.x(r13, r4)));     // Catch: Exception -> L20
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L20
        r9.put("uuid", r7);     // Catch: Exception -> L20
        r9.put("src", r8);     // Catch: Exception -> L20
        r9.put("fileSize", Long.valueOf(r5));     // Catch: Exception -> L20
        r9.put("fileName", FileUtils.x(r13, r4));     // Catch: Exception -> L20
        if (((h) org.koin.java.a.a(h.class)).z(FileUtils.s(FileUtils.x(r13, r4))) == false) goto L16;
        Pair r6 = nl5.a.b(r4);     // Catch: Exception -> L20
        r9.put("height", r6.first);     // Catch: Exception -> L20
        r9.put("width", r6.second);     // Catch: Exception -> L20
        r9.put("contentType", VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE);     // Catch: Exception -> L20
    L17:
        r3.add(r9);     // Catch: Exception -> L20
        r1.put(r8, r4);     // Catch: Exception -> L20
        goto L10
    L16:
        r9.put("contentType", "file");     // Catch: Exception -> L20
        goto L17
    L19:
        SelectFilePlugin r16 = r0.b;
        SelectFilePlugin.access$502(r16, t.a(SelectFilePlugin.access$600(r16).getUrl(), r1, r13, null).observeOn(d.d()).subscribe(new h45.a(r0, r3), new h45.b(r0)));
        return;
    L20:
        tt5.a.d("SelectFilePlugin", "get file message error");
    }
}
