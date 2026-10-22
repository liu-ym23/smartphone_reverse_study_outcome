package com.bytedance.locallife.live.userinfo.title.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/live/userinfo/title/view/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/locallife/live/userinfo/title/view/GradientTextView$a;", "value", "linearGradientCreator", "Lcom/bytedance/locallife/live/userinfo/title/view/GradientTextView$a;", "getLinearGradientCreator", "()Lcom/bytedance/locallife/live/userinfo/title/view/GradientTextView$a;", "setLinearGradientCreator", "(Lcom/bytedance/locallife/live/userinfo/title/view/GradientTextView$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f260644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f260645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260646c;

    public interface a {
    }

    public GradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final a getLinearGradientCreator() {
        return null;
    }

    public final void setLinearGradientCreator(a r100) {
        this.f260644a = true;
        requestLayout();
    }

    public GradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f260644a = true;
    }

    public /* synthetic */ GradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f260644a == false) goto L5;
    L8:
        getPaint().setShader(null);
        this.f260645b = getWidth();
        this.f260646c = getHeight();
        this.f260644a = false;
        return;
    L5:
        if (this.f260645b != getWidth()) goto L8;
        if (this.f260646c != getHeight()) goto L8;
    }
}
