package com.bytedance.ee.bear.list.homepage.banner;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.u;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mc5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseBannerModel<T extends k> implements f {
    public final ce5.a a;
    public final Lazy b;
    public LiveData<ArrayList<Document>> c;
    public Disposable d;
    public final ArrayList<Document> e;
    public boolean f;
    public int g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseBannerModel<T> a;

        public b(BaseBannerModel<T> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.C(((DocumentListInfo) r2).getDocumentList());
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.f("BaseBannerModel", (Throwable) r3, false);
        }
    }

    static {
    }

    public final void create() {
    }

    public abstract T h();

    public abstract LiveData<ArrayList<Document>> k();

    public abstract u o();

    public abstract NetService.f p();

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public final LiveData<ArrayList<Document>> X() {
        if (this.c != null) goto L5;
        this.c = k();
    L5:
        tt5.a.h("BaseBannerModel", "getListLiveData()...liveData = " + this.c);
        LiveData<ArrayList<Document>> r0 = this.c;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public final void d7() {
        tt5.a.h("BaseBannerModel", "clearListLiveData()...");
        this.c = null;
    }

    public final void destroy() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public void m5() {
        if (j.a.a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        this.d = w().subscribe(new b(this), c.a);
    }

    public final T s() {
        return (T) this.b.getValue();
    }

    public Flowable<DocumentListInfo> w() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(o()).a(p());
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public final ArrayList<Document> getList() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public boolean hasMore() {
        return this.f;
    }

    public BaseBannerModel(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        this.a = r2;
        this.b = LazyKt.lazy(new BaseBannerModel$listCache$2(this));
        this.e = new ArrayList();
        this.g = 6;
    }

    public final void C(ArrayList<Document> r4) {
        StringBuilder r0 = new StringBuilder("saveToDB()...list = ");
        if (r4 == null) goto L5;
        Integer r1 = Integer.valueOf(r4.size());
    L6:
        r0.append(r1);
        tt5.a.h("BaseBannerModel", r0.toString());
        if (r4 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L18;
        Iterator<Document> r3 = r4.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        r3.next().t = "";
    L18:
        s().a(r4);
        return;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.f
    public final void C4(List<? extends Document> r5) {
        this.e.clear();
        List<? extends Document> r0 = r5;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        tt5.a.h("BaseBannerModel", "data is null");
        r1 = false;
    L15:
        this.f = r1;
        return;
    L11:
        int r3 = r5.size();
        int r4 = this.g;
        if (r3 > r4) goto L14;
        this.e.addAll(r5);
        goto L15
    L14:
        this.e.addAll(r5.subList(0, r4));
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
