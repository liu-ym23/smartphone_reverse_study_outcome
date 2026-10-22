package com.bytedance.ee.bear.middleground.comment.export;

import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    static {
    }

    public static boolean a() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.comment_voice_input_disable_legacy_session_bug");
        tt5.a.h("CommentVoiceInputFG", "disableLegacyVoiceInputSessionBug=" + r0);
        return r0;
    }

    public static CommentVoiceHostPolicy.Route c() {
        LarkAppContext.Companion.getClass();
        boolean r0 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        boolean r1 = false;
        if (r0 == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r0 == true) goto L10;
    L12:
        int r2 = CommentVoiceHostPolicy.a;
        if (r0 == false) goto L16;
        if (r1 == false) goto L16;
        CommentVoiceHostPolicy.Route r4 = CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT;
    L20:
        tt5.a.h("CommentVoiceInputFG", "route=" + r4 + ", isOfficeSDK=" + r0);
        return r4;
    L16:
        if (r0 == true) goto L19;
        if (r3 == false) goto L19;
        r4 = CommentVoiceHostPolicy.Route.LARK_IM;
    L19:
        r4 = CommentVoiceHostPolicy.Route.DISABLED;
        goto L20
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.comment_voice_input_doubao") == false) goto L12;
        r1 = true;
        goto L12
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.comment_voice_input_upgrade") == false) goto L7;
        r3 = true;
        goto L8
    }

    public static boolean b() {
        if (c() == CommentVoiceHostPolicy.Route.DISABLED) goto L5;
        return true;
    L5:
        return false;
    }
}
