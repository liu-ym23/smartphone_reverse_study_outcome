package com.ss.android.lark.profile.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f438852a = 0;

    static {
    }

    public static void a(final Context r100, final String r110, final Serializable r111) {
        final Fragment r101 = null;
        final String r102 = null;
        final String r103 = null;
        final boolean r104 = false;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "contactSource");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isMempopeApp() == false) goto L6;
        Log.i("ProfileJumpUtilsExport", "profile is disabled in mempope");
        return;
    L6:
        if (TextUtils.isEmpty(r110) == true) goto L8;
    L10:
        Log.i("ProfileJumpUtilsExport", "open profile by router");
        UICallbackExecutor.execute(new ProfileJumpUtilsExport$openUserProfile$1(r110, r111, r102, r103, r101, r100, r104));
        return;
    L8:
        if (TextUtils.isEmpty(null) == false) goto L10;
        Log.e("ProfileJumpUtilsExport", "userId and Token are null");
    }
}
