package com.bytedance.ee.bear.basesdk.business.comment;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/bean/At;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseCommentPlugin$init$5 extends Lambda implements Function1<bo4.a, Unit> {
    final /* synthetic */ a this$0;

    public BaseCommentPlugin$init$5(a r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(bo4.a r100) {
        StringBuilder r101 = new StringBuilder("mention select invoke, result is null? ");
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("BaseCommentPlugin", r101.toString());
        if (r100 != null) goto L9;
        return;
    L9:
        JSONObject r103 = new JSONObject();
        r103.put2("action", JSEventListener.ONMENTION);
        r103.put2("id", r100.f19815e);
        r103.put2("avatar_url", r100.f19816f);
        r103.put2("name", r100.f19819i);
        r103.put2("en_name", r100.f19820j);
        r103.put2("cn_name", r100.f19821k);
        r103.put2("union_id", r100.f19832v);
        r103.put2("department", r100.f19833w);
        a r104 = this.this$0;
        int r105 = a.f206587a;
        r104.getClass();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(bo4.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
