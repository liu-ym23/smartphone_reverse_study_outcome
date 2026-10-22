package kh2;

import com.bytedance.android.livesdk.livecommerce.event.d1;
import com.bytedance.android.livesdk.livecommerce.event.refactor.EntranceShowStatusByRoomState;
import com.bytedance.android.livesdk.livecommerce.event.refactor.ReportWhenEnter;
import com.bytedance.android.livesdk.livecommerce.event.refactor.RequestLivePromotions;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public final a a;

    public static final class a {
        public e<Integer> a;
        public e<Integer> b;
        public e<String> c;
        public e<String> d;
        public e<Integer> e;
        public e<Integer> f;
        public e<Integer> g;
        public e<Integer> h;
        public e<Integer> i;
        public e<Integer> j;
        public final k k;

        public a(f r3) {
            Intrinsics.checkNotNullParameter(r3, "shared");
            this.k = r3;
            this.a = new kh2.a(null);
            this.b = new d(null);
            this.c = EntranceShowStatusByRoomState.NO;
            this.d = new c(0);
            this.e = ReportWhenEnter.NO;
            this.f = new j(null);
            this.g = new i(null);
            this.h = RequestLivePromotions.NO;
            this.i = new g(null);
            this.j = new h(null);
        }

        public final void a(EntranceShowStatusByRoomState r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.c = r2;
        }

        public final void b(ReportWhenEnter r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.e = r2;
        }

        public final void c(RequestLivePromotions r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.h = r2;
        }
    }

    /* JADX INFO: renamed from: kh2.b$b, reason: collision with other inner class name */
    public static final class C0149b {
        @JvmStatic
        public static a a(f r1) {
            Intrinsics.checkNotNullParameter(r1, "shared");
            return new a(r1);
        }
    }

    static {
    }

    public final void a() {
        new d1(this.a.k.getValue(), this.a.a.getValue().intValue(), this.a.b.getValue().intValue(), this.a.c.getValue(), this.a.d.getValue(), this.a.e.getValue().intValue(), this.a.f.getValue().intValue(), this.a.g.getValue().intValue(), this.a.h.getValue().intValue(), this.a.i.getValue().intValue(), this.a.j.getValue().intValue()).k();
    }

    public b(a r1) {
        this.a = r1;
    }
}
