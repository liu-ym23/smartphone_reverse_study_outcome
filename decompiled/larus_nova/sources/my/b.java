package my;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicCenterGetType f516350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f516351b;

    public static final class a {
    }

    static {
    }

    public final DynamicCenterGetType getType() {
        return this.f516350a;
    }

    public b(DynamicCenterGetType r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "bizId");
        this.f516350a = r100;
        this.f516351b = r102;
    }
}
