package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0077a extends a {
        public final ni2.a a;
        public final View b;

        public C0077a(ni2.a r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public final boolean a;

        public c(boolean r1) {
            this.a = r1;
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
        public final int a;

        public e(int r1) {
            this.a = r1;
        }
    }

    public static final class f extends a {
        public final int a;

        public f(int r1) {
            this.a = r1;
        }
    }

    public static final class g extends a {
        public final int a;
        public final boolean b;

        public g(int r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h extends a {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }
    }

    public static final class i extends a {
        public final ni2.a a;
        public final View b;

        public i(ni2.a r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public a() {
    }
}
