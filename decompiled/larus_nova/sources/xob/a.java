package xob;

import android.content.Context;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ContextsKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564691a = 0;

    static {
    }

    public static String a(Context r100) {
        if (KeyboardUtils.isSoftShowing(ContextsKt.requireActivity(r100)) == false) goto L8;
        return "keyboard_unfold";
    L8:
        return "keyboard_fold";
    L6:
        e = move-exception;
        Log.e("KeyboardAssemblerHitPointUtils", "Error while checking keyboard status: " + e.getMessage(), e);
        goto L8
    }

    public static void b(Pair... r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        int r102 = r100.length;     // Catch: Exception -> L14
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L6;
        Pair r104 = r100[r103];     // Catch: Exception -> L14
        r101.put((String) r104.getFirst(), r104.getSecond());     // Catch: Exception -> L14
        r103 = r103 + 1;     // Catch: Exception -> L14
        goto L4
    L6:
        Map<String, Object> r105 = ChatParamUtils.e();     // Catch: Exception -> L14
        if (r105 == null) goto L12;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r106.hasNext() == false) goto L12;
        Map.Entry<String, Object> r107 = r106.next();     // Catch: Exception -> L14
        r101.put(r107.getKey(), r107.getValue());     // Catch: Exception -> L14
    L12:
        Statistics.sendEvent("im_chat_main_click", r101);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e("KeyboardAssemblerHitPointUtils", "sendHitPoint / event: im_chat_main_click, error: " + e);
    }
}
