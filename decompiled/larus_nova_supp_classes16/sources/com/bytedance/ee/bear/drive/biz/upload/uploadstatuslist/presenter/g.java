package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.util.io.FileUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends s65.a {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // s65.a
    public final void onFileProgressChange(int r18, ProgressingEntity r19) {
        int r1 = h.a(r19.f);
        z65.a.C0332a r2 = new z65.a.C0332a();
        r2.a = r1;
        r2.b = r19.b;
        r2.e = r19.e;
        r2.c = r19.c;
        r2.d = r19.d;
        z65.a r3 = new z65.a(r2);
        h r4 = this.a;
        r4.getClass();
        if (r19.f != 4) goto L8;
        if (TextUtils.isEmpty(r19.b) == true) goto L8;
        z65.b r5 = new z65.b(r19.a, r19.c, r19.d, r19.f, FileUtils.u(r19.g), r19.b, "");
        w r7 = r4.b;
        r7.getClass();
        r7.sendMessage(Message.obtain(r7, 10007, r5));
    L8:
        if (r1 != 4) goto L13;
        tt5.a.h("UpdateListTAG", "name + " + du5.b.g(r19.a) + " status " + r1 + " progress " + r19.e);
        if (System.currentTimeMillis() <= r4.i) goto L12;
        tt5.a.h("UpdateListTAG", "reset delay time");
        r4.f = 1500;
    L12:
        w r0 = r4.b;
        int r6 = r4.f;
        r0.getClass();
        r0.sendMessageDelayed(Message.obtain(r0, 10001, r3), r6);
        r4.f += UploadResult.UPLOAD_CACELL;
        r4.i = (System.currentTimeMillis() + ((long) r4.f)) + 500;
        return;
    L13:
        long r11 = System.currentTimeMillis();
        r4.h = r11;
        if (r1 != 1) goto L16;
    L19:
        tt5.a.h("UpdateListTAG", "name + " + du5.b.g(r19.a) + " status " + r1 + " progress " + r19.e);
        w r8 = r4.b;
        r8.getClass();
        r8.sendMessageDelayed(Message.obtain(r8, 10001, r3), (long) 0);
        r4.g = r4.h;
        return;
    L16:
        if ((r11 - r4.g) >= 400) goto L19;
        if (r19.e == 0) goto L19;
    }

    public final void onUploadErrorCode(String r4, int r5, long r6) {
        tt5.a.h("UpdateListTAG", "onUploadErrorCode, fileId: " + du5.b.g(r4) + ", errorCode: " + r5 + ", bytesTotal: " + r6);
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).g(r5) == false) goto L5;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).f(((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity(), SingleFileQuotaConfig.UPLOAD, Long.valueOf(r6));
    L5:
        z65.a.C0332a r7 = new z65.a.C0332a();
        r7.b = r4;
        r7.f = String.valueOf(r5);
        z65.a r8 = new z65.a(r7);
        w r9 = this.a.b;
        r9.getClass();
        r9.sendMessageDelayed(Message.obtain(r9, 10001, r8), 0);
    }
}
