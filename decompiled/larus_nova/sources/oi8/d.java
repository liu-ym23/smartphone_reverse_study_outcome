package oi8;

import com.larus.platform.service.o;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f523447a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102, boolean r103) {
        o r104 = o.f365780a;
        JSONObject r105 = new JSONObject();
        r105.put("current_page", r100);
        r105.put("previous_page", r101);
        r105.put("bot_id", r102);
        r105.put("option_name", "expert");
        if (r103 == false) goto L5;
        String r106 = "on";
    L6:
        r105.put("option_selected", r106);
        Unit r107 = Unit.INSTANCE;
        r104.reportEvent("option_select", r105);
        return;
    L5:
        r106 = "off";
        goto L6
    }
}
