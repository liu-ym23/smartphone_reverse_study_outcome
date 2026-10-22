package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ay implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ay f464284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f1076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f1077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f1078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f1080a;

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f464286a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f1081a;

        public abstract void a(ay r100);

        @Override // java.lang.Runnable
        public void run() {
            com_xiaomi_push_service_ay$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_xiaomi_push_service_ay$a__run$___twin___() {
            if (ay.a() == null) goto L13;
            Context r100 = ay.a().f1077a;
            if (com.xiaomi.push.at.c(r100) == true) goto L8;
            return;
        L8:
            if ((System.currentTimeMillis() - ay.a(ay.a()).getLong(":ts-" + this.f1081a, 0)) <= this.f464286a) goto L10;
        L11:
            com.xiaomi.push.o.a(ay.a(ay.a()).edit().putLong(":ts-" + this.f1081a, System.currentTimeMillis()));
            a(ay.a());
            return;
        L10:
            if (com.xiaomi.push.aa.a(r100) == true) goto L11;
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_service_ay$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_xiaomi_push_service_ay$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, long r101) {
            this.f1081a = r100;
            this.f464286a = r101;
        }
    }

    @Override // com.xiaomi.push.service.aa
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9380a() {
        if (this.f1080a == false) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f1076a) >= 3600000) goto L8;
        return;
    L8:
        this.f1076a = r100;
        this.f1080a = true;
        int r101 = (int) (Math.random() * 10.0d);
        com.xiaomi.push.ad.a(this.f1077a).a(new AnonymousClass1(this), r101);
    }

    public static /* synthetic */ ay a() {
        return f464284a;
    }

    private ay(Context r100) {
        this.f1080a = false;
        this.f1079a = new ConcurrentHashMap();
        this.f1077a = r100.getApplicationContext();
        this.f1078a = r100.getSharedPreferences(DocumentType.DOCX_SYNC_BLOCK_NAME, 0);
    }

    public void a(a r100) {
        if (this.f1079a.putIfAbsent(r100.f1081a, r100) != null) goto L6;
        int r101 = ((int) (Math.random() * 30.0d)) + 10;
        com.xiaomi.push.ad.a(this.f1077a).a(r100, r101);
        return;
    }

    public static ay a(Context r100) {
        if (f464284a != null) goto L15;
        monitor-enter(ay.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464284a != null) goto L9;
        f464284a = new ay(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ay.class);     // Catch: Throwable -> L11
    L15:
        return f464284a;
    }

    public static /* synthetic */ SharedPreferences a(ay r100) {
        return r100.f1078a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ ConcurrentHashMap m9379a(ay r100) {
        return r100.f1079a;
    }

    public String a(String r100, String r101) {
        return this.f1078a.getString(r100 + ":" + r101, "");
    }

    public static /* synthetic */ boolean a(ay r100, boolean r101) {
        r100.f1080a = r101;
        return r101;
    }

    public void a(String r100, String r101, String r102) {
        com.xiaomi.push.o.a(f464284a.f1078a.edit().putString(r100 + ":" + r101, r102));
    }
}
