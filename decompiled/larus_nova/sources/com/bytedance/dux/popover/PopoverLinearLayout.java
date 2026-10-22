package com.bytedance.dux.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/dux/popover/PopoverLinearLayout;", "Landroid/widget/LinearLayout;", "", "pressed", "", "setPressed", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getLimitLargeFontScale", "()Z", "setLimitLargeFontScale", "(Z)V", "limitLargeFontScale", "dux_release"}, k = 1, mv = {1, 7, 1})
public class PopoverLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205461a;

    public PopoverLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public PopoverLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final boolean getLimitLargeFontScale() {
        return this.f205461a;
    }

    public final void setLimitLargeFontScale(boolean r100) {
        this.f205461a = r100;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        if (r100 == false) goto L5;
        setAlpha(0.66f);
        return;
    L5:
        setAlpha(1.0f);
    }

    public PopoverLinearLayout(Context r100, AttributeSet r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205461a = r102;
    }

    public /* synthetic */ PopoverLinearLayout(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, false);
    }
}
