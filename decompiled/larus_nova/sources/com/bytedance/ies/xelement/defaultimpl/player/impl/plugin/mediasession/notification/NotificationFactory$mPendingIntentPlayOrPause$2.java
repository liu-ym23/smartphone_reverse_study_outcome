package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import androidx.media.session.MediaButtonReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NotificationFactory$mPendingIntentPlayOrPause$2 extends Lambda implements Function0<PendingIntent> {
    final /* synthetic */ ComponentName $notificationReceiverComponentName;
    final /* synthetic */ c this$0;

    public NotificationFactory$mPendingIntentPlayOrPause$2(c r100, ComponentName r101) {
        this.this$0 = r100;
        this.$notificationReceiverComponentName = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PendingIntent invoke() {
        this.this$0.getClass();
        return MediaButtonReceiver.buildMediaButtonPendingIntent(null, this.$notificationReceiverComponentName, 512);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PendingIntent invoke() {
        return invoke();
    }
}
