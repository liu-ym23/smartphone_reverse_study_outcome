package sk4;

import android.text.TextUtils;
import java.util.Arrays;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f542406e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f542407f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f542408g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f542409h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f542410i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f542411j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f542412k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f542413l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f542415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f542417d;

    static {
        f542406e = new g("TTS_START", new byte[]{1, 1, 2});
        f542407f = new g("DATA_END", new byte[]{1, 1, 3});
        f542408g = new g("ASR_START", new byte[]{1, 1, 4});
        f542409h = new g("DISABLE", new byte[]{6, 1, 1});
        f542410i = new g("RESET", new byte[]{6, 1, 8});
        f542411j = new g("ENABLE", new byte[]{6, 1, 2});
        f542412k = new g("SPEECH_START", new byte[]{7, 1, 2});
        f542413l = new g("SPEECH_END", new byte[]{7, 1, 3});
    }

    public final int hashCode() {
        String r100 = this.f542414a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return ((((((r101 + 31) * 31) + this.f542416c) * 31) + Arrays.hashCode(this.f542417d)) * 31) + this.f542415b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VUIEvent{name='" + this.f542414a + "', sid=" + this.f542415b + ", cid=" + this.f542416c + ", payload=" + Arrays.toString(this.f542417d) + '}';
    }

    public static g a(String r100) {
        StringBuilder r101 = new StringBuilder("ASR_END: textSize=");
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.append(r102);
        j.d("VUIEvent", r101.toString());
        byte[] r103 = {5, 1, 1};
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L18;
        byte[] r104 = r100.getBytes();
        if (r104 != null) goto L14;
        r104 = new byte[0];
    L16:
        r103 = n.u(r103, n.u(new byte[]{43, (byte) r104.length}, r104));
        goto L18
    L14:
        if (r104.length <= 60) goto L16;
        byte[] r105 = new byte[60];
        System.arraycopy(r104, 0, r105, 0, 60);
        r104 = r105;
    L18:
        return new g("ASR_END", r103);
    L5:
        r102 = r100.length();
        goto L6
    }

    public static g b(String r100) {
        StringBuilder r101 = new StringBuilder("TTS_END: textSize=");
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.append(r102);
        j.d("VUIEvent", r101.toString());
        byte[] r103 = {1, 1, 1};
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L18;
        byte[] r104 = r100.getBytes();
        if (r104 != null) goto L14;
        r104 = new byte[0];
    L16:
        r103 = n.u(r103, n.u(new byte[]{43, (byte) r104.length}, r104));
        goto L18
    L14:
        if (r104.length <= 60) goto L16;
        byte[] r105 = new byte[60];
        System.arraycopy(r104, 0, r105, 0, 60);
        r104 = r105;
    L18:
        return new g("TTS_END", r103);
    L5:
        r102 = r100.length();
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (g.class != r100.getClass()) goto L21;
        g r101 = (g) r100;
        if (TextUtils.equals(this.f542414a, r101.f542414a) == true) goto L13;
    L19:
        return false;
    L13:
        if (this.f542416c != r101.f542416c) goto L19;
        if (this.f542415b != r101.f542415b) goto L19;
        if (Arrays.equals(this.f542417d, r101.f542417d) == false) goto L19;
        return true;
    }

    public g(String r100, byte[] r101) {
        this.f542414a = r100;
        this.f542415b = 2;
        this.f542416c = 5;
        this.f542417d = r101;
    }
}
