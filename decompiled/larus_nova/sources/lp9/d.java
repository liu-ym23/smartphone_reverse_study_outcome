package lp9;

import kotlin.jvm.internal.Intrinsics;
import kq9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f510246a;

    static {
    }

    public static JSONObject a() {
        JSONObject r100 = new JSONObject();
        e r101 = f510246a;
        if (r101 == null) goto L34;
        String r102 = r101.f505618a;
        String r103 = "";
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.put("bot_id", r102);
        String r104 = r101.f505619b;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r100.put("conversation_id", r104);
        r100.put("bot_conversation_type", r101.f505620c);
        String r105 = r101.f505621d;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r100.put("chat_type", r105);
        String r106 = r101.f505622e;
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r100.put("previous_page", r106);
        String r107 = r101.f505623f;
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r100.put("click_from", r107);
        String r108 = r101.f505624g;
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r100.put("cited_from_user_type", r108);
        String r109 = r101.f505625h;
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        r100.put("cited_message_id", r109);
        String r110 = r101.f505626i;
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        r100.put("previous_camera_tab_name", r110);
        Boolean r111 = r101.f505627j;
        Boolean r112 = Boolean.TRUE;
        r100.put("is_ai_doc", Intrinsics.areEqual(r111, r112) ? 1 : 0);
        r100.put("is_replica_create", Intrinsics.areEqual(r101.f505628k, r112) ? 1 : 0);
        String r113 = r101.f505629l;
        if (r113 == null) goto L33;
        r103 = r113;
    L33:
        r100.put("replica_create_id", r103);
    L34:
        return r100;
    }
}
