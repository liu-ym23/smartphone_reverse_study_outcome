package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/layout/BaseContainerLayout;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleOwner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "viewLifecycle$delegate", "Lkotlin/Lazy;", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "inflateFullLayout", "", "layoutId", "inflateCommonLayout", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/CommonContainerLayout;", "partialLayoutRes", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseContainerLayout extends FrameLayout implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f423858a;

    public BaseContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Lifecycle getViewLifecycle() {
        return (Lifecycle) this.f423858a.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return getViewLifecycle();
    }

    public final void a(int r100) {
        ViewStub r101 = (ViewStub) findViewById(R.id.vs_full_layout);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L5;
        ((FrameLayout.LayoutParams) r102).gravity = 1;
    L6:
        r101.setLayoutResource(r100);
        r101.inflate();
        return;
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r103 = getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r103).gravity = 1;
        goto L6
    }

    public BaseContainerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f423858a = LazyKt.lazy(new BaseContainerLayout$viewLifecycle$2(this));
        View.inflate(r100, R.layout.signin_sdk_common_base_container, this);
        if (getId() != (-1)) goto L6;
        setId(R.id.signin_sdk_widget_root_container);
        return;
    }

    public /* synthetic */ BaseContainerLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
