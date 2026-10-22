package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomLyricsStateMachineConfig {
    public static final KtvRoomLyricsStateMachineConfig a = null;

    public static abstract class a {
        public final String a;
        public String b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$a$a, reason: collision with other inner class name */
        public static final class C0031a extends a {
            public static final C0031a c = null;

            static {
                c = new C0031a();
            }

            public C0031a() {
                super("CloseKtvRoom");
            }
        }

        public static final class b extends a {
            public final MusicPanel c;
            public final long d;

            public b() {
                this(0);
            }

            public /* synthetic */ b(int r3) {
                this(null, 0);
            }

            public b(MusicPanel r2, long r3) {
                super("PauseSing");
                this.c = r2;
                this.d = r3;
            }
        }

        public static final class c extends a {
            public final MusicPanel c;

            public c(MusicPanel r2) {
                Intrinsics.checkNotNullParameter(r2, "musicPanel");
                super("Prepare");
                this.c = r2;
            }
        }

        public static final class d extends a {
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k c;

            public d() {
                this(null);
            }

            public d(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2) {
                super("ResumeSing");
                this.c = r2;
            }
        }

        public static final class e extends a {
            public final MusicPanel c;
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k d;
            public final long e;

            public e(MusicPanel r2, com.bytedance.android.livesdk.ktvimpl.base.sei.k r3, long r4) {
                super("Sing");
                this.c = r2;
                this.d = r3;
                this.e = r4;
            }
        }

        public static final class f extends a {
            public final List<com.bytedance.component.lyric.model.b> c;

            public f(List<com.bytedance.component.lyric.model.b> r2) {
                Intrinsics.checkNotNullParameter(r2, "lyricsList");
                super("SingerBeginSing");
                this.c = r2;
            }
        }

        public static final class g extends a {
            public static final g c = null;

            static {
                c = new g();
            }

            public g() {
                super("StartKtvRoom");
            }
        }

        public static final class h extends a {
            public static final h c = null;

            static {
                c = new h();
            }

            public h() {
                super("StopSing");
            }
        }

        public static final class i extends a {
            public final MusicPanel c;

            public i(MusicPanel r2) {
                Intrinsics.checkNotNullParameter(r2, "nextMusic");
                super("TuningNext");
                this.c = r2;
            }
        }

        public final String toString() {
            return String.valueOf(this.a);
        }

        public a(String r1) {
            this.a = r1;
            this.b = "";
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$b$b, reason: collision with other inner class name */
        public static final class C0032b extends b {
            public static final C0032b a = null;

            static {
                a = new C0032b();
            }

            public C0032b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {
            public final MusicPanel a;
            public final c b;

            public e(MusicPanel r2, c r3) {
                Intrinsics.checkNotNullParameter(r2, "musicPanel");
                Intrinsics.checkNotNullParameter(r3, "snapshot");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class f extends b {
            public final boolean a;

            public f() {
                this(true);
            }

            public f(boolean r1) {
                this.a = r1;
            }
        }

        public b() {
        }
    }

    public static final class c {
        public final long a;
        public final MusicPanel b;
        public final List<com.bytedance.component.lyric.model.b> c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L12;
            c r7 = (c) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            MusicPanel r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            List<com.bytedance.component.lyric.model.b> r6 = this.c;
            if (r6 == null) goto L10;
            r3 = r6.hashCode();
        L10:
            return r5 + r3;
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "SingStateSnapshot(progress=" + this.a + ", currentMusic=" + this.b + ", currentLyricsLines=" + this.c + ")";
        }

        public c(long r2, MusicPanel r4, List<com.bytedance.component.lyric.model.b> r5) {
            Intrinsics.checkNotNullParameter(r4, "currentMusic");
            Intrinsics.checkNotNullParameter(r5, "currentLyricsLines");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }

        public static c a(c r1, long r2, MusicPanel r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = r1.a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r4 = r1.b;
        L9:
            if ((r5 & 4) == 0) goto L11;
            List<com.bytedance.component.lyric.model.b> r6 = r1.c;
        L12:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "currentMusic");
            Intrinsics.checkNotNullParameter(r6, "currentLyricsLines");
            return new c(r2, r4, r6);
        L11:
            r6 = null;
            goto L12
        }
    }

    public static abstract class d {
        public final String a;

        public static final class a extends d {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("Closed");
            }
        }

        public static final class b extends d {
            public static final b b = null;

            static {
                b = new b();
            }

            public b() {
                super("Idle");
            }
        }

        public static abstract class c extends d {
            public final MusicPanel b;

            public c(MusicPanel r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "currentMusic");
                Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
                super(r3);
                this.b = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$d$d, reason: collision with other inner class name */
        public static final class C0041d extends c {
            public final c c;

            public C0041d(MusicPanel r2, c r3) {
                Intrinsics.checkNotNullParameter(r2, "currentMusic");
                Intrinsics.checkNotNullParameter(r3, "snapshot");
                super(r2, "Paused");
                this.c = r3;
            }
        }

        public static final class e extends c {
            public e(MusicPanel r2) {
                Intrinsics.checkNotNullParameter(r2, "currentMusic");
                super(r2, "Preparing");
            }
        }

        public static final class f extends c {
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k c;
            public final c d;

            public f(MusicPanel r2, com.bytedance.android.livesdk.ktvimpl.base.sei.k r3, c r4) {
                Intrinsics.checkNotNullParameter(r2, "currentMusic");
                Intrinsics.checkNotNullParameter(r4, "snapshot");
                super(r2, "Singing");
                this.c = r3;
                this.d = r4;
            }
        }

        public final List<com.bytedance.component.lyric.model.b> a() {
            if ((this instanceof f) == false) goto L6;
            return ((f) this).d.c;
        L6:
            if ((this instanceof C0041d) == true) goto L11;
            return null;
        L11:
            return ((C0041d) this).c.c;
        }

        public final MusicPanel b() {
            if ((this instanceof c) == true) goto L7;
            return null;
        L7:
            return ((c) this).b;
        }

        public final com.bytedance.android.livesdk.ktvimpl.base.sei.k c() {
            if ((this instanceof f) == true) goto L7;
            return null;
        L7:
            return ((f) this).c;
        }

        public final String toString() {
            return String.valueOf(this.a);
        }

        public d(String r1) {
            this.a = r1;
        }
    }

    public KtvRoomLyricsStateMachineConfig() {
    }

    static {
        a = new KtvRoomLyricsStateMachineConfig();
    }

    public static StateMachine a(Function1 r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ALogger.i("logKtvMainPath", "createStateMachine for listener, invoke class :".concat(KtvRoomLyricsStateMachineConfig.class.getSimpleName()));
        StateMachine.a r0 = StateMachine.c;
        KtvRoomLyricsStateMachineConfig$createStateMachine$1 r1 = new KtvRoomLyricsStateMachineConfig$createStateMachine$1(r3, r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }

    public static StateMachine b(Function1 r2, d r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r3, "initState");
        ALogger.i("logKtvMainPath", "createStateMachineForSinger, invoke class :".concat(KtvRoomLyricsStateMachineConfig.class.getSimpleName()));
        StateMachine.a r0 = StateMachine.c;
        KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1 r1 = new KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1(r3, r4, r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }
}
