package mt1;

import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f515595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Room f515597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pt1.a f515599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515600f;

    /* JADX INFO: renamed from: mt1.a$a, reason: collision with other inner class name */
    public static final class C6850a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f515596b == r101.f515596b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f515597c, r101.f515597c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f515598d, r101.f515598d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515599e, r101.f515599e) == true) goto L14;
        return false;
    L14:
        if (this.f515600f == r101.f515600f) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = this.f515596b * 31;
        Room r101 = this.f515597c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f515598d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        pt1.a r108 = this.f515599e;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.f515600f;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        return r109 + r111;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DislikeMenuEvent(type=" + this.f515596b + ", room=" + this.f515597c + ", enterFrom=" + this.f515598d + ", shareFansHelper=" + this.f515599e + ", fromLongPress=" + this.f515600f + ")";
    }

    public final int getType() {
        return this.f515596b;
    }

    public a(int r100, Room r101, String r102, pt1.a r103, boolean r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = false;
    L8:
        this.f515596b = r100;
        this.f515597c = r101;
        this.f515598d = r102;
        this.f515599e = r103;
        this.f515600f = r104;
    }
}
