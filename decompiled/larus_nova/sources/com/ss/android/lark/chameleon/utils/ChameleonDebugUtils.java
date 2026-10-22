package com.ss.android.lark.chameleon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.storage.IKVStorage;
import com.ss.android.lark.chameleon.storage.SPKVStore;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/utils/ChameleonDebugUtils;", "", "()V", "DEBUG_VIEW_TAG", "", "KEY_DISABLE_DEBUG_VIEW", "KEY_DISABLE_OFFLINE_RES", "KEY_SPECIFIC_BIZNAME", "KEY_SPECIFIC_RES_PATH", "KEY_SPECIFIC_VERSION", "TAG", "addDebugEntry", "", "viewGroup", "Landroid/view/ViewGroup;", "intervalMs", "", "clickCounts", "", "addDebugView", "config", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "generateDebugInfo", "getActivityFromContext", "Landroid/app/Activity;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getOfflineResVersion", "chameleonConfig", "getSpecificBizname", "getSpecificResPath", "getSpecificVersion", "isDebugViewDisabled", "", "isOfflineResDisabled", "startDebugActivity", "activity", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonDebugUtils {
    private static final String DEBUG_VIEW_TAG = "chameleon_debug_view";
    public static final ChameleonDebugUtils INSTANCE = null;
    private static final String KEY_DISABLE_DEBUG_VIEW = "chameleon_disable_debug_view";
    private static final String KEY_DISABLE_OFFLINE_RES = "chameleon_disable_offline_res";
    private static final String KEY_SPECIFIC_BIZNAME = "chameleon_specific_bizname";
    private static final String KEY_SPECIFIC_RES_PATH = "chameleon_specific_res_path";
    private static final String KEY_SPECIFIC_VERSION = "chameleon_specific_version";
    private static final String TAG = "ChameleonDebugUtils";

    static {
        INSTANCE = new ChameleonDebugUtils();
    }

    private ChameleonDebugUtils() {
    }

    private final String getSpecificVersion() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_VERSION, null, 2, null);
    }

    private final boolean isDebugViewDisabled() {
        return SPKVStore.INSTANCE.getBoolean(KEY_DISABLE_DEBUG_VIEW, false);
    }

    public final String getSpecificBizname() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_BIZNAME, null, 2, null);
    }

    public final String getSpecificResPath() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_RES_PATH, null, 2, null);
    }

    public final boolean isOfflineResDisabled() {
        return SPKVStore.INSTANCE.getBoolean(KEY_DISABLE_OFFLINE_RES, false);
    }

    private final String generateDebugInfo(ChameleonConfig r110) {
        if (isDebugViewDisabled() == false) goto L5;
        return null;
    L5:
        if (r110 != null) goto L7;
    L27:
        return null;
    L7:
        if (TextUtils.isEmpty(r110.getBizName()) == true) goto L27;
        ArrayList r100 = new ArrayList();
        if (isOfflineResDisabled() == true) goto L23;
        if (Intrinsics.areEqual(getSpecificBizname(), r110.getBizName()) == false) goto L23;
        String r101 = getSpecificVersion();
        if (r101 != null) goto L16;
    L19:
        boolean r102 = true;
    L20:
        if (r102 == true) goto L23;
        r100.add("离线资源版本: " + getSpecificVersion());
        goto L23
    L16:
        if (r101.length() == 0) goto L19;
        r102 = false;
    L23:
        if (r100.isEmpty() == false) goto L26;
        return null;
    L26:
        return "调试:" + r110.getBizName() + '\n' + CollectionsKt.joinToString$default(r100, "\n", null, null, 0, null, null, 62, null);
    }

    private final Activity getActivityFromContext(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        if ((r100 instanceof Activity) == true) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L6
    L10:
        return (Activity) r100;
    L12:
        return null;
    }

    public final String getOfflineResVersion(ChameleonConfig r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getBizName();
    L6:
        if (Env.isDebug() == false) goto L22;
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L22;
        if (isOfflineResDisabled() == false) goto L18;
        return "";
    L18:
        String r103 = getSpecificResPath();
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
    L22:
        return "";
    L4:
        r101 = null;
        goto L6
    }

    public final void startDebugActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intent r101 = new Intent("com.ss.android.lark.ACTION_CML_DEBUG");     // Catch: Exception -> L7
        r101.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L7
        r101.addFlags(268435456);     // Catch: Exception -> L7
        r101.setPackage(r100.getPackageName());     // Catch: Exception -> L7
        if (r101.resolveActivity(r100.getPackageManager()) == null) goto L10;
        r100.startActivity(r101);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public static final /* synthetic */ Activity access$getActivityFromContext(ChameleonDebugUtils r100, Context r101) {
        return r100.getActivityFromContext(r101);
    }

    public final void addDebugView(ChameleonConfig r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        Context r102 = r101.getContext();
        if (r102 != null) goto L6;
        return;
    L6:
        if (((TextView) r101.findViewWithTag(DEBUG_VIEW_TAG)) == null) goto L8;
        return;
    L8:
        TextView r103 = new TextView(r102);
        r103.setText(INSTANCE.generateDebugInfo(r100));
        r103.setTag(DEBUG_VIEW_TAG);
        r103.setTextColor(-1);
        r103.setBackgroundColor(r102.getResources().getColor(R.color.chameleon_debug_bg_color));
        r103.setTextSize(12.0f);
        if ((r101 instanceof FrameLayout) == false) goto L12;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 8388661;
        ViewGroup.MarginLayoutParams r105 = r104;
    L15:
        r105.setMargins(40, 40, 40, 40);
        r103.setLayoutParams(r105);
        r101.addView(r103);
        return;
    L12:
        if ((r101 instanceof ConstraintLayout) == false) goto L14;
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(-2, -2);
        r106.endToEnd = 0;
        r106.bottomToBottom = 0;
        r105 = r106;
        goto L15
    L14:
        r105 = new ViewGroup.MarginLayoutParams(-2, -2);
        goto L15
    }

    public final void addDebugEntry(ViewGroup r100, final long r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        final Context r103 = r100.getContext();
        if (r103 != null) goto L5;
        return;
    L5:
        View r104 = new ChameleonDebugUtils$addDebugEntry$transparentView$1(r103, r101, r102);
        r104.setBackgroundColor(0);
        r104.setClickable(false);
        r100.addView(r104, -1, -1);
    }

    public static /* synthetic */ void addDebugEntry$default(ChameleonDebugUtils r100, ViewGroup r101, long r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 1000;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 5;
    L8:
        r100.addDebugEntry(r101, r102, r103);
    }
}
