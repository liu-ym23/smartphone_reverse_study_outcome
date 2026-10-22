package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418373a = 0;

    static {
    }

    public static CustomDisplayPageUiMode a(NoPermissionType r100, InternalSecurityAction r101) {
        Intrinsics.checkNotNullParameter(r100, "noPermissionType");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        return CustomDisplayPageUiMode.LARK;
    L7:
        if (w4c.c.a().C() == false) goto L9;
        if (r101 == null) goto L28;
        DecisionData.Action r102 = r101.getCurrentAction();
        if (r102 == null) goto L28;
        if (r100 == NoPermissionType.CUSTOM_DISPLAY) goto L17;
    L21:
        boolean r103 = false;
    L22:
        if (r103 == true) goto L26;
        return CustomDisplayPageUiMode.LARK;
    L26:
        return CustomDisplayPageUiMode.DOUBAO;
    L17:
        if (Intrinsics.areEqual(r102.getParams().get("policyType"), "POLICY_CENTER") == false) goto L21;
        if (Intrinsics.areEqual(r102.getParams().get("containerType"), "page") == false) goto L21;
        r103 = true;
    L28:
        return CustomDisplayPageUiMode.LARK;
    L9:
        return CustomDisplayPageUiMode.LARK;
    }
}
