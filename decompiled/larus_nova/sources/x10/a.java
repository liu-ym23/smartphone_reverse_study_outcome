package x10;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562101a = 0;

    /* JADX INFO: renamed from: x10.a$a, reason: collision with other inner class name */
    public static final class C8179a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f562102a;

        /* JADX INFO: renamed from: x10.a$a$a, reason: collision with other inner class name */
        public static final class C8180a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final HashMap<String, String> f562103a;

            public C8180a(String r100) {
                Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
                HashMap<String, String> r101 = new HashMap();
                this.f562103a = r101;
                r101.put("action_type", r100);
            }

            public final void a(String r100) {
                this.f562103a.put("param1", r100);
            }
        }

        public final void a() {
            int r100 = a.f562101a;
            Intrinsics.checkNotNullParameter(this, "event");
            Map<String, String> r101 = this.f562102a;
            IUserService r102 = (IUserService) k.f(IUserService.class);
            if (r102 == null) goto L7;
            com.bytedance.android.livesdk.user.f r103 = r102.user();
            if (r103 == null) goto L7;
            String r104 = r103.n();
        L8:
            ((HashMap) r101).put("user_id", r104);
            u.l().sendLog("livesdk_game_common_event", this.f562102a, new Object[]{Room.class});
            return;
        L7:
            r104 = null;
            goto L8
        }

        public C8179a(C8180a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.f562102a = r100.f562103a;
        }
    }

    static {
    }

    public static C8179a.C8180a a(PluginContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        C8179a.C8180a r102 = new C8179a.C8180a(r101);
        String r103 = r100.f60809m.b(r100.f60811o);
        r102.f562103a.put(EventConstants.ExtraJson.GAME_NAME, r103);
        String r104 = r100.f60809m.f61083i;
        r102.f562103a.put("app_id", r104);
        String r105 = String.valueOf(r100.f60809m.f61082h);
        r102.f562103a.put("game_id", r105);
        if (r100.f60811o == false) goto L5;
        String r106 = "0";
    L6:
        r102.f562103a.put("is_from_audience", r106);
        return r102;
    L5:
        r106 = "1";
        goto L6
    }
}
