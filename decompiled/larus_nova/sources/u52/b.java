package u52;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends d<f> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f548784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f548785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f548786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f548787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f548788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f548789m;

    @Override // u52.d
    public final boolean a() {
        if (this.f548785i == true) goto L5;
    L7:
        return false;
    L5:
        if (d() == false) goto L7;
        return true;
    }

    public final PolarisFileWrapper k() {
        String r100 = this.f548784h;
        if (r100 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r101 = d.c(this.f548789m.f548790a);
        if (r101 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, r100);
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("getAudioFile. name=" + r102.getName() + " exists=" + r102.exists());
        return r102;
    }

    public static Pair j(byte[] r100) {
        JSONObject r101 = new JSONObject(new String(r100, Charsets.UTF_8));     // Catch: Exception -> L11
        String r102 = r101.optString("reqid");     // Catch: Exception -> L11
        JSONArray r103 = r101.optJSONArray("result");     // Catch: Exception -> L11
        if (r103 == null) goto L8;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r103, 0);     // Catch: Exception -> L11
        if (r104 == null) goto L8;
        String r105 = JSONObjectProtectorUtils.getString(r104, "text");     // Catch: Exception -> L11
        if (r105 == null) goto L8;
    L9:
        return TuplesKt.to(r102, r105);
    L8:
        r105 = "";
    L11:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get asr result failed", e, null);
        return null;
    }

    @Override // u52.d
    public final void g(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        super.g(r100, r101);
        if (r100 != 1001) goto L5;
        this.f548784h = "recorder_" + this.f548795b + ".aac";
        return;
    L5:
        if (r100 != 1201) goto L7;
        Pair r102 = j(r101);
        if (r102 == null) goto L24;
        f r103 = (f) this.f548798e;
        if (r103 == null) goto L25;
        r103.b((String) r102.getFirst(), (String) r102.getSecond());
        return;
    L25:
        return;
    L24:
        return;
    L7:
        if (r100 != 1204) goto L27;
        Pair r104 = j(r101);
        if (r104 == null) goto L21;
        e("onComplete result " + ((String) r104.getFirst()));
        this.f548794a.set(4);
        f r105 = (f) this.f548798e;
        if (r105 == null) goto L22;
        r105.a((String) r104.getFirst(), (String) r104.getSecond());
        return;
    L22:
        return;
    L21:
        return;
    }

    public b(String r100, String r101, String r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appToken");
        Intrinsics.checkNotNullParameter(r102, "cluster");
        Intrinsics.checkNotNullParameter(r103, "config");
        super("AsrEngine");
        this.f548786j = r100;
        this.f548787k = r101;
        this.f548788l = r102;
        this.f548789m = r103;
    }
}
