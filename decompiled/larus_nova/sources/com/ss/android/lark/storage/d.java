package com.ss.android.lark.storage;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f440946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440947b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f440946a, r101.f440946a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f440947b, r101.f440947b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f440946a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f440947b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Name(domains=" + this.f440946a + ", name=" + this.f440947b + ')';
    }

    public final String[] a() {
        ArrayList r100 = new ArrayList();
        a r101 = this.f440946a;
    L3:
        boolean r102 = true;
        if (r101 == null) goto L13;
        String r103 = r101.f440942a;
        if (r103 == null) goto L13;
        if (r103.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 != true) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        ListProtector.add(r100, 0, r101.f440942a);
    L16:
        if (r101 == null) goto L18;
        r101 = r101.f440943b;
    L19:
        if (r101 != null) goto L3;
        String r106 = this.f440947b;
        if (r106 != null) goto L23;
    L26:
        if (r102 == true) goto L29;
        r100.add(this.f440947b);
    L29:
        return (String[]) r100.toArray(new String[0]);
    L23:
        if (r106.length() == 0) goto L26;
        r102 = false;
        goto L26
    L18:
        r101 = null;
        goto L19
    L10:
        r104 = false;
    L13:
        r105 = false;
        goto L14
    }

    public d(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "names");
        int r101 = a.f440941c;
        List r102 = ArraysKt.dropLast(r100, 1);
        Intrinsics.checkNotNullParameter(r102, "names");
        Iterator r103 = r102.iterator();
        a r104 = null;
    L4:
        if (r103.hasNext() == false) goto L6;
        a r105 = new a((String) r103.next());
        r105.f440943b = r104;
        r104 = r105;
        goto L4
    L6:
        this(r104, (String) ArraysKt.last(r100));
    }

    public d(a r100, String r101) {
        this.f440946a = r100;
        this.f440947b = r101;
    }
}
