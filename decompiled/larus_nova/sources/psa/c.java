package psa;

import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements SDKCallBack.CommonRequestCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f530515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530516b;

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
    public final void onRequestFinish(BDResponse r100) {
        ICertFlow r101 = BytedCertManager.getInstance().getFlow(this.f530515a);
        if (r101 == null) goto L5;
        r101.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_QEURY_RESULT, EventConstant.Key.FACE_DETECT_TIMESTAMP);
    L5:
        SDKCallBack.CommonRequestCallback r102 = this.f530516b;
        if (r102 == null) goto L9;
        r102.onRequestFinish(r100);
        return;
    }

    public c(String r100, SDKCallBack.CommonRequestCallback r101) {
        this.f530515a = r100;
        this.f530516b = r101;
    }
}
