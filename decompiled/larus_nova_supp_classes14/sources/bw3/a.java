package bw3;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.file.AppletFileManager;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static File a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "appletId");
        Intrinsics.checkNotNullParameter(r7, "source");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        AppletAppManagerService.INSTANCE.getClass();     // Catch: Throwable -> L9
        OnlineAppletApplication r2 = AppletAppManagerService.b(r6);     // Catch: Throwable -> L9
        if (r2 != null) goto L6;
        File r3 = null;
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("resolve applet file failed. appletId: ");
        r9.append(r6);
        r9.append(", hasSource: ");
        r9.append(!StringsKt.isBlank(r7));
        r9.append(", error: ");
        r9.append(r5.getMessage());
        r8.e("AppletInnerAudioFileResolver", r9.toString());
    L15:
        if (Result.isFailure-impl(r4) == true) goto L19;
        r0 = r4;
    L19:
        return (File) r0;
    L6:
        AppletFileManager r10 = r2.J();     // Catch: Throwable -> L9
        int r11 = com.bytedance.ai.file.a.b;     // Catch: Throwable -> L9
        r3 = r10.n(com.bytedance.ai.file.a.a.a(r7));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
