package pl1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f529750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f529751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static DataCenter f529752c;

    static {
        f529751b = "unknown";
    }

    @JvmStatic
    public static final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$logDialogBaseParam");
        r100.put("source", String.valueOf(f529750a));
        r100.put("vs_scene_source", f529751b);
        DataCenter r101 = f529752c;
        if (r101 == null) goto L6;
        String r102 = (String) r101.get("VSEventPage");
        if (r102 == null) goto L6;
    L7:
        r100.put("vs_event_page", r102);
        DataCenter r103 = f529752c;
        if (r103 == null) goto L11;
        String r104 = (String) r103.get("VSReplyClickPosition");
        if (r104 == null) goto L11;
    L12:
        r100.put("vs_reply_click_position", r104);
        r100.put("to_comment_id", "");
        if (TextUtils.isEmpty(null) == false) goto L15;
        String r105 = "0";
    L16:
        r100.put("vs_is_comment_reply", r105);
        return;
    L15:
        r105 = "1";
    L11:
        r104 = "";
    L6:
        r102 = "";
        goto L7
    }

    public static void b(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tabName");
        Intrinsics.checkNotNullParameter(r102, "enterType");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("vs_tab_name", r101);
        r103.put("vs_enter_tab_type", r102);
        a(r103);
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("input_comment_emoji_sub_panel_show", "eventName");
        Intrinsics.checkNotNullParameter(r103, "param");
        if (r100 == null) goto L6;
        d.a(r100).e("input_comment_emoji_sub_panel_show", r103, new Object[0]);
        return;
    }
}
