package dia;

import android.content.Context;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import eia.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g extends o {

    public static final class a {
    }

    static {
    }

    @Override // eia.o
    public final void c(i r100) {
        Intrinsics.checkNotNullParameter(r100, "box");
        FLogger.f375446a.i("PortraitMessageListStrategy", "updateMessageBoxWidth, box: " + r100);
    }

    public g(Context r100, t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
    }
}
