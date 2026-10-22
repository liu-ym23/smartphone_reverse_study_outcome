package com.obric.matrix.platform.sdk.ones.account;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$updatePassword$1 extends Lambda implements Function1<IAccountService, Unit> {
    final /* synthetic */ String $newPassword;
    final /* synthetic */ String $oldPassword;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$updatePassword$1(String r100, String r101, Function0<Unit> r102, Function2<? super Integer, ? super String, Unit> r103) {
        this.$oldPassword = r100;
        this.$newPassword = r101;
        this.$onSuccess = r102;
        this.$onFailed = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IAccountService r110) {
        Intrinsics.checkNotNullParameter(r110, "service");
        r110.updatePassword(this.$oldPassword, this.$newPassword, new OAccount.AsyncResultCallback("updatePassword", this.$onSuccess, this.$onFailed, null, 8, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IAccountService r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
