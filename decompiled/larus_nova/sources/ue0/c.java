package ue0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.feed.datamerge.j;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<IRoomLinkMicSyncData> f549767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<List<ch0.e>> f549768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> f549769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<List<ch0.e>> f549770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BehaviorSubject<List<LinkmicPositionItem>> f549771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> f549772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<wg0.a> f549773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BehaviorSubject<cj> f549774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BehaviorSubject<ch0.a> f549775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<j> f549776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MessageHub f549777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f549778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IVoiceLiveTheme f549779m;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> d() {
        List<ch0.e> r100 = this.f549770d.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final ch0.a e() {
        ch0.a r100 = this.f549775i.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final wg0.a j() {
        wg0.a r100 = this.f549773g.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<LinkmicPositionItem> k() {
        List<LinkmicPositionItem> r100 = this.f549771e.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final List<ch0.e> o() {
        List<ch0.e> r100 = this.f549768b.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final Map<String, pf0.a> r() {
        ConcurrentHashMap<String, pf0.a> r100 = this.f549772f.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<wg0.a> b() {
        return this.f549773g;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<ch0.e>> f() {
        return this.f549768b;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<LinkmicPositionItem>> g() {
        return this.f549771e;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final MessageHub getMessageHub() {
        return this.f549777k;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final int getShowFrom() {
        return this.f549778l;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<List<ch0.e>> h() {
        return this.f549770d;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ConcurrentHashMap<String, pf0.a>> i() {
        return this.f549772f;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final BehaviorSubject<ch0.a> s() {
        return this.f549775i;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void a(List<? extends ILinkPlayerInfoBridge> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f549769c.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void c(wg0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "playModeStateItem");
        this.f549773g.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void l(ch0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomState");
        this.f549775i.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void n(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "updateResult");
        if (r100.f72975a == false) goto L6;
        this.f549770d.onNext(r100.f72976b);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void p(List<? extends LinkmicPositionItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f549771e.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void q(cj r100) {
        Intrinsics.checkNotNullParameter(r100, "radioGiftCommentMessage");
        this.f549774h.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void t(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "updateResult");
        if (r100.f72975a == false) goto L6;
        this.f549768b.onNext(r100.f72976b);
        return;
    }

    public final void u(com.bytedance.android.live.liveinteract.feed.datamerge.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f549776j.add(r100);
        r100.attach();
    }

    public final void v(com.bytedance.android.live.liveinteract.feed.datamerge.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f549776j.remove(r100);
        r100.detach();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.k
    public final void m(String r100, pf0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ConcurrentHashMap<String, pf0.a> r102 = this.f549772f.getValue();
        if (r102 == null) goto L6;
        pf0.a r103 = r102.put(r100, r101);
        return;
    }

    public c(MessageHub r100, int r101, IVoiceLiveTheme r102) {
        this.f549777k = r100;
        this.f549778l = r101;
        this.f549779m = r102;
        this.f549767a = BehaviorSubject.create();
        this.f549768b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.f549769c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.f549770d = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.f549771e = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.f549772f = BehaviorSubject.createDefault(new ConcurrentHashMap());
        this.f549773g = BehaviorSubject.createDefault(new wg0.a(0));
        this.f549774h = BehaviorSubject.create();
        this.f549775i = BehaviorSubject.createDefault(new ch0.a(0, 0, CollectionsKt.emptyList()));
        BehaviorSubject.createDefault(new SeiAppData());
        this.f549776j = new CopyOnWriteArrayList();
    }
}
