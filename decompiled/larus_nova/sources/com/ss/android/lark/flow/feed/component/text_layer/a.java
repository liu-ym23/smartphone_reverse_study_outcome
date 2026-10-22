package com.ss.android.lark.flow.feed.component.text_layer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FeedCardComponent<C4997a, FlowTextLayerView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f423348c;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.text_layer.a$a, reason: collision with other inner class name */
    public static final class C4997a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f423349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f423350b;

        public C4997a(boolean r100, int r101) {
            this.f423349a = r100;
            this.f423350b = r101;
        }
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FlowTextLayerView(getContext());
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        r100.gravity = 16;
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.f423348c;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f423348c = r100;
    }
}
