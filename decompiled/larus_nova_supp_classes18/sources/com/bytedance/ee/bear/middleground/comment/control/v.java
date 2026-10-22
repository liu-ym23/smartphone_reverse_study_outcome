package com.bytedance.ee.bear.middleground.comment.control;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements com.bytedance.ee.bear.rn.g.a {
    public final /* synthetic */ Function1<String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Function1<? super String, Unit> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.rn.g.a
    public final void a(String r3) {
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L5;
        tt5.a.b("Comment#DataControlRNImpl", "setPushListener - didReceiveCommentData, data: " + r3);
    L5:
        if (r3 == null) goto L8;
        this.a.invoke(r3);
        return;
    }
}
