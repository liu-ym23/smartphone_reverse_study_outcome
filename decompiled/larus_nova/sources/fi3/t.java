package fi3;

import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StatTagItem f477321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f477322b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f477321a, r101.f477321a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477322b, r101.f477322b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        StatTagItem r100 = this.f477321a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f477322b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPJumpToProductCommentPageParam(tagInfo=" + this.f477321a + ", extraParams=" + this.f477322b + ")";
    }

    public t(StatTagItem r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "tagInfo");
        this.f477321a = r100;
        this.f477322b = r101;
    }
}
