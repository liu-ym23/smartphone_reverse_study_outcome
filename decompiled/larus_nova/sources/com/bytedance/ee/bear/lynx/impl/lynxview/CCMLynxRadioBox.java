package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import fe5.f;
import fe5.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0007R\u001a\u0010\u0007\u001a\u00020\bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxRadioBox;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "udCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getUdCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setUdCheckBox", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "createView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setChecked", "", "isChecked", "", "setEnable", "isEnable", "setLargeSize", "isLargeSize", "setType", "type", "", "setClickable", "clickable", "setUnCheckBackgroundColor", "color", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CCMLynxRadioBox extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDCheckBox f229875a;

    public static final class a {
    }

    static {
    }

    public final UDCheckBox M() {
        UDCheckBox r100 = this.f229875a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("udCheckBox");
        return null;
    }

    public CCMLynxRadioBox(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxContext");
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        i r103 = new i(r100);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f229875a = r103;
        M().setType(UDCheckBox.CheckBoxType.RADIO);
        M().setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
        r101.setOnClickListener(new f(this));
        r102.gravity = 17;
        M().setLayoutParams(r102);
        r101.addView(M(), r102);
        return r101;
    }

    @LynxProp(defaultBoolean = false, name = "is-checked")
    public final void setChecked(boolean r100) {
        tt5.a.h("CCMLynxRadioBox", "isChecked = " + r100);
        M().setChecked(r100);
    }

    @LynxProp(name = "clickable")
    public final void setClickable(boolean r100) {
        UDCheckBox r101 = M();
        if (r101 == null) goto L6;
        r101.setClickable(r100);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "is-enabled")
    public final void setEnable(boolean r100) {
        tt5.a.h("CCMLynxRadioBox", "setEnable = " + r100);
        M().setEnabled(r100);
    }

    @LynxProp(defaultBoolean = false, name = "is-large-size")
    public final void setLargeSize(boolean r100) {
        tt5.a.h("CCMLynxRadioBox", "setLargeSize = " + r100);
        if (r100 == false) goto L5;
        M().setSize(UDCheckBox.CheckBoxSize.NORMAL_SIZE);
        return;
    L5:
        M().setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
    }

    @LynxProp(name = "type")
    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = r100.hashCode();
        if (r101 == (-518537308)) goto L22;
        if (r101 == 108270587) goto L16;
        if (r101 == 398904852) goto L10;
        return;
    L10:
        if (r100.equals("check_box") == false) goto L34;
        UDCheckBox r102 = M();
        if (r102 == null) goto L28;
        r102.setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        return;
    L28:
        return;
    L34:
        return;
    L16:
        if (r100.equals("radio") == false) goto L35;
        UDCheckBox r103 = M();
        if (r103 == null) goto L30;
        r103.setType(UDCheckBox.CheckBoxType.RADIO);
        return;
    L30:
        return;
    L35:
        return;
    L22:
        if (r100.equals("check_mark") == false) goto L36;
        UDCheckBox r104 = M();
        if (r104 == null) goto L32;
        r104.setType(UDCheckBox.CheckBoxType.CHECK_MARK);
        return;
    L32:
        return;
    }

    @LynxProp(name = "uncheck-background-color")
    public final void setUnCheckBackgroundColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        UDCheckBox r101 = M();
        if (r101 == null) goto L6;
        r101.setUncheckedBackgroundColor(ColorUtils.h(r100));
        return;
    }
}
