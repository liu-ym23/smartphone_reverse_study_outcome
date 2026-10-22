package com.ss.android.lark.contact.base.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.entity.bean.ContactAvatarSourceStrategy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.s0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/base/service/InviteExternalService$Companion$getInvitationInfoFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/im/v2/GetContactTokenResponse;", "onSuccess", "", "response", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalService$Companion$getInvitationInfoFromLocal$1 implements IGetDataCallback<GetContactTokenResponse> {
    final /* synthetic */ s0.b<z8b.a> $syncValue;

    public InviteExternalService$Companion$getInvitationInfoFromLocal$1(s0.b<z8b.a> r100) {
        this.$syncValue = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("ContactModule_", r100.getDebugMsg());
        s0.b<z8b.a> r101 = this.$syncValue;
        z8b.a r102 = new z8b.a();
        r102.f570974c = r100;
        r101.a(r102);
        a0.a(r100);
    }

    public void onSuccess(GetContactTokenResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.$syncValue.a(z8b.a.a(r100, ContactAvatarSourceStrategy.FOREGROUND_USER));
        a0.g(false);
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
