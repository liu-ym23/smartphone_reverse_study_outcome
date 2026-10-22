package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdk.interactivity.api.settings.config.e0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.m3;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f569868b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f569869c = null;

    static {
        f569869c = new d();
        f569868b = m3.f536221a.getValue();
    }

    public d() {
    }

    @JvmStatic
    public static final void a(PSNoMessageValueNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (f569868b.c() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569869c.f569864a, r100.getValueNodeName(), 1);
    }
}
