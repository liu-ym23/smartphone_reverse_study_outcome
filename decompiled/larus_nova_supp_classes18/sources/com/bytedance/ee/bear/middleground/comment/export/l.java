package com.bytedance.ee.bear.middleground.comment.export;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public static final boolean a(Function1 r3) {
        LarkAppContext.Companion.getClass();
        boolean r0 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        boolean r4 = ((Boolean) r3.invoke(Boolean.valueOf(r0))).booleanValue();
        if (r4 == true) goto L13;
        if (r0 == false) goto L12;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.comment_voice_input_doubao");
        int r2 = CommentVoiceHostPolicy.a;
        if (r4 == true) goto L13;
        if (r0 == false) goto L12;
        if (r1 == true) goto L13;
    L12:
        return false;
    L13:
        return true;
    }
}
