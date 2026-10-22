package com.ss.android.lark.passportc.impl.v2.entity;

import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f438268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<c> f438269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.d f438270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final lzb.a f438271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<BehaviorSubject<c>> f438272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f438273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f438274g;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f438268a == r101.f438268a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f438269b, r101.f438269b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f438270c, r101.f438270c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f438271d, r101.f438271d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f438272e, r101.f438272e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f438273f, r101.f438273f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f438274g, r101.f438274g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f438268a * 31) + this.f438269b.hashCode()) * 31) + this.f438270c.hashCode()) * 31) + this.f438271d.hashCode()) * 31) + this.f438272e.hashCode()) * 31) + this.f438273f.hashCode()) * 31) + this.f438274g.hashCode();
    }

    public final String toString() {
        return "{reqId:" + this.f438268a + ", foreground:\n  " + CollectionsKt.joinToString$default(this.f438273f, "\n", null, null, 0, null, null, 62, null) + "\nbackground: [\n  " + CollectionsKt.joinToString$default(this.f438274g, "\n  ", null, null, 0, null, null, 62, null) + "\n]}";
    }

    public a(int r100, BehaviorSubject r101, com.ss.android.lark.passportc.api.d r102, lzb.a r103, List r104) {
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        Intrinsics.checkNotNullParameter(r102, "executeMode");
        Intrinsics.checkNotNullParameter(r103, "actionContext");
        Intrinsics.checkNotNullParameter(r104, "mergedSubject");
        Intrinsics.checkNotNullParameter(r105, "foregroundTransitions");
        Intrinsics.checkNotNullParameter(r106, "backgroundTransitions");
        this.f438268a = r100;
        this.f438269b = r101;
        this.f438270c = r102;
        this.f438271d = r103;
        this.f438272e = r104;
        this.f438273f = r105;
        this.f438274g = r106;
    }
}
