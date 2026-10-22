package com.bytedance.ee.bear.search.picker.filter.wiki;

import com.bytedance.ee.bear.contract.route.parcelable.h;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements y3c.a {
    public final CompositeDisposable a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> b;

        public b(g r1, IGetDataCallback<List<SearchBaseInfo>> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            g r0 = this.a;
            Intrinsics.checkNotNull(r3);
            List r4 = g.a(r0, r3);
            this.b.onSuccess(r4);
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
            tt5.a.f("WikiSpaceRecommendPuller", ((Throwable) r3).getCause(), false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> b;

        public d(g r1, IGetDataCallback<List<SearchBaseInfo>> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            g r0 = this.a;
            Intrinsics.checkNotNull(r3);
            List r4 = g.a(r0, r3);
            if (CollectionUtils.isEmpty(r4) == true) goto L6;
            this.b.onSuccess(r4);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            tt5.a.f("WikiSpaceRecommendPuller", ((Throwable) r3).getCause(), false);
        }
    }

    static {
    }

    public final boolean needHeader() {
        return true;
    }

    public final boolean canLoadMore() {
        return ((h) org.koin.java.a.c(h.class, null, null, 6)).hasMore();
    }

    public g() {
        this.a = new CompositeDisposable();
    }

    public final void loadData(IGetDataCallback<List<SearchBaseInfo>> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a.add(((h) org.koin.java.a.c(h.class, null, null, 6)).load().subscribe(new b(this, r5), c.a));
    }

    public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a.add(((h) org.koin.java.a.c(h.class, null, null, 6)).a().subscribe(new d(this, r5), e.a));
    }

    public static final List a(g r3, List r4) {
        r3.getClass();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        SpaceBean r0 = (SpaceBean) r6.next();
        SearchWikiSpaceInfo r1 = new SearchWikiSpaceInfo();
        r1.setSpaceId(r0.space_id);
        r1.setCoverColorValue(r0.space_cover.color_value);
        r1.setCoverKey(r0.space_cover.key);
        r1.setCoverThumbnail(r0.space_cover.thumbnail);
        r1.setCoverOrigin(r0.space_cover.origin);
        r1.setDescription(r0.description);
        r1.setSubTitle(r0.description);
        r1.setTitle(r0.space_name);
        r1.setId(r0.space_id);
        r1.setRootToken(r0.root_token);
        r5.add(r1);
        goto L4
    L6:
        return r5;
    }
}
