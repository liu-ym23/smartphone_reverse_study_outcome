package gd8;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.bmhome.chat.cell.view.MessageInboxContainerView;
import com.larus.bmhome.chat.cell.view.MessageOutboxContainerView;
import com.larus.bmhome.chat.layout.ChatListItem;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends com.bytedance.nita.api.a {

    public static final class a {
    }

    public static final class b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f480950a;

        public b() {
            this.f480950a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            v19.f.a(r100.getTheme());
            if (r102 != (-6)) goto L5;
            this.f480950a = "CHAT_MESSAGE_OUTBOX";     // Catch: Throwable -> L16
            return new MessageOutboxContainerView(r100, null);
        L5:
            if (r102 != (-5)) goto L7;
            this.f480950a = "CHAT_MESSAGE_INBOX";     // Catch: Throwable -> L16
            return new MessageInboxContainerView(r100, null);
        L7:
            if (r102 == (-1)) goto L10;
            this.f480950a = "else";     // Catch: Throwable -> L16
            return LayoutInflater.from(r100).inflate(r102, r101, false);
        L10:
            this.f480950a = "CHAT_LIST_ITEM";     // Catch: Throwable -> L16
            return new ChatListItem(r100, 0);
        L16:
            th = move-exception;
            FLogger.f375446a.e("ChatHolderNitaView", " msg=" + th.getMessage());
            JSONObject r103 = new JSONObject();
            r103.put("tag", "chat_holder_nita");
            r103.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r103.put("err_view", this.f480950a);
            o.f365780a.reportEvent("nita_preload_monitor", r103);
            com.larus.bmhome.utils.c.a("nita_preload_monitor", r103, true);
            return new View(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return new int[]{-1, -5, -6};
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "chat_holder_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public d() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
