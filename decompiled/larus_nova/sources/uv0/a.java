package uv0;

import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveRequestSourceRole f551786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f551788c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f551786a, r101.f551786a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f551787b, r101.f551787b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f551788c, r101.f551788c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LiveRequestSourceRole r100 = this.f551786a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f551787b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f551788c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveAVResourceParams(role=" + this.f551786a + ", source=" + this.f551787b + ", params=" + this.f551788c + ")";
    }

    public a(LiveRequestSourceRole r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "role");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f551786a = r100;
        this.f551787b = r101;
        this.f551788c = r102;
    }
}
