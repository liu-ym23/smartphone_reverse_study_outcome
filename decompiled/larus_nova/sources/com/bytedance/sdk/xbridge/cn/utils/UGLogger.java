package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
public final class UGLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f270252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270253b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f270254a;

        public a() {
            this.f270254a = new ArrayList();
        }

        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            List<b> r102 = this.f270254a;
            ArrayList r103 = (ArrayList) r102;
            r103.add(new b(r100, r101));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f270256b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f270255a, r101.f270255a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f270256b, r101.f270256b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f270255a.hashCode() * 31) + this.f270256b.hashCode();
        }

        public final String toString() {
            return "Stage(name=" + this.f270255a + ", sessionId=" + this.f270256b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            this.f270255a = r100;
            this.f270256b = r101;
        }
    }

    public static final class c {
        public c() {
        }

        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            HybridLogger r102 = HybridLogger.f246343a;
            if (HybridLogger.c(r100, r101, LogLevel.D) == false) goto L5;
            return;
        L5:
            ALog.d(r100, r101);
        }

        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            HybridLogger r102 = HybridLogger.f246343a;
            if (HybridLogger.c(r100, r101, LogLevel.E) == false) goto L5;
            return;
        L5:
            ALog.e(r100, r101);
        }

        public final void c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            HybridLogger r102 = HybridLogger.f246343a;
            if (HybridLogger.c(r100, r101, LogLevel.I) == false) goto L5;
            return;
        L5:
            ALog.i(r100, r101);
        }

        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            HybridLogger r102 = HybridLogger.f246343a;
            if (HybridLogger.c(r100, r101, LogLevel.W) == false) goto L5;
            return;
        L5:
            ALog.w(r100, r101);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f270257a;

        /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.utils.UGLogger$d$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
        final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            final /* synthetic */ a $ctx;
            final /* synthetic */ String $module;
            final /* synthetic */ String $msg;
            final /* synthetic */ Map<String, Object> $params;
            final /* synthetic */ String $tag;

            public AnonymousClass1(String r100, String r101, String r102, Map<String, ? extends Object> r103, a r104) {
                this.$tag = r100;
                this.$module = r101;
                this.$msg = r102;
                this.$params = r103;
                this.$ctx = r104;
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                c r100 = UGLogger.f270252a;
                String r101 = UGLogger.b(this.$tag, this.$module);
                String r102 = UGLogger.a(this.$msg, this.$params, this.$ctx);
                UGLogger.f270252a.a(r101, r102);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }

        public d(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f270257a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f270257a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public UGLogger() {
    }

    static {
        f270252a = new c();
        f270253b = LazyKt.lazy(UGLogger$logHandler$2.INSTANCE);
    }

    public static /* synthetic */ void d(String r100) {
        c("AnnieXLynxEngine", r100, null, null, null);
    }

    public static String b(String r100, String r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        if (StringsKt.isBlank(r101) == false) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102.append("_");
        r102.append(r101);
    L11:
        return r102.toString();
    L7:
        r103 = false;
        goto L8
    }

    public static final String a(String r100, Map r101, a r102) {
        boolean r103 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        if (r102 != null) goto L12;
        return r100;
    L12:
        StringBuffer r105 = new StringBuffer(r100);
        if (r101 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        r105.append("|xParam:");
        r105.append(new JSONObject(r101).toString());
    L21:
        if (r102 == null) goto L23;
        List<b> r107 = r102.f270254a;
    L24:
        if (r107 != null) goto L26;
    L27:
        r103 = true;
    L28:
        if (r103 == true) goto L39;
        JSONObject r108 = new JSONObject();
        if (r102 == null) goto L37;
        List<b> r109 = r102.f270254a;
        if (r109 == null) goto L37;
        Iterator r110 = ((ArrayList) r109).iterator();
    L35:
        if (r110.hasNext() == false) goto L37;
        b r111 = (b) r110.next();
        r108.put(r111.f270255a, r111.f270256b);
    L37:
        JSONObject r112 = new JSONObject();
        r112.put("stages", r108);
        r105.append("|xContext:");
        r105.append(r112.toString());
    L39:
        return r105.toString();
    L26:
        if (r107.isEmpty() == false) goto L28;
    L23:
        r107 = null;
        goto L24
    L15:
        if (r101.isEmpty() == true) goto L18;
        r106 = false;
        goto L19
    L5:
        if (r101.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static void c(final String r100, final String r101, final String r102, final Map r110, final a r111) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r103 = HybridLogger.f246343a;
        if (HybridLogger.c(b(r100, r102), r101, LogLevel.I) == false) goto L5;
        return;
    L5:
        id7.c r104 = id7.c.f489341a;
        if (id7.c.f489343c == false) goto L8;
        return;
    L8:
        Function0<Unit> r105 = new UGLogger$i$1(r100, r102, r101, r110, r111);
        ((Handler) f270253b.getValue()).post(new d(r105));
    }
}
