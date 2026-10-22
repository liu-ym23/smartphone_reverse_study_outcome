package com.bytedance.ee.bear.document.offline.file.upload;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import java.util.List;
import k25.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements i.a {
    public final String a;
    public final j25.q b;
    public final FileUploadModel c;
    public final List<String> d;
    public final tb5.m e;

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i.a
    public final void a(String r6) {
        tt5.a.h("FileUploadCallbackImpl", "onUploadStart, save uploadKey");
        j25.q r1 = this.b;
        if (r1.i != null) goto L13;
        r1.i = r6;
        if (TextUtils.equals(this.a, r1.b) == false) goto L8;
    L11:
        e0.m().G(this.b);
        goto L13
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.folder_block_enable") == false) goto L11;
        e0 r2 = e0.m();
        r2.f(this.a, this.b.a);
        r2.u(this.b);
    L13:
        if ((!this.c.getContentType().contains("image")) == false) goto L25;
        List<String> r3 = this.d;
        if (r3 != null) goto L17;
        return;
    L17:
        if (r3.contains(r6) == false) goto L19;
        return;
    L19:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.folder_block_enable") == true) goto L21;
    L23:
        this.d.add(r6);
        return;
    L21:
        if (Boolean.TRUE.equals(this.c.getExitStillUpload()) == false) goto L23;
        tt5.a.h("FileUploadCallbackImpl", "current upload exist still upload, key= " + du5.b.f(r6));
        return;
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i.a
    public final void b(String r4, Float r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        UploadProgressModel r6 = new UploadProgressModel(r5.floatValue(), this.c.getUuids()[0]);
        if (this.e == null) goto L13;
        FileUploadModel r0 = this.c;
        if (r0 == null) goto L13;
        if (r0.getProgress() == null) goto L13;
        if (this.c.getProgress().booleanValue() == false) goto L13;
        JSONObject r1 = new JSONObject();
        r1.put("uuid", this.c.getUuids()[0]);
        r1.put("progress", r5);
        this.e.b(r1);
    L13:
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).a(mu5.b.e(r6));
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i.a
    public final void c(String r3, UploadCallback.b r4, UploadCallback.a r5) {
        if ((!this.c.getContentType().contains("image")) == false) goto L8;
        List<String> r0 = this.d;
        if (r0 == null) goto L8;
        r0.remove(r3);
    L8:
        if (r4.a != DriveFile.Status.SUCCESS) goto L21;
        FileUploadModel r6 = this.c;
        if (r6 != null) goto L12;
    L14:
        String r7 = "44";
    L15:
        j25.q r8 = this.b;
        if (r8 == null) goto L18;
        String r9 = r8.a();
    L19:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).j0(qw4.b.b(qw4.b.a(r5, r7, r9)));
        return;
    L18:
        r9 = null;
        goto L19
    L12:
        if (r6.isFolderBlockScene() == false) goto L14;
        r7 = "56";
        goto L15
    }

    public h(String r1, j25.q r2, FileUploadModel r3, List<String> r4, tb5.m r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
