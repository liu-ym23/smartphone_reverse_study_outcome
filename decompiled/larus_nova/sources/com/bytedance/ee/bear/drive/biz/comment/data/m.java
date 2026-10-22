package com.bytedance.ee.bear.drive.biz.comment.data;

import android.graphics.RectF;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.scaleimageview.areacomment.AreaCoordinate;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larus.network.http.ServiceType;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AreaCommentFetcher f222753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f222754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f222755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f222756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DriveViewModel f222757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f85.a f222758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<CommentRectF> f222759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, CommentRectF> f222760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArraySet<b> f222761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArraySet<a> f222762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q75.a f222763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ee.bear.rn.h f222764l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i f222765m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f222766n;

    public interface a {
        void a(CommentRectF r100);

        void c(CommentRectF r100);
    }

    public interface b {
        void b(ArrayList<CommentRectF> r100);
    }

    public final void g() {
        this.f222756d = true;
        ArrayList<CommentRectF> r100 = this.f222759g;
        if (hu5.a.d(r100) == false) goto L6;
        tt5.a.k("DriveCommentDataManager", "onDriveAreaCommentUpdate - mSourceCommentRectFList is null or empty.");
        return;
    L6:
        tt5.a.h("DriveCommentDataManager", "onDriveCommentDataReceived, callback mSourceCommentRectFList, size: " + r100.size());
        Iterator<b> r101 = this.f222761i.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().b(r100);
        goto L8
    }

    public final void c() {
        if (this.f222765m == null) goto L7;
        com.bytedance.ee.bear.rn.h r100 = this.f222764l;
        if (r100 == null) goto L7;
        r100.a();
        tt5.a.h("DriveCommentDataManager", "unregisterPushObserver success, protocol=" + this.f222764l.hashCode() + ", observer=" + hashCode());
        this.f222764l = null;
        this.f222765m = null;
    L7:
        tt5.a.h("DriveCommentDataManager", "detach, clear mSourceCommentRectFList");
        this.f222759g.clear();
        this.f222754b.clear();
        this.f222762j.clear();
    }

    public final ArrayList<CommentRectF> e() {
        ArrayList<CommentRectF> r100 = new ArrayList();
        Iterator<CommentRectF> r101 = this.f222759g.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        CommentRectF r102 = r101.next();
        if (r102.f236775b.startsWith(ServiceType.DRIVE) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public final void i() {
        if (this.f222758f != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "pullDriveAreaComment, registerPushListener file model is null");
        return;
    L6:
        tt5.a.h("DriveCommentDataManager", "pullDriveAreaComment, before fetch, mSourceCommentRectFList size: " + this.f222759g.size());
        AreaCommentFetcher r100 = this.f222753a;
        w75.b r101 = this.f222758f.f558532a;
        String r102 = ((f85.a.C5868a) r101).f558557a;
        if (this.f222766n == false) goto L9;
        String r103 = "";
    L10:
        r100.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "get rect comment starting...");
        NetService.f r104 = new NetService.f("/api/box/comment/get/");
        r104.b("file_token", r102);
        if (TextUtils.isEmpty(r103) == true) goto L13;
        r104.b("version", r103);
    L13:
        r104.f216906c = 2;
        this.f222754b.add(r100.f222736a.a(r104).map(new com.bytedance.ee.bear.drive.biz.comment.data.a()).map(new d()).observeOn(fo5.d.d()).subscribe(new e(this), new f(this)));
        return;
    L9:
        r103 = ((f85.a.C5868a) r101).f475873p;
        goto L10
    }

    public m() {
        this.f222754b = new CompositeDisposable();
        this.f222759g = new ArrayList();
        this.f222760h = new HashMap();
        this.f222761i = new ArraySet(2);
        this.f222762j = new ArraySet(2);
        this.f222766n = false;
        this.f222753a = new AreaCommentFetcher((NetService) org.koin.java.a.a(NetService.class));
        this.f222763k = o75.b.a().getDriveConfig();
    }

    public final void b(b r100) {
        if (r100 == null) goto L5;
        this.f222761i.add(r100);
        tt5.a.h("DriveCommentDataManager", "addOnPullDriveCommentListener, sticky callback mSourceCommentRectFList, size: " + this.f222759g.size());
        r100.b(this.f222759g);
        return;
    }

    public final Flowable<CommentRectF> d(String r100) {
        f85.a r101 = this.f222758f;
        if (r101 != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "registerPushListener file model is null");
        return null;
    L6:
        AreaCommentFetcher r102 = this.f222753a;
        w75.b r103 = r101.f558532a;
        String r104 = ((f85.a.C5868a) r103).f558557a;
        String r105 = ((f85.a.C5868a) r103).f475873p;
        r102.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "get rect comment starting...");
        if (TextUtils.isEmpty(r100) == false) goto L9;
        Flowable r106 = Flowable.error(new Exception("getCommentById id is empty"));
    L14:
        return r106.map(new d()).map(new g());
    L9:
        NetService.f r107 = new NetService.f("/api/box/comment/get/");
        r107.b("file_token", r104);
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r107.b("version", r105);
    L12:
        r107.b("comment_id", r100);
        r107.f216906c = 2;
        r106 = r102.f222736a.a(r107).map(new com.bytedance.ee.bear.drive.biz.comment.data.a());
        goto L14
    }

    public final void h(CommentRectF r100) {
        if (r100 != null) goto L7;
        tt5.a.d("DriveCommentDataManager", "onFetchedCommentRectF, commentRectF is null.");
        return;
    L7:
        if (this.f222759g.contains(r100) == false) goto L10;
        tt5.a.d("DriveCommentDataManager", "onFetchedCommentRectF, commentRectF already existed: " + r100);
        return;
    L10:
        tt5.a.h("DriveCommentDataManager", "bindSendingComment, commentRectF: " + r100);
        this.f222759g.add(r100);
        g();
    }

    public final void a(String r100, final CommentRectF r110) {
        if (this.f222758f != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "addDriveCommentArea, registerPushListener file model is null");
        return;
    L6:
        if (r110 != null) goto L9;
        tt5.a.d("DRIVE_COMMENT_FLOW", "addDriveCommentArea, addDriveCommentArea with null commentRectF, return.");
        return;
    L9:
        Disposable r101 = this.f222755c;
        if (r101 != null) goto L12;
    L14:
        this.f222755c = null;
        final String r102 = r110.f236775b;
        tt5.a.h("DriveCommentDataManager", "addDriveCommentArea, mSourceCommentRectFList adding commentRectF and request to bind, current size: " + this.f222759g.size() + ", new commentRectF: " + r102);
        this.f222759g.add(r110);
        g();
        ArrayMap<String, Integer> r103 = c.f222739a;
        AreaCoordinate r104 = new AreaCoordinate();
        AreaCoordinate.Position r105 = new AreaCoordinate.Position();
        r104.setType(r110.getType());
        r105.setLeft(((RectF) r110).left);
        r105.setTop(((RectF) r110).top);
        r105.setRight(((RectF) r110).right);
        r105.setBottom(((RectF) r110).bottom);
        r105.setPage(r110.f236778e);
        r105.setText(r110.f236783j);
        r105.setQuads(r110.f236782i);
        r104.setPosition(r105);
        AreaCommentFetcher r106 = this.f222753a;
        String r107 = ((f85.a.C5868a) this.f222758f.f558532a).f558557a;
        String r108 = r110.f236775b;
        r106.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "add rect comment starting...");
        final NetService.f r109 = new NetService.f("/api/box/comment/add/");
        AreaCommentFetcher.AddParam r111 = new AreaCommentFetcher.AddParam(null);
        r111.setFileToken(r107);
        r111.setVersion(r100);
        r111.setCommentId(r108);
        AreaCommentFetcher.AddParam.Extra r112 = new AreaCommentFetcher.AddParam.Extra(null);
        r112.setAreaCoordinate(r104);
        r111.setExtra(r112);
        r109.f216913j = JSON.toJSONString(r111);
        r109.f216906c = 1;
        this.f222755c = r106.f222737b.a(r109).map(new com.bytedance.ee.bear.drive.biz.comment.data.b(r109)).timeout(10, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new j(this, r110, r102), new k(this, r110, r102));
        return;
    L12:
        if (r101.isDisposed() == true) goto L14;
        tt5.a.h("DriveCommentDataManager", "addDriveCommentArea, mLastAddCommentDisposable dispose.");
        this.f222755c.dispose();
        goto L14
    }

    public final void f(CommentRectF r100, Throwable r101) {
        Iterator<a> r102 = this.f222762j.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        a r103 = r102.next();
        if (r101 == null) goto L7;
        r103.a(r100);
        goto L4
    L7:
        r103.c(r100);
        goto L4
    }
}
