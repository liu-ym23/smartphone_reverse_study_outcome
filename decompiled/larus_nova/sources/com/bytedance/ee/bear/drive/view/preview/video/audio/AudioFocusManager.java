package com.bytedance.ee.bear.drive.view.preview.video.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.bytedance.ee.bear.drive.view.preview.video.player.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class AudioFocusManager implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f225533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f225534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f225535c;

    public final class a implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AudioFocusRequest f225536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioFocusManager f225537b;

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void b() {
            AudioFocusRequest r100 = this.f225536a;
            if (r100 == null) goto L5;
            ((AudioManager) this.f225537b.f225534b.getValue()).abandonAudioFocusRequest(r100);
        L5:
            this.f225536a = null;
        }

        public a(AudioFocusManager r100) {
            this.f225537b = r100;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void a(n r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            AudioFocusRequest.Builder r101 = new AudioFocusRequest.Builder(1);
            AudioAttributes.Builder r102 = new AudioAttributes.Builder();
            r102.setUsage(14);
            r102.setContentType(2);
            r101.setAudioAttributes(r102.build());
            r101.setAcceptsDelayedFocusGain(true);
            r101.setOnAudioFocusChangeListener(r100);
            AudioFocusRequest r103 = r101.build();
            this.f225536a = r103;
            r100.onAudioFocusChange(((AudioManager) this.f225537b.f225534b.getValue()).requestAudioFocus(r103));
        }
    }

    public final class b implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AudioManager.OnAudioFocusChangeListener f225538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioFocusManager f225539b;

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void b() {
            AudioManager.OnAudioFocusChangeListener r100 = this.f225538a;
            if (r100 == null) goto L5;
            ((AudioManager) this.f225539b.f225534b.getValue()).abandonAudioFocus(r100);
        L5:
            this.f225538a = null;
        }

        public b(AudioFocusManager r100) {
            this.f225539b = r100;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void a(n r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f225538a = r100;
            r100.onAudioFocusChange(((AudioManager) this.f225539b.f225534b.getValue()).requestAudioFocus(r100, 3, 1));
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
    public final void b() {
        tt5.a.h("AudioFocusManager", "abandonAudioFocus");
        ((com.bytedance.ee.bear.drive.view.preview.video.audio.a) this.f225535c.getValue()).b();
    }

    public AudioFocusManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f225533a = r100;
        this.f225534b = LazyKt.lazy(new AudioFocusManager$audioManager$2(this));
        this.f225535c = LazyKt.lazy(new AudioFocusManager$delegate$2(this));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        tt5.a.h("AudioFocusManager", "requestAudioFocus");
        ((com.bytedance.ee.bear.drive.view.preview.video.audio.a) this.f225535c.getValue()).a(r100);
    }
}
