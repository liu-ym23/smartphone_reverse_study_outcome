package kw4;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f506391a = null;

    static {
        f506391a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        SimpleRequestResult r111 = (SimpleRequestResult) r110;
        Intrinsics.checkNotNullParameter(r111, "result");
        String r100 = "";
        int r101 = 0;
        if (r111.code != 0) goto L36;
        int r102 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        String r112 = r111.data.toString();
        HashMap r113 = new HashMap();
        JSONObject r114 = new JSONObject(r112);     // Catch: Exception -> L20
        String r115 = r114.optString("value");     // Catch: Exception -> L20
        if (Intrinsics.areEqual(r115, "my_document_library") == false) goto L9;
        r113.put("createLocationType", "my_document_library");     // Catch: Exception -> L20
    L22:
        String r116 = (String) r113.get("parentToken");
        if (r116 != null) goto L25;
        r116 = "";
    L25:
        String r103 = (String) r113.get("createLocationType");
        if (r103 != null) goto L28;
        r103 = "";
    L28:
        String r104 = (String) r113.get("owner_type");
        if (r104 == null) goto L31;
        r101 = CastIntegerProtector.parseInt(r104);
    L31:
        String r105 = (String) r113.get(DocViewModel.EXTRA_SPACE_ID);
        if (r105 == null) goto L35;
        r100 = r105;
    L35:
        tt5.a.h("CreateLocationSelector", "Create Location: parentToken: " + du5.b.i(r116) + ", type: " + r103 + " ownerType:" + r101 + " spaceId:" + r100);
        int r106 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        return com.bytedance.ee.bear.content.creation.location.a.b(r116, r103, r100, r101);
    L9:
        if (Intrinsics.areEqual(r115, "my_root_folder") == false) goto L11;
        r113.put("createLocationType", "my_root_folder");     // Catch: Exception -> L20
        goto L22
    L11:
        r113.put("parentToken", r115);     // Catch: Exception -> L20
        JSONObject r117 = r114.optJSONObject(DocumentType.FOLDER_NAME);     // Catch: Exception -> L20
        if (r117 == null) goto L14;
        int r118 = r117.optInt("owner_type");     // Catch: Exception -> L20
        r113.put("createLocationType", DocumentType.FOLDER_NAME);     // Catch: Exception -> L20
        r113.put("owner_type", String.valueOf(r118));     // Catch: Exception -> L20
    L14:
        JSONObject r119 = r114.optJSONObject("node");     // Catch: Exception -> L20
        if (r119 == null) goto L22;
        String r120 = r119.optString(DocViewModel.EXTRA_SPACE_ID);     // Catch: Exception -> L20
        if (r120 == null) goto L22;
        r113.put("createLocationType", "node");     // Catch: Exception -> L20
        r113.put(DocViewModel.EXTRA_SPACE_ID, r120);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.d("CreateLocationSelector", "Parse error: " + ExceptionsKt.stackTraceToString(e));
        r113.put("createLocationType", "my_document_library");
        goto L22
    L36:
        tt5.a.k("CreateLocationSelector", "Fallback to wiki. Reason: unknown");
        return com.bytedance.ee.bear.content.creation.location.a.b("", "my_document_library", "", 0);
    }
}
