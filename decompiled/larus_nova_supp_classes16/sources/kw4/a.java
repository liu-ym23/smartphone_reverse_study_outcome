package kw4;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r16) {
        SimpleRequestResult r17 = (SimpleRequestResult) r16;
        Intrinsics.checkNotNullParameter(r17, TipCallBackData.RESULT);
        String r6 = "";
        int r7 = 0;
        if (r17.code != 0) goto L36;
        int r4 = com.bytedance.ee.bear.content.creation.location.a.a;
        String r18 = r17.data.toString();
        HashMap r11 = new HashMap();
        JSONObject r12 = new JSONObject(r18);     // Catch: Exception -> L20
        String r19 = r12.optString("value");     // Catch: Exception -> L20
        if (Intrinsics.areEqual(r19, "my_document_library") == false) goto L9;
        r11.put("createLocationType", "my_document_library");     // Catch: Exception -> L20
    L22:
        String r110 = (String) r11.get("parentToken");
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        String r0 = (String) r11.get("createLocationType");
        if (r0 != null) goto L28;
        r0 = "";
    L28:
        String r1 = (String) r11.get("owner_type");
        if (r1 == null) goto L31;
        r7 = CastIntegerProtector.parseInt(r1);
    L31:
        String r2 = (String) r11.get(DocViewModel.EXTRA_SPACE_ID);
        if (r2 == null) goto L35;
        r6 = r2;
    L35:
        tt5.a.h("CreateLocationSelector", "Create Location: parentToken: " + du5.b.i(r110) + ", type: " + r0 + " ownerType:" + r7 + " spaceId:" + r6);
        int r3 = com.bytedance.ee.bear.content.creation.location.a.a;
        return com.bytedance.ee.bear.content.creation.location.a.b(r110, r0, r6, r7);
    L9:
        if (Intrinsics.areEqual(r19, "my_root_folder") == false) goto L11;
        r11.put("createLocationType", "my_root_folder");     // Catch: Exception -> L20
        goto L22
    L11:
        r11.put("parentToken", r19);     // Catch: Exception -> L20
        JSONObject r111 = r12.optJSONObject("folder");     // Catch: Exception -> L20
        if (r111 == null) goto L14;
        int r112 = r111.optInt("owner_type");     // Catch: Exception -> L20
        r11.put("createLocationType", "folder");     // Catch: Exception -> L20
        r11.put("owner_type", String.valueOf(r112));     // Catch: Exception -> L20
    L14:
        JSONObject r113 = r12.optJSONObject("node");     // Catch: Exception -> L20
        if (r113 == null) goto L22;
        String r114 = r113.optString(DocViewModel.EXTRA_SPACE_ID);     // Catch: Exception -> L20
        if (r114 == null) goto L22;
        r11.put("createLocationType", "node");     // Catch: Exception -> L20
        r11.put(DocViewModel.EXTRA_SPACE_ID, r114);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.d("CreateLocationSelector", "Parse error: " + ExceptionsKt.stackTraceToString(e));
        r11.put("createLocationType", "my_document_library");
        goto L22
    L36:
        tt5.a.k("CreateLocationSelector", "Fallback to wiki. Reason: unknown");
        return com.bytedance.ee.bear.content.creation.location.a.b("", "my_document_library", "", 0);
    }
}
