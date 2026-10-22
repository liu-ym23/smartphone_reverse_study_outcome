package lp2;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510205a = 0;

    static {
    }

    public static void a(com.bytedance.android.live.base.model.push.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pushMessage");
        Intrinsics.checkNotNullParameter(r101, "actType");
        HashMap r102 = new HashMap();
        String r103 = r100.getScene();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("business_scene", r103);
        r102.put("action_type", r101);
        j0.l().sendLog("livesdk_live_common_inner_push", r102, new Object[]{x.class, Room.class});
    }
}
