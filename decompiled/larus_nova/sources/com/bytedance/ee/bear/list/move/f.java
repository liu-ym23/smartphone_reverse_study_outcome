package com.bytedance.ee.bear.list.move;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends com.bytedance.ee.bear.list.e<SimpleRequestResult> implements com.bytedance.ee.bear.list.move.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f228853b;

    public static final class a {
    }

    public static final class b implements NetService.c<Result<MoveTaskCreateResult>> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<MoveTaskCreateResult> parse(String r100) {
            Result<MoveTaskCreateResult> r101 = new Result();
            if (r100 != null) goto L11;
        L10:
            return r101;
        L11:
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L8
            r101.code = r102.optInt("code");     // Catch: JSONException -> L8
            r101.msg = r102.optString("msg");     // Catch: JSONException -> L8
            JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L8
            if (r103 == null) goto L10;
            MoveTaskCreateResult r104 = new MoveTaskCreateResult();     // Catch: JSONException -> L8
            r104.setTaskId(r103.optString("task_id"));     // Catch: JSONException -> L8
            r104.setTaskType(r103.optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE));     // Catch: JSONException -> L8
            r101.data = r104;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("MoveTaskCreateResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class c implements NetService.c<Result<MoveTaskInfo>> {
        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<MoveTaskInfo> parse(String r100) {
            Result<MoveTaskInfo> r101 = new Result();
            if (r100 != null) goto L32;
        L31:
            return r101;
        L32:
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L29
            r101.code = r102.optInt("code");     // Catch: JSONException -> L29
            r101.msg = r102.optString("msg");     // Catch: JSONException -> L29
            JSONObject r103 = r102.optJSONObject("data");     // Catch: JSONException -> L29
            if (r103 == null) goto L31;
            MoveTaskInfo r104 = new MoveTaskInfo();     // Catch: JSONException -> L29
            r104.setTaskId(r103.optString("task_id"));     // Catch: JSONException -> L29
            r104.setTaskStatus(r103.optInt("task_status"));     // Catch: JSONException -> L29
            r104.setTaskType(r103.optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE));     // Catch: JSONException -> L29
            if (r103.has("obj_type") == false) goto L10;
            r104.setObjType(Integer.valueOf(r103.optInt("obj_type")));     // Catch: JSONException -> L29
        L10:
            String r105 = r103.optString("obj_token");     // Catch: JSONException -> L29
            Intrinsics.checkNotNull(r105);     // Catch: JSONException -> L29
            boolean r106 = true;
            if (r105.length() <= 0) goto L13;
            boolean r107 = true;
        L14:
            String r108 = null;
            if (r107 == true) goto L18;
            r105 = null;
        L18:
            r104.setObjToken(r105);     // Catch: JSONException -> L29
            if (r103.has("biz_type") == false) goto L21;
            r104.setBizType(Integer.valueOf(r103.optInt("biz_type")));     // Catch: JSONException -> L29
        L21:
            String r109 = r103.optString("node_token");     // Catch: JSONException -> L29
            Intrinsics.checkNotNull(r109);     // Catch: JSONException -> L29
            if (r109.length() > 0) goto L25;
            r106 = false;
        L25:
            if (r106 == false) goto L27;
            r108 = r109;
        L27:
            r104.setNodeToken(r108);     // Catch: JSONException -> L29
            r101.data = r104;     // Catch: JSONException -> L29
            goto L31
        L13:
            r107 = false;
        L29:
            e = move-exception;
            tt5.a.e("MoveTaskInfoParser", "parse error", e, false);
            goto L31
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f228854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nc5.a<Boolean> f228855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ io.reactivex.disposables.a f228856c;

        public d(f r100, nc5.a<Boolean> r101, io.reactivex.disposables.a r102) {
            this.f228854a = r100;
            this.f228855b = r101;
            this.f228856c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Result r111 = (Result) r110;
            if (r111.code == 0) goto L5;
            io.reactivex.disposables.a r100 = this.f228856c;
            nc5.a<Boolean> r101 = this.f228855b;
            NetService.ServerErrorException r102 = new NetService.ServerErrorException(r111.code, r111.msg, "", "");
            r100.dispose();
            r101.onFailure(r102);
            return;
        L5:
            MoveTaskCreateResult r112 = (MoveTaskCreateResult) r111.data;
            if (r112 != null) goto L8;
            io.reactivex.disposables.a r113 = this.f228856c;
            nc5.a<Boolean> r103 = this.f228855b;
            IllegalStateException r104 = new IllegalStateException("empty response data");
            r113.dispose();
            r103.onFailure(r104);
            return;
        L8:
            String r105 = r112.getTaskId();
            if (TextUtils.isEmpty(r105) == false) goto L11;
        L17:
            io.reactivex.disposables.a r114 = this.f228856c;
            nc5.a<Boolean> r106 = this.f228855b;
            r114.dispose();
            r106.onSuccess(Boolean.TRUE);
            return;
        L11:
            if (Intrinsics.areEqual(r105, "0") == true) goto L17;
            String r107 = r112.getTaskType();
            if (TextUtils.isEmpty(r107) == false) goto L16;
            io.reactivex.disposables.a r115 = this.f228856c;
            nc5.a<Boolean> r108 = this.f228855b;
            IllegalStateException r109 = new IllegalStateException("task_type is empty");
            r115.dispose();
            r108.onFailure(r109);
            return;
        L16:
            f.o(this.f228854a, r105, r107, 0, SystemClock.elapsedRealtime(), this.f228855b, this.f228856c);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f228857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ io.reactivex.disposables.a f228858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nc5.a<Boolean> f228859c;

        public e(f r100, io.reactivex.disposables.a r101, nc5.a<Boolean> r102) {
            this.f228857a = r100;
            this.f228858b = r101;
            this.f228859c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(this.f228857a.f228853b, "move  error:", r101, false);
            io.reactivex.disposables.a r102 = this.f228858b;
            nc5.a<Boolean> r103 = this.f228859c;
            Intrinsics.checkNotNull(r101);
            r102.dispose();
            r103.onFailure(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<SimpleRequestResult> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f());
    }

    public f() {
        this.f228853b = "MoveExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.f228853b;
    }

    @Override // com.bytedance.ee.bear.list.move.e
    public final void h(String r100, int r101, String r102, int r103, nc5.a<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, "srcObjToken");
        Intrinsics.checkNotNullParameter(r102, "destParentToken");
        Intrinsics.checkNotNullParameter(r104, "callback");
        tt5.a.h(this.f228853b, "move unified, srcObjToken=" + du5.b.k(r100) + ", srcObjType=" + r101 + ", destParentToken=" + du5.b.k(r102) + ", destParentObjType=" + r103);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r104.onFailure(new IllegalArgumentException("srcObjToken is empty"));
        return;
    L6:
        if (r101 < 0) goto L22;
        if (r103 < 0) goto L22;
        boolean r105 = false;
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L12
        r106.put("src_obj_token", r100);     // Catch: Exception -> L12
        r106.put("src_obj_type", r101);     // Catch: Exception -> L12
        r106.put("dest_parent_token", r102);     // Catch: Exception -> L12
        r106.put("dest_parent_obj_type", r103);     // Catch: Exception -> L12
        String r107 = r106.toString();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r107);     // Catch: Exception -> L12
    L15:
        if (r107.length() != 0) goto L17;
        r105 = true;
    L17:
        if (r105 == false) goto L20;
        r104.onFailure(new IllegalStateException("build json failed"));
        return;
    L20:
        NetService.f r108 = com.bytedance.ee.bear.list.e.j("/space/api/explorer/object/move/", r107);
        NetService.d r109 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b());
        io.reactivex.disposables.a r110 = new io.reactivex.disposables.a();
        r110.b(r109.a(r108).subscribe(new d(this, r104, r110), new e(this, r110, r104)));
        return;
    L12:
        e = move-exception;
        tt5.a.e(this.f228853b, "buildMoveUnifiedJson error", e, false);
        r107 = "";
    L22:
        r104.onFailure(new IllegalArgumentException("invalid objType"));
    }

    public static final void o(f r110, String r111, String r112, int r113, long r114, nc5.a r210, io.reactivex.disposables.a r211) {
        r110.getClass();
        long r100 = (r113 * 500) + 1000;
        long r101 = 30000 - (SystemClock.elapsedRealtime() - r114);
        long r102 = 0;
        if (r101 <= 0) goto L5;
        r102 = Math.min(r100, r101);
    L5:
        r211.b(Observable.timer(r102, TimeUnit.MILLISECONDS).flatMap(new g(r114, r111, r112)).subscribe(new h(r211, r210, r110, r111, r112, r113, r114), new i(r110, r111, r112, r113, r211, r210)));
    }
}
