package hd5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements NetService.c<SpaceMakeCopyToSpaceResult> {
        public b() {
        }

        public final Result parse(String r5) {
        L22:
            return null;
        L3:
            String r1 = "";
            if (r5 != null) goto L6;
            r5 = "";
        L6:
            JSONObject r6 = new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L22
            if (r6 == null) goto L10;
            String r0 = JSONObjectProtectorUtils.getString(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Exception -> L22
            if (r0 == null) goto L10;
        L11:
            if (r6 == null) goto L14;
            String r2 = JSONObjectProtectorUtils.getString(r6, ResourceData.KEY_TOKEN);     // Catch: Exception -> L22
            if (r2 == null) goto L14;
        L15:
            if (r6 == null) goto L20;
            String r7 = JSONObjectProtectorUtils.getString(r6, ResourceData.KEY_URL);     // Catch: Exception -> L22
            if (r7 == null) goto L20;
            r1 = r7;
        L20:
            SpaceMakeCopyToSpaceResult.Data r8 = new SpaceMakeCopyToSpaceResult.Data(r0, r2, r1);     // Catch: Exception -> L22
            SpaceMakeCopyToSpaceResult r3 = new SpaceMakeCopyToSpaceResult();     // Catch: Exception -> L22
            ((Result) r3).data = r8;     // Catch: Exception -> L22
            return r3;
        L14:
            r2 = "";
        L10:
            r0 = "";
            goto L11
        }
    }

    /* JADX INFO: renamed from: hd5.c$c, reason: collision with other inner class name */
    public static final class C0239c implements NetService.c<SpaceMakeCopyToSpaceResult> {
        public C0239c() {
        }

        public final Result parse(String r6) {
            String r2 = "";
            if (r6 != null) goto L7;
            r6 = "";
        L7:
            JSONObject r7 = new JSONObject(r6).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L38
            if (r7 == null) goto L10;
            JSONArray r1 = r7.optJSONArray("node_list");     // Catch: Exception -> L38
        L11:
            if (r1 == null) goto L13;
            String r3 = r1.optString(0);     // Catch: Exception -> L38
        L14:
            if (r7 == null) goto L18;
            JSONObject r8 = r7.optJSONObject("entities");     // Catch: Exception -> L38
            if (r8 == null) goto L18;
            JSONObject r9 = r8.optJSONObject("nodes");     // Catch: Exception -> L38
        L19:
            if (r9 == null) goto L21;
            JSONObject r10 = r9.optJSONObject(r3);     // Catch: Exception -> L38
        L22:
            if (r10 == null) goto L25;
            String r4 = r10.optString(ResourceData.KEY_OBJ_TOKEN);     // Catch: Exception -> L38
            if (r4 == null) goto L25;
        L26:
            if (r10 == null) goto L29;
            String r5 = r10.optString(ResourceData.KEY_TOKEN);     // Catch: Exception -> L38
            if (r5 == null) goto L29;
        L30:
            if (r10 == null) goto L35;
            String r11 = r10.optString(ResourceData.KEY_URL);     // Catch: Exception -> L38
            if (r11 == null) goto L35;
            r2 = r11;
        L35:
            SpaceMakeCopyToSpaceResult r12 = new SpaceMakeCopyToSpaceResult();     // Catch: Exception -> L38
            ((Result) r12).data = new SpaceMakeCopyToSpaceResult.Data(r4, r5, r2);     // Catch: Exception -> L38
            return r12;
        L29:
            r5 = "";
        L25:
            r4 = "";
            goto L26
        L21:
            r10 = null;
        L18:
            r9 = null;
            goto L19
        L13:
            r3 = null;
            goto L14
        L10:
            r1 = null;
        L41:
            return null;
        }
    }

    static {
    }
}
