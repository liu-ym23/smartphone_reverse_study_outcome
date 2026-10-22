package com.bytedance.ee.bear.document.multitask;

import android.R;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.ss.android.lark.slideback.SlideFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/multitask/MultiTaskPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "TAG", "", "disableMultiTaskSlide", "", "enableMultiTaskSlide", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskPlugin extends DocumentPlugin {
    private final String TAG;

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void disableMultiTaskSlide() {
        tt5.a.h(this.TAG, "disableMultiTaskSlide()...");
        FragmentActivity r0 = getActivity();
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(R.id.content);
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getParent();
    L9:
        if ((r1 instanceof SlideFrameLayout) == false) goto L12;
        tt5.a.h(this.TAG, "SlideFrameLayout exist, setCanSlide = false");
        SlideFrameLayout r3 = r2.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.slideback.SlideFrameLayout");
        r3.setSlideable(false);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void enableMultiTaskSlide() {
        tt5.a.h(this.TAG, "enableMultiTaskSlide()...");
        FragmentActivity r0 = getActivity();
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(R.id.content);
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getParent();
    L9:
        if ((r1 instanceof SlideFrameLayout) == false) goto L12;
        SlideFrameLayout r3 = r2.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.slideback.SlideFrameLayout");
        r3.setSlideable(true);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public MultiTaskPlugin() {
        this.TAG = "MultiTaskPlugin";
    }
}
