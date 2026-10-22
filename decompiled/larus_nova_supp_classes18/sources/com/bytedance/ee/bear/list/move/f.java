package com.bytedance.ee.bear.list.move;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends com.bytedance.ee.bear.list.e<SimpleRequestResult> implements com.bytedance.ee.bear.list.move.e {
    public final String b;

    public static final class a {
    }

    public static final class b implements NetService.c<Result<MoveTaskCreateResult>> {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.list.move.MoveTaskCreateResult, java.io.Serializable] */
        public final Result<MoveTaskCreateResult> parse(String r5) {
            Result<MoveTaskCreateResult> r0 = new Result();
            if (r5 != null) goto L11;
        L10:
            return r0;
        L11:
            JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L8
            r0.code = r1.optInt("code");     // Catch: JSONException -> L8
            r0.msg = r1.optString("msg");     // Catch: JSONException -> L8
            JSONObject r6 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L8
            if (r6 == null) goto L10;
            ?? r2 = new MoveTaskCreateResult();     // Catch: JSONException -> L8
            r2.setTaskId(r6.optString("task_id"));     // Catch: JSONException -> L8
            r2.setTaskType(r6.optString("task_type"));     // Catch: JSONException -> L8
            r0.data = r2;     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            tt5.a.e("MoveTaskCreateResultParser", "parse error", e, false);
            goto L10
        }
    }

    public static final class c implements NetService.c<Result<MoveTaskInfo>> {
        public c() {
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.ee.bear.list.move.MoveTaskInfo, java.io.Serializable] */
        public final Result<MoveTaskInfo> parse(String r9) {
            Result<MoveTaskInfo> r2 = new Result();
            if (r9 != null) goto L32;
        L31:
            return r2;
        L32:
            JSONObject r4 = new JSONObject(r9);     // Catch: JSONException -> L29
            r2.code = r4.optInt("code");     // Catch: JSONException -> L29
            r2.msg = r4.optString("msg");     // Catch: JSONException -> L29
            JSONObject r10 = r4.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L29
            if (r10 == null) goto L31;
            ?? r5 = new MoveTaskInfo();     // Catch: JSONException -> L29
            r5.setTaskId(r10.optString("task_id"));     // Catch: JSONException -> L29
            r5.setTaskStatus(r10.optInt("task_status"));     // Catch: JSONException -> L29
            r5.setTaskType(r10.optString("task_type"));     // Catch: JSONException -> L29
            if (r10.has("obj_type") == false) goto L10;
            r5.setObjType(Integer.valueOf(r10.optInt("obj_type")));     // Catch: JSONException -> L29
        L10:
            String r1 = r10.optString(ResourceData.KEY_OBJ_TOKEN);     // Catch: JSONException -> L29
            Intrinsics.checkNotNull(r1);     // Catch: JSONException -> L29
            boolean r6 = true;
            if (r1.length() <= 0) goto L13;
            boolean r7 = true;
        L14:
            String r8 = null;
            if (r7 == true) goto L18;
            r1 = null;
        L18:
            r5.setObjToken(r1);     // Catch: JSONException -> L29
            if (r10.has("biz_type") == false) goto L21;
            r5.setBizType(Integer.valueOf(r10.optInt("biz_type")));     // Catch: JSONException -> L29
        L21:
            String r11 = r10.optString("node_token");     // Catch: JSONException -> L29
            Intrinsics.checkNotNull(r11);     // Catch: JSONException -> L29
            if (r11.length() > 0) goto L25;
            r6 = false;
        L25:
            if (r6 == false) goto L27;
            r8 = r11;
        L27:
            r5.setNodeToken(r8);     // Catch: JSONException -> L29
            r2.data = r5;     // Catch: JSONException -> L29
            goto L31
        L13:
            r7 = false;
        L29:
            e = move-exception;
            tt5.a.e("MoveTaskInfoParser", "parse error", e, false);
            goto L31
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ nc5.a<Boolean> b;
        public final /* synthetic */ io.reactivex.disposables.a c;

        public d(f r1, nc5.a<Boolean> r2, io.reactivex.disposables.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            Result r13 = (Result) r12;
            if (r13.code == 0) goto L5;
            io.reactivex.disposables.a r0 = this.c;
            nc5.a<Boolean> r1 = this.b;
            NetService.ServerErrorException r2 = new NetService.ServerErrorException(r13.code, r13.msg, "", "");
            r0.dispose();
            r1.onFailure(r2);
            return;
        L5:
            MoveTaskCreateResult r14 = (MoveTaskCreateResult) r13.data;
            if (r14 != null) goto L8;
            io.reactivex.disposables.a r15 = this.c;
            nc5.a<Boolean> r3 = this.b;
            IllegalStateException r4 = new IllegalStateException("empty response data");
            r15.dispose();
            r3.onFailure(r4);
            return;
        L8:
            String r5 = r14.getTaskId();
            if (TextUtils.isEmpty(r5) == false) goto L11;
        L17:
            io.reactivex.disposables.a r16 = this.c;
            nc5.a<Boolean> r6 = this.b;
            r16.dispose();
            r6.onSuccess(Boolean.TRUE);
            return;
        L11:
            if (Intrinsics.areEqual(r5, "0") == true) goto L17;
            String r7 = r14.getTaskType();
            if (TextUtils.isEmpty(r7) == false) goto L16;
            io.reactivex.disposables.a r17 = this.c;
            nc5.a<Boolean> r8 = this.b;
            IllegalStateException r9 = new IllegalStateException("task_type is empty");
            r17.dispose();
            r8.onFailure(r9);
            return;
        L16:
            f.o(this.a, r5, r7, 0, SystemClock.elapsedRealtime(), this.b, this.c);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ io.reactivex.disposables.a b;
        public final /* synthetic */ nc5.a<Boolean> c;

        public e(f r1, io.reactivex.disposables.a r2, nc5.a<Boolean> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(this.a.b, "move  error:", r5, false);
            io.reactivex.disposables.a r0 = this.b;
            nc5.a<Boolean> r1 = this.c;
            Intrinsics.checkNotNull(r5);
            r0.dispose();
            r1.onFailure(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<SimpleRequestResult> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f());
    }

    public f() {
        this.b = "MoveExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.move.e
    public final void h(String r4, int r5, String r6, int r7, nc5.a<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r4, "srcObjToken");
        Intrinsics.checkNotNullParameter(r6, "destParentToken");
        Intrinsics.checkNotNullParameter(r8, "callback");
        tt5.a.h(this.b, "move unified, srcObjToken=" + du5.b.k(r4) + ", srcObjType=" + r5 + ", destParentToken=" + du5.b.k(r6) + ", destParentObjType=" + r7);
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r8.onFailure(new IllegalArgumentException("srcObjToken is empty"));
        return;
    L6:
        if (r5 < 0) goto L22;
        if (r7 < 0) goto L22;
        boolean r0 = false;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L12
        r1.put("src_obj_token", r4);     // Catch: Exception -> L12
        r1.put("src_obj_type", r5);     // Catch: Exception -> L12
        r1.put("dest_parent_token", r6);     // Catch: Exception -> L12
        r1.put("dest_parent_obj_type", r7);     // Catch: Exception -> L12
        String r9 = r1.toString();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L12
    L15:
        if (r9.length() != 0) goto L17;
        r0 = true;
    L17:
        if (r0 == false) goto L20;
        r8.onFailure(new IllegalStateException("build json failed"));
        return;
    L20:
        NetService.f r10 = com.bytedance.ee.bear.list.e.j("/space/api/explorer/object/move/", r9);
        NetService.d r11 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b());
        io.reactivex.disposables.a r12 = new io.reactivex.disposables.a();
        r12.b(r11.a(r10).subscribe(new d(this, r8, r12), new e(this, r12, r8)));
        return;
    L12:
        e = move-exception;
        tt5.a.e(this.b, "buildMoveUnifiedJson error", e, false);
        r9 = "";
    L22:
        r8.onFailure(new IllegalArgumentException("invalid objType"));
    }

    public static final void o(f r14, String r15, String r16, int r17, long r18, nc5.a r20, io.reactivex.disposables.a r21) {
        r14.getClass();
        long r0 = (r17 * 500) + CCMLynxCardView.ViewType.BANNER;
        long r4 = 30000 - (SystemClock.elapsedRealtime() - r18);
        long r2 = 0;
        if (r4 <= 0) goto L5;
        r2 = Math.min(r0, r4);
    L5:
        r21.b(Observable.timer(r2, TimeUnit.MILLISECONDS).flatMap(new g(r18, r15, r16)).subscribe(new h(r21, r20, r14, r15, r16, r17, r18), new i(r14, r15, r16, r17, r21, r20)));
    }
}
