package mm9;

import android.content.Context;
import com.larus.bmhome.chat.nita.IChatNitaPreloadService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements com.bytedance.nita.api.b {
    public n() {
    }

    public static void g(int r100) {
        IChatNitaPreloadService r101 = (IChatNitaPreloadService) ServiceManager.get().getService(IChatNitaPreloadService.class);
        if (r100 == R.layout.larus_page_chat) goto L9;
        if (r101 == null) goto L8;
        r101.a(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.nita.api.b
    public final void d(com.bytedance.nita.api.c r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "nitaView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Objects.toString(r100);
    }

    @Override // com.bytedance.nita.api.b
    public final void a(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "viewTag");
        Intrinsics.checkNotNullParameter(r102, "action");
        g(r101);
    }

    @Override // com.bytedance.nita.api.b
    public final void b(com.bytedance.nita.api.c r100, Exception r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "nitaView");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Objects.toString(r100);
        Objects.toString(r101);
    }

    @Override // com.bytedance.nita.api.b
    public final void c(com.bytedance.nita.api.c r100, int r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "nitaView");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Objects.toString(r100);
        g(r101);
    }

    public final void f(com.bytedance.nita.api.c r100, int r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "nitaView");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Objects.toString(r100);
        g(r101);
    }

    @Override // com.bytedance.nita.api.b
    public final void e(long r100, com.bytedance.nita.api.c r101, int r102, Context r103) {
        f(r101, r102, r103);
    }
}
