package tib;

import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProvider;
import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExternalTargetAvatarProvider f546332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f546334c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546332a, r101.f546332a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546333b, r101.f546333b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546334c, r101.f546334c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f546332a.hashCode() * 31) + this.f546333b.hashCode()) * 31;
        Integer r101 = this.f546334c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ExternalTargetItem(avatarProvider=" + this.f546332a + ", name=" + this.f546333b + ", insertPosition=" + this.f546334c + ')';
    }

    public a(ForwardNewDependency.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarProvider");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f546332a = r100;
        this.f546333b = r101;
        this.f546334c = null;
    }
}
