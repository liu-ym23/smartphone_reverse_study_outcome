package zb8;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f571154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f571155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f571156f;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f571151a, r101.f571151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571152b, r101.f571152b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f571153c, r101.f571153c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f571154d, r101.f571154d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f571155e, r101.f571155e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f571156f, r101.f571156f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f571151a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571152b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571153c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f571154d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.f571155e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Function0<Unit> r116 = this.f571156f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatCameraMoreData(prompt=" + this.f571151a + ", enterMethod=" + this.f571152b + ", scene=" + this.f571153c + ", msgExt=" + this.f571154d + ", msgEventExt=" + this.f571155e + ", onDirectSend=" + this.f571156f + ')';
    }

    public a(String r100, String r101, String r102, Map r103, Map r104, Function0 r105, int r106) {
        if ((r106 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r106 & 32) == 0) goto L8;
        r105 = null;
    L8:
        this.f571151a = r100;
        this.f571152b = r101;
        this.f571153c = r102;
        this.f571154d = r103;
        this.f571155e = r104;
        this.f571156f = r105;
    }
}
