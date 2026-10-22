package ti5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDCheckBox f546128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TransferApplyFragment f546129b;

    public l(UDCheckBox r100, TransferApplyFragment r101) {
        this.f546128a = r100;
        this.f546129b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        boolean r101 = this.f546128a.isChecked();
        this.f546128a.setChecked(!r101);
        this.f546129b.f234290l = !r101;
    }
}
