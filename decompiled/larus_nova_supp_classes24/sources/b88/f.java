package b88;

import aw3.o0;
import com.larus.platform.api.k4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final String a;
    public final int b;
    public final k4 c;
    public final JSONObject d;
    public final String e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final Function1<String, Unit> j;

    public f() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        int r2 = 1231;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.i == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (r5 + r2) * 31;
        Function1<String, Unit> r7 = this.j;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UrlAudioPlayerConfig(url=" + this.a + ", sourceType=" + this.b + ", mediaScene=" + this.c + ", traceInfo=" + this.d + ", focusScene=" + this.e + ", globalAudioScene=" + this.f + ", reportGlobalPlayTriggeredOnFocusSuccess=" + this.g + ", reportGlobalErrorOnPlayerError=" + this.h + ", requestAudioFocusOnPlay=" + this.i + ", onRequireAudioFocusFailure=" + this.j + ')';
    }

    public f(String r6, int r7, k4 r8, JSONObject r9, String r10, String r11, o0 r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r9 = new JSONObject();
    L5:
        boolean r1 = true;
        if ((r13 & 64) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r13 & 128) == 0) goto L12;
        boolean r3 = true;
    L14:
        if ((r13 & 256) != 0) goto L18;
        r1 = false;
    L18:
        if ((r13 & 512) == 0) goto L20;
        r12 = null;
    L20:
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r8, "mediaScene");
        Intrinsics.checkNotNullParameter(r9, "traceInfo");
        Intrinsics.checkNotNullParameter(r10, "focusScene");
        Intrinsics.checkNotNullParameter(r11, "globalAudioScene");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r0;
        this.h = r3;
        this.i = r1;
        this.j = r12;
        return;
    L12:
        r3 = false;
        goto L14
    L8:
        r0 = false;
        goto L10
    }
}
