package fc3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAction f476346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f476347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ? extends b> f476348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentSliceComponent f476349d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f476346a, r101.f476346a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476347b, r101.f476347b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f476348c, r101.f476348c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476349d, r101.f476349d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        IAction r100 = this.f476346a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f476347b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, ? extends b> r107 = this.f476348c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CommentSliceComponent r110 = this.f476349d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HandleActionParams(action=" + this.f476346a + ", targetView=" + this.f476347b + ", actionParams=" + this.f476348c + ", component=" + this.f476349d + ")";
    }

    public c(IAction r100, View r101, Map<String, ? extends b> r102, CommentSliceComponent r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f476346a = r100;
        this.f476347b = r101;
        this.f476348c = r102;
        this.f476349d = r103;
    }

    public /* synthetic */ c(IAction r100, View r101, CommentSliceComponent r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, null, r102);
    }
}
