package z79;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f570684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DriveFileItem f570685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleCoroutineScope f570686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<DriveFileItem> f570687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PreviewFromPage f570688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u79.a f570689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f570690g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f570684a, r101.f570684a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570685b, r101.f570685b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570686c, r101.f570686c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f570687d, r101.f570687d) == true) goto L21;
        return false;
    L21:
        if (this.f570688e == r101.f570688e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f570689f, r101.f570689f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f570690g, r101.f570690g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f570684a.hashCode() * 31) + this.f570685b.hashCode()) * 31) + this.f570686c.hashCode()) * 31;
        List<DriveFileItem> r101 = this.f570687d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f570688e.hashCode()) * 31;
        u79.a r105 = this.f570689f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        View r108 = this.f570690g;
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
        return "DriveGalleryContext(context=" + this.f570684a + ", file=" + this.f570685b + ", scope=" + this.f570686c + ", mediaList=" + this.f570687d + ", fromPage=" + this.f570688e + ", listVmCallback=" + this.f570689f + ", ivStartView=" + this.f570690g + ')';
    }

    public final Context getContext() {
        return this.f570684a;
    }

    public /* synthetic */ b(Context r100, DriveFileItem r110, LifecycleCoroutineScope r111, PreviewFromPage r112, u79.a r113, int r114) {
        if ((r114 & 16) == 0) goto L5;
        r112 = PreviewFromPage.UNKNOWN;
    L5:
        PreviewFromPage r101 = r112;
        if ((r114 & 32) == 0) goto L8;
        r113 = null;
    L8:
        this(r100, r110, r111, null, r101, r113, null);
    }

    public b(Context r100, DriveFileItem r101, LifecycleCoroutineScope r102, List<DriveFileItem> r103, PreviewFromPage r104, u79.a r105, View r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "file");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r104, "fromPage");
        this.f570684a = r100;
        this.f570685b = r101;
        this.f570686c = r102;
        this.f570687d = r103;
        this.f570688e = r104;
        this.f570689f = r105;
        this.f570690g = r106;
    }
}
