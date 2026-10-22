package uj7;

import android.app.Activity;
import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model.RedPacketModel;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550433a;

    public class a implements pi7.a {
        public a() {
        }
    }

    public w(ProjectActivity r100) {
        this.f550433a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ej7.b r101 = ej7.b.a.f472883a;
        ProjectActivity r102 = this.f550433a;
        a r103 = new a();
        r101.getClass();
        com.bytedance.ug.sdk.luckycat.impl.model.e.b(2);
        WeakReference r104 = new WeakReference(r102);
        if (r101.f472881a != null) goto L8;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r105 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.impl.manager.q r106 = com.bytedance.ug.sdk.luckycat.impl.manager.q.b.f271365a;
        if (r106.f271363h == false) goto L7;
        r101.f472881a = RedPacketModel.getDefaultModel();
        r101.a((Activity) r104.get(), "project_activity");
        return;
    L7:
        r106.f271362g = new ej7.a(r101, r104, r103);
        return;
    L8:
        r101.a((Activity) r104.get(), "project_activity");
    }
}
