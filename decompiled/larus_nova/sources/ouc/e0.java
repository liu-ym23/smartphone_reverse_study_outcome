package ouc;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonDslMarker;

/* JADX INFO: loaded from: classes5.dex */
@JsonDslMarker
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, i> f526831a;

    public final d0 a() {
        return new d0(this.f526831a);
    }

    public e0() {
        this.f526831a = new LinkedHashMap();
    }

    public final i b(String r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "element");
        return this.f526831a.put(r100, r101);
    }
}
