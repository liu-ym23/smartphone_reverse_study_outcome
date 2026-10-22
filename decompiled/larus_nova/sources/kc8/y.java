package kc8;

import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class y {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f502619J = 0;
    public final z A;
    public final Function1<Boolean, Unit> B;
    public final Function0<Unit> C;
    public final Function1<Boolean, Unit> D;
    public final Function0<Integer> E;
    public final Function0<Integer> F;
    public final Function2<Integer, Integer, Unit> G;
    public final Function4<Integer, Integer, Interpolator, Integer, Unit> H;
    public final Function1<Integer, Unit> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f502620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f502621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final by7.e f502622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f502623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<wc9.e> f502624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f502625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f502626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f502627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f502628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f502629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f502630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<BotModel> f502631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<ChatParam> f502632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<ChatPageContext> f502633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<de8.c> f502634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<e5> f502635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Boolean> f502636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j f502637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<Map<String, Object>> f502638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Integer f502639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0.a f502640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AttachReceiver f502641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RecyclerView.Adapter<?> f502642w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0 f502643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LruSet<String> f502644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Function1<Integer, Unit> f502645z;

    public static final class a {
        public com.larus.bmhome.chat.api.q0 A;
        public LruSet<String> B;
        public Fragment C;
        public z D;
        public Function2<? super Integer, ? super Integer, Unit> E;
        public Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> F;
        public Function0<Integer> G;
        public Function0<Integer> H;
        public Function1<? super Integer, Unit> I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super Boolean, Unit> f502646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super Boolean, Unit> f502647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function0<Unit> f502648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super Integer, Unit> f502649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f502650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public by7.e f502651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RecyclerView f502652g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function0<BotModel> f502653h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Function0<ChatParam> f502654i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Function0<ChatPageContext> f502655j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Function0<de8.c> f502656k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Function0<e5> f502657l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Function0<Boolean> f502658m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public j f502659n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Function0<wc9.e> f502660o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Function0<String> f502661p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f502662q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Boolean f502663r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Integer f502664s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Boolean f502665t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Integer f502666u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Function0<? extends Map<String, ? extends Object>> f502667v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Integer f502668w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public com.larus.bmhome.chat.api.q0.a f502669x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public AttachReceiver f502670y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public RecyclerView.Adapter<?> f502671z;

        /* JADX INFO: renamed from: kc8.y$a$a, reason: collision with other inner class name */
        public static final class C6538a implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C6538a f502672a = null;

            static {
                f502672a = new C6538a();
            }

            public C6538a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class b implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f502673a = null;

            static {
                f502673a = new b();
            }

            public b() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class c implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f502674a = null;

            static {
                f502674a = new c();
            }

            public c() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class d implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f502675a = null;

            static {
                f502675a = new d();
            }

            public d() {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
                ((Number) r100).intValue();
                ((Number) r101).intValue();
                return null;
            }
        }

        public static final class e implements Function4 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f502676a = null;

            static {
                f502676a = new e();
            }

            public e() {
            }

            @Override // kotlin.jvm.functions.Function4
            public final /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Object r103) {
                ((Number) r100).intValue();
                ((Number) r101).intValue();
                Interpolator r104 = (Interpolator) r102;
                ((Number) r103).intValue();
                return null;
            }
        }

        public static final class f implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f502677a = null;

            static {
                f502677a = new f();
            }

            public f() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public final y a() {
            Long r100 = this.f502650e;
            by7.e r101 = this.f502651f;
            RecyclerView r102 = this.f502652g;
            Function0<BotModel> r110 = this.f502653h;
            Function0<ChatParam> r111 = this.f502654i;
            Function0<ChatPageContext> r112 = this.f502655j;
            Function0<de8.c> r103 = this.f502656k;
            Function0<e5> r104 = this.f502657l;
            Function0<Boolean> r105 = this.f502658m;
            j r106 = this.f502659n;
            Function0<wc9.e> r107 = this.f502660o;
            Function0<String> r108 = this.f502661p;
            Boolean r109 = this.f502662q;
            Boolean r113 = this.f502663r;
            Integer r114 = this.f502664s;
            Boolean r115 = this.f502665t;
            Integer r116 = this.f502666u;
            Function0<? extends Map<String, ? extends Object>> r117 = this.f502667v;
            Integer r118 = this.f502668w;
            com.larus.bmhome.chat.api.q0.a r119 = this.f502669x;
            AttachReceiver r120 = this.f502670y;
            RecyclerView.Adapter<?> r121 = this.f502671z;
            com.larus.bmhome.chat.api.q0 r122 = this.A;
            LruSet<String> r123 = this.B;
            Function1<? super Integer, Unit> r124 = this.f502649d;
            z r125 = this.D;
            Function1<? super Boolean, Unit> r126 = this.f502646a;
            Function0<Unit> r127 = this.f502648c;
            Fragment r128 = this.C;
            Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r129 = this.F;
            Function2<? super Integer, ? super Integer, Unit> r130 = this.E;
            Function0<Integer> r131 = this.G;
            Function0<Integer> r132 = this.H;
            return new y(r128, r100, r101, r102, r107, r108, r109, r113, r115, r114, r116, r110, r111, r112, r103, r104, r105, r106, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, this.f502647b, r131, r132, r130, r129, this.I);
        }

        public a() {
            this.f502655j = b.f502673a;
            this.f502656k = C6538a.f502672a;
            this.f502657l = c.f502674a;
            Boolean r100 = Boolean.FALSE;
            this.f502662q = r100;
            this.f502663r = r100;
            this.f502665t = r100;
            this.f502667v = f.f502677a;
            this.E = d.f502675a;
            this.F = e.f502676a;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean a() {
        if (this.f502630k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final a b() {
        a r100 = new a();
        r100.C = this.f502620a;
        r100.f502650e = this.f502621b;
        r100.f502651f = this.f502622c;
        r100.f502652g = this.f502623d;
        r100.f502660o = this.f502624e;
        r100.f502661p = this.f502625f;
        r100.f502662q = this.f502626g;
        r100.f502663r = this.f502627h;
        r100.f502665t = this.f502628i;
        r100.f502664s = this.f502629j;
        r100.f502666u = this.f502630k;
        r100.f502653h = this.f502631l;
        r100.f502654i = this.f502632m;
        r100.f502667v = this.f502638s;
        r100.f502668w = this.f502639t;
        r100.f502669x = this.f502640u;
        r100.f502670y = this.f502641v;
        r100.f502671z = this.f502642w;
        r100.A = this.f502643x;
        r100.B = this.f502644y;
        r100.f502649d = this.f502645z;
        r100.D = this.A;
        r100.f502646a = this.B;
        r100.f502648c = this.C;
        r100.f502647b = this.D;
        r100.G = this.E;
        Function2<Integer, Integer, Unit> r101 = this.G;
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.E = r101;
        Function4<Integer, Integer, Interpolator, Integer, Unit> r102 = this.H;
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.F = r102;
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(Fragment r100, Long r101, by7.e r102, RecyclerView r103, Function0<wc9.e> r104, Function0<String> r110, Boolean r111, Boolean r112, Boolean r113, Integer r114, Integer r115, Function0<BotModel> r116, Function0<ChatParam> r117, Function0<ChatPageContext> r118, Function0<de8.c> r119, Function0<e5> r210, Function0<Boolean> r211, j r212, Function0<? extends Map<String, ? extends Object>> r213, Integer r214, com.larus.bmhome.chat.api.q0.a r215, AttachReceiver r216, RecyclerView.Adapter<?> r217, com.larus.bmhome.chat.api.q0 r218, LruSet<String> r219, Function1<? super Integer, Unit> r310, z r311, Function1<? super Boolean, Unit> r312, Function0<Unit> r313, Function1<? super Boolean, Unit> r314, Function0<Integer> r315, Function0<Integer> r316, Function2<? super Integer, ? super Integer, Unit> r317, Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r318, Function1<? super Integer, Unit> r319) {
        Intrinsics.checkNotNullParameter(r317, "scrollBy");
        Intrinsics.checkNotNullParameter(r318, "smoothScrollBy");
        this.f502620a = r100;
        this.f502621b = r101;
        this.f502622c = r102;
        this.f502623d = r103;
        this.f502624e = r104;
        this.f502625f = r110;
        this.f502626g = r111;
        this.f502627h = r112;
        this.f502628i = r113;
        this.f502629j = r114;
        this.f502630k = r115;
        this.f502631l = r116;
        this.f502632m = r117;
        this.f502633n = r118;
        this.f502634o = r119;
        this.f502635p = r210;
        this.f502636q = r211;
        this.f502637r = r212;
        this.f502638s = r213;
        this.f502639t = r214;
        this.f502640u = r215;
        this.f502641v = r216;
        this.f502642w = r217;
        this.f502643x = r218;
        this.f502644y = r219;
        this.f502645z = r310;
        this.A = r311;
        this.B = r312;
        this.C = r313;
        this.D = r314;
        this.E = r315;
        this.F = r316;
        this.G = r317;
        this.H = r318;
        this.I = r319;
    }
}
