package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f434401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f434402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f434403c;

    public static final class a {
        public static String a(int r100, boolean r101) {
            Intrinsics.checkNotNullParameter("", "tenantId");
            JSONObject r102 = new JSONObject();
            if (r100 != 2) goto L5;
            r102.put("call_type", "meeting");
        L7:
            if (r101 == false) goto L9;
            r102.put("user_type", "host");
        L10:
            r102.put("tenant_id", "");
            return r102.toString();
        L9:
            r102.put("user_type", "attendee");
            goto L10
        L5:
            r102.put("call_type", NotificationCompat.CATEGORY_CALL);
            goto L7
        }
    }

    static {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("", "tenantId");
        Intrinsics.checkNotNullParameter("", "interactiveId");
        Intrinsics.checkNotNullParameter("", "appVersion");
        JSONObject r100 = this.f434402b;
        if (r100 == null) goto L5;
        r100.put("tenant_id", "");
    L5:
        JSONObject r101 = this.f434402b;
        if (r101 == null) goto L8;
        r101.put("interactive_id", "");
    L8:
        JSONObject r102 = this.f434402b;
        if (r102 == null) goto L12;
        r102.put("app_version", "");
        return;
    }

    public d() {
        this.f434403c = "0";
    }
}
