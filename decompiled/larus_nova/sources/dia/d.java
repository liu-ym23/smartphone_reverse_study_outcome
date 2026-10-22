package dia;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;
import com.larus.platform.api.g0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.view.WindowChatTitleAlignLeftStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import eia.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d extends r {

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger.f375446a.i("LandscapeTitleStrategy", "applyOrientationChange");
        g0 r100 = (g0) this.f472815e.getValue();
        if ((r100 instanceof WindowChatTitleAlignLeftStyle) == false) goto L5;
        WindowChatTitleAlignLeftStyle r101 = (WindowChatTitleAlignLeftStyle) r100;
    L6:
        if (r101 == null) goto L11;
        View r102 = r101.findViewById(R.id.window_title_gesture_bar);
        if (r102 == null) goto L12;
        e1.o(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public d(Context r100, t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
    }
}
