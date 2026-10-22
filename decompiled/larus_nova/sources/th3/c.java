package th3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f545928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f545930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f545931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f545933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<CartNumWithBusinessLine> f545934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f545935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f545936i;

    public c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "originData");
        this.f545936i = r100;
        this.f545928a = r100.optInt("status_code");
        this.f545929b = r100.optString("msg");
        JSONObject r101 = r100.optJSONObject("data");
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.optString("cart_id");
    L6:
        this.f545930c = r103;
        JSONObject r104 = r100.optJSONObject("data");
        if (r104 == null) goto L9;
        int r105 = r104.optInt("cart_num");
    L10:
        this.f545932e = r105;
        JSONObject r106 = r100.optJSONObject("data");
        if (r106 == null) goto L13;
        JSONObject r107 = r106.optJSONObject("toast_bar");
    L14:
        this.f545933f = r107;
        JSONObject r108 = r100.optJSONObject("data");     // Catch: Exception -> L21
        if (r108 == null) goto L23;
        int r109 = w0.f45736a;     // Catch: Exception -> L21
        CartNumWithBusinessLine[] r110 = (CartNumWithBusinessLine[]) w0.b(r108.optString("cart_num_with_business_line"), CartNumWithBusinessLine[].class);     // Catch: Exception -> L21
        if (r110 == null) goto L23;
        List<CartNumWithBusinessLine> r111 = ArraysKt.toList(r110);     // Catch: Exception -> L21
    L24:
        this.f545934g = r111;
        JSONObject r112 = this.f545936i.optJSONObject("data");
        if (r112 == null) goto L27;
        r102 = r112.optString("after_add_jump_url");
    L27:
        this.f545935h = r102;
        return;
    L23:
        r111 = null;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
