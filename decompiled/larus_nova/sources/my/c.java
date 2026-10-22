package my;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicCenterUpdateType f516352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f516353b;

    public static final class a {
    }

    static {
    }

    public final DynamicCenterUpdateType getType() {
        return this.f516352a;
    }

    public c(DynamicCenterUpdateType r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "bizId");
        this.f516352a = r100;
        this.f516353b = r102;
    }
}
