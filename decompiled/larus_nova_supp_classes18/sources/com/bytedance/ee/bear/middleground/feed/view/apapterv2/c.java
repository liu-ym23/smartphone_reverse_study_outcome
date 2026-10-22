package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> a;
    public final /* synthetic */ Notice<BaseContent> b;

    public c(BaseFeedItemAdapter<BaseContent> r1, Notice<BaseContent> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Function5<String, String, String, Boolean, Notice<?>, Unit> r0 = this.a.a;
        String r1 = this.b.getClickType();
        HashMap<String, Context> r8 = cg5.a.a;
        r0.invoke(r1, cg5.a.a(this.b.getClickToast()), this.b.getNoticeId(), Boolean.valueOf(this.b.isGlobalComment()), this.b);
    }
}
