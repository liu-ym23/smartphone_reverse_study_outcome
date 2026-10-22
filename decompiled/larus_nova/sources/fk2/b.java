package fk2;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.event.c1;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f477600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f477601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f477602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f477603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f477604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f477605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f477606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f477607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f477608i;

    public final void d() {
        boolean r100 = false;
        if (this.f477608i == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Long r102 = null;
        if (r101 == false) goto L11;
        b r103 = this;
    L12:
        if (r103 == null) goto L76;
        long r104 = SystemClock.elapsedRealtime();
        long r105 = this.f477604e;
        if (r105 <= 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        this.f477601b += r104 - r105;
    L19:
        long r110 = this.f477605f;
        if (r110 <= 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L41;
        this.f477602c += r104 - r110;
        if (r105 <= 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == true) goto L41;
        Long r109 = Long.valueOf(this.f477606g);
        long r111 = r109.longValue();
        if (1 <= r111) goto L33;
    L35:
        boolean r112 = false;
    L36:
        if (r112 == true) goto L39;
        r109 = null;
    L39:
        if (r109 == null) goto L41;
        this.f477603d += r104 - r109.longValue();
        goto L41
    L33:
        if (r104 <= r111) goto L35;
        r112 = true;
        goto L36
    L27:
        r108 = false;
    L41:
        c1 r113 = new c1();
        Long r114 = Long.valueOf(r104 - this.f477600a);
        if (r114.longValue() < 0) goto L44;
        boolean r115 = true;
    L45:
        if (r115 == true) goto L48;
        r114 = null;
    L48:
        if (r114 == null) goto L50;
        r113.e("room_duration", r114.longValue());
    L50:
        Long r116 = Long.valueOf(this.f477601b);
        if (r116.longValue() < 0) goto L53;
        boolean r117 = true;
    L54:
        if (r117 == true) goto L57;
        r116 = null;
    L57:
        if (r116 == null) goto L59;
        r113.e("list_show_duration", r116.longValue());
    L59:
        Long r118 = Long.valueOf(this.f477602c);
        if (r118.longValue() < 0) goto L62;
        boolean r119 = true;
    L63:
        if (r119 == true) goto L66;
        r118 = null;
    L66:
        if (r118 == null) goto L68;
        r113.e("card_show_duration", r118.longValue());
    L68:
        Long r120 = Long.valueOf(this.f477603d);
        if (r120.longValue() < 0) goto L71;
        r100 = true;
    L71:
        if (r100 == false) goto L73;
        r102 = r120;
    L73:
        if (r102 == null) goto L75;
        r113.e("card_show_duration_without_list", r102.longValue());
    L75:
        r113.k();
        goto L76
    L62:
        r119 = false;
        goto L63
    L53:
        r117 = false;
        goto L54
    L44:
        r115 = false;
        goto L45
    L22:
        r107 = false;
        goto L23
    L16:
        r106 = false;
    L76:
        this.f477608i = true;
        return;
    L11:
        r103 = null;
        goto L12
    L5:
        if (this.f477600a <= 0) goto L7;
        r101 = true;
        goto L8
    }

    public b() {
        this.f477600a = -1;
        this.f477604e = -1;
        this.f477605f = -1;
        this.f477606g = -1;
    }

    public final void a() {
        long r100 = SystemClock.elapsedRealtime();
        Long r101 = Long.valueOf(this.f477605f);
        if (r101.longValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L19;
        long r103 = r100 - r101.longValue();
        this.f477602c += r103;
        if (this.f477607h == true) goto L13;
        this.f477603d += r103;
        goto L19
    L13:
        long r104 = this.f477606g;
        if (1 > r104) goto L19;
        if (r100 <= r104) goto L19;
        this.f477603d += r100 - r104;
    L19:
        this.f477605f = -1;
        this.f477606g = -1;
        this.f477607h = false;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void b() {
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = true;
        if (this.f477605f <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        this.f477606g = r100;
    L8:
        Long r103 = Long.valueOf(this.f477604e);
        if (r103.longValue() > 0) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        this.f477601b += SystemClock.elapsedRealtime() - r103.longValue();
    L17:
        this.f477604e = -1;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void c() {
        long r100 = SystemClock.elapsedRealtime();
        this.f477604e = r100;
        boolean r101 = true;
        if (this.f477605f <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L17;
        this.f477607h = true;
        Long r103 = Long.valueOf(this.f477606g);
        if (r103.longValue() > 0) goto L11;
        r101 = false;
    L11:
        if (r101 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L18;
        this.f477603d += r100 - r103.longValue();
        this.f477606g = -1;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
