package q74;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends p74.a {
    @Override // p74.a
    public final String b() {
        return "d_b0";
    }

    @Override // p74.a
    public final String c() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    public b(JSONObject r100) {
        super(r100);
    }
}
