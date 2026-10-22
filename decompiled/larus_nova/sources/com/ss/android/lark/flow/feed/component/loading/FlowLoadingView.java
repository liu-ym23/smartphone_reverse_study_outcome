package com.ss.android.lark.flow.feed.component.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001e\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/loading/FlowLoadingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingView", "Landroid/view/View;", "setLoadingView", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "lp", "Landroid/widget/FrameLayout$LayoutParams;", "hasLoadingContent", "", "clearLoadingView", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f423331a;

    public final void setLoadingView(View r100) {
        a(this, r100);
    }

    public FlowLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public FlowLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
    }

    public static void a(FlowLoadingView r100, View r101) {
        View r102 = r100.f423331a;
        int r103 = 8;
        if (r102 != r101) goto L8;
        if (r101 == null) goto L7;
        r103 = 0;
    L7:
        r100.setVisibility(r103);
        return;
    L8:
        if (r102 != null) goto L10;
    L12:
        r100.f423331a = r101;
        if (r101 != null) goto L15;
        r100.setVisibility(8);
        return;
    L15:
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L18;
        ViewGroup r105 = (ViewGroup) r104;
    L19:
        if (r105 == null) goto L21;
        r105.removeView(r101);
    L21:
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 17;
        r100.addView(r101, r106);
        r100.setVisibility(0);
        return;
    L18:
        r105 = null;
        goto L19
    L10:
        if (r102.getParent() != r100) goto L12;
        r100.removeView(r102);
        goto L12
    }
}
