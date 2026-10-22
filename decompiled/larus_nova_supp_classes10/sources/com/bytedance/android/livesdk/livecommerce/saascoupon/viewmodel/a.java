package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0127a extends a {
        public static final C0127a a = null;

        static {
            a = new C0127a();
        }

        public C0127a() {
        }
    }

    public static final class b extends a {
        public final boolean a;

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends a {
        public final Activity a;

        public final Activity getActivity() {
            return this.a;
        }

        public c(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            this.a = r2;
        }
    }

    public static final class d extends a {
        public final boolean a;

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public static final class e extends a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends a {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public static final class g extends a {
        public final String a;
        public final String b;
        public final String c;

        public g(String r3, String r4, String r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = "";
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = "";
        L8:
            Intrinsics.checkNotNullParameter(r3, "eventTag");
            Intrinsics.checkNotNullParameter(r4, "buttonType");
            Intrinsics.checkNotNullParameter(r5, "postCouponStatus");
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class h extends a {
        public final Activity a;

        public final Activity getActivity() {
            return this.a;
        }

        public h(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            this.a = r2;
        }
    }

    public a() {
    }
}
