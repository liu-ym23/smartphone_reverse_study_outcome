package jx4;

import android.view.View;
import com.bytedance.ee.bear.debug.SendMemoryWarningActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: classes16.dex */
public final class y implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendMemoryWarningActivity f500864a;

    public y(SendMemoryWarningActivity r100) {
        this.f500864a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.share.b r101 = this.f500864a.f217358c;
        if (r101 == null) goto L5;
        r101.h(10);
    L5:
        Toast.showText(this.f500864a, "send warning memory warning: TRIM_MEMORY_RUNNING_LOW");
    }
}
