package com.bytedance.ee.bear.list.office.preload;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public final boolean a;
    public final String b;
    public final ArrayList<Document> c;
    public final g d;

    public static final class a {
        public static e a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            return new e(false, r4, new ArrayList(), null);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        g r2 = this.d;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSpacePreloadConsumeResult(hit=" + this.a + ", reason=" + this.b + ", documents=" + this.c + ", entry=" + this.d + ')';
    }

    public e(boolean r2, String r3, ArrayList<Document> r4, g r5) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Intrinsics.checkNotNullParameter(r4, "documents");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
