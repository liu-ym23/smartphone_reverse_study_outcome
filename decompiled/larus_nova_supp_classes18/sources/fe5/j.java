package fe5;

import android.content.Context;
import android.view.MotionEvent;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends UDSwitch {
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return false;
    }

    public j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
