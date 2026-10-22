package z67;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.third.PushChannelHelper;
import com.ss.android.message.AppProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f570526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHandler f570527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, Boolean> f570528c = null;

    public static class a implements WeakHandler.IHandler {
        public a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.what != 1001) goto L15;
            String r101 = PushChannelHelper.inst(AppProvider.getApp()).getSenderNameById(((Integer) r100.obj).intValue()) + " register timeout";
            JSONObject r102 = new JSONObject();
            r102.put("status", 108);     // Catch: JSONException -> L9
            r102.put("pushType", r100.obj);     // Catch: JSONException -> L9
        L11:
            com.bytedance.push.utils.f.e("Monitor", "Push Sender Monitor:" + r101);
            i.a("push_monitor_register_result", r102, null, null);
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }
    }

    static {
        f570526a = new a();
        f570527b = new WeakHandler(Looper.getMainLooper(), f570526a);
        f570528c = new ConcurrentHashMap(2);
    }
}
