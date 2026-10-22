package wib;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.HashMap;
import java.util.Map;
import ova.d;

/* JADX INFO: loaded from: classes36.dex */
@AppLinkHandlerPlugin
public final class a implements pva.b {
    public a() {
    }

    @Override // pva.b
    public final Map<String, d> a(Context r100) {
        HashMap r101 = new HashMap();
        r101.put("/client/forward/share_text", new b());
        return r101;
    }
}
