package qz2;

import com.bytedance.android.monitorV2.util.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f535313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f535314d;

    public static final class a {
    }

    static {
    }

    public e() {
        super("nativeError");
        this.f535312b = "lynx_error";
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        l.q(r100, "scene", this.f535312b);
        l.n(r100, "error_code", this.f535313c);
        l.q(r100, "error_msg", this.f535314d);
    }
}
