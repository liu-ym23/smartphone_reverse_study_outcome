package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365197f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k4) == true) goto L8;
        return false;
    L8:
        k4 r101 = (k4) r100;
        if (Intrinsics.areEqual(this.f365192a, r101.f365192a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365193b, r101.f365193b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365194c, r101.f365194c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365195d, r101.f365195d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365196e, r101.f365196e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365197f, r101.f365197f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f365192a.hashCode() * 31) + this.f365193b.hashCode()) * 31) + this.f365194c.hashCode()) * 31) + this.f365195d.hashCode()) * 31) + this.f365196e.hashCode()) * 31) + this.f365197f.hashCode();
    }

    public final String toString() {
        return "MediaSceneInfo(scene=" + this.f365192a + ", title=" + this.f365193b + ", artist=" + this.f365194c + ", audioId=" + this.f365195d + ", conversationId=" + this.f365196e + ", messageId=" + this.f365197f + ')';
    }

    public k4(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "artist");
        Intrinsics.checkNotNullParameter(r103, "audioId");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "messageId");
        this.f365192a = r100;
        this.f365193b = r101;
        this.f365194c = r102;
        this.f365195d = r103;
        this.f365196e = r104;
        this.f365197f = r105;
    }
}
