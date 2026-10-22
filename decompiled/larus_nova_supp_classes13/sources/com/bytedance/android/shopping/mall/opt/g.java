package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final long a;
    public JSONObject b;
    public final String c;
    public final String d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ g b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public b(long r1, g r3, boolean r4, int r5, int r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void a() {
            JSONObject r0 = new JSONObject();
            r0.putOpt("type", this.b.c);
            if (this.c == false) goto L5;
            String r1 = "success";
        L6:
            r0.putOpt("timing", r1);
            r0.putOpt("filedTiming", Integer.valueOf(this.d));
            r0.putOpt("failedReason", Integer.valueOf(this.e));
            r0.putOpt("pageName", this.b.d);
            r0.putOpt("startT", Long.valueOf(this.b.a));
            r0.putOpt("reportT", Long.valueOf(this.a));
            JSONObject r2 = this.b.b;
            if (r2 == null) goto L17;
            Iterator<String> r3 = r2.keys();
            if (r3 == null) goto L17;
        L11:
            if (r3.hasNext() == false) goto L17;
            String r4 = r3.next();
            JSONObject r5 = this.b.b;
            if (r5 == null) goto L15;
            Object r6 = r5.opt(r4);
        L16:
            r0.putOpt(r4, r6);
            goto L11
        L15:
            r6 = null;
        L17:
            Unit r7 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("mall_gyl_refresh", r0);
            return;
        L5:
            r1 = CheckLoginParam.KEY_FAILED;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ JSONObject b;

        public c(g r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            JSONObject r0 = new JSONObject();
            r0.putOpt("type", this.a.c);
            r0.putOpt("timing", this.a.c);
            r0.putOpt("pageName", this.a.d);
            r0.putOpt("startT", Long.valueOf(this.a.a));
            JSONObject r1 = this.b;
            if (r1 == null) goto L9;
            Iterator<String> r2 = r1.keys();
            if (r2 == null) goto L9;
        L7:
            if (r2.hasNext() == false) goto L9;
            String r3 = r2.next();
            r0.putOpt(r3, this.b.opt(r3));
        L9:
            Unit r4 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("mall_gyl_refresh", r0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b(JSONObject r3) {
        this.b = r3;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(ThreadPoolHelper.c().submit(new c(this, r3)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "pageName");
        this.c = r2;
        this.d = r3;
        this.a = System.currentTimeMillis();
    }

    public final void a(boolean r10, int r11, int r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L4
        Result.constructor-impl(ThreadPoolHelper.c().submit(new b(r2, this, r10, r11, r12)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
