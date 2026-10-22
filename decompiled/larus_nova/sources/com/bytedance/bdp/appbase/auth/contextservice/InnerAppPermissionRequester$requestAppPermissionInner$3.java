package com.bytedance.bdp.appbase.auth.contextservice;

import android.app.Activity;
import b94.d;
import com.bytedance.bdp.appbase.auth.ui.entity.AuthViewProperty;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class InnerAppPermissionRequester$requestAppPermissionInner$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b94.a $appPermissionRequest;
    final /* synthetic */ AuthViewProperty $authViewProperty;
    final /* synthetic */ Activity $currentActivity;
    final /* synthetic */ String $dialogIdentify;
    final /* synthetic */ d $filterResult;
    final /* synthetic */ List $finalAuthResult;
    final /* synthetic */ String $token;
    final /* synthetic */ a this$0;

    public InnerAppPermissionRequester$requestAppPermissionInner$3(a r100, Activity r101, AuthViewProperty r102, d r103, List r104, String r105, b94.a r106, String r107) {
        this.$currentActivity = r101;
        this.$finalAuthResult = r104;
        this.$dialogIdentify = r105;
        this.$appPermissionRequest = r106;
        this.$token = r107;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = a.f200402a;
        throw null;
    }
}
