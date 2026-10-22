package hda;

import android.content.Context;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f484768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Context, View> f484769d;

    public v() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f484766a, r101.f484766a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484767b, r101.f484767b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484768c, r101.f484768c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484769d, r101.f484769d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f484766a.hashCode() * 31) + this.f484767b.hashCode()) * 31;
        Function0<Unit> r101 = this.f484768c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function1<Context, View> r105 = this.f484769d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewDetailTextSection(label=" + this.f484766a + ", text=" + this.f484767b + ", onClick=" + this.f484768c + ", contentBuilder=" + this.f484769d + ')';
    }

    public v(String r100, String r101, ida.j r102, ida.i r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f484766a = r100;
        this.f484767b = r101;
        this.f484768c = r102;
        this.f484769d = r103;
    }
}
