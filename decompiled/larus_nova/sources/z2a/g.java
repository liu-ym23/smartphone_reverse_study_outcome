package z2a;

import androidx.core.app.NotificationCompat;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569833a = 0;

    static {
    }

    public g() {
    }

    public static void a(String r100) {
        if (r100 != null) goto L5;
        FLogger.f375446a.w("RealtimeCallSpanManager", "endRootSpan failed, traceId is null");
        return;
    L5:
        vx9.b.f557496a.getClass();
        com.larus.trace.tracespan.span.b r101 = vx9.b.a(r100, NotificationCompat.CATEGORY_CALL);
        if (r101 == null) goto L13;
        List<com.larus.trace.tracespan.span.b> r102 = ((SpanWrapImpl) r101).k();
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        ((com.larus.trace.tracespan.span.b) r103.next()).cancel(true);
    L13:
        b(r100, NotificationCompat.CATEGORY_CALL, null, null);
    }

    public static com.larus.trace.tracespan.span.b c(String r100, String r101) {
        if (r100 == null) goto L5;
        vx9.b.f557496a.getClass();
        return vx9.b.a(r100, r101);
    L5:
        FLogger.f375446a.w("RealtimeCallSpanManager", "getSpanByTag failed, traceId=" + r100 + ", tagName=" + r101);
        return null;
    }

    public static wx9.a d(String r100, String r101) {
        if (r100 == null) goto L8;
        vx9.b.f557496a.getClass();
        com.larus.trace.tracespan.span.b r102 = vx9.b.a(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return xx9.a.a(r102);
    L8:
        FLogger.f375446a.w("RealtimeCallSpanManager", "getSpanContext failed, traceId=" + r100 + ", spanName=" + r101);
        return null;
    }

    public static com.larus.trace.tracespan.span.b e(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "spanScene");
        Intrinsics.checkNotNullParameter(r101, "spanCommonParams");
        vx9.b.a r102 = new vx9.b.a();
        Intrinsics.checkNotNullParameter(r100, "spanEventName");
        r102.f557505c = r100;
        Intrinsics.checkNotNullParameter(NotificationCompat.CATEGORY_CALL, "spanName");
        r102.f557503a = NotificationCompat.CATEGORY_CALL;
        Intrinsics.checkNotNullParameter(r100, "scene");
        r102.f557504b = r100;
        r102.f557506d = wx9.b.f561852c;
        com.larus.trace.tracespan.span.b r103 = r102.a();
        r103.setTag(NotificationCompat.CATEGORY_CALL);
        r103.b(r101);
        return r103;
    }

    public static void f(String r100, String r101, wx9.a r102) {
        Intrinsics.checkNotNullParameter(r100, "spanScene");
        Intrinsics.checkNotNullParameter(r101, "spanName");
        FLogger.f375446a.i("RealtimeCallSpanManager", "startSpan, spanName=" + r101);
        vx9.b.a r103 = new vx9.b.a();
        Intrinsics.checkNotNullParameter(r100, "spanEventName");
        r103.f557505c = r100;
        Intrinsics.checkNotNullParameter(r101, "spanName");
        r103.f557503a = r101;
        Intrinsics.checkNotNullParameter(r100, "scene");
        r103.f557504b = r100;
        if (r102 != null) goto L5;
        r102 = wx9.b.f561852c;
    L5:
        r103.f557506d = r102;
        r103.a().setTag(r101);
    }

    public static void b(String r100, String r101, Integer r102, String r103) {
        if (r100 == null) goto L12;
        vx9.b.f557496a.getClass();
        com.larus.trace.tracespan.span.b r104 = vx9.b.a(r100, r101);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("endSpan, spanName=");
        r106.append(r101);
        r106.append(", isSpanExist=");
        if (r104 == null) goto L7;
        boolean r107 = true;
    L8:
        r106.append(r107);
        r105.i("RealtimeCallSpanManager", r106.toString());
        if (r104 == null) goto L14;
        ((SpanWrapImpl) r104).g(r102, r103);
        return;
    L14:
        return;
    L7:
        r107 = false;
        goto L8
    L12:
        FLogger.f375446a.w("RealtimeCallSpanManager", "endSpan failed, traceId=" + r100 + ", spanName=" + r101);
    }
}
