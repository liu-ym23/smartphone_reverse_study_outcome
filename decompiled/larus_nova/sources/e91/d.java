package e91;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.n;
import yt1.o;
import yt1.q;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends a<AnchorTabLabel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f471429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f471430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f471431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f471432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f471433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f471434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f471435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f471436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f471437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f471438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m91.c f471439n;

    @Override // e91.a
    public final void c() {
        this.f471438m = false;
        super.c();
    }

    @Override // e91.a, com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        super.b();
        this.f471438m = true;
        q r100 = this.f471435j;
        if (r100 == null) goto L8;
        n r101 = this.f471433h;
        if (r101 == null) goto L9;
        r101.a(r100, this.f471434i);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f471436k = System.currentTimeMillis();
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        q r102 = null;
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.q r103 = IRoomContextService.a.b(r101, this.f471439n.getDataCenter(), 2);
        if (r103 == null) goto L9;
        j<n> r104 = r103.E1();
        if (r104 == null) goto L9;
        n r105 = r104.getValue();
    L10:
        this.f471433h = r105;
        LiveDSLModel r106 = r100.getDslLabel();
        if (r106 == null) goto L13;
        o.f569030e.getClass();
        o r107 = o.a.b(r106);
        this.f471435j = r107.f569032b;
        Unit r108 = Unit.INSTANCE;
    L14:
        this.f471437l = r107;
        n r109 = this.f471433h;
        boolean r110 = true;
        if (r109 == null) goto L26;
        if (r107 == null) goto L18;
        String r111 = r107.getType();
    L19:
        o r112 = this.f471437l;
        if (r112 == null) goto L23;
        r102 = r112.f569032b;
    L23:
        if (r109.b(r111, r102) != true) goto L26;
        r110 = false;
        goto L26
    L18:
        r111 = null;
    L26:
        String r113 = "render label, noCache:" + r110;
        if (v.a() == false) goto L29;
        ALogger.i("DslLabelController", r113);
    L29:
        Intrinsics.checkNotNullParameter(r100, "data");
        ViewGroup r114 = this.f471424b.getContainer();
        if (this.f471423a == true) goto L49;
        if (r114 == null) goto L50;
        o r115 = this.f471437l;
        if (r115 == null) goto L54;
        n r116 = this.f471433h;
        if (r116 == null) goto L55;
        LiveDSLModel r117 = r100.getDslLabel();
        if (r117 == null) goto L51;
        String r118 = r117.getDslData();
        if (r118 != null) goto L43;
        r118 = "";
    L43:
        k r119 = r116.c(r115, r118, r114.getContext(), null, new c(this, r116, r114));
        this.f471434i = r119;
        if (r119 == null) goto L52;
        View r120 = r119.getView();
        if (r120 == null) goto L53;
        a1.p(r114, this.f471432g);
        a1.k(r114, this.f471431f);
        r114.addView(r120);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L55:
        return;
    L54:
        return;
    L50:
        return;
    L49:
        return;
    L13:
        r107 = null;
    L9:
        r105 = null;
        goto L10
    }

    public d(m91.c r100, com.bytedance.android.live.room.navi.userinfo_p.presenter.h r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r101);
        this.f471439n = r100;
        this.f471428c = UtilityKotlinExtentionsKt.i(30);
        this.f471429d = UtilityKotlinExtentionsKt.i(8);
        this.f471430e = UtilityKotlinExtentionsKt.i(78);
        this.f471431f = UtilityKotlinExtentionsKt.i(12);
        this.f471432g = UtilityKotlinExtentionsKt.i(110);
        new CompositeDisposable();
    }
}
