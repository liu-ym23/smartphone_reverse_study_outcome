package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Notice<BaseContent> c;

    public b(BaseFeedItemAdapter<BaseContent> r1, int r2, Notice<BaseContent> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        BaseFeedItemAdapter<BaseContent> r0 = this.a;
        Intrinsics.checkNotNull(r4);
        return r0.a(r4, this.b, this.c);
    }
}
