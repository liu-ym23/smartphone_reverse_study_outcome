package i48;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f488241a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.account_saas_loading_dialog);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        WindowManager.LayoutParams r102 = r101.getAttributes();
    L6:
        if (r102 == null) goto L9;
        r102.width = -1;
        r102.height = -1;
        r102.gravity = 17;
    L9:
        if (r101 == null) goto L17;
        View r103 = r101.getDecorView();
        if (c.f346345e == false) goto L15;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == c.f346341a) goto L15;
        c.a(r104, "getDecorView");
    L15:
        if (r103 == null) goto L17;
        r103.setPadding(0, 0, 0, 0);
    L17:
        if (r101 == null) goto L19;
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        if (r101 == null) goto L21;
        r101.addFlags(Integer.MIN_VALUE);
    L21:
        if (r101 == null) goto L24;
        r101.setStatusBarColor(0);
    L24:
        if (r101 == null) goto L27;
        r101.setNavigationBarColor(0);
    L27:
        if (r101 == null) goto L30;
        r101.setDimAmount(this.f488241a);
        return;
    L30:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public a(FragmentActivity r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f488241a = r101;
        setCancelable(false);
    }
}
