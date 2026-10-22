package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<o> f271241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f271242b = null;

    public m() {
    }

    static {
        f271242b = new m();
        f271241a = new LinkedList();
    }

    public static LinkedList b() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = new LinkedList(f271241a).iterator();
    L4:
        if (r101.hasNext() == false) goto L22;
        o r102 = (o) r101.next();
        Activity r103 = r102.f271243a.get();
        c r104 = r102.f271244b.get();
        m r105 = f271242b;
        if (r103 == null) goto L10;
        if (r104 == null) goto L10;
        boolean r106 = false;
    L11:
        if (r106 == false) goto L14;
        r105 = null;
    L14:
        if (r105 == null) goto L4;
        if (r103 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        if (r104 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        r100.add(new p(r103, r104));
    L10:
        r106 = true;
        goto L11
    L22:
        return new LinkedList(r100);
    }

    public static o a(c r100) {
        Iterator<T> r101 = f271241a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(r100, ((o) r102).f271244b.get()) == false) goto L4;
    L10:
        return (o) r102;
    L8:
        r102 = null;
        goto L10
    }

    public static void c(c r100) {
        LinkedList<o> r101 = f271241a;
        o r102 = a(r100);
        if (r101 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r101).remove(r102);
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
}
