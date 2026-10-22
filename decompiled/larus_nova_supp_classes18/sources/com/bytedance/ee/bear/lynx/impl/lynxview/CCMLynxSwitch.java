package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import fe5.g;
import fe5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxSwitch;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "udSwitch", "Lcom/bytedance/ee/bear/lynx/impl/lynxview/CustomSwitch;", "createView", "context", "Landroid/content/Context;", "setChecked", "", "isChecked", "", "setEnable", "isEnable", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxSwitch extends LynxUI<FrameLayout> {
    public j a;

    public static final class a {
    }

    static {
    }

    public CCMLynxSwitch(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxContext");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View] */
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new FrameLayout(r5);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        this.a = new j(r5);
        r0.setOnClickListener(new g(this));
        r1.gravity = 17;
        UDSwitch r6 = this.a;
        ?? r2 = 0;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r6 = null;
    L5:
        r6.setLayoutParams(r1);
        j r7 = this.a;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
    L9:
        r0.addView(r2, r1);
        return r0;
    L8:
        r2 = r7;
        goto L9
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "is-on")
    public final void setChecked(boolean r3) {
        tt5.a.h("CCMLynxSwitch", "isChecked = " + r3);
        j r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r0 = null;
    L5:
        r0.setChecked(r3);
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "is-enabled")
    public final void setEnable(boolean r3) {
        tt5.a.h("CCMLynxSwitch", "setEnable = " + r3);
        UDSwitch r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r0 = null;
    L5:
        r0.setEnabled(r3);
    }
}
