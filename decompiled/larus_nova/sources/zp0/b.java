package zp0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShelfCardInfo f573178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573179c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f573177a == r101.f573177a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f573178b, r101.f573178b) == true) goto L10;
        return false;
    L10:
        if (this.f573179c == r101.f573179c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f573177a * 31;
        ShelfCardInfo r101 = this.f573178b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.f573179c;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "EditCardEvent(type=" + this.f573177a + ", shelfCardInfo=" + this.f573178b + ", position=" + this.f573179c + ")";
    }

    public final int getType() {
        return this.f573177a;
    }

    public b(int r100, ShelfCardInfo r101, int r102) {
        this.f573177a = r100;
        this.f573178b = r101;
        this.f573179c = r102;
    }
}
