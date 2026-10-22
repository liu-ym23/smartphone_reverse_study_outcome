package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f271319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f271320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<pi7.g> f271321c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f271322a = null;

        static {
            f271322a = new i();
        }
    }

    public i() {
        this.f271321c = new ArrayList();
        this.f271319a = com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c("init_settings", "");
    }

    public static void a(i r100, boolean r101) {
        List<pi7.g> r102 = r100.f271321c;
        if (r102 == null) goto L26;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r100.f271321c).iterator();     // Catch: Throwable -> L17
    L8:
        if (r103.hasNext() == false) goto L15;
        pi7.g r104 = (pi7.g) r103.next();     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        if (r101 == false) goto L13;
        r104.onSuccess();     // Catch: Throwable -> L17
        goto L14
    L13:
        r104.onFailed();     // Catch: Throwable -> L17
    L14:
        r103.remove();     // Catch: Throwable -> L17
        goto L8
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final String b(String r100, String r101) {
    L13:
        return r101;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        JSONObject r102 = new JSONObject(this.f271319a);     // Catch: Throwable -> L13
        if (r102.has(r100) == true) goto L8;
        return r101;
    L8:
        JSONObject r103 = r102.optJSONObject(r100);     // Catch: Throwable -> L13
        if (r103 != null) goto L11;
        return r101;
    L11:
        return r103.optString("value", r101);
    }
}
