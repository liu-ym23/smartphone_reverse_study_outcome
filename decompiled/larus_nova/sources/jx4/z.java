package jx4;

import android.view.View;
import com.bytedance.ee.bear.debug.SendMemoryWarningActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: classes16.dex */
public final class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendMemoryWarningActivity f500865a;

    public z(SendMemoryWarningActivity r100) {
        this.f500865a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.share.b r101 = this.f500865a.f217358c;
        if (r101 == null) goto L5;
        r101.h(15);
    L5:
        Toast.showText(this.f500865a, "send serious memory warning: TRIM_MEMORY_RUNNING_CRITICAL");
    }
}
