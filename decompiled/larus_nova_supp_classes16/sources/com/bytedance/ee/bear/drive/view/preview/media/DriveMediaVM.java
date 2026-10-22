package com.bytedance.ee.bear.drive.view.preview.media;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final String a;
        public final u95.a b;
        public final /* synthetic */ DriveMediaVM c;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.d();     // Catch: Throwable -> L4
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
        public static final class RunnableC0180b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ MediaMutex.LockError b;

            public RunnableC0180b(b r1, MediaMutex.LockError r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.b(this.b.getErrorMessage());     // Catch: Throwable -> L4
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
            public final /* synthetic */ b a;

            public c(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.c();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onSuccess() {
            tt5.a.h(DriveMediaVM.TAG, this.a + " mediaResourceInterrupt onSuccess");
            m.a(new c(this));
        }

        public final void a(MediaMutex.LockError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            tt5.a.h(DriveMediaVM.TAG, this.a + " mediaResourceInterrupt onError, occupiedScene= " + r3.getOccupiedScene());
            this.c.tryReleaseMediaMutex();
            m.a(new RunnableC0180b(this, r3));
        }

        public final void b(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "byScene");
            Intrinsics.checkNotNullParameter(r4, "type");
            tt5.a.h(DriveMediaVM.TAG, this.a + " mediaResourceWasInterrupted, byScene= " + r3 + ", type= " + r4);
            m.a(new com.bytedance.ee.bear.drive.view.preview.media.a(this));
        }

        public final void c(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "fromScene");
            Intrinsics.checkNotNullParameter(r4, "type");
            tt5.a.h(DriveMediaVM.TAG, this.a + " mediaResourceInterruptionEnd, fromScene= " + r3 + ", type= " + r4);
            m.a(new a(this));
        }

        public b(DriveMediaVM r2, String r3, u95.a r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "connector");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    static {
        Companion = new a();
    }

    public final synchronized void tryReleaseMediaMutex() {
        monitor-enter(this);
        tt5.a.h(TAG, "tryReleaseMediaMutex");     // Catch: Throwable -> L11
        com.ss.android.lark.media.a r0 = this.audioResourceInterruptListener;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        MediaMutex r2 = MediaMutex.r;     // Catch: Throwable -> L11
        MediaMutex.r.n(Scene.CCM_Audio_Play, r0);     // Catch: Throwable -> L11
        this.audioResourceInterruptListener = null;     // Catch: Throwable -> L11
    L6:
        com.ss.android.lark.media.a r1 = this.videoResourceInterruptListener;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        MediaMutex r3 = MediaMutex.r;     // Catch: Throwable -> L11
        MediaMutex.r.n(Scene.CCM_Audio_Play, r1);     // Catch: Throwable -> L11
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

    public final void setAutoPlay(boolean r1) {
        this.isAutoPlay = r1;
    }

    public final synchronized void tryPlayAudio(u95.a r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "mediaResourceConnector");     // Catch: Throwable -> L6
        tt5.a.h(TAG, "tryPlayAudio");     // Catch: Throwable -> L6
        tryReleaseMediaMutex();     // Catch: Throwable -> L6
        b r0 = new b(this, "Audio", r4);     // Catch: Throwable -> L6
        MediaMutex.r.l(Scene.CCM_Audio_Play, true, r0, true);     // Catch: Throwable -> L6
        this.audioResourceInterruptListener = r0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void tryPlayVideo(u95.a r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "mediaResourceConnector");     // Catch: Throwable -> L6
        tt5.a.h(TAG, "tryPlayVideo");     // Catch: Throwable -> L6
        tryReleaseMediaMutex();     // Catch: Throwable -> L6
        b r0 = new b(this, "Video", r4);     // Catch: Throwable -> L6
        MediaMutex.r.l(Scene.CCM_Audio_Play, true, r0, true);     // Catch: Throwable -> L6
        this.videoResourceInterruptListener = r0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
