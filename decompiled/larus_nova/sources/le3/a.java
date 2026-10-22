package le3;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508917a = 0;

    static {
    }

    public static JSONObject a(View r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.putOpt("promotion_id", r101);
        if (r100 != null) goto L5;
        return r102;
    L5:
        JSONObject r103 = EcomBcmTracker.c(PageFinder.via(r100), r102);
        if (r103 != null) goto L9;
        return r102;
    L9:
        return r103;
    }
}
