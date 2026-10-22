package ws3;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import d27.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements e {
    public PolarisFileWrapper a;
    public final List<String> b;
    public long c;
    public volatile long d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public volatile long h;
    public volatile long i;
    public volatile long j;
    public volatile long k;

    public final void d(boolean r1) {
    }

    public final void init() {
        this.a = new PolarisFileWrapper("/proc/net/xt_qtaguid/stats");
    }

    public final void m() {
        h this = this;
        if ((System.currentTimeMillis() - this.c) >= 1000) goto L5;
        return;
    L5:
        this.c = System.currentTimeMillis();
        int r2 = Process.myUid();
        if (this.a == null) goto L24;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L19
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(this.a), "utf-8"));     // Catch: Throwable -> L19
        int r5 = 1;
    L89:
        String r6 = r4.readLine();     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        if (r5 < 0) goto L14;
        r0.add(r6);     // Catch: Throwable -> L17
    L14:
        r5 = r5 + 1;     // Catch: Throwable -> L17
        goto L89
    L15:
        ((CopyOnWriteArrayList) this.b).clear();     // Catch: Throwable -> L17
        ((CopyOnWriteArrayList) this.b).addAll(r0);     // Catch: Throwable -> L17
    L22:
        d.a(r4);
    L17:
        th = th;
    L97:
        th.printStackTrace();     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        d.a(r4);
        throw th;
    L19:
        th = th;
        r4 = null;
    L24:
        if (k.b(this.b) == false) goto L26;
        return;
    L26:
        Iterator r1 = ((CopyOnWriteArrayList) this.b).iterator();
        long r7 = 0;
        long r8 = 0;
        long r9 = 0;
        long r10 = 0;
        long r12 = 0;
        long r14 = 0;
        long r18 = 0;
        long r20 = 0;
    L28:
        if (r1.hasNext() == false) goto L77;
        String r3 = (String) r1.next();
        r1 = r1;
        String[] r11 = r3.split(" ");
    L74:
        int r32 = r2;
        long r33 = r9;
        r10 = r10;
        r18 = r18;
        r20 = r20;
    L75:
        r18 = r18;
        r20 = r20;
        r9 = r33;
        r10 = r10;
    L76:
        r2 = r32;
        goto L28
    L31:
        if (TextUtils.equals(r11[3], "uid_tag_int") == true) goto L28;
        if (r2 != CastIntegerProtector.parseInt(r11[3])) goto L73;
        long r24 = CastLongProtector.parseLong(r11[5]);     // Catch: Exception -> L74
        long r26 = CastLongProtector.parseLong(r11[6]);     // Catch: Exception -> L74
        long r28 = CastLongProtector.parseLong(r11[7]);     // Catch: Exception -> L74
        long r30 = CastLongProtector.parseLong(r11[8]);     // Catch: Exception -> L74
        if (CastLongProtector.valueOf(r11[4]).longValue() != 1) goto L50;
        r32 = r2;
        if (r11[1].startsWith("rmnet_data") == false) goto L42;
        r10 = r10 + (r28 + r24);
        r9 = r9 + (r30 + r26);
    L95:
        if (CastLongProtector.valueOf(r11[4]).longValue() != 0) goto L69;
        long r34 = r7;
        if (r11[1].startsWith("rmnet_data") == false) goto L91;
        r14 = r14 + (r28 + r24);
        r8 = r8 + (r30 + r26);
        r7 = r34;
        goto L76
    L91:
        if (r11[1].startsWith("wlan") == false) goto L71;
        r12 = r12 + (r28 + r24);
        long r13 = r18;
        r18 = r13 + (r30 + r26);
    L72:
        r7 = r34;
    L71:
        r18 = r18;
        goto L72
    L69:
        r34 = r7;
    L70:
        r34 = r7;
        goto L71
    L42:
        r33 = r9;
        if (r11[1].startsWith("wlan") == false) goto L51;
        r7 = r7 + (r28 + r24);
        long r15 = r20;
        r20 = r15 + (r30 + r26);
    L52:
        r9 = r33;
        r10 = r10;
    L51:
        r20 = r20;
    L47:
        r33 = r9;
        goto L75
    L50:
        r32 = r2;
        r33 = r9;
        goto L51
    L73:
        r32 = r2;
        r33 = r9;
        goto L75
    L77:
        long r35 = r9;
        long r36 = r10;
        h r16 = this;
        r16.d = r12;
        r16.e = r14;
        r16.f = r7;
        r16.g = r36;
        r16.h = r18;
        r16.i = r8;
        r16.j = r20;
        r16.k = r35;
    }

    public h() {
        this.b = new CopyOnWriteArrayList();
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public final long a() {
        m();
        return this.d;
    }

    public final long b() {
        m();
        return this.e;
    }

    public final long c() {
        m();
        long r0 = this.e;
        m();
        return r0 + this.d;
    }

    public final long e() {
        m();
        long r0 = this.d;
        m();
        return r0 + this.f;
    }

    public final long f() {
        m();
        long r0 = this.g;
        m();
        return r0 + this.f;
    }

    public final long g() {
        m();
        long r0 = this.e;
        m();
        return r0 + this.g;
    }

    public final long h() {
        m();
        return this.k + this.j;
    }

    public final long i() {
        return g() + e();
    }

    public final long j() {
        m();
        return this.f;
    }

    public final long k() {
        m();
        return this.i + this.h;
    }

    public final long l() {
        m();
        return this.g;
    }
}
