package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
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

/* JADX INFO: loaded from: classes18.dex */
public final class DraftStoreManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DraftStoreManager f231285d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<ze5.b>> f231286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f231287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f231288c;

    public static final class a extends com.bytedance.ee.bear.contract.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DraftStoreManager f231289b;

        public a(DraftStoreManager r100) {
            this.f231289b = r100;
        }

        @Override // com.bytedance.ee.bear.contract.c
        public final void b(AccountService$Account r100) {
            StringBuilder r101 = new StringBuilder("account change, uid = ");
            String r102 = null;
            if (r100 == null) goto L5;
            String r103 = r100.uid;
        L6:
            r101.append(r103);
            tt5.a.h("Comment#DraftStoreManager", r101.toString());
            if (r100 == null) goto L9;
            r102 = r100.uid;
        L9:
            if (r102 != null) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(this.f231289b.f231288c, r100.uid) == true) goto L15;
            this.f231289b.f231288c = r100.uid;
            this.f231289b.e();
            return;
        L15:
            return;
        L5:
            r103 = null;
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
        f231285d = (DraftStoreManager) LazyKt.lazy(DraftStoreManager$Companion$INSTANCE$1.INSTANCE).getValue();
    }

    public final void a() {
        Iterator<Map.Entry<String, WeakReference<ze5.b>>> r100 = this.f231286a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<String, WeakReference<ze5.b>> r101 = r100.next();
        if (r101.getValue().get() != null) goto L4;
        tt5.a.h("Comment#DraftStoreManager", "recycle, token = " + du5.b.g(r101.getKey()));
        r100.remove();
        goto L4
    }

    public final void e() {
        tt5.a.h("Comment#DraftStoreManager", "resetStores()... uid = " + this.f231288c);
        this.f231287b.clear();
        CopyOnWriteArrayList<String> r100 = this.f231287b;
        com.ss.android.lark.storage.kv.repo.a r101 = b();
        int r102 = com.bytedance.ee.bear.middleground.comment.draft.c.f231298a;
        List r103 = r101.getJSONArray("Docs_Comment_Draft_Tokens", String.class);
        if (r103 != null) goto L6;
        r103 = CollectionsKt.emptyList();
    L6:
        r100.addAll(r103);
        this.f231286a.clear();
    }

    public DraftStoreManager() {
        this.f231286a = new ConcurrentHashMap();
        this.f231287b = new CopyOnWriteArrayList();
        h0 r100 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        this.f231288c = r100.G2().uid;
        tt5.a.h("Comment#DraftStoreManager", "DraftStoreManager init, uid = " + this.f231288c);
        e();
        r100.Pe(new a(this));
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        tt5.a.h("Comment#DraftStoreManager", "onCommentDestroy()... token = " + du5.b.g(r100));
        a();
    }

    public final ze5.b d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        tt5.a.h("Comment#DraftStoreManager", "provideDraftStore()... token = " + du5.b.g(r100));
        a();
        WeakReference<ze5.b> r101 = this.f231286a.get(r100);
        if (r101 == null) goto L6;
        ze5.b r102 = r101.get();
        if (r102 == null) goto L6;
        return r102;
    L6:
        tt5.a.h("Comment#DraftStoreManager", "cache is null, load from sp");
        int r103 = com.bytedance.ee.bear.middleground.comment.draft.c.f231298a;
        HashMap r104 = (HashMap) new Gson().fromJson(b().getString(com.bytedance.ee.bear.middleground.comment.draft.c.c(r100), SliceInitService.DEFAULT_SWITCH), new c().getType());     // Catch: Throwable -> L9
    L11:
        if (r104 != null) goto L13;
        r104 = new HashMap();
    L13:
        com.bytedance.ee.bear.middleground.comment.draft.b r105 = new com.bytedance.ee.bear.middleground.comment.draft.b(r100, r104);
        this.f231286a.put(r100, new WeakReference(r105));
        return r105;
    L9:
        th = move-exception;
        tt5.a.e("Comment#DraftStoreManager", "parse draft error", th, false);
        r104 = null;
        goto L11
    }
}
