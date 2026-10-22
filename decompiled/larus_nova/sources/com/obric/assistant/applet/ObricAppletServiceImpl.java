package com.obric.assistant.applet;

import com.larus.platform.service.AccountService;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mba.a;
import mba.b;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/applet/ObricAppletServiceImpl;", "Lcom/obric/assistant/applet/IObricAppletService;", "<init>", "()V", "repo", "Lcom/obric/assistant/applet/PersonalPermissionRepo;", "getRepo", "()Lcom/obric/assistant/applet/PersonalPermissionRepo;", "repo$delegate", "Lkotlin/Lazy;", "checkPersonalPermission", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "permission", "updatePersonalPermission", "", "granted", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppletServiceImpl implements IObricAppletService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f385591a;

    public ObricAppletServiceImpl() {
        this.f385591a = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.applet.IObricAppletService
    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        b r102 = (b) this.f385591a.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        String r103 = AccountService.f365697a.getUserId();
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        return r102.f512800a.getBoolean(r100 + '_' + r101, false);
    L10:
        return r102.f512800a.getBoolean(r100 + '_' + r103 + '_' + r101, false);
    L5:
        r104 = false;
        goto L7
    }

    @Override // com.obric.assistant.applet.IObricAppletService
    public final void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        b r103 = (b) this.f385591a.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        String r104 = AccountService.f365697a.getUserId();
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        r103.f512800a.storeBoolean(r100 + '_' + r101, r102);
        return;
    L9:
        r103.f512800a.storeBoolean(r100 + '_' + r104 + '_' + r101, r102);
        return;
    L5:
        r105 = false;
        goto L7
    }
}
