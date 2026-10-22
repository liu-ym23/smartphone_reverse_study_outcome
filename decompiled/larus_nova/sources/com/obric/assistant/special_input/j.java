package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.flow.b1 f392746a = null;

    public j() {
    }

    static {
        OSkillExtensionSettingRepository.f392543a.getClass();
        f392746a = OSkillExtensionSettingRepository.f392552j;
    }

    public static /* synthetic */ boolean b() {
        return a(0);
    }

    public static boolean a(long r100) {
        OSkillExtensionSettingRepository.f392543a.getClass();
        if (OSkillExtensionSettingRepository.c() == true) goto L5;
        OSkillExtensionSettingRepository.e();
        return false;
    L5:
        OSkillExtensionSettingRepository.a();
        if (r100 > 0) goto L34;
        OSkillExtensionSettingRepository.b("lazy_read");
    L23:
        t0 r101 = (t0) OSkillExtensionSettingRepository.f392551i.getValue();
        if (r101.f392779e != 1) goto L26;
        boolean r102 = true;
    L27:
        if (r102 == true) goto L29;
        return false;
    L29:
        if (r101.f392775a == false) goto L38;
        return true;
    L38:
        return false;
    L26:
        r102 = false;
        goto L27
    L34:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(OSkillExtensionSettingRepository.f392546d.tryLock(r100, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L9
    L11:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = r105;
    L15:
        if (((Boolean) r104).booleanValue() == true) goto L32;
        t0 r106 = (t0) OSkillExtensionSettingRepository.f392551i.getValue();
        FLogger.f375446a.w("SkillExtSettingRepo", "syncRemoteState timeout for send, timeoutMs=" + r100 + ", enabled=" + r106.f392775a + ", hasLoadedRemote=" + r106.f392777c + ", omniSkillAvailableState=" + r106.f392779e + ", hasLoadedOmniSkillAvailableRemote=" + r106.f392780f);
        goto L23
    L32:
        OSkillExtensionSettingRepository.f("send_message_sync");     // Catch: Throwable -> L19
        OSkillExtensionSettingRepository.f392546d.unlock();
    L19:
        th = move-exception;
        OSkillExtensionSettingRepository.f392546d.unlock();
        throw th;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
