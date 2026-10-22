package ll0;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Function2<String, g<JsonObject, JsonObject>, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IJsBridgeManager f509666a;

    public b(IJsBridgeManager r100) {
        this.f509666a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(String r100, g<JsonObject, JsonObject> r101) {
        String r102 = r100;
        g<JsonObject, JsonObject> r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p1");
        Intrinsics.checkNotNullParameter(r103, "p2");
        this.f509666a.registerMethod(r102, r103);
        return Unit.INSTANCE;
    }
}
