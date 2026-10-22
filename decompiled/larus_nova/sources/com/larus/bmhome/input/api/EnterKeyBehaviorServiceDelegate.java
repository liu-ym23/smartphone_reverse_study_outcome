package com.larus.bmhome.input.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyBehaviorServiceDelegate;", "Lcom/larus/bmhome/input/api/IEnterKeyBehaviorService;", "<init>", "()V", "getFinalBehavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "finalBehavior", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterKeyBehaviorServiceDelegate implements IEnterKeyBehaviorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnterKeyBehaviorServiceDelegate f311788b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IEnterKeyBehaviorService f311789a;

    static {
        f311788b = new EnterKeyBehaviorServiceDelegate();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    public final EnterKeyAction a() {
        return this.f311789a.a();
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    /* JADX INFO: renamed from: a */
    public final i1<EnterKeyAction> mo8542a() {
        return this.f311789a.mo8542a();
    }

    private EnterKeyBehaviorServiceDelegate() {
        IEnterKeyBehaviorService r100 = (IEnterKeyBehaviorService) ServiceManager.get().getService(IEnterKeyBehaviorService.class);
        if (r100 != null) goto L5;
        r100 = new EnterKeyBehaviorServiceNoop();
    L5:
        this.f311789a = r100;
    }
}
