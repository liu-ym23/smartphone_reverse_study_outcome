package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013R?\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/bdp/appbase/base/ui/viewwindow/ViewWindowContainer;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", PerfLog.PARAM_KEY_CONTEXT_ID, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function1;", "getOnAttachedToWindowListener", "()Lkotlin/jvm/functions/Function1;", "setOnAttachedToWindowListener", "(Lkotlin/jvm/functions/Function1;)V", "onAttachedToWindowListener", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bdp-appbase_release"}, k = 1, mv = {1, 4, 0})
public final class ViewWindowContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Context, Unit> f200621a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Function1<? super Context, Unit> r100 = this.f200621a;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke(getContext());
        return;
    }

    public final Function1<Context, Unit> getOnAttachedToWindowListener() {
        return this.f200621a;
    }

    public ViewWindowContainer(Context r100) {
        super(r100);
    }

    public final void setOnAttachedToWindowListener(Function1<? super Context, Unit> r100) {
        this.f200621a = r100;
    }

    public ViewWindowContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
