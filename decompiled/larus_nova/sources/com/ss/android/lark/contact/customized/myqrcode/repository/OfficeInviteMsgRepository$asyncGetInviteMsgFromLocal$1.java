package com.ss.android.lark.contact.customized.myqrcode.repository;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.entity.bean.ContactAvatarSourceStrategy;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/myqrcode/repository/OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/im/v2/GetContactTokenResponse;", "onSuccess", "", "response", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1 implements IGetDataCallback<GetContactTokenResponse> {
    final /* synthetic */ Function1<z8b.a, Unit> $consumer;

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1(Function1<? super z8b.a, Unit> r100) {
        this.$consumer = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("ContactModule_", r100.getDebugMsg());
        Function1<z8b.a, Unit> r101 = this.$consumer;
        z8b.a r102 = new z8b.a();
        r102.f570974c = r100;
        r101.invoke(r102);
    }

    public void onSuccess(GetContactTokenResponse r100) {
        Function1<z8b.a, Unit> r101 = this.$consumer;
        if (r100 != null) goto L5;
        z8b.a r102 = null;
    L6:
        r101.invoke(r102);
        return;
    L5:
        r102 = z8b.a.a(r100, ContactAvatarSourceStrategy.LOGIN_CHATTER);
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((GetContactTokenResponse) r100);
    }
}
