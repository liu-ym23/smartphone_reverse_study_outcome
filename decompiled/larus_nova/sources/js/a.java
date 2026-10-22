package js;

import android.R;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500177b;

    public final Drawable a() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setCornerRadius(y0.b(8.0f));
        r100.setColor(this.f500177b);
        GradientDrawable r101 = new GradientDrawable();
        r101.setCornerRadius(y0.b(8.0f));
        r101.setColor(this.f500176a);
        Object[] r102 = CollectionsKt.listOf(new Drawable[]{r101, new ClipDrawable(r100, 3, 1)}).toArray(new Drawable[0]);
        if (r102 == null) goto L7;
        LayerDrawable r103 = new LayerDrawable((Drawable[]) r102);
        r103.setId(0, R.id.background);
        r103.setId(1, R.id.progress);
        return r103;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static String b(String r100) {
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L5;
        return r100;
    L5:
        if (r100.length() == 9) goto L7;
        return r100;
    L7:
        return ("#" + r100.subSequence(7, 9)) + r100.subSequence(1, 7);
    }

    public a(JSONObject r100, JSONObject r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        JSONObject r103 = r100.optJSONObject("button_configs");
    L7:
        if (r103 == null) goto L11;
        JSONObject r104 = r103.optJSONObject("support");
        if (r104 == null) goto L11;
        r104.optString("text");
    L11:
        if (r103 == null) goto L16;
        JSONObject r105 = r103.optJSONObject("support");
        if (r105 == null) goto L16;
        r105.optString("sub_text");
    L16:
        if (r103 == null) goto L20;
        JSONObject r106 = r103.optJSONObject("unsupport");
        if (r106 == null) goto L20;
        r106.optString("text");
    L20:
        if (r103 == null) goto L24;
        JSONObject r107 = r103.optJSONObject("open");
        if (r107 == null) goto L24;
        r107.optString("text");
    L24:
        if (r103 == null) goto L28;
        JSONObject r108 = r103.optJSONObject("install");
        if (r108 == null) goto L28;
        r108.optString("text");
    L28:
        if (r103 == null) goto L32;
        JSONObject r109 = r103.optJSONObject("update");
        if (r109 == null) goto L32;
        r109.optString("text");
    L32:
        if (r103 == null) goto L36;
        JSONObject r110 = r103.optJSONObject("downloading");
        if (r110 == null) goto L36;
        r110.optString("text");
    L36:
        if (r103 == null) goto L40;
        JSONObject r111 = r103.optJSONObject("pause");
        if (r111 == null) goto L40;
        r111.optString("text");
    L40:
        if (r103 == null) goto L44;
        JSONObject r112 = r103.optJSONObject("waitWifi");
        if (r112 == null) goto L44;
        r112.optString("text");
    L44:
        if (r103 == null) goto L48;
        JSONObject r113 = r103.optJSONObject(EventConstant.Value.RETRY);
        if (r113 == null) goto L48;
        r113.optString("text");
    L48:
        if (r101 == null) goto L54;
        JSONObject r114 = r101.optJSONObject("support");
        if (r114 == null) goto L54;
        String r115 = r114.optString("progress_color");
        if (r115 == null) goto L54;
        String r116 = b(r115);
    L55:
        this.f500176a = c(r116, "#57FE2C55");
        if (r101 == null) goto L62;
        JSONObject r117 = r101.optJSONObject("support");
        if (r117 == null) goto L62;
        String r118 = r117.optString("text_color");
        if (r118 == null) goto L62;
        String r119 = b(r118);
    L63:
        c(r119, "#FFFFFFFF");
        if (r101 == null) goto L70;
        JSONObject r120 = r101.optJSONObject("support");
        if (r120 == null) goto L70;
        String r121 = r120.optString("sub_text_color");
        if (r121 == null) goto L70;
        String r122 = b(r121);
    L71:
        c(r122, "#B2FFFFFF");
        if (r101 == null) goto L78;
        JSONObject r123 = r101.optJSONObject("support");
        if (r123 == null) goto L78;
        String r124 = r123.optString("background_color");
        if (r124 == null) goto L78;
        String r125 = b(r124);
    L79:
        this.f500177b = c(r125, "#FFFE2C55");
        if (r101 == null) goto L86;
        JSONObject r126 = r101.optJSONObject("unsupport");
        if (r126 == null) goto L86;
        String r127 = r126.optString("background_color");
        if (r127 == null) goto L86;
        String r128 = b(r127);
    L87:
        c(r128, "#0D161823");
        if (r101 == null) goto L94;
        JSONObject r129 = r101.optJSONObject("unsupport");
        if (r129 == null) goto L94;
        String r130 = r129.optString("text_color");
        if (r130 == null) goto L94;
        r102 = b(r130);
    L94:
        c(r102, "#57161823");
        return;
    L86:
        r128 = null;
    L78:
        r125 = null;
    L70:
        r122 = null;
    L62:
        r119 = null;
    L54:
        r116 = null;
        goto L55
    L5:
        r103 = null;
        goto L7
    }

    public static int c(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return ColorProtector.parseColor(r100);
    L6:
        return ColorProtector.parseColor(r101);
    }
}
