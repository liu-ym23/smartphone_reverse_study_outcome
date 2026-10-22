package xcb;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import kotlin.jvm.internal.Intrinsics;
import t6c.d;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlCardPreviewEntity f563251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f563252b;

    public b(UrlCardPreviewEntity r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "previewEntity");
        Intrinsics.checkNotNullParameter(r101, ChameleonOpenTracker.Stage.RENDER);
        this.f563251a = r100;
        this.f563252b = r101;
    }
}
