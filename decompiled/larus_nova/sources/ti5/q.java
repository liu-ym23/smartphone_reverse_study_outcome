package ti5;

import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements gp5.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyFragment f546139a;

    public q(TransferApplyFragment r100) {
        this.f546139a = r100;
    }

    @Override // gp5.a.b
    public final void a(CharSequence r100, SpaceEditText r101) {
        TransferApplyFragment r102 = this.f546139a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.f234294p = r100;
    }
}
