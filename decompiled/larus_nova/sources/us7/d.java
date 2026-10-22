package us7;

import com.dtf.face.api.IDTFragment;
import com.dtf.face.ui.FaceLoadingActivity;
import com.dtf.face.ui.widget.ToygerWebView;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements IDTFragment.ICloseCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceLoadingActivity f551533a;

    @Override // com.dtf.face.api.IDTFragment.ICloseCallBack
    public final void onBack() {
        ToygerWebView r100 = this.f551533a.f273651f;
        if (r100 == null) goto L6;
        r100.goBack();
        return;
    }

    @Override // com.dtf.face.api.IDTFragment.ICloseCallBack
    public final void onClose() {
        this.f551533a.m(1);
    }

    public d(FaceLoadingActivity r100) {
        this.f551533a = r100;
    }
}
