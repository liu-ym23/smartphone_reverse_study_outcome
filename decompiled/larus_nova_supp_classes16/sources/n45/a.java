package n45;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.web.CommonWebActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ CommonWebActivity a;

    public a(CommonWebActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        ConnectionService.NetworkState r7 = (ConnectionService.NetworkState) r6;
        StringBuilder r0 = new StringBuilder("onChanged: network state = ");
        BaseTitleBar r1 = null;
        if (r7 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r7.a());
    L6:
        r0.append(r2);
        tt5.a.h("CommonWebActivity", r0.toString());
        int r3 = 0;
        if (r7 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        LinearLayout r4 = this.a.f;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
        r4 = null;
    L16:
        if (r8 == false) goto L18;
        int r5 = 8;
    L19:
        r4.setVisibility(r5);
        FrameLayout r9 = this.a.g;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFrameLayout");
        r9 = null;
    L22:
        if (r8 == true) goto L25;
        r3 = 8;
    L25:
        r9.setVisibility(r3);
        if (r8 == false) goto L30;
        CommonWebActivity r10 = this.a;
        if (r8 == r10.i) goto L30;
        r10.C1().reload();
    L30:
        BaseTitleBar r11 = this.a.e;
        if (r11 == null) goto L33;
        r1 = r11;
    L34:
        r1.setMainTitleVisible(r8);
        this.a.i = r8;
        return;
    L33:
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        goto L34
    L18:
        r5 = 0;
        goto L19
    L9:
        if (r7.a() == false) goto L11;
        r8 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
