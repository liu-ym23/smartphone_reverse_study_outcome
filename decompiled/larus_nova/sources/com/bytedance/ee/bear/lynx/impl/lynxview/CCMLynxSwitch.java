package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import fe5.g;
import fe5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxSwitch;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "udSwitch", "Lcom/bytedance/ee/bear/lynx/impl/lynxview/CustomSwitch;", "createView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setChecked", "", "isChecked", "", "setEnable", "isEnable", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxSwitch extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f229876a;

    public static final class a {
    }

    static {
    }

    public CCMLynxSwitch(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxContext");
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        this.f229876a = new j(r100);
        r101.setOnClickListener(new g(this));
        r102.gravity = 17;
        j r103 = this.f229876a;
        j r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r103 = null;
    L5:
        r103.setLayoutParams(r102);
        j r105 = this.f229876a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
    L9:
        r101.addView(r104, r102);
        return r101;
    L8:
        r104 = r105;
        goto L9
    }

    @LynxProp(defaultBoolean = false, name = "is-on")
    public final void setChecked(boolean r100) {
        tt5.a.h("CCMLynxSwitch", "isChecked = " + r100);
        j r101 = this.f229876a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r101 = null;
    L5:
        r101.setChecked(r100);
    }

    @LynxProp(defaultBoolean = false, name = "is-enabled")
    public final void setEnable(boolean r100) {
        tt5.a.h("CCMLynxSwitch", "setEnable = " + r100);
        j r101 = this.f229876a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r101 = null;
    L5:
        r101.setEnabled(r100);
    }
}
