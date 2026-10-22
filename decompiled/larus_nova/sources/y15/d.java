package y15;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, e> f565642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f565643b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f565644c = null;

    static {
        HashMap r100 = new HashMap();
        f565642a = r100;
        f565643b = new HashMap();
        HashMap r101 = new HashMap();
        f565644c = r101;
        Integer r102 = Integer.valueOf(R.drawable.ud_icon_share_outlined);
        Integer r103 = Integer.valueOf(R.color.facade_selector_icon_n1);
        d("SHARE", r102, r103);
        d("MORE_OPERATE", Integer.valueOf(R.drawable.ud_icon_more_outlined), r103);
        d("MESSAGE", Integer.valueOf(R.drawable.ud_icon_bell_outlined), r103);
        d("SCREEN_ORIENTATION_OPERATE", Integer.valueOf(R.drawable.ud_icon_landscape_mode_colorful), r103);
        d("UNDO", Integer.valueOf(R.drawable.ud_icon_undo_outlined), r103);
        d("REDO", Integer.valueOf(R.drawable.ud_icon_redo_outlined), r103);
        d("HISTORY_RECORD", Integer.valueOf(R.drawable.ud_icon_history_outlined), r103);
        d("SEARCH", Integer.valueOf(R.drawable.icon_tool_findandreplace_nor), r103);
        d("SECRET", Integer.valueOf(R.drawable.ud_icon_safe_settings_outlined), r103);
        d("VC_SHARE", Integer.valueOf(R.drawable.ud_icon_share_screen_outlined), r103);
        d("BACK", Integer.valueOf(R.drawable.ud_icon_left_outlined), r103);
        d("FORWARD", Integer.valueOf(R.drawable.ud_icon_forward_outlined), r103);
        d("COPY", Integer.valueOf(R.drawable.ud_icon_copy_outlined), r103);
        d("SYNCED_BLOCK_REFERENCES", Integer.valueOf(R.drawable.ud_icon_link_record_outlined), r103);
        d("FEEDBACK", Integer.valueOf(R.drawable.ud_icon_edit_discription_outlined), r103);
        d("SEND_TO_CHAT", Integer.valueOf(R.drawable.ud_icon_send_filled), Integer.valueOf(R.color.primary_pri_500));
        d("COMMENT", Integer.valueOf(R.drawable.ud_icon_add_comment_outlined), Integer.valueOf(R.color.facade_icon_n1_pri_500_color_selector));
        r101.put("PUBLISH_ANNOUNCEMENT", Integer.valueOf(R.string.Doc_Lark_PublishChannelAnnouncement));
        r100.put("CREATION_AI_ANIMATION", new e(0, 0, Integer.valueOf(R.raw.creation_ai_thinking_anim).intValue()));
    }

    public static String a(String r100) {
        Iterator r101 = ((HashMap) f565643b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        String r104 = (String) r102.getValue();
        if (r103.equals(r100) == true) goto L7;
        if (r104.equals(r100) == false) goto L4;
        return r103;
    L7:
        return r104;
    L11:
        return null;
    }

    public static e c(String r100) {
        return (e) ((HashMap) f565642a).get(r100);
    }

    public static Drawable b(Context r100, String r101) {
        if ("DOUBAO_AI".equals(r101) == true) goto L24;
        e r102 = (e) ((HashMap) f565642a).get(r101);
        if (r102 != null) goto L17;
        return null;
    L17:
        if (r102.a() == false) goto L31;
        int r103 = r102.f565646b;
        if (r103 != 0) goto L23;
        return AppCompatResources.getDrawable(r100, r102.f565645a);
    L23:
        return l.a(r100, r102.f565645a, r103);
    L31:
        return null;
    L24:
        com.bytedance.ee.bear.document.knowledgeai.a r104 = (com.bytedance.ee.bear.document.knowledgeai.a) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L11
        if (r104 != null) goto L7;
        return null;
    L7:
        if (r104.d() != DocsKnowledgeAIType.FLOW_AI) goto L27;
        return r104.b(r100, n.e(r100, 20.0f));
    L27:
        return null;
    L11:
        th = move-exception;
        tt5.a.d("MenuConfigs", "resolve DOUBAO_AI drawable fail: " + th.getMessage());
        return null;
    }

    public static void d(String r100, Integer r101, Integer r102) {
        e r103 = new e(r101.intValue(), r102.intValue(), 0);
        ((HashMap) f565642a).put(r100, r103);
    }

    public static void e(String r100, int r101, int r102) {
        d(r100, Integer.valueOf(r101), Integer.valueOf(r102));
    }
}
