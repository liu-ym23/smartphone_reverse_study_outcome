package com.ss.android.lark.conditional.access.utils;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f418482a = null;

    static {
        f418482a = CollectionsKt.listOf(new String[]{"CustomLink", "CustomAppLink", "DeviceApply", "DeviceAuth", "Cancel", "RetryAccess", "MFA", "UserConfirm", "DeviceCertAuth", "DeviceTokenClaimsChallenge", "GeoAuth", "VerifyLocation", CancelRetainContactInfoFunctions.SkipVerify});
    }

    public static final boolean a(CustomDisplayHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f418482a.contains(r100.type) == true) goto L5;
        return false;
    L5:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r100.type, "GeoAuth") == false) goto L9;
        return false;
    }
}
