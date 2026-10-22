package di9;

import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements xe6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f468863a = null;

    static {
        f468863a = new a();
    }

    public a() {
    }

    @Override // xe6.a
    public final void report(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
