package hd5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484599a = 0;

    public static final class a {
    }

    public static final class b implements NetService.c<SpaceMakeCopyToSpaceResult> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
        L22:
            return null;
        L3:
            String r101 = "";
            if (r100 != null) goto L6;
            r100 = "";
        L6:
            JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L22
            if (r102 == null) goto L10;
            String r103 = JSONObjectProtectorUtils.getString(r102, "obj_token");     // Catch: Exception -> L22
            if (r103 == null) goto L10;
        L11:
            if (r102 == null) goto L14;
            String r104 = JSONObjectProtectorUtils.getString(r102, "token");     // Catch: Exception -> L22
            if (r104 == null) goto L14;
        L15:
            if (r102 == null) goto L20;
            String r105 = JSONObjectProtectorUtils.getString(r102, "url");     // Catch: Exception -> L22
            if (r105 == null) goto L20;
            r101 = r105;
        L20:
            SpaceMakeCopyToSpaceResult.Data r106 = new SpaceMakeCopyToSpaceResult.Data(r103, r104, r101);     // Catch: Exception -> L22
            SpaceMakeCopyToSpaceResult r107 = new SpaceMakeCopyToSpaceResult();     // Catch: Exception -> L22
            r107.data = r106;     // Catch: Exception -> L22
            return r107;
        L14:
            r104 = "";
        L10:
            r103 = "";
            goto L11
        }
    }

    /* JADX INFO: renamed from: hd5.c$c, reason: collision with other inner class name */
    public static final class C6125c implements NetService.c<SpaceMakeCopyToSpaceResult> {
        public C6125c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            String r101 = "";
            if (r100 != null) goto L7;
            r100 = "";
        L7:
            JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L38
            if (r102 == null) goto L10;
            JSONArray r103 = r102.optJSONArray("node_list");     // Catch: Exception -> L38
        L11:
            if (r103 == null) goto L13;
            String r104 = r103.optString(0);     // Catch: Exception -> L38
        L14:
            if (r102 == null) goto L18;
            JSONObject r105 = r102.optJSONObject("entities");     // Catch: Exception -> L38
            if (r105 == null) goto L18;
            JSONObject r106 = r105.optJSONObject("nodes");     // Catch: Exception -> L38
        L19:
            if (r106 == null) goto L21;
            JSONObject r107 = r106.optJSONObject(r104);     // Catch: Exception -> L38
        L22:
            if (r107 == null) goto L25;
            String r108 = r107.optString("obj_token");     // Catch: Exception -> L38
            if (r108 == null) goto L25;
        L26:
            if (r107 == null) goto L29;
            String r109 = r107.optString("token");     // Catch: Exception -> L38
            if (r109 == null) goto L29;
        L30:
            if (r107 == null) goto L35;
            String r110 = r107.optString("url");     // Catch: Exception -> L38
            if (r110 == null) goto L35;
            r101 = r110;
        L35:
            SpaceMakeCopyToSpaceResult r111 = new SpaceMakeCopyToSpaceResult();     // Catch: Exception -> L38
            r111.data = new SpaceMakeCopyToSpaceResult.Data(r108, r109, r101);     // Catch: Exception -> L38
            return r111;
        L29:
            r109 = "";
        L25:
            r108 = "";
            goto L26
        L21:
            r107 = null;
        L18:
            r106 = null;
            goto L19
        L13:
            r104 = null;
            goto L14
        L10:
            r103 = null;
        L41:
            return null;
        }
    }

    static {
    }
}
