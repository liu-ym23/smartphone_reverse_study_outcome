package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f558719a = null;

    static {
        f558719a = new a();
    }

    public a() {
    }

    @Override // w9.c
    public final boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((c) Annie.getService$default(c.class, null, 2, null)).handleHttpSchema(r100, r101, r102, r103);
    }

    @Override // w9.c
    public final boolean j0(Context r100, Uri r101, View r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((c) Annie.getService$default(c.class, null, 2, null)).j0(r100, r101, r102, r103);
    }

    @Override // w9.c
    public final void v1(Context r100, String r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((c) Annie.getService$default(c.class, null, 2, null)).v1(r100, r101, r102, r103);
    }
}
