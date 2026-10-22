package uv2;

import am2.x;
import com.bytedance.android.live.profit.vip.h;
import com.bytedance.android.live.profit.vip.l;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.utils.j6;
import com.bytedance.android.livesdk.utils.k6;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends ExpressionSection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f551802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f551803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f551804e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f551805a;

        public a(c r100) {
            this.f551805a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f551805a.g(ExpressionSection.EnterType.DRAW);
            Disposable r102 = this.f551805a.f551803d;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            this.f551805a.f551803d = null;
        }
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final int b() {
        return R.drawable.ttlive_ic_subscribe_section;
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final /* bridge */ /* synthetic */ CharSequence c() {
        return "会员表情";
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final void d() {
        Disposable r100 = this.f551803d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f551803d = null;
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final boolean a() {
        return this.f551802c;
    }

    public c(String r100) {
        this.f551804e = r100;
        this.f551802c = true;
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final void e(ExpressionSection.EnterType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ExpressionSection.EnterType.CLICK) goto L5;
        k6.b(2, false);
    L5:
        f(false);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = l42.a.f507337x;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, 3);
        com.bytedance.android.live.profit.vip.e r102 = yt0.c.l();
        if (r102 == null) goto L8;
        r102.bn("emoji");
    L8:
        com.bytedance.android.live.profit.vip.e r103 = yt0.c.l();
        if (r103 == null) goto L15;
        m<Boolean> r104 = r103.isEmojiPanelShow();
        if (r104 == null) goto L15;
        if (r104.getValue().booleanValue() != true) goto L15;
        g(r100);
        return;
    L15:
        com.bytedance.android.live.profit.vip.e r105 = yt0.c.l();
        if (r105 == null) goto L22;
        m<Boolean> r106 = r105.isEmojiPanelShow();
        if (r106 == null) goto L22;
        Observable<Boolean> r107 = r106.a();
        if (r107 == null) goto L22;
        Disposable r108 = r107.subscribe(new a(this));
    L23:
        this.f551803d = r108;
        return;
    L22:
        r108 = null;
        goto L23
    }

    public final void g(ExpressionSection.EnterType r110) {
        Intrinsics.checkNotNullParameter(r110, "type");
        com.bytedance.android.live.profit.vip.e r100 = yt0.c.l();
        if (r100 == null) goto L5;
        com.bytedance.android.live.profit.vip.b r101 = r100.u1();
    L6:
        com.bytedance.android.live.profit.vip.e r102 = yt0.c.l();
        if (r102 == null) goto L14;
        m<? extends h> r103 = r102.getSubscribeInfo();
        if (r103 == null) goto L14;
        h r104 = r103.getValue();
        if (r104 == null) goto L14;
        List r105 = r104.f89133a;
        if (r105 == null) goto L14;
    L16:
        if (r101 == null) goto L26;
        Iterator r106 = r105.iterator();
        boolean r107 = false;
    L19:
        if (r106.hasNext() == false) goto L23;
        l r108 = (l) r106.next();
        if (r108.f89152f == false) goto L19;
        r101.f89130a.add(Long.valueOf(r108.f89147a));
        r107 = true;
        goto L19
    L23:
        com.bytedance.android.live.profit.vip.e r109 = yt0.c.l();
        if (r109 == null) goto L27;
        r109.td(r101);
    L27:
        int r111 = k6.f159042a;
        String r112 = this.f551804e;
        Intrinsics.checkNotNullParameter(r110, "type");
        Pair[] r113 = new Pair[6];
        r113[0] = TuplesKt.to("livevip_status", k6.a());
        int r114 = j6.f158999a[r110.ordinal()];
        if (r114 == 1) goto L33;
        if (r114 != 2) goto L32;
        String r115 = "draw";
    L34:
        r113[1] = TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE, r115);
        if (l42.a.f507334u.getValue().booleanValue() == false) goto L37;
        String r116 = "vip_page";
    L38:
        r113[2] = TuplesKt.to("request_page", r116);
        com.bytedance.android.live.profit.vip.e r117 = yt0.c.l();
        if (r117 == null) goto L45;
        i<Boolean> r118 = r117.isAnchor();
        if (r118 == null) goto L45;
        Boolean r119 = r118.getValue();
        if (r119 == null) goto L45;
        boolean r120 = r119.booleanValue();
    L46:
        String r121 = "1";
        if (r120 == false) goto L49;
        Object r122 = "1";
    L50:
        r113[3] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r122);
        if (r107 == false) goto L53;
        Object r123 = "1";
    L54:
        r113[4] = TuplesKt.to("have_new", r123);
        if (Intrinsics.areEqual(r112, "emoji_detail_page") == true) goto L58;
        r121 = "0";
    L58:
        r113[5] = TuplesKt.to("is_from_screen_chat", r121);
        Map<String, String> r124 = MapsKt.mapOf(r113);
        j0.l().sendLog("livesdk_livevip_emoji_panel_show", r124, new Object[]{IRoom.class, x.class});
        return;
    L53:
        r123 = "0";
        goto L54
    L49:
        r122 = "0";
    L45:
        r120 = false;
        goto L46
    L37:
        r116 = "comment";
        goto L38
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r115 = "click";
        goto L34
    L26:
        r107 = false;
    L14:
        r105 = new ArrayList();
        goto L16
    L5:
        r101 = null;
        goto L6
    }
}
