package uj7;

import android.view.View;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550415a;

    public d(ProjectActivity r100) {
        this.f550415a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ti7.e r101 = new ti7.e();
        r101.f546234a = 1;
        r101.f546235b = true;
        r101.f546237d = true;
        r101.f546236c = true;
        r101.f546238e = false;
        r101.f546239f = "black";
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.v(this.f550415a, r101.a(), PrefetchTiming.JSB);
    }
}
