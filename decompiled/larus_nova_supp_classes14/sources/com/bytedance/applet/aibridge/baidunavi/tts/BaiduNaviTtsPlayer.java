package com.bytedance.applet.aibridge.baidunavi.tts;

import com.larus.audio.IFlowTtsClientService;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaiduNaviTtsPlayer {
    public final Lazy a;
    public a b;
    public a c;
    public final com.larus.media.model.a d;
    public final BaiduNaviTtsPlayer$mAudioPlayerListener$1 e;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final Map<String, String> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, String> r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "BaiduNaviTtsInfo(text=" + this.a + ", speakerStyleId=" + this.b + ", conversationId=" + this.c + ", payloadExtParams=" + this.d + ')';
        }

        public a(String r2, String r3, String r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "speakerStyleId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
    }

    public static final class c implements v {
        public final /* synthetic */ BaiduNaviTtsPlayer a;

        public c(BaiduNaviTtsPlayer r1) {
            this.a = r1;
        }

        public final boolean b(g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = o0.a;
            return o0.a("NAVIGATION", r2.getScene());
        }

        public final void e(g r4) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            v.a.d(r4);
            this.a.a().f("onMediaInterrupted by BaiduNaviTtsPlayer");
            FLogger.a.i("BaiduNaviTtsPlayer", "audio focus gainOccupiedStrategy and interrupt. applicant:" + r4 + ", current: NAVIGATION.");
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(g r1, float r2) {
            v.a.f(r1, r2);
        }

        public final void d(g r1, g r2) {
            v.a.c(r1, r2);
        }

        public final void g(g r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            v.a.g(r4, r5);
            this.a.a().setVolume(r5);
            FLogger.a.i("BaiduNaviTtsPlayer", "audio focus onMediaVolumeChange. applicant:" + r4 + ", volumeFactor: " + r5 + '.');
        }

        public final void i(g r1, g r2) {
            v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(g r1, g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(g r1, g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    static {
    }

    public final IFlowTtsClientService a() {
        return (IFlowTtsClientService) this.a.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.baidunavi.tts.BaiduNaviTtsPlayer$mAudioPlayerListener$1] */
    public BaiduNaviTtsPlayer() {
        this.a = LazyKt.lazy(new com.bytedance.applet.aibridge.baidunavi.tts.c());
        this.d = new com.larus.media.model.a(null, "NAVIGATION", false, 1, 2, false, 0, false, false, 0, false, new c(this), 2021);
        this.e = new BaiduNaviTtsPlayer$mAudioPlayerListener$1(this);
    }

    public final void b(final a r4, boolean r5) {
        monitor-enter(this);
        if (r5 == true) goto L12;
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L12;
        this.c = r4;     // Catch: Throwable -> L9
        FLogger.a.i("BaiduNaviTtsPlayer", "tts waiting for play");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L12:
        this.c = null;     // Catch: Throwable -> L9
        this.b = r4;     // Catch: Throwable -> L9
        FLogger.a.i("BaiduNaviTtsPlayer", "tts ready for play");     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        a().f("startTts by BaiduNaviTtsPlayer");
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(this.d, new com.bytedance.applet.aibridge.baidunavi.tts.a(r7, this, r4), new com.bytedance.applet.aibridge.baidunavi.tts.b(this), 0, 8);
    }
}
