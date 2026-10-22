package tic;

import com.ss.ttvideoengine.model.VideoModel;
import ejc.b;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f546363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f546364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f546365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoModel f546366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f546367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f546368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f546369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f546370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f546371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f546372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f546373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f546374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f546375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f546376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f546377o;

    public final int hashCode() {
        String r100 = this.f546363a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f546367e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f546368f;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + 0) * 31;
        String r110 = this.f546369g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + 0) * 31;
        String r113 = this.f546371i;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f546370h;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((r115 + r101) * 31) + ((int) (this.f546364b * 31));
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public a() {
        this.f546377o = b.a();
        this.f546365c = -1;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L41:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L41;
        a r101 = (a) r100;
        if (this.f546364b == r101.f546364b) goto L14;
        return false;
    L14:
        if (a(this.f546363a, r101.f546363a) == true) goto L17;
        return false;
    L17:
        if (a(this.f546366d, r101.f546366d) == true) goto L20;
        return false;
    L20:
        if (a(this.f546367e, r101.f546367e) == true) goto L23;
        return false;
    L23:
        if (a(this.f546368f, r101.f546368f) == true) goto L26;
        return false;
    L26:
        if (a(null, null) == true) goto L29;
        return false;
    L29:
        if (a(this.f546369g, r101.f546369g) == true) goto L32;
        return false;
    L32:
        if (a(null, null) == true) goto L35;
        return false;
    L35:
        if (a(this.f546371i, r101.f546371i) == true) goto L38;
        return false;
    L38:
        if (a(this.f546370h, r101.f546370h) == true) goto L40;
        return false;
    L40:
        return true;
    }

    public static boolean a(Object r100, Object r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r100.equals(r101);
    }
}
