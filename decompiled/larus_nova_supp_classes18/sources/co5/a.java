package co5;

import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static List a(JSONArray r8) {
        if (r8 == null) goto L4;
        ArrayList r0 = new ArrayList();
        int r1 = r8.length();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        JSONObject r3 = r8.optJSONObject(r2);
        SceneTemplateData.Scene r4 = new SceneTemplateData.Scene();
        r4.obj_token = r3.optString(ResourceData.KEY_OBJ_TOKEN);
        r4.obj_type = r3.optInt("obj_type");
        r4.name = r3.optString("name");
        r4.cover_download_url = r3.optString("cover_download_url");
        JSONObject r5 = r3.optJSONObject("thumbnail_extra");
        if (r5 != null) goto L10;
        SceneTemplateData.Extra r6 = new SceneTemplateData.Extra();
    L11:
        r4.thumbnail_extra = r6;
        r4.display_type = r3.optInt("display_type");
        r0.add(r4);
        r2 = r2 + 1;
        goto L6
    L10:
        SceneTemplateData.Extra r7 = new SceneTemplateData.Extra();
        r7.decrypt_key = r5.optString("decrypt_key");
        r7.thumbnail = r5.optString("thumbnail");
        r7.type = r5.optInt(ResourceData.KEY_TYPE);
        r6 = r7;
        goto L11
    L12:
        return r0;
    L4:
        return new ArrayList();
    }
}
