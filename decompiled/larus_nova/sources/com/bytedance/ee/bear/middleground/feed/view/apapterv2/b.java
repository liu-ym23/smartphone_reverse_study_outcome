package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> f232701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f232702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Notice<BaseContent> f232703c;

    public b(BaseFeedItemAdapter<BaseContent> r100, int r101, Notice<BaseContent> r102) {
        this.f232701a = r100;
        this.f232702b = r101;
        this.f232703c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        BaseFeedItemAdapter<BaseContent> r101 = this.f232701a;
        Intrinsics.checkNotNull(r100);
        return r101.a(r100, this.f232702b, this.f232703c);
    }
}
