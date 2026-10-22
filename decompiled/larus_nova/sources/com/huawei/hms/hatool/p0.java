package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes23.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f277419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f277420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f277421c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f277422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f277423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f277424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p0 f277425d;

        public a(p0 r100, long r101) {
            this.f277425d = r100;
            this.f277422a = UUID.randomUUID().toString().replace("-", "");
            this.f277422a += "_" + r101;
            this.f277424c = r101;
            this.f277423b = true;
            p0.a(r100, false);
        }

        private boolean a(long r100, long r101) {
            Calendar r102 = Calendar.getInstance();
            r102.setTimeInMillis(r100);
            Calendar r103 = Calendar.getInstance();
            r103.setTimeInMillis(r101);
            if (r102.get(1) == r103.get(1)) goto L5;
            return true;
        L5:
            if (r102.get(6) != r103.get(6)) goto L10;
            return false;
        L10:
            return true;
        }

        private void b(long r100) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String r101 = UUID.randomUUID().toString();
            this.f277422a = r101;
            this.f277422a = r101.replace("-", "");
            this.f277422a += "_" + r100;
            this.f277424c = r100;
            this.f277423b = true;
        }

        private boolean b(long r100, long r101) {
            if ((r101 - r100) < p0.b(this.f277425d)) goto L5;
            return true;
        L5:
            return false;
        }

        public void a(long r100) {
            if (p0.a(this.f277425d) == false) goto L7;
            p0.a(this.f277425d, false);
            b(r100);
            return;
        L7:
            if (b(this.f277424c, r100) == false) goto L9;
        L13:
            b(r100);
            return;
        L9:
            if (a(this.f277424c, r100) == true) goto L13;
            this.f277424c = r100;
            this.f277423b = false;
        }
    }

    public p0() {
        this.f277419a = 1800000;
        this.f277420b = false;
        this.f277421c = null;
    }

    public static /* synthetic */ boolean a(p0 r100) {
        return r100.f277420b;
    }

    public static /* synthetic */ boolean a(p0 r100, boolean r101) {
        r100.f277420b = r101;
        return r101;
    }

    public static /* synthetic */ long b(p0 r100) {
        return r100.f277419a;
    }

    public String a() {
        a r100 = this.f277421c;
        if (r100 != null) goto L7;
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    L7:
        return r100.f277422a;
    }

    public void a(long r100) {
        a r101 = this.f277421c;
        if (r101 != null) goto L6;
        v.c("hmsSdk", "Session is first flush");
        this.f277421c = new a(this, r100);
        return;
    L6:
        r101.a(r100);
    }

    public boolean b() {
        a r100 = this.f277421c;
        if (r100 != null) goto L7;
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    L7:
        return r100.f277423b;
    }
}
