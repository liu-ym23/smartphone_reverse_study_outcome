package ujb;

import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnchorConfig f550455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MaskConfig f550456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f550457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f550458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f550459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f550460i;

    public c(AnchorConfig r100, MaskConfig r101, String r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "anchorConfig");
        Intrinsics.checkNotNullParameter(r101, "maskConfig");
        Intrinsics.checkNotNullParameter(r102, "detail");
        Intrinsics.checkNotNullParameter(r103, "rightButton");
        this.f550455d = r100;
        this.f550456e = r101;
        this.f550457f = null;
        this.f550458g = r102;
        this.f550459h = null;
        this.f550460i = r103;
    }
}
