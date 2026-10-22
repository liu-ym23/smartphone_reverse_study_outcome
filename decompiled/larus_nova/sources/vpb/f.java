package vpb;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.text.DecimalFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecimalFormat f556745a = null;

    static {
        f556745a = new DecimalFormat("#.#");
    }

    public static void a(String r100, IconScene r101, int r102, boolean r103, long r104, String r110) {
        JSONObject r105 = new JSONObject();
        String r106 = "";
        r105.put("BIZ_SCENE", "");
        r105.put("type", r102);
        r105.put("stage", r100);
        r105.put("success", r103 ? 1 : 0);
        DecimalFormat r107 = f556745a;
        double r108 = r104 / 1000000.0d;
        r105.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r107.format(r108));
        if (r110 == null) goto L6;
        r106 = r110;
    L6:
        r105.put("error_message", r106);
        if (r101 == null) goto L10;
        String r109 = r101.name();
        if (r109 == null) goto L10;
    L11:
        r105.put("scene", r109);
        StringBuilder r111 = new StringBuilder("reportIconLoad ");
        if (r101 == null) goto L14;
        String r112 = r101.name();
    L15:
        r111.append(r112);
        r111.append(tb2.c.DEFAULT_TEXT);
        r111.append(r103);
        r111.append(' ');
        r111.append(r107.format(r108));
        r111.append(' ');
        r111.append(r110);
        Log.d("LarkIconReport", r111.toString());
        ((o5c.b) k.a(LarkContext.getApplication(), o5c.b.class)).sendEvent("lark_icon_render_performance", r105);
        return;
    L14:
        r112 = null;
    L10:
        r109 = "UNKNOW";
        goto L11
    }
}
