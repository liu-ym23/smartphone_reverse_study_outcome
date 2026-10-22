package gd8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.bmhome.view.ChatInputReply;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f480946b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: gd8.b$b, reason: collision with other inner class name */
    public static final class C6012b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f480947a;

        public C6012b() {
            this.f480947a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            v19.f.a(r100.getTheme());
            int r103 = b.f480946b;     // Catch: Throwable -> L14
            if (r102 != R.layout.larus_layout_instruction_editor_container) goto L7;
            this.f480947a = "INSTRUCTION_INPUT_EDITOR";     // Catch: Throwable -> L14
            View r104 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_instruction_editor_container, r101, false);     // Catch: Throwable -> L14
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L14
            e1.o(r104);     // Catch: Throwable -> L14
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L14
            return r104;
        L7:
            if (r102 != R.layout.larus_layout_chat_speaker) goto L10;
            this.f480947a = "CHAT_SPEAKER";     // Catch: Throwable -> L14
            View r105 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_chat_speaker, r101, false);     // Catch: Throwable -> L14
            Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L14
            return r105;
        L10:
            if (r102 != (-1)) goto L12;
            this.f480947a = "CHAT_INPUT_REPLY";     // Catch: Throwable -> L14
            return new ChatInputReply(r100, null, 6, 0);
        L12:
            this.f480947a = "else";     // Catch: Throwable -> L14
            View r106 = LayoutInflater.from(r100).inflate(r102, r101, false);     // Catch: Throwable -> L14
            Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L14
            return r106;
        L14:
            th = move-exception;
            FLogger.f375446a.e("ChatBottomNitaView", " msg=" + th.getMessage());
            JSONObject r107 = new JSONObject();
            r107.put("tag", "chat_bottom_nita");
            r107.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r107.put("err_view", this.f480947a);
            o.f365780a.reportEvent("nita_preload_monitor", r107);
            com.larus.bmhome.utils.c.a("nita_preload_monitor", r107, true);
            return new View(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return new int[]{R.layout.larus_layout_instruction_editor_container, R.layout.larus_layout_chat_speaker, -1};
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "chat_bottom_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new C6012b();
    }

    public b() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
