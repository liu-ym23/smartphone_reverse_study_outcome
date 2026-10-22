package com.ttnet.org.chromium.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class PackageManagerUtils {
    public static final Intent BROWSER_INTENT = null;
    private static final String TAG = "PackageManagerUtils";

    public PackageManagerUtils() {
    }

    static {
        BROWSER_INTENT = new Intent().setAction(CommonConstant.ACTION.HWID_SCHEME_URL).addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
    }

    public static Intent getQueryInstalledHomeLaunchersIntent() {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    }

    public static List<ResolveInfo> queryAllWebBrowsersInfo() {
        return queryIntentActivities(BROWSER_INTENT, 983040);
    }

    public static ResolveInfo resolveDefaultWebBrowserActivity() {
        return resolveActivity(BROWSER_INTENT, 65536);
    }

    public static List<ResolveInfo> queryAllLaunchersInfo() {
        return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
    }

    public static boolean canResolveActivity(Intent r100) {
        return canResolveActivity(r100, 0);
    }

    public static boolean canResolveActivity(Intent r100, int r101) {
        return !queryIntentActivities(r100, r101).isEmpty();
    }

    private static void handleExpectedExceptionsOrRethrow(RuntimeException r100, Intent r101) {
        if ((r100 instanceof NullPointerException) == false) goto L5;
    L8:
        Log.e(TAG, "Could not resolve Activity for intent " + r101.toString(), new Object[]{r100});
        return;
    L5:
        if ((r100.getCause() instanceof TransactionTooLargeException) == true) goto L8;
        throw r100;
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r100, int r101) {
        StrictModeContext r102 = StrictModeContext.allowDiskReads();     // Catch: RuntimeException -> L14
        List<ResolveInfo> r103 = ContextUtils.getApplicationContext().getPackageManager().queryIntentActivities(r100, r101);     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.close();     // Catch: RuntimeException -> L14
    L6:
        return r103;
    L7:
        th = move-exception;
        if (r102 != null) goto L20;
    L13:
        throw th;     // Catch: RuntimeException -> L14
    L20:
        r102.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r100);
        return Collections.emptyList();
    }

    public static ResolveInfo resolveActivity(Intent r100, int r101) {
        StrictModeContext r102 = StrictModeContext.allowDiskWrites();     // Catch: RuntimeException -> L14
        ResolveInfo r103 = ContextUtils.getApplicationContext().getPackageManager().resolveActivity(r100, r101);     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.close();     // Catch: RuntimeException -> L14
    L6:
        return r103;
    L7:
        th = move-exception;
        if (r102 != null) goto L20;
    L13:
        throw th;     // Catch: RuntimeException -> L14
    L20:
        r102.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r100);
        return null;
    }
}
