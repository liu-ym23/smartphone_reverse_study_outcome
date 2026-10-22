package ke5;

import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalList;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.v;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f503029a = 0;

    static {
    }

    public static EscapeApprovalInfo a(XReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.getString("token");
        int r102 = r100.getInt("type");
        XReadableMap r103 = r100.getMap("approval_list");
        if (r103 != null) goto L5;
        ApprovalList r104 = new ApprovalList(null, null, 3, null);
    L15:
        return new EscapeApprovalInfo(r101, r102, r104);
    L5:
        v r105 = r103.getArray("instances");
        ArrayList r106 = new ArrayList();
        if (r105 == null) goto L13;
        int r107 = r105.size();
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L13;
        Instance r109 = b(r105.getMap(r108));
        if (r109 == null) goto L12;
        r106.add(r109);
    L12:
        r108 = r108 + 1;
    L13:
        r104 = new ApprovalList(r106, b(r103.getMap("my_instance")));
        goto L15
    }

    public static Instance b(XReadableMap r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        return new Instance(r110.getString("instance_code"), r110.getInt("obj_type"), r110.getString("obj_id"), r110.getString("user_id"), r110.getString(ITwitterService.ResponseConstants.USER_NAME), r110.getString("user_avatar_url"), com.bytedance.ee.bear.lynx.impl.xbridge.a.a(r110, "create_time").longValue());
    }

    public static ArrayList c(v r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L27;
        XReadableMap r104 = r100.getMap(r103);
        String r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.getString("user_id");
    L11:
        String r107 = "";
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        XReadableMap r108 = r100.getMap(r103);
        if (r108 == null) goto L17;
        String r109 = r108.getString(ITwitterService.ResponseConstants.USER_NAME);
    L18:
        if (r109 != null) goto L20;
        r109 = "";
    L20:
        XReadableMap r110 = r100.getMap(r103);
        if (r110 == null) goto L23;
        r105 = r110.getString("user_avatar_tos_url");
    L23:
        if (r105 == null) goto L26;
        r107 = r105;
    L26:
        r101.add(new Reviewer(r106, r109, r107));
        r103 = r103 + 1;
        goto L6
    L17:
        r109 = null;
        goto L18
    L10:
        r106 = null;
        goto L11
    L27:
        return r101;
    L4:
        return new ArrayList();
    }
}
