package ti5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ UDCheckBox a;
    public final /* synthetic */ TransferApplyFragment b;

    public l(UDCheckBox r1, TransferApplyFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        boolean r4 = this.a.isChecked();
        this.a.setChecked(!r4);
        this.b.l = !r4;
    }
}
