package com.bytedance.ee.bear.tts.media;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.Npth;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0006DEFGHIB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\u0014\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u00060\rR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0018\u00010\u0018R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/tts/media/TtsMediaService;", "Landroid/app/Service;", "<init>", "()V", "actionReceiver", "Landroid/content/BroadcastReceiver;", "getActionReceiver", "()Landroid/content/BroadcastReceiver;", "actionReceiver$delegate", "Lkotlin/Lazy;", "actionReceiverFilter", "Landroid/content/IntentFilter;", "phoneCallObserver", "Lcom/bytedance/ee/bear/tts/media/TtsMediaService$PhoneCallObserver;", "getPhoneCallObserver", "()Lcom/bytedance/ee/bear/tts/media/TtsMediaService$PhoneCallObserver;", "phoneCallObserver$delegate", "notificationId", "", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "binder", "Lcom/bytedance/ee/bear/tts/media/TtsMediaService$RemoteBinder;", "lastMediaBean", "Lcom/bytedance/ee/bear/tts/media/TtsMediaBean;", "lastNotification", "Landroid/app/Notification;", "defaultCoverBitmap", "Landroid/graphics/Bitmap;", "getDefaultCoverBitmap", "()Landroid/graphics/Bitmap;", "defaultCoverBitmap$delegate", "docCoverBitmap", "loadingCoverJob", "Lkotlinx/coroutines/Job;", "onCreate", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "unbindService", "conn", "Landroid/content/ServiceConnection;", "onStartCommand", "flags", "startId", "onDestroy", "initActionReceiver", "destroyActionReceiver", "initCallingObserver", "destroyCallingObserver", "initSession", "initController", "initBinder", "initNotificationChannel", "startForeground", "updateNotificationMetadata", "updateNotificationUI", "updateNotificationState", "updateNotificationCoverBitmap", "removeNotification", "createNotification", "convertRemoteState", "ttsState", "Lcom/bytedance/ee/bear/middleground/drive/export/player/IPlayer$State;", "Companion", "IRemoteListener", "RemoteBinder", "MediaSessionCallback", "MediaActionReceiver", "PhoneCallObserver", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsMediaService extends Service {
    public static final int l = 0;
    public final Lazy a;
    public final IntentFilter b;
    public final Lazy c;
    public final int d;
    public MediaSessionCompat e;
    public f f;
    public com.bytedance.ee.bear.tts.media.a g;
    public Notification h;
    public final Lazy i;
    public Bitmap j;
    public Job k;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        void d(long r1);

        void e();
    }

    public final class c extends BroadcastReceiver {
        public final /* synthetic */ TtsMediaService a;

        public static final class a implements Runnable {
            public final /* synthetic */ TtsMediaService a;
            public final /* synthetic */ TtsMediaRemoteAction b;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.TtsMediaService$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0191a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[TtsMediaRemoteAction.values().length];
                    r0[TtsMediaRemoteAction.RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[TtsMediaRemoteAction.PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[TtsMediaRemoteAction.PREVIOUS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[TtsMediaRemoteAction.NEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public a(TtsMediaService r1, c r2, TtsMediaRemoteAction r3) {
                this.a = r1;
                this.b = r3;
            }

            public final void a() {
                f r0 = this.a.f;
                if (r0 == null) goto L21;
                b r1 = r0.a;
                if (r1 == null) goto L21;
                int r2 = C0191a.a[this.b.ordinal()];
                if (r2 != 1) goto L10;
                r1.e();
                return;
            L10:
                if (r2 != 2) goto L12;
                r1.b();
                return;
            L12:
                if (r2 != 3) goto L14;
                r1.c();
                return;
            L14:
                if (r2 == 4) goto L16;
                tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, remoteAction not handled: " + this.b);
                return;
            L16:
                r1.a();
                return;
            L21:
                tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, remoteListener is null, not bound.");
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(TtsMediaService r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r4, Intent r5) {
            if (r5 == null) goto L13;
            String r0 = r5.getAction();
            if (r0 == null) goto L13;
            TtsMediaRemoteAction.Companion.getClass();
            TtsMediaRemoteAction r1 = TtsMediaRemoteAction.a.a(r0);
            if (r1 != null) goto L11;
            tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, remoteAction not supported: " + r0 + ", intent: " + r5);
            return;
        L11:
            com.bytedance.ee.util.ui.j.c(new a(this.a, this, r1));
            return;
        L13:
            tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, intentAction is null or empty, intent: " + r5);
        }
    }

    public final class d extends MediaSessionCompat.Callback {
        public final /* synthetic */ TtsMediaService a;

        public static final class a implements Runnable {
            public final /* synthetic */ TtsMediaService a;

            public a(TtsMediaService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r0 = this.a.f;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                b r1 = r0.a;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.b();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ TtsMediaService a;

            public b(TtsMediaService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r0 = this.a.f;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                b r1 = r0.a;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.e();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ TtsMediaService a;
            public final /* synthetic */ long b;

            public c(TtsMediaService r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r0 = this.a.f;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                b r1 = r0.a;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.d(this.b);     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.TtsMediaService$d$d, reason: collision with other inner class name */
        public static final class RunnableC0192d implements Runnable {
            public final /* synthetic */ TtsMediaService a;

            public RunnableC0192d(TtsMediaService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r0 = this.a.f;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                b r1 = r0.a;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.a();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public static final class e implements Runnable {
            public final /* synthetic */ TtsMediaService a;

            public e(TtsMediaService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r0 = this.a.f;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                b r1 = r0.a;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.c();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public final void onPause() {
            com.bytedance.ee.util.ui.j.f(new a(this.a));
        }

        public final void onPlay() {
            com.bytedance.ee.util.ui.j.f(new b(this.a));
        }

        public final void onSkipToNext() {
            com.bytedance.ee.util.ui.j.f(new RunnableC0192d(this.a));
        }

        public final void onSkipToPrevious() {
            com.bytedance.ee.util.ui.j.f(new e(this.a));
        }

        public d(TtsMediaService r1) {
            this.a = r1;
        }

        public final void onSeekTo(long r3) {
            com.bytedance.ee.util.ui.j.f(new c(this.a, r3));
        }
    }

    public final class e implements ewa.b {
        public final ewa.a a;
        public boolean b;
        public String c;
        public final /* synthetic */ TtsMediaService d;

        public e(TtsMediaService r2) {
            this.d = r2;
            this.a = new ewa.a(r2);
        }

        public final void a(boolean r5) {
            if (this.b != r5) goto L5;
            return;
        L5:
            this.b = r5;
            String r0 = null;
            if (r5 == false) goto L18;
            f r6 = this.d.f;
            if (r6 == null) goto L16;
            b r7 = r6.a;
            if (r7 == null) goto L16;
            tt5.a.h("TtsMediaService", "CallingObserver-onCallStateChanged, Calling started, pause.");
            r7.b();
            com.bytedance.ee.bear.tts.media.a r8 = this.d.g;
            if (r8 == null) goto L15;
            r0 = r8.a;
        L15:
            this.c = r0;
            return;
        L16:
            tt5.a.k("TtsMediaService", "CallingObserver-onCallStateChanged, calling started but remoteListener is null.");
            return;
        L18:
            f r9 = this.d.f;
            if (r9 == null) goto L39;
            b r10 = r9.a;
            if (r10 == null) goto L39;
            String r2 = this.c;
            if (r2 != null) goto L26;
        L29:
            boolean r3 = true;
        L30:
            if (r3 == true) goto L42;
            String r4 = this.c;
            com.bytedance.ee.bear.tts.media.a r11 = this.d.g;
            if (r11 == null) goto L34;
            String r12 = r11.a;
        L36:
            if (Intrinsics.areEqual(r4, r12) == false) goto L43;
            tt5.a.h("TtsMediaService", "CallingObserver-onCallStateChanged, Calling finished, resume.");
            r10.e();
            this.c = null;
            return;
        L43:
            return;
        L34:
            r12 = null;
            goto L36
        L42:
            return;
        L26:
            if (r2.length() == 0) goto L29;
            r3 = false;
        L39:
            tt5.a.k("TtsMediaService", "CallingObserver-onCallStateChanged, calling ended but remoteListener is null.");
        }
    }

    public final class f extends Binder {
        public b a;
        public final /* synthetic */ TtsMediaService b;

        public f(TtsMediaService r1) {
            this.b = r1;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IPlayer.State.values().length];
            r0[IPlayer.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[IPlayer.State.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[IPlayer.State.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[IPlayer.State.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[IPlayer.State.BUFFERING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[IPlayer.State.PAUSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[IPlayer.State.ENDED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[IPlayer.State.ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ TtsMediaRemoteAction a;
        public final /* synthetic */ TtsMediaService b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TtsMediaRemoteAction.values().length];
                r0[TtsMediaRemoteAction.FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[TtsMediaRemoteAction.TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[TtsMediaRemoteAction.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[TtsMediaRemoteAction.PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[TtsMediaRemoteAction.PREVIOUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[TtsMediaRemoteAction.NEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public h(TtsMediaRemoteAction r1, TtsMediaService r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            switch(a.a[this.a.ordinal()]) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L20;
                case 4: goto L15;
                case 5: goto L10;
                case 6: goto L5;
                default: goto L4;
            };
        L4:
            tt5.a.k("TtsMediaService", "onStartCommand, remoteAction not handled: " + this.a);
            return;
        L5:
            f r0 = this.b.f;
            if (r0 == null) goto L45;
            b r1 = r0.a;
            if (r1 == null) goto L46;
            r1.a();
            return;
        L46:
            return;
        L45:
            return;
        L10:
            f r2 = this.b.f;
            if (r2 == null) goto L48;
            b r3 = r2.a;
            if (r3 == null) goto L49;
            r3.c();
            return;
        L49:
            return;
        L48:
            return;
        L15:
            f r4 = this.b.f;
            if (r4 == null) goto L51;
            b r5 = r4.a;
            if (r5 == null) goto L52;
            r5.b();
            return;
        L52:
            return;
        L51:
            return;
        L20:
            f r6 = this.b.f;
            if (r6 == null) goto L54;
            b r7 = r6.a;
            if (r7 == null) goto L55;
            r7.e();
            return;
        L55:
            return;
        L54:
            return;
        L25:
            this.b.stopForeground(true);
            this.b.stopSelf();
            return;
        L26:
            TtsMediaService r8 = this.b;
            Notification r9 = r8.h;
            if (r9 != null) goto L31;
            r9 = r8.a();
            if (r9 != null) goto L31;
            tt5.a.d("TtsMediaService", "startForeground, notification is null.");
            return;
        L31:
            tt5.a.h("TtsMediaService", "startForeground.");
        L37:
            e = move-exception;
            tt5.a.e("TtsMediaService", "startForeground, error:", e, false);
            return;
        L33:
            if (Build.VERSION.SDK_INT < 34) goto L35;
            r8.startForeground(r8.d, r9, 2);     // Catch: Exception -> L37
        L40:
            return;
        L35:
            r8.startForeground(r8.d, r9);     // Catch: Exception -> L37
            goto L40
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r0 = 201326592;
    L6:
        l = r0;
        return;
    L5:
        r0 = 134217728;
        goto L6
    }

    public final Notification a() {
        MediaSessionCompat r0 = this.e;
        if (r0 == null) goto L39;
        MediaSessionCompat.Token r1 = r0.getSessionToken();
        if (r1 == null) goto L39;
        Application r2 = LarkContext.getApplication();
        com.bytedance.ee.bear.tts.media.a r3 = this.g;
        boolean r4 = false;
        if (r3 == null) goto L16;
        IPlayer.State r5 = r3.f;
        if (r5 == null) goto L16;
        if (r5 != IPlayer.State.PLAYING) goto L14;
    L15:
        r4 = true;
        goto L16
    L14:
        if (r5 == IPlayer.State.BUFFERING) goto L15;
    L16:
        Intent r6 = new Intent();
        r6.setAction(TtsMediaRemoteAction.PREVIOUS.getActionName());
        r6.setPackage(r2.getPackageName());
        Unit r7 = Unit.INSTANCE;
        int r8 = l;
        PendingIntent r9 = PendingIntent.getBroadcast(r2, 1, r6, r8);
        if (r4 == false) goto L19;
        int r10 = 2131255396;
    L20:
        Intent r11 = new Intent();
        if (r4 == false) goto L23;
        String r12 = TtsMediaRemoteAction.PAUSE.getActionName();
    L24:
        r11.setAction(r12);
        r11.setPackage(r2.getPackageName());
        PendingIntent r13 = PendingIntent.getBroadcast(r2, 1, r11, r8);
        Intent r14 = new Intent();
        r14.setAction(TtsMediaRemoteAction.NEXT.getActionName());
        r14.setPackage(r2.getPackageName());
        PendingIntent r15 = PendingIntent.getBroadcast(r2, 1, r14, r8);
        NotificationCompat.Builder r16 = new NotificationCompat.Builder(r2, "lark.tts").setVisibility(1);
        com.bytedance.ee.bear.tts.media.a r17 = this.g;
        if (r17 == null) goto L28;
        String r18 = r17.c;
        if (r18 == null) goto L28;
    L29:
        NotificationCompat.Builder r19 = r16.setContentTitle(r18);
        com.bytedance.ee.bear.tts.media.a r20 = this.g;
        if (r20 == null) goto L33;
        String r21 = r20.d;
        if (r21 == null) goto L33;
    L34:
        NotificationCompat.Builder r22 = r19.setContentText(r21).setSmallIcon(2131236062);
        Bitmap r23 = this.j;
        if (r23 != null) goto L37;
        r23 = (Bitmap) this.i.getValue();
    L37:
        Notification r24 = r22.setLargeIcon(r23).addAction(2131255449, "", r9).addAction(r10, "", r13).addAction(2131255220, "", r15).setStyle(new androidx.media.app.NotificationCompat.MediaStyle().setMediaSession(r1).setShowActionsInCompactView(new int[]{0, 1, 2})).build();
        this.h = r24;
        return r24;
    L33:
        r21 = "";
    L28:
        r18 = "";
        goto L29
    L23:
        r12 = TtsMediaRemoteAction.RESUME.getActionName();
        goto L24
    L19:
        r10 = 2131255432;
    L39:
        tt5.a.d("TtsMediaService", "getNotification, sessionToken is null");
        return null;
    }

    public final void b() {
        Object r1 = null;
        Job r2 = this.k;     // Catch: Exception -> L12
        if (r2 != null) goto L6;
    L14:
        this.g = null;
        d();
        f();
        e();
        c();
        Object r3 = LarkContext.getApplication().getSystemService("notification");
        if (r3 != null) goto L17;
    L22:
        tt5.a.d("TtsMediaService", "removeNotification, NotificationManager not found");
        return;
    L17:
        if ((r3 instanceof NotificationManager) == false) goto L19;
        r1 = r3;
    L19:
        if (r1 == null) goto L22;
        tt5.a.h("TtsMediaService", "removeNotification, cancel: " + this.d);
        ((NotificationManager) r1).cancel(this.d);
        return;
    L6:
        if (r2.isActive() == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L14;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("TtsMediaService", "removeNotification, cancel loadingCoverJob error:", e, false);
        goto L14
    }

    public final void c() {
        boolean r1 = true;
        Integer r3 = null;
        Job r4 = this.k;     // Catch: Exception -> L12
        if (r4 != null) goto L6;
    L14:
        com.bytedance.ee.bear.tts.media.a r5 = this.g;
        if (r5 == null) goto L38;
        String r7 = r5.a;
        if (r7 == null) goto L38;
        if (r5 == null) goto L36;
        Integer r6 = Integer.valueOf(r5.getType());
        if (r6.intValue() != (-1)) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L26;
        r3 = r6;
    L26:
        if (r3 == null) goto L36;
        int r8 = r3.intValue();
        com.bytedance.ee.bear.tts.media.a r2 = this.g;
        if (r2 == null) goto L34;
        String r9 = r2.e;
        if (r9 == null) goto L34;
        tt5.a.h("TtsMediaService", "updateNotificationCoverBitmap, token: " + du5.b.i(r7) + ", type: " + r8);
        this.k = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TtsMediaService$updateNotificationCoverBitmap$2(this, r7, r8, r9, null), 3, null);
        return;
    L34:
        tt5.a.k("TtsMediaService", "updateNotificationCoverBitmap, iconInfo is null or empty, use default cover.");
        f();
        return;
    L36:
        tt5.a.k("TtsMediaService", "updateNotificationCoverBitmap, docType invalid.");
        return;
    L38:
        tt5.a.k("TtsMediaService", "updateNotificationCoverBitmap, docToken is null or empty.");
        return;
    L6:
        if (r4.isActive() == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("TtsMediaService", "updateNotificationCoverBitmap, cancel loadingCoverJob error:", e, false);
        goto L14
    }

    public final void d() {
        MediaSessionCompat r0 = this.e;
        if (r0 == null) goto L9;
        tt5.a.h("TtsMediaService", "updateNotificationMetadata.");
        MediaMetadataCompat.Builder r1 = new MediaMetadataCompat.Builder();
        com.bytedance.ee.bear.tts.media.a r2 = this.g;
        if (r2 == null) goto L7;
        long r3 = r2.g;
    L8:
        r0.setMetadata(r1.putLong("android.media.metadata.DURATION", r3).build());
        return;
    L7:
        r3 = 0;
        goto L8
    L9:
        tt5.a.d("TtsMediaService", "updateNotificationMetadata, mediaSession is null.");
    }

    public final void e() {
        MediaSessionCompat r0 = this.e;
        if (r0 != null) goto L6;
        tt5.a.d("TtsMediaService", "updateNotificationState, mediaSession is null.");
        return;
    L6:
        tt5.a.h("TtsMediaService", "updateNotificationState, show: " + this.d);
        com.bytedance.ee.bear.tts.media.a r1 = this.g;
        if (r1 == null) goto L10;
        IPlayer.State r2 = r1.f;
        if (r2 == null) goto L10;
    L12:
        switch(g.a[r2.ordinal()]) {
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L14;
            default: goto L20;
        };
    L14:
        int r3 = 7;
    L21:
        com.bytedance.ee.bear.tts.media.a r4 = this.g;
        if (r4 == null) goto L24;
        float r5 = r4.i;
    L25:
        if (r4 == null) goto L27;
        long r6 = r4.h;
    L28:
        r0.setPlaybackState(new PlaybackStateCompat.Builder().setActions(816).setState(r3, r6, r5).build());
        return;
    L27:
        r6 = 0;
        goto L28
    L24:
        r5 = 1.0f;
        goto L25
    L15:
        r3 = 6;
        goto L21
    L16:
        r3 = 3;
        goto L21
    L17:
        r3 = 1;
        goto L21
    L18:
        r3 = 2;
        goto L21
    L19:
        r3 = 8;
        goto L21
    L20:
        r3 = 0;
    L10:
        r2 = IPlayer.State.IDLE;
        goto L12
    }

    public TtsMediaService() {
        this.a = LazyKt.lazy(new TtsMediaService$actionReceiver$2(this));
        IntentFilter r0 = new IntentFilter();
        r0.addAction(TtsMediaRemoteAction.RESUME.getActionName());
        r0.addAction(TtsMediaRemoteAction.PAUSE.getActionName());
        r0.addAction(TtsMediaRemoteAction.PREVIOUS.getActionName());
        r0.addAction(TtsMediaRemoteAction.NEXT.getActionName());
        this.b = r0;
        this.c = LazyKt.lazy(new TtsMediaService$phoneCallObserver$2(this));
        this.d = hashCode();
        this.i = LazyKt.lazy(TtsMediaService$defaultCoverBitmap$2.INSTANCE);
    }

    public final void f() {
        Object r0 = LarkContext.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r1 = (NotificationManager) r0;
        Notification r2 = a();
        if (r2 == null) goto L5;
        tt5.a.h("TtsMediaService", "updateNotificationUI, show: " + this.d);
        r1.notify(this.d, r2);
        return;
    L5:
        tt5.a.d("TtsMediaService", "updateNotificationUI, notification is null.");
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        tt5.a.h("TtsMediaService", "onCreate");
        Application r1 = LarkContext.getApplication();
        if (Build.VERSION.SDK_INT < 33) goto L26;
        BroadcastReceiver r13 = (BroadcastReceiver) this.a.getValue();
        IntentFilter r14 = this.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L75:
    L21:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L25;
        ReceiverRegisterCrashOptimizer.registerReceiver(r13, r14, null, null, 4);
    L47:
        e r2 = (e) this.c.getValue();
        r2.a.b(r2);
        MediaSessionCompat r3 = new MediaSessionCompat(LarkContext.getApplication(), "TtsMediaService");     // Catch: Exception -> L50
        r3.setCallback(new d(this));     // Catch: Exception -> L50
        r3.setFlags(3);     // Catch: Exception -> L50
        r3.setPlaybackState(new PlaybackStateCompat.Builder().setState(0, 0, 1.0f).setActions(816).build());     // Catch: Exception -> L50
        this.e = r3;     // Catch: Exception -> L50
    L52:
        MediaSessionCompat r4 = this.e;
        if (r4 == null) goto L58;
        MediaSessionCompat.Token r5 = r4.getSessionToken();
        if (r5 == null) goto L58;
        new MediaControllerCompat(LarkContext.getApplication(), r5);
    L59:
        this.f = new f(this);
        int r6 = Build.VERSION.SDK_INT;
        if (r6 >= 26) goto L62;
        tt5.a.h("TtsMediaService", "initNotificationChannel, API below 26: " + r6);
        return;
    L62:
        String r0 = LarkContext.getApplication().getString(2131889241);
        Object r7 = LarkContext.getApplication().getSystemService("notification");
        if (r7 != null) goto L65;
        return;
    L65:
        if ((r7 instanceof NotificationManager) == true) goto L68;
        r7 = null;
    L68:
        if (r7 == null) goto L84;
        NotificationManager r8 = (NotificationManager) r7;
        if (r8.getNotificationChannel("lark.tts") != null) goto L85;
        NotificationChannel r9 = new NotificationChannel("lark.tts", r0, 3);
        r9.setDescription(r0);
        r9.enableVibration(false);
        r9.setSound(null, null);
        r9.enableLights(true);
        r9.setLightColor(-16776961);
        r8.createNotificationChannel(r9);
        Unit r10 = Unit.INSTANCE;
        return;
    L85:
        return;
    L84:
        return;
    L58:
        tt5.a.d("TtsMediaService", "initController, sessionToken is null");
    L50:
        e = move-exception;
        tt5.a.e("TtsMediaService", "initSession, error:", e, false);
        goto L52
    L25:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (r14 == null) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r14) == false) goto L19;
        int r11 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r13, r14, 4, null, null, 5, r1).result;     // Catch: Exception -> L21
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L17;
        if (r11 == 3) goto L74;
        r1.registerReceiver(r13, r14, null, null, 4);     // Catch: Exception -> L21
    L74:
        goto L47
    L17:
        new Intent();     // Catch: Exception -> L21
        goto L74
    L18:
        r1.registerReceiver(r13, r14, null, null, 4);     // Catch: Exception -> L21
    L19:
        r1.registerReceiver(r13, r14, null, null, 4);     // Catch: Exception -> L21
        goto L74
    L26:
        BroadcastReceiver r15 = (BroadcastReceiver) this.a.getValue();
        IntentFilter r16 = this.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L80;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L80:
    L43:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L73;
        ReceiverRegisterCrashOptimizer.registerReceiver(r15, r16, null, null);
        goto L47
    L73:
        throw e;
    L30:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L41;
        if (r16 == null) goto L41;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r16) == false) goto L41;
        int r12 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r15, r16, 0, null, null, 4, r1).result;     // Catch: Exception -> L43
        if (r12 == 1) goto L40;
        if (r12 == 2) goto L39;
        if (r12 == 3) goto L79;
        r1.registerReceiver(r15, r16, null, null);     // Catch: Exception -> L43
    L79:
        goto L47
    L39:
        new Intent();     // Catch: Exception -> L43
        goto L79
    L40:
        r1.registerReceiver(r15, r16, null, null);     // Catch: Exception -> L43
    L41:
        r1.registerReceiver(r15, r16, null, null);     // Catch: Exception -> L43
        goto L79
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("TtsMediaService", "onDestroy");
        f r1 = this.f;
        if (r1 == null) goto L8;
        b r3 = r1.a;
        if (r3 == null) goto L7;
        r3.b();
    L7:
        r1.a = null;
        this.f = null;
    L8:
        MediaSessionCompat r2 = this.e;
        if (r2 == null) goto L11;
        r2.setCallback(null);
    L11:
        Application r4 = LarkContext.getApplication();
        BroadcastReceiver r5 = (BroadcastReceiver) this.a.getValue();     // Catch: Exception -> L24
        ReceiverRegisterLancet.loge(r5, false);     // Catch: Exception -> L24
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L29;
        r4.unregisterReceiver(r5);     // Catch: Exception -> L24
    L26:
        ((e) this.c.getValue()).a.d();
        stopForeground(true);
        b();
        return;
    L29:
    L18:
        e = move-exception;
        if (r5 == null) goto L21;
        Npth.addTag("unregisterReceiver", r5.toString());     // Catch: Exception -> L24
    L21:
        e.printStackTrace();     // Catch: Exception -> L24
        goto L26
    L15:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r5, r4) == false) goto L26;
        r4.unregisterReceiver(r5);     // Catch: Exception -> L18
    L24:
        e = move-exception;
        tt5.a.e("TtsMediaService", "destroyActionReceiver, error:", e, false);
        goto L26
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r3) {
        tt5.a.h("TtsMediaService", "onBind, intent: " + r3);
        return this.f;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r2) {
        Intrinsics.checkNotNullParameter(r2, "conn");
        super.unbindService(r2);
        tt5.a.h("TtsMediaService", "unbindService");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r8, int r9, int r10) {
        if (r8 == null) goto L22;
        String r4 = r8.getAction();
        if (r4 == null) goto L22;
        if (r4.length() != 0) goto L9;
        boolean r5 = true;
    L11:
        if ((!r5) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L22;
        TtsMediaRemoteAction.Companion.getClass();
        TtsMediaRemoteAction r6 = TtsMediaRemoteAction.a.a(r4);
        if (r6 != null) goto L20;
        tt5.a.k("TtsMediaService", "onStartCommand, remoteAction not supported: ".concat(r4));
        return 2;
    L20:
        tt5.a.h("TtsMediaService", "onStartCommand, intent: " + r8 + ", flags: " + r9 + ", startId: " + r10 + ", intentAction: " + r4);
        com.bytedance.ee.util.ui.j.c(new h(r6, this));
        return super.onStartCommand(r8, r9, r10);
    L9:
        r5 = false;
    L22:
        tt5.a.k("TtsMediaService", "onStartCommand, intentAction is empty, intent: " + r8 + ", flags: " + r9 + ", startId: " + r10);
        return 2;
    }
}
