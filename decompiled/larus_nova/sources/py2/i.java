package py2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f531004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f531006d;

    public i() {
        super("jsbError");
    }

    public final String toString() {
        return "JsbErrorData(isSync=0, errorCode=" + this.f531004b + ", errorMessage=" + this.f531005c + ", bridgeName=" + this.f531006d + ", errorActivity=null, protocol=null)";
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.f(r100, "is_sync", 0);
        bz2.e.f(r100, "error_code", this.f531004b);
        bz2.e.i(r100, "error_message", this.f531005c);
        bz2.e.i(r100, "bridge_name", this.f531006d);
        bz2.e.i(r100, "error_activity", null);
        bz2.e.i(r100, "protocol_version", null);
    }
}
