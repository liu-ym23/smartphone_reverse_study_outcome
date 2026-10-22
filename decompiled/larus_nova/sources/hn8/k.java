package hn8;

import android.view.View;
import com.larus.bmhome.chat.standarduikit.search.vm.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<String, Integer, View, Unit> f486148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f486149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<String, Integer, Boolean, Unit> f486150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<String, Integer, Throwable, Unit> f486151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<String, Integer, View, Unit> f486152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<View, Unit> f486153f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f486148a, r101.f486148a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486149b, r101.f486149b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486150c, r101.f486150c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486151d, r101.f486151d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486152e, r101.f486152e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f486153f, r101.f486153f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Function3<String, Integer, View, Unit> r100 = this.f486148a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Integer, Unit> r104 = this.f486149b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function3<String, Integer, Boolean, Unit> r107 = this.f486150c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function3<String, Integer, Throwable, Unit> r110 = this.f486151d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function3<String, Integer, View, Unit> r113 = this.f486152e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Function1<View, Unit> r116 = this.f486153f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "VideoCardViewCallback(bindDataCallback=" + this.f486148a + ", imgLoadOnStart=" + this.f486149b + ", imgLoadOnSuccess=" + this.f486150c + ", imgLoadOnFail=" + this.f486151d + ", coverClick=" + this.f486152e + ", coverLongClick=" + this.f486153f + ')';
    }

    public k(com.larus.bmhome.chat.standarduikit.search.vm.h r100, com.larus.bmhome.chat.standarduikit.search.vm.i r101, com.larus.bmhome.chat.standarduikit.search.vm.j r102, com.larus.bmhome.chat.standarduikit.search.vm.k r103, com.larus.bmhome.chat.standarduikit.search.vm.l r104, m r105) {
        this.f486148a = r100;
        this.f486149b = r101;
        this.f486150c = r102;
        this.f486151d = r103;
        this.f486152e = r104;
        this.f486153f = r105;
    }
}
