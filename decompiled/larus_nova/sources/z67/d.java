package z67;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f570507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakHandler f570508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f570509c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f570510d;

    public static class a implements WeakHandler.IHandler {
        public a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.what == 2) goto L7;
            e r101 = null;
        L8:
            if (r101 == null) goto L11;
            ThreadPlus.submitRunnable(r101);
            return;
        L11:
            return;
        L7:
            r101 = new e();
            goto L8
        }
    }

    static {
        f570507a = new a();
        f570509c = new AtomicBoolean(false);
    }

    public static Handler a() {
        if (f570508b != null) goto L6;
        f570508b = new WeakHandler(Looper.getMainLooper(), f570507a);
    L6:
        return f570508b;
    }

    public static void b(int r100, long r101) {
        if (r100 == 201) goto L5;
        String r102 = "init success";
    L7:
        if (r100 != 0) goto L9;
        com.bytedance.push.utils.f.g("Monitor", "Push init error:".concat(r102));
    L10:
        JSONObject r103 = new JSONObject();
        r103.put("status", r100);     // Catch: JSONException -> L13
    L15:
        JSONObject r104 = new JSONObject();
        r104.put("delta", r101);     // Catch: JSONException -> L18
    L20:
        i.a("push_monitor_applog_timeout", r103, r104, null);
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L9:
        com.bytedance.push.utils.f.e("Monitor", "Push init error:".concat(r102));
        goto L10
    L5:
        r102 = "not invoke start() method/not invoke start() when 30s passed";
        goto L7
    }
}
