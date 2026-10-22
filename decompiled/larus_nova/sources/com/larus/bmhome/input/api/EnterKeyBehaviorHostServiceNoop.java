package com.larus.bmhome.input.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyBehaviorHostServiceNoop;", "Lcom/larus/bmhome/input/api/IEnterKeyBehaviorHostService;", "<init>", "()V", "getFinalBehavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "finalBehavior", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "updateUserPreference", "", "action", "refresh", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterKeyBehaviorHostServiceNoop implements IEnterKeyBehaviorHostService {
    public EnterKeyBehaviorHostServiceNoop() {
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorHostService
    public final void b(EnterKeyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    public final EnterKeyAction a() {
        return EnterKeyBehaviorServiceDelegate.f311788b.a();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    /* JADX INFO: renamed from: a */
    public final i1<EnterKeyAction> mo8542a() {
        return EnterKeyBehaviorServiceDelegate.f311788b.mo8542a();
    }
}
