package l76;

import com.bytedance.android.monitorV2.util.l;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<LynxContext> f507796c;

    public static final class a {
    }

    static {
    }

    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "category");
        LynxContext r101 = this.f507796c.get();
        if (r101 == null) goto L8;
        EventEmitter r102 = r101.getEventEmitter();
        if (r102 == null) goto L9;
        m7a.a r103 = new m7a.a(this.f507795b, "errorReport");
        r103.a("category", r100.toString());
        r102.sendCustomEvent(r103);
        return;
    L9:
        return;
    }

    public b(int r100, LynxContext r101) {
        Intrinsics.checkNotNullParameter("x_audio_error", "eventName");
        Intrinsics.checkNotNullParameter(r101, "lynxContext");
        this.f507794a = "x_audio_error";
        this.f507795b = r100;
        this.f507796c = new WeakReference(r101);
    }

    public static void a(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonOb");
        Intrinsics.checkNotNullParameter(r101, "key");
        l.q(r100, r101, r102);
    }
}
