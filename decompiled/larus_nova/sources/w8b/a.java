package w8b;

import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f558703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f558704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f558706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f558707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f558708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TenantNameStatus f558709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatterDescription f558710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f558711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f558712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f558713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f558714l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f558715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CertificationInfo f558716n;

    public a() {
    }

    public static int a(char r100) {
        if (r100 != ' ') goto L5;
        return 36;
    L5:
        boolean r101 = false;
        if ('a' <= r100) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return 35 - (r100 - 'a');
    L14:
        if ('0' <= r100) goto L16;
    L18:
        if (r101 == true) goto L24;
        return -1;
    L24:
        return 9 - (r100 - '0');
    L16:
        if (r100 >= ':') goto L18;
        r101 = true;
        goto L18
    L8:
        if (r100 >= '{') goto L10;
        r102 = true;
        goto L11
    }

    public final String b() {
        String r100 = this.f558704b;
        char r101 = '#';
        boolean r102 = true;
        if (r100 == null) goto L12;
        if (r100.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        r101 = r100.charAt(0);
        goto L12
    L7:
        r103 = false;
    L12:
        if ('A' <= r101) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L20;
        return String.valueOf(r101);
    L20:
        if ('a' <= r101) goto L22;
    L24:
        r102 = false;
    L25:
        if (r102 == true) goto L30;
        return "#";
    L30:
        return String.valueOf(Character.toUpperCase(r101));
    L22:
        if (r101 >= '{') goto L24;
    L14:
        if (r101 >= '[') goto L16;
        r104 = true;
        goto L17
    }

    public final int hashCode() {
        String r100 = this.f558707e;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    L7:
        return 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        String r102 = b();
        boolean r103 = r102.equals("#");
        if ((r101.b().equals("#") ^ r103) == false) goto L6;
        if (r103 == true) goto L14;
    L11:
        return -1;
    L14:
        return 1;
    L6:
        int r104 = 0;
        if (r102.equals(r101.b()) == false) goto L39;
        String r105 = this.f558704b;
        if (r105 == null) goto L11;
        String r106 = r101.f558704b;
        if (r106 == null) goto L14;
        int r107 = r105.length();
        int r108 = r106.length();
        int r109 = Math.min(r107, r108);
    L16:
        if (r104 >= r109) goto L24;
        char r110 = r105.charAt(r104);
        char r111 = r106.charAt(r104);
        if (r110 == r111) goto L22;
        int r112 = a(r110);
        int r113 = a(r111);
        if (r112 == r113) goto L22;
        return -(r112 - r113);
    L22:
        r104 = r104 + 1;
        goto L16
    L24:
        if (r107 != r108) goto L34;
        Long r114 = this.f558712j;
        long r115 = 0;
        if (r114 == null) goto L28;
        long r116 = r114.longValue();
    L29:
        Long r117 = r101.f558712j;
        if (r117 == null) goto L43;
        r115 = r117.longValue();
    L43:
        return -((int) (r116 - r115));
    L28:
        r116 = 0;
        goto L29
    L34:
        return r107 - r108;
    L39:
        return r102.charAt(0) - r101.b().charAt(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f558707e, ((a) r100).f558707e);
    }
}
