package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;
import java.util.Calendar;

/* JADX INFO: loaded from: classes22.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550423a;

    public class a implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {
        public a() {
        }

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            r100.toString();
        }
    }

    public m(ProjectActivity r100) {
        this.f550423a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ug.sdk.luckycat.impl.model.a r101 = new com.bytedance.ug.sdk.luckycat.impl.model.a();
        r101.f271391g = true;
        r101.f271389e = 2;
        r101.f271388d = 2;
        r101.f271386b = 22;
        r101.f271387c = 30;
        r101.f271385a = "测试" + System.currentTimeMillis();
        r101.f271393i = "descri";
        Calendar r102 = Calendar.getInstance();
        r102.set(5, -1);
        r102.getTime().getTime();
        r101.f271390f = r102.getTimeInMillis();
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.h(this.f550423a, r101, new a());
    }
}
