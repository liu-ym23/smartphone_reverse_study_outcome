package t39;

import com.bytedance.keva.Keva;
import com.larus.apm.api.IApmTrace;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f544459a;

    public static final class a {
    }

    static {
    }

    public final int a() {
        return ((Keva) this.f544459a.getValue()).getInt("switch_mask", -1);
    }

    public c() {
        this.f544459a = LazyKt.lazy(new b());
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (g49.e.f480009a != null) goto L5;
        return;
    L5:
        int r101 = a();
        JSONObject r102 = new JSONObject();
        r102.put("keep_alive_switch_mask", r101);
        r102.put("keep_alive_source", r100);
        IApmTrace.f286937a.c("device_status_prefs", r102);
    }

    public final void c(int r100, boolean r101) {
        if (r100 < 0) goto L18;
        if (r100 > 30) goto L18;
        int r102 = a();
        if (r102 >= 0) goto L9;
        int r103 = 0;
    L10:
        int r104 = 1 << r100;
        if (r101 == false) goto L13;
        int r105 = r104 | r103;
    L14:
        if (r102 == r105) goto L22;
        ((Keva) this.f544459a.getValue()).storeInt("switch_mask", r105);     // Catch: Exception -> L19
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r105 = (~r104) & r103;
        goto L14
    L9:
        r103 = r102;
    }
}
