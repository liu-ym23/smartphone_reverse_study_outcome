package com.larus.account.saas;

import com.larus.account.saas.coreapi.IAccountBindingService;
import com.larus.account.saas.coreapi.IAccountDispatchService;
import com.larus.account.saas.coreapi.IAccountInitManager;
import com.larus.account.saas.coreapi.IAccountLoginService;
import com.larus.account.saas.coreapi.IAccountMfaService;
import com.larus.account.saas.coreapi.IAccountProfileService;
import com.larus.account.saas.coreapi.IAccountSessionService;
import com.larus.account.saas.coreapi.ISecShareDataService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowAccountSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<KClass<?>, Object> f286233a = null;

    static {
        f286233a = new ConcurrentHashMap();
    }

    public static IAccountBindingService a() {
        IAccountBindingService r100 = (IAccountBindingService) i(Reflection.getOrCreateKotlinClass(IAccountBindingService.class), FlowAccountSdk$getAccountBindingService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountBindingService.f286303a.getClass();
        return IAccountBindingService.Companion.f286305b;
    L6:
        return r100;
    }

    public static IAccountDispatchService b() {
        IAccountDispatchService r100 = (IAccountDispatchService) i(Reflection.getOrCreateKotlinClass(IAccountDispatchService.class), FlowAccountSdk$getAccountDispatchService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountDispatchService.f286306a.getClass();
        return IAccountDispatchService.Companion.f286308b;
    L6:
        return r100;
    }

    public static IAccountLoginService c() {
        IAccountLoginService r100 = (IAccountLoginService) i(Reflection.getOrCreateKotlinClass(IAccountLoginService.class), FlowAccountSdk$getAccountLoginService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountLoginService.f286316a.getClass();
        return IAccountLoginService.Companion.f286318b;
    L6:
        return r100;
    }

    public static IAccountMfaService d() {
        IAccountMfaService r100 = (IAccountMfaService) i(Reflection.getOrCreateKotlinClass(IAccountMfaService.class), FlowAccountSdk$getAccountMfaService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountMfaService.f286319a.getClass();
        return IAccountMfaService.Companion.f286321b;
    L6:
        return r100;
    }

    public static IAccountProfileService e() {
        IAccountProfileService r100 = (IAccountProfileService) i(Reflection.getOrCreateKotlinClass(IAccountProfileService.class), FlowAccountSdk$getAccountProfileService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountProfileService.f286322a.getClass();
        return IAccountProfileService.Companion.f286324b;
    L6:
        return r100;
    }

    public static IAccountSessionService f() {
        IAccountSessionService r100 = (IAccountSessionService) i(Reflection.getOrCreateKotlinClass(IAccountSessionService.class), FlowAccountSdk$getAccountSessionService$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountSessionService.f286325a.getClass();
        return IAccountSessionService.Companion.f286327b;
    L6:
        return r100;
    }

    public static IAccountInitManager g() {
        IAccountInitManager r100 = (IAccountInitManager) i(Reflection.getOrCreateKotlinClass(IAccountInitManager.class), FlowAccountSdk$getInitManager$1.INSTANCE);
        if (r100 != null) goto L6;
        IAccountInitManager.f286310a.getClass();
        return IAccountInitManager.Companion.f286312b;
    L6:
        return r100;
    }

    public static ISecShareDataService h() {
        ISecShareDataService r100 = (ISecShareDataService) i(Reflection.getOrCreateKotlinClass(ISecShareDataService.class), FlowAccountSdk$getSecShareDataService$1.INSTANCE);
        if (r100 != null) goto L6;
        ISecShareDataService.f286328a.getClass();
        return ISecShareDataService.Companion.f286330b;
    L6:
        return r100;
    }

    public static Object i(KClass r100, Function0 r101) {
        Object r102 = f286233a.get(r100);
        if (r102 != null) goto L5;
        r102 = null;
    L5:
        if (r102 == null) goto L7;
        return r102;
    L7:
        return r101.invoke();
    }
}
