package com.bytedance.ee.bear.wikiv2.more;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2;
import com.bytedance.ee.bear.wikiv2.more.bean.WikiThumbNailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.google.gson.Gson;
import com.ss.android.lark.utils.ContextsKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiTreeManualCacheItem extends ManualCacheItemV2 {
    private static final String TAG = "WikiTreeManualCacheItem";
    private CompositeDisposable disposables;
    private DocMetaInfo docMetaInfo;
    private TreeNode treeNode;

    public static /* synthetic */ void d(Throwable r0) {
        lambda$new$3(r0);
    }

    public static /* synthetic */ void e(WikiTreeManualCacheItem r0, DocMetaInfo r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void f(Throwable r0) {
        lambda$isManualOfflineByNet$5(r0);
    }

    public static /* synthetic */ void g(Throwable r0) {
        lambda$new$1(r0);
    }

    public static /* synthetic */ void h(WikiTreeManualCacheItem r0, Boolean r1) {
        r0.lambda$isManualOfflineByNet$4(r1);
    }

    public static /* synthetic */ void i(WikiTreeManualCacheItem r0, TreeNode r1, Boolean r2) {
        r0.lambda$new$2(r1, r2);
    }

    @Override // com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return TAG;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2
    public Document getManualOfflineDocument() {
        Document r0 = new Document();
        r0.d = this.treeNode.origin_wiki_token;
        r0.b = 16;
        r0.a = this.docMetaInfo.getTitle();
        r0.j = this.docMetaInfo.getCreateTime();
        r0.e = this.docMetaInfo.getOwnerUid();
        r0.r = this.docMetaInfo.getCreatorName();
        r0.s = this.docMetaInfo.getCreatorName();
        r0.F = this.docMetaInfo.getSubType();
        r0.e = this.docMetaInfo.getCreatorTenantId();
        r0.V = String.valueOf(SystemClock.uptimeMillis());
        r0.j = this.docMetaInfo.getCreateTime();
        r0.i = this.docMetaInfo.getEditTime();
        TreeNode r1 = this.treeNode;
        r0.y1 = r1.obj_type;
        r0.G1 = r1.obj_token;
        r0.p = r1.getUrl();
        WikiDetailInfo r2 = this.treeNode.detail_info;
        if (r2 == null) goto L7;
        WikiThumbNailInfo r3 = getThumbnailInfo(r2.getThumbnail());
        if (r3 == null) goto L7;
        r0.V0 = r3.getUrl();
        r0.g1 = r3.getNonce();
        r0.b1 = r3.getDecryptKey();
        r0.h1 = r3.getCipherType();
    L7:
        oj5.d r4 = new oj5.d();
        r4.h(this.treeNode.origin_space_id);
        r4.a = this.treeNode.origin_wiki_token;
        r0.O = r4.toString();
        return r0;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (this.treeNode != null) goto L5;
        return false;
    L5:
        return ((rc5.a) org.koin.java.a.a(rc5.a.class)).z(this.treeNode.obj_type);
    }

    @Override // com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2, com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        if (this.docMetaInfo != null) goto L6;
        tt5.a.d(TAG, "docMetaInfo is null, return");
        return;
    L6:
        super.onClick();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void onRelease() {
        super.onRelease();
        CompositeDisposable r0 = this.disposables;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    private WikiThumbNailInfo getThumbnailInfo(String r4) {
    L8:
        return null;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        return (WikiThumbNailInfo) new Gson().fromJson(r4, WikiThumbNailInfo.class);
    }

    private /* synthetic */ void lambda$isManualOfflineByNet$4(Boolean r3) throws Exception {
        tt5.a.h(TAG, "isManualOfflineByNet isOffline: " + r3);
        if (getMoreInfo() == null) goto L6;
        getMoreInfo().J(r3.booleanValue());
    L6:
        if (getHostProvider() == null) goto L9;
        getHostProvider().g();
        return;
    }

    private static void lambda$isManualOfflineByNet$5(Throwable r3) throws Exception {
        tt5.a.e(TAG, "isManualOfflineByNet error", r3, false);
    }

    private /* synthetic */ void lambda$new$0(DocMetaInfo r1) throws Exception {
        this.docMetaInfo = r1;
    }

    private static void lambda$new$1(Throwable r3) throws Exception {
        tt5.a.e(TAG, "get meta error", r3, false);
    }

    private static void lambda$new$3(Throwable r3) throws Exception {
        tt5.a.e(TAG, "get offline status error", r3, false);
    }

    public WikiTreeManualCacheItem(sj5.b r3, final TreeNode r4) {
        super(ContextsKt.findActivity(r3.getHostFragment().getActivity()));
        this.disposables = new CompositeDisposable();
        this.treeNode = r4;
        Disposable r5 = ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).b(r4.obj_token, r4.obj_type).subscribe(new g(this), new h());
        Disposable r6 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).S(r4.origin_wiki_token).observeOn(fo5.d.d()).subscribe(new i(this, r4), new j());
        this.disposables.add(r5);
        this.disposables.add(r6);
    }

    private /* synthetic */ void lambda$new$2(TreeNode r3, Boolean r4) throws Exception {
        if (getMoreInfo() == null) goto L6;
        getMoreInfo().J(r4.booleanValue());
    L6:
        if (getHostProvider() == null) goto L8;
        getHostProvider().g();
    L8:
        isManualOfflineByNet(r3.origin_wiki_token, r4.booleanValue());
    }

    public void isManualOfflineByNet(String r3, boolean r4) {
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).y(r3, 16, r4).observeOn(fo5.d.d()).subscribe(new k(this), new l());
    }
}
