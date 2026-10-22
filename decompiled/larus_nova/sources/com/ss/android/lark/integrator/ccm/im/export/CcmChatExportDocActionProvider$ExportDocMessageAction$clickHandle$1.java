package com.ss.android.lark.integrator.ccm.im.export;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.DeriveMessagesToDocResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/integrator/ccm/im/export/CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/DeriveMessagesToDocResponse;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1 implements IGetDataCallback<DeriveMessagesToDocResponse> {
    final /* synthetic */ long $sendTime;
    final /* synthetic */ a this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("CcmChatExportDocActionProvider", "export error " + r100.getErrorCode());
        this.this$0.getClass();
        b.a();
        throw null;
    }

    public void onSuccess(DeriveMessagesToDocResponse r100) {
        Log.i("CcmChatExportDocActionProvider", "export success");
        this.this$0.getClass();
        b.a();
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((DeriveMessagesToDocResponse) r100);
    }

    public CcmChatExportDocActionProvider$ExportDocMessageAction$clickHandle$1(a r100, long r101) {
        this.this$0 = r100;
        this.$sendTime = r101;
    }
}
