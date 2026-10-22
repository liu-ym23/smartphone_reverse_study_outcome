package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Build;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/PendingIntent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NotificationFactory$mPendingClickNotificationIntent$2 extends Lambda implements Function0<PendingIntent> {
    final /* synthetic */ ComponentName $notificationReceiverComponentName;
    final /* synthetic */ c this$0;

    public NotificationFactory$mPendingClickNotificationIntent$2(c r100, ComponentName r101) {
        this.this$0 = r100;
        this.$notificationReceiverComponentName = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PendingIntent invoke() {
        if (Build.VERSION.SDK_INT >= 31) goto L6;
        c r100 = this.this$0;
        ComponentName r101 = this.$notificationReceiverComponentName;
        int r102 = c.f249992a;
        return r100.a(r101);
    L6:
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PendingIntent invoke() {
        return invoke();
    }
}
