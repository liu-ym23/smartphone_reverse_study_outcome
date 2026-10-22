package com.bytedance.ee.bear.document.associateddocs.view;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f219039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f219040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f219041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f219042e;

    public final int hashCode() {
        return this.f219038a.hashCode() + this.f219039b.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AppUrlItem(id=");
        r100.append(this.f219038a);
        r100.append(", name=");
        r100.append(this.f219039b);
        r100.append(", url=");
        r100.append(this.f219040c);
        r100.append(", icon is null =");
        if (this.f219041d != null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(", , urlMetaId=");
        r100.append(this.f219042e);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.document.associateddocs.view.AppUrlItem");
        a r102 = (a) r100;
        if (Intrinsics.areEqual(this.f219038a, r102.f219038a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f219039b, r102.f219039b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f219040c, r102.f219040c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f219042e, r102.f219042e) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(String r100, String r101, String r102, Drawable r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r104, "urlMetaId");
        this.f219038a = r100;
        this.f219039b = r101;
        this.f219040c = r102;
        this.f219041d = r103;
        this.f219042e = r104;
    }
}
