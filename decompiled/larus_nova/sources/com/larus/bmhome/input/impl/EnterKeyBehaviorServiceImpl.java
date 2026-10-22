package com.larus.bmhome.input.impl;

import com.bytedance.keva.Keva;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.IEnterKeyBehaviorHostService;
import com.larus.platform.service.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import sp8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/input/impl/EnterKeyBehaviorServiceImpl;", "Lcom/larus/bmhome/input/api/IEnterKeyBehaviorHostService;", "<init>", "()V", "getFinalBehavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "finalBehavior", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "updateUserPreference", "", "action", "refresh", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterKeyBehaviorServiceImpl implements IEnterKeyBehaviorHostService {
    public EnterKeyBehaviorServiceImpl() {
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    public final EnterKeyAction a() {
        return (EnterKeyAction) b.f542911c.getValue();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    /* JADX INFO: renamed from: a */
    public final i1<EnterKeyAction> mo8542a() {
        return b.f542912d;
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorHostService
    public final void b(EnterKeyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        EnterKeyAction r101 = b.f542909a;
        Intrinsics.checkNotNullParameter(r100, "action");
        ((Keva) b.f542910b.getValue()).storeInt("user_enter_key_behavior_".concat(o.f365780a.getDeviceId()), r100.getValue());
        b.f542911c.setValue(b.a(r100.getValue()));
    }
}
