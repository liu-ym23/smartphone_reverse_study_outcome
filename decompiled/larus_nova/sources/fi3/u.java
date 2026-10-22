package fi3;

import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.core.btm.a f477325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StatTagItem f477326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f477327c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L12;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f477325a, r101.f477325a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477326b, r101.f477326b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477327c, r101.f477327c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.core.btm.a r100 = this.f477325a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        StatTagItem r104 = this.f477326b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f477327c;
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
        return "PDPJumpToShopCommentPageActionHandlerParam(btmFields=" + this.f477325a + ", tagInfo=" + this.f477326b + ", extraParams=" + this.f477327c + ")";
    }

    public u(com.bytedance.android.ec.core.btm.a r100, StatTagItem r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "tagInfo");
        this.f477325a = r100;
        this.f477326b = r101;
        this.f477327c = r102;
    }
}
