package l74;

import android.text.TextUtils;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public c() {
    }

    public abstract JSONObject a();

    public abstract void c();

    public final void b(o0 r100, String r101) {
        JSONObject r102 = a();
        c0 r103 = r100.E;
        if (r103 == null) goto L11;
        ((nw3.c) r103).a(r101, r102);
        if (TextUtils.isEmpty(r101) == true) goto L7;
        t.a("EventTracking# " + r101 + r100.f199728a + ", " + r102);
    L7:
        c();
        if (TextUtils.isEmpty(r101) == true) goto L12;
        t.a("EventTracking# " + r101 + r100.f199728a + " reset.");
        return;
    L12:
        return;
    }
}
