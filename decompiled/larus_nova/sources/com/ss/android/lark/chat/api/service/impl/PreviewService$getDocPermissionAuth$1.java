package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.preview.DocPer;
import com.ss.android.lark.chat.entity.preview.DocType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.entities.DocPermission;
import com.ss.android.lark.pb.messages.PullMessageDocPermsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/api/service/impl/PreviewService$getDocPermissionAuth$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/PullMessageDocPermsResponse;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewService$getDocPermissionAuth$1 implements IGetDataCallback<PullMessageDocPermsResponse> {
    final /* synthetic */ IGetDataCallback<ArrayList<DocPer>> $callback;

    public PreviewService$getDocPermissionAuth$1(IGetDataCallback<ArrayList<DocPer>> r100) {
        this.$callback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("[URLPreview] PreviewService", "getDocPermissionAuth error:" + r100.getDisplayMsg());
        this.$callback.onError(r100);
    }

    public void onSuccess(PullMessageDocPermsResponse r110) {
        ArrayList<DocPer> r100 = new ArrayList();
        if (r110 == null) goto L16;
        List<PullMessageDocPermsResponse.DocPerm> r111 = r110.mdoc_perms;
        if (r111 == null) goto L16;
        Iterator<T> r112 = r111.iterator();
    L8:
        if (r112.hasNext() == false) goto L16;
        PullMessageDocPermsResponse.DocPerm r101 = (PullMessageDocPermsResponse.DocPerm) r112.next();
        ArrayList r102 = new ArrayList();
        List<DocPermission> r103 = r101.mpermissions;
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        DocPermission r105 = (DocPermission) r104.next();
        r102.add(new com.ss.android.lark.chat.entity.preview.DocPermission(r105.mperm_code, r105.mperm_name, r105.mis_set.booleanValue()));
    L15:
        String r106 = r101.mdoc_title;
        DocType.a r107 = DocType.Companion;
        int r108 = r101.mdoc_type.getValue();
        r107.getClass();
        r100.add(new DocPer(r106, DocType.a.a(r108), r101.mowner_name, r101.mdoc_url, r102, r101.mmessage_ids));
    L16:
        this.$callback.onSuccess(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PullMessageDocPermsResponse) r100);
    }
}
