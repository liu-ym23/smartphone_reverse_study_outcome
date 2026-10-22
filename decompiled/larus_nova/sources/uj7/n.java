package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550424a;

    public class a implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {
        public a() {
        }

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            r100.toString();
        }
    }

    public n(ProjectActivity r100) {
        this.f550424a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.j(this.f550424a, "测试", new a(), false);
    }
}
