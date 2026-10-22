package fe5;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxSwitch;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CCMLynxSwitch a;

    public g(CCMLynxSwitch r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.CompoundButton] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        StringBuilder r6 = new StringBuilder("on frameLayout clicked...isEnable = ");
        UDSwitch r0 = this.a.a;
        ?? r1 = 0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r0 = null;
    L5:
        r6.append(r0.isEnabled());
        tt5.a.h("CCMLynxSwitch", r6.toString());
        UDSwitch r7 = this.a.a;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
        r7 = null;
    L9:
        if (r7.isEnabled() == false) goto L15;
        HashMap r8 = new HashMap();
        j r2 = this.a.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("udSwitch");
    L14:
        r8.put("isOn", Boolean.valueOf(!r1.isChecked()));
        this.a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(this.a.getSign(), "valuewillchange", r8));
        return;
    L13:
        r1 = r2;
        goto L14
    L15:
        this.a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(this.a.getSign(), "disabledclicked", new LinkedHashMap()));
    }
}
