package com.larus.uaigc.createpage;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.creation.ICreationService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationServiceImpl;", "Lcom/larus/uaigc/creation/ICreationService;", "<init>", "()V", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationServiceImpl implements ICreationService {
    public CreationServiceImpl() {
    }

    @Override // com.larus.uaigc.creation.ICreationService
    public final Object a(Continuation<? super String> r100) {
        DigitalAvatarInfoManager r101 = DigitalAvatarInfoManager.f371542a;
        r101.getClass();
        String r102 = (String) DigitalAvatarInfoManager.f371543b.getValue();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L15;
        Object r104 = r101.c("", r100);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r104;
    L14:
        return (String) r104;
    L15:
        return r102;
    L8:
        r103 = false;
        goto L9
    }
}
