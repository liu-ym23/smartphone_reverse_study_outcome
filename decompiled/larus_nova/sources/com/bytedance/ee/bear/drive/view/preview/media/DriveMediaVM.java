package com.bytedance.ee.bear.drive.view.preview.media;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/media/DriveMediaVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "hexString", "", "getHexString", "()Ljava/lang/String;", "playPosition", "Landroidx/lifecycle/MutableLiveData;", "", "getPlayPosition", "()Landroidx/lifecycle/MutableLiveData;", "resumePosition", "getResumePosition", "pauseMedia", "getPauseMedia", "startMedia", "getStartMedia", "audioResourceInterruptListener", "Lcom/ss/android/lark/media/OnMediaResourceInterruptListener;", "videoResourceInterruptListener", "tryPlayAudio", "", "mediaResourceConnector", "Lcom/bytedance/ee/bear/drive/view/preview/media/IDriveMediaResourceConnector;", "tryPlayVideo", "tryReleaseMediaMutex", "Companion", "DriveOnMediaResourceInterruptListener", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveMediaVM";
    private com.ss.android.lark.media.a audioResourceInterruptListener;
    private final String hexString;
    private boolean isAutoPlay;
    private final MutableLiveData<Boolean> pauseMedia;
    private final MutableLiveData<Long> playPosition;
    private final MutableLiveData<Long> resumePosition;
    private final MutableLiveData<Boolean> startMedia;
    private com.ss.android.lark.media.a videoResourceInterruptListener;

    public static final class a {
        public a() {
        }
    }

    public final class b implements com.ss.android.lark.media.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u95.a f225071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DriveMediaVM f225072c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f225073a;

            public a(b r100) {
                this.f225073a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f225073a.f225071b.d();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM$b$b, reason: collision with other inner class name */
        public static final class RunnableC3236b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f225074a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MediaMutex.LockError f225075b;

            public RunnableC3236b(b r100, MediaMutex.LockError r101) {
                this.f225074a = r100;
                this.f225075b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f225074a.f225071b.b(this.f225075b.getErrorMessage());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f225076a;

            public c(b r100) {
                this.f225076a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f225076a.f225071b.c();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            tt5.a.h(DriveMediaVM.TAG, this.f225070a + " mediaResourceInterrupt onSuccess");
            m.a(new c(this));
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            tt5.a.h(DriveMediaVM.TAG, this.f225070a + " mediaResourceInterrupt onError, occupiedScene= " + r100.getOccupiedScene());
            this.f225072c.tryReleaseMediaMutex();
            m.a(new RunnableC3236b(this, r100));
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "byScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            tt5.a.h(DriveMediaVM.TAG, this.f225070a + " mediaResourceWasInterrupted, byScene= " + r100 + ", type= " + r101);
            m.a(new com.bytedance.ee.bear.drive.view.preview.media.a(this));
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "fromScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            tt5.a.h(DriveMediaVM.TAG, this.f225070a + " mediaResourceInterruptionEnd, fromScene= " + r100 + ", type= " + r101);
            m.a(new a(this));
        }

        public b(DriveMediaVM r100, String r101, u95.a r102) {
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "connector");
            this.f225072c = r100;
            this.f225070a = r101;
            this.f225071b = r102;
        }
    }

    static {
        Companion = new a();
    }

    public final synchronized void tryReleaseMediaMutex() {
        monitor-enter(this);
        tt5.a.h(TAG, "tryReleaseMediaMutex");     // Catch: Throwable -> L11
        com.ss.android.lark.media.a r100 = this.audioResourceInterruptListener;     // Catch: Throwable -> L11
        if (r100 == null) goto L6;
        MediaMutex r101 = MediaMutex.f431631r;     // Catch: Throwable -> L11
        MediaMutex.f431631r.n(Scene.CCM_Audio_Play, r100);     // Catch: Throwable -> L11
        this.audioResourceInterruptListener = null;     // Catch: Throwable -> L11
    L6:
        com.ss.android.lark.media.a r102 = this.videoResourceInterruptListener;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        MediaMutex r103 = MediaMutex.f431631r;     // Catch: Throwable -> L11
        MediaMutex.f431631r.n(Scene.CCM_Audio_Play, r102);     // Catch: Throwable -> L11
        this.videoResourceInterruptListener = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public DriveMediaVM() {
        this.isAutoPlay = true;
        this.hexString = Integer.toHexString(hashCode());
        this.playPosition = new MutableLiveData();
        this.resumePosition = new MutableLiveData();
        this.pauseMedia = new MutableLiveData();
        this.startMedia = new MutableLiveData();
    }

    public final String getHexString() {
        return this.hexString;
    }

    public final MutableLiveData<Boolean> getPauseMedia() {
        return this.pauseMedia;
    }

    public final MutableLiveData<Long> getPlayPosition() {
        return this.playPosition;
    }

    public final MutableLiveData<Long> getResumePosition() {
        return this.resumePosition;
    }

    public final MutableLiveData<Boolean> getStartMedia() {
        return this.startMedia;
    }

    public final boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public final void setAutoPlay(boolean r100) {
        this.isAutoPlay = r100;
    }

    public final synchronized void tryPlayAudio(u95.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "mediaResourceConnector");     // Catch: Throwable -> L6
        tt5.a.h(TAG, "tryPlayAudio");     // Catch: Throwable -> L6
        tryReleaseMediaMutex();     // Catch: Throwable -> L6
        b r101 = new b(this, ServiceType.AUDIO, r100);     // Catch: Throwable -> L6
        MediaMutex.f431631r.l(Scene.CCM_Audio_Play, true, r101, true);     // Catch: Throwable -> L6
        this.audioResourceInterruptListener = r101;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void tryPlayVideo(u95.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "mediaResourceConnector");     // Catch: Throwable -> L6
        tt5.a.h(TAG, "tryPlayVideo");     // Catch: Throwable -> L6
        tryReleaseMediaMutex();     // Catch: Throwable -> L6
        b r101 = new b(this, "Video", r100);     // Catch: Throwable -> L6
        MediaMutex.f431631r.l(Scene.CCM_Audio_Play, true, r101, true);     // Catch: Throwable -> L6
        this.videoResourceInterruptListener = r101;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
