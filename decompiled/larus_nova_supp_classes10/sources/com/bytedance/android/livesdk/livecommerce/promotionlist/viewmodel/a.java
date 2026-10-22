package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0097a extends a {
        public final JsonObject a;

        public C0097a(JsonObject r1) {
            this.a = r1;
        }
    }

    public static final class a0 extends a {
        public a0() {
        }
    }

    public static final class b extends a {
        public final float a;

        public b(float r1) {
            this.a = r1;
        }
    }

    public static final class b0 extends a {
        public final ECLottieAnimationView a;
        public final boolean b;

        public b0(ECLottieAnimationView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends a {
        public final int a;

        public c(int r1) {
            this.a = r1;
        }
    }

    public static final class c0 extends a {
        public c0() {
        }
    }

    public static final class d extends a {
        public final String a;
        public final boolean b;
        public final boolean c;

        public d(String r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "component");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d0 extends a {
        public final PromotionCategory a;

        public d0(PromotionCategory r1) {
            this.a = r1;
        }
    }

    public static final class e extends a {
        public final PromotionCategory a;

        public e(PromotionCategory r2) {
            Intrinsics.checkNotNullParameter(r2, "toCategory");
            this.a = r2;
        }
    }

    public static final class e0 extends a {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
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

    public static final class f0 extends a {
        public final boolean a;

        public f0() {
            this.a = false;
        }
    }

    public static final class g extends a {
        public final boolean a;

        public g() {
            this(false);
        }

        public g(boolean r1) {
            this.a = r1;
        }
    }

    public static final class g0 extends a {
        public final xi2.e0 a;

        public g0(xi2.e0 r1) {
            this.a = r1;
        }
    }

    public static final class h extends a {
        public final boolean a;

        public h(boolean r1) {
            this.a = r1;
        }
    }

    public static final class h0 extends a {
        public final com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a a;

        public h0(com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a r2) {
            Intrinsics.checkNotNullParameter(r2, "cardRegionData");
            this.a = r2;
        }
    }

    public static final class i extends a {
        public final int a;
        public final int b;

        public i(int r2) {
            this.a = 0;
            this.b = r2;
        }
    }

    public static final class i0 extends a {
        public final String a;
        public final List<String> b;

        public i0(String r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j extends a {
    }

    public static final class k extends a {
        public final si2.m a;

        public k(si2.m r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
        }
    }

    public static final class l extends a {
        public final PageListLoadStatus a;

        public l(PageListLoadStatus r2) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.a = r2;
        }
    }

    public static final class m extends a {
        public final PageListLoadStatus a;

        public m(PageListLoadStatus r2) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.a = r2;
        }
    }

    public static final class n extends a {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }
    }

    public static final class o extends a {
        public o() {
        }
    }

    public static final class p extends a {
        public final boolean a;

        public p(boolean r1) {
            this.a = r1;
        }
    }

    public static final class q extends a {
        public q() {
        }
    }

    public static final class r extends a {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }
    }

    public static final class s extends a {
        public final boolean a;

        public s(boolean r1) {
            this.a = r1;
        }
    }

    public static final class t extends a {
        public final List<cf.x> a;

        public t(List<cf.x> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.a = r2;
        }
    }

    public static final class u extends a {
        public u() {
        }
    }

    public static final class v extends a {
        public final we3.d a;

        public v(we3.d r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }

    public static final class w extends a {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
        }
    }

    public static final class x extends a {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
        }
    }

    public static final class y extends a {
        public final ml.b a;

        public y(ml.b r2) {
            Intrinsics.checkNotNullParameter(r2, "selectRoom");
            this.a = r2;
        }
    }

    public static final class z extends a {
        public final Function0<View> a;

        /* JADX WARN: Multi-variable type inference failed */
        public z(Function0<? extends View> r2) {
            Intrinsics.checkNotNullParameter(r2, "getView");
            this.a = r2;
        }
    }

    public a() {
    }
}
