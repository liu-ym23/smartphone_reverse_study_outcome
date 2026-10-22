package vs7;

import com.dtf.face.api.IDTUICallBack;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements IDTUICallBack.MessageBoxCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f557109b;

    @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
    public final void onCancel() {
    }

    @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
    public final void onOK() {
        this.f557109b.i(this.f557108a, "");
    }

    public h(f r100, String r101) {
        this.f557109b = r100;
        this.f557108a = r101;
    }
}
