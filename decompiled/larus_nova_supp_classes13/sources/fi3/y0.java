package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y0 {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Integer b;
    public final String c;

    public static final class a {
        public static y0 a(Map r5) {
            Object r1 = null;
            if (r5 == null) goto L5;
            Object r2 = r5.get("post_action");
        L6:
            String r3 = String.valueOf(r2);
            if (r5 == null) goto L9;
            Object r4 = r5.get("type");
        L11:
            if ((r4 instanceof Number) == true) goto L13;
            r4 = null;
        L13:
            Number r6 = (Number) r4;
            if (r6 == null) goto L16;
            Integer r7 = Integer.valueOf(r6.intValue());
        L17:
            if (r5 == null) goto L20;
            r1 = r5.get("page");
        L20:
            return new y0(r3, r7, String.valueOf(r1));
        L16:
            r7 = null;
            goto L17
        L9:
            r4 = null;
            goto L11
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public y0() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y0) == false) goto L12;
        y0 r4 = (y0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TriggerMarketingServiceActionHandlerParam(action=" + this.a + ", type=" + this.b + ", pageId=" + this.c + ")";
    }

    public final Integer getType() {
        return this.b;
    }

    public y0(String r1, Integer r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
