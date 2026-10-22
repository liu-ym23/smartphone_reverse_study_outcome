package tq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.api.ReplayListApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<List<EpisodeGroup>> f547103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f547104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f547105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f547106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<EpisodeGroup> f547107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f547108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NextLiveData<Boolean> f547109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NextLiveData<Boolean> f547110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f547111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f547112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f547113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final mq1.b f547114l;

    public static final class a {
    }

    /* JADX INFO: renamed from: tq1.b$b, reason: collision with other inner class name */
    public static final class C7759b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7759b f547115a = null;

        static {
            f547115a = new C7759b();
        }

        public C7759b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return ((ReplayListApi.ReplayListData) r101.data).getAllReplayGroup();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f547116a;

        public c(b r100) {
            this.f547116a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            b r102 = this.f547116a;
            r102.f547105c = true;
            r102.f547106d = null;
            ((ArrayList) r102.f547107e).clear();
            if (r101 == null) goto L16;
            List<EpisodeGroup> r103 = r102.f547107e;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r101.iterator();
        L6:
            if (r105.hasNext() == false) goto L15;
            T r106 = r105.next();
            List<Episode> r107 = ((EpisodeGroup) r106).episodes;
            if (r107 != null) goto L10;
        L12:
            boolean r108 = false;
        L13:
            if (r108 == false) goto L6;
            r104.add(r106);
            goto L6
        L10:
            if (r107.isEmpty() == true) goto L12;
            r108 = true;
            goto L13
        L15:
            ((ArrayList) r103).addAll(r104);
        L16:
            r102.f547114l.onListDataChanged(r102.f547107e);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f547117a;

        public d(b r100) {
            this.f547117a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.e("ReplayPlayListProvider", "get play list error", r101);
            b r102 = this.f547117a;
            r102.f547105c = true;
            r102.f547106d = r101;
            r102.f547114l.onPullDataFailed(r101);
        }
    }

    static {
    }

    public final List<Episode> b() {
        List<EpisodeGroup> r100 = this.f547107e;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        List<Episode> r103 = ((EpisodeGroup) r102.next()).episodes;
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        r101.add(r103);
        goto L4
    L10:
        return CollectionsKt.flatten(r101);
    }

    public final Observable<List<EpisodeGroup>> c() {
        Observable<Response<ReplayListApi.ReplayListData>> r100 = ((ReplayListApi) r.n().getService(ReplayListApi.class)).getReplayList(this.f547112j, this.f547113k);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.map(C7759b.f547115a);
    }

    public final void d() {
        Observable<List<EpisodeGroup>> r100 = c();
        if (r100 == null) goto L12;
        Observable<List<EpisodeGroup>> r101 = r100.subscribeOn(Schedulers.io());
        if (r101 == null) goto L13;
        Observable<List<EpisodeGroup>> r102 = r101.observeOn(AndroidSchedulers.mainThread());
        if (r102 == null) goto L14;
        Disposable r103 = r102.subscribe(new c(this), new d(this));
        if (r103 == null) goto L15;
        RxUtilKt.c(r103, this.f547108f);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final Episode a(long r110) {
        Iterator<T> r100 = this.f547107e.iterator();
    L4:
        if (r100.hasNext() == false) goto L24;
        Object r101 = r100.next();
        List<Episode> r102 = ((EpisodeGroup) r101).episodes;
        if (r102 == null) goto L21;
        List<Episode> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L21;
        if (((Episode) r104.next()).getId() != r110) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L14;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L4;
    L25:
        EpisodeGroup r107 = (EpisodeGroup) r101;
        if (r107 == null) goto L29;
        List<Episode> r108 = r107.episodes;
        if (r108 == null) goto L29;
    L31:
        if (r110 > 0) goto L33;
        return null;
    L33:
        if (r108.isEmpty() == true) goto L64;
        Iterator<Episode> r109 = r108.iterator();
        boolean r111 = false;
    L37:
        if (r109.hasNext() == false) goto L45;
        Episode r112 = r109.next();
        if (r111 == true) goto L63;
        if (r112.getId() != r110) goto L37;
        r111 = true;
        goto L37
    L63:
        return r112;
    L45:
        return (Episode) ListProtector.get(r108, 0);
    L64:
        return null;
    L29:
        r108 = CollectionsKt.emptyList();
        goto L31
    L18:
        r105 = false;
        goto L19
    L10:
        if (r103.isEmpty() == false) goto L12;
    L21:
        r106 = false;
        goto L22
    L24:
        r101 = null;
        goto L25
    }

    public b(long r100, long r101, mq1.b r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f547112j = r100;
        this.f547113k = r101;
        this.f547114l = r102;
        this.f547103a = new NextLiveData();
        this.f547107e = new ArrayList();
        this.f547108f = new CompositeDisposable();
        this.f547109g = new NextLiveData();
        this.f547110h = new NextLiveData();
        d();
    }
}
