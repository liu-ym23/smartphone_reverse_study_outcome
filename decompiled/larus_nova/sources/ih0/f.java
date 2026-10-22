package ih0;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f489769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DynamicUpdateType f489770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f489772d;

    public static final class a {
    }

    static {
    }

    public final DynamicUpdateType getType() {
        return this.f489770b;
    }

    public f(View r100, DynamicUpdateType r101, String r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "bizId");
        this.f489769a = r100;
        this.f489770b = r101;
        this.f489771c = r102;
        this.f489772d = r103;
    }
}
