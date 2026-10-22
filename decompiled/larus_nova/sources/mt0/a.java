package mt0;

import com.bytedance.android.live.profile.model.CompareOperation;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<TYPE, BEAN> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TYPE f515589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BEAN f515590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompareOperation f515591c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f515589a, r101.f515589a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f515590b, r101.f515590b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f515591c, r101.f515591c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        TYPE r100 = this.f515589a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BEAN r104 = this.f515590b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CompareOperation r107 = this.f515591c;
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
        return "CompareItemInfo(type=" + this.f515589a + ", data=" + this.f515590b + ", operation=" + this.f515591c + ")";
    }

    public final TYPE getType() {
        return this.f515589a;
    }

    public a(TYPE r100, BEAN r101, CompareOperation r102) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        this.f515589a = r100;
        this.f515590b = r101;
        this.f515591c = r102;
    }
}
