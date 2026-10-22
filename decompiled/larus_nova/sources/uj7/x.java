package uj7;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f550434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Button f550435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550436c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f550434a == true) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.o();
        Toast.makeText(this.f550436c.getApplicationContext(), "not support", 0).show();
        return;
    L6:
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.o();
        this.f550435b.setText("pedometer closed");
        this.f550434a = !this.f550434a;
    }

    public x(ProjectActivity r100, Button r101) {
        this.f550436c = r100;
        this.f550435b = r101;
        this.f550434a = false;
    }
}
