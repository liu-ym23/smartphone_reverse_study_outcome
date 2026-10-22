package rz0;

import com.bytedance.android.live.revenue.platform.log.api.LogDSLMaker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@LogDSLMaker
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f539953a;

    public b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f539953a = r100;
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f539953a.put(r100, r101);
    }
}
