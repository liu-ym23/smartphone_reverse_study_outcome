package com.bytedance.badger.t;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f199198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f199199c;

    public d(int r100, List r101, byte[] r102) {
        this.f199197a = r100;
        this.f199198b = r101;
        this.f199199c = r102;
    }

    public final l b(int r100) {
        int r101 = r100 + 2;
        if (r101 < this.f199198b.size()) goto L7;
        return null;
    L7:
        return (l) ListProtector.get(this.f199198b, r101);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(d.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        d r102 = (d) r100;
        if (this.f199197a == r102.f199197a) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f199198b, r102.f199198b)) == false) goto L20;
        return false;
    L20:
        if (Arrays.equals(this.f199199c, r102.f199199c) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.NativeResult");
    L8:
        r101 = null;
        goto L10
    }

    public final int hashCode() {
        return (((this.f199197a * 31) + this.f199198b.hashCode()) * 31) + Arrays.hashCode(this.f199199c);
    }

    public final String toString() {
        return "NativeResult(eventId=" + this.f199197a + ", nodes=" + this.f199198b + ", rawPayload=" + Arrays.toString(this.f199199c) + ")";
    }

    public final boolean e() {
        if ((!this.f199198b.isEmpty()) == true) goto L5;
    L13:
        return false;
    L5:
        if ((ListProtector.get(this.f199198b, 0) instanceof g) == false) goto L13;
        Object r100 = ListProtector.get(this.f199198b, 0);
        if (r100 == null) goto L12;
        if (((g) r100).f199202a != 0) goto L13;
        return true;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.IntVal");
    }

    public static boolean f(d r100) {
        l r101 = r100.b(0);
        if ((r101 instanceof e) == true) goto L5;
        return false;
    L5:
        return ((e) r101).f199200a;
    }

    public final List d(Function1 r100) {
        l r101 = b(0);
    L17:
        e = move-exception;
        com.bytedance.badger.e.e("NativeResult", "Failed to convert TLVNode to object list: " + e.getMessage());
        return CollectionsKt.emptyList();
    L4:
        if ((r101 instanceof h) == false) goto L28;
        List r102 = ((h) r101).f199203a;     // Catch: Exception -> L17
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L17
        Iterator r104 = r102.iterator();     // Catch: Exception -> L17
    L7:
        if (r104.hasNext() == false) goto L29;
        n r105 = (n) r100.invoke((l) r104.next());     // Catch: Exception -> L11
    L13:
        if (r105 == null) goto L7;
        r103.add(r105);     // Catch: Exception -> L17
        goto L7
    L11:
        e = move-exception;
        com.bytedance.badger.e.e("NativeResult", "Failed to convert list item to object: " + e.getMessage());     // Catch: Exception -> L17
        r105 = null;
        goto L13
    L29:
        return r103;
    L28:
        return CollectionsKt.emptyList();
    }

    public static int a(d r100, int r101, int r102) {
        int r103 = 0;
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r103 = -1;
    L8:
        l r104 = r100.b(r101);
        if ((r104 instanceof g) == true) goto L11;
        return r103;
    L11:
        return ((g) r104).f199202a;
    }

    public static String c(d r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        String r103 = "";
    L9:
        l r104 = r100.b(r101);
        if ((r104 instanceof k) == true) goto L12;
        return r103;
    L12:
        return ((k) r104).f199206a;
    L8:
        r103 = null;
        goto L9
    }
}
