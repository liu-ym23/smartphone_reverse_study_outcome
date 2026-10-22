package y15;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final Map<String, e> a = null;
    public static final Map<String, String> b = null;
    public static final Map<String, Integer> c = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        b = new HashMap();
        HashMap r1 = new HashMap();
        c = r1;
        d("SHARE", 2131255656, 2131101926);
        d("MORE_OPERATE", 2131255147, 2131101926);
        d("MESSAGE", 2131253828, 2131101926);
        d("SCREEN_ORIENTATION_OPERATE", 2131254972, 2131101926);
        d("UNDO", 2131256063, 2131101926);
        d("REDO", 2131255522, 2131101926);
        d("HISTORY_RECORD", 2131254879, 2131101926);
        d("SEARCH", 2131238081, 2131101926);
        d("SECRET", 2131255592, 2131101926);
        d("VC_SHARE", 2131255659, 2131101926);
        d("BACK", 2131254998, 2131101926);
        d("FORWARD", 2131254801, 2131101926);
        d("COPY", 2131254165, 2131101926);
        d("SYNCED_BLOCK_REFERENCES", 2131255015, 2131101926);
        d("FEEDBACK", 2131254283, 2131101926);
        d("SEND_TO_CHAT", 2131255631, 2131105568);
        d("COMMENT", 2131253538, 2131101924);
        r1.put("PUBLISH_ANNOUNCEMENT", 2131887867);
        Integer r2 = 2131820560;
        r0.put("CREATION_AI_ANIMATION", new e(0, 0, r2.intValue()));
    }

    public static String a(String r4) {
        Iterator r0 = ((HashMap) b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        String r3 = (String) r1.getValue();
        if (r2.equals(r4) == true) goto L7;
        if (r3.equals(r4) == false) goto L4;
        return r2;
    L7:
        return r3;
    L11:
        return null;
    }

    public static e c(String r1) {
        return (e) ((HashMap) a).get(r1);
    }

    public static Drawable b(Context r3, String r4) {
        if ("DOUBAO_AI".equals(r4) == true) goto L24;
        e r5 = (e) ((HashMap) a).get(r4);
        if (r5 != null) goto L17;
        return null;
    L17:
        if (r5.a() == false) goto L31;
        int r0 = r5.b;
        if (r0 != 0) goto L23;
        return AppCompatResources.getDrawable(r3, r5.a);
    L23:
        return l.a(r3, r5.a, r0);
    L31:
        return null;
    L24:
        com.bytedance.ee.bear.document.knowledgeai.a r6 = (com.bytedance.ee.bear.document.knowledgeai.a) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L11
        if (r6 != null) goto L7;
        return null;
    L7:
        if (r6.d() != DocsKnowledgeAIType.FLOW_AI) goto L27;
        return r6.b(r3, n.e(r3, 20.0f));
    L27:
        return null;
    L11:
        th = move-exception;
        tt5.a.d("MenuConfigs", "resolve DOUBAO_AI drawable fail: " + th.getMessage());
        return null;
    }

    public static void d(String r2, Integer r3, Integer r4) {
        e r0 = new e(r3.intValue(), r4.intValue(), 0);
        ((HashMap) a).put(r2, r0);
    }

    public static void e(String r0, int r1, int r2) {
        d(r0, Integer.valueOf(r1), Integer.valueOf(r2));
    }
}
