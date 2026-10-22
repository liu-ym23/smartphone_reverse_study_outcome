package com.bytedance.bdp.appbase.ui.toast;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class ToastManager$showToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WeakReference $activityRef;
    final /* synthetic */ Context $appContext;
    final /* synthetic */ BdpAppContext $bdpAppContext;
    final /* synthetic */ BdpToastService.a $callback;
    final /* synthetic */ ViewGroup $containerView;
    final /* synthetic */ long $duration;
    final /* synthetic */ String $icon;
    final /* synthetic */ String $image;
    final /* synthetic */ boolean $mask;
    final /* synthetic */ CharSequence $text;
    final /* synthetic */ boolean $useCustomToast;
    final /* synthetic */ b this$0;

    public ToastManager$showToast$1(b r100, boolean r101, BdpAppContext r102, long r103, Context r104, CharSequence r105, BdpToastService.a r106, WeakReference r107, String r110, String r111, boolean r112, ViewGroup r113) {
        this.this$0 = r100;
        this.$useCustomToast = r101;
        this.$bdpAppContext = r102;
        this.$duration = r103;
        this.$appContext = r104;
        this.$text = r105;
        this.$callback = r106;
        this.$activityRef = r107;
        this.$icon = r110;
        this.$image = r111;
        this.$mask = r112;
        this.$containerView = r113;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$useCustomToast == true) goto L5;
    L19:
        int r100 = 1;
        if (((int) this.$duration) == 1) goto L23;
        r100 = 0;
    L23:
        Toast.makeText(this.$appContext, this.$text, r100).show();
        BdpToastService.a r101 = this.$callback;
        if (r101 == null) goto L30;
        r101.onSucceed();
        return;
    L30:
        return;
    L5:
        if (this.$bdpAppContext == null) goto L19;
        b.a(this.this$0);
        WeakReference r102 = this.$activityRef;
        if (r102 == null) goto L10;
        Activity r103 = (Activity) r102.get();
    L11:
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.isFinishing() == false) goto L15;
        return;
    L15:
        if (r103.isDestroyed() == true) goto L28;
        ((BdpToastService) this.$bdpAppContext.c(BdpToastService.class)).a();
        return;
    L28:
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
