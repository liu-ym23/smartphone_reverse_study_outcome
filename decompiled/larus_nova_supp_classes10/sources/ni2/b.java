package ni2;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final int a;
    public final ml.b b;
    public final il.a c;
    public final ml.a d;
    public final String e;
    public final String f;
    public final JSONObject g;
    public final String h;
    public final xk.a i;
    public final ViewModelProvider.Factory j;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L26;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ml.b r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        il.a r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ml.a r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        JSONObject r17 = this.g;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        xk.a r23 = this.i;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        ViewModelProvider.Factory r26 = this.j;
        if (r26 == null) goto L38;
        r2 = r26.hashCode();
    L38:
        return r25 + r2;
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ECScrollProductCardAdapterParams(funType=" + this.a + ", liveInfo=" + this.b + ", eventMap=" + this.c + ", btmInfo=" + this.d + ", ecomSceneId=" + this.e + ", replayId=" + this.f + ", queryEntranceInfo=" + this.g + ", enterFrom=" + this.h + ", replayParams=" + this.i + ", factory=" + this.j + ")";
    }

    public b(int r2, ml.b r3, il.a r4, ml.a r5, String r6, String r7, JSONObject r8, String r9, xk.a r10, ViewModelProvider.Factory r11) {
        Intrinsics.checkNotNullParameter(r3, "liveInfo");
        Intrinsics.checkNotNullParameter(r4, "eventMap");
        Intrinsics.checkNotNullParameter(r5, "btmInfo");
        Intrinsics.checkNotNullParameter(r6, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r7, "replayId");
        Intrinsics.checkNotNullParameter(r8, "queryEntranceInfo");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        Intrinsics.checkNotNullParameter(r10, "replayParams");
        Intrinsics.checkNotNullParameter(r11, "factory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
