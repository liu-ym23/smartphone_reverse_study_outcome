package x5c;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class a implements o5c.b {
    @Inject
    public a() {
    }

    @Override // o5c.b
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }
}
