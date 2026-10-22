package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/base/ui/viewwindow/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ViewWindowRoot$1 extends Lambda implements Function1<Context, Unit> {
    final /* synthetic */ g this$0;

    public ViewWindowRoot$1(g r100) {
        this.this$0 = r100;
        super(1);
    }

    public static View INVOKEVIRTUAL_com_bytedance_bdp_appbase_base_ui_viewwindow_ViewWindowRoot$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context r100) {
        if (this.this$0.getActivity() == null) goto L25;
        this.this$0.getClass();
        Activity r101 = this.this$0.getActivity();
        if (r101 == null) goto L9;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        View r103 = INVOKEVIRTUAL_com_bytedance_bdp_appbase_base_ui_viewwindow_ViewWindowRoot$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102);
    L10:
        ViewGroup r104 = null;
    L12:
        if ((r104 instanceof ViewGroup) == false) goto L19;
        if (r104 == r103) goto L14;
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == true) goto L18;
        r105 = null;
    L18:
        r104 = (ViewGroup) r105;
        goto L12
    L14:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        return;
    L23:
        throw new RuntimeException("Activity and container not match.");
    L19:
        r106 = false;
    L9:
        r103 = null;
        goto L10
    L25:
        throw new RuntimeException("Must call bindActivity before adding container to the view hierarchy.");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Context r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
