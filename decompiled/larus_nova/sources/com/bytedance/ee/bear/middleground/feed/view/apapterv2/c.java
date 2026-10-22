package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> f232704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Notice<BaseContent> f232705b;

    public c(BaseFeedItemAdapter<BaseContent> r100, Notice<BaseContent> r101) {
        this.f232704a = r100;
        this.f232705b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function5<String, String, String, Boolean, Notice<?>, Unit> r101 = this.f232704a.f232687a;
        String r102 = this.f232705b.getClickType();
        HashMap<String, Context> r103 = cg5.a.f23672a;
        r101.invoke(r102, cg5.a.a(this.f232705b.getClickToast()), this.f232705b.getNoticeId(), Boolean.valueOf(this.f232705b.isGlobalComment()), this.f232705b);
    }
}
