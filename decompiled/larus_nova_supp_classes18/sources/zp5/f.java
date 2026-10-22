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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ int a;
        public final /* synthetic */ ce5.a b;

        public a(int r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((String) r6, "it");
            if (this.a != (-1)) goto L5;
            List<b3> r7 = ((j) this.b.a(j.class)).A7();
        L6:
            Intrinsics.checkNotNull(r7);
            List<b3> r8 = r7;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r9 = r8.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            b3 r1 = (b3) r9.next();
            Intrinsics.checkNotNull(r1);
            Intrinsics.checkNotNullParameter(r1, "<this>");
            SpaceBean r2 = new SpaceBean();
            r2.space_id = r1.a;
            r2.space_name = r1.c;
            r2.space_icon = r1.d;
            r2.description = r1.f;
            r2.is_star = r1.g;
            r2.browse_time = r1.h;
            r2.wiki_scope = r1.q;
            r2.space_type = r1.r;
            r2.open_sharing = r1.s;
            SpaceCover r3 = new SpaceCover();
            r3.origin = r1.l;
            r3.thumbnail = r1.m;
            r3.key = r1.n;
            r3.is_graph_dark = r1.o;
            r3.color_value = r1.p;
            r2.space_cover = r3;
            r0.add(r2);
            goto L8
        L10:
            return r0;
        L5:
            r7 = ((j) this.b.a(j.class)).M7(this.a);
            goto L6
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ List<SpaceBean> a;
        public final /* synthetic */ ce5.a b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends SpaceBean> r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((String) r5, "it");
            List<SpaceBean> r6 = this.a;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L9;
            SpaceBean r1 = (SpaceBean) r7.next();
            Intrinsics.checkNotNullParameter(r1, "<this>");
            b3 r2 = new b3();
            r2.a = r1.space_id;
            r2.c = r1.space_name;
            r2.d = r1.space_icon;
            r2.g = r1.is_star;
            r2.h = r1.browse_time;
            r2.f = r1.description;
            r2.q = r1.wiki_scope;
            r2.r = r1.space_type;
            r2.s = r1.open_sharing;
            SpaceCover r3 = r1.space_cover;
            if (r3 == null) goto L8;
            r2.l = r3.origin;
            r2.m = r3.thumbnail;
            r2.p = r3.color_value;
            r2.o = r3.is_graph_dark;
            r2.n = r3.key;
        L8:
            r0.add(r2);
            goto L4
        L9:
            ((j) this.b.a(j.class)).s1(r0);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.i("WikiSpaceRepository", "saveSpacesToDb err. ", (Throwable) r3);
        }
    }

    static {
    }

    public static Flowable a(int r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.b()).map(new a(r2, r3));
    }

    public static void b(List r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spaces");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        if (hu5.a.d(r2) == true) goto L6;
        Flowable.just("").observeOn(fo5.d.b()).map(new b(r2, r3)).subscribe(c.a, d.a);
        return;
    }
}
