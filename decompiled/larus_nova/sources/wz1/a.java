package wz1;

import com.bytedance.android.livesdk.gift.model.k2;
import com.bytedance.android.scope.o;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, JsonObject> f561901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f561902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Long, ? extends k2> f561903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f561904d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a() {
        this.f561901a = new LinkedHashMap();
        this.f561903c = MapsKt.emptyMap();
    }
}
