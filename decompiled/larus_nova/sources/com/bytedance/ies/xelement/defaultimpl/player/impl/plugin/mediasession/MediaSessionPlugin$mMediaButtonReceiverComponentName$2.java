package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession;

import android.content.ComponentName;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/ComponentName;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class MediaSessionPlugin$mMediaButtonReceiverComponentName$2 extends Lambda implements Function0<ComponentName> {
    final /* synthetic */ a this$0;

    public MediaSessionPlugin$mMediaButtonReceiverComponentName$2(a r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ComponentName invoke() {
        this.this$0.getClass();
        return new ComponentName(null, MediaSessionReceiver.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ComponentName invoke() {
        return invoke();
    }
}
