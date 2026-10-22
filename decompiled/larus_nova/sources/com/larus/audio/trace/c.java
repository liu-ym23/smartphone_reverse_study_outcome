package com.larus.audio.trace;

import androidx.collection.LruCache;
import com.larus.audio.v0;
import com.larus.platform.service.z2;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f289815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, com.larus.trace.tracespan.span.b> f289816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, String> f289817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, String> f289818d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f289819e;

    public c() {
    }

    static {
        f289815a = new c();
        f289816b = new LruCache(10);
        f289817c = new LruCache(10);
        f289818d = new LruCache(10);
    }

    public static boolean j() {
        return z2.f365865a.disableAudioTraceSpan();
    }

    @Override // com.larus.audio.v0
    public final String f() {
        return f289819e;
    }

    public static com.larus.trace.tracespan.span.b k(String r100) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getRootSpan disableAudioTraceSpan");
        return null;
    L6:
        if (r100 != null) goto L9;
        return null;
    L9:
        return f289816b.get(r100);
    }

    public static String l(String r100) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getTraceSpanHeader disableAudioTraceSpan");
        return null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        com.larus.trace.tracespan.span.b r101 = f289816b.get(r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        String r102 = r101.f();
        JSONObject r103 = new JSONObject();
        r103.put("span_header", r102);
        return r103.toString();
    }

    @Override // com.larus.audio.v0
    public final String b(String r100) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getLocalSendMsgId disableAudioTraceSpan");
        return null;
    L6:
        if (r100 != null) goto L9;
        return null;
    L9:
        return f289817c.get(r100);
    }

    @Override // com.larus.audio.v0
    public final String c(String r100) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getLocalSendMsgIdFromSend disableAudioTraceSpan");
        return null;
    L6:
        if (r100 != null) goto L9;
        return null;
    L9:
        return f289818d.get(r100);
    }

    @Override // com.larus.audio.v0
    public final void e(String r100) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "updateOnlyNewestSendLocalMsgId disableAudioTraceSpan");
        return;
    L6:
        int r101 = c68.b.f22600a;
        c68.b.d("AudioTraceSpanManager", "updateOnlyNewestSendLocalMsgId sendLocalMsgId=".concat(r100));
        f289819e = r100;
    }

    @Override // com.larus.audio.v0
    public final com.larus.trace.tracespan.span.b a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "commonParams");
        if (j() == false) goto L7;
        c68.b.d("AudioTraceSpanManager", "startRootSpan disableAudioTraceSpan");
        return null;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        FLogger.f375446a.w("AudioTraceSpanManager", "startRootSpan localMsgId=".concat(r100));
        LruCache<String, com.larus.trace.tracespan.span.b> r103 = f289816b;
        com.larus.trace.tracespan.span.b r104 = r103.get(r100);
        if (r104 != null) goto L15;
        vx9.b.a r105 = new vx9.b.a();
        r105.f557507e = 600000;
        Intrinsics.checkNotNullParameter("audio_message", "spanEventName");
        r105.f557505c = "audio_message";
        Intrinsics.checkNotNullParameter("audio_message", "spanName");
        r105.f557503a = "audio_message";
        Intrinsics.checkNotNullParameter("audio_message", "scene");
        r105.f557504b = "audio_message";
        r104 = r105.a();
        r104.setTag("audio_message");
        r103.put(r100, r104);
    L15:
        r104.b(r101);
        return r104;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.larus.audio.v0
    public final void d(String r100, String r101) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "addSendMsgIdToLocalSendMsgIdPair disableAudioTraceSpan");
        return;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        int r102 = c68.b.f22600a;
        c68.b.d("AudioTraceSpanManager", "addSendMsgIdToLocalSendMsgIdPair sendMsgId=" + r100 + " localSendMsgId=" + r101);
        LruCache<String, String> r103 = f289818d;
        String r104 = r103.get(r100);
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L20;
        r103.put(r100, r101);
        return;
    L20:
        return;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
        goto L17
    }

    @Override // com.larus.audio.v0
    public final void g(String r100, String r101) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "addRecToSendLocalMsgIdPair disableAudioTraceSpan");
        return;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        LruCache<String, String> r102 = f289817c;
        if (r102.get(r100) != null) goto L14;
        r102.put(r100, r101);
        return;
    }

    public static void m(String r100, wx9.a r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "startAudioMessageSpan disableAudioTraceSpan");
        return;
    L6:
        FLogger r103 = FLogger.f375446a;
        r103.i("AudioTraceSpanManager", "startAudioMessageSpan, spanName=" + r100);
        if (j() == false) goto L9;
        c68.b.d("AudioTraceSpanManager", "startSpan disableAudioTraceSpan");
        return;
    L9:
        r103.i("AudioTraceSpanManager", "startSpan, spanEventName=audio_message spanName=" + r100 + " spanScene=audio_message");
        if (r100 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L22;
        vx9.b.a r105 = new vx9.b.a();
        Intrinsics.checkNotNullParameter("audio_message", "spanEventName");
        r105.f557505c = "audio_message";
        Intrinsics.checkNotNullParameter(r100, "spanName");
        r105.f557503a = r100;
        Intrinsics.checkNotNullParameter("audio_message", "scene");
        r105.f557504b = "audio_message";
        r105.f557506d = r101;
        com.larus.trace.tracespan.span.b r106 = r105.a();
        r106.setTag(r100);
        if (r102 == null) goto L23;
        r106.b(r102);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r100.length() == 0) goto L15;
        r104 = false;
        goto L16
    }

    public static void h(String r100, Integer r101, String r102, String r110) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "endRootSpan disableAudioTraceSpan");
        return;
    L6:
        if (r100 != null) goto L9;
        FLogger.f375446a.w("AudioTraceSpanManager", "endRootSpan failed, localMessageId is null");
        return;
    L9:
        com.larus.trace.tracespan.span.b r103 = f289816b.get(r100);
        if (r103 != null) goto L13;
        FLogger.f375446a.w("AudioTraceSpanManager", "endRootSpan failed, rootSpan is null");
        return;
    L13:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("endRootSpan localMsgId:");
        r105.append(r100);
        r105.append(" span:");
        StringBuilder r106 = new StringBuilder("traceId=");
        r106.append(r103.getTraceId());
        r106.append(", parentSpanId=");
        com.larus.trace.tracespan.span.b r107 = r103.getParent();
        if (r107 == null) goto L16;
        String r108 = r107.a();
    L17:
        r106.append(r108);
        r106.append(", spanId=");
        r106.append(r103.a());
        r105.append(r106.toString());
        r104.i("AudioTraceSpanManager", r105.toString());
        vx9.b r109 = vx9.b.f557496a;
        String r111 = r103.getTraceId();
        r109.getClass();
        com.larus.trace.tracespan.span.b r112 = vx9.b.a(r111, "audio_message");
        if (r112 == null) goto L25;
        List<com.larus.trace.tracespan.span.b> r113 = ((SpanWrapImpl) r112).k();
        if (r113 == null) goto L25;
        Iterator<T> r114 = r113.iterator();
    L23:
        if (r114.hasNext() == false) goto L25;
        com.larus.trace.tracespan.span.b r115 = (com.larus.trace.tracespan.span.b) r114.next();
        FLogger.f375446a.i("AudioTraceSpanManager", "endRootSpan cancel spanName=" + r115.getTag() + '}');
        r115.cancel(true);
    L25:
        if (r110 == null) goto L27;
        r103.d("error_ext_msg", r110);
    L27:
        r103.g(r101, r102);
        f289816b.remove(r100);
        return;
    L16:
        r108 = null;
        goto L17
    }

    public static void i(String r100, String r101, Integer r102, String r103, JSONObject r104) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "endSpan disableAudioTraceSpan");
        return;
    L6:
        boolean r105 = true;
        if (r100 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L34;
        if (r101 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == true) goto L34;
        vx9.b.f557496a.getClass();
        com.larus.trace.tracespan.span.b r108 = vx9.b.a(r100, r101);
        if (r104 == null) goto L26;
        if (r108 == null) goto L26;
        ((SpanWrapImpl) r108).b(r104);
    L26:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("endSpan, spanName=");
        r110.append(r101);
        r110.append(", isSpanExist=");
        if (r108 != null) goto L30;
        r105 = false;
    L30:
        r110.append(r105);
        r109.i("AudioTraceSpanManager", r110.toString());
        if (r108 == null) goto L36;
        ((SpanWrapImpl) r108).g(r102, r103);
        return;
    L36:
        return;
    L16:
        if (r101.length() == 0) goto L19;
        r107 = false;
    L34:
        FLogger.f375446a.w("AudioTraceSpanManager", "endSpan failed, traceId=" + r100 + ", spanName=" + r101);
        return;
    L9:
        if (r100.length() == 0) goto L12;
        r106 = false;
        goto L13
    }
}
