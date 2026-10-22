package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f443864h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f443865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f443866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f443867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f443868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f443869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f443870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f443871g;

    public static final class a {
        public a() {
        }

        public static w8c.a a(int r100, int r101, String r110, int r111) {
            int r102 = k.f443864h;
            if ((r111 & 4) == 0) goto L6;
            r110 = null;
        L6:
            return new w8c.a(new k(r100, r101, r110, null, null, null, null));
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f443865a == r101.f443865a) goto L12;
        return false;
    L12:
        if (this.f443866b == r101.f443866b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f443867c, r101.f443867c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f443868d, r101.f443868d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f443869e, r101.f443869e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f443870f, r101.f443870f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f443871g, r101.f443871g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f443865a * 31) + this.f443866b) * 31;
        String r101 = this.f443867c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Context r105 = this.f443868d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f443869e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f443870f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f443871g;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TodoToastUnit(stringId=" + this.f443865a + ", toastType=" + this.f443866b + ", string=" + this.f443867c + ", context=" + this.f443868d + ", gravity=" + this.f443869e + ", xOffset=" + this.f443870f + ", yOffset=" + this.f443871g + ')';
    }

    public final Context getContext() {
        return this.f443868d;
    }

    public /* synthetic */ k(int r100, int r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r110, r111, null, null, null, null);
    }

    public k(int r100, @ToastType int r101, String r102, Context r103, Integer r104, Integer r105, Integer r106) {
        this.f443865a = r100;
        this.f443866b = r101;
        this.f443867c = r102;
        this.f443868d = r103;
        this.f443869e = r104;
        this.f443870f = r105;
        this.f443871g = r106;
    }
}
