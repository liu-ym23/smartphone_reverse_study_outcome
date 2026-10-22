package z60;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f570440a;

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "updateStrategy");
        this.f570440a = r100;
    }

    public final boolean update(JsonObject r100, JsonObject r101, c70.a r102) {
        return this.f570440a.update(r100, r101, r102);
    }
}
