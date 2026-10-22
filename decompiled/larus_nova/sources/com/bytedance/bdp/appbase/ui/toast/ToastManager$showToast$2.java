package com.bytedance.bdp.appbase.ui.toast;

import android.app.Activity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class ToastManager$showToast$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WeakReference $ref;
    final /* synthetic */ com.bytedance.bdp.appbase.ui.toast.a $toast;
    final /* synthetic */ b this$0;

    public static final class a {
        public a(ToastManager$showToast$2 r100) {
        }
    }

    public ToastManager$showToast$2(b r100, WeakReference r101, com.bytedance.bdp.appbase.ui.toast.a r102) {
        this.this$0 = r100;
        this.$ref = r101;
        this.$toast = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b.a(this.this$0);
        Activity r100 = (Activity) this.$ref.get();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == false) goto L7;
        return;
    L7:
        if (r100.isDestroyed() == true) goto L13;
        this.$toast.getClass();
        this.$toast.getClass();
        this.$toast.getClass();
        com.bytedance.bdp.appbase.ui.toast.a r101 = this.$toast;
        new a(this);
        r101.getClass();
        r101.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
