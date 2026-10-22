package u52;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends d<h> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f548801h;

    public j(k r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super("KwsEngine");
        this.f548801h = r100;
    }

    @Override // u52.d
    public final void g(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        super.g(r100, r101);
        if (r100 != 1100) goto L15;
        JSONObject r102 = new JSONObject(new String(r101, Charsets.UTF_8));     // Catch: Exception -> L9
        String r103 = JSONObjectProtectorUtils.getString(r102, "kw");     // Catch: Exception -> L9
        long r104 = r102.optLong("traceback", 0);     // Catch: Exception -> L9
        h r105 = (h) this.f548798e;     // Catch: Exception -> L9
        if (r105 == null) goto L14;
        r105.d(r103, r104);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        SafetyGuard.a("AnchorAsr parse kws result error", e, null);
        return;
    }
}
