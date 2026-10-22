package ku4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.panel.GroupInfo;
import com.bytedance.ee.bear.bitable.pro.BlockRole;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.bitable.pro.TableRole;
import com.bytedance.ee.bear.bitable.pro.roledetail.RoleDetailItemData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static final ArrayList<GroupInfo> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList<GroupInfo> r101 = new ArrayList();
        r101.add(new GroupInfo("PermName", r100.getString(R.string.Bitable_AdvancedPermission_PermissionName)));
        r101.add(new GroupInfo("DashboardPerm", r100.getString(R.string.Bitable_AdvancedPermissions_DashboardPerm_Tab_Mob)));
        r101.add(new GroupInfo("TablePerm", r100.getString(R.string.Bitable_AdvancedPermissions_TablePerm_Tab_Mob)));
        r101.add(new GroupInfo("DocxPerm", r100.getString(R.string.Bitable_AdvancedPermissions_DocumentPerm_Tab_Mob)));
        return r101;
    }

    public static final ArrayList<RoleDetailItemData> b(Role r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList<RoleDetailItemData> r100 = new ArrayList();
        Iterator<T> r101 = r110.getDashboardRoleList().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        BlockRole r102 = (BlockRole) r101.next();
        r100.add(new RoleDetailItemData(r102.getBlockName(), r102.getPermDesc(r111), "DashboardPerm", false, 8, null));
        goto L4
    L6:
        Iterator<T> r103 = r110.getTableRoleList().iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        TableRole r104 = (TableRole) r103.next();
        r100.add(new RoleDetailItemData(r104.getTableName(), r104.getPermDescV2(r111), "TablePerm", false, 8, null));
        goto L8
    L11:
        if (Intrinsics.areEqual(r110.isSoloBaseSuite(), Boolean.TRUE) == false) goto L16;
        Iterator<T> r112 = r110.getDocxRoleList().iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        BlockRole r105 = (BlockRole) r112.next();
        r100.add(new RoleDetailItemData(r105.getBlockName(), r105.getPermDesc(r111), "DocxPerm", false, 8, null));
    L16:
        return r100;
    }
}
