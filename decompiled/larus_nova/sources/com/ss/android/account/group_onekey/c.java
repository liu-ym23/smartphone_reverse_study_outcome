package com.ss.android.account.group_onekey;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f406291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Integer> f406292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f406293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, SoftReference<AuthorizeCallback>> f406294d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f406295e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, yqa.a> f406296f = null;

    static {
        f406291a = 10000;
        f406292b = new HashMap();
        f406293c = new HashMap();
        f406294d = new HashMap();
        f406295e = new Handler(Looper.getMainLooper());
        f406296f = new HashMap();
    }

    public static void a(String r110, Intent r111, boolean r112) {
        long r100 = System.currentTimeMillis();
        f406295e.removeCallbacksAndMessages(null);
        String r101 = f406293c.remove(r110);
        SoftReference<AuthorizeCallback> r102 = f406294d.remove(r110);
        f406292b.remove(r110);
        yqa.a r103 = f406296f.remove(r110);
        if (r102 == null) goto L31;
        AuthorizeCallback r104 = r102.get();
        if (r104 == null) goto L32;
        int r105 = r111.getIntExtra("code", -1);
        String r106 = r111.getStringExtra(ITwitterService.ResponseConstants.AUTH_TOKEN);
        long r113 = 0;
        if (r105 != 0) goto L19;
        if (r106 != null) goto L10;
    L13:
        boolean r114 = true;
    L14:
        if (r114 == true) goto L19;
        Bundle r107 = new Bundle();
        r107.putString(ITwitterService.ResponseConstants.AUTH_TOKEN, r106);
        r107.putString("token_verifier", r101);
        r107.putBundle("server_app_original_result", r111.getExtras());
        if (r103 == null) goto L18;
        r113 = r103.f568877a;
    L18:
        r107.putLong("monitor_start_activity_time", r113);
        r107.putLong("monitor_server_app_callback_time", r100);
        r104.onSuccess(r107);
        return;
    L10:
        if (r106.length() == 0) goto L13;
        r114 = false;
    L19:
        String r108 = r111.getStringExtra("message");
        Bundle r109 = r111.getExtras();
        if (r109 != null) goto L22;
    L24:
        if (r112 == false) goto L26;
        r105 = -10;
        r108 = "user cancel";
    L26:
        AuthorizeErrorResponse r115 = new AuthorizeErrorResponse(r105, r108);
        r115.isCancel = r112;
        Bundle r116 = new Bundle();
        r116.putBundle("server_app_original_result", r111.getExtras());
        if (r103 == null) goto L29;
        r113 = r103.f568877a;
    L29:
        r116.putLong("monitor_start_activity_time", r113);
        r116.putLong("monitor_server_app_callback_time", r100);
        r115.extras = r116;
        r104.onError(r115);
        return;
    L22:
        if (r109.isEmpty() != true) goto L24;
        r108 = "result intent is empty";
        goto L24
    L32:
        return;
    }
}
