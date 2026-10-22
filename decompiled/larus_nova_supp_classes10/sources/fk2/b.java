package fk2;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.event.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;

    public final void d() {
        boolean r3 = false;
        if (this.i == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Long r5 = null;
        if (r0 == false) goto L11;
        b r1 = this;
    L12:
        if (r1 == null) goto L76;
        long r6 = SystemClock.elapsedRealtime();
        long r8 = this.e;
        if (r8 <= 0) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        this.b += r6 - r8;
    L19:
        long r10 = this.f;
        if (r10 <= 0) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L41;
        this.c += r6 - r10;
        if (r8 <= 0) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == true) goto L41;
        Long r9 = Long.valueOf(this.g);
        long r11 = r9.longValue();
        if (1 <= r11) goto L33;
    L35:
        boolean r12 = false;
    L36:
        if (r12 == true) goto L39;
        r9 = null;
    L39:
        if (r9 == null) goto L41;
        this.d += r6 - r9.longValue();
        goto L41
    L33:
        if (r6 <= r11) goto L35;
        r12 = true;
        goto L36
    L27:
        r7 = false;
    L41:
        c1 r13 = new c1();
        Long r14 = Long.valueOf(r6 - this.a);
        if (r14.longValue() < 0) goto L44;
        boolean r15 = true;
    L45:
        if (r15 == true) goto L48;
        r14 = null;
    L48:
        if (r14 == null) goto L50;
        r13.e("room_duration", r14.longValue());
    L50:
        Long r16 = Long.valueOf(this.b);
        if (r16.longValue() < 0) goto L53;
        boolean r17 = true;
    L54:
        if (r17 == true) goto L57;
        r16 = null;
    L57:
        if (r16 == null) goto L59;
        r13.e("list_show_duration", r16.longValue());
    L59:
        Long r18 = Long.valueOf(this.c);
        if (r18.longValue() < 0) goto L62;
        boolean r19 = true;
    L63:
        if (r19 == true) goto L66;
        r18 = null;
    L66:
        if (r18 == null) goto L68;
        r13.e("card_show_duration", r18.longValue());
    L68:
        Long r20 = Long.valueOf(this.d);
        if (r20.longValue() < 0) goto L71;
        r3 = true;
    L71:
        if (r3 == false) goto L73;
        r5 = r20;
    L73:
        if (r5 == null) goto L75;
        r13.e("card_show_duration_without_list", r5.longValue());
    L75:
        r13.k();
        goto L76
    L62:
        r19 = false;
        goto L63
    L53:
        r17 = false;
        goto L54
    L44:
        r15 = false;
        goto L45
    L22:
        r4 = false;
        goto L23
    L16:
        r2 = false;
    L76:
        this.i = true;
        return;
    L11:
        r1 = null;
        goto L12
    L5:
        if (this.a <= 0) goto L7;
        r0 = true;
        goto L8
    }

    public b() {
        this.a = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
    }

    public final void a() {
        long r0 = SystemClock.elapsedRealtime();
        Long r2 = Long.valueOf(this.f);
        if (r2.longValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L19;
        long r4 = r0 - r2.longValue();
        this.c += r4;
        if (this.h == true) goto L13;
        this.d += r4;
        goto L19
    L13:
        long r5 = this.g;
        if (1 > r5) goto L19;
        if (r0 <= r5) goto L19;
        this.d += r0 - r5;
    L19:
        this.f = -1;
        this.g = -1;
        this.h = false;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void b() {
        long r0 = SystemClock.elapsedRealtime();
        boolean r4 = true;
        if (this.f <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        this.g = r0;
    L8:
        Long r1 = Long.valueOf(this.e);
        if (r1.longValue() > 0) goto L12;
        r4 = false;
    L12:
        if (r4 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L17;
        this.b += SystemClock.elapsedRealtime() - r1.longValue();
    L17:
        this.e = -1;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void c() {
        long r0 = SystemClock.elapsedRealtime();
        this.e = r0;
        boolean r4 = true;
        if (this.f <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        this.h = true;
        Long r3 = Long.valueOf(this.g);
        if (r3.longValue() > 0) goto L11;
        r4 = false;
    L11:
        if (r4 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L18;
        this.d += r0 - r3.longValue();
        this.g = -1;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
