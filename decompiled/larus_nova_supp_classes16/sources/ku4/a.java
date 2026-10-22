package ku4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.panel.GroupInfo;
import com.bytedance.ee.bear.bitable.pro.BlockRole;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.bitable.pro.TableRole;
import com.bytedance.ee.bear.bitable.pro.roledetail.RoleDetailItemData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final ArrayList<GroupInfo> a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ArrayList<GroupInfo> r0 = new ArrayList();
        r0.add(new GroupInfo("PermName", r4.getString(2131886187)));
        r0.add(new GroupInfo("DashboardPerm", r4.getString(2131886229)));
        r0.add(new GroupInfo("TablePerm", r4.getString(2131886244)));
        r0.add(new GroupInfo("DocxPerm", r4.getString(2131886233)));
        return r0;
    }

    public static final ArrayList<RoleDetailItemData> b(Role r11, Context r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "context");
        ArrayList<RoleDetailItemData> r0 = new ArrayList();
        Iterator<T> r1 = r11.getDashboardRoleList().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        BlockRole r2 = (BlockRole) r1.next();
        r0.add(new RoleDetailItemData(r2.getBlockName(), r2.getPermDesc(r12), "DashboardPerm", false, 8, null));
        goto L4
    L6:
        Iterator<T> r3 = r11.getTableRoleList().iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        TableRole r4 = (TableRole) r3.next();
        r0.add(new RoleDetailItemData(r4.getTableName(), r4.getPermDescV2(r12), "TablePerm", false, 8, null));
        goto L8
    L11:
        if (Intrinsics.areEqual(r11.isSoloBaseSuite(), Boolean.TRUE) == false) goto L16;
        Iterator<T> r13 = r11.getDocxRoleList().iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        BlockRole r5 = (BlockRole) r13.next();
        r0.add(new RoleDetailItemData(r5.getBlockName(), r5.getPermDesc(r12), "DocxPerm", false, 8, null));
    L16:
        return r0;
    }
}
