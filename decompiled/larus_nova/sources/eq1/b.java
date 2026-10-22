package eq1;

import android.net.Uri;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.schema.helper.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import j40.x3;
import j40.y3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f473456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473457b;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> c() {
        HashMap r100 = new HashMap();
        r100.put("type", "popup");
        r100.put(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom");
        if (this.f473456a == true) goto L6;
        r100.put("horizontal_width", "375");
        r100.put("horizontal_width_percent", "0");
    L6:
        if (PadConfigUtils.c() == false) goto L9;
        r100.put("pad_use_player_bottom_height", "1");
    L13:
        if (this.f473457b == false) goto L15;
    L17:
        String r101 = "8";
    L18:
        r100.put("radius", r101);
        if (FoldScreenUtils.f() == true) goto L21;
    L23:
        return r100;
    L21:
        if (FoldScreenUtils.e() == false) goto L23;
        r100.put("use_player_bottom_height", "0");
        r100.put("pad_use_player_bottom_height", "0");
        goto L23
    L15:
        if (this.f473456a == false) goto L17;
        r101 = "0";
        goto L18
    L9:
        if (this.f473457b == false) goto L11;
        r100.put("height", "494");
        r100.put(ECFindSimilarConfig.HEIGHT_PERCENT, "0");
        r100.put("use_player_bottom_height", "0");
        goto L13
    L11:
        r100.put("use_player_bottom_height", "1");
        goto L13
    }

    public final Uri a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L26;
        ALogger.d("VSSchemaHandler", "schema is null or empty");
        return null;
    L26:
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L23
        ALogger.d("VSSchemaHandler", "previous: " + r102);     // Catch: Exception -> L23
        if (y3.f497328a.getValue().booleanValue() == true) goto L17;
        ALogger.d("VSSchemaHandler", "LIVE_VS_HANDLE_SCHEMA false");     // Catch: Exception -> L23
        return r102;
    L17:
        Iterator r103 = ((HashMap) c()).entrySet().iterator();     // Catch: Exception -> L23
    L19:
        if (r103.hasNext() == false) goto L21;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Exception -> L23
        r102 = h.b(r102, (String) r104.getKey(), (String) r104.getValue());     // Catch: Exception -> L23
        goto L19
    L21:
        ALogger.d("VSSchemaHandler", "after: " + r102);     // Catch: Exception -> L23
        return r102;
    L23:
        e = move-exception;
        ALogger.e("VSSchemaHandler", e);
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final String b(String r100) {
        if (x3.f497323a.getValue().booleanValue() == true) goto L6;
        ALogger.d("VSSchemaHandler", "LIVE_VS_BANNER_HANDLE_SCHEMA false");
        return r100;
    L6:
        Uri r101 = a(r100);
        if (r101 == null) goto L13;
        String r102 = r101.toString();
        if (r102 != null) goto L12;
        return r100;
    L12:
        return r102;
    L13:
        return r100;
    }

    public b(boolean r100, boolean r101) {
        this.f473456a = r100;
        this.f473457b = r101;
    }
}
