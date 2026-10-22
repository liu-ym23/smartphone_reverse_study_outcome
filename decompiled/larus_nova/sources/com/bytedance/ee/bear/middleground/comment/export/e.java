package com.bytedance.ee.bear.middleground.comment.export;

import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes18.dex */
public final class e {
    static {
    }

    public static boolean a() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.mobile.comment_voice_input_disable_legacy_session_bug");
        tt5.a.h("CommentVoiceInputFG", "disableLegacyVoiceInputSessionBug=" + r100);
        return r100;
    }

    public static CommentVoiceHostPolicy.Route c() {
        LarkAppContext.Companion.getClass();
        boolean r100 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        boolean r101 = false;
        if (r100 == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == true) goto L10;
    L12:
        int r103 = CommentVoiceHostPolicy.f231338a;
        if (r100 == false) goto L16;
        if (r101 == false) goto L16;
        CommentVoiceHostPolicy.Route r104 = CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT;
    L20:
        tt5.a.h("CommentVoiceInputFG", "route=" + r104 + ", isOfficeSDK=" + r100);
        return r104;
    L16:
        if (r100 == true) goto L19;
        if (r102 == false) goto L19;
        r104 = CommentVoiceHostPolicy.Route.LARK_IM;
    L19:
        r104 = CommentVoiceHostPolicy.Route.DISABLED;
        goto L20
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.comment_voice_input_doubao") == false) goto L12;
        r101 = true;
        goto L12
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.comment_voice_input_upgrade") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean b() {
        if (c() == CommentVoiceHostPolicy.Route.DISABLED) goto L5;
        return true;
    L5:
        return false;
    }
}
