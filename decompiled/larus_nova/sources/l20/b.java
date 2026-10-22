package l20;

import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements IXplayMessageInterface.SendMsgListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h10.b f507089a;

    public b(d r100) {
        this.f507089a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.SendMsgListener
    public final void onSendResult(boolean r100, int r101, String r102, String r103) {
        h10.b r104 = this.f507089a;
        if (r104 == null) goto L6;
        r104.onSendResult(r100, r101, r102, r103);
        return;
    }
}
