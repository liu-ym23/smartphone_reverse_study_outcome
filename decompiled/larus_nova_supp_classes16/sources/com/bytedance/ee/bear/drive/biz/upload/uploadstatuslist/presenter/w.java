package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w extends Handler {
    public final h a;
    public final a75.g b;
    public final z65.d c;
    public final List<z65.b> d;
    public final List<z65.b> e;
    public final CompositeDisposable f;
    public final int g;

    public final void b(String r4) {
        final h r0 = this.a;
        r0.getClass();
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().h(r4, new RustUploadStatusMonitor$1(r0));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r6) {
        int r1 = 0;
        switch(r6.what) {
            case 10000: goto L16;
            case 10001: goto L15;
            case 10002: goto L14;
            case 10003: goto L13;
            case 10004: goto L12;
            case 10005: goto L7;
            case 10006: goto L6;
            case 10007: goto L5;
            default: goto L26;
        };
    L5:
        final z65.b r7 = (z65.b) r6.obj;
        tt5.a.h("UpdateListTAG", "upload data append key= " + r7.g);
        this.f.add(Flowable.just("").filter(new p(r7)).observeOn(fo5.d.d()).subscribe(new q(this, r7), new r()));
        return;
    L6:
        z65.a r8 = (z65.a) r6.obj;
        h r0 = this.a;
        String r9 = r8.b;
        r0.getClass();
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(new String[]{r9});
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().z(r9);
        return;
    L7:
        h r10 = this.a;
        List<z65.b> r2 = this.e;
        r10.getClass();
        ArrayList r11 = new ArrayList(r2);
        ((ArrayList) r2).clear();
        String[] r3 = new String[r11.size()];
    L9:
        if (r1 >= r11.size()) goto L11;
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().z(((z65.b) ListProtector.get(r11, r1)).g);
        r3[r1] = ((z65.b) ListProtector.get(r11, r1)).g;
        r1 = r1 + 1;
        goto L9
    L11:
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(r3);
        return;
    L12:
        tt5.a.h("UpdateListTAG", "delete specified key: " + ((z65.a) r6.obj).b);
        this.f.add(Flowable.just((z65.a) r6.obj).observeOn(fo5.d.d()).subscribe(new v(this), new k()));
        return;
    L13:
        tt5.a.h("UpdateListTAG", "cancel all upload");
        this.f.add(Flowable.just(this.d).observeOn(fo5.d.d()).subscribe(new u(this), new o()));
        return;
    L14:
        tt5.a.h("UpdateListTAG", "upload complete then delete " + ((z65.a) r6.obj).b + " status :" + ((z65.a) r6.obj).a);
        this.f.add(Flowable.just((z65.a) r6.obj).observeOn(fo5.d.d()).subscribe(new t(this), new j()));
        return;
    L15:
        tt5.a.h("UpdateListTAG", "update " + ((z65.a) r6.obj).b + " status :" + ((z65.a) r6.obj).a);
        z65.a r12 = (z65.a) r6.obj;
        this.f.add(Flowable.just(r12).observeOn(fo5.d.d()).subscribe(new s(this, r12), new i()));
        return;
    L16:
        tt5.a.h("UpdateListTAG", "init ui data");
        this.f.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new l(this)).observeOn(fo5.d.d()).subscribe(new m(this), new n()));
        return;
    }

    public static void a(w r4, List r5) {
        String r6 = r4.b.QD();
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L10;
        z65.b r2 = (z65.b) ListProtector.get(r5, r1);
        if (TextUtils.equals(r6, r2.g) == false) goto L8;
        r2.j = true;
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r2.j = false;
        goto L9
    }

    public w(Looper r2, a75.g r3, String r4, String r5) {
        super(r2);
        this.e = new ArrayList();
        this.f = new CompositeDisposable();
        this.g = UploadResult.UPLOAD_CACELL;
        this.b = r3;
        z65.d r6 = new z65.d();
        this.c = r6;
        this.a = new h(this, r4, r5, o75.b.a().Ke());
        this.d = r6.a;
    }
}
