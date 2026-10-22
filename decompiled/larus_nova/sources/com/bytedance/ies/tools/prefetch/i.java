package com.bytedance.ies.tools.prefetch;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface i {

    public interface a {
        void a(Throwable r100);

        void b(b r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f248820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f248821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f248822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f248823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f248824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f248825f;

        public final String a() {
            String r100 = this.f248821b;
            if (r100 != null) goto L11;
            byte[] r101 = this.f248820a;
            if (r101 == null) goto L8;
            String r102 = new String(r101, Charsets.UTF_8);
            this.f248821b = r102;
            return r102;
        L8:
            return null;
        L11:
            return r100;
        }

        @Deprecated(message = "Please build your json as you want.")
        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            String r102 = a();     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
            JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L9
        L7:
            r100.put(TemplateNodeType.RAW, r103);     // Catch: Throwable -> L9
            r100.put("headers", g0.c(this.f248822c));     // Catch: Throwable -> L9
            r100.put("cached", this.f248825f);     // Catch: Throwable -> L9
            Object r104 = Result.m9449constructorimpl(r100.put("status_code", this.f248823d));     // Catch: Throwable -> L9
        L11:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L14;
            p.f248826a.b(r105);
        L14:
            return r100;
        L6:
            r103 = new JSONObject();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public b() {
            this.f248823d = -1;
            this.f248825f = PrefetchProcess.HitState.FALLBACK.ordinal();
        }
    }

    void a(String r100, Map r101, Map r102, ProcessManager.b r103);

    void b(String r100, Map r101, String r102, JSONObject r103, Map r104, ProcessManager.b r105);
}
