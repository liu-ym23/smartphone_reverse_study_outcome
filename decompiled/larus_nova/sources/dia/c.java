package dia;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import eia.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c extends o {

    public static final class a {
    }

    static {
    }

    @Override // eia.o
    public final void c(i r100) {
        Intrinsics.checkNotNullParameter(r100, "box");
        FLogger r101 = FLogger.f375446a;
        r101.i("LandscapeMessageListStrategy", "updateMessageBoxWidth");
        View r102 = r100.getRootView();
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getWidth());
    L6:
        Resources r104 = r100.getResources();
        if (r104 == null) goto L11;
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        if (r105 == null) goto L11;
        int r106 = r105.widthPixels;
    L12:
        if (r103 == null) goto L25;
        if (r106 <= 0) goto L27;
        int r107 = r106 - r103.intValue();
        int r108 = r100.getMaxWidth();
        r101.i("LandscapeMessageListStrategy", "currentMaxWidth: " + r108 + ", rootWidth: " + r103 + ", widthDelta: " + r107 + ", screenWidth: " + r106);
        if (r108 >= r103.intValue()) goto L18;
        int r109 = r108;
    L22:
        if (r108 == r109) goto L26;
        r100.setMaxWidth(r109);
        return;
    L26:
        return;
    L18:
        if (r108 >= r107) goto L20;
        r109 = r108;
    L21:
        r101.i("LandscapeMessageListStrategy", "targetMaxWidth: " + r109);
        goto L22
    L20:
        r109 = r108 - r107;
        goto L21
    L27:
        return;
    L25:
        return;
    L11:
        r106 = 0;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public c(Context r100, t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
    }
}
