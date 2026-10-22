package com.bytedance.ee.bear.middleground.comment.export;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class l {
    public static final boolean a(Function1 r100) {
        LarkAppContext.Companion.getClass();
        boolean r101 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        boolean r102 = ((Boolean) r100.invoke(Boolean.valueOf(r101))).booleanValue();
        if (r102 == true) goto L13;
        if (r101 == false) goto L12;
        boolean r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.comment_voice_input_doubao");
        int r104 = CommentVoiceHostPolicy.f231338a;
        if (r102 == true) goto L13;
        if (r101 == false) goto L12;
        if (r103 == true) goto L13;
    L12:
        return false;
    L13:
        return true;
    }
}
