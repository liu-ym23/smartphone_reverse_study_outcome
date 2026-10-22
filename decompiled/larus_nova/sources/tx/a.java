package tx;

import kotlin.jvm.internal.Intrinsics;
import nx.b;
import nx.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends c {
    public a(String r100, JSONObject r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100, r102, "client_predict_drawer", r101);
    }
}
