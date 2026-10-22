package com.bytedance.ee.bear.list.delete;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DeleteExecutor extends com.bytedance.ee.bear.list.e<Result<String>> implements com.bytedance.ee.bear.list.delete.f {
    public static final a c = null;
    public final String b;

    public static final class a implements nc5.b {
        public a() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    public static final class b {
    }

    public static final class c {
        public final boolean a;
        public final Map<String, Integer> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeleteGroupResult(allSuccess=" + this.a + ", failedTokenToCode=" + this.b + ')';
        }

        public c(boolean r2, Map<String, Integer> r3) {
            Intrinsics.checkNotNullParameter(r3, "failedTokenToCode");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements NetService.c<Result<String>> {
        public d() {
        }

        public final Result<String> parse(String r3) {
            Intrinsics.checkNotNullParameter(r3, "json");
            Result<String> r0 = new Result();
            JSONObject r1 = new JSONObject(r3);     // Catch: JSONException -> L5
            r0.msg = r1.optString("msg");     // Catch: JSONException -> L5
            r0.code = r1.optInt("code");     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            tt5.a.d("DeleteParser", e.getMessage());
            goto L7
        }
    }

    public static final class e implements NetService.c<Result<DeleteTaskResult>> {
        public e() {
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.list.delete.DeleteTaskResult, java.io.Serializable] */
        public final Result<DeleteTaskResult> parse(String r5) {
            Result<DeleteTaskResult> r0 = new Result();
            if (r5 != null) goto L11;
        L10:
            return r0;
        L11:
            JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L8
            r0.code = r1.optInt("code");     // Catch: JSONException -> L8
            r0.msg = r1.optString("msg");     // Catch: JSONException -> L8
            JSONObject r6 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L8
            if (r6 == null) goto L10;
            ?? r2 = new DeleteTaskResult();     // Catch: JSONException -> L8
            r2.setTaskId(r6.optString("task_id"));     // Catch: JSONException -> L8
            r0.data = r2;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("DeleteTaskResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class f implements NetService.c<Result<DeleteTaskStatusResult>> {
        public f() {
        }

        public static Map a(JSONObject r6) {
            LinkedHashMap r0 = new LinkedHashMap();
            JSONObject r7 = r6.optJSONObject("fail_data");
            if (r7 != null) goto L5;
            return r0;
        L5:
            JSONObject r1 = r7.optJSONObject("node_token_to_fail_data");
            if (r1 == null) goto L16;
            Iterator<String> r8 = r1.keys();
        L9:
            if (r8.hasNext() == false) goto L15;
            String r3 = r8.next();
            JSONObject r4 = r1.optJSONObject(r3);
            if (r4 == null) goto L9;
            if (r4.has("code") == false) goto L9;
            r0.put(r3, Integer.valueOf(r4.optInt("code")));
            goto L9
        L15:
            return r0;
        L16:
            Iterator<String> r2 = r7.keys();
        L18:
            if (r2.hasNext() == false) goto L24;
            String r5 = r2.next();
            JSONObject r9 = r7.optJSONObject(r5);
            if (r9 == null) goto L18;
            if (r9.has("code") == false) goto L18;
            r0.put(r5, Integer.valueOf(r9.optInt("code")));
            goto L18
        L24:
            return r0;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.list.delete.DeleteTaskStatusResult, java.io.Serializable] */
        public final Result<DeleteTaskStatusResult> parse(String r5) {
            Result<DeleteTaskStatusResult> r0 = new Result();
            if (r5 != null) goto L11;
        L10:
            return r0;
        L11:
            JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L8
            r0.code = r1.optInt("code");     // Catch: JSONException -> L8
            r0.msg = r1.optString("msg");     // Catch: JSONException -> L8
            JSONObject r6 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L8
            if (r6 == null) goto L10;
            ?? r2 = new DeleteTaskStatusResult();     // Catch: JSONException -> L8
            r2.setFinish(r6.optBoolean("is_finish"));     // Catch: JSONException -> L8
            r2.setFail(r6.optBoolean("is_fail"));     // Catch: JSONException -> L8
            r2.setFailedTokenToCode(a(r6));     // Catch: JSONException -> L8
            r0.data = r2;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("DeleteTaskStatusResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class g implements nc5.a<c> {
        public final /* synthetic */ nc5.a<Boolean> a;

        public g(nc5.a<Boolean> r1) {
            this.a = r1;
        }

        @Override // nc5.a
        public final void onFailure(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.onFailure(r2);
        }

        @Override // nc5.a
        public final void onSuccess(c r2) {
            c r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.onSuccess(Boolean.valueOf(r3.a));
        }
    }

    public static final class h implements nc5.a<c> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ ConcurrentHashMap<String, Integer> c;
        public final /* synthetic */ DeleteExecutor d;
        public final /* synthetic */ AtomicInteger e;
        public final /* synthetic */ nc5.c<com.bytedance.ee.bear.list.delete.e> f;

        @Override // nc5.a
        public final void onFailure(Throwable r8) {
            Intrinsics.checkNotNullParameter(r8, "error");
            if (this.a.get() == false) goto L5;
            return;
        L5:
            this.b.set(false);
            DeleteExecutor.o(this.d, this.e, this.a, this.b, this.c, this.f);
        }

        @Override // nc5.a
        public final void onSuccess(c r8) {
            c r9 = r8;
            Intrinsics.checkNotNullParameter(r9, "result");
            if (this.a.get() == false) goto L6;
            return;
        L6:
            if (r9.a == true) goto L8;
            this.b.set(false);
            this.c.putAll(r9.b);
        L8:
            DeleteExecutor.o(this.d, this.e, this.a, this.b, this.c, this.f);
        }

        public h(AtomicBoolean r1, AtomicBoolean r2, ConcurrentHashMap<String, Integer> r3, DeleteExecutor r4, AtomicInteger r5, nc5.c<com.bytedance.ee.bear.list.delete.e> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class i implements nc5.a<Result<String>> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ DeleteExecutor b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ AtomicBoolean d;
        public final /* synthetic */ ConcurrentHashMap<String, Integer> e;
        public final /* synthetic */ nc5.c<com.bytedance.ee.bear.list.delete.e> f;

        @Override // nc5.a
        public final void onFailure(Throwable r8) {
            Intrinsics.checkNotNullParameter(r8, "error");
            if (this.a.get() == false) goto L5;
            return;
        L5:
            this.d.set(false);
            DeleteExecutor.o(this.b, this.c, this.a, this.d, this.e, this.f);
        }

        @Override // nc5.a
        public final void onSuccess(Result<String> r7) {
            Intrinsics.checkNotNullParameter(r7, "result");
            if (this.a.get() == true) goto L7;
            DeleteExecutor.o(this.b, this.c, this.a, this.d, this.e, this.f);
            return;
        }

        public i(AtomicBoolean r1, DeleteExecutor r2, AtomicInteger r3, AtomicBoolean r4, ConcurrentHashMap<String, Integer> r5, nc5.c<com.bytedance.ee.bear.list.delete.e> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class j implements nc5.b {
        public final /* synthetic */ AtomicBoolean a;

        @Override // nc5.b
        public final void cancel() {
            this.a.set(true);
        }

        public j(AtomicBoolean r1) {
            this.a = r1;
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ long a;
        public final /* synthetic */ DeleteExecutor b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public k(long r1, DeleteExecutor r3, String r4, String r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((Long) r5, "it");
            if ((SystemClock.elapsedRealtime() - this.a) < 30000) goto L5;
            tt5.a.d(this.b.b, "pollAsyncTaskStatus timeout, path: " + this.c + ", taskId: " + this.d);
            return Observable.error(new TimeoutException("pollAsyncTaskStatus timeout, path: " + this.c + ", taskId: " + this.d));
        L5:
            NetService.d r6 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f());
            DeleteExecutor r0 = this.b;
            String r1 = this.c;
            String r2 = this.d;
            r0.getClass();
            NetService.f r3 = new NetService.f(r1);
            ((NetService.e) r3).c = 2;
            r3.b("task_id", r2);
            return r6.a(r3).toObservable();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ DeleteExecutor a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ io.reactivex.disposables.a f;
        public final /* synthetic */ Function1<DeleteTaskStatusResult, Unit> g;
        public final /* synthetic */ Function1<Throwable, Unit> h;

        /* JADX WARN: Multi-variable type inference failed */
        public l(DeleteExecutor r1, String r2, String r3, int r4, long r5, io.reactivex.disposables.a r7, Function1<? super DeleteTaskStatusResult, Unit> r8, Function1<? super Throwable, Unit> r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final void accept(Object r11) {
            Result r12 = (Result) r11;
            tt5.a.h(this.a.b, "pollAsyncTaskStatus result, path: " + this.b + ", code: " + r12.code);
            DeleteTaskStatusResult r0 = (DeleteTaskStatusResult) r12.data;
            if (r12.code != 0) goto L9;
            if (r0 == null) goto L9;
            if (r0.isFinish() == true) goto L8;
            this.a.r(this.c, this.d + 1, this.e, this.f, this.b, this.g, this.h);
            return;
        L8:
            this.g.invoke(r0);
            return;
        L9:
            this.h.invoke(new Exception("pollAsyncTaskStatus fail, path: " + this.b + ", msg: " + r12.msg));
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ DeleteExecutor a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<Throwable, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public m(DeleteExecutor r1, String r2, Function1<? super Throwable, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(this.a.b, "pollAsyncTaskStatus error, path: " + this.b, r5, false);
            Function1<Throwable, Unit> r0 = this.c;
            Intrinsics.checkNotNull(r5);
            r0.invoke(r5);
        }
    }

    static {
        c = new a();
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<Result<String>> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new d());
    }

    public DeleteExecutor() {
        this.b = "DeleteExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b b(List<com.bytedance.ee.bear.list.delete.d> r18, nc5.c<com.bytedance.ee.bear.list.delete.e> r19) {
        Intrinsics.checkNotNullParameter(r18, "items");
        Intrinsics.checkNotNullParameter(r19, "callback");
        tt5.a.h(this.b, "deleteRecentItems, items size: " + r18.size());
        boolean r1 = r18.isEmpty();
        a r2 = c;
        if (r1 == false) goto L7;
        r19.a(p(r18, "items is empty"));
        return r2;
    L7:
        if (r18.size() <= 50) goto L10;
        r19.a(p(r18, "items size is greater than 50"));
        return r2;
    L10:
        List<com.bytedance.ee.bear.list.delete.d> r0 = r18;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r0.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (((com.bytedance.ee.bear.list.delete.d) r5).c == false) goto L12;
        r3.add(r5);
        goto L12
    L16:
        ArrayList r11 = new ArrayList();
        Iterator<T> r6 = r0.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (((com.bytedance.ee.bear.list.delete.d) r7).c == true) goto L18;
        r11.add(r7);
        goto L18
    L22:
        AtomicInteger r8 = new AtomicInteger((!r3.isEmpty() ? 1 : 0) + (!r11.isEmpty() ? 1 : 0));
        AtomicBoolean r13 = new AtomicBoolean(false);
        AtomicBoolean r15 = new AtomicBoolean(true);
        ConcurrentHashMap r16 = new ConcurrentHashMap();
        if ((!r3.isEmpty()) == false) goto L34;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r10 = r3.iterator();
    L26:
        if (r10.hasNext() == false) goto L28;
        r9.add(((com.bytedance.ee.bear.list.delete.d) r10.next()).a);
        goto L26
    L28:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r14 = r3.iterator();
    L30:
        if (r14.hasNext() == false) goto L32;
        r12.add(Integer.valueOf(((com.bytedance.ee.bear.list.delete.d) r14.next()).b));
        goto L30
    L32:
        delete(r9, r12, new h(r13, r15, r16, this, r8, r19));
    L34:
        if ((!r11.isEmpty()) == false) goto L48;
        nc5.a r17 = new i(r13, this, r8, r15, r16, r19);
        if (r11.isEmpty() == false) goto L49;
        r17.onFailure(new IllegalArgumentException("items is empty"));
        goto L48
    L49:
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L44
        JSONArray r21 = new JSONArray();     // Catch: Exception -> L44
        Iterator r22 = r11.iterator();     // Catch: Exception -> L44
    L40:
        if (r22.hasNext() == false) goto L42;
        com.bytedance.ee.bear.list.delete.d r23 = (com.bytedance.ee.bear.list.delete.d) r22.next();     // Catch: Exception -> L44
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L44
        r24.put(ResourceData.KEY_OBJ_TOKEN, r23.a);     // Catch: Exception -> L44
        r24.put("obj_type", String.valueOf(r23.b));     // Catch: Exception -> L44
        r21.put(r24);     // Catch: Exception -> L44
        goto L40
    L42:
        r20.put("entities", r21);     // Catch: Exception -> L44
        String r25 = r20.toString();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r25);     // Catch: Exception -> L44
    L46:
        l(com.bytedance.ee.bear.list.e.j("/api/explorer/v2/recent/delete/", r25), r17);
    L44:
        e = move-exception;
        tt5.a.e(this.b, "buildDeleteRecentParams error", e, false);
        r25 = "";
    L48:
        return new j(r13);
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b c(final List r6, final nc5.c r7) {
        Intrinsics.checkNotNullParameter(r6, "tokenList");
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h(this.b, "deleteByObjTokens, tokenList size: " + r6.size() + ", apply: 1");
        if (r6.isEmpty() == false) goto L16;
        r7.a(new com.bytedance.ee.bear.list.delete.e(false, MapsKt.emptyMap()));
        return c;
    L16:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L12
        Iterator r3 = r6.iterator();     // Catch: Exception -> L12
    L8:
        if (r3.hasNext() == false) goto L10;
        r2.put((String) r3.next());     // Catch: Exception -> L12
        goto L8
    L10:
        r0.put("tokens", r2);     // Catch: Exception -> L12
        r0.put("apply", 1);     // Catch: Exception -> L12
        String r1 = r0.toString();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L12
    L15:
        return q(com.bytedance.ee.bear.list.e.j("/space/api/explorer/v3/remove/", r1), new DeleteExecutor$deleteByObjTokens$1(this, r7), new DeleteExecutor$deleteByObjTokens$2(this, r6, r7));
    L12:
        e = move-exception;
        tt5.a.e(this.b, "buildDeleteMultiTokensParams error", e, false);
        r1 = "";
        goto L15
    }

    public final com.bytedance.ee.bear.list.delete.e p(List<com.bytedance.ee.bear.list.delete.d> r4, String r5) {
        tt5.a.d(this.b, "buildDeleteItemsErrorResult, size=" + r4.size() + ", message=" + r5);
        List<com.bytedance.ee.bear.list.delete.d> r6 = r4;
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Pair r8 = TuplesKt.to(((com.bytedance.ee.bear.list.delete.d) r7.next()).a, -1);
        r0.put(r8.getFirst(), r8.getSecond());
        goto L4
    L7:
        return new com.bytedance.ee.bear.list.delete.e(false, r0);
    }

    private final nc5.b delete(List<String> r9, List<Integer> r10, final nc5.a<c> r11) {
        tt5.a.h(this.b, "delete, tokens: " + du5.b.k(r9.toString()) + ", types: " + r10);
        if (r9.isEmpty() == false) goto L5;
    L27:
        r11.onFailure(new IllegalArgumentException("invalid tokens/types size"));
        return c;
    L5:
        if (r10.isEmpty() == true) goto L27;
        if (r9.size() != r10.size()) goto L27;
        if (r9.size() == r10.size()) goto L29;
        tt5.a.d(this.b, "buildDeleteParams size mismatch, tokens=" + r9.size() + ", types=" + r10.size());
    L24:
        String r12 = "";
    L26:
        return q(com.bytedance.ee.bear.list.e.j("/space/api/explorer/v2/m_del_node/", r12), new AnonymousClass1(this, r11), new AnonymousClass2(r11));
    L29:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L22
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L22
        Iterator<T> r13 = r9.iterator();     // Catch: Exception -> L22
        int r3 = 0;
    L15:
        if (r13.hasNext() == false) goto L20;
        Object r4 = r13.next();     // Catch: Exception -> L22
        int r5 = r3 + 1;     // Catch: Exception -> L22
        if (r3 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L22
    L19:
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L22
        r6.put(ResourceData.KEY_OBJ_TOKEN, (String) r4);     // Catch: Exception -> L22
        r6.put("obj_type", ((Number) ListProtector.get(r10, r3)).intValue());     // Catch: Exception -> L22
        r2.put(r6);     // Catch: Exception -> L22
        r3 = r5;
        goto L15
    L20:
        r1.put("objs", r2);     // Catch: Exception -> L22
        r12 = r1.toString();     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        tt5.a.e(this.b, "buildDeleteParams error", e, false);
        goto L24
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b e(String r4, int r5, nc5.a<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        Intrinsics.checkNotNullParameter(r6, "callback");
        tt5.a.h(this.b, "deleteByObjToken, objToken: " + du5.b.k(r4) + ", objType: " + r5);
        return delete(CollectionsKt.listOf(r4), CollectionsKt.listOf(Integer.valueOf(r5)), new g(r6));
    }

    public final com.bytedance.ee.bear.list.delete.a q(NetService.f r4, Function2 r5, Function1 r6) {
        NetService.d r0 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e());
        io.reactivex.disposables.a r1 = new io.reactivex.disposables.a();
        return new com.bytedance.ee.bear.list.delete.a(this, r0.a(r4).subscribe(new com.bytedance.ee.bear.list.delete.b(this, r5, r1, r6), new com.bytedance.ee.bear.list.delete.c(this, r6)), r1);
    }

    public static final void o(DeleteExecutor r0, AtomicInteger r1, AtomicBoolean r2, AtomicBoolean r3, Map r4, nc5.c r5) {
        r0.getClass();
        if (r1.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (r2.get() == true) goto L9;
        r5.a(new com.bytedance.ee.bear.list.delete.e(r3.get(), MapsKt.toMap(r4)));
        return;
    }

    public final void r(String r15, int r16, long r17, io.reactivex.disposables.a r19, String r20, Function1<? super DeleteTaskStatusResult, Unit> r21, Function1<? super Throwable, Unit> r22) {
        long r0 = (r16 * 500) + CCMLynxCardView.ViewType.BANNER;
        long r4 = 30000 - (SystemClock.elapsedRealtime() - r17);
        long r2 = 0;
        if (r4 <= 0) goto L5;
        r2 = Math.min(r0, r4);
    L5:
        tt5.a.h(this.b, "pollAsyncTaskStatus, path: " + r20 + ", taskId: " + r15 + ", times: " + r16 + ", delay: " + r2);
        r19.b(Observable.timer(r2, TimeUnit.MILLISECONDS).flatMap(new k(r17, this, r20, r15)).subscribe(new l(this, r20, r15, r16, r17, r19, r21, r22), new m(this, r20, r22)));
    }
}
