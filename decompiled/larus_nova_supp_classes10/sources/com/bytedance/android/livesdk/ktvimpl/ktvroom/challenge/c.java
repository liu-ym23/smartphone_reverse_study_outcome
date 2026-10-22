package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class c {
    public final String a;

    public static final class a extends c {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("OnClose");
        }
    }

    public static final class b extends c {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("OnEnd");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c$c, reason: collision with other inner class name */
    public static final class C0025c extends c {
        public final MusicPanel b;
        public final boolean c;
        public final boolean d;

        public C0025c() {
            super("OnFailure");
            this.b = null;
            this.c = true;
            this.d = true;
        }
    }

    public static final class d extends c {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("OnPrepare");
        }
    }

    public static final class e extends c {
        public final long b;
        public final long c;

        public e(long r2, long r4) {
            super("OnStart");
            this.b = r2;
            this.c = r4;
        }
    }

    public static final class f extends c {
        public final long b;

        public f(long r1, long r3) {
            super("OnSuccess");
            this.b = r1;
        }
    }

    public static final class g extends c {
        public final long b;

        public g(long r1, long r3, Long r5, Long r6) {
            super("OnUpdateScore");
            this.b = r1;
        }
    }

    public final String toString() {
        return this.a;
    }

    public c(String r1) {
        this.a = r1;
    }
}
