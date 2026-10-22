package com.bytedance.ee.bear.document.folder.selection;

import ay4.d;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.h;
import io.reactivex.Flowable;
import j25.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends za5.b {
    public final /* synthetic */ SelectFileBlockMediaPlugin a;
    public final /* synthetic */ SelectFileBlockMediaPlugin.b b;

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v14 */
    @Override // za5.b, za5.a
    public final void c(List<? extends FileBean> r18) {
        Intrinsics.checkNotNullParameter(r18, "fileList");
        Intrinsics.checkNotNullParameter(r18, "fileList");
        ?? r3 = 0;
        if (j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(SelectFileBlockMediaPlugin.access$getContext(this.a), SelectFileBlockMediaPlugin.access$getString(this.a, 2131888423), 0);
        return;
    L6:
        SelectFileBlockMediaPlugin.b r2 = this.b;
        if (r2.a != null) goto L10;
        tt5.a.k("SelectFileBlockMediaPlugin", "callback is null.");
        return;
    L10:
        if (hu5.a.d(r18) == false) goto L12;
        tt5.a.d("SelectFileBlockMediaPlugin", "handleResult, fileList is empty");
        return;
    L12:
        HashMap r4 = new HashMap();
        JSONArray r6 = new JSONArray();
        Iterator<? extends FileBean> r1 = r18.iterator();     // Catch: Exception -> L25
    L14:
        if (r1.hasNext() == false) goto L24;
        FileBean r7 = r1.next();     // Catch: Exception -> L25
        String r8 = UUID.randomUUID().toString();     // Catch: Exception -> L25
        String r9 = r7.getPath();     // Catch: Exception -> L25
        String r10 = FileUtils.x(r3, r9);     // Catch: Exception -> L25
        String r11 = FileUtils.s(r10);     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L25
        String r12 = "docsource://com.bytedance.net/file/f/" + r8 + '.' + r11;     // Catch: Exception -> L25
        int r13 = r7.getWidth();     // Catch: Exception -> L25
        int r14 = r7.getHeight();     // Catch: Exception -> L25
        if (r13 <= 0) goto L20;
        if (r14 <= 0) goto L20;
    L22:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L25
        r16.put("contentType", r7.getMimeType());     // Catch: Exception -> L25
        r16.put("uuid", r8);     // Catch: Exception -> L25
        r16.put("src", r12);     // Catch: Exception -> L25
        r16.put("width", Integer.valueOf(r13));     // Catch: Exception -> L25
        r16.put("height", Integer.valueOf(r14));     // Catch: Exception -> L25
        r16.put("duration", Long.valueOf(r7.getDuration()));     // Catch: Exception -> L25
        r16.put("fileSize", Long.valueOf(r7.getSize()));     // Catch: Exception -> L25
        r16.put("fileName", r10);     // Catch: Exception -> L25
        r6.add(r16);     // Catch: Exception -> L25
        r4.put(r12, r9);     // Catch: Exception -> L25
        r3 = 0;
    L20:
        if (r7.isVideo() == false) goto L22;
        h r17 = d.a();     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L25
        int[] r19 = g5.a(r17.z(r9));     // Catch: Exception -> L25
        int r110 = r19[r3];     // Catch: Exception -> L25
        r14 = r19[1];     // Catch: Exception -> L25
        r13 = r110;
        goto L22
    L24:
        SelectFileBlockMediaPlugin r5 = r2.b;
        Flowable r20 = t.a(SelectFileBlockMediaPlugin.access$getDocViewModel(r5).getUrl(), r4, false, null).observeOn(fo5.d.d());
        SelectFileBlockMediaPlugin r21 = r2.b;
        SelectFileBlockMediaPlugin.access$setDisposable$p(r5, r20.subscribe(new b(r21, r6), new c(r21)));
        return;
    L25:
        tt5.a.d("SelectFileBlockMediaPlugin", "get file message error");
    }

    public a(SelectFileBlockMediaPlugin r1, SelectFileBlockMediaPlugin.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
