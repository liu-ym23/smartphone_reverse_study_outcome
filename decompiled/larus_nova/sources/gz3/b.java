package gz3;

import com.bytedance.awemeopen.apps.framework.feed.collect.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.a f483392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f483393c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f483391a, r101.f483391a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483392b, r101.f483392b) == true) goto L15;
        return false;
    L15:
        if (this.f483393c == r101.f483393c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f483391a.hashCode() * 31;
        f.a r101 = this.f483392b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f483393c;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AosCollectFeedSelectedIndexEvent(userOpenId=" + this.f483391a + ", profileType=" + this.f483392b + ", selectedIndex=" + this.f483393c + ')';
    }

    public b(String r100, f.a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "userOpenId");
        this.f483391a = r100;
        this.f483392b = r101;
        this.f483393c = r102;
    }
}
