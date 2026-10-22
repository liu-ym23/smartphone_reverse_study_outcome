package us7;

import com.dtf.face.api.IDTLoadingFragment;
import com.dtf.face.ui.FaceLoadingActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements IDTLoadingFragment.IMessageBoxCB {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f551531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceLoadingActivity f551532b;

    @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
    public final void onCancel() {
    }

    @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
    public final void onOK() {
        FaceLoadingActivity r100 = this.f551532b;
        String r101 = this.f551531a;
        int r102 = FaceLoadingActivity.f273649k;
        r100.r(r101);
    }

    public c(FaceLoadingActivity r100, String r101) {
        this.f551532b = r100;
        this.f551531a = r101;
    }
}
