package com.ttnet.org.chromium.base;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import androidx.core.app.BundleCompat;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForS;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class IntentUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ANDROID_APP_REFERRER_SCHEME = "android-app";
    private static final Object COMPONENT_NAME_LOCK = null;
    public static final String EPHEMERAL_INSTALLER_CLASS = "com.google.android.gms.instantapps.routing.EphemeralInstallerActivity";
    private static final String TAG = "IntentUtils";
    public static final String TRUSTED_APPLICATION_CODE_EXTRA = "trusted_application_code_extra";
    private static ComponentName sFakeComponentName;
    private static boolean sForceTrustedIntentForTesting;

    public IntentUtils() {
    }

    static {
        COMPONENT_NAME_LOCK = new Object();
    }

    private static PendingIntent getAuthenticationToken() {
        Intent r100 = new Intent();
        Context r101 = ContextUtils.getApplicationContext();
        r100.setComponent(getFakeComponentName(r101.getPackageName()));
        return PendingIntent.getActivity(r101, 0, r100, getPendingIntentMutabilityFlag(false));
    }

    public static void addTrustedIntentExtras(Intent r100) {
        if (intentTargetsSelf(ContextUtils.getApplicationContext(), r100) == true) goto L5;
        return;
    L5:
        r100.putExtra(TRUSTED_APPLICATION_CODE_EXTRA, getAuthenticationToken());
    }

    private static ComponentName getFakeComponentName(String r100) {
        Object r101 = COMPONENT_NAME_LOCK;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sFakeComponentName != null) goto L7;
        sFakeComponentName = new ComponentName(r100, "FakeClass");     // Catch: Throwable -> L10
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return sFakeComponentName;
    }

    public static int getParceledIntentSize(Intent r100) {
        Parcel r101 = Parcel.obtain();
        r100.writeToParcel(r101, 0);
        return r101.dataSize();
    }

    public static int getPendingIntentMutabilityFlag(boolean r100) {
        if (r100 == false) goto L4;
    L7:
        if (r100 == true) goto L9;
        return 0;
    L9:
        if (Build.VERSION.SDK_INT >= 31) goto L11;
        return 0;
    L11:
        return ApiHelperForS.getPendingIntentMutableFlag();
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.getPendingIntentImmutableFlag();
    }

    public static boolean isInstantAppResolveInfo(ResolveInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        ActivityInfo r101 = r100.activityInfo;
        if (r101 != null) goto L12;
        return false;
    L12:
        return EPHEMERAL_INSTALLER_CLASS.equals(r101.name);
    L8:
        return r100.isInstantAppAvailable;
    }

    public static boolean isIntentForNewTaskOrNewDocument(Intent r100) {
        if ((r100.getFlags() & 268959744) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainIntentFromLauncher(Intent r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (TextUtils.equals(r100.getAction(), "android.intent.action.MAIN") == false) goto L10;
        if (r100.hasCategory("android.intent.category.LAUNCHER") == false) goto L10;
        if ((r100.getFlags() & 1048576) != 0) goto L10;
        return true;
    }

    public static boolean isTrustedIntentFromSelf(Intent r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (sForceTrustedIntentForTesting == false) goto L9;
        return true;
    L9:
        PendingIntent r101 = (PendingIntent) safeGetParcelableExtra(r100, TRUSTED_APPLICATION_CODE_EXTRA);
        if (r101 != null) goto L13;
        return false;
    L13:
        return getAuthenticationToken().equals(r101);
    }

    public static Intent sanitizeIntent(Intent r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        r100.getBooleanExtra("TriggerUnparcel", false);     // Catch: RuntimeException -> L7 BadParcelableException -> L13
        return r100;
    L13:
        e = move-exception;
        return logInvalidIntent(r100, e);
    L7:
        e = move-exception;
        if ((e.getCause() instanceof ClassNotFoundException) == true) goto L11;
        throw e;
    L11:
        return logInvalidIntent(r100, e);
    }

    public static void setForceIsTrustedIntentForTesting(boolean r100) {
        sForceTrustedIntentForTesting = r100;
    }

    public static Bundle INVOKEVIRTUAL_com_ttnet_org_chromium_base_IntentUtils_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r100, String r101) {
        Bundle r102 = r100.getBundleExtra(r101);
        Context r103 = BadParcelableCrashOptimizer.getContext();
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r102.setClassLoader(r103.getClassLoader());
    L6:
        return r102;
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent r100, String r101) {
        return r100.getParcelableArrayListExtra(r101);
    L4:
        Log.e(TAG, "getParcelableArrayListExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static boolean intentTargetsSelf(Context r100, Intent r101) {
        boolean r102 = !TextUtils.isEmpty(r101.getPackage());
        if (r102 == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r101.getComponent() == null) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L21;
        if (r102 == false) goto L20;
        return r103;
    L20:
        return true;
    L21:
        if (r103 == true) goto L23;
        return false;
    L23:
        return !r104;
    L14:
        if (r100.getPackageName().equals(r101.getComponent().getPackageName()) == false) goto L16;
        r105 = true;
        goto L17
    L11:
        r104 = false;
        goto L12
    L5:
        if (r100.getPackageName().equals(r101.getPackage()) == false) goto L7;
        r103 = true;
        goto L9
    }

    private static Intent logInvalidIntent(Intent r100, Exception r101) {
        Log.e(TAG, "Invalid incoming intent.", new Object[]{r101});
        return r100.replaceExtras(null);
    }

    public static void logTransactionTooLargeOrRethrow(RuntimeException r100, Intent r101) {
        if ((r100.getCause() instanceof TransactionTooLargeException) == false) goto L6;
        Log.e(TAG, "Could not resolve Activity for intent " + r101.toString(), new Object[]{r100});
        return;
    L6:
        throw r100;
    }

    public static IBinder safeGetBinder(Bundle r100, String r101) {
        if (r100 != null) goto L9;
        return null;
    L9:
        return BundleCompat.getBinder(r100, r101);
    L7:
        Log.e(TAG, "getBinder failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static IBinder safeGetBinderExtra(Intent r100, String r101) {
        if (r100.hasExtra(r101) == true) goto L7;
        return null;
    L7:
        return safeGetBinder(r100.getExtras(), r101);
    }

    public static Bundle safeGetBundle(Bundle r100, String r101) {
        return r100.getBundle(r101);
    L4:
        Log.e(TAG, "getBundle failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static Bundle safeGetBundleExtra(Intent r100, String r101) {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_IntentUtils_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r100, r101);
    L4:
        Log.e(TAG, "getBundleExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static byte[] safeGetByteArrayExtra(Intent r100, String r101) {
        return r100.getByteArrayExtra(r101);
    L4:
        Log.e(TAG, "getByteArrayExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static float[] safeGetFloatArray(Bundle r100, String r101) {
        return r100.getFloatArray(r101);
    L4:
        Log.e(TAG, "getFloatArray failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static int[] safeGetIntArray(Bundle r100, String r101) {
        return r100.getIntArray(r101);
    L4:
        Log.e(TAG, "getIntArray failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static int[] safeGetIntArrayExtra(Intent r100, String r101) {
        return r100.getIntArrayExtra(r101);
    L4:
        Log.e(TAG, "getIntArrayExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static <T extends Parcelable> T safeGetParcelable(Bundle r100, String r101) {
        return (T) r100.getParcelable(r101);
    L4:
        Log.e(TAG, "getParcelable failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static Parcelable[] safeGetParcelableArrayExtra(Intent r100, String r101) {
        return r100.getParcelableArrayExtra(r101);
    L4:
        Log.e(TAG, "getParcelableArrayExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static <T extends Parcelable> ArrayList<T> safeGetParcelableArrayList(Bundle r100, String r101) {
        return r100.getParcelableArrayList(r101);
    L4:
        Log.e(TAG, "getParcelableArrayList failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent r100, String r101) {
        return (T) r100.getParcelableExtra(r101);
    L4:
        Log.e(TAG, "getParcelableExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static <T extends Serializable> T safeGetSerializableExtra(Intent r100, String r101) {
        return (T) r100.getSerializableExtra(r101);
    L7:
        e = move-exception;
        Log.e(TAG, "Invalide class for Serializable: " + r101, new Object[]{e});
        return null;
    L5:
        Log.e(TAG, "getSerializableExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static String safeGetString(Bundle r100, String r101) {
        return r100.getString(r101);
    L4:
        Log.e(TAG, "getString failed on bundle " + r100, new Object[0]);
        return null;
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent r100, String r101) {
        return r100.getStringArrayListExtra(r101);
    L4:
        Log.e(TAG, "getStringArrayListExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static String safeGetStringExtra(Intent r100, String r101) {
        return r100.getStringExtra(r101);
    L4:
        Log.e(TAG, "getStringExtra failed on intent " + r100, new Object[0]);
        return null;
    }

    public static boolean safeHasExtra(Intent r100, String r101) {
        return r100.hasExtra(r101);
    L4:
        Log.e(TAG, "hasExtra failed on intent " + r100, new Object[0]);
        return false;
    }

    public static void safeRemoveExtra(Intent r100, String r101) {
        r100.removeExtra(r101);     // Catch: Throwable -> L4
        return;
    L4:
        Log.e(TAG, "removeExtra failed on intent " + r100, new Object[0]);
    }

    public static boolean safeStartActivity(Context r100, Intent r101) {
        return safeStartActivity(r100, r101, null);
    }

    public static boolean safeGetBoolean(Bundle r100, String r101, boolean r102) {
        return r100.getBoolean(r101, r102);
    L4:
        Log.e(TAG, "getBoolean failed on bundle " + r100, new Object[0]);
        return r102;
    }

    public static boolean safeGetBooleanExtra(Intent r100, String r101, boolean r102) {
        return r100.getBooleanExtra(r101, r102);
    L4:
        Log.e(TAG, "getBooleanExtra failed on intent " + r100, new Object[0]);
        return r102;
    }

    public static int safeGetInt(Bundle r100, String r101, int r102) {
        return r100.getInt(r101, r102);
    L4:
        Log.e(TAG, "getInt failed on bundle " + r100, new Object[0]);
        return r102;
    }

    public static int safeGetIntExtra(Intent r100, String r101, int r102) {
        return r100.getIntExtra(r101, r102);
    L4:
        Log.e(TAG, "getIntExtra failed on intent " + r100, new Object[0]);
        return r102;
    }

    public static long safeGetLongExtra(Intent r100, String r101, long r102) {
        return r100.getLongExtra(r101, r102);
    L4:
        Log.e(TAG, "getLongExtra failed on intent " + r100, new Object[0]);
        return r102;
    }

    public static void safePutBinderExtra(Intent r100, String r101, IBinder r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r103 = new Bundle();
        BundleCompat.putBinder(r103, r101, r102);     // Catch: Throwable -> L7
    L8:
        r100.putExtras(r103);
        return;
    L7:
        Log.e(TAG, "putBinder failed on bundle " + r103, new Object[0]);
        goto L8
    }

    public static boolean safeStartActivity(Context r100, Intent r101, Bundle r102) {
        r100.startActivity(r101, r102);     // Catch: ActivityNotFoundException -> L5
        return true;
    L5:
        return false;
    }
}
