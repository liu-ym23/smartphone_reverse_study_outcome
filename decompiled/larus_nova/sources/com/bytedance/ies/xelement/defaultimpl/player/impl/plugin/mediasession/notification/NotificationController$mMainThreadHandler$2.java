package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.notification;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/ies/xelement/defaultimpl/player/impl/plugin/mediasession/notification/NotificationController$mMainThreadHandler$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/ies/xelement/defaultimpl/player/impl/plugin/mediasession/notification/NotificationController$mMainThreadHandler$2$a;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class NotificationController$mMainThreadHandler$2 extends Lambda implements Function0<a> {
    final /* synthetic */ b this$0;

    public static final class a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            int r101 = r100.what;
            if (r101 != 1) goto L15;
            Object r102 = r100.obj;
            if ((r102 instanceof d) == false) goto L7;
            d r103 = (d) r102;
        L8:
            if (r103 != null) goto L10;
            return;
        L10:
            if (Build.VERSION.SDK_INT >= 33) goto L13;
            b.a(null, r103);
            return;
        L13:
            throw null;
        L7:
            r103 = null;
            goto L8
        L15:
            if (r101 != 2) goto L20;
            int r104 = b.f249989a;
            throw null;
        }

        public a(b r100, Looper r101) {
            super(r101);
        }
    }

    public NotificationController$mMainThreadHandler$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        Looper r100 = Looper.getMainLooper();
        return new a(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
