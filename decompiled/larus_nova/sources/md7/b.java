package md7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDLXBridgeMethod.Access f513421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f513422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f513423c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f513421a == r101.f513421a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513422b, r101.f513422b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513423c, r101.f513423c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f513421a.hashCode() * 31) + this.f513422b.hashCode()) * 31) + this.f513423c.hashCode();
    }

    public final String toString() {
        return "PermissionRule(access=" + this.f513421a + ", includedMethods=" + this.f513422b + ", excludedMethods=" + this.f513423c + ')';
    }

    public b(IDLXBridgeMethod.Access r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = IDLXBridgeMethod.Access.PUBLIC;
    L5:
        LinkedHashSet r102 = null;
        if ((r101 & 2) == 0) goto L8;
        LinkedHashSet r103 = new LinkedHashSet();
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = new LinkedHashSet();
    L12:
        Intrinsics.checkNotNullParameter(r100, "access");
        Intrinsics.checkNotNullParameter(r103, "includedMethods");
        Intrinsics.checkNotNullParameter(r102, "excludedMethods");
        this.f513421a = r100;
        this.f513422b = r103;
        this.f513423c = r102;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
