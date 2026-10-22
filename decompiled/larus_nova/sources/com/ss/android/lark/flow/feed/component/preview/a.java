package com.ss.android.lark.flow.feed.component.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.cardcomponent.preview.c;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FeedCardComponent<C4996a, FlowPreviewView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f423338c;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.preview.a$a, reason: collision with other inner class name */
    public static final class C4996a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f423339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.feed.cardcomponent.preview.a.b f423340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.flow.feed.component.text_layer.a.C4997a f423341c;

        public C4996a(com.ss.android.lark.feed.cardcomponent.preview.a.b r100, com.ss.android.lark.flow.feed.component.text_layer.a.C4997a r101) {
            this(c.f420946g, r100, r101);
        }

        public C4996a(c r100, com.ss.android.lark.feed.cardcomponent.preview.a.b r101, com.ss.android.lark.flow.feed.component.text_layer.a.C4997a r102) {
            Intrinsics.checkNotNullParameter(r100, "reactionParam");
            Intrinsics.checkNotNullParameter(r101, "digestParams");
            this.f423339a = r100;
            this.f423340b = r101;
            this.f423341c = r102;
        }
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        FlowPreviewView r100 = new FlowPreviewView(getContext());
        r100.setGravity(16);
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        ViewGroup.MarginLayoutParams r100 = super.b();
        r100.height = UIUtils.dp2px(getContext(), 22.0f);
        r100.width = 0;
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.f423338c;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f423338c = r100;
    }

    public final void d(C4996a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c().a(r100.f423339a, r100.f423340b, r100.f423341c);
    }
}
