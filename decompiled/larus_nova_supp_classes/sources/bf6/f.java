package bf6;

import com.bytedance.lego.init.model.InitPeriod;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f implements Comparable<f> {
    public final String a;
    public final String b;
    public final d c;
    public final boolean d;
    public final boolean e;
    public final List<String> f;
    public final float g;
    public final List<String> h;
    public final List<String> i;
    public final List<String> j;
    public volatile InitPeriod k;
    public volatile long l;
    public volatile boolean m;

    public final String toString() {
        return this.g + "," + this.a + "," + this.d;
    }

    public f() {
        this.g = 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(f r4) {
        f r5 = r4;
        float r0 = r5.g - this.g;
        if (r0 <= 0.0f) goto L6;
        return 1;
    L6:
        if (r0 >= 0.0f) goto L9;
        return -1;
    L9:
        return this.b.compareTo(r5.b);
    }

    public f(String r2, float r3, List r4, List r5, List r6, List r7, InitPeriod r8) {
        this.g = 0.0f;
        this.a = r2;
        this.d = true;
        this.f = r4;
        this.g = r3;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.b = "init_shceduler_internal_task";
        this.k = r8;
        this.e = false;
    }

    public f(String r2, boolean r3, boolean r4, float r5, List<String> r6, List<String> r7, List<String> r8, List<String> r9, String r10, d r11, InitPeriod r12) {
        this.g = 0.0f;
        this.a = r2;
        this.d = r3;
        this.f = r6;
        this.g = r5;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.b = r10;
        this.c = r11;
        this.k = r12;
        this.e = r4;
    }
}
