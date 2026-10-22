package jz2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class n extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f501169b;

    public n() {
        super("navigationStart");
        this.f501169b = System.currentTimeMillis();
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        com.bytedance.android.monitorV2.util.l.o(r100, "invoke_ts", this.f501169b);
    }
}
