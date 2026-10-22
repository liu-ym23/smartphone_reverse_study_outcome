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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.Npth;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0006DEFGHIB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\u0014\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u00060\rR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0018\u00010\u0018R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/tts/media/TtsMediaService;", "Landroid/app/Service;", "<init>", "()V", "actionReceiver", "Landroid/content/BroadcastReceiver;", "getActionReceiver", "()Landroid/content/BroadcastReceiver;", "actionReceiver$delegate", "Lkotlin/Lazy;", "actionReceiverFilter", "Landroid/content/IntentFilter;", "phoneCallObserver", "Lcom/bytedance/ee/bear/tts/media/TtsMediaService$PhoneCallObserver;", "getPhoneCallObserver", "()Lcom/bytedance/ee/bear/tts/media/TtsMediaService$PhoneCallObserver;", "phoneCallObserver$delegate", "notificationId", "", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "binder", "Lcom/bytedance/ee/bear/tts/media/TtsMediaService$RemoteBinder;", "lastMediaBean", "Lcom/bytedance/ee/bear/tts/media/TtsMediaBean;", "lastNotification", "Landroid/app/Notification;", "defaultCoverBitmap", "Landroid/graphics/Bitmap;", "getDefaultCoverBitmap", "()Landroid/graphics/Bitmap;", "defaultCoverBitmap$delegate", "docCoverBitmap", "loadingCoverJob", "Lkotlinx/coroutines/Job;", WidgetCostModule.TYPE_ON_CREATE, "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "unbindService", "conn", "Landroid/content/ServiceConnection;", "onStartCommand", "flags", "startId", LiveCommonConstants.REASON_ON_DEDTROY, "initActionReceiver", "destroyActionReceiver", "initCallingObserver", "destroyCallingObserver", "initSession", "initController", "initBinder", "initNotificationChannel", "startForeground", "updateNotificationMetadata", "updateNotificationUI", "updateNotificationState", "updateNotificationCoverBitmap", "removeNotification", "createNotification", "convertRemoteState", "ttsState", "Lcom/bytedance/ee/bear/middleground/drive/export/player/IPlayer$State;", "Companion", "IRemoteListener", "RemoteBinder", "MediaSessionCallback", "MediaActionReceiver", "PhoneCallObserver", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsMediaService extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f239653l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f239654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntentFilter f239655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f239656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f239657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaSessionCompat f239658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f239659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.tts.media.a f239660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Notification f239661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f239662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f239663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f239664k;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        void d(long r100);

        void e();
    }

    public final class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsMediaService f239665a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239666a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TtsMediaRemoteAction f239667b;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.TtsMediaService$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C3438a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f239668a = null;

                static {
                    int[] r100 = new int[TtsMediaRemoteAction.values().length];
                    r100[TtsMediaRemoteAction.RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r100[TtsMediaRemoteAction.PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r100[TtsMediaRemoteAction.PREVIOUS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r100[TtsMediaRemoteAction.NEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    f239668a = r100;
                }
            }

            public a(TtsMediaService r100, c r101, TtsMediaRemoteAction r102) {
                this.f239666a = r100;
                this.f239667b = r102;
            }

            public final void a() {
                f r100 = this.f239666a.f239659f;
                if (r100 == null) goto L21;
                b r101 = r100.f239680a;
                if (r101 == null) goto L21;
                int r102 = C3438a.f239668a[this.f239667b.ordinal()];
                if (r102 != 1) goto L10;
                r101.e();
                return;
            L10:
                if (r102 != 2) goto L12;
                r101.b();
                return;
            L12:
                if (r102 != 3) goto L14;
                r101.c();
                return;
            L14:
                if (r102 == 4) goto L16;
                tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, remoteAction not handled: " + this.f239667b);
                return;
            L16:
                r101.a();
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

        public c(TtsMediaService r100) {
            this.f239665a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L13;
            String r102 = r101.getAction();
            if (r102 == null) goto L13;
            TtsMediaRemoteAction.Companion.getClass();
            TtsMediaRemoteAction r103 = TtsMediaRemoteAction.a.a(r102);
            if (r103 != null) goto L11;
            tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, remoteAction not supported: " + r102 + ", intent: " + r101);
            return;
        L11:
            com.bytedance.ee.util.ui.j.c(new a(this.f239665a, this, r103));
            return;
        L13:
            tt5.a.k("TtsMediaService", "MediaActionReceiver-onReceive, intentAction is null or empty, intent: " + r101);
        }
    }

    public final class d extends MediaSessionCompat.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsMediaService f239669a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239670a;

            public a(TtsMediaService r100) {
                this.f239670a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f239670a.f239659f;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                b r101 = r100.f239680a;     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.b();     // Catch: Throwable -> L8
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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239671a;

            public b(TtsMediaService r100) {
                this.f239671a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f239671a.f239659f;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                b r101 = r100.f239680a;     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.e();     // Catch: Throwable -> L8
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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f239673b;

            public c(TtsMediaService r100, long r101) {
                this.f239672a = r100;
                this.f239673b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f239672a.f239659f;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                b r101 = r100.f239680a;     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.d(this.f239673b);     // Catch: Throwable -> L8
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
        public static final class RunnableC3439d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239674a;

            public RunnableC3439d(TtsMediaService r100) {
                this.f239674a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f239674a.f239659f;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                b r101 = r100.f239680a;     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.a();     // Catch: Throwable -> L8
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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TtsMediaService f239675a;

            public e(TtsMediaService r100) {
                this.f239675a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f239675a.f239659f;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                b r101 = r100.f239680a;     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.c();     // Catch: Throwable -> L8
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

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onPause() {
            com.bytedance.ee.util.ui.j.f(new a(this.f239669a));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onPlay() {
            com.bytedance.ee.util.ui.j.f(new b(this.f239669a));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSkipToNext() {
            com.bytedance.ee.util.ui.j.f(new RunnableC3439d(this.f239669a));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSkipToPrevious() {
            com.bytedance.ee.util.ui.j.f(new e(this.f239669a));
        }

        public d(TtsMediaService r100) {
            this.f239669a = r100;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSeekTo(long r100) {
            com.bytedance.ee.util.ui.j.f(new c(this.f239669a, r100));
        }
    }

    public final class e implements ewa.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ewa.a f239676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f239677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f239678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TtsMediaService f239679d;

        public e(TtsMediaService r100) {
            this.f239679d = r100;
            this.f239676a = new ewa.a(r100);
        }

        @Override // ewa.b
        public final void a(boolean r100) {
            if (this.f239677b != r100) goto L5;
            return;
        L5:
            this.f239677b = r100;
            String r101 = null;
            if (r100 == false) goto L18;
            f r102 = this.f239679d.f239659f;
            if (r102 == null) goto L16;
            b r103 = r102.f239680a;
            if (r103 == null) goto L16;
            tt5.a.h("TtsMediaService", "CallingObserver-onCallStateChanged, Calling started, pause.");
            r103.b();
            com.bytedance.ee.bear.tts.media.a r104 = this.f239679d.f239660g;
            if (r104 == null) goto L15;
            r101 = r104.f239689a;
        L15:
            this.f239678c = r101;
            return;
        L16:
            tt5.a.k("TtsMediaService", "CallingObserver-onCallStateChanged, calling started but remoteListener is null.");
            return;
        L18:
            f r105 = this.f239679d.f239659f;
            if (r105 == null) goto L39;
            b r106 = r105.f239680a;
            if (r106 == null) goto L39;
            String r107 = this.f239678c;
            if (r107 != null) goto L26;
        L29:
            boolean r108 = true;
        L30:
            if (r108 == true) goto L42;
            String r109 = this.f239678c;
            com.bytedance.ee.bear.tts.media.a r110 = this.f239679d.f239660g;
            if (r110 == null) goto L34;
            String r111 = r110.f239689a;
        L36:
            if (Intrinsics.areEqual(r109, r111) == false) goto L43;
            tt5.a.h("TtsMediaService", "CallingObserver-onCallStateChanged, Calling finished, resume.");
            r106.e();
            this.f239678c = null;
            return;
        L43:
            return;
        L34:
            r111 = null;
            goto L36
        L42:
            return;
        L26:
            if (r107.length() == 0) goto L29;
            r108 = false;
        L39:
            tt5.a.k("TtsMediaService", "CallingObserver-onCallStateChanged, calling ended but remoteListener is null.");
        }
    }

    public final class f extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f239680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsMediaService f239681b;

        public f(TtsMediaService r100) {
            this.f239681b = r100;
        }
    }

    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f239682a = null;

        static {
            int[] r100 = new int[IPlayer.State.values().length];
            r100[IPlayer.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[IPlayer.State.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[IPlayer.State.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[IPlayer.State.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[IPlayer.State.BUFFERING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[IPlayer.State.PAUSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[IPlayer.State.ENDED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[IPlayer.State.ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f239682a = r100;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsMediaRemoteAction f239683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsMediaService f239684b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f239685a = null;

            static {
                int[] r100 = new int[TtsMediaRemoteAction.values().length];
                r100[TtsMediaRemoteAction.FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[TtsMediaRemoteAction.TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[TtsMediaRemoteAction.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[TtsMediaRemoteAction.PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[TtsMediaRemoteAction.PREVIOUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[TtsMediaRemoteAction.NEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f239685a = r100;
            }
        }

        public h(TtsMediaRemoteAction r100, TtsMediaService r101) {
            this.f239683a = r100;
            this.f239684b = r101;
        }

        public final void a() {
            switch(a.f239685a[this.f239683a.ordinal()]) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L20;
                case 4: goto L15;
                case 5: goto L10;
                case 6: goto L5;
                default: goto L4;
            };
        L4:
            tt5.a.k("TtsMediaService", "onStartCommand, remoteAction not handled: " + this.f239683a);
            return;
        L5:
            f r100 = this.f239684b.f239659f;
            if (r100 == null) goto L45;
            b r101 = r100.f239680a;
            if (r101 == null) goto L46;
            r101.a();
            return;
        L46:
            return;
        L45:
            return;
        L10:
            f r102 = this.f239684b.f239659f;
            if (r102 == null) goto L48;
            b r103 = r102.f239680a;
            if (r103 == null) goto L49;
            r103.c();
            return;
        L49:
            return;
        L48:
            return;
        L15:
            f r104 = this.f239684b.f239659f;
            if (r104 == null) goto L51;
            b r105 = r104.f239680a;
            if (r105 == null) goto L52;
            r105.b();
            return;
        L52:
            return;
        L51:
            return;
        L20:
            f r106 = this.f239684b.f239659f;
            if (r106 == null) goto L54;
            b r107 = r106.f239680a;
            if (r107 == null) goto L55;
            r107.e();
            return;
        L55:
            return;
        L54:
            return;
        L25:
            this.f239684b.stopForeground(true);
            this.f239684b.stopSelf();
            return;
        L26:
            TtsMediaService r108 = this.f239684b;
            Notification r109 = r108.f239661h;
            if (r109 != null) goto L31;
            r109 = r108.a();
            if (r109 != null) goto L31;
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
            r108.startForeground(r108.f239657d, r109, 2);     // Catch: Exception -> L37
        L40:
            return;
        L35:
            r108.startForeground(r108.f239657d, r109);     // Catch: Exception -> L37
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
        int r100 = 201326592;
    L6:
        f239653l = r100;
        return;
    L5:
        r100 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L6
    }

    public final Notification a() {
        MediaSessionCompat r100 = this.f239658e;
        if (r100 == null) goto L39;
        MediaSessionCompat.Token r101 = r100.getSessionToken();
        if (r101 == null) goto L39;
        Application r102 = LarkContext.getApplication();
        com.bytedance.ee.bear.tts.media.a r103 = this.f239660g;
        boolean r104 = false;
        if (r103 == null) goto L16;
        IPlayer.State r105 = r103.f239694f;
        if (r105 == null) goto L16;
        if (r105 != IPlayer.State.PLAYING) goto L14;
    L15:
        r104 = true;
        goto L16
    L14:
        if (r105 == IPlayer.State.BUFFERING) goto L15;
    L16:
        Intent r106 = new Intent();
        r106.setAction(TtsMediaRemoteAction.PREVIOUS.getActionName());
        r106.setPackage(r102.getPackageName());
        Unit r107 = Unit.INSTANCE;
        int r108 = f239653l;
        PendingIntent r109 = PendingIntent.getBroadcast(r102, 1, r106, r108);
        if (r104 == false) goto L19;
        int r110 = R.drawable.ud_icon_pause_filled;
    L20:
        Intent r111 = new Intent();
        if (r104 == false) goto L23;
        String r112 = TtsMediaRemoteAction.PAUSE.getActionName();
    L24:
        r111.setAction(r112);
        r111.setPackage(r102.getPackageName());
        PendingIntent r113 = PendingIntent.getBroadcast(r102, 1, r111, r108);
        Intent r114 = new Intent();
        r114.setAction(TtsMediaRemoteAction.NEXT.getActionName());
        r114.setPackage(r102.getPackageName());
        PendingIntent r115 = PendingIntent.getBroadcast(r102, 1, r114, r108);
        NotificationCompat.Builder r116 = new NotificationCompat.Builder(r102, "lark.tts").setVisibility(1);
        com.bytedance.ee.bear.tts.media.a r117 = this.f239660g;
        if (r117 == null) goto L28;
        String r118 = r117.f239691c;
        if (r118 == null) goto L28;
    L29:
        NotificationCompat.Builder r119 = r116.setContentTitle(r118);
        com.bytedance.ee.bear.tts.media.a r120 = this.f239660g;
        if (r120 == null) goto L33;
        String r121 = r120.f239692d;
        if (r121 == null) goto L33;
    L34:
        NotificationCompat.Builder r122 = r119.setContentText(r121).setSmallIcon(R.drawable.ic_notify);
        Bitmap r123 = this.f239663j;
        if (r123 != null) goto L37;
        r123 = (Bitmap) this.f239662i.getValue();
    L37:
        Notification r124 = r122.setLargeIcon(r123).addAction(R.drawable.ud_icon_previous_play_filled, "", r109).addAction(r110, "", r113).addAction(R.drawable.ud_icon_next_play_filled, "", r115).setStyle(new androidx.media.app.NotificationCompat.MediaStyle().setMediaSession(r101).setShowActionsInCompactView(new int[]{0, 1, 2})).build();
        this.f239661h = r124;
        return r124;
    L33:
        r121 = "";
    L28:
        r118 = "";
        goto L29
    L23:
        r112 = TtsMediaRemoteAction.RESUME.getActionName();
        goto L24
    L19:
        r110 = R.drawable.ud_icon_play_filled;
    L39:
        tt5.a.d("TtsMediaService", "getNotification, sessionToken is null");
        return null;
    }

    public final void b() {
        Object r100 = null;
        Job r101 = this.f239664k;     // Catch: Exception -> L12
        if (r101 != null) goto L6;
    L14:
        this.f239660g = null;
        d();
        f();
        e();
        c();
        Object r102 = LarkContext.getApplication().getSystemService("notification");
        if (r102 != null) goto L17;
    L22:
        tt5.a.d("TtsMediaService", "removeNotification, NotificationManager not found");
        return;
    L17:
        if ((r102 instanceof NotificationManager) == false) goto L19;
        r100 = r102;
    L19:
        if (r100 == null) goto L22;
        tt5.a.h("TtsMediaService", "removeNotification, cancel: " + this.f239657d);
        ((NotificationManager) r100).cancel(this.f239657d);
        return;
    L6:
        if (r101.isActive() == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L14;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("TtsMediaService", "removeNotification, cancel loadingCoverJob error:", e, false);
        goto L14
    }

    public final void c() {
        boolean r100 = true;
        Integer r101 = null;
        Job r102 = this.f239664k;     // Catch: Exception -> L12
        if (r102 != null) goto L6;
    L14:
        com.bytedance.ee.bear.tts.media.a r103 = this.f239660g;
        if (r103 == null) goto L38;
        String r104 = r103.f239689a;
        if (r104 == null) goto L38;
        if (r103 == null) goto L36;
        Integer r105 = Integer.valueOf(r103.getType());
        if (r105.intValue() != (-1)) goto L24;
        r100 = false;
    L24:
        if (r100 == false) goto L26;
        r101 = r105;
    L26:
        if (r101 == null) goto L36;
        int r106 = r101.intValue();
        com.bytedance.ee.bear.tts.media.a r107 = this.f239660g;
        if (r107 == null) goto L34;
        String r108 = r107.f239693e;
        if (r108 == null) goto L34;
        tt5.a.h("TtsMediaService", "updateNotificationCoverBitmap, token: " + du5.b.i(r104) + ", type: " + r106);
        this.f239664k = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TtsMediaService$updateNotificationCoverBitmap$2(this, r104, r106, r108, null), 3, null);
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
        if (r102.isActive() == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L14;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("TtsMediaService", "updateNotificationCoverBitmap, cancel loadingCoverJob error:", e, false);
        goto L14
    }

    public final void d() {
        MediaSessionCompat r100 = this.f239658e;
        if (r100 == null) goto L9;
        tt5.a.h("TtsMediaService", "updateNotificationMetadata.");
        MediaMetadataCompat.Builder r101 = new MediaMetadataCompat.Builder();
        com.bytedance.ee.bear.tts.media.a r102 = this.f239660g;
        if (r102 == null) goto L7;
        long r103 = r102.f239695g;
    L8:
        r100.setMetadata(r101.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, r103).build());
        return;
    L7:
        r103 = 0;
        goto L8
    L9:
        tt5.a.d("TtsMediaService", "updateNotificationMetadata, mediaSession is null.");
    }

    public final void e() {
        MediaSessionCompat r100 = this.f239658e;
        if (r100 != null) goto L6;
        tt5.a.d("TtsMediaService", "updateNotificationState, mediaSession is null.");
        return;
    L6:
        tt5.a.h("TtsMediaService", "updateNotificationState, show: " + this.f239657d);
        com.bytedance.ee.bear.tts.media.a r101 = this.f239660g;
        if (r101 == null) goto L10;
        IPlayer.State r102 = r101.f239694f;
        if (r102 == null) goto L10;
    L12:
        switch(g.f239682a[r102.ordinal()]) {
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
        int r103 = 7;
    L21:
        com.bytedance.ee.bear.tts.media.a r104 = this.f239660g;
        if (r104 == null) goto L24;
        float r105 = r104.f239697i;
    L25:
        if (r104 == null) goto L27;
        long r106 = r104.f239696h;
    L28:
        r100.setPlaybackState(new PlaybackStateCompat.Builder().setActions(816).setState(r103, r106, r105).build());
        return;
    L27:
        r106 = 0;
        goto L28
    L24:
        r105 = 1.0f;
        goto L25
    L15:
        r103 = 6;
        goto L21
    L16:
        r103 = 3;
        goto L21
    L17:
        r103 = 1;
        goto L21
    L18:
        r103 = 2;
        goto L21
    L19:
        r103 = 8;
        goto L21
    L20:
        r103 = 0;
    L10:
        r102 = IPlayer.State.IDLE;
        goto L12
    }

    public TtsMediaService() {
        this.f239654a = LazyKt.lazy(new TtsMediaService$actionReceiver$2(this));
        IntentFilter r100 = new IntentFilter();
        r100.addAction(TtsMediaRemoteAction.RESUME.getActionName());
        r100.addAction(TtsMediaRemoteAction.PAUSE.getActionName());
        r100.addAction(TtsMediaRemoteAction.PREVIOUS.getActionName());
        r100.addAction(TtsMediaRemoteAction.NEXT.getActionName());
        this.f239655b = r100;
        this.f239656c = LazyKt.lazy(new TtsMediaService$phoneCallObserver$2(this));
        this.f239657d = hashCode();
        this.f239662i = LazyKt.lazy(TtsMediaService$defaultCoverBitmap$2.INSTANCE);
    }

    public final void f() {
        Object r100 = LarkContext.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r101 = (NotificationManager) r100;
        Notification r102 = a();
        if (r102 == null) goto L5;
        tt5.a.h("TtsMediaService", "updateNotificationUI, show: " + this.f239657d);
        r101.notify(this.f239657d, r102);
        return;
    L5:
        tt5.a.d("TtsMediaService", "updateNotificationUI, notification is null.");
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        tt5.a.h("TtsMediaService", WidgetCostModule.TYPE_ON_CREATE);
        Application r100 = LarkContext.getApplication();
        if (Build.VERSION.SDK_INT < 33) goto L26;
        BroadcastReceiver r110 = (BroadcastReceiver) this.f239654a.getValue();
        IntentFilter r111 = this.f239655b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L75:
    L21:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L25;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, null, null, 4);
    L47:
        e r101 = (e) this.f239656c.getValue();
        r101.f239676a.b(r101);
        MediaSessionCompat r102 = new MediaSessionCompat(LarkContext.getApplication(), "TtsMediaService");     // Catch: Exception -> L50
        r102.setCallback(new d(this));     // Catch: Exception -> L50
        r102.setFlags(3);     // Catch: Exception -> L50
        r102.setPlaybackState(new PlaybackStateCompat.Builder().setState(0, 0, 1.0f).setActions(816).build());     // Catch: Exception -> L50
        this.f239658e = r102;     // Catch: Exception -> L50
    L52:
        MediaSessionCompat r103 = this.f239658e;
        if (r103 == null) goto L58;
        MediaSessionCompat.Token r104 = r103.getSessionToken();
        if (r104 == null) goto L58;
        new MediaControllerCompat(LarkContext.getApplication(), r104);
    L59:
        this.f239659f = new f(this);
        int r105 = Build.VERSION.SDK_INT;
        if (r105 >= 26) goto L62;
        tt5.a.h("TtsMediaService", "initNotificationChannel, API below 26: " + r105);
        return;
    L62:
        String r106 = LarkContext.getApplication().getString(R.string.LarkCCM_Docs_ReadAloud_Menu);
        Object r107 = LarkContext.getApplication().getSystemService("notification");
        if (r107 != null) goto L65;
        return;
    L65:
        if ((r107 instanceof NotificationManager) == true) goto L68;
        r107 = null;
    L68:
        if (r107 == null) goto L84;
        NotificationManager r108 = (NotificationManager) r107;
        if (r108.getNotificationChannel("lark.tts") != null) goto L85;
        NotificationChannel r109 = new NotificationChannel("lark.tts", r106, 3);
        r109.setDescription(r106);
        r109.enableVibration(false);
        r109.setSound(null, null);
        r109.enableLights(true);
        r109.setLightColor(FakePickerAvatarCreator.BLUE);
        r108.createNotificationChannel(r109);
        Unit r112 = Unit.INSTANCE;
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
        if (r111 == null) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L19;
        int r113 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, null, null, 5, r100).result;     // Catch: Exception -> L21
        if (r113 == 1) goto L18;
        if (r113 == 2) goto L17;
        if (r113 == 3) goto L74;
        r100.registerReceiver(r110, r111, null, null, 4);     // Catch: Exception -> L21
    L74:
        goto L47
    L17:
        new Intent();     // Catch: Exception -> L21
        goto L74
    L18:
        r100.registerReceiver(r110, r111, null, null, 4);     // Catch: Exception -> L21
    L19:
        r100.registerReceiver(r110, r111, null, null, 4);     // Catch: Exception -> L21
        goto L74
    L26:
        BroadcastReceiver r114 = (BroadcastReceiver) this.f239654a.getValue();
        IntentFilter r115 = this.f239655b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L80;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L80:
    L43:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L73;
        ReceiverRegisterCrashOptimizer.registerReceiver(r114, r115, null, null);
        goto L47
    L73:
        throw e;
    L30:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L41;
        if (r115 == null) goto L41;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r115) == false) goto L41;
        int r116 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r114, r115, 0, null, null, 4, r100).result;     // Catch: Exception -> L43
        if (r116 == 1) goto L40;
        if (r116 == 2) goto L39;
        if (r116 == 3) goto L79;
        r100.registerReceiver(r114, r115, null, null);     // Catch: Exception -> L43
    L79:
        goto L47
    L39:
        new Intent();     // Catch: Exception -> L43
        goto L79
    L40:
        r100.registerReceiver(r114, r115, null, null);     // Catch: Exception -> L43
    L41:
        r100.registerReceiver(r114, r115, null, null);     // Catch: Exception -> L43
        goto L79
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("TtsMediaService", LiveCommonConstants.REASON_ON_DEDTROY);
        f r100 = this.f239659f;
        if (r100 == null) goto L8;
        b r101 = r100.f239680a;
        if (r101 == null) goto L7;
        r101.b();
    L7:
        r100.f239680a = null;
        this.f239659f = null;
    L8:
        MediaSessionCompat r102 = this.f239658e;
        if (r102 == null) goto L11;
        r102.setCallback(null);
    L11:
        Application r103 = LarkContext.getApplication();
        BroadcastReceiver r104 = (BroadcastReceiver) this.f239654a.getValue();     // Catch: Exception -> L24
        ReceiverRegisterLancet.loge(r104, false);     // Catch: Exception -> L24
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L29;
        r103.unregisterReceiver(r104);     // Catch: Exception -> L24
    L26:
        ((e) this.f239656c.getValue()).f239676a.d();
        stopForeground(true);
        b();
        return;
    L29:
    L18:
        e = move-exception;
        if (r104 == null) goto L21;
        Npth.addTag("unregisterReceiver", r104.toString());     // Catch: Exception -> L24
    L21:
        e.printStackTrace();     // Catch: Exception -> L24
        goto L26
    L15:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r104, r103) == false) goto L26;
        r103.unregisterReceiver(r104);     // Catch: Exception -> L18
    L24:
        e = move-exception;
        tt5.a.e("TtsMediaService", "destroyActionReceiver, error:", e, false);
        goto L26
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        tt5.a.h("TtsMediaService", "onBind, intent: " + r100);
        return this.f239659f;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r100) {
        Intrinsics.checkNotNullParameter(r100, "conn");
        super.unbindService(r100);
        tt5.a.h("TtsMediaService", "unbindService");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r110) {
        if (r100 == null) goto L22;
        String r102 = r100.getAction();
        if (r102 == null) goto L22;
        if (r102.length() != 0) goto L9;
        boolean r103 = true;
    L11:
        if ((!r103) == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L22;
        TtsMediaRemoteAction.Companion.getClass();
        TtsMediaRemoteAction r104 = TtsMediaRemoteAction.a.a(r102);
        if (r104 != null) goto L20;
        tt5.a.k("TtsMediaService", "onStartCommand, remoteAction not supported: ".concat(r102));
        return 2;
    L20:
        tt5.a.h("TtsMediaService", "onStartCommand, intent: " + r100 + ", flags: " + r101 + ", startId: " + r110 + ", intentAction: " + r102);
        com.bytedance.ee.util.ui.j.c(new h(r104, this));
        return super.onStartCommand(r100, r101, r110);
    L9:
        r103 = false;
    L22:
        tt5.a.k("TtsMediaService", "onStartCommand, intentAction is empty, intent: " + r100 + ", flags: " + r101 + ", startId: " + r110);
        return 2;
    }
}
