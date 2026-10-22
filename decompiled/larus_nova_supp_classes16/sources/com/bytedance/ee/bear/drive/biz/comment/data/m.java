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
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public final AreaCommentFetcher a;
    public final CompositeDisposable b;
    public Disposable c;
    public volatile boolean d;
    public DriveViewModel e;
    public f85.a f;
    public ArrayList<CommentRectF> g;
    public final Map<String, CommentRectF> h;
    public final ArraySet<b> i;
    public final ArraySet<a> j;
    public final q75.a k;
    public com.bytedance.ee.bear.rn.h l;
    public i m;
    public boolean n;

    public interface a {
        void a(CommentRectF r1);

        void c(CommentRectF r1);
    }

    public interface b {
        void b(ArrayList<CommentRectF> r1);
    }

    public final void g() {
        this.d = true;
        ArrayList<CommentRectF> r0 = this.g;
        if (hu5.a.d(r0) == false) goto L6;
        tt5.a.k("DriveCommentDataManager", "onDriveAreaCommentUpdate - mSourceCommentRectFList is null or empty.");
        return;
    L6:
        tt5.a.h("DriveCommentDataManager", "onDriveCommentDataReceived, callback mSourceCommentRectFList, size: " + r0.size());
        Iterator r1 = this.i.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((b) r1.next()).b(r0);
        goto L8
    }

    public final void c() {
        if (this.m == null) goto L7;
        com.bytedance.ee.bear.rn.h r0 = this.l;
        if (r0 == null) goto L7;
        r0.a();
        tt5.a.h("DriveCommentDataManager", "unregisterPushObserver success, protocol=" + this.l.hashCode() + ", observer=" + hashCode());
        this.l = null;
        this.m = null;
    L7:
        tt5.a.h("DriveCommentDataManager", "detach, clear mSourceCommentRectFList");
        this.g.clear();
        this.b.clear();
        this.j.clear();
    }

    public final ArrayList<CommentRectF> e() {
        ArrayList<CommentRectF> r0 = new ArrayList();
        Iterator<CommentRectF> r1 = this.g.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CommentRectF r2 = r1.next();
        if (r2.b.startsWith("Drive") == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public final void i() {
        if (this.f != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "pullDriveAreaComment, registerPushListener file model is null");
        return;
    L6:
        tt5.a.h("DriveCommentDataManager", "pullDriveAreaComment, before fetch, mSourceCommentRectFList size: " + this.g.size());
        AreaCommentFetcher r0 = this.a;
        w75.b r1 = this.f.a;
        String r2 = ((f85.a.C0229a) r1).a;
        if (this.n == false) goto L9;
        String r3 = "";
    L10:
        r0.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "get rect comment starting...");
        NetService.f r4 = new NetService.f("/api/box/comment/get/");
        r4.b("file_token", r2);
        if (TextUtils.isEmpty(r3) == true) goto L13;
        r4.b("version", r3);
    L13:
        r4.c = 2;
        this.b.add(r0.a.a(r4).map(new com.bytedance.ee.bear.drive.biz.comment.data.a()).map(new d()).observeOn(fo5.d.d()).subscribe(new e(this), new f(this)));
        return;
    L9:
        r3 = ((f85.a.C0229a) r1).p;
        goto L10
    }

    public m() {
        this.b = new CompositeDisposable();
        this.g = new ArrayList();
        this.h = new HashMap();
        this.i = new ArraySet(2);
        this.j = new ArraySet(2);
        this.n = false;
        this.a = new AreaCommentFetcher((NetService) org.koin.java.a.a(NetService.class));
        this.k = o75.b.a().getDriveConfig();
    }

    public final void b(b r3) {
        if (r3 == null) goto L5;
        this.i.add(r3);
        tt5.a.h("DriveCommentDataManager", "addOnPullDriveCommentListener, sticky callback mSourceCommentRectFList, size: " + this.g.size());
        r3.b(this.g);
        return;
    }

    public final Flowable<CommentRectF> d(String r6) {
        f85.a r0 = this.f;
        if (r0 != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "registerPushListener file model is null");
        return null;
    L6:
        AreaCommentFetcher r1 = this.a;
        w75.b r2 = r0.a;
        String r3 = ((f85.a.C0229a) r2).a;
        String r4 = ((f85.a.C0229a) r2).p;
        r1.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "get rect comment starting...");
        if (TextUtils.isEmpty(r6) == false) goto L9;
        Flowable r7 = Flowable.error(new Exception("getCommentById id is empty"));
    L14:
        return r7.map(new d()).map(new g());
    L9:
        NetService.f r5 = new NetService.f("/api/box/comment/get/");
        r5.b("file_token", r3);
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r5.b("version", r4);
    L12:
        r5.b("comment_id", r6);
        r5.c = 2;
        r7 = r1.a.a(r5).map(new com.bytedance.ee.bear.drive.biz.comment.data.a());
        goto L14
    }

    public final void h(CommentRectF r4) {
        if (r4 != null) goto L7;
        tt5.a.d("DriveCommentDataManager", "onFetchedCommentRectF, commentRectF is null.");
        return;
    L7:
        if (this.g.contains(r4) == false) goto L10;
        tt5.a.d("DriveCommentDataManager", "onFetchedCommentRectF, commentRectF already existed: " + r4);
        return;
    L10:
        tt5.a.h("DriveCommentDataManager", "bindSendingComment, commentRectF: " + r4);
        this.g.add(r4);
        g();
    }

    public final void a(String r9, final CommentRectF r10) {
        if (this.f != null) goto L6;
        tt5.a.d("DriveCommentDataManager", "addDriveCommentArea, registerPushListener file model is null");
        return;
    L6:
        if (r10 != null) goto L9;
        tt5.a.d("DRIVE_COMMENT_FLOW", "addDriveCommentArea, addDriveCommentArea with null commentRectF, return.");
        return;
    L9:
        Disposable r0 = this.c;
        if (r0 != null) goto L12;
    L14:
        this.c = null;
        final String r2 = r10.b;
        tt5.a.h("DriveCommentDataManager", "addDriveCommentArea, mSourceCommentRectFList adding commentRectF and request to bind, current size: " + this.g.size() + ", new commentRectF: " + r2);
        this.g.add(r10);
        g();
        ArrayMap<String, Integer> r1 = c.a;
        AreaCoordinate r3 = new AreaCoordinate();
        AreaCoordinate.Position r4 = new AreaCoordinate.Position();
        r3.setType(r10.getType());
        r4.setLeft(((RectF) r10).left);
        r4.setTop(((RectF) r10).top);
        r4.setRight(((RectF) r10).right);
        r4.setBottom(((RectF) r10).bottom);
        r4.setPage(r10.e);
        r4.setText(r10.j);
        r4.setQuads(r10.i);
        r3.setPosition(r4);
        AreaCommentFetcher r5 = this.a;
        String r6 = ((f85.a.C0229a) this.f.a).a;
        String r7 = r10.b;
        r5.getClass();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "add rect comment starting...");
        final NetService.f r8 = new NetService.f("/api/box/comment/add/");
        AreaCommentFetcher.AddParam r11 = new AreaCommentFetcher.AddParam(null);
        r11.setFileToken(r6);
        r11.setVersion(r9);
        r11.setCommentId(r7);
        AreaCommentFetcher.AddParam.Extra r12 = new AreaCommentFetcher.AddParam.Extra(null);
        r12.setAreaCoordinate(r3);
        r11.setExtra(r12);
        r8.j = JSON.toJSONString(r11);
        r8.c = 1;
        this.c = r5.b.a(r8).map(new com.bytedance.ee.bear.drive.biz.comment.data.b(r8)).timeout(10, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new j(this, r10, r2), new k(this, r10, r2));
        return;
    L12:
        if (r0.isDisposed() == true) goto L14;
        tt5.a.h("DriveCommentDataManager", "addDriveCommentArea, mLastAddCommentDisposable dispose.");
        this.c.dispose();
        goto L14
    }

    public final void f(CommentRectF r3, Throwable r4) {
        Iterator r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        a r1 = (a) r0.next();
        if (r4 == null) goto L7;
        r1.a(r3);
        goto L4
    L7:
        r1.c(r3);
        goto L4
    }
}
