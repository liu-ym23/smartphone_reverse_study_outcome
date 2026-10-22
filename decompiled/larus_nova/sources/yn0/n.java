package yn0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements l81.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f568510a = null;

    public n() {
    }

    static {
        f568510a = new n();
    }

    @Override // l81.n
    public final Boolean isPerfToolsDebug() {
        ILiveSdkProjectModeService r100 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.isPerfToolsDebug());
    }

    @Override // l81.n
    public final void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILiveSdkProjectModeService r101 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r101 == null) goto L6;
        r101.initAndShowPerfTools(r100);
        return;
    }
}
