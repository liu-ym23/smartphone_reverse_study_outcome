package sl6;

import com.bytedance.ies.commerce.common_utils.event.EventCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class e implements at6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f542472a = null;

    static {
        f542472a = new e();
    }

    public e() {
    }

    @Override // at6.d
    public final void a(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "targetId");
        EventCenter.a(r101, r100, r102);
    }
}
