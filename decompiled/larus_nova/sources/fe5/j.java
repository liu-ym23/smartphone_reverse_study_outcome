package fe5;

import android.content.Context;
import android.view.MotionEvent;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends UDSwitch {
    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return false;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
