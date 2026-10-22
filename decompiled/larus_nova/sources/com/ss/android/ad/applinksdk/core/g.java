package com.ss.android.ad.applinksdk.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.ad.applinksdk.core.activity.TTDelegateActivity;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406364a = 0;

    static {
    }

    public static AppLinkResult a(Context r100, Intent r101, ira.e r102) {
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L33;
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        return new AppLinkResult(-1, 14);
    L33:
        if (r101 != null) goto L13;
        AppLinkResult.Type.Companion.getClass();     // Catch: Exception -> L29
        AppLinkResult.Message.Companion.getClass();     // Catch: Exception -> L29
        return new AppLinkResult(-1, 13);
    L13:
        if (mra.c.a().optInt("enable_delegate_activity", 0) != 0) goto L23;
        ira.b r104 = r102.f495542a;     // Catch: Exception -> L29
        if (r104 == null) goto L23;
        if (r104.f495503a != true) goto L23;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        List<Object> r105 = jra.a.f500155a;     // Catch: Exception -> L29
        if (jra.a.a() == false) goto L23;
        TTDelegateActivity.f406353a.getClass();     // Catch: Exception -> L29
        d.f406360e.getClass();     // Catch: Exception -> L29
        r100.startActivity(r101);     // Catch: Exception -> L29
    L24:
        r102.getClass();     // Catch: Exception -> L29
        r102.f495547f = System.currentTimeMillis();     // Catch: Exception -> L29
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        return new AppLinkResult(1, 10);
    L23:
        d.f406360e.getClass();     // Catch: Exception -> L29
        r100.startActivity(r101);     // Catch: Exception -> L29
    L29:
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        return new AppLinkResult(-1, 13);
    L5:
        if (r100.getPackageManager().queryIntentActivities(r101, 65536).size() <= 0) goto L7;
        r103 = true;
        goto L9
    }

    public static AppLinkResult b(String r100, Context r101, ira.e r102) {
        int r103 = r102.f495545d.f495539o;
        if (r100 == null) goto L5;
        Uri r104 = UriProtector.parse(r100);
        Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r105.setData(r104);
        r105.addFlags(r103);
        r105.putExtra("open_url", r100);
        r105.putExtra("start_only_for_android", true);
    L7:
        return a(r101, r105, r102);
    L5:
        r105 = null;
        goto L7
    }
}
