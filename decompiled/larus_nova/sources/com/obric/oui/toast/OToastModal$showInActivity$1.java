package com.obric.oui.toast;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInActivity$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ Activity $activity;

    public OToastModal$showInActivity$1(Activity r100) {
        this.$activity = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        Activity r100 = this.$activity;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isFinishing() == false) goto L7;
        return null;
    L7:
        if (this.$activity.isDestroyed() == true) goto L20;
        Window r101 = this.$activity.getWindow();
        if (r101 != null) goto L12;
        View r102 = null;
    L14:
        if ((r102 instanceof ViewGroup) == true) goto L16;
        return null;
    L16:
        return (ViewGroup) r102;
    L12:
        r102 = INVOKEVIRTUAL_com_obric_oui_toast_OToastModal$showInActivity$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
        goto L14
    L20:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }

    public static View INVOKEVIRTUAL_com_obric_oui_toast_OToastModal$showInActivity$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }
}
