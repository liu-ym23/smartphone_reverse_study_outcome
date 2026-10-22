package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements c {
    public b() {
    }

    @Override // w9.c
    public final boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return false;
    }

    @Override // w9.c
    public final boolean j0(Context r100, Uri r101, View r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return false;
    }

    @Override // w9.c
    public final void v1(Context r100, String r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
