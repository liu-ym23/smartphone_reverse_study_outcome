package pt3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f530638a;

    public final String toString() {
        return new JSONObject(new String(this.f530638a)).toString();
    L4:
        return "";
    }

    public b(byte[] r100) {
        this.f530638a = r100;
    }
}
