package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/impl/plugin/mediasession/MediaSessionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final class MediaSessionReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public MediaSessionReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r100 == null) goto L5;
        Intent r102 = new Intent("intent.filter.X_ELEMENT_X_AUDIO_MEDIA_SESSION_BROADCAST");
        r102.putExtra("EXTRA_MEDIA_BUTTON_DATA", r101);
        LocalBroadcastManager.getInstance(r100).sendBroadcast(r102);
        return;
    }
}
