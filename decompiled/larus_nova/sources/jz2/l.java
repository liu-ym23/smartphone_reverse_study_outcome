package jz2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f501166b;

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        com.bytedance.android.monitorV2.util.l.a(r100, this.f501166b);
    }

    public l(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "data");
        super(r100);
        this.f501166b = r101;
    }
}
