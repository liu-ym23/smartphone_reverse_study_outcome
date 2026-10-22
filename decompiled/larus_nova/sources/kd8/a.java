package kd8;

import android.view.MotionEvent;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.g;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<View.OnTouchListener> f502856a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends View.OnTouchListener> r100) {
        this.f502856a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r102 == null) goto L5;
        r102.a0();
        g r103 = g.f346177a;
    L6:
        Function0<View.OnTouchListener> r104 = this.f502856a;
        if (r104 == null) goto L12;
        View.OnTouchListener r105 = r104.invoke();
        if (r105 == null) goto L12;
        return r105.onTouch(r100, r101);
    L12:
        if (r101 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L21;
        if (r103 == null) goto L20;
        r103.a();
    L20:
        s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_chat_toast_tap_loading, false);
    L21:
        return true;
    L14:
        if (r101.getActionMasked() != 0) goto L16;
        r106 = true;
        goto L17
    L5:
        r103 = null;
        goto L6
    }
}
