package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.api.settings.config.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.r0;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f569865b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f569866c = null;

    static {
        f569866c = new b();
        f569865b = r0.f536248a.getValue();
    }

    public b() {
    }

    @JvmStatic
    public static final void a(HighlevelNoMessageMonitorEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (f569865b.c() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569866c.f569864a, r100.getValueNodeName(), 1);
    }
}
