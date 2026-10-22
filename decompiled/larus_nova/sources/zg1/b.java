package zg1;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Context> f571802d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f571799a, r101.f571799a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571800b, r101.f571800b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571801c, r101.f571801c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571802d, r101.f571802d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f571799a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571800b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571801c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        WeakReference<Context> r110 = this.f571802d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "AnchorFansGroupManagerEvent(conversationId=" + this.f571799a + ", enterFrom=" + this.f571800b + ", url=" + this.f571801c + ", curTopCtx=" + this.f571802d + ")";
    }

    public b(String r100, String r101, String r102, WeakReference<Context> r103) {
        Intrinsics.checkNotNullParameter(r103, "curTopCtx");
        this.f571799a = r100;
        this.f571800b = r101;
        this.f571801c = r102;
        this.f571802d = r103;
    }
}
