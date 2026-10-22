package ja4;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f497879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f497881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f497882d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.setContentView(this.f497881c);
        r101.setGravity(this.f497882d);
        r101.setBackgroundDrawableResource(R.color.transparent);
        r101.setFlags(131072, 131072);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.x = 0;
        r102.y = 0;
        r102.width = this.f497879a;
        r102.height = this.f497880b;
        r101.setAttributes(r102);
        return;
    }

    public f(Activity r100, int r101, int r102, View r103) {
        super(r100, com.larus.nova.R.style.microapp_i_basic_popup);
        this.f497882d = 80;
        this.f497879a = r101;
        this.f497880b = r102;
        this.f497881c = r103;
    }
}
