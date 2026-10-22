package com.ss.android.lark.compose.util;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f417745a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f417746a = null;

        static {
            int[] r100 = new int[Chat.Type.values().length];
            r100[Chat.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Chat.Type.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f417746a = r100;
        }
    }

    static {
    }

    public static void a(String r100, String r101, String r102) {
        Map<String, Object> r103 = ChatParamUtils.e();
        if (r103 != null) goto L5;
        return;
    L5:
        JSONObject r104 = new JSONObject(r103).put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101);
        if (r102 == null) goto L8;
        r104.put("status", r102);
    L8:
        Statistics.sendEvent("im_chat_setting_click", r104);
    }

    public static void b(String r100, Chat.Type r101, boolean r102) {
        if (r101 != null) goto L4;
        int r103 = -1;
    L6:
        if (r103 != 1) goto L8;
        Pair r104 = TuplesKt.to("group_chat_setting", "group");
    L12:
        String r105 = (String) r104.component1();
        String r106 = (String) r104.component2();
        JSONObject r107 = new JSONObject().put("current_page", r105).put("chat_type", r106);
        if (r102 == false) goto L15;
        String r108 = "on";
    L16:
        Statistics.sendEvent(r100, r107.put("to_status", r108));
        return;
    L15:
        r108 = "off";
        goto L16
    L8:
        if (r103 == 2) goto L10;
        return;
    L10:
        r104 = TuplesKt.to("single_chat_setting", "real_people");
        goto L12
    L4:
        r103 = a.f417746a[r101.ordinal()];
        goto L6
    }
}
