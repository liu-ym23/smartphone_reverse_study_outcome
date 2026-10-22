package ut1;

import am2.x;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551587a = 0;

    public static void c() {
        HashMap r100 = new HashMap();
        r100.put("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        u.l().sendLog("livesdk_user_screenshift_show", r100, new Object[]{Room.class});
    }

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        if (Intrinsics.areEqual("button", r100) == false) goto L6;
        r100 = "click";
    L8:
        HashMap r101 = new HashMap();
        r101.put("action_type", r100);
        if (e5.n() == false) goto L11;
        String r102 = "landscape";
    L12:
        r101.put("screen_direction", r102);
        u.l().sendLog("livesdk_drawer_close", r101, new Object[]{x.class});
        return;
    L11:
        r102 = "portrait";
        goto L12
    L6:
        if (Intrinsics.areEqual("draw", r100) == false) goto L8;
        r100 = "pull";
        goto L8
    }

    public static void b(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        if (Intrinsics.areEqual("button", r100) == false) goto L6;
        r100 = "click";
    L8:
        HashMap r102 = new HashMap();
        r102.put("action_type", r100);
        if (e5.n() == false) goto L11;
        String r103 = "landscape";
    L12:
        r102.put("screen_direction", r103);
        ILiveService r104 = TTLiveService.getLiveService();
        if (r104 == null) goto L18;
        ILiveOntologyInfoManager r105 = r104.getLiveOntologyRecord();
        if (r105 == null) goto L18;
        String r106 = r105.getEnterFromMerge();
        if (r106 == null) goto L18;
    L19:
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r106);
        if (r101 == null) goto L22;
        r102.putAll(r101);
    L22:
        u.l().sendLog("livesdk_drawer_entrance_click", r102, new Object[]{Room.class, x.class});
        return;
    L18:
        r106 = "";
        goto L19
    L11:
        r103 = "portrait";
        goto L12
    L6:
        if (Intrinsics.areEqual("draw", r100) == false) goto L8;
        r100 = "pull";
        goto L8
    }
}
