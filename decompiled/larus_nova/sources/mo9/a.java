package mo9;

import com.bytedance.ee.bear.bitable.context.BitableTokenType;
import com.bytedance.ee.bear.bitable.context.BitableViewType;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tr4.e;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514618a = 0;

    static {
    }

    public static void a(Map r100, tr4.a r101) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        if (r101 == null) goto L89;
        boolean r102 = true;
        if (r101.f547296a.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        String r104 = null;
        if (r103 == false) goto L11;
        tr4.a r105 = r101;
    L12:
        if (r105 == null) goto L90;
        JSONObject r106 = new JSONObject();
        r106.put("token", r101.f547296a);
        r106.put("base_token_type", r101.f547297b.getValue());
        e r107 = r101.f547298c;
        if (r107 == null) goto L87;
        JSONObject r108 = new JSONObject();
        if (r101.f547297b != BitableTokenType.APP) goto L29;
        String r109 = r107.f547306h;
        if (r109 == null) goto L85;
        if (r109.length() > 0) goto L25;
        r102 = false;
    L25:
        if (r102 == false) goto L27;
        r104 = r109;
    L27:
        if (r104 == null) goto L85;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r104);
    L85:
        if (r108.length() <= 0) goto L87;
        r106.put("view_param", r108);
        goto L87
    L29:
        r108.put("base_block_type", r107.f547299a.getValue());
        String r110 = r107.f547300b;
        if (r110.length() <= 0) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == true) goto L36;
        r110 = null;
    L36:
        if (r110 == null) goto L38;
        r108.put("base_block_id", r110);
    L38:
        BitableViewType r112 = r107.f547301c;
        if (r112 == null) goto L41;
        r108.put(BytedCertConstant.IntentKey.VIEW_TYPE, r112.getValue());
    L41:
        String r113 = r107.f547302d;
        if (r113 != null) goto L44;
    L52:
        String r114 = r107.f547303e;
        if (r114 != null) goto L55;
    L63:
        String r115 = r107.f547304f;
        if (r115 != null) goto L66;
    L74:
        String r116 = r107.f547305g;
        if (r116 == null) goto L85;
        if (r116.length() > 0) goto L80;
        r102 = false;
    L80:
        if (r102 == false) goto L82;
        r104 = r116;
    L82:
        if (r104 == null) goto L85;
        r108.put("doc_token", r104);
        goto L85
    L66:
        if (r115.length() <= 0) goto L68;
        boolean r117 = true;
    L69:
        if (r117 == true) goto L72;
        r115 = null;
    L72:
        if (r115 == null) goto L74;
        r108.put("workflow_token", r115);
        goto L74
    L68:
        r117 = false;
        goto L69
    L55:
        if (r114.length() <= 0) goto L57;
        boolean r118 = true;
    L58:
        if (r118 == true) goto L61;
        r114 = null;
    L61:
        if (r114 == null) goto L63;
        r108.put("dashboard_token", r114);
        goto L63
    L57:
        r118 = false;
        goto L58
    L44:
        if (r113.length() <= 0) goto L46;
        boolean r119 = true;
    L47:
        if (r119 == true) goto L50;
        r113 = null;
    L50:
        if (r113 == null) goto L52;
        r108.put(BitableResourceData.KEY_VIEW_ID, r113);
        goto L52
    L46:
        r119 = false;
        goto L47
    L32:
        r111 = false;
    L87:
        r100.put("office_base_context", r106.toString());
        return;
    L90:
        return;
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = false;
        goto L8
    }
}
