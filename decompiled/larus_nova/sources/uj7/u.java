package uj7;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550432a;

    public u(ProjectActivity r100) {
        this.f550432a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Context r101 = this.f550432a.getApplicationContext();
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.r() == false) goto L5;
        String r102 = "already logged in";
    L6:
        Toast.makeText(r101, r102, 0).show();
        return;
    L5:
        r102 = "already logged out";
        goto L6
    }
}
