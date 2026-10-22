package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uu5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ze5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f231294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, DraftEntity> f231295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m<Pair<String, String>> f231296c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.draft.b$b, reason: collision with other inner class name */
    public static final class C3310b<V> implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3310b<V> f231297a = null;

        static {
            f231297a = new C3310b();
        }

        public C3310b() {
        }

        @Override // uu5.m.a
        public final void onSubscribe(Object r100) {
            Pair r101 = (Pair) r100;
            StringBuilder r102 = new StringBuilder("saveDraftContent()... key = ");
            r102.append((String) r101.getFirst());
            r102.append(", content length = ");
            String r103 = (String) r101.getSecond();
            if (r103 == null) goto L5;
            int r104 = r103.length();
        L6:
            r102.append(r104);
            tt5.a.h("Comment#DraftStoreImpl", r102.toString());
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    static {
    }

    public final void g() {
        DraftStoreManager r100 = DraftStoreManager.f231285d;
        String r101 = this.f231294a;
        HashMap<String, DraftEntity> r102 = this.f231295b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "storeData");
        int r103 = c.f231298a;
        String r104 = c.c(r101);
        if (r102.isEmpty() == false) goto L10;
        DraftStoreManager.b().remove(r104);
        if (r100.f231287b.contains(r101) == false) goto L14;
        r100.f231287b.remove(r101);
        if (r100.f231287b.isEmpty() == false) goto L9;
        DraftStoreManager.b().remove("Docs_Comment_Draft_Tokens");
        return;
    L9:
        DraftStoreManager.b().putJSONArray("Docs_Comment_Draft_Tokens", r100.f231287b);
        return;
    L14:
        return;
    L10:
        DraftStoreManager.b().putJSONObject(r104, r102);
        if (r100.f231287b.contains(r101) == true) goto L17;
        r100.f231287b.add(r101);
        DraftStoreManager.b().putJSONArray("Docs_Comment_Draft_Tokens", r100.f231287b);
        return;
    }

    @Override // ze5.b
    public final DraftEntity a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        DraftEntity r101 = this.f231295b.get(r100);
        tt5.a.h("Comment#DraftStoreImpl", "loadDraft()... key = " + r100 + ", draft = " + r101);
        return r101;
    }

    public final DraftEntity f(String r100) {
        DraftEntity r101 = this.f231295b.get(r100);
        if (r101 != null) goto L6;
        DraftEntity r102 = new DraftEntity(null, null, 3, null);
        this.f231295b.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public b(String r100, HashMap<String, DraftEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        this.f231294a = r100;
        this.f231295b = r101;
        this.f231296c = new m(1000, C3310b.f231297a);
    }

    @Override // ze5.b
    public final void b(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        StringBuilder r102 = new StringBuilder("addDraftImages()... key = ");
        r102.append(r100);
        r102.append(", images count = ");
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        r102.append(r103);
        tt5.a.h("Comment#DraftStoreImpl", r102.toString());
        DraftEntity r104 = f(r100);
        r104.addImages(r101);
        if (r104.isDraftEmpty() == false) goto L9;
        this.f231295b.remove(r100);
    L9:
        g();
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // ze5.b
    public final void c(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        StringBuilder r102 = new StringBuilder("removeDraftImages()... key = ");
        r102.append(r100);
        r102.append(", images count = ");
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        r102.append(r103);
        tt5.a.h("Comment#DraftStoreImpl", r102.toString());
        DraftEntity r104 = f(r100);
        if (r101 == null) goto L13;
        Iterator<T> r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L13;
        r104.removeImage((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r105.next());
    L13:
        if (r104.isDraftEmpty() == false) goto L15;
        this.f231295b.remove(r100);
    L15:
        g();
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // ze5.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f231296c.a(new Pair(r100, r101));
        DraftEntity r102 = f(r100);
        r102.setContent(r101);
        if (r102.isDraftEmpty() == false) goto L5;
        this.f231295b.remove(r100);
    L5:
        g();
    }

    @Override // ze5.b
    public final void e(String r100, DraftEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        tt5.a.h("Comment#DraftStoreImpl", "saveDraft()... key = " + r100 + ", draft = " + r101);
        if (r101 != null) goto L5;
    L8:
        this.f231295b.remove(r100);
    L9:
        g();
        return;
    L5:
        if (r101.isDraftEmpty() == true) goto L8;
        this.f231295b.put(r100, r101);
        goto L9
    }
}
