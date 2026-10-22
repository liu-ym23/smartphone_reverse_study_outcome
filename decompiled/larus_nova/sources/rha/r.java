package rha;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f537854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f537855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f537856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z0 f537857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f537858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f537859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f537860g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f537854a, r101.f537854a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f537855b, r101.f537855b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537856c, r101.f537856c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f537857d, r101.f537857d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f537858e, r101.f537858e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f537859f, r101.f537859f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f537860g, r101.f537860g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f537854a.hashCode() * 31) + this.f537855b.hashCode()) * 31;
        AppCompatImageView r101 = this.f537856c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f537857d.hashCode()) * 31;
        String r105 = this.f537858e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f537859f.hashCode()) * 31;
        Map<String, String> r108 = this.f537860g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SecondaryMenuWindowConfig(activity=" + this.f537854a + ", anchorView=" + this.f537855b + ", secondaryMenuButton=" + this.f537856c + ", customActionBarItem=" + this.f537857d + ", botId=" + this.f537858e + ", conversationId=" + this.f537859f + ", extra=" + this.f537860g + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f537854a;
    }

    public r(FragmentActivity r100, View r101, AppCompatImageView r102, z0 r103, String r104, String r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        this.f537854a = r100;
        this.f537855b = r101;
        this.f537856c = r102;
        this.f537857d = r103;
        this.f537858e = r104;
        this.f537859f = r105;
        this.f537860g = r106;
    }
}
