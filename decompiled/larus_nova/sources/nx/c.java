package nx;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f521034a;

    public c(String r100, b r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "businessName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f521034a = r101;
    }
}
