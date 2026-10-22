package ej3;

import com.bytedance.android.ec.store.repository.dto.m;
import com.bytedance.android.ec.store.repository.vo.r;
import dj3.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f472858g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<r> f472859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<r> f472860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f472861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<com.bytedance.android.ec.store.repository.dto.c> f472862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f472863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, k> f472864f;

    public static final class a {
        public a() {
        }

        public static f a(dj3.g r100) {
            f r101 = new f();
            Map<String, k> r102 = null;
            if (r100 == null) goto L5;
            List<com.bytedance.android.ec.store.repository.dto.c> r103 = r100.c();
        L6:
            r101.f472862d = r103;
            if (r100 == null) goto L14;
            List<m> r104 = r100.f();
            if (r104 == null) goto L14;
            List<m> r105 = r104;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L12:
            if (r107.hasNext() == false) goto L15;
            m r108 = (m) r107.next();
            int r109 = r.f48479t;
            r106.add(r.a.a(r108));
        L15:
            r101.f472859a = r106;
            if (r100 == null) goto L23;
            List<m> r110 = r100.b();
            if (r110 == null) goto L23;
            List<m> r111 = r110;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator<T> r113 = r111.iterator();
        L21:
            if (r113.hasNext() == false) goto L24;
            m r114 = (m) r113.next();
            int r115 = r.f48479t;
            r r116 = r.a.a(r114);
            r.d(r116);
            r112.add(r116);
        L24:
            r101.f472860b = r112;
            if (r100 == null) goto L27;
            Boolean r117 = Boolean.valueOf(r100.a());
        L28:
            r101.f472861c = r117;
            if (r100 != null) goto L31;
        L33:
            if (r100 == null) goto L35;
            r102 = r100.g();
        L35:
            r101.f472864f = r102;
            return r101;
        L31:
            if (r100.e() != true) goto L33;
            r101.f472863e = r100.d();
            goto L33
        L27:
            r117 = null;
        L23:
            r112 = null;
        L14:
            r106 = null;
            goto L15
        L5:
            r103 = null;
            goto L6
        }
    }

    public f() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 17;
    }

    static {
        f472858g = new a();
    }
}
