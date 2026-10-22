package et8;

import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.view.chatinput.InputKeyboardIconPopupMenu;
import com.skydoves.balloon.Balloon;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputKeyboardIconPopupMenu f473949a;

    public k(InputKeyboardIconPopupMenu r100) {
        this.f473949a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.getActionMasked() != 4) goto L10;
        Balloon r102 = this.f473949a.f316870b;
        if (r102 == null) goto L7;
        r102.h();
    L7:
        Balloon r103 = this.f473949a.f316871c;
        if (r103 == null) goto L10;
        r103.h();
    L10:
        return false;
    }
}
