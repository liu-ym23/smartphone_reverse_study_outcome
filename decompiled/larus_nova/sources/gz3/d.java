package gz3;

import com.bytedance.awemeopen.apps.framework.feed.profile.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.a f483397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f483398c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f483396a, r101.f483396a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483397b, r101.f483397b) == true) goto L15;
        return false;
    L15:
        if (this.f483398c == r101.f483398c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f483396a.hashCode() * 31;
        f.a r101 = this.f483397b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f483398c;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AosProfileFeedSelectedIndexEvent(userOpenId=" + this.f483396a + ", profileType=" + this.f483397b + ", selectedIndex=" + this.f483398c + ')';
    }

    public d(String r100, f.a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "userOpenId");
        this.f483396a = r100;
        this.f483397b = r101;
        this.f483398c = r102;
    }
}
