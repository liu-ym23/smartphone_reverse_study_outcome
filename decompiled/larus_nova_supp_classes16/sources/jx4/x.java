package jx4;

import android.view.View;
import com.bytedance.ee.bear.debug.SendMemoryWarningActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ SendMemoryWarningActivity a;

    public x(SendMemoryWarningActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.ee.bear.share.b r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.h(5);
    L5:
        Toast.showText(this.a, "send normal memory warning: TRIM_MEMORY_RUNNING_MODERATE");
    }
}
