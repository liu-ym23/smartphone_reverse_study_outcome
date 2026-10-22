package lk9;

import com.larus.media.MediaLevel;
import com.larus.media.MixPriority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f509608i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f509610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaLevel f509611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MixPriority f509612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f509613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f509614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f509615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f509616h;

    /* JADX INFO: renamed from: lk9.a$a, reason: collision with other inner class name */
    public static final class C6704a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509609a, r101.f509609a) == true) goto L12;
        return false;
    L12:
        if (this.f509610b == r101.f509610b) goto L15;
        return false;
    L15:
        if (this.f509611c == r101.f509611c) goto L18;
        return false;
    L18:
        if (this.f509612d == r101.f509612d) goto L21;
        return false;
    L21:
        if (this.f509613e == r101.f509613e) goto L24;
        return false;
    L24:
        if (this.f509614f == r101.f509614f) goto L27;
        return false;
    L27:
        if (this.f509615g == r101.f509615g) goto L30;
        return false;
    L30:
        if (this.f509616h == r101.f509616h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f509609a.hashCode() * 31) + this.f509610b) * 31) + this.f509611c.hashCode()) * 31) + this.f509612d.hashCode()) * 31) + this.f509613e) * 31;
        int r101 = 1231;
        if (this.f509614f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f509615g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f509616h == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioConfig(scene=" + this.f509609a + ", mediaType=" + this.f509610b + ", level=" + this.f509611c + ", mixPriority=" + this.f509612d + ", focusType=" + this.f509613e + ", mixWithOthers=" + this.f509614f + ", canInterruptInPeer=" + this.f509615g + ", isExternal=" + this.f509616h + ')';
    }

    public a(String r100, int r101, MediaLevel r102, MixPriority r103, int r104, boolean r105, boolean r106, boolean r107) {
        this.f509609a = r100;
        this.f509610b = r101;
        this.f509611c = r102;
        this.f509612d = r103;
        this.f509613e = r104;
        this.f509614f = r105;
        this.f509615g = r106;
        this.f509616h = r107;
    }
}
