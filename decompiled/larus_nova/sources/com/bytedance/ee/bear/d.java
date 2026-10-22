package com.bytedance.ee.bear;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.Flowable;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f217328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f217329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f217330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f217331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f217332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f217333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f217334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f217335h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f217336i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f217337j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f217338k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f217339l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final IDocUserPermission f217340m;

        public a(int r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r108, boolean r110, boolean r111, String r112, IDocUserPermission r113) {
            this.f217328a = r100;
            this.f217329b = r101;
            this.f217330c = r102;
            this.f217331d = r103;
            this.f217332e = r104;
            this.f217333f = r105;
            this.f217334g = r106;
            this.f217335h = r107;
            this.f217336i = r108;
            this.f217337j = r110;
            this.f217338k = r111;
            this.f217339l = r112;
            this.f217340m = r113;
        }
    }

    public interface b {
        void a(String r100);

        void b(String r100);

        void c(String r100);

        void d(String r100);

        void e(String r100, String r101, String r102);

        void f(String r100);
    }

    ExportMoreItemV2 a(FragmentActivity r100);

    Flowable<DocMetaInfo> b(String r100, int r101);

    LiveData<PageviewResult> c(FragmentActivity r100);

    Flowable<DocContainerInfo> d(String r100, int r101);

    Flowable<DocObjInfo> e(String r100, int r101);

    Flowable<MentionTitleResult> f(BearUrl r100, NetService r101);

    Flowable<MentionTitleResultList> g(List<BearUrl> r100, NetService r101);

    boolean h(FragmentActivity r100, a r101, com.bytedance.ee.bear.list.office.longpress.n r102);
}
