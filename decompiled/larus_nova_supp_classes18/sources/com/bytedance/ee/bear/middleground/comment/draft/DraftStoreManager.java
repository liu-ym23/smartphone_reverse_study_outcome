package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DraftStoreManager {
    public static final DraftStoreManager d = null;
    public final ConcurrentHashMap<String, WeakReference<ze5.b>> a;
    public final CopyOnWriteArrayList<String> b;
    public volatile String c;

    public static final class a extends com.bytedance.ee.bear.contract.c {
        public final /* synthetic */ DraftStoreManager b;

        public a(DraftStoreManager r1) {
            this.b = r1;
        }

        public final void b(AccountService.Account r4) {
            StringBuilder r0 = new StringBuilder("account change, uid = ");
            String r1 = null;
            if (r4 == null) goto L5;
            String r2 = r4.uid;
        L6:
            r0.append(r2);
            tt5.a.h("Comment#DraftStoreManager", r0.toString());
            if (r4 == null) goto L9;
            r1 = r4.uid;
        L9:
            if (r1 != null) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(this.b.c, r4.uid) == true) goto L15;
            this.b.c = r4.uid;
            this.b.e();
            return;
        L15:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/ee/bear/middleground/comment/draft/DraftStoreManager$provideDraftStore$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/middleground/comment/export/draft/DraftEntity;", "Lkotlin/collections/HashMap;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<HashMap<String, DraftEntity>> {
        public c() {
        }
    }

    public static com.ss.android.lark.storage.kv.repo.a b() {
        return ay4.b.d("comment_draft", 6);
    }

    static {
        d = (DraftStoreManager) LazyKt.lazy(DraftStoreManager$Companion$INSTANCE$1.INSTANCE).getValue();
    }

    public final void a() {
        Iterator<Map.Entry<String, WeakReference<ze5.b>>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, WeakReference<ze5.b>> r1 = r0.next();
        if (r1.getValue().get() != null) goto L4;
        tt5.a.h("Comment#DraftStoreManager", "recycle, token = " + du5.b.g(r1.getKey()));
        r0.remove();
        goto L4
    }

    public final void e() {
        tt5.a.h("Comment#DraftStoreManager", "resetStores()... uid = " + this.c);
        this.b.clear();
        CopyOnWriteArrayList<String> r0 = this.b;
        com.ss.android.lark.storage.kv.repo.a r1 = b();
        int r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        List r3 = r1.getJSONArray("Docs_Comment_Draft_Tokens", String.class);
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        r0.addAll(r3);
        this.a.clear();
    }

    public DraftStoreManager() {
        this.a = new ConcurrentHashMap();
        this.b = new CopyOnWriteArrayList();
        h0 r0 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        this.c = r0.G2().uid;
        tt5.a.h("Comment#DraftStoreManager", "DraftStoreManager init, uid = " + this.c);
        e();
        r0.Pe(new a(this));
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        tt5.a.h("Comment#DraftStoreManager", "onCommentDestroy()... token = " + du5.b.g(r3));
        a();
    }

    public final ze5.b d(String r5) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        tt5.a.h("Comment#DraftStoreManager", "provideDraftStore()... token = " + du5.b.g(r5));
        a();
        WeakReference<ze5.b> r0 = this.a.get(r5);
        if (r0 == null) goto L6;
        ze5.b r1 = r0.get();
        if (r1 == null) goto L6;
        return r1;
    L6:
        tt5.a.h("Comment#DraftStoreManager", "cache is null, load from sp");
        int r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        HashMap r3 = (HashMap) new Gson().fromJson(b().getString(com.bytedance.ee.bear.middleground.comment.draft.c.c(r5), "{}"), new c().getType());     // Catch: Throwable -> L9
    L11:
        if (r3 != null) goto L13;
        r3 = new HashMap();
    L13:
        com.bytedance.ee.bear.middleground.comment.draft.b r4 = new com.bytedance.ee.bear.middleground.comment.draft.b(r5, r3);
        this.a.put(r5, new WeakReference(r4));
        return r4;
    L9:
        th = move-exception;
        tt5.a.e("Comment#DraftStoreManager", "parse draft error", th, false);
        r3 = null;
        goto L11
    }
}
