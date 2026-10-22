package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputConstantNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f569867b = null;

    static {
        f569867b = new c();
    }

    public c() {
    }

    @JvmStatic
    public static final void b(InputValueNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569867b.f569864a, r100.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(InputDescNode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "field");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.c(f569867b.f569864a, r100.getDescNodeName(), r101);
    }

    @JvmStatic
    public static final void c(InputConstantNode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "value");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.b(f569867b.f569864a, r100.getNodeName(), r101);
    }
}
