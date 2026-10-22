package com.ss.ugc.effectplatform.preload;

import java.util.List;
import java.util.ListIterator;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f457438g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f457439h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f457440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f457441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f457442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f457443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f457444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f457445f;

    public static final class a {
        public a() {
        }

        public static String[] a(String r100) {
            List<String> r101 = new Regex(c.f457438g).split(r100, 0);
            if (r101.isEmpty() == true) goto L13;
            ListIterator<String> r102 = r101.listIterator(r101.size());
        L6:
            if (r102.hasPrevious() == false) goto L13;
            if (r102.previous().length() != 0) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == true) goto L6;
            List r104 = CollectionsKt.take(r101, r102.nextIndex() + 1);
        L14:
            Object[] r105 = r104.toArray(new String[0]);
            if (r105 == null) goto L19;
            return (String[]) r105;
        L19:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        L10:
            r103 = false;
        L13:
            r104 = CollectionsKt.emptyList();
            goto L14
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f457440a, r101.f457440a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f457441b, r101.f457441b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f457442c, r101.f457442c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f457443d, r101.f457443d) == true) goto L14;
        return false;
    L14:
        if (this.f457444e == r101.f457444e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f457445f, r101.f457445f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f457440a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f457441b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f457442c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f457443d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f457444e;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.f457445f;
        if (r115 == null) goto L22;
        r101 = r115.hashCode();
    L22:
        return r114 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadDbBean(file_name=" + this.f457440a + ", resource_key=" + this.f457441b + ", uri=" + this.f457442c + ", res_name=" + this.f457443d + ", last_access_time=" + this.f457444e + ", businessKey=" + this.f457445f + ")";
    }

    static {
        f457439h = new a();
        f457438g = ",";
    }

    public c(String r100, String r101, String r102, String r103, long r104, String r105) {
        this.f457440a = r100;
        this.f457441b = r101;
        this.f457442c = r102;
        this.f457443d = r103;
        this.f457444e = r104;
        this.f457445f = r105;
    }
}
