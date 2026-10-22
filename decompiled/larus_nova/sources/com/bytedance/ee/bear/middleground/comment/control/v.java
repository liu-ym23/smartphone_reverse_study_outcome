package com.bytedance.ee.bear.middleground.comment.control;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements com.bytedance.ee.bear.rn.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f231251a;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Function1<? super String, Unit> r100) {
        this.f231251a = r100;
    }

    @Override // com.bytedance.ee.bear.rn.g.a
    public final void a(String r100) {
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L5;
        tt5.a.b("Comment#DataControlRNImpl", "setPushListener - didReceiveCommentData, data: " + r100);
    L5:
        if (r100 == null) goto L8;
        this.f231251a.invoke(r100);
        return;
    }
}
