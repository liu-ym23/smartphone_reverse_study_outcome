package th3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final int a;
    public final String b;
    public final String c;
    public String d;
    public final int e;
    public final JSONObject f;
    public final List<CartNumWithBusinessLine> g;
    public final String h;
    public final JSONObject i;

    public c(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "originData");
        this.i = r5;
        this.a = r5.optInt("status_code");
        this.b = r5.optString("msg");
        JSONObject r1 = r5.optJSONObject("data");
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.optString("cart_id");
    L6:
        this.c = r3;
        JSONObject r4 = r5.optJSONObject("data");
        if (r4 == null) goto L9;
        int r6 = r4.optInt("cart_num");
    L10:
        this.e = r6;
        JSONObject r7 = r5.optJSONObject("data");
        if (r7 == null) goto L13;
        JSONObject r8 = r7.optJSONObject("toast_bar");
    L14:
        this.f = r8;
        JSONObject r9 = r5.optJSONObject("data");     // Catch: Exception -> L21
        if (r9 == null) goto L23;
        int r10 = w0.a;     // Catch: Exception -> L21
        CartNumWithBusinessLine[] r11 = (CartNumWithBusinessLine[]) w0.b(r9.optString("cart_num_with_business_line"), CartNumWithBusinessLine[].class);     // Catch: Exception -> L21
        if (r11 == null) goto L23;
        List<CartNumWithBusinessLine> r12 = ArraysKt.toList(r11);     // Catch: Exception -> L21
    L24:
        this.g = r12;
        JSONObject r13 = this.i.optJSONObject("data");
        if (r13 == null) goto L27;
        r2 = r13.optString("after_add_jump_url");
    L27:
        this.h = r2;
        return;
    L23:
        r12 = null;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
