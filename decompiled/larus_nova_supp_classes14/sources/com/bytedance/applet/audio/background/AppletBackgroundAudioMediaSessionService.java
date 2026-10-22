package com.bytedance.applet.audio.background;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import aw3.h0;
import aw3.i0;
import aw3.j0;
import aw3.k0;
import aw3.l;
import aw3.o;
import aw3.p;
import aw3.q0;
import aw3.r;
import aw3.w;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0004MNOPB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u0014J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J\u0014\u00103\u001a\u000204*\u0002042\u0006\u00101\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002JZ\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u00192!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020!092%\b\u0002\u0010=\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020!\u0018\u000109H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020!H\u0002J\"\u0010@\u001a\u00020A2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0016J\f\u0010D\u001a\u00020\u0019*\u000202H\u0002J\f\u0010E\u001a\u00020\u0019*\u000202H\u0002J\f\u0010F\u001a\u00020A*\u000202H\u0002J\f\u0010G\u001a\u00020H*\u000202H\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService$BackgroundAudioServiceBinder;", "mediaSessionCallback", "Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService$BackgroundAudioMediaSessionCallback;", "mainHandler", "Landroid/os/Handler;", "delayAutoUpdateTask", "Ljava/lang/Runnable;", "playPendingIntent", "Landroid/app/PendingIntent;", "pausePendingIntent", "previousPendingIntent", "nextPendingIntent", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "isStopped", "", "isForeground", "albumArt", "Landroid/graphics/Bitmap;", "albumArtUrl", "", "emptyAlbumArt", "downloadingAlbumArtUrl", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "dismissMediaNotification", "updateMediaMetadata", "updatePlaybackState", "isAuto", "generateActionPendingIntent", "action", "initMediaSession", "releaseMediaSession", "updateNotification", "buildNotification", "Landroid/app/Notification;", "session", "state", "Lcom/bytedance/applet/audio/background/BackgroundAudioState;", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "updateAlbumArtIfNeeded", "downloadAlbumArt", "url", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "onFailure", "error", "createNotificationChannel", "onStartCommand", "", "flags", "startId", "notificationTitle", "notificationArtist", "toPlaybackStateCompat", "playbackSpeedForSystem", "", "secondsToMillis", "", "seconds", "", "Companion", "BackgroundAudioServiceBinder", "MediaSessionManageCallback", "BackgroundAudioMediaSessionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBackgroundAudioMediaSessionService extends Service {
    public static final /* synthetic */ int p = 0;
    public final b a;
    public final a b;
    public final Handler c;
    public final h0 d;
    public final PendingIntent e;
    public final PendingIntent f;
    public final PendingIntent g;
    public final PendingIntent h;
    public MediaSessionCompat i;
    public boolean j;
    public boolean k;
    public Bitmap l;
    public String m;
    public Bitmap n;
    public String o;

    public final class a extends MediaSessionCompat.Callback {
        public final void onPause() {
            super.onPause();
            w r0 = w.a;
            String r1 = w.k;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L6:
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session pause callback. dispatched: " + r2);
            return;
        L5:
            w.z(new o(r1));
            r2 = true;
            goto L6
        }

        public final void onPlay() {
            super.onPlay();
            w r0 = w.a;
            String r1 = w.k;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L6:
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session play callback. dispatched: " + r2);
            return;
        L5:
            w.z(new p(r1));
            r2 = true;
            goto L6
        }

        public final void onSkipToNext() {
            super.onSkipToNext();
            w r0 = w.a;
            final String r1 = w.k;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L6:
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session next callback. dispatched: " + r2);
            return;
        L5:
            w.z(new aw3.a(r1));
            r2 = true;
            goto L6
        }

        public final void onSkipToPrevious() {
            super.onSkipToPrevious();
            w r0 = w.a;
            final String r1 = w.k;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L6:
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session previous callback. dispatched: " + r2);
            return;
        L5:
            w.z(new r(r1));
            r2 = true;
            goto L6
        }

        public a() {
        }

        public final void onSeekTo(long r6) {
            super.onSeekTo(r6);
            w r0 = w.a;
            final String r1 = w.k;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L6:
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session seek callback. dispatched: " + r2 + ", positionMs: " + r6);
            return;
        L5:
            final double r3 = RangesKt.coerceAtLeast(r6, 0) / 1000.0d;
            w.z(new l(r3, r1));
            r2 = true;
            goto L6
        }
    }

    public final class b extends Binder {
        public final /* synthetic */ AppletBackgroundAudioMediaSessionService a;

        public b(AppletBackgroundAudioMediaSessionService r1) {
            this.a = r1;
        }
    }

    public static final class c {
    }

    public final class d implements pk9.a.a {
        public final /* synthetic */ AppletBackgroundAudioMediaSessionService a;

        public final void a() {
            this.a.c();
            this.a.b();
            this.a.b.onPause();
            FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session deactivated by global manager");
        }

        public d(AppletBackgroundAudioMediaSessionService r1) {
            this.a = r1;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BackgroundAudioPlaybackState.values().length];
            r0[BackgroundAudioPlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[BackgroundAudioPlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[BackgroundAudioPlaybackState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[BackgroundAudioPlaybackState.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.c.removeCallbacks(this.d);     // Catch: Throwable -> L10
        MediaSessionCompat r0 = this.i;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        r0.setActive(false);     // Catch: Throwable -> L10
        r0.release();     // Catch: Throwable -> L10
        pk9.a r2 = pk9.a.a;     // Catch: Throwable -> L10
        pk9.a.b.remove(r0);     // Catch: Throwable -> L10
        this.i = null;     // Catch: Throwable -> L10
        this.l = null;     // Catch: Throwable -> L10
        this.m = null;     // Catch: Throwable -> L10
        this.o = null;     // Catch: Throwable -> L10
        FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session released");     // Catch: Throwable -> L10
    L7:
        this.n = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.j == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.k == false) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        stopForeground(1);     // Catch: Throwable -> L17
    L12:
        this.k = false;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        stopForeground(true);     // Catch: Throwable -> L17
        goto L12
    }

    public final synchronized boolean l() {
        monitor-enter(this);
        boolean r0 = m(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final void stopService() {
        this.j = true;
        c();
        b();
        stopSelf();
    }

    public final boolean e() {
        if (this.j == false) goto L5;
        return false;
    L5:
        w r0 = w.a;
        if (w.o() != null) goto L8;
        return false;
    L8:
        MediaSessionCompat r1 = new MediaSessionCompat(AppHost.a.getApplication(), "AppletBackgroundAudioMediaSessionService");
        r1.setCallback(this.b);
        r1.setFlags(3);
        Bundle r2 = new Bundle();
        r2.putBoolean("HMOS_MEDIA_CONTROLLER", true);
        r1.setExtras(r2);
        this.i = r1;
        if (k() == true) goto L13;
        this.i = null;
        return false;
    L13:
        if (l() == true) goto L16;
        this.i = null;
        return false;
    L16:
        pk9.a r3 = pk9.a.a;
        pk9.a.b(r1, new d(this));
        r3.a(r1);
        FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media session initialized");
        return true;
    }

    public final synchronized void i() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.j == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        MediaSessionCompat r1 = this.i;     // Catch: Throwable -> L36
        if (r1 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        w r2 = w.a;     // Catch: Throwable -> L36
        q0 r3 = w.o();     // Catch: Throwable -> L36
        if (r3 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        int r4 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        boolean r5 = false;
        if (r4 < 26) goto L24;
        NotificationChannel r6 = new NotificationChannel("background_audio_channel", "background_audio", 2);     // Catch: Throwable -> L36
        r6.enableVibration(false);     // Catch: Throwable -> L36
        r6.setSound(null, null);     // Catch: Throwable -> L36
        NotificationManagerCompat.from(AppHost.a.getApplication()).createNotificationChannel(r6);     // Catch: Throwable -> L36
    L24:
        Notification r7 = a(r1, r3);     // Catch: Throwable -> L36
        if (r4 < 34) goto L28;
        startForeground(109, r7, 2);     // Catch: Exception -> L31 Throwable -> L36
    L29:
        FLogger.a.i("AppletBackgroundAudioMediaSessionService", "foreground notification started. state: " + r3.b());     // Catch: Exception -> L31 Throwable -> L36
        r5 = true;
    L33:
        this.k = r5;     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L28:
        startForeground(109, r7);     // Catch: Exception -> L31 Throwable -> L36
    L31:
        e = move-exception;
        FLogger.a.e("AppletBackgroundAudioMediaSessionService", "foreground notification start failed", e);     // Catch: Throwable -> L36
        goto L33
    }

    public final synchronized boolean k() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        boolean r2 = false;
        if (this.j == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        MediaSessionCompat r1 = this.i;     // Catch: Throwable -> L32
        if (r1 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        w r3 = w.a;     // Catch: Throwable -> L32
        q0 r4 = w.o();     // Catch: Throwable -> L32
        if (r4 != null) goto L17;
        monitor-exit(this);
        return false;
    L17:
        j(r4);     // Catch: Throwable -> L32
        MediaMetadataCompat.Builder r5 = new MediaMetadataCompat.Builder().putString("android.media.metadata.TITLE", g(r4)).putString("android.media.metadata.ARTIST", f(r4));     // Catch: Throwable -> L32
        String r6 = r4.c;     // Catch: Throwable -> L32
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        MediaMetadataCompat.Builder r7 = r5.putString("android.media.metadata.ALBUM", r6).putLong("android.media.metadata.DURATION", h(r4.i));     // Catch: Throwable -> L32
        Bitmap r8 = this.l;     // Catch: Throwable -> L32
        if (r8 != null) goto L25;
        r8 = this.n;     // Catch: Throwable -> L32
        if (r8 != null) goto L25;
        r8 = BitmapFactory.decodeResource(getResources(), 2131238473);     // Catch: Throwable -> L32
        this.n = r8;     // Catch: Throwable -> L32
    L25:
        r7.putBitmap("android.media.metadata.ALBUM_ART", r8);     // Catch: Throwable -> L32
        r1.setMetadata(r7.build());     // Catch: Exception -> L28 Throwable -> L32
        FLogger.a.i("AppletBackgroundAudioMediaSessionService", "media metadata updated. state: " + r4.b());     // Catch: Exception -> L28 Throwable -> L32
        r2 = true;
    L30:
        monitor-exit(this);
        return r2;
    L28:
        e = move-exception;
        FLogger.a.e("AppletBackgroundAudioMediaSessionService", "media metadata update failed", e);     // Catch: Throwable -> L32
        goto L30
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [aw3.h0] */
    public AppletBackgroundAudioMediaSessionService() {
        this.a = new b(this);
        this.b = new a();
        this.c = new Handler(Looper.getMainLooper());
        this.d = new h0(this);
        this.e = d("background_audio_play");
        this.f = d("background_audio_pause");
        this.g = d("background_audio_previous");
        this.h = d("background_audio_next");
    }

    public static PendingIntent d(String r4) {
        AppHost.Companion r1 = AppHost.a;
        Intent r0 = new Intent(r1.getApplication(), AppletBackgroundAudioMediaSessionService.class);
        r0.setAction(r4);
        Application r5 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 201326592;
    L7:
        return PendingIntent.getService(r5, 109, r0, r2);
    L5:
        r2 = 134217728;
        goto L7
    }

    public static String f(q0 r3) {
        String r0 = r3.d;
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        String r4 = r3.c;
        if (r4 != null) goto L12;
    L14:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L12:
        if ((!StringsKt.isBlank(r4)) == false) goto L14;
        r1 = r4;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public static String g(q0 r3) {
        String r0 = r3.b;
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        String r4 = r3.c;
        if (r4 != null) goto L12;
    L14:
        if (r1 != null) goto L17;
        return "豆包音频";
    L17:
        return r1;
    L12:
        if ((!StringsKt.isBlank(r4)) == false) goto L14;
        r1 = r4;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public static long h(double r3) {
        if (Double.isInfinite(r3) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        double r1 = 0.0d;
        if (r0 == false) goto L12;
        r1 = RangesKt.coerceAtLeast(r3, 0.0d);
    L12:
        return RangesKt.coerceAtLeast(MathKt.roundToLong(r1 * ((double) ECDraweeView.SQUARE)), 0);
    L5:
        if (Double.isNaN(r3) == true) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [aw3.j0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [aw3.i0] */
    public final void j(q0 r9) {
        String r10 = r9.e;
        if (r10 != null) goto L5;
    L7:
        final String r2 = null;
    L9:
        if (Intrinsics.areEqual(r2, this.m) == false) goto L14;
        if (this.l == null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r2, this.m) == true) goto L16;
        this.m = r2;
        this.l = null;
        this.o = null;
    L16:
        if (r2 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(this.o, r2) == true) goto L23;
        this.o = r2;
        final ?? r11 = new i0(r2, this);
        final ?? r0 = new j0(this, r2);
        ImageLoaderKt.o(r2, "background_audio.album_art", AppHost.a.getApplication(), new k0(r11, r2, r0), null, 112);
        return;
    L23:
        return;
    L5:
        if ((!StringsKt.isBlank(r10)) == false) goto L7;
        r2 = r10;
        goto L9
    }

    public final boolean m(boolean r19) {
        boolean r5 = false;
        if (this.j == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r4 = this.i;
        if (r4 != null) goto L8;
        return false;
    L8:
        w r6 = w.a;
        q0 r7 = w.o();
        if (r7 != null) goto L11;
        return false;
    L11:
        PlaybackStateCompat.Builder r8 = new PlaybackStateCompat.Builder();
        Bundle r9 = new Bundle();
        r9.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r10 = r8.setExtras(r9).setActions(822);
        int r11 = e.a[r7.m.ordinal()];
        int r12 = 3;
        if (r11 != 1) goto L14;
    L23:
        long r13 = h(r7.h);
        if (r7.m != BackgroundAudioPlaybackState.PLAYING) goto L42;
        Double r14 = Double.valueOf(r7.l);
        double r15 = r14.doubleValue();
        if (Double.isInfinite(r15) == false) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == true) goto L33;
    L35:
        boolean r17 = false;
    L36:
        if (r17 == true) goto L39;
        r14 = null;
    L39:
        if (r14 == null) goto L41;
        float r18 = (float) r14.doubleValue();
    L62:
        r4.setPlaybackState(r10.setState(r12, r13, r18).build());     // Catch: Exception -> L56
        if (this.k == false) goto L54;
        MediaSessionCompat r20 = this.i;     // Catch: Exception -> L56
        if (r20 == null) goto L54;
        q0 r21 = w.o();     // Catch: Exception -> L56
        if (r21 == null) goto L54;
        NotificationManagerCompat.from(AppHost.a.getApplication()).notify(109, a(r20, r21));     // Catch: Exception -> L56
    L54:
        FLogger.a.i("AppletBackgroundAudioMediaSessionService", "playback state updated. state: " + r7.b() + ", isAuto: " + r19);     // Catch: Exception -> L56
        r5 = true;
    L58:
        if (r5 == false) goto L61;
        if (r19 == true) goto L61;
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 500);
    L61:
        return r5;
    L56:
        e = move-exception;
        FLogger.a.e("AppletBackgroundAudioMediaSessionService", "playback state update failed", e);
        goto L58
    L41:
        r18 = 1.0f;
        goto L62
    L33:
        if (r15 <= 0.0d) goto L35;
        r17 = true;
        goto L36
    L28:
        if (Double.isNaN(r15) == true) goto L30;
        r16 = true;
        goto L31
    L42:
        r18 = 0.0f;
        goto L62
    L14:
        if (r11 == 2) goto L22;
        if (r11 != 3) goto L17;
        r12 = 1;
        goto L23
    L17:
        if (r11 != 4) goto L20;
        r12 = 7;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        r12 = 2;
        goto L23
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a;
    }

    public final Notification a(MediaSessionCompat r5, q0 r6) {
        NotificationCompat.MediaStyle r7 = new NotificationCompat.MediaStyle().setMediaSession(r5.getSessionToken()).setShowActionsInCompactView(new int[]{0, 1, 2});
        androidx.core.app.NotificationCompat.Builder r0 = new androidx.core.app.NotificationCompat.Builder(AppHost.a.getApplication(), "background_audio_channel").setShowWhen(false).setSound(null).setContentTitle(g(r6)).setContentText(f(r6)).setSmallIcon(2131238474).setAutoCancel(false).setOngoing(true).addAction(2131238472, "background_audio_previous", this.g);
        if (r6.m != BackgroundAudioPlaybackState.PLAYING) goto L5;
        androidx.core.app.NotificationCompat.Builder r8 = r0.addAction(2131243096, "background_audio_pause", this.f);
        Intrinsics.checkNotNull(r8);
    L6:
        androidx.core.app.NotificationCompat.Builder r9 = r8.addAction(2131238471, "background_audio_next", this.h).setStyle(r7);
        Bitmap r10 = this.l;
        if (r10 != null) goto L11;
        r10 = this.n;
        if (r10 != null) goto L11;
        r10 = BitmapFactory.decodeResource(getResources(), 2131238473);
        this.n = r10;
    L11:
        r9.setLargeIcon(r10);
        return r9.build();
    L5:
        r8 = r0.addAction(2131243099, "background_audio_play", this.e);
        Intrinsics.checkNotNull(r8);
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        if (r1 == null) goto L4;
        String r4 = r1.getAction();
    L5:
        if (r4 != null) goto L7;
        return 2;
    L7:
        switch(r4.hashCode()) {
            case -1423730575: goto L22;
            case -221263172: goto L18;
            case 2071016813: goto L14;
            case 2071082414: goto L10;
            default: goto L31;
        };
    L31:
        return 2;
    L10:
        if (r4.equals("background_audio_play") == false) goto L32;
        this.b.onPlay();
        return 2;
    L32:
        return 2;
    L14:
        if (r4.equals("background_audio_next") == false) goto L33;
        this.b.onSkipToNext();
        return 2;
    L33:
        return 2;
    L18:
        if (r4.equals("background_audio_pause") == false) goto L34;
        this.b.onPause();
        return 2;
    L34:
        return 2;
    L22:
        if (r4.equals("background_audio_previous") == false) goto L35;
        this.b.onSkipToPrevious();
        return 2;
    L35:
        return 2;
    L4:
        r4 = null;
        goto L5
    }
}
