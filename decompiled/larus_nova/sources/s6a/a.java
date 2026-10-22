package s6a;

import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f540861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f540862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f540863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f540864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f540865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f540866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f540867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f540868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f540869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f540870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f540871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f540872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f540873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f540874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f540875p;

    public a() {
        this.f540871l = -1;
        this.f540873n = -1;
        this.f540875p = -1;
    }

    public a(a r100) {
        this.f540871l = -1;
        this.f540873n = -1;
        this.f540875p = -1;
        this.f540860a = r100.f540860a;
        this.f540861b = r100.f540861b;
        this.f540862c = r100.f540862c;
        this.f540863d = r100.f540863d;
        this.f540864e = r100.f540864e;
        this.f540865f = r100.f540865f;
        this.f540866g = r100.f540866g;
        this.f540867h = r100.f540867h;
        this.f540868i = r100.f540868i;
        this.f540869j = r100.f540869j;
        this.f540870k = r100.f540870k;
        this.f540871l = r100.f540871l;
        this.f540872m = r100.f540872m;
        this.f540873n = r100.f540873n;
        this.f540874o = r100.f540874o;
        this.f540875p = r100.f540875p;
    }

    public static a d(ReadableArray r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.size() == 13) goto L8;
        LLog.DTHROW();
    L8:
        a r101 = new a();
        r101.f540860a = r100.getString(0);
        r101.f540861b = (long) r100.getDouble(1);
        int r102 = r101.c(r100, 2);
        int r103 = r102 + 1;
        r101.f540862c = (long) r100.getDouble(r102);
        int r104 = r103 + 1;
        r101.f540870k = r100.getInt(r103) - 1;
        int r105 = r104 + 1;
        r101.f540872m = r100.getInt(r104);
        int r106 = r105 + 1;
        r101.f540871l = r100.getInt(r105);
        r101.f540873n = r100.getInt(r106);
        return r101;
    }

    public final boolean a(a r100) {
        if (r100 != null) goto L4;
    L32:
        return false;
    L4:
        if (this.f540860a.equals(r100.f540860a) == false) goto L32;
        if (this.f540861b != r100.f540861b) goto L32;
        if (this.f540862c != r100.f540862c) goto L32;
        if (this.f540863d != r100.f540863d) goto L32;
        if (this.f540864e != r100.f540864e) goto L32;
        if (this.f540865f != r100.f540865f) goto L32;
        if (this.f540866g != r100.f540866g) goto L32;
        if (this.f540867h != r100.f540867h) goto L32;
        if (this.f540868i != r100.f540868i) goto L32;
        if (this.f540869j != r100.f540869j) goto L32;
        if (this.f540870k != r100.f540870k) goto L32;
        if (this.f540871l != r100.f540871l) goto L32;
        if (this.f540872m != r100.f540872m) goto L32;
        if (this.f540874o != r100.f540874o) goto L32;
        return true;
    }

    public final int c(ReadableArray r100, int r101) {
        if (r100 != null) goto L4;
    L8:
        this.f540864e = 0;
        this.f540869j = 0;
        this.f540865f = 0.0f;
        this.f540866g = 0.0f;
        this.f540867h = 0.0f;
        this.f540868i = 0.0f;
        return r101;
    L4:
        if (r100.size() < 6) goto L8;
        this.f540864e = r100.getInt(r101);
        this.f540869j = r100.getInt(r101 + 1);
        this.f540865f = (float) r100.getDouble(r101 + 2);
        this.f540866g = (float) r100.getDouble(r101 + 3);
        this.f540867h = (float) r100.getDouble(r101 + 4);
        this.f540868i = (float) r100.getDouble(r101 + 5);
        return r101 + 6;
    }

    public static void b(SparseArray<a> r100, int r101, int r102) {
        if (r100.indexOfKey(r101) >= 0) goto L5;
        return;
    L5:
        if (r100.indexOfKey(r102) >= 0) goto L7;
        return;
    L7:
        if (r100.get(r101).f540875p >= r100.get(r102).f540875p) goto L9;
        r100.remove(r101);
        return;
    L9:
        r100.remove(r102);
    }
}
