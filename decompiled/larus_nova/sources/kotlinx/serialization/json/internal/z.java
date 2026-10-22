package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class z implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f505466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f505467b;

    public final void e() {
        i r100 = i.f505416c;
        char[] r101 = this.f505466a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "array");
        Intrinsics.checkNotNullParameter(r101, "array");
        monitor-enter(r100);
        int r102 = r100.f505420b;     // Catch: Throwable -> L10
        if ((r101.length + r102) >= h.f505414a) goto L7;
        r100.f505420b = r102 + r101.length;     // Catch: Throwable -> L10
        r100.f505419a.addLast(r101);     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return new String(this.f505466a, 0, this.f505467b);
    }

    public z() {
        i r100 = i.f505416c;
        monitor-enter(r100);
        char[] r101 = r100.f505419a.removeLastOrNull();     // Catch: Throwable -> L14
        if (r101 == null) goto L8;
        r100.f505420b -= r101.length;     // Catch: Throwable -> L14
    L9:
        monitor-exit(r100);
        if (r101 != null) goto L12;
        r101 = new char[128];
    L12:
        this.f505466a = r101;
        return;
    L8:
        r101 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void a(char r100) {
        d(this.f505467b, 1);
        char[] r101 = this.f505466a;
        int r102 = this.f505467b;
        this.f505467b = r102 + 1;
        r101[r102] = r100;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = r100.length();
        if (r101 != 0) goto L5;
        return;
    L5:
        d(this.f505467b, r101);
        r100.getChars(0, r100.length(), this.f505466a, this.f505467b);
        this.f505467b += r101;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        d(this.f505467b, r110.length() + 2);
        char[] r100 = this.f505466a;
        int r101 = this.f505467b;
        int r102 = r101 + 1;
        r100[r101] = Typography.quote;
        int r103 = r110.length();
        r110.getChars(0, r103, r100, r102);
        int r104 = r103 + r102;
        int r105 = r102;
    L3:
        if (r105 >= r104) goto L25;
        char r106 = r100[r105];
        byte[] r107 = o0.f505452b;
        if (r106 >= r107.length) goto L24;
        if (r107[r106] == 0) goto L24;
        int r108 = r105 - r102;
        int r109 = r110.length();
    L10:
        if (r108 >= r109) goto L22;
        d(r105, 2);
        char r111 = r110.charAt(r108);
        byte[] r112 = o0.f505452b;
        if (r111 >= r112.length) goto L19;
        byte r113 = r112[r111];
        if (r113 != 0) goto L16;
        int r114 = r105 + 1;
        this.f505466a[r105] = r111;
    L20:
        r105 = r114;
    L21:
        r108 = r108 + 1;
        goto L10
    L16:
        if (r113 != 1) goto L18;
        String r115 = o0.f505451a[r111];
        Intrinsics.checkNotNull(r115);
        d(r105, r115.length());
        r115.getChars(0, r115.length(), this.f505466a, r105);
        r105 = r105 + r115.length();
        this.f505467b = r105;
        goto L21
    L18:
        char[] r116 = this.f505466a;
        r116[r105] = '\\';
        r116[r105 + 1] = (char) r113;
        r105 = r105 + 2;
        this.f505467b = r105;
        goto L21
    L19:
        r114 = r105 + 1;
        this.f505466a[r105] = r111;
        goto L20
    L22:
        d(r105, 1);
        this.f505466a[r105] = Typography.quote;
        this.f505467b = r105 + 1;
        return;
    L24:
        r105 = r105 + 1;
        goto L3
    L25:
        r100[r104] = Typography.quote;
        this.f505467b = r104 + 1;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void writeLong(long r100) {
        b(String.valueOf(r100));
    }

    public final void d(int r100, int r101) {
        int r102 = r101 + r100;
        char[] r103 = this.f505466a;
        if (r103.length > r102) goto L6;
        this.f505466a = Arrays.copyOf(r103, RangesKt.coerceAtLeast(r102, r100 * 2));
        return;
    }
}
