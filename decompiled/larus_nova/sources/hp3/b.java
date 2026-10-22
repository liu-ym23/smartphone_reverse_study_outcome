package hp3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486385a;

    public abstract Map<String, Object> a();

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f486385a = r100;
    }
}
