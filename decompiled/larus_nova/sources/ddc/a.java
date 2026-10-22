package ddc;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ova.d;

/* JADX INFO: loaded from: classes38.dex */
@AppLinkHandlerPlugin
public final class a implements pva.b {
    public a() {
    }

    @Override // pva.b
    public final Map<String, d> a(Context r100) {
        return MapsKt.mapOf(TuplesKt.to("/client/photo_picker/open", new b()));
    }
}
