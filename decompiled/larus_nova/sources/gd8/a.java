package gd8;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: gd8.a$a, reason: collision with other inner class name */
    public static final class C6011a {
    }

    public static final class b implements com.bytedance.nita.view.b {
        public b() {
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            v19.f.a(r100.getTheme());
            View r103 = LayoutInflater.from(r100).inflate(r102, r101, false);     // Catch: Throwable -> L5
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L5
            return r103;
        L5:
            th = move-exception;
            FLogger.f375446a.e("ActionBarNormalHolderNitaView", "msg=" + th.getMessage());
            JSONObject r104 = new JSONObject();
            r104.put("tag", "action_bar_normal_holder_nita");
            r104.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            o.f365780a.reportEvent("nita_preload_monitor", r104);
            com.larus.bmhome.utils.c.a("nita_preload_monitor", r104, true);
            return new View(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return new int[]{R.layout.larus_chat_item_custom_actionbar_normal_holder};
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "action_bar_normal_holder_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public a() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
