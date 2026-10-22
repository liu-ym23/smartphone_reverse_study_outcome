package gd8;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f480948b = 0;

    public static final class a {
        public static Object a(String r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "block");
            long r102 = SystemClock.elapsedRealtime();
            Object r103 = r101.invoke();
            SystemClock.elapsedRealtime();
            FLogger.f375446a.i("chat_fragment_nita", "get scene[" + r100 + "], time cost=" + (SystemClock.elapsedRealtime() - r102));
            return r103;
        }
    }

    public static final class b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f480949a;

        public b() {
            this.f480949a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            v19.f.a(r100.getTheme());
            this.f480949a = "else";     // Catch: Throwable -> L11
            View r103 = LayoutInflater.from(r100).inflate(r102, r101, false);     // Catch: Throwable -> L11
            if (r102 != R.layout.larus_page_chat) goto L9;
            if (r103 == null) goto L7;
            ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.input);     // Catch: Throwable -> L11
        L8:
            InputViewCreatorDelegate.f298409b.b(r104);     // Catch: Throwable -> L11
            goto L9
        L7:
            r104 = null;
        L9:
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L11
            return r103;
        L11:
            th = move-exception;
            FLogger.f375446a.e("ChatFragmentNitaView", " msg=" + th.getMessage());
            JSONObject r105 = new JSONObject();
            r105.put("tag", "chat_fragment_nita");
            r105.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r105.put("err_view", this.f480949a);
            o.f365780a.reportEvent("nita_preload_monitor", r105);
            com.larus.bmhome.utils.c.a("nita_preload_monitor", r105, true);
            return new View(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return new int[]{R.layout.larus_page_chat};
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "chat_fragment_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public c() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
