package ns;

import bw.j;
import com.bytedance.android.gamecp.business.download.predownload.ResQueryReason;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f520281a = 0;

    public b() {
    }

    static {
    }

    public static void a(boolean r100, String r101, ResQueryReason r102, Map r103) {
        Intrinsics.checkNotNullParameter(r102, "queryReason");
        Intrinsics.checkNotNullParameter(r103, "eventMap");
        j r104 = com.bytedance.android.gamecp.host_api.a.b().getLogService();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.put("game_id", r101);
        r103.put("fail_reason", String.valueOf(r102.getFailureCode()));
        if (r100 == false) goto L8;
        String r105 = "success";
    L9:
        r103.put("result", r105);
        r103.put("product_type", BaseConstants.GAME_INFO_LIVE_UNION);
        r103.put("biz_type", "douyingame");
        Unit r106 = Unit.INSTANCE;
        r104.logV3("pre_download_resource_queryed", r103);
        return;
    L8:
        r105 = "fail";
        goto L9
    }
}
