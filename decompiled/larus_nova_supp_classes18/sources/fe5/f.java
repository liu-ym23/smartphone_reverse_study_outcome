package fe5;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxRadioBox;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CCMLynxRadioBox a;

    public f(CCMLynxRadioBox r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        tt5.a.h("CCMLynxRadioBox", "on frameLayout clicked...isEnable = " + this.a.M().isEnabled());
        if (this.a.M().isEnabled() == false) goto L6;
        HashMap r6 = new HashMap();
        r6.put("isChecked", Boolean.valueOf(!this.a.M().isChecked()));
        this.a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(this.a.getSign(), "valuewillchange", r6));
        return;
    }
}
