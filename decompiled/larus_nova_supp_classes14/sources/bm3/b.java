package bm3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public transient int a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public long f;
    public float g;
    public double h;
    public String i;
    public byte[] j;
    public List<String> k;

    public static final class a {
        public static void a(c r2, b r3) throws IOException {
            r2.c();
            r3.k.clear();
        L3:
            int r0 = r2.e();
            if (r0 == (-1)) goto L31;
            switch(r0) {
                case 1: goto L30;
                case 2: goto L27;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L13;
                case 8: goto L11;
                case 9: goto L9;
                case 10: goto L8;
                default: goto L7;
            };
        L7:
            throw new IllegalStateException("Unexpected tag: " + r0);
        L9:
            long r1 = r2.b();
            com.bytedance.android.tools.superkv.c r4 = r2.a;
            r4.getClass();
            byte[] r5 = new byte[(int) r1];
            r4.a.get(r5);
            r3.j = r5;
            return;
        L11:
            r3.i = r2.h();
            return;
        L13:
            r3.h = Double.longBitsToDouble(r2.g());
            return;
        L15:
            r3.g = Float.intBitsToFloat(r2.f());
            return;
        L17:
            r3.f = r2.j();
            return;
        L19:
            r3.e = r2.i();
            return;
        L21:
            boolean r6 = true;
            if (r2.i() == 1) goto L25;
            r6 = false;
        L25:
            r3.d = r6;
            return;
        L27:
            int r7 = r2.i();
            r3.c = r7;
            if (r7 != 0) goto L3;
            return;
        L30:
            r3.b = r2.h();
            goto L3
        L8:
            r3.k.add(r2.h());
            goto L3
        }
    }

    public final void c() {
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0.0f;
        this.h = 0.0d;
        this.i = null;
        this.j = null;
        this.k.clear();
    }

    public final int hashCode() {
        int r0 = this.a;
        if (r0 != 0) goto L17;
        int r1 = ((this.b.hashCode() * 37) + this.c) * 37;
        if (this.d == false) goto L7;
        int r2 = 1231;
    L8:
        int r3 = (((r1 + r2) * 37) + this.e) * 37;
        long r4 = this.f;
        int r5 = ((r3 + ((int) (r4 ^ (r4 >>> 32)))) * 37) + Float.floatToIntBits(this.g);
        long r6 = Double.doubleToLongBits(this.h);
        int r7 = ((r5 * 37) + ((int) (r6 ^ (r6 >>> 32)))) * 37;
        String r8 = this.i;
        int r9 = 0;
        if (r8 == null) goto L11;
        int r10 = r8.hashCode();
    L12:
        int r11 = (r7 + r10) * 37;
        byte[] r12 = this.j;
        if (r12 == null) goto L15;
        r9 = Arrays.hashCode(r12);
    L15:
        int r13 = ((r11 + r9) * 37) + this.k.hashCode();
        this.a = r13;
        return r13;
    L11:
        r10 = 0;
        goto L12
    L7:
        r2 = 1237;
        goto L8
    L17:
        return r0;
    }

    public final String toString() {
        return "KVProto{ key=" + this.b + ", type=" + this.c + ", booleanValue=" + this.d + ", intValue=" + this.e + ", longValue=" + this.f + ", floatValue=" + this.g + ", doubleValue=" + this.h + ", stringValue=" + this.i + ", bytesValue=" + Arrays.toString(this.j) + ", stringListValue=" + this.k + " }";
    }

    public b() {
        this.a = 0;
        this.k = new ArrayList();
    }

    public static String b(Integer r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        switch(r0.intValue()) {
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            default: goto L7;
        };
    L7:
        return "UNKNOWN";
    L9:
        return "StringList";
    L11:
        return "Bytes";
    L13:
        return "String";
    L15:
        return "Double";
    L17:
        return "Float";
    L19:
        return "Long";
    L21:
        return "Integer";
    L23:
        return "Boolean";
    L25:
        return "TYPE";
    }

    public final boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof b) == true) goto L8;
        return false;
    L8:
        b r7 = (b) r6;
        if (a(this.b, r7.b) == true) goto L11;
    L29:
        return false;
    L11:
        if (a(Integer.valueOf(this.c), Integer.valueOf(r7.c)) == false) goto L29;
        if (a(Boolean.valueOf(this.d), Boolean.valueOf(r7.d)) == false) goto L29;
        if (a(Integer.valueOf(this.e), Integer.valueOf(r7.e)) == false) goto L29;
        if (a(Long.valueOf(this.f), Long.valueOf(r7.f)) == false) goto L29;
        if (a(Float.valueOf(this.g), Float.valueOf(r7.g)) == false) goto L29;
        if (a(Double.valueOf(this.h), Double.valueOf(r7.h)) == false) goto L29;
        if (a(this.i, r7.i) == false) goto L29;
        if (Arrays.equals(this.j, r7.j) == false) goto L29;
        if (this.k.equals(r7.k) == false) goto L29;
        return true;
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }
}
