package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uu5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ze5.b {
    public final String a;
    public final HashMap<String, DraftEntity> b;
    public final m<Pair<String, String>> c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.draft.b$b, reason: collision with other inner class name */
    public static final class C0063b<V> implements m.a {
        public static final C0063b<V> a = null;

        static {
            a = new C0063b();
        }

        public C0063b() {
        }

        public final void onSubscribe(Object r3) {
            Pair r4 = (Pair) r3;
            StringBuilder r0 = new StringBuilder("saveDraftContent()... key = ");
            r0.append((String) r4.getFirst());
            r0.append(", content length = ");
            String r5 = (String) r4.getSecond();
            if (r5 == null) goto L5;
            int r6 = r5.length();
        L6:
            r0.append(r6);
            tt5.a.h("Comment#DraftStoreImpl", r0.toString());
            return;
        L5:
            r6 = 0;
            goto L6
        }
    }

    static {
    }

    public final void g() {
        DraftStoreManager r0 = DraftStoreManager.d;
        String r1 = this.a;
        HashMap<String, DraftEntity> r2 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "storeData");
        int r3 = c.a;
        String r4 = c.c(r1);
        if (r2.isEmpty() == false) goto L10;
        DraftStoreManager.b().remove(r4);
        if (r0.b.contains(r1) == false) goto L14;
        r0.b.remove(r1);
        if (r0.b.isEmpty() == false) goto L9;
        DraftStoreManager.b().remove("Docs_Comment_Draft_Tokens");
        return;
    L9:
        DraftStoreManager.b().putJSONArray("Docs_Comment_Draft_Tokens", r0.b);
        return;
    L14:
        return;
    L10:
        DraftStoreManager.b().putJSONObject(r4, r2);
        if (r0.b.contains(r1) == true) goto L17;
        r0.b.add(r1);
        DraftStoreManager.b().putJSONArray("Docs_Comment_Draft_Tokens", r0.b);
        return;
    }

    @Override // ze5.b
    public final DraftEntity a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        DraftEntity r0 = this.b.get(r4);
        tt5.a.h("Comment#DraftStoreImpl", "loadDraft()... key = " + r4 + ", draft = " + r0);
        return r0;
    }

    public final DraftEntity f(String r4) {
        DraftEntity r0 = this.b.get(r4);
        if (r0 != null) goto L6;
        DraftEntity r1 = new DraftEntity(null, null, 3, null);
        this.b.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public b(String r3, HashMap<String, DraftEntity> r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "store");
        this.a = r3;
        this.b = r4;
        this.c = new m(1000, C0063b.a);
    }

    @Override // ze5.b
    public final void b(String r3, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        StringBuilder r0 = new StringBuilder("addDraftImages()... key = ");
        r0.append(r3);
        r0.append(", images count = ");
        if (r4 == null) goto L5;
        int r1 = r4.size();
    L6:
        r0.append(r1);
        tt5.a.h("Comment#DraftStoreImpl", r0.toString());
        DraftEntity r2 = f(r3);
        r2.addImages(r4);
        if (r2.isDraftEmpty() == false) goto L9;
        this.b.remove(r3);
    L9:
        g();
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // ze5.b
    public final void c(String r3, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        StringBuilder r0 = new StringBuilder("removeDraftImages()... key = ");
        r0.append(r3);
        r0.append(", images count = ");
        if (r4 == null) goto L5;
        int r1 = r4.size();
    L6:
        r0.append(r1);
        tt5.a.h("Comment#DraftStoreImpl", r0.toString());
        DraftEntity r2 = f(r3);
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r2.removeImage((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r5.next());
    L13:
        if (r2.isDraftEmpty() == false) goto L15;
        this.b.remove(r3);
    L15:
        g();
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // ze5.b
    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        this.c.a(new Pair(r3, r4));
        DraftEntity r0 = f(r3);
        r0.setContent(r4);
        if (r0.isDraftEmpty() == false) goto L5;
        this.b.remove(r3);
    L5:
        g();
    }

    @Override // ze5.b
    public final void e(String r3, DraftEntity r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        tt5.a.h("Comment#DraftStoreImpl", "saveDraft()... key = " + r3 + ", draft = " + r4);
        if (r4 != null) goto L5;
    L8:
        this.b.remove(r3);
    L9:
        g();
        return;
    L5:
        if (r4.isDraftEmpty() == true) goto L8;
        this.b.put(r3, r4);
        goto L9
    }
}
