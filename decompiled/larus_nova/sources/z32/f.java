package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f569871b = null;

    static {
        f569871b = new f();
    }

    public f() {
    }

    @JvmStatic
    public static final void c(PSRoomStatValueNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569871b.f569864a, r100.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(PSRoomStatDescNode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "field");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.c(f569871b.f569864a, r100.getDescName(), r101);
    }

    @JvmStatic
    public static final void b(PSRoomIndicatorNode r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(f569871b.f569864a, r100.getIndicatorName(), r101);
    }

    @JvmStatic
    public static final void d(PSRoomStatValueNode r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569871b.f569864a, r100.getValueNodeName(), r101);
    }
}
