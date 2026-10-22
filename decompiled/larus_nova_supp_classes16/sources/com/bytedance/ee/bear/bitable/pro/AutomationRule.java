package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/AutomationRule;", "Lcom/bytedance/ee/util/io/NonProguard;", "isEnable", "", "actionRuleMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(ZLjava/util/HashMap;)V", "()Z", "getActionRuleMap", "()Ljava/util/HashMap;", "getPermDesc", "context", "Landroid/content/Context;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutomationRule implements NonProguard {
    public static final String AUTOMATION_EXCUTE_ACCEPT_USER_NUM = "80007";
    public static final String AUTOMATION_EXCUTE_NOTIFY_USER_NUM = "80006";
    public static final String AUTOMATION_EXCUTE_UPDATE_DATA = "80008";
    private static final String[] AUTOMATION_PERM_LIST = null;
    public static final String AUTOMATION_TRIGGER_CYCLICITY = "80005";
    public static final String AUTOMATION_TRIGGER_DATA_UPDATE = "80003";
    public static final String AUTOMATION_TRIGGER_ONE_TIME = "80004";
    public static final String AUTOMATION_WORKFLOW_CREATE = "80001";
    public static final String AUTOMATION_WORKFLOW_DELETE = "80002";
    public static final a Companion = null;
    private final HashMap<String, Integer> actionRuleMap;
    private final boolean isEnable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        AUTOMATION_PERM_LIST = new String[]{AUTOMATION_WORKFLOW_CREATE, AUTOMATION_WORKFLOW_DELETE, AUTOMATION_TRIGGER_DATA_UPDATE, AUTOMATION_TRIGGER_ONE_TIME, AUTOMATION_TRIGGER_CYCLICITY, AUTOMATION_EXCUTE_NOTIFY_USER_NUM, AUTOMATION_EXCUTE_ACCEPT_USER_NUM, AUTOMATION_EXCUTE_UPDATE_DATA};
    }

    public static final /* synthetic */ String[] access$getAUTOMATION_PERM_LIST$cp() {
        return AUTOMATION_PERM_LIST;
    }

    public final HashMap<String, Integer> getActionRuleMap() {
        return this.actionRuleMap;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final String getPermDesc(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (this.isEnable == false) goto L20;
        String[] r0 = AUTOMATION_PERM_LIST;
        int r1 = r0.length;
        boolean r2 = false;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L16;
        String r4 = r0[r3];
        Integer r5 = this.actionRuleMap.get(r4);
        if (r5 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L14;
        r3 = r3 + 1;
        goto L5
    L14:
        r2 = true;
        goto L16
    L10:
        if (1 != r5.intValue()) goto L12;
        r6 = true;
    L16:
        if (r2 == false) goto L18;
        String r8 = r7.getString(2131886247);
    L19:
        Intrinsics.checkNotNull(r8);
        return r8;
    L18:
        r8 = r7.getString(2131886239);
        goto L19
    L20:
        String r9 = r7.getString(2131886246);
        Intrinsics.checkNotNull(r9);
        return r9;
    }

    public AutomationRule(boolean r2, HashMap<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "actionRuleMap");
        this.isEnable = r2;
        this.actionRuleMap = r3;
    }
}
