package com.ss.android.lark.contact.customized.newcontact.repository;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.log.Log;
import e9b.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/newcontact/repository/OfficeNewContactRepository$getFriendRequestsFromServer$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/contact/base/interfaces/IContactServiceInternal$GetFriendRequestResult;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactRepository$getFriendRequestsFromServer$1 implements IGetDataCallback<b> {
    final /* synthetic */ IGetDataCallback<b> $callback;
    final /* synthetic */ a this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("Contact_NewContactRepo", "get server friend requests failed: " + r100);
        this.this$0.f419340b = false;
        this.$callback.onError(r100);
    }

    public void onSuccess(b r100) {
        a r101 = this.this$0;
        boolean r102 = false;
        r101.f419340b = false;
        if (r100 == null) goto L7;
        r101.getClass();
        if (r100.f471539b != true) goto L7;
        r102 = true;
    L7:
        r101.f419339a = r102;
        if (r100 == null) goto L10;
        List<ChatApplication> r103 = r100.f471538a;
    L11:
        if (r103 != null) goto L13;
        r103 = CollectionsKt.emptyList();
    L13:
        List<ChatApplication> r104 = r103;
        ((ArrayList) r101.f419342d).addAll(r104);
        if ((true ^ r104.isEmpty()) == false) goto L16;
        r101.f419341c = ((ChatApplication) CollectionsKt.last(r103)).getId();
    L16:
        this.$callback.onSuccess(r100);
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((b) r100);
    }

    public OfficeNewContactRepository$getFriendRequestsFromServer$1(a r100, IGetDataCallback<b> r101) {
        this.this$0 = r100;
        this.$callback = r101;
    }
}
