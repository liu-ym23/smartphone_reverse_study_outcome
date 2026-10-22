package ko8;

import android.os.SystemClock;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f504536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f504537b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f504538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f504539b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f504538a == r101.f504538a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f504539b, r101.f504539b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f504538a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f504539b.hashCode();
        }

        public final String toString() {
            return "TraceRecord(startTime=" + this.f504538a + ", sendType=" + this.f504539b + ')';
        }

        public a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sendType");
            this.f504538a = r100;
            this.f504539b = r101;
        }
    }

    static {
        f504536a = new ConcurrentHashMap();
        f504537b = new ConcurrentHashMap();
    }

    public static void a(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L23;
        if (r101 != null) goto L12;
    L15:
        if (r102 == false) goto L18;
        return;
    L18:
        if (f504536a.containsKey(r100) == true) goto L21;
        FLogger.f375446a.i("CreationSendMessageTrace", "bind skipped, traceId not started, traceId=" + r100 + ", localMessageId=" + r101);
        return;
    L21:
        f504537b.put(r101, r100);
        FLogger.f375446a.i("CreationSendMessageTrace", "bind traceId=" + r100 + ", localMessageId=" + r101);
        return;
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L15
    L23:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static void b(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "localMessageIds");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        a(r100, (String) r102.next());
        goto L4
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "sendType");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        f504536a.put(r100, new a(SystemClock.elapsedRealtime(), r101));
        FLogger.f375446a.i("CreationSendMessageTrace", "start traceId=" + r100 + ", sendType=" + r101);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static void c(String r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "sendFuncChannel");
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, String> r103 = f504537b;
        String r104 = r103.remove(r100);
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.length() != 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L49;
        a r106 = f504536a.remove(r104);
        if (r106 == null) goto L50;
        Iterator<T> r107 = r103.entrySet().iterator();
    L25:
        if (r107.hasNext() == false) goto L29;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (Intrinsics.areEqual(r108.getValue(), r104) == false) goto L25;
        f504537b.remove(r108.getKey());
        goto L25
    L29:
        long r109 = SystemClock.elapsedRealtime() - r106.f504538a;
        if (0 <= r109) goto L32;
    L34:
        r101 = false;
    L36:
        if (r101 == true) goto L38;
        FLogger.f375446a.e("CreationSendMessageTrace", "invalid duration=" + r109 + ", traceId=" + r104);
        return;
    L38:
        JSONObject r112 = new JSONObject();
        r112.put(BindCardPayConfirmConstants.Key.TRACE_ID, r104);
        r112.put("duration", r109);
        r112.put("send_type", r106.f504539b);
        if (r100 != null) goto L41;
        r100 = "";
    L41:
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
        r112.put("content_type", r110);
        r112.put("send_func_channel", r111);
        FLogger.f375446a.i("CreationSendMessageTrace", "report creation_send_message_cost, params=" + r112);
        o.f365780a.reportEvent("creation_send_message_cost", r112);
        return;
    L32:
        if (r109 >= 600001) goto L34;
    L50:
        return;
    L49:
        return;
    L17:
        r105 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
