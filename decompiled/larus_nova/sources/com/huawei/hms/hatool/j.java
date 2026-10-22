package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* JADX INFO: loaded from: classes23.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f277365b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277366a;

    public static class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f277367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f277368b;

        public a(String r100, String r101) {
            this.f277367a = r100;
            this.f277368b = r101;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f277367a, this.f277368b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String r100) {
            return SHA.sha256Encrypt(r100);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f277367a, this.f277368b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f277367a, this.f277368b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            int r100 = 0;
            if (z.k(this.f277367a, this.f277368b) == false) goto L5;
            int r101 = 4;
        L6:
            int r102 = r101 | 0;
            if (z.e(this.f277367a, this.f277368b) == false) goto L10;
            r100 = 2;
        L10:
            return (r102 | r100) | (z.h(this.f277367a, this.f277368b) ? 1 : 0);
        L5:
            r101 = 0;
            goto L6
        }
    }

    public j() {
    }

    public static j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277365b != null) goto L7;
        f277365b = new j();     // Catch: Throwable -> L10
    L7:
        j r100 = f277365b;     // Catch: Throwable -> L10
        monitor-exit(j.class);     // Catch: Throwable -> L10
        return r100;
    }

    public String a(String r100, String r101) {
        return i0.a(this.f277366a, r100, r101);
    }

    public String a(boolean r100) {
        if (r100 == true) goto L5;
        return "";
    L5:
        String r101 = q0.e();
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = d.a(this.f277366a, "global_v2", ST.UUID_DEVICE, "");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = UUID.randomUUID().toString().replace("-", "");
        d.b(this.f277366a, "global_v2", ST.UUID_DEVICE, r101);
    L10:
        q0.h(r101);
    L11:
        return r101;
    }

    public void a(Context r100) {
        if (this.f277366a != null) goto L6;
        this.f277366a = r100;
        return;
    }

    public String b(String r100, String r101) {
        return i0.b(this.f277366a, r100, r101);
    }

    public i c(String r100, String r101) {
        return new a(r100, r101).a(this.f277366a);
    }

    public String d(String r100, String r101) {
        return f1.b(r100, r101);
    }

    public Pair<String, String> e(String r100, String r101) {
        if (z.f(r100, r101) == false) goto L14;
        String r102 = s.c().b().p();
        String r103 = s.c().b().q();
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L11:
        Pair<String, String> r104 = x0.e(this.f277366a);
        s.c().b().k((String) r104.first);
        s.c().b().l((String) r104.second);
        return r104;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L11;
        return new Pair(r102, r103);
    L14:
        return new Pair("", "");
    }

    public String f(String r100, String r101) {
        return f1.a(r100, r101);
    }
}
