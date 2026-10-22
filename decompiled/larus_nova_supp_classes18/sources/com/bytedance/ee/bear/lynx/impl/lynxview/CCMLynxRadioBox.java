package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import fe5.f;
import fe5.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0007R\u001a\u0010\u0007\u001a\u00020\bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxRadioBox;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "udCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getUdCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setUdCheckBox", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "createView", "context", "Landroid/content/Context;", "setChecked", "", "isChecked", "", "setEnable", "isEnable", "setLargeSize", "isLargeSize", "setType", ResourceData.KEY_TYPE, "", "setClickable", "clickable", "setUnCheckBackgroundColor", "color", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CCMLynxRadioBox extends LynxUI<FrameLayout> {
    public UDCheckBox a;

    public static final class a {
    }

    static {
    }

    public final UDCheckBox M() {
        UDCheckBox r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("udCheckBox");
        return null;
    }

    public CCMLynxRadioBox(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxContext");
        super(r2);
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FrameLayout r0 = new FrameLayout(r4);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        i r2 = new i(r4);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
        M().setType(UDCheckBox.CheckBoxType.RADIO);
        M().setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
        r0.setOnClickListener(new f(this));
        r1.gravity = 17;
        M().setLayoutParams(r1);
        r0.addView(M(), r1);
        return r0;
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "is-checked")
    public final void setChecked(boolean r3) {
        tt5.a.h("CCMLynxRadioBox", "isChecked = " + r3);
        M().setChecked(r3);
    }

    @LynxProp(name = "clickable")
    public final void setClickable(boolean r2) {
        UDCheckBox r0 = M();
        if (r0 == null) goto L6;
        r0.setClickable(r2);
        return;
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "is-enabled")
    public final void setEnable(boolean r3) {
        tt5.a.h("CCMLynxRadioBox", "setEnable = " + r3);
        M().setEnabled(r3);
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "is-large-size")
    public final void setLargeSize(boolean r3) {
        tt5.a.h("CCMLynxRadioBox", "setLargeSize = " + r3);
        if (r3 == false) goto L5;
        M().setSize(UDCheckBox.CheckBoxSize.NORMAL_SIZE);
        return;
    L5:
        M().setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
    }

    @LynxProp(name = ResourceData.KEY_TYPE)
    public final void setType(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        int r0 = r3.hashCode();
        if (r0 == (-518537308)) goto L22;
        if (r0 == 108270587) goto L16;
        if (r0 == 398904852) goto L10;
        return;
    L10:
        if (r3.equals("check_box") == false) goto L34;
        UDCheckBox r4 = M();
        if (r4 == null) goto L28;
        r4.setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        return;
    L28:
        return;
    L34:
        return;
    L16:
        if (r3.equals("radio") == false) goto L35;
        UDCheckBox r5 = M();
        if (r5 == null) goto L30;
        r5.setType(UDCheckBox.CheckBoxType.RADIO);
        return;
    L30:
        return;
    L35:
        return;
    L22:
        if (r3.equals("check_mark") == false) goto L36;
        UDCheckBox r6 = M();
        if (r6 == null) goto L32;
        r6.setType(UDCheckBox.CheckBoxType.CHECK_MARK);
        return;
    L32:
        return;
    }

    @LynxProp(name = "uncheck-background-color")
    public final void setUnCheckBackgroundColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        UDCheckBox r0 = M();
        if (r0 == null) goto L6;
        r0.setUncheckedBackgroundColor(ColorUtils.h(r2));
        return;
    }
}
