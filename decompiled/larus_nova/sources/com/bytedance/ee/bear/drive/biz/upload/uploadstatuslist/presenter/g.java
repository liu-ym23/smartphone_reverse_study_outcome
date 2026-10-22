package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.util.io.FileUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends s65.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f223892a;

    public g(h r100) {
        this.f223892a = r100;
    }

    @Override // s65.a, rf5.e
    public final void onFileProgressChange(int r110, ProgressingEntity r111) {
        int r100 = h.a(r111.f232473f);
        z65.a.C8425a r101 = new z65.a.C8425a();
        r101.f570488a = r100;
        r101.f570489b = r111.f232469b;
        r101.f570492e = r111.f232472e;
        r101.f570490c = r111.f232470c;
        r101.f570491d = r111.f232471d;
        z65.a r102 = new z65.a(r101);
        h r103 = this.f223892a;
        r103.getClass();
        if (r111.f232473f != 4) goto L8;
        if (TextUtils.isEmpty(r111.f232469b) == true) goto L8;
        z65.b r104 = new z65.b(r111.f232468a, r111.f232470c, r111.f232471d, r111.f232473f, FileUtils.u(r111.f232474g), r111.f232469b, "");
        w r105 = r103.f223894b;
        r105.getClass();
        r105.sendMessage(Message.obtain(r105, 10007, r104));
    L8:
        if (r100 != 4) goto L13;
        tt5.a.h("UpdateListTAG", "name + " + du5.b.g(r111.f232468a) + " status " + r100 + " progress " + r111.f232472e);
        if (System.currentTimeMillis() <= r103.f223901i) goto L12;
        tt5.a.h("UpdateListTAG", "reset delay time");
        r103.f223898f = 1500;
    L12:
        w r106 = r103.f223894b;
        int r107 = r103.f223898f;
        r106.getClass();
        r106.sendMessageDelayed(Message.obtain(r106, 10001, r102), r107);
        r103.f223898f += 1000;
        r103.f223901i = (System.currentTimeMillis() + ((long) r103.f223898f)) + 500;
        return;
    L13:
        long r112 = System.currentTimeMillis();
        r103.f223900h = r112;
        if (r100 != 1) goto L16;
    L19:
        tt5.a.h("UpdateListTAG", "name + " + du5.b.g(r111.f232468a) + " status " + r100 + " progress " + r111.f232472e);
        w r108 = r103.f223894b;
        r108.getClass();
        r108.sendMessageDelayed(Message.obtain(r108, 10001, r102), (long) 0);
        r103.f223899g = r103.f223900h;
        return;
    L16:
        if ((r112 - r103.f223899g) >= 400) goto L19;
        if (r111.f232472e == 0) goto L19;
    }

    @Override // rf5.e
    public final void onUploadErrorCode(String r100, int r101, long r102) {
        tt5.a.h("UpdateListTAG", "onUploadErrorCode, fileId: " + du5.b.g(r100) + ", errorCode: " + r101 + ", bytesTotal: " + r102);
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).g(r101) == false) goto L5;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).f(((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity(), SingleFileQuotaConfig.UPLOAD, Long.valueOf(r102));
    L5:
        z65.a.C8425a r103 = new z65.a.C8425a();
        r103.f570489b = r100;
        r103.f570493f = String.valueOf(r101);
        z65.a r104 = new z65.a(r103);
        w r105 = this.f223892a.f223894b;
        r105.getClass();
        r105.sendMessageDelayed(Message.obtain(r105, 10001, r104), 0);
    }
}
