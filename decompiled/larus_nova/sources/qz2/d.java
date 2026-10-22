package qz2;

import com.bytedance.android.monitorV2.util.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends fz2.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f535304h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f535305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f535306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f535307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f535308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f535309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f535310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f535311g;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f535311g = -1;
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        l.o(r100, "load_start", this.f535305a);
        l.o(r100, "load_finish", this.f535306b);
        l.o(r100, "load_failed", 0);
        l.o(r100, "show_start", this.f535307c);
        l.o(r100, "show_end", this.f535308d);
        l.o(r100, "receive_error", 0);
        l.o(r100, "first_screen", this.f535309e);
        l.o(r100, "runtime_ready", this.f535310f);
    }
}
