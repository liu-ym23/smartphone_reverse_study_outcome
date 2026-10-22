package com.suite.lark.component.logger.dynamic;

import android.os.SystemClock;
import com.bytedance.android.alog.Alog;
import com.ss.android.lark.log.Log;
import com.suite.component.logger.c;
import com.suite.lark.component.logger.printer.MoltenV2Printer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pqb.e;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f460161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f460162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f460163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f460164d;

    /* JADX INFO: renamed from: com.suite.lark.component.logger.dynamic.a$a, reason: collision with other inner class name */
    public static final class C5518a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f460165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f460166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f460167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f460168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f460169e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f460170f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f460171g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f460172h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5518a) == true) goto L8;
            return false;
        L8:
            C5518a r101 = (C5518a) r100;
            if (Intrinsics.areEqual(this.f460165a, r101.f460165a) == true) goto L12;
            return false;
        L12:
            if (this.f460166b == r101.f460166b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f460167c, r101.f460167c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f460168d, r101.f460168d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f460169e, r101.f460169e) == true) goto L24;
            return false;
        L24:
            if (this.f460170f == r101.f460170f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f460171g, r101.f460171g) == true) goto L30;
            return false;
        L30:
            if (this.f460172h == r101.f460172h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f460165a.hashCode() * 31;
            long r101 = this.f460166b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            String r103 = this.f460167c;
            int r104 = 0;
            if (r103 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r102 + r105) * 31;
            String r107 = this.f460168d;
            if (r107 != null) goto L9;
            int r108 = 0;
        L10:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f460169e;
            if (r110 != null) goto L13;
            int r111 = 0;
        L14:
            long r112 = this.f460170f;
            int r113 = (((r109 + r111) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            String r114 = this.f460171g;
            if (r114 == null) goto L19;
            r104 = r114.hashCode();
        L19:
            return ((r113 + r104) * 31) + this.f460172h;
        L13:
            r111 = r110.hashCode();
            goto L14
        L9:
            r108 = r107.hashCode();
            goto L10
        L5:
            r105 = r103.hashCode();
            goto L6
        }

        public final String toString() {
            return "LogEvent(type=" + this.f460165a + ", blockCount=" + this.f460166b + ", tag=" + this.f460167c + ", errorMsg=" + this.f460168d + ", reason=" + this.f460169e + ", averageCount=" + this.f460170f + ", maxTags=" + this.f460171g + ", msgLen=" + this.f460172h + ')';
        }

        public final String getType() {
            return this.f460165a;
        }

        public C5518a(String r100, String r101, long r102, String r103, int r110, int r111) {
            if ((r111 & 4) == 0) goto L6;
            r101 = null;
        L6:
            if ((r111 & 32) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r111 & 64) == 0) goto L12;
            r103 = null;
        L12:
            if ((r111 & 128) == 0) goto L14;
            r110 = 0;
        L14:
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f460165a = r100;
            this.f460166b = 0;
            this.f460167c = r101;
            this.f460168d = null;
            this.f460169e = null;
            this.f460170f = r102;
            this.f460171g = r103;
            this.f460172h = r110;
        }
    }

    public a(boolean r100) {
        this.f460161a = r100;
        this.f460162b = 7200000;
        this.f460164d = new ConcurrentHashMap();
    }

    public static void f(C5518a r100) {
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
        r101.put("type", r100.getType());     // Catch: Throwable -> L4
        r101.putOpt("tag", r100.f460167c);     // Catch: Throwable -> L4
        r101.putOpt("message", r100.f460168d);     // Catch: Throwable -> L4
        r101.putOpt("reason", r100.f460169e);     // Catch: Throwable -> L4
        r101.putOpt("av_count", Long.valueOf(r100.f460170f));     // Catch: Throwable -> L4
        r101.putOpt("max_tags", r100.f460171g);     // Catch: Throwable -> L4
        r101.putOpt("block_count", Long.valueOf(r100.f460166b));     // Catch: Throwable -> L4
        r101.putOpt("msg_len", Integer.valueOf(r100.f460172h));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("LogEventListener", "send event error", th);     // Catch: Throwable -> L7
        return;
    }

    public final boolean a(String r100, long r101) {
        long r102 = SystemClock.elapsedRealtime();
        ConcurrentHashMap<String, Long> r103 = this.f460164d;
        Long r104 = r103.get(r100);
        if (r104 != null) goto L8;
        r104 = Long.valueOf(r102);
        Long r105 = r103.putIfAbsent(r100, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        Long r106 = r104;
        if (r106 != null) goto L12;
    L13:
        Intrinsics.checkNotNull(r106);
        if ((r102 - r106.longValue()) >= r101) goto L17;
        return false;
    L17:
        return true;
    L12:
        if (r102 == r106.longValue()) goto L17;
        goto L13
    }

    public final void b(c r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "logEntity");
        String r102 = r101.getMessage();
        lnc.a.a(r100);
        if ((r101 instanceof MoltenV2Printer.MoltenV2PrintErrorException) == false) goto L17;
        if (a("print_error", this.f460162b) == false) goto L26;
        String r103 = "log print molten exception occurred: " + r102;
        Log.reportError("LogEventListener", r103, r101, Boolean.TRUE);
        e r104 = e.f530322a;
        if (r104 == null) goto L10;
        r104.e("LogEventListener", r103, r101);
    L10:
        if (this.f460161a == true) goto L12;
        return;
    L12:
        if (((MoltenV2Printer.MoltenV2PrintErrorException) r101).isLimit() == false) goto L15;
        return;
    L15:
        throw new IllegalStateException(r103, r101);
    L26:
        return;
    L17:
        if (a("proc_exception", this.f460162b) == false) goto L28;
        String r105 = "log process exception occurred: " + r102;
        Log.reportError("LogEventListener", r105, r101, Boolean.TRUE);
        e r106 = e.f530322a;
        if (r106 == null) goto L22;
        r106.e("LogEventListener", r105, r101);
    L22:
        if (this.f460161a == true) goto L25;
        return;
    L25:
        throw new IllegalStateException(r105, r101);
    }

    public final void c(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        if (a("msg_too_long", this.f460162b) == false) goto L6;
        f(new C5518a("msg_too_long", r110, 0, null, r111, 122));
        return;
    }

    public final void e(c r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "logEntity");
        if (e.f530322a == null) goto L11;
        int r100 = r110.f460115a.getValue();
        pqb.b.a r101 = pqb.b.f530315a;
        String r102 = pqb.b.a.a(r110.f460116b, r110.f460122h, Integer.valueOf(r110.f460123i));
        if (r102 != null) goto L7;
        r102 = r110.f460116b;
    L7:
        String r103 = r102;
        String r104 = r110.f460117c;
        long r105 = r110.f460125k;
        long r106 = r110.f460129o;
        Intrinsics.checkNotNullParameter(r103, "tag");
        int r107 = r100 - 2;
        Alog r108 = com.bytedance.android.alog.e.f38378a;
        if (r108 == null) goto L11;
        r108.o(r107, r103, r104, r105, r106);
    L11:
        if (r111 > Math.max(2000, this.f460163c)) goto L13;
        return;
    L13:
        if (a("log_block", this.f460162b) == false) goto L19;
        this.f460163c = r111;
        String r112 = "log pipeline has block, block count:" + r111;
        Log.reportError("LogEventListener", r112, null, Boolean.TRUE);
        e r113 = e.f530322a;
        if (r113 == null) goto L20;
        r113.e("LogEventListener", r112);
        return;
    L20:
        return;
    }

    public final void d(long r100, long r110, Map r111) {
        Intrinsics.checkNotNullParameter(r111, "countMap");
        List r112 = CollectionsKt.take(CollectionsKt.sortedWith(((LinkedHashMap) r111).entrySet(), new b()), 3);
        String r101 = "log too frequently in recently " + r100 + " ms, countPerSecond:" + r110 + ", maxTags:" + r112;
        com.suite.component.logger.api.b r113 = com.suite.component.logger.Log.f460087a;
        Intrinsics.checkNotNullParameter("LogEventListener", "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.suite.component.logger.Log.f460088b.w("LogEventListener", r101, null);
        if (a("over_frequency", this.f460162b) == false) goto L6;
        f(new C5518a("over_frequency", null, r110, r112.toString(), 0, 158));
        return;
    }
}
