package com.bytedance.ee.bear.drive.view.preview.video.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.bytedance.ee.bear.drive.view.preview.video.player.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AudioFocusManager implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public final class a implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {
        public AudioFocusRequest a;
        public final /* synthetic */ AudioFocusManager b;

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void b() {
            AudioFocusRequest r0 = this.a;
            if (r0 == null) goto L5;
            ((AudioManager) this.b.b.getValue()).abandonAudioFocusRequest(r0);
        L5:
            this.a = null;
        }

        public a(AudioFocusManager r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void a(n r5) {
            Intrinsics.checkNotNullParameter(r5, "listener");
            AudioFocusRequest.Builder r0 = new AudioFocusRequest.Builder(1);
            AudioAttributes.Builder r2 = new AudioAttributes.Builder();
            r2.setUsage(14);
            r2.setContentType(2);
            r0.setAudioAttributes(r2.build());
            r0.setAcceptsDelayedFocusGain(true);
            r0.setOnAudioFocusChangeListener(r5);
            AudioFocusRequest r1 = r0.build();
            this.a = r1;
            r5.onAudioFocusChange(((AudioManager) this.b.b.getValue()).requestAudioFocus(r1));
        }
    }

    public final class b implements com.bytedance.ee.bear.drive.view.preview.video.audio.a {
        public AudioManager.OnAudioFocusChangeListener a;
        public final /* synthetic */ AudioFocusManager b;

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void b() {
            AudioManager.OnAudioFocusChangeListener r0 = this.a;
            if (r0 == null) goto L5;
            ((AudioManager) this.b.b.getValue()).abandonAudioFocus(r0);
        L5:
            this.a = null;
        }

        public b(AudioFocusManager r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
        public final void a(n r4) {
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.a = r4;
            r4.onAudioFocusChange(((AudioManager) this.b.b.getValue()).requestAudioFocus(r4, 3, 1));
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
    public final void b() {
        tt5.a.h("AudioFocusManager", "abandonAudioFocus");
        ((com.bytedance.ee.bear.drive.view.preview.video.audio.a) this.c.getValue()).b();
    }

    public AudioFocusManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new AudioFocusManager$audioManager$2(this));
        this.c = LazyKt.lazy(new AudioFocusManager$delegate$2(this));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.audio.a
    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("AudioFocusManager", "requestAudioFocus");
        ((com.bytedance.ee.bear.drive.view.preview.video.audio.a) this.c.getValue()).a(r3);
    }
}
