package ju0;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f500400a;

    public b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        this.f500400a = r100;
    }
}
