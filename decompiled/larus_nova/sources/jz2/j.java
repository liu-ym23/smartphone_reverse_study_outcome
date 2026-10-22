package jz2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f501158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f501159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f501160d;

    public j() {
        super("jsbError");
    }

    @Override // fz2.b
    public final String toString() {
        return "JsbErrorData(isSync=0, errorCode=" + this.f501158b + ", errorMessage=" + this.f501159c + ", bridgeName=" + this.f501160d + ", errorActivity=null, protocol=null)";
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        com.bytedance.android.monitorV2.util.l.n(r100, "is_sync", 0);
        com.bytedance.android.monitorV2.util.l.n(r100, "error_code", this.f501158b);
        com.bytedance.android.monitorV2.util.l.q(r100, "error_message", this.f501159c);
        com.bytedance.android.monitorV2.util.l.q(r100, "bridge_name", this.f501160d);
        com.bytedance.android.monitorV2.util.l.q(r100, "error_activity", null);
        com.bytedance.android.monitorV2.util.l.q(r100, "protocol_version", null);
    }
}
