package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class w extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f223912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a75.g f223913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z65.d f223914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<z65.b> f223915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<z65.b> f223916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f223917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f223918g;

    public final void b(String r100) {
        final h r101 = this.f223912a;
        r101.getClass();
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().h(r100, new RustUploadStatusMonitor$1(r101));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = 0;
        switch(r100.what) {
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
        final z65.b r102 = (z65.b) r100.obj;
        tt5.a.h("UpdateListTAG", "upload data append key= " + r102.f570500g);
        this.f223917f.add(Flowable.just("").filter(new p(r102)).observeOn(fo5.d.d()).subscribe(new q(this, r102), new r()));
        return;
    L6:
        z65.a r103 = (z65.a) r100.obj;
        h r104 = this.f223912a;
        String r105 = r103.f570483b;
        r104.getClass();
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(new String[]{r105});
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().z(r105);
        return;
    L7:
        h r106 = this.f223912a;
        List<z65.b> r107 = this.f223916e;
        r106.getClass();
        ArrayList r108 = new ArrayList(r107);
        ((ArrayList) r107).clear();
        String[] r109 = new String[r108.size()];
    L9:
        if (r101 >= r108.size()) goto L11;
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().z(((z65.b) ListProtector.get(r108, r101)).f570500g);
        r109[r101] = ((z65.b) ListProtector.get(r108, r101)).f570500g;
        r101 = r101 + 1;
        goto L9
    L11:
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(r109);
        return;
    L12:
        tt5.a.h("UpdateListTAG", "delete specified key: " + ((z65.a) r100.obj).f570483b);
        this.f223917f.add(Flowable.just((z65.a) r100.obj).observeOn(fo5.d.d()).subscribe(new v(this), new k()));
        return;
    L13:
        tt5.a.h("UpdateListTAG", "cancel all upload");
        this.f223917f.add(Flowable.just(this.f223915d).observeOn(fo5.d.d()).subscribe(new u(this), new o()));
        return;
    L14:
        tt5.a.h("UpdateListTAG", "upload complete then delete " + ((z65.a) r100.obj).f570483b + " status :" + ((z65.a) r100.obj).f570482a);
        this.f223917f.add(Flowable.just((z65.a) r100.obj).observeOn(fo5.d.d()).subscribe(new t(this), new j()));
        return;
    L15:
        tt5.a.h("UpdateListTAG", "update " + ((z65.a) r100.obj).f570483b + " status :" + ((z65.a) r100.obj).f570482a);
        z65.a r110 = (z65.a) r100.obj;
        this.f223917f.add(Flowable.just(r110).observeOn(fo5.d.d()).subscribe(new s(this, r110), new i()));
        return;
    L16:
        tt5.a.h("UpdateListTAG", "init ui data");
        this.f223917f.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new l(this)).observeOn(fo5.d.d()).subscribe(new m(this), new n()));
        return;
    }

    public static void a(w r100, List r101) {
        String r102 = r100.f223913b.QD();
        int r103 = 0;
    L4:
        if (r103 >= r101.size()) goto L10;
        z65.b r104 = (z65.b) ListProtector.get(r101, r103);
        if (TextUtils.equals(r102, r104.f570500g) == false) goto L8;
        r104.f570503j = true;
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        r104.f570503j = false;
        goto L9
    }

    public w(Looper r100, a75.g r101, String r102, String r103) {
        super(r100);
        this.f223916e = new ArrayList();
        this.f223917f = new CompositeDisposable();
        this.f223918g = 1000;
        this.f223913b = r101;
        z65.d r104 = new z65.d();
        this.f223914c = r104;
        this.f223912a = new h(this, r102, r103, o75.b.a().Ke());
        this.f223915d = r104.f570505a;
    }
}
