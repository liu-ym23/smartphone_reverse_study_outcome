package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f496913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f496914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f496915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends p> f496916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends p> f496917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends IBaseUser> f496918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRivalRankRecommendResponse f496919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f496920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f496921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f496922j;

    public static final class a implements j21.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f496923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f496924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f496925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f496926d;

        @Override // j21.a
        public final void a(IRivalRankRecommendResponse r110) {
            Intrinsics.checkNotNullParameter(r110, "resp");
            e r100 = this.f496923a;
            r100.f496919g = r110;
            b r101 = r100.f496920h;
            if (r101 == null) goto L11;
            List<? extends p> r102 = r100.f496916d;
            if (r102 != null) goto L7;
            r102 = CollectionsKt.emptyList();
        L7:
            List<? extends p> r103 = r102;
            List<? extends p> r104 = this.f496923a.f496917e;
            if (r104 != null) goto L10;
            r104 = CollectionsKt.emptyList();
        L10:
            List<? extends p> r105 = r104;
            e r106 = this.f496923a;
            r101.onPageRecsFetch(r103, r105, r106.f496918f, r106.f496919g, this.f496924b);
        L11:
            com.bytedance.android.live.revlink.impl.multianchor.vm.f r107 = com.bytedance.android.live.revlink.impl.global.b.p();
            if (r107 != null) goto L14;
            return;
        L14:
            if (r107.b() == true) goto L16;
            return;
        L16:
            if (this.f496925c == 4) goto L23;
            this.f496923a.getClass();
            LinkingInvitePreloadUtils r108 = e.d();
            if (r108 == null) goto L24;
            int r109 = this.f496925c;
            long r111 = this.f496926d;
            Intrinsics.checkNotNullParameter(r110, "resp");
            i97.a r112 = i97.a.f488802a;
            r108.f95030f = new com.bytedance.android.live.revlink.impl.multianchor.vm.h(r110, r109, r111, System.currentTimeMillis());
            return;
        L24:
            return;
        }

        public a(e r100, boolean r101, int r102, long r103) {
            this.f496923a = r100;
            this.f496924b = r101;
            this.f496925c = r102;
            this.f496926d = r103;
        }
    }

    public static LinkingInvitePreloadUtils d() {
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r100 = com.bytedance.android.live.revlink.impl.global.b.p();
        if (r100 == null) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r101 = r100.f95050a;
        if (r101 == null) goto L7;
        MultiAnchorPkLaunchContext r102 = r101.Ib();
    L8:
        if (r102 == null) goto L14;
        com.bytedance.live.datacontext.j<LinkingInvitePreloadUtils> r103 = r102.getLinkingInvitePreloadUtils();
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.getValue();
    L14:
        return null;
    L7:
        r102 = null;
        goto L8
    L13:
        return null;
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r100) {
        this.f496922j = r100;
        this.f496914b = new j();
        this.f496915c = new g(r100);
        this.f496918f = CollectionsKt.emptyList();
        this.f496921i = new CompositeDisposable();
    }

    @Override // j21.c
    public final void b(List<? extends IBaseUser> r100) {
        this.f496918f = r100;
        b r101 = this.f496920h;
        if (r101 == null) goto L6;
        r101.onInviteeOrApplicantListChanged(r100);
        return;
    }

    public final void c(boolean r110) {
        Integer r100 = this.f496913a;
        if (r100 == null) goto L6;
        int r101 = r100.intValue();
    L9:
        long r102 = System.currentTimeMillis();
        g r103 = this.f496915c;
        a r104 = new a(this, r110, r101, r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "callback");
        Disposable r111 = null;
        jy0.b.f("ttlive_anchor_link_panel", "fetchRecommendList tabType=" + r101 + " recommendType=3", null, 4);
        Disposable r112 = r103.f496929a;
        if (r112 == null) goto L12;
        r112.dispose();
        r103.f496929a = null;
    L12:
        i97.a r113 = i97.a.f488802a;
        long r114 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r115 = r103.f496930b;
        if (r115 == null) goto L15;
        r31.a r105 = r115.getLinkNetwork();
    L16:
        if (r105 == null) goto L24;
        Observable r116 = r105.c(3, false, r101, "", 3, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r116 == null) goto L24;
        int r106 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r117 = r116.subscribeOn(Schedulers.io());
        if (r117 == null) goto L24;
        Observable r118 = r117.observeOn(AndroidSchedulers.mainThread());
        if (r118 == null) goto L24;
        r111 = r118.subscribe(new h(r103, r101, r114, r104), new i(r103, r101, r114));
    L24:
        r103.f496929a = r111;
        return;
    L15:
        r105 = null;
        goto L16
    L6:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L8;
        r101 = 3;
        goto L9
    L8:
        r101 = 6;
        goto L9
    }

    public final void e(IRivalRankRecommendResponse r100) {
        this.f496919g = r100;
        b r101 = this.f496920h;
        if (r101 == null) goto L11;
        List<? extends p> r102 = this.f496916d;
        if (r102 != null) goto L7;
        r102 = CollectionsKt.emptyList();
    L7:
        List<? extends p> r103 = r102;
        List<? extends p> r104 = this.f496917e;
        if (r104 != null) goto L10;
        r104 = CollectionsKt.emptyList();
    L10:
        r101.onPageRecsFetch(r103, r104, this.f496918f, this.f496919g, false);
    L11:
        LinkingInvitePreloadUtils r105 = d();
        if (r105 == null) goto L15;
        r105.b("cacheConsumed");
        return;
    }

    @Override // j21.c
    public final void a(List r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorList");
        Intrinsics.checkNotNullParameter(r101, "waitingList");
        AnchorLinkOptUtils r103 = null;
        jy0.b.f("ttlive_anchor_link_panel", "onUserStatusFetch anchorList size=" + ((ArrayList) r100).size(), null, 4);
        this.f496916d = r100;
        this.f496917e = r101;
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        this.f496918f = r102;
        com.bytedance.android.live.revlink.impl.global.c r104 = this.f496922j;
        if (r104 == null) goto L8;
        r103 = r104.vk();
    L8:
        if (r103 != null) goto L10;
    L11:
        c(false);
    L12:
        b r105 = this.f496920h;
        if (r105 == null) goto L22;
        List<? extends p> r106 = this.f496916d;
        if (r106 != null) goto L17;
        r106 = CollectionsKt.emptyList();
    L17:
        List<? extends p> r107 = r106;
        List<? extends p> r108 = this.f496917e;
        if (r108 != null) goto L20;
        r108 = CollectionsKt.emptyList();
    L20:
        r105.onPageUpdate(r107, r108, this.f496918f, this.f496919g, false);
        return;
    L22:
        return;
    L10:
        if (r103.d() == true) goto L12;
        goto L11
    }
}
