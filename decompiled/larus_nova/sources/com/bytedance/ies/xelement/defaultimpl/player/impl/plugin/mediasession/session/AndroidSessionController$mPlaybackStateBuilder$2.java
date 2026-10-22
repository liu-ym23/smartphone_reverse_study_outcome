package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.session;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/support/v4/media/session/PlaybackStateCompat$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AndroidSessionController$mPlaybackStateBuilder$2 extends Lambda implements Function0<PlaybackStateCompat.Builder> {
    public static final AndroidSessionController$mPlaybackStateBuilder$2 INSTANCE = null;

    static {
        INSTANCE = new AndroidSessionController$mPlaybackStateBuilder$2();
    }

    public AndroidSessionController$mPlaybackStateBuilder$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PlaybackStateCompat.Builder invoke() {
        return new PlaybackStateCompat.Builder();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PlaybackStateCompat.Builder invoke() {
        return invoke();
    }
}
