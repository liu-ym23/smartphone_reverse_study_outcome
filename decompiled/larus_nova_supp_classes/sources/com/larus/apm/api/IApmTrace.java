package com.larus.apm.api;

import android.util.EventsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p48.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/larus/apm/api/IApmTrace;", XmlPullParser.NO_NAMESPACE, "addPerfTag", XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IApmTrace {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/larus/apm/api/IApmTrace$Companion;", "Lcom/larus/apm/api/IApmTrace;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/apm/api/IApmTrace;", "impl$delegate", "Lkotlin/Lazy;", "addPerfTag", XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "ApmScene", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements IApmTrace {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IApmTrace> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new a());
        }

        public static IApmTrace h() {
            return c.getValue();
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void b() {
            Intrinsics.checkNotNullParameter("TYPEWRITER", "key");
            Intrinsics.checkNotNullParameter("STOP", "value");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void c(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.c(r2, r3);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.d(r2, r3);
            return;
        }

        @Override // com.larus.apm.api.IApmTrace
        public final void f(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "category");
            IApmTrace r0 = h();
            if (r0 == null) goto L6;
            r0.f(r2, r3, r4, r5);
            return;
        }
    }

    static {
        a = Companion.b;
    }

    void a(String r1, String r2);

    void b();

    void c(String r1, JSONObject r2);

    void d(String r1, String r2);

    void e(String r1);

    void f(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void g(String r1);
}
