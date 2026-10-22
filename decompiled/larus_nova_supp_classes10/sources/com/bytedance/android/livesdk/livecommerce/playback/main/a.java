package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.a$a, reason: collision with other inner class name */
    public static final class C0082a extends a {
        public final String a;

        public C0082a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final boolean a;

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a {
        public final ECUIPromotion a;
        public final ExplainPlaybackVideoInfo b;

        public e(ECUIPromotion r1, ExplainPlaybackVideoInfo r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f extends a {
        public f() {
        }
    }

    public static final class g extends a {
        static {
            new g();
        }

        public g() {
        }
    }

    public static final class h extends a {
        public h() {
        }
    }

    public static final class i extends a {
        public final ECUIPromotion a;
        public final ExplainPlaybackVideoInfo b;

        public i(ECUIPromotion r1, ExplainPlaybackVideoInfo r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j extends a {
        static {
            new j();
        }

        public j() {
        }
    }

    public static final class k extends a {
        public final boolean a;

        public k() {
            this.a = false;
        }
    }

    public static final class l extends a {
        public final boolean a;

        public l() {
            this.a = false;
        }
    }

    public static final class m extends a {
    }

    public static final class n extends a {
        public final boolean a;

        public n(boolean r1) {
            this.a = r1;
        }
    }

    public static final class o extends a {
        public final boolean a;

        public o(boolean r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
