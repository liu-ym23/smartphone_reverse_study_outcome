package com.bytedance.applet.aibridge.permission;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.s;
import uv3.l;
import uv3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements g1.c {
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b a;
    public final /* synthetic */ RequestPermissionMethod b;
    public final /* synthetic */ Function0<Boolean> c;

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
        final boolean r0 = ((Boolean) this.c.invoke()).booleanValue();
        if (r0 == false) goto L5;
        String r1 = CommentScene.COMMENTSCENE_NO_AWEME;
    L6:
        s.c(r1);
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " return from setting page, result: " + r0);
        final RequestPermissionMethod r2 = this.b;
        final AbsRequestPermissionMethodIDL.b r3 = this.a;
        Function0 r4 = new m(r2, r3, r0);
        int r5 = RequestPermissionMethod.b;
        r2.getClass();
        RequestPermissionMethod.d(r4);
        return;
    L5:
        r1 = "0";
        goto L6
    }

    public final void onGoSettingsDialogDismiss(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "authorize";
    L5:
        JSONObject r1 = this.a.getTraceInfo();
        if (r1 != null) goto L8;
        r1 = new JSONObject();
    L8:
        s.a("set_up_popup", "system_request_permission_again", r0, r1);
        if (r5 == true) goto L12;
        s.c("0");
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onGoSettingsDialogRefused");
        return;
    L12:
        return;
    L4:
        r0 = "next_time";
        goto L5
    }

    public c(AbsRequestPermissionMethodIDL.b r1, RequestPermissionMethod r2, uv3.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r5 == false) goto L9;
        JSONObject r6 = this.a.getTraceInfo();
        if (r6 != null) goto L7;
        r6 = new JSONObject();
    L7:
        s.b("set_up_popup", "system_request_permission_again", r6);
        return;
    L9:
        if (r2 == false) goto L11;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L12:
        s.c(r7);
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onResult: " + r2);
        if (r2 == false) goto L16;
        final RequestPermissionMethod r8 = this.b;
        final AbsRequestPermissionMethodIDL.b r9 = this.a;
        Function0 r10 = new l(r8, r9);
        int r11 = RequestPermissionMethod.b;
        r8.getClass();
        RequestPermissionMethod.d(r10);
        return;
    L16:
        return;
    L11:
        r7 = "0";
        goto L12
    }
}
