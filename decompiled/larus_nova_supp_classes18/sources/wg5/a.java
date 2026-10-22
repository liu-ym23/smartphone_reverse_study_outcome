package wg5;

import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends vg5.a {
    public final DocPermSetInfo e;

    public a(dh5.b r2, DocPermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "permSetInfo");
        super(r2, r3);
        this.e = r3;
    }

    @Override // vg5.a
    public final HashMap<String, String> k(ArrayList<UserInfo> r2, boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "selectedUsers");
        Intrinsics.checkNotNullParameter(r5, "notes");
        HashMap<String, String> r6 = new HashMap();
        r6.put(ResourceData.KEY_TOKEN, this.e.c);
        r6.put(ResourceData.KEY_TYPE, String.valueOf(this.e.getType()));
        r6.put("owners", vg5.a.p(r2));
        String r7 = "1";
        r6.put("perm_type", "1");
        if (r3 == true) goto L6;
        r7 = "0";
    L6:
        r6.put("notify_lark", r7);
        h(r6);
        return r6;
    }
}
