package com.larus.account.base.provider.agegate;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s38.a;
import s38.b;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/larus/account/base/provider/agegate/AgeGateManagerService;", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "impl$delegate", "Lkotlin/Lazy;", "onPassAgeGate", "", "pass", "", "verifyAgeGate", "callback", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "platform", "", "trackerJson", "Lorg/json/JSONObject;", "getLoginPlatform", "getNeutralAgeGateStyle", "", "()Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateManagerService implements IAgeGateManagerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AgeGateManagerService f286218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f286219b = null;

    private AgeGateManagerService() {
    }

    static {
        f286218a = new AgeGateManagerService();
        f286219b = LazyKt.lazy(new a());
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final Integer b() {
        IAgeGateManagerInterface r100 = (IAgeGateManagerInterface) f286219b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final String getLoginPlatform() {
        IAgeGateManagerInterface r100 = (IAgeGateManagerInterface) f286219b.getValue();
        if (r100 == null) goto L5;
        String r101 = r100.getLoginPlatform();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void c(boolean r100) {
        IAgeGateManagerInterface r101 = (IAgeGateManagerInterface) f286219b.getValue();
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void a(b r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "platform");
        IAgeGateManagerInterface r103 = (IAgeGateManagerInterface) f286219b.getValue();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }
}
