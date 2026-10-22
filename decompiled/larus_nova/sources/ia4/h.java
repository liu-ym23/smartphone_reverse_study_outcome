package ia4;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f488911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f488912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f488913c;

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.gravity = 17;
        r101.width = -2;
        r101.height = -2;
        r100.setAttributes(r101);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        a(getWindow()).setPadding(0, 0, 0, 0);
        a(getWindow()).setBackground(null);
        setContentView(R.layout.bdp_layout_loading);
        ImageView r101 = (ImageView) findViewById(R.id.bdp_icon);
        this.f488911a = (ProgressBar) findViewById(R.id.bdp_loading_progress);
        this.f488912b = (TextView) findViewById(R.id.bdp_text);
        this.f488911a.setVisibility(0);
        this.f488912b.setText(this.f488913c);
    }

    public h(Context r100, String r101) {
        super(r100);
        this.f488913c = r101;
    }
}
