package com.obric.assistant.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c0 {
    public static final void a(FlowCommonAppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getResources().getConfiguration().uiMode & 48;
        String r102 = r100.getIntent().getStringExtra("theme_source");
        if (r102 != null) goto L5;
        r102 = "assistant";
    L5:
        boolean r103 = true;
        int r104 = -1;
        if (Intrinsics.areEqual(r102, CameraParam.TYPE_SYSTEM_CAMERA) == true) goto L14;
        int r105 = AppCompatDelegate.getDefaultNightMode();
        if (r105 == (-1)) goto L13;
        if (r105 == 1) goto L13;
        if (r105 != 2) goto L14;
    L13:
        r104 = r105;
    L14:
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L17;
    L20:
        FLogger.f375446a.d(r100.getClass().getSimpleName(), "applyObricSettingThemeFromIntent themeSource=" + r102 + ", targetNightMode=" + r104 + ", isNightMode=" + r103);
        r100.getDelegate().setLocalNightMode(r104);
        boolean r106 = v19.h.f552477a;
        v19.h.f552477a = r103;
        return;
    L17:
        if (r101 == 32) goto L20;
    L19:
        r103 = false;
        goto L20
    }

    public static final String c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        if (r101 == null) goto L11;
        Intent r102 = r101.getIntent();
        if (r102 == null) goto L11;
        String r103 = r102.getStringExtra("theme_source");
        if (r103 == null) goto L11;
        return r103;
    L11:
        return "assistant";
    L5:
        r101 = null;
        goto L6
    }

    public static final void b(Intent r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L5;
        String r102 = c(r101);
    L6:
        r100.putExtra("theme_source", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
