package j98;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f497808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f497810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f497811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f497812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f497813f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f497808a == r101.f497808a) goto L12;
        return false;
    L12:
        if (this.f497809b == r101.f497809b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f497810c, r101.f497810c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f497811d, r101.f497811d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f497812e, r101.f497812e) == true) goto L24;
        return false;
    L24:
        if (this.f497813f == r101.f497813f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f497808a;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f497809b) * 31) + this.f497810c.hashCode()) * 31) + this.f497811d.hashCode()) * 31) + this.f497812e.hashCode()) * 31;
        if (this.f497813f == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "DiaryFeedbackSheetUiState(sessionId=" + this.f497808a + ", actionType=" + this.f497809b + ", reasonOptions=" + this.f497810c + ", selectedReasons=" + this.f497811d + ", inputText=" + this.f497812e + ", isSubmitting=" + this.f497813f + ')';
    }

    public final boolean b() {
        if (this.f497813f == false) goto L5;
        return false;
    L5:
        if ((!this.f497811d.isEmpty()) == false) goto L7;
    L11:
        return true;
    L7:
        if (StringsKt.trim(this.f497812e).toString().length() <= 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == true) goto L11;
        return false;
    L9:
        r100 = false;
        goto L10
    }

    public f() {
        this(System.nanoTime(), 0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", false);
    }

    public f(long r100, int r101, List<String> r102, List<String> r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r102, "reasonOptions");
        Intrinsics.checkNotNullParameter(r103, "selectedReasons");
        Intrinsics.checkNotNullParameter(r104, "inputText");
        this.f497808a = r100;
        this.f497809b = r101;
        this.f497810c = r102;
        this.f497811d = r103;
        this.f497812e = r104;
        this.f497813f = r105;
    }

    public static f a(f r110, List r111, List r112, String r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        long r100 = r110.f497808a;
    L6:
        long r101 = r100;
        if ((r115 & 2) == 0) goto L9;
        int r102 = r110.f497809b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        r111 = r110.f497810c;
    L13:
        List r103 = r111;
        if ((r115 & 8) == 0) goto L16;
        r112 = r110.f497811d;
    L16:
        List r104 = r112;
        if ((r115 & 16) == 0) goto L19;
        r113 = r110.f497812e;
    L19:
        String r105 = r113;
        if ((r115 & 32) == 0) goto L22;
        r114 = r110.f497813f;
    L22:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "reasonOptions");
        Intrinsics.checkNotNullParameter(r104, "selectedReasons");
        Intrinsics.checkNotNullParameter(r105, "inputText");
        return new f(r101, r102, r103, r104, r105, r114);
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L6
    }
}
