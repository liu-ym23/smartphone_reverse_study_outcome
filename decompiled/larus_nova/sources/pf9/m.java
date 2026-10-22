package pf9;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f528939j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f528940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f528941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f528942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f528943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f528944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f528945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f528946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f528947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f528948i;

    public static final class a {
        public static m a(Map r110) {
            return new m(r110, 0, 0, 0, 0, 0, 0, 0, "");
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f528940a, r101.f528940a) == true) goto L12;
        return false;
    L12:
        if (this.f528941b == r101.f528941b) goto L15;
        return false;
    L15:
        if (this.f528942c == r101.f528942c) goto L18;
        return false;
    L18:
        if (this.f528943d == r101.f528943d) goto L21;
        return false;
    L21:
        if (this.f528944e == r101.f528944e) goto L24;
        return false;
    L24:
        if (this.f528945f == r101.f528945f) goto L27;
        return false;
    L27:
        if (this.f528946g == r101.f528946g) goto L30;
        return false;
    L30:
        if (this.f528947h == r101.f528947h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f528948i, r101.f528948i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f528940a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f528941b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f528942c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f528943d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f528944e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f528945f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f528946g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f528947h;
        return ((r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.f528948i.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L11
        Map<String, String> r102 = this.f528940a;     // Catch: Throwable -> L11
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();     // Catch: Throwable -> L11
    L5:
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Throwable -> L11
        String r105 = r104.getKey();     // Catch: Throwable -> L11
        ouc.i r106 = sf9.a.e(r104.getValue());     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r105, "key");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r106, "element");     // Catch: Throwable -> L11
        ouc.i r107 = (ouc.i) r101.put(r105, r106);     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r108 = Result.m9449constructorimpl(new ouc.d0(r101).toString());     // Catch: Throwable -> L11
    L13:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L17;
        fe9.a.f476620a.b("FlowAudioEvent", "FlowLLMAudioContent toString error, " + r109.getMessage());
    L17:
        if (Result.m9455isFailureimpl(r108) == false) goto L19;
        r108 = null;
    L19:
        String r110 = (String) r108;
        if (r110 != null) goto L26;
        return "";
    L26:
        return r110;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public m(Map<String, String> r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, String r210) {
        Intrinsics.checkNotNullParameter(r210, "intention");
        this.f528940a = r100;
        this.f528941b = r101;
        this.f528942c = r102;
        this.f528943d = r110;
        this.f528944e = r111;
        this.f528945f = r112;
        this.f528946g = r113;
        this.f528947h = r114;
        this.f528948i = r210;
    }
}
