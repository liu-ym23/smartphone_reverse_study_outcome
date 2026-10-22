package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import mc5.j;
import mc5.u1;
import od5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SidebarPinFolderListCache extends t {

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SidebarPinFolderListCache a;
        public final /* synthetic */ ArrayList<Document> b;

        public b(SidebarPinFolderListCache r1, ArrayList<Document> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ((Boolean) r4).booleanValue();
            ((j) this.a.a.a(j.class)).dc(16, u1.g(this.b), u1.e(this.b, 16));
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("SidebarPinFolderListCache", "clearAndSave()...", (Throwable) r4, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ SidebarPinFolderListCache a;
        public final /* synthetic */ String b;

        public d(SidebarPinFolderListCache r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            ((j) this.a.a.a(j.class)).a2(16, this.b);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("SidebarPinFolderListCache", "delete()...", (Throwable) r4, false);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ SidebarPinFolderListCache a;

        public f(SidebarPinFolderListCache r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ArrayList r5 = (ArrayList) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            ((j) this.a.a.a(j.class)).v4(u1.g(r5), u1.e(r5, 16));
        }
    }

    public static final class g<T> implements Consumer {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r4) {
            tt5.a.e("SidebarPinFolderListCache", "save()...", (Throwable) r4, false);
        }
    }

    static {
    }

    public final LiveData<ArrayList<Document>> c() {
        tt5.a.h("SidebarPinFolderListCache", "getDisplayPinFolderLiveData()...");
        return Transformations.map(((j) this.a.a(j.class)).ae(16), SidebarPinFolderListCache$getDisplayPinFolderLiveData$1.INSTANCE);
    }

    @Override // od5.t, mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("SidebarPinFolderListCache", "getFilter()...");
        FolderSortStrategy r0 = ((j) this.a.a(j.class)).m1("sidebar_pin_folder");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderSortStrategy("sidebar_pin_folder", FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
    }

    public SidebarPinFolderListCache(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        super(r2);
    }

    @Override // od5.t, mc5.k
    public final void a(ArrayList<Document> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        tt5.a.h("SidebarPinFolderListCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new b(this, r3), c.a);
    }

    @Override // od5.t, mc5.k
    public final void b(ArrayList<Document> r3) {
        Intrinsics.checkNotNullParameter(r3, "docList");
        tt5.a.h("SidebarPinFolderListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new f(this), g.a);
    }

    @Override // od5.t, mc5.a3, mc5.k
    public void delete(String r3) {
        tt5.a.h("SidebarPinFolderListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new d(this, r3), e.a);
    }
}
