package lv8;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f510974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f510975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f510976d;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f510973a, r101.f510973a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510974b, r101.f510974b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510975c, r101.f510975c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510976d, r101.f510976d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f510973a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f510974b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f510975c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Fragment r110 = this.f510976d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BtmPageFinder(btmPageId=" + this.f510973a + ", page=" + this.f510974b + ", view=" + this.f510975c + ", fragment=" + this.f510976d + ')';
    }

    public a(String r100, Object r101, View r102, Fragment r103) {
        this.f510973a = r100;
        this.f510974b = r101;
        this.f510975c = r102;
        this.f510976d = r103;
    }
}
