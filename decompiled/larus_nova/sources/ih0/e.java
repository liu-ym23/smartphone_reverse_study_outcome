package ih0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicGetType f489766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f489768c;

    public static final class a {
    }

    static {
    }

    public final DynamicGetType getType() {
        return this.f489766a;
    }

    public e(DynamicGetType r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "bizId");
        this.f489766a = r100;
        this.f489767b = r101;
        this.f489768c = r102;
    }
}
