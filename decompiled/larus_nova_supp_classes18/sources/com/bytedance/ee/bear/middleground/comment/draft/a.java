package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements ze5.a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.draft.a$a, reason: collision with other inner class name */
    public final class C0062a implements com.bytedance.ee.bear.contract.b {
        public final int a;
        public final /* synthetic */ a b;

        public final void a(AccountService.Account r3) {
            String r0 = null;
            if (r3 == null) goto L5;
            String r1 = r3.uid;
        L6:
            if (r1 != null) goto L8;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == true) goto L20;
            if (r3 == null) goto L16;
            r0 = r3.uid;
        L16:
            if (Intrinsics.areEqual(r0, "null") == true) goto L21;
            a r4 = this.b;
            int r5 = this.a;
            Intrinsics.checkNotNull(r3);
            String r6 = r3.uid;
            r4.getClass();
            a.c(r5, r6, this);
            return;
        L21:
            return;
        L20:
            return;
        L8:
            if (r1.length() == 0) goto L11;
            r2 = false;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public C0062a(a r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final class b implements com.bytedance.ee.bear.contract.b {
        public final List<String> a;
        public final /* synthetic */ a b;

        public final void a(AccountService.Account r3) {
            String r0 = null;
            if (r3 == null) goto L5;
            String r1 = r3.uid;
        L6:
            if (r1 != null) goto L8;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == true) goto L20;
            if (r3 == null) goto L16;
            r0 = r3.uid;
        L16:
            if (Intrinsics.areEqual(r0, "null") == true) goto L21;
            a r4 = this.b;
            List<String> r5 = this.a;
            Intrinsics.checkNotNull(r3);
            String r6 = r3.uid;
            r4.getClass();
            a.d(r5, r6, this);
            return;
        L21:
            return;
        L20:
            return;
        L8:
            if (r1.length() == 0) goto L11;
            r2 = false;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public b(a r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "tokens");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class c {
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/ee/bear/middleground/comment/draft/DraftCleaner$cleanByTimeInternal$2", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/middleground/comment/export/draft/DraftEntity;", "Lkotlin/collections/HashMap;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends TypeToken<HashMap<String, DraftEntity>> {
        public d() {
        }
    }

    static {
    }

    public a() {
    }

    @Override // ze5.a
    public final void a(int r5) {
        AccountService.Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r0 == null) goto L5;
        String r1 = r0.uid;
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        tt5.a.h("Comment#DraftCleaner", "cleanByTime()... seconds = " + r5 + ", uid is empty!");
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(new C0062a(this, r5));
        return;
    L14:
        c(r5, r1, null);
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // ze5.a
    public final void b(List<String> r9) {
        List<String> r0 = r9;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        tt5.a.k("Comment#DraftCleaner", "cleanByTokens()... tokens is empty!");
        return;
    L13:
        DraftStoreManager r3 = DraftStoreManager.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "tokens");
        Iterator<String> r4 = r9.iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        String r5 = r4.next();
        tt5.a.h("Comment#DraftStoreManager", "cleanStoreCache()... token = " + du5.b.g(r5));
        r3.a.remove(r5);
        r3.b.remove(r5);
        goto L15
    L17:
        AccountService.Account r6 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r6 == null) goto L20;
        String r7 = r6.uid;
    L21:
        if (r7 != null) goto L23;
    L26:
        if (r1 == false) goto L28;
        StringBuilder r8 = new StringBuilder("cleanByTokens()... tokens = ");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Any");
        r8.append(du5.b.f(r9));
        r8.append(", uid is empty!");
        tt5.a.h("Comment#DraftCleaner", r8.toString());
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(new b(this, r9));
        return;
    L28:
        d(r9, r7, null);
        return;
    L23:
        if (r7.length() == 0) goto L26;
        r1 = false;
        goto L26
    L20:
        r7 = null;
        goto L21
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public static void c(int r18, String r19, C0062a r20) {
        tt5.a.h("Comment#DraftCleaner", "cleanByTimeInternal()... seconds = " + r18 + ", uid = " + r19);
        HashMap r4 = null;
        if (r20 == null) goto L5;
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).qc(r20);
    L5:
        int r1 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        com.ss.android.lark.storage.kv.repo.a r2 = ay4.b.d("comment_draft", 6);
        List r3 = r2.getJSONArray("Docs_Comment_Draft_Tokens", String.class);
        if (TypeIntrinsics.isMutableList(r3) == true) goto L9;
        r3 = null;
    L9:
        StringBuilder r6 = new StringBuilder("tokens size before = ");
        if (r3 == null) goto L12;
        int r8 = r3.size();
    L13:
        r6.append(r8);
        tt5.a.h("Comment#DraftCleaner", r6.toString());
        List r7 = r3;
        if (r7 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
        return;
    L22:
        long r10 = System.currentTimeMillis() - (((long) r18) * 1000);
        Iterator r11 = CollectionsKt.toList(r3).iterator();
    L24:
        if (r11.hasNext() == false) goto L65;
        String r12 = (String) r11.next();
        tt5.a.h("Comment#DraftCleaner", "start processing token: " + du5.b.g(r12));
        int r0 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        String r13 = com.bytedance.ee.bear.middleground.comment.draft.c.c(r12);
        if (r2.contains(r13) == false) goto L27;
        HashMap r5 = (HashMap) new Gson().fromJson(r2.getString(r13, "{}"), new d().getType());     // Catch: Throwable -> L31
    L33:
        StringBuilder r14 = new StringBuilder("storeData size before = ");
        if (r5 == null) goto L36;
        int r15 = r5.size();
    L37:
        r14.append(r15);
        tt5.a.h("Comment#DraftCleaner", r14.toString());
        if (r5 != null) goto L40;
    L42:
        boolean r16 = false;
    L43:
        if (r16 == false) goto L50;
        Iterator r17 = r5.entrySet().iterator();
    L46:
        if (r17.hasNext() == false) goto L50;
        Map.Entry r110 = (Map.Entry) r17.next();
        if (((DraftEntity) r110.getValue()).getLastAccess() >= r10) goto L46;
        tt5.a.h("Comment#DraftCleaner", "remove draft, key = " + ((String) r110.getKey()) + ", value = " + r110.getValue());
        r17.remove();
    L50:
        StringBuilder r21 = new StringBuilder("storeData size after = ");
        if (r5 == null) goto L53;
        int r111 = r5.size();
    L54:
        r21.append(r111);
        tt5.a.h("Comment#DraftCleaner", r21.toString());
        if (r5 != null) goto L57;
    L60:
        boolean r22 = true;
    L61:
        if (r22 == false) goto L63;
        r2.remove(r13);
        r3.remove(r12);
    L64:
        r4 = null;
        goto L24
    L63:
        r2.putJSONObject(r13, r5);
        goto L64
    L57:
        if (r5.isEmpty() == true) goto L60;
        r22 = false;
        goto L61
    L53:
        r111 = 0;
        goto L54
    L40:
        if ((!r5.isEmpty()) != true) goto L42;
        r16 = true;
        goto L43
    L36:
        r15 = 0;
    L31:
        th = move-exception;
        tt5.a.e("Comment#DraftCleaner", "parse draft error", th, false);
        r5 = r4;
        goto L33
    L27:
        tt5.a.h("Comment#DraftCleaner", "draftKey not exists");
        r3.remove(r12);
        goto L24
    L65:
        tt5.a.h("Comment#DraftCleaner", "tokens size after = " + r3.size());
        if (r3.isEmpty() == false) goto L68;
        r2.remove("Docs_Comment_Draft_Tokens");
        return;
    L68:
        r2.putJSONArray("Docs_Comment_Draft_Tokens", r3);
        return;
    L16:
        if (r7.isEmpty() == true) goto L19;
        r9 = false;
        goto L20
    L12:
        r8 = 0;
        goto L13
    }

    public static void d(List r6, String r7, b r8) {
        StringBuilder r0 = new StringBuilder("cleanByTokensInternal()... tokens = ");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Any");
        r0.append(du5.b.f(r6));
        r0.append(", uid = ");
        r0.append(r7);
        tt5.a.h("Comment#DraftCleaner", r0.toString());
        List r1 = null;
        if (r8 == null) goto L5;
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).qc(r8);
    L5:
        com.ss.android.lark.storage.kv.repo.a r9 = ay4.b.d("comment_draft", 6);
        int r10 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        List r11 = r9.getJSONArray("Docs_Comment_Draft_Tokens", String.class);
        if (TypeIntrinsics.isMutableList(r11) == false) goto L8;
        r1 = r11;
    L8:
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        tt5.a.h("Comment#DraftCleaner", "tokensInSp size before = " + r1.size());
        Iterator r12 = CollectionsKt.toList(r6).iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        String r3 = (String) r12.next();
        tt5.a.h("Comment#DraftCleaner", "start processing token: " + du5.b.g(r3));
        r1.remove(r3);
        int r4 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        r9.remove(com.bytedance.ee.bear.middleground.comment.draft.c.c(r3));
        goto L12
    L14:
        tt5.a.h("Comment#DraftCleaner", "tokensInSp size after = " + r1.size());
        if (r6.isEmpty() == false) goto L17;
        r9.remove("Docs_Comment_Draft_Tokens");
        return;
    L17:
        r9.putJSONArray("Docs_Comment_Draft_Tokens", r1);
    }
}
