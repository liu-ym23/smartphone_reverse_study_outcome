package j76;

import com.facebook.keyframes.model.KFImage;
import com.lynx.tasm.base.LLog;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f497591b;

    public static final class a {
    }

    static {
    }

    public b(String r100) {
        this.f497590a = r100;
        new HashMap();
        this.f497591b = new HashMap();
    }

    public final void a(String r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (this.f497591b.containsKey(r110) == false) goto L10;
        long r100 = System.currentTimeMillis();
        Long r101 = this.f497591b.get(r110);
        if (r101 == null) goto L11;
        long r102 = r100 - r101.longValue();
        JSONObject r103 = new JSONObject();
        r103.put("resource_url", r110);
        r103.put("lottie_url", r110);
        JSONObject r104 = new JSONObject();
        r104.put(ChameleonOpenTracker.ParamKey.COST, r102);
        JSONObject r105 = new JSONObject();
        r105.put("virtual_aid", this.f497590a);
        com.bytedance.android.monitorV2.g.e().getClass();
        com.bytedance.android.monitorV2.g.b(r110, "lottie_fetch_total_cost", r103, r104, null, r105, 2);
        return;
    L11:
        return;
    }

    public final void b(String r100, String r101, String r110) {
        JSONObject r102 = new JSONObject();
        r102.put("code", "1");
        r102.put("resource_url", r101);
        r102.put("lottie_url", r100);
        r102.put("message", r110);
        JSONObject r103 = new JSONObject();
        r103.put("virtual_aid", this.f497590a);
        com.bytedance.android.monitorV2.g.e().getClass();
        com.bytedance.android.monitorV2.g.b(r100, "lottie_fetch_error", r102, null, null, r103, 2);
    }

    public final void c(String r100, String r101, Float r102, Float r103, Float r104, Float r105, Boolean r106) {
        if (Intrinsics.areEqual(r102, 0.0f) == true) goto L6;
        JSONObject r107 = new JSONObject();
        r107.put("bid", r101);
        r107.put("lottie_src", r100);
        r107.put("loop", String.valueOf(r106));
        JSONObject r108 = new JSONObject();
        r108.put(KFImage.FRAME_RATE_JSON_FIELD, r103);
        r108.put("frame_num", r104);
        r108.put("real_frame", r102);
        r108.put("ideal_time", r105);
        JSONObject r109 = new JSONObject();
        r109.put("virtual_aid", this.f497590a);
        LLog.d("byted-lottie", "lottieUrl is " + r100 + ", bid is " + r101 + ", realFrame is " + r102);
        com.bytedance.android.monitorV2.g.e().getClass();
        com.bytedance.android.monitorV2.g.b(r100, "lottie_animation_performance", r107, r108, null, r109, 2);
        return;
    }
}
