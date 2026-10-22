package jz2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fz2.b f501167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f501168c;

    public m() {
        super("performance");
        this.f501168c = new JSONObject();
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        fz2.b r101 = this.f501167b;
        if (r101 == null) goto L5;
        JSONObject r102 = r101.toJsonObject();
    L6:
        com.bytedance.android.monitorV2.util.l.a(r100, r102);
        com.bytedance.android.monitorV2.util.l.a(r100, this.f501168c);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
