package zp5;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceCover;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mc5.b3;
import mc5.j;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573192a = 0;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f573193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ce5.a f573194b;

        public a(int r100, ce5.a r101) {
            this.f573193a = r100;
            this.f573194b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            if (this.f573193a != (-1)) goto L5;
            List<b3> r101 = ((j) this.f573194b.a(j.class)).A7();
        L6:
            Intrinsics.checkNotNull(r101);
            List<b3> r102 = r101;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L8:
            if (r104.hasNext() == false) goto L10;
            b3 r105 = (b3) r104.next();
            Intrinsics.checkNotNull(r105);
            Intrinsics.checkNotNullParameter(r105, "<this>");
            SpaceBean r106 = new SpaceBean();
            r106.space_id = r105.f512923a;
            r106.space_name = r105.f512925c;
            r106.space_icon = r105.f512926d;
            r106.description = r105.f512928f;
            r106.is_star = r105.f512929g;
            r106.browse_time = r105.f512930h;
            r106.wiki_scope = r105.f512939q;
            r106.space_type = r105.f512940r;
            r106.open_sharing = r105.f512941s;
            SpaceCover r107 = new SpaceCover();
            r107.origin = r105.f512934l;
            r107.thumbnail = r105.f512935m;
            r107.key = r105.f512936n;
            r107.is_graph_dark = r105.f512937o;
            r107.color_value = r105.f512938p;
            r106.space_cover = r107;
            r103.add(r106);
            goto L8
        L10:
            return r103;
        L5:
            r101 = ((j) this.f573194b.a(j.class)).M7(this.f573193a);
            goto L6
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<SpaceBean> f573195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ce5.a f573196b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends SpaceBean> r100, ce5.a r101) {
            this.f573195a = r100;
            this.f573196b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            List<SpaceBean> r101 = this.f573195a;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            SpaceBean r104 = (SpaceBean) r103.next();
            Intrinsics.checkNotNullParameter(r104, "<this>");
            b3 r105 = new b3();
            r105.f512923a = r104.space_id;
            r105.f512925c = r104.space_name;
            r105.f512926d = r104.space_icon;
            r105.f512929g = r104.is_star;
            r105.f512930h = r104.browse_time;
            r105.f512928f = r104.description;
            r105.f512939q = r104.wiki_scope;
            r105.f512940r = r104.space_type;
            r105.f512941s = r104.open_sharing;
            SpaceCover r106 = r104.space_cover;
            if (r106 == null) goto L8;
            r105.f512934l = r106.origin;
            r105.f512935m = r106.thumbnail;
            r105.f512938p = r106.color_value;
            r105.f512937o = r106.is_graph_dark;
            r105.f512936n = r106.key;
        L8:
            r102.add(r105);
            goto L4
        L9:
            ((j) this.f573196b.a(j.class)).s1(r102);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f573197a = null;

        static {
            f573197a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Unit r101 = (Unit) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f573198a = null;

        static {
            f573198a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.i("WikiSpaceRepository", "saveSpacesToDb err. ", (Throwable) r100);
        }
    }

    static {
    }

    public static Flowable a(int r100, ce5.a r101) {
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.b()).map(new a(r100, r101));
    }

    public static void b(List r100, ce5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spaces");
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        if (hu5.a.d(r100) == true) goto L6;
        Flowable.just("").observeOn(fo5.d.b()).map(new b(r100, r101)).subscribe(c.f573197a, d.f573198a);
        return;
    }
}
