package uac;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f549296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f549297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f549298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vac.a f549299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f549300f;

    /* JADX INFO: renamed from: uac.a$a, reason: collision with other inner class name */
    public static final class C7853a {
    }

    static {
    }

    public a() {
        this(null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f549295a == r101.f549295a) goto L12;
        return false;
    L12:
        if (this.f549296b == r101.f549296b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549297c, r101.f549297c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f549298d, r101.f549298d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f549299e, r101.f549299e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f549300f, r101.f549300f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f549295a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f549296b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.f549297c.hashCode()) * 31;
        String r104 = this.f549298d;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return ((((r103 + r105) * 31) + this.f549299e.hashCode()) * 31) + this.f549300f.hashCode();
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceAsrConfig(isEnable=" + this.f549295a + ", parallelEnable=" + this.f549296b + ", language=" + this.f549297c + ", model=" + this.f549298d + ", result=" + this.f549299e + ", retry=" + this.f549300f + ')';
    }

    public a(vac.a r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r101 & 4) == 0) goto L13;
        String r104 = "auto";
    L15:
        if ((r101 & 16) == 0) goto L18;
        r100 = new vac.a(null, 31);
    L18:
        if ((r101 & 32) == 0) goto L20;
        b r105 = new b(0);
    L21:
        Intrinsics.checkNotNullParameter(r104, "language");
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r105, EventConstant.Value.RETRY);
        this.f549295a = r102;
        this.f549296b = r103;
        this.f549297c = r104;
        this.f549298d = null;
        this.f549299e = r100;
        this.f549300f = r105;
        if ((!StringsKt.isBlank(r104)) == false) goto L25;
        return;
    L25:
        throw new IllegalArgumentException("language must not be blank".toString());
    L20:
        r105 = null;
        goto L21
    L13:
        r104 = null;
        goto L15
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }
}
