package z8a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f570965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f570966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f570967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f570968d;

    public a() {
    }

    public final String toString() {
        return "CloudMessage{mParams='" + this.f570965a + "', mType=" + this.f570966b + ", send_time=0, command_id='" + this.f570967c + "'}";
    }

    public String getType() {
        return this.f570966b;
    }
}
