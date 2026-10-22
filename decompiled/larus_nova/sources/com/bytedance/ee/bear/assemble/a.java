package com.bytedance.ee.bear.assemble;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f206275b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f206274a, r101.f206274a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206275b, r101.f206275b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f206274a.hashCode() * 31;
        String r101 = this.f206275b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "KoinDefinitionKey(className=" + this.f206274a + ", qualifierValue=" + this.f206275b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f206274a = r100;
        this.f206275b = r101;
    }
}
