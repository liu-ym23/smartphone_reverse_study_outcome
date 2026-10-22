package com.ss.android.lark.auditsdk.v2.utils;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditUtilsV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f409687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f409688b = null;

    public AuditUtilsV2() {
    }

    static {
        f409687a = LazyKt.lazy(AuditUtilsV2$isEnableAuthForMe$2.INSTANCE);
        f409688b = LazyKt.lazy(AuditUtilsV2$isMultiAuthCheckDisabled$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) f409687a.getValue()).booleanValue();
    }

    public static final String a(Integer r100, String r101, Integer r102) {
        if (r100 != null) goto L12;
        if (r101 != null) goto L13;
        if (r102 == null) goto L10;
        String r103 = UIHelper.mustacheFormat(R.string.Lark_Audit_BlockedActionsDueToPermissionSettings, "BlockedAction", UIHelper.getString(r102.intValue()));
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        return r103;
    L10:
        Log.e("AuditUtilsV2", "No message to display on check authorization failed");
        return null;
    L13:
        return r101;
    L12:
        return UIHelper.getString(r100.intValue());
    }
}
