package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562421a = 0;

    static {
    }

    public static void a(int r100, String r101, long r102) {
        if (ActivityMonitor.f64743a.booleanValue() == false) goto L9;
        HashMap r103 = new HashMap();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.put("url", r101);
        r103.put("status_code", String.valueOf(r100));
        r103.put("tti", String.valueOf(r102));
        j0.l().sendLog("banner_icon_show", r103, new Object[]{IRoom.class, x.class});
        return;
    }
}
