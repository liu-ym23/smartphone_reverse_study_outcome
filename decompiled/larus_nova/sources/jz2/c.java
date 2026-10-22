package jz2;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends fz2.b {
    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
    }

    public c() {
        super("containerError");
    }

    @Override // fz2.b
    public final String toString() {
        return "event_type:" + this.f479348a;
    }
}
