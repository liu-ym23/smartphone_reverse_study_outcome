package com.larus.bmhome.input.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyBehaviorHostDelegate;", "Lcom/larus/bmhome/input/api/IEnterKeyBehaviorHostService;", "<init>", "()V", "getFinalBehavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "refresh", "", "updateUserPreference", "action", "finalBehavior", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterKeyBehaviorHostDelegate implements IEnterKeyBehaviorHostService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnterKeyBehaviorHostDelegate f311786b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IEnterKeyBehaviorHostService f311787a;

    static {
        f311786b = new EnterKeyBehaviorHostDelegate();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    public final EnterKeyAction a() {
        return this.f311787a.a();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final i1<EnterKeyAction> mo8542a() {
        return this.f311787a.mo8542a();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorHostService
    public final void b(EnterKeyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f311787a.b(r100);
    }

    private EnterKeyBehaviorHostDelegate() {
        IEnterKeyBehaviorHostService r100 = (IEnterKeyBehaviorHostService) ServiceManager.get().getService(IEnterKeyBehaviorHostService.class);
        if (r100 != null) goto L5;
        r100 = new EnterKeyBehaviorHostServiceNoop();
    L5:
        this.f311787a = r100;
    }
}
