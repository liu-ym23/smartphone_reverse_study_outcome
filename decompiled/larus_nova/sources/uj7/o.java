package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550425a;

    public class a implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {
        public a() {
        }

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            r100.toString();
        }
    }

    public o(ProjectActivity r100) {
        this.f550425a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.i(this.f550425a, "测试", new a());
    }
}
