package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import android.media.AudioManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z implements r {
    public final Context a;

    public static final class a {
    }

    public static final class b implements s {
        public boolean a;
        public final AudioManager b;
        public final AudioManager.OnAudioFocusChangeListener c;

        public b(AudioManager r3) {
            a0 r0 = a0.a;
            Intrinsics.checkNotNullParameter(r3, "audioManager");
            Intrinsics.checkNotNullParameter(r0, "listener");
            this.b = r3;
            this.c = r0;
        }

        @Override // com.bytedance.android.shopping.commentv3.audio.s
        public final void a(StopReason r5) {
            Intrinsics.checkNotNullParameter(r5, "reason");
            if (this.a == false) goto L5;
            return;
        L5:
            this.a = true;
            this.b.abandonAudioFocus(this.c);     // Catch: Exception -> L8
            dm.a.a("CommentExternalAudio").i("restore external audio, reason: " + r5);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            dm.a.a("CommentExternalAudio").b("restore external audio failed, reason: " + r5, e);
        }
    }

    static {
    }

    public z(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2.getApplicationContext();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.r
    public final b a(t r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        if (r8.e != ExternalAudioTargetScope.NONE) goto L18;
        return null;
    L18:
        Object r2 = this.a.getSystemService("audio");     // Catch: Exception -> L15
        if ((r2 instanceof AudioManager) == true) goto L8;
        r2 = null;
    L8:
        AudioManager r3 = (AudioManager) r2;     // Catch: Exception -> L15
        if (r3 != null) goto L11;
        return null;
    L11:
        int r4 = r3.requestAudioFocus(a0.a, 3, 2);     // Catch: Exception -> L15
        dm.a.a("CommentExternalAudio").i("interrupt external audio, result: " + r4 + ", sliceId: " + r8.b);     // Catch: Exception -> L15
        if (r4 != 1) goto L20;
        return new b(r3);
    L20:
        return null;
    L15:
        e = move-exception;
        dm.a.a("CommentExternalAudio").b("interrupt external audio failed, sliceId: " + r8.b, e);
        return null;
    }
}
