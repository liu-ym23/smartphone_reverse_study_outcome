package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.session;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.ies.xelement.w;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l76.d;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/impl/plugin/mediasession/session/MediaSessionService;", "Landroidx/media/MediaBrowserServiceCompat;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public class MediaSessionService extends MediaBrowserServiceCompat {

    public static final class a {
    }

    public static class b extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSessionService f250000a;

        public b(MediaSessionService r100) {
            Intrinsics.checkNotNullParameter(r100, "mService");
            this.f250000a = r100;
        }
    }

    static {
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public final MediaBrowserServiceCompat.BrowserRoot onGetRoot(String r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "clientPackageName");
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        d r100 = d.f507797a;
        v76.a.C7969a r101 = w.f250621a;
    }

    public MediaSessionService() {
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public final IBinder onBind(Intent r100) {
        d r101 = d.f507797a;
        v76.a.C7969a r102 = w.f250621a;
        return new b(this);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r100) {
        d r101 = d.f507797a;
        v76.a.C7969a r102 = w.f250621a;
        return super.onUnbind(r100);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public final void onLoadChildren(String r100, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> r101) {
        Intrinsics.checkNotNullParameter(r100, "parentId");
        Intrinsics.checkNotNullParameter(r101, "result");
        r101.sendResult(null);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        Intent r103 = new Intent("player.plugin.mediasession.common.intent.filter.AWE_MEDIA_SESSION_BROADCAST");
        r103.putExtra("EXTRA_MEDIA_BUTTON_DATA", r100);
        LocalBroadcastManager.getInstance(this).sendBroadcast(r103);
        d r104 = d.f507797a;
        v76.a.C7969a r105 = w.f250621a;
        return super.onStartCommand(r100, r101, r102);
    }
}
