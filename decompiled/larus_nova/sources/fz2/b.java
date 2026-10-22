package fz2;

import com.bytedance.android.monitorV2.util.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f479348a;

    public String toString() {
        return "BaseNativeInfo{eventType='" + this.f479348a + "'}";
    }

    @Override // fz2.a
    public final JSONObject toJsonObject() {
        JSONObject r100 = super.toJsonObject();
        l.q(r100, "event_type", this.f479348a);
        return r100;
    }

    public b(String r100) {
        this.f479348a = r100;
    }
}
