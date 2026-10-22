package z99;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f571071a = 0;

    static {
    }

    public static void a(Map r100, JSONObject r101) {
        List r102 = CollectionsKt.listOf(new String[]{"bot_count", "chat_type", "chat_id"});
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r105 = r104.next();
        if (r101.has((String) r105) == true) goto L4;
        r103.add(r105);
        goto L4
    L9:
        if ((!r103.isEmpty()) == false) goto L17;
        FLogger.f375446a.w("FlowDocImChatMainClickTrace", "missing OfficeSDK chat params: " + r103 + ", sourceKeys=" + r100.keySet());
        return;
    }

    public static String b(Map r100, String... r101) {
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        Object r105 = r100.get(r101[r104]);
        if (r105 != null) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        String r106 = r105.toString();
        if (r106.length() <= 0) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L12;
        return r106;
    L12:
        return null;
    }
}
