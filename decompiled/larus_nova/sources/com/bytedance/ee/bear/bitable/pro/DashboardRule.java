package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/DashboardRule;", "Lcom/bytedance/ee/util/io/NonProguard;", "isEnable", "", "actionRuleMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(ZLjava/util/HashMap;)V", "()Z", "getActionRuleMap", "()Ljava/util/HashMap;", "getPermDesc", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DashboardRule implements NonProguard {
    public static final a Companion = null;
    public static final String DASHBOARD_CREAT = "80101";
    public static final String DASHBOARD_DELETE = "80102";
    private static final String[] DASHBOARD_PERM_LIST = null;
    public static final String DASHBOARD_SHARE = "80103";
    private final HashMap<String, Integer> actionRuleMap;
    private final boolean isEnable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        DASHBOARD_PERM_LIST = new String[]{DASHBOARD_CREAT, DASHBOARD_DELETE, DASHBOARD_SHARE};
    }

    public static final /* synthetic */ String[] access$getDASHBOARD_PERM_LIST$cp() {
        return DASHBOARD_PERM_LIST;
    }

    public final HashMap<String, Integer> getActionRuleMap() {
        return this.actionRuleMap;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final String getPermDesc(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.isEnable == false) goto L20;
        String[] r101 = DASHBOARD_PERM_LIST;
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L16;
        String r105 = r101[r104];
        Integer r106 = this.actionRuleMap.get(r105);
        if (r106 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == true) goto L14;
        r104 = r104 + 1;
        goto L5
    L14:
        r103 = true;
        goto L16
    L10:
        if (1 != r106.intValue()) goto L12;
        r107 = true;
    L16:
        if (r103 == false) goto L18;
        String r108 = r100.getString(R.string.Bitable_AdvancedPermissions_UseDashboard_Desc_Mob);
    L19:
        Intrinsics.checkNotNull(r108);
        return r108;
    L18:
        r108 = r100.getString(R.string.Bitable_AdvancedPermissions_NoDashboardAccess_Desc_Mob);
        goto L19
    L20:
        String r109 = r100.getString(R.string.Bitable_AdvancedPermissions_Unset_Desc_Mob);
        Intrinsics.checkNotNull(r109);
        return r109;
    }

    public DashboardRule(boolean r100, HashMap<String, Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "actionRuleMap");
        this.isEnable = r100;
        this.actionRuleMap = r101;
    }
}
