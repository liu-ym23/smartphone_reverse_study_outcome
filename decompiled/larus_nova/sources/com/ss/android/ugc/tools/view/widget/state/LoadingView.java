package com.ss.android.ugc.tools.view.widget.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/state/LoadingView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/widget/FrameLayout$LayoutParams;", "getProgressLayoutParams", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getProgress", "()Landroid/view/View;", "setProgress", "(Landroid/view/View;)V", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public class LoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f455140a;

    public final FrameLayout.LayoutParams getProgressLayoutParams() {
        View r100 = this.f455140a;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L11;
        r101 = r102;
    L11:
        return (FrameLayout.LayoutParams) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final View getProgress() {
        return this.f455140a;
    }

    public final void setProgress(View r100) {
        this.f455140a = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f455140a;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public LoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f455140a = LayoutInflater.from(r100).inflate(R.layout.tools_layout_loading, this, true).findViewById(R.id.double_loading_view);
    }
}
