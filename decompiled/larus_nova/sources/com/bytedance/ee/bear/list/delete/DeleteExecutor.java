package com.bytedance.ee.bear.list.delete;

import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.EventConstant;
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

/* JADX INFO: loaded from: classes18.dex */
public final class DeleteExecutor extends com.bytedance.ee.bear.list.e<Result<String>> implements com.bytedance.ee.bear.list.delete.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f227813c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f227814b;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f227815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Integer> f227816b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f227815a == r101.f227815a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f227816b, r101.f227816b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f227815a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f227816b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeleteGroupResult(allSuccess=" + this.f227815a + ", failedTokenToCode=" + this.f227816b + ')';
        }

        public c(boolean r100, Map<String, Integer> r101) {
            Intrinsics.checkNotNullParameter(r101, "failedTokenToCode");
            this.f227815a = r100;
            this.f227816b = r101;
        }
    }

    public static final class d implements NetService.c<Result<String>> {
        public d() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<String> parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Result<String> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L5
            r101.msg = r102.optString("msg");     // Catch: JSONException -> L5
            r101.code = r102.optInt("code");     // Catch: JSONException -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            tt5.a.d("DeleteParser", e.getMessage());
            goto L7
        }
    }

    public static final class e implements NetService.c<Result<DeleteTaskResult>> {
        public e() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<DeleteTaskResult> parse(String r100) {
            Result<DeleteTaskResult> r101 = new Result();
            if (r100 != null) goto L11;
        L10:
            return r101;
        L11:
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L8
            r101.code = r102.optInt("code");     // Catch: JSONException -> L8
            r101.msg = r102.optString("msg");     // Catch: JSONException -> L8
            JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L8
            if (r103 == null) goto L10;
            DeleteTaskResult r104 = new DeleteTaskResult();     // Catch: JSONException -> L8
            r104.setTaskId(r103.optString("task_id"));     // Catch: JSONException -> L8
            r101.data = r104;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("DeleteTaskResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class f implements NetService.c<Result<DeleteTaskStatusResult>> {
        public f() {
        }

        public static Map a(JSONObject r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            JSONObject r102 = r100.optJSONObject("fail_data");
            if (r102 != null) goto L5;
            return r101;
        L5:
            JSONObject r103 = r102.optJSONObject("node_token_to_fail_data");
            if (r103 == null) goto L16;
            Iterator<String> r104 = r103.keys();
        L9:
            if (r104.hasNext() == false) goto L15;
            String r105 = r104.next();
            JSONObject r106 = r103.optJSONObject(r105);
            if (r106 == null) goto L9;
            if (r106.has("code") == false) goto L9;
            r101.put(r105, Integer.valueOf(r106.optInt("code")));
            goto L9
        L15:
            return r101;
        L16:
            Iterator<String> r107 = r102.keys();
        L18:
            if (r107.hasNext() == false) goto L24;
            String r108 = r107.next();
            JSONObject r109 = r102.optJSONObject(r108);
            if (r109 == null) goto L18;
            if (r109.has("code") == false) goto L18;
            r101.put(r108, Integer.valueOf(r109.optInt("code")));
            goto L18
        L24:
            return r101;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<DeleteTaskStatusResult> parse(String r100) {
            Result<DeleteTaskStatusResult> r101 = new Result();
            if (r100 != null) goto L11;
        L10:
            return r101;
        L11:
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L8
            r101.code = r102.optInt("code");     // Catch: JSONException -> L8
            r101.msg = r102.optString("msg");     // Catch: JSONException -> L8
            JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L8
            if (r103 == null) goto L10;
            DeleteTaskStatusResult r104 = new DeleteTaskStatusResult();     // Catch: JSONException -> L8
            r104.setFinish(r103.optBoolean(EventConstant.Key.IS_FINISH));     // Catch: JSONException -> L8
            r104.setFail(r103.optBoolean("is_fail"));     // Catch: JSONException -> L8
            r104.setFailedTokenToCode(a(r103));     // Catch: JSONException -> L8
            r101.data = r104;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("DeleteTaskStatusResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class g implements nc5.a<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ nc5.a<Boolean> f227817a;

        public g(nc5.a<Boolean> r100) {
            this.f227817a = r100;
        }

        @Override // nc5.a
        public final void onFailure(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f227817a.onFailure(r100);
        }

        @Override // nc5.a
        public final void onSuccess(c r100) {
            c r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f227817a.onSuccess(Boolean.valueOf(r101.f227815a));
        }
    }

    public static final class h implements nc5.a<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f227818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f227819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Integer> f227820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DeleteExecutor f227821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f227822e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ nc5.c<com.bytedance.ee.bear.list.delete.e> f227823f;

        @Override // nc5.a
        public final void onFailure(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (this.f227818a.get() == false) goto L5;
            return;
        L5:
            this.f227819b.set(false);
            DeleteExecutor.o(this.f227821d, this.f227822e, this.f227818a, this.f227819b, this.f227820c, this.f227823f);
        }

        @Override // nc5.a
        public final void onSuccess(c r100) {
            c r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (this.f227818a.get() == false) goto L6;
            return;
        L6:
            if (r101.f227815a == true) goto L8;
            this.f227819b.set(false);
            this.f227820c.putAll(r101.f227816b);
        L8:
            DeleteExecutor.o(this.f227821d, this.f227822e, this.f227818a, this.f227819b, this.f227820c, this.f227823f);
        }

        public h(AtomicBoolean r100, AtomicBoolean r101, ConcurrentHashMap<String, Integer> r102, DeleteExecutor r103, AtomicInteger r104, nc5.c<com.bytedance.ee.bear.list.delete.e> r105) {
            this.f227818a = r100;
            this.f227819b = r101;
            this.f227820c = r102;
            this.f227821d = r103;
            this.f227822e = r104;
            this.f227823f = r105;
        }
    }

    public static final class i implements nc5.a<Result<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f227824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DeleteExecutor f227825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f227826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f227827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Integer> f227828e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ nc5.c<com.bytedance.ee.bear.list.delete.e> f227829f;

        @Override // nc5.a
        public final void onFailure(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (this.f227824a.get() == false) goto L5;
            return;
        L5:
            this.f227827d.set(false);
            DeleteExecutor.o(this.f227825b, this.f227826c, this.f227824a, this.f227827d, this.f227828e, this.f227829f);
        }

        @Override // nc5.a
        public final void onSuccess(Result<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (this.f227824a.get() == true) goto L7;
            DeleteExecutor.o(this.f227825b, this.f227826c, this.f227824a, this.f227827d, this.f227828e, this.f227829f);
            return;
        }

        public i(AtomicBoolean r100, DeleteExecutor r101, AtomicInteger r102, AtomicBoolean r103, ConcurrentHashMap<String, Integer> r104, nc5.c<com.bytedance.ee.bear.list.delete.e> r105) {
            this.f227824a = r100;
            this.f227825b = r101;
            this.f227826c = r102;
            this.f227827d = r103;
            this.f227828e = r104;
            this.f227829f = r105;
        }
    }

    public static final class j implements nc5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f227830a;

        @Override // nc5.b
        public final void cancel() {
            this.f227830a.set(true);
        }

        public j(AtomicBoolean r100) {
            this.f227830a = r100;
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f227831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DeleteExecutor f227832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f227833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f227834d;

        public k(long r100, DeleteExecutor r101, String r102, String r103) {
            this.f227831a = r100;
            this.f227832b = r101;
            this.f227833c = r102;
            this.f227834d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Long) r100, "it");
            if ((SystemClock.elapsedRealtime() - this.f227831a) < 30000) goto L5;
            tt5.a.d(this.f227832b.f227814b, "pollAsyncTaskStatus timeout, path: " + this.f227833c + ", taskId: " + this.f227834d);
            return Observable.error(new TimeoutException("pollAsyncTaskStatus timeout, path: " + this.f227833c + ", taskId: " + this.f227834d));
        L5:
            NetService.d r101 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f());
            DeleteExecutor r102 = this.f227832b;
            String r103 = this.f227833c;
            String r104 = this.f227834d;
            r102.getClass();
            NetService.f r105 = new NetService.f(r103);
            r105.f216906c = 2;
            r105.b("task_id", r104);
            return r101.a(r105).toObservable();
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeleteExecutor f227835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f227836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f227837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f227838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f227839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ io.reactivex.disposables.a f227840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function1<DeleteTaskStatusResult, Unit> f227841g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Function1<Throwable, Unit> f227842h;

        /* JADX WARN: Multi-variable type inference failed */
        public l(DeleteExecutor r100, String r101, String r102, int r103, long r104, io.reactivex.disposables.a r105, Function1<? super DeleteTaskStatusResult, Unit> r106, Function1<? super Throwable, Unit> r107) {
            this.f227835a = r100;
            this.f227836b = r101;
            this.f227837c = r102;
            this.f227838d = r103;
            this.f227839e = r104;
            this.f227840f = r105;
            this.f227841g = r106;
            this.f227842h = r107;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Result r111 = (Result) r110;
            tt5.a.h(this.f227835a.f227814b, "pollAsyncTaskStatus result, path: " + this.f227836b + ", code: " + r111.code);
            DeleteTaskStatusResult r100 = (DeleteTaskStatusResult) r111.data;
            if (r111.code != 0) goto L9;
            if (r100 == null) goto L9;
            if (r100.isFinish() == true) goto L8;
            this.f227835a.r(this.f227837c, this.f227838d + 1, this.f227839e, this.f227840f, this.f227836b, this.f227841g, this.f227842h);
            return;
        L8:
            this.f227841g.invoke(r100);
            return;
        L9:
            this.f227842h.invoke(new Exception("pollAsyncTaskStatus fail, path: " + this.f227836b + ", msg: " + r111.msg));
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeleteExecutor f227843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f227844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Throwable, Unit> f227845c;

        /* JADX WARN: Multi-variable type inference failed */
        public m(DeleteExecutor r100, String r101, Function1<? super Throwable, Unit> r102) {
            this.f227843a = r100;
            this.f227844b = r101;
            this.f227845c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(this.f227843a.f227814b, "pollAsyncTaskStatus error, path: " + this.f227844b, r101, false);
            Function1<Throwable, Unit> r102 = this.f227845c;
            Intrinsics.checkNotNull(r101);
            r102.invoke(r101);
        }
    }

    static {
        f227813c = new a();
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<Result<String>> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new d());
    }

    public DeleteExecutor() {
        this.f227814b = "DeleteExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.f227814b;
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b b(List<com.bytedance.ee.bear.list.delete.d> r110, nc5.c<com.bytedance.ee.bear.list.delete.e> r111) {
        Intrinsics.checkNotNullParameter(r110, "items");
        Intrinsics.checkNotNullParameter(r111, "callback");
        tt5.a.h(this.f227814b, "deleteRecentItems, items size: " + r110.size());
        boolean r100 = r110.isEmpty();
        a r101 = f227813c;
        if (r100 == false) goto L7;
        r111.a(p(r110, "items is empty"));
        return r101;
    L7:
        if (r110.size() <= 50) goto L10;
        r111.a(p(r110, "items size is greater than 50"));
        return r101;
    L10:
        List<com.bytedance.ee.bear.list.delete.d> r102 = r110;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((com.bytedance.ee.bear.list.delete.d) r105).f227857c == false) goto L12;
        r103.add(r105);
        goto L12
    L16:
        ArrayList r112 = new ArrayList();
        Iterator<T> r106 = r102.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (((com.bytedance.ee.bear.list.delete.d) r107).f227857c == true) goto L18;
        r112.add(r107);
        goto L18
    L22:
        AtomicInteger r108 = new AtomicInteger((!r103.isEmpty() ? 1 : 0) + (!r112.isEmpty() ? 1 : 0));
        AtomicBoolean r113 = new AtomicBoolean(false);
        AtomicBoolean r114 = new AtomicBoolean(true);
        ConcurrentHashMap r115 = new ConcurrentHashMap();
        if ((!r103.isEmpty()) == false) goto L34;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r116 = r103.iterator();
    L26:
        if (r116.hasNext() == false) goto L28;
        r109.add(((com.bytedance.ee.bear.list.delete.d) r116.next()).f227855a);
        goto L26
    L28:
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r118 = r103.iterator();
    L30:
        if (r118.hasNext() == false) goto L32;
        r117.add(Integer.valueOf(((com.bytedance.ee.bear.list.delete.d) r118.next()).f227856b));
        goto L30
    L32:
        delete(r109, r117, new h(r113, r114, r115, this, r108, r111));
    L34:
        if ((!r112.isEmpty()) == false) goto L48;
        nc5.a r119 = new i(r113, this, r108, r114, r115, r111);
        if (r112.isEmpty() == false) goto L49;
        r119.onFailure(new IllegalArgumentException("items is empty"));
        goto L48
    L49:
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L44
        JSONArray r121 = new JSONArray();     // Catch: Exception -> L44
        Iterator r122 = r112.iterator();     // Catch: Exception -> L44
    L40:
        if (r122.hasNext() == false) goto L42;
        com.bytedance.ee.bear.list.delete.d r123 = (com.bytedance.ee.bear.list.delete.d) r122.next();     // Catch: Exception -> L44
        JSONObject r124 = new JSONObject();     // Catch: Exception -> L44
        r124.put("obj_token", r123.f227855a);     // Catch: Exception -> L44
        r124.put("obj_type", String.valueOf(r123.f227856b));     // Catch: Exception -> L44
        r121.put(r124);     // Catch: Exception -> L44
        goto L40
    L42:
        r120.put("entities", r121);     // Catch: Exception -> L44
        String r125 = r120.toString();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r125);     // Catch: Exception -> L44
    L46:
        l(com.bytedance.ee.bear.list.e.j("/api/explorer/v2/recent/delete/", r125), r119);
    L44:
        e = move-exception;
        tt5.a.e(this.f227814b, "buildDeleteRecentParams error", e, false);
        r125 = "";
    L48:
        return new j(r113);
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b c(final List r100, final nc5.c r101) {
        Intrinsics.checkNotNullParameter(r100, "tokenList");
        Intrinsics.checkNotNullParameter(r101, "callback");
        tt5.a.h(this.f227814b, "deleteByObjTokens, tokenList size: " + r100.size() + ", apply: 1");
        if (r100.isEmpty() == false) goto L16;
        r101.a(new com.bytedance.ee.bear.list.delete.e(false, MapsKt.emptyMap()));
        return f227813c;
    L16:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L12
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L12
        Iterator r104 = r100.iterator();     // Catch: Exception -> L12
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.put((String) r104.next());     // Catch: Exception -> L12
        goto L8
    L10:
        r102.put("tokens", r103);     // Catch: Exception -> L12
        r102.put(e1.REPLY_ACTION_APPLY, 1);     // Catch: Exception -> L12
        String r105 = r102.toString();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L12
    L15:
        return q(com.bytedance.ee.bear.list.e.j("/space/api/explorer/v3/remove/", r105), new DeleteExecutor$deleteByObjTokens$1(this, r101), new DeleteExecutor$deleteByObjTokens$2(this, r100, r101));
    L12:
        e = move-exception;
        tt5.a.e(this.f227814b, "buildDeleteMultiTokensParams error", e, false);
        r105 = "";
        goto L15
    }

    public final com.bytedance.ee.bear.list.delete.e p(List<com.bytedance.ee.bear.list.delete.d> r100, String r101) {
        tt5.a.d(this.f227814b, "buildDeleteItemsErrorResult, size=" + r100.size() + ", message=" + r101);
        List<com.bytedance.ee.bear.list.delete.d> r102 = r100;
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        Pair r105 = TuplesKt.to(((com.bytedance.ee.bear.list.delete.d) r104.next()).f227855a, -1);
        r103.put(r105.getFirst(), r105.getSecond());
        goto L4
    L7:
        return new com.bytedance.ee.bear.list.delete.e(false, r103);
    }

    private final nc5.b delete(List<String> r100, List<Integer> r110, final nc5.a<c> r111) {
        tt5.a.h(this.f227814b, "delete, tokens: " + du5.b.k(r100.toString()) + ", types: " + r110);
        if (r100.isEmpty() == false) goto L5;
    L27:
        r111.onFailure(new IllegalArgumentException("invalid tokens/types size"));
        return f227813c;
    L5:
        if (r110.isEmpty() == true) goto L27;
        if (r100.size() != r110.size()) goto L27;
        if (r100.size() == r110.size()) goto L29;
        tt5.a.d(this.f227814b, "buildDeleteParams size mismatch, tokens=" + r100.size() + ", types=" + r110.size());
    L24:
        String r101 = "";
    L26:
        return q(com.bytedance.ee.bear.list.e.j("/space/api/explorer/v2/m_del_node/", r101), new AnonymousClass1(this, r111), new AnonymousClass2(r111));
    L29:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L22
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L22
        Iterator<T> r104 = r100.iterator();     // Catch: Exception -> L22
        int r105 = 0;
    L15:
        if (r104.hasNext() == false) goto L20;
        Object r106 = r104.next();     // Catch: Exception -> L22
        int r107 = r105 + 1;     // Catch: Exception -> L22
        if (r105 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L22
    L19:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L22
        r108.put("obj_token", (String) r106);     // Catch: Exception -> L22
        r108.put("obj_type", ((Number) ListProtector.get(r110, r105)).intValue());     // Catch: Exception -> L22
        r103.put(r108);     // Catch: Exception -> L22
        r105 = r107;
        goto L15
    L20:
        r102.put("objs", r103);     // Catch: Exception -> L22
        r101 = r102.toString();     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        tt5.a.e(this.f227814b, "buildDeleteParams error", e, false);
        goto L24
    }

    @Override // com.bytedance.ee.bear.list.delete.f
    public final nc5.b e(String r100, int r101, nc5.a<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.h(this.f227814b, "deleteByObjToken, objToken: " + du5.b.k(r100) + ", objType: " + r101);
        return delete(CollectionsKt.listOf(r100), CollectionsKt.listOf(Integer.valueOf(r101)), new g(r102));
    }

    public final com.bytedance.ee.bear.list.delete.a q(NetService.f r100, Function2 r101, Function1 r102) {
        NetService.d r103 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e());
        io.reactivex.disposables.a r104 = new io.reactivex.disposables.a();
        return new com.bytedance.ee.bear.list.delete.a(this, r103.a(r100).subscribe(new com.bytedance.ee.bear.list.delete.b(this, r101, r104, r102), new com.bytedance.ee.bear.list.delete.c(this, r102)), r104);
    }

    public static final void o(DeleteExecutor r100, AtomicInteger r101, AtomicBoolean r102, AtomicBoolean r103, Map r104, nc5.c r105) {
        r100.getClass();
        if (r101.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (r102.get() == true) goto L9;
        r105.a(new com.bytedance.ee.bear.list.delete.e(r103.get(), MapsKt.toMap(r104)));
        return;
    }

    public final void r(String r110, int r111, long r112, io.reactivex.disposables.a r113, String r210, Function1<? super DeleteTaskStatusResult, Unit> r211, Function1<? super Throwable, Unit> r212) {
        long r100 = (r111 * 500) + 1000;
        long r101 = 30000 - (SystemClock.elapsedRealtime() - r112);
        long r102 = 0;
        if (r101 <= 0) goto L5;
        r102 = Math.min(r100, r101);
    L5:
        tt5.a.h(this.f227814b, "pollAsyncTaskStatus, path: " + r210 + ", taskId: " + r110 + ", times: " + r111 + ", delay: " + r102);
        r113.b(Observable.timer(r102, TimeUnit.MILLISECONDS).flatMap(new k(r112, this, r210, r110)).subscribe(new l(this, r210, r110, r111, r112, r113, r211, r212), new m(this, r210, r212)));
    }
}
