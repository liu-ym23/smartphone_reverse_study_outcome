package ke5;

import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalList;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.v;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static EscapeApprovalInfo a(XReadableMap r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        String r1 = r8.getString(ResourceData.KEY_TOKEN);
        int r2 = r8.getInt(ResourceData.KEY_TYPE);
        XReadableMap r9 = r8.getMap("approval_list");
        if (r9 != null) goto L5;
        ApprovalList r10 = new ApprovalList(null, null, 3, null);
    L15:
        return new EscapeApprovalInfo(r1, r2, r10);
    L5:
        v r3 = r9.getArray("instances");
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L13;
        int r5 = r3.size();
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L13;
        Instance r7 = b(r3.getMap(r6));
        if (r7 == null) goto L12;
        r4.add(r7);
    L12:
        r6 = r6 + 1;
    L13:
        r10 = new ApprovalList(r4, b(r9.getMap("my_instance")));
        goto L15
    }

    public static Instance b(XReadableMap r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new Instance(r10.getString("instance_code"), r10.getInt("obj_type"), r10.getString("obj_id"), r10.getString("user_id"), r10.getString("user_name"), r10.getString("user_avatar_url"), com.bytedance.ee.bear.lynx.impl.xbridge.a.a(r10, "create_time").longValue());
    }

    public static ArrayList c(v r9) {
        if (r9 == null) goto L4;
        ArrayList r0 = new ArrayList();
        int r1 = r9.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L27;
        XReadableMap r4 = r9.getMap(r2);
        String r5 = null;
        if (r4 == null) goto L10;
        String r6 = r4.getString("user_id");
    L11:
        String r7 = "";
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        XReadableMap r8 = r9.getMap(r2);
        if (r8 == null) goto L17;
        String r10 = r8.getString("user_name");
    L18:
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        XReadableMap r11 = r9.getMap(r2);
        if (r11 == null) goto L23;
        r5 = r11.getString("user_avatar_tos_url");
    L23:
        if (r5 == null) goto L26;
        r7 = r5;
    L26:
        r0.add(new Reviewer(r6, r10, r7));
        r2 = r2 + 1;
        goto L6
    L17:
        r10 = null;
        goto L18
    L10:
        r6 = null;
        goto L11
    L27:
        return r0;
    L4:
        return new ArrayList();
    }
}
