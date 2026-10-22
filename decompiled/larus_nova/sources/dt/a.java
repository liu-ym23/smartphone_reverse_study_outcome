package dt;

import com.bytedance.ies.sve_core.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f469934b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> f469935a;

    /* JADX INFO: renamed from: dt.a$a, reason: collision with other inner class name */
    public static final class C5707a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f469935a, ((a) r100).f469935a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r100 = this.f469935a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CoLComponentTabState(navInfo=" + this.f469935a + ")";
    }

    public a(List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "navInfo");
        this.f469935a = r100;
    }
}
