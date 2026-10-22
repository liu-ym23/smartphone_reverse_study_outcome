package com.bytedance.ee.bear.document.associateddocs.view;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public String b;
    public final String c;
    public Drawable d;
    public final String e;

    public final int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AppUrlItem(id=");
        r0.append(this.a);
        r0.append(", name=");
        r0.append(this.b);
        r0.append(", url=");
        r0.append(this.c);
        r0.append(", icon is null =");
        if (this.d != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", , urlMetaId=");
        r0.append(this.e);
        r0.append(')');
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.document.associateddocs.view.AppUrlItem");
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public a(String r2, String r3, String r4, Drawable r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r6, "urlMetaId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
