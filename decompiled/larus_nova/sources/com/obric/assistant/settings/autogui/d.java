package com.obric.assistant.settings.autogui;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSettingsIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f391919a = 0;

    static {
    }

    public static boolean a() {
        KClass r100 = Reflection.getOrCreateKotlinClass(IAgentSettingsIDL.class);     // Catch: Exception -> L8 CancellationException -> L12
        int r101 = com.obric.aiagent.assistant.idl.l.f384546a;     // Catch: Exception -> L8 CancellationException -> L12
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Exception -> L8 CancellationException -> L12
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();     // Catch: Exception -> L8 CancellationException -> L12
        IAgentSettingsIDL r102 = (IAgentSettingsIDL) com.obric.aiagent.ipc.utils.g.b(IAgentSettingsIDL.class);     // Catch: Exception -> L8 CancellationException -> L12
        if (r102 == null) goto L10;
    L6:
        if (r102.isAutoGuiInstall() != true) goto L10;
        return true;
    L10:
        return false;
    L12:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        FLogger.f375446a.w("AutoGuiSettingsEntryGate", "isAutoGuiInstalled failed. " + e.getMessage(), e);
        goto L10
    }

    public static boolean b() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L9;
        q38.a r101 = r100.getAccountInfo();
        if (r101 == null) goto L9;
        if (r101.f531534g != true) goto L9;
        return true;
    L9:
        return false;
    }
}
