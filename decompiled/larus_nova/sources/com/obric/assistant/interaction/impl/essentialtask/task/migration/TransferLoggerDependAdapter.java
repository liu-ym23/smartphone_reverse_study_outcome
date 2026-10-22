package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.obric.datatransfer.logger.TransferLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/TransferLoggerDependAdapter;", "Lcom/obric/datatransfer/logger/ITransferLoggerDepend;", "<init>", "()V", "log", "", "level", "Lcom/obric/datatransfer/logger/TransferLogger$Level;", "tag", "", "message", "tr", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferLoggerDependAdapter implements com.obric.datatransfer.logger.a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[TransferLogger.Level.values().length];
            r100[TransferLogger.Level.VERBOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[TransferLogger.Level.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[TransferLogger.Level.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[TransferLogger.Level.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[TransferLogger.Level.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public TransferLoggerDependAdapter() {
    }

    public static /* synthetic */ String a(String r100, Throwable r101) {
        return log$lambda$0(r100, r101);
    }

    private static final String log$lambda$0(String r100, Throwable r101) {
        return r100 + '\n' + Log.getStackTraceString(r101);
    }

    @Override // com.obric.datatransfer.logger.a
    public void log(TransferLogger.Level r100, String r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        int r104 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r104 != 1) goto L5;
        if (r103 != null) goto L24;
        FLogger.f375446a.v(r101, r102);
    L25:
        if (r103 == null) goto L28;
        r100.getLevelValue();
        Log.getStackTraceString(r103);
        return;
    L28:
        return;
    L24:
        FLogger.f375446a.v(r101, a(r102, r103));
        goto L25
    L5:
        if (r104 != 2) goto L7;
        if (r103 != null) goto L21;
        FLogger.f375446a.d(r101, r102);
        goto L25
    L21:
        FLogger.f375446a.d(r101, a(r102, r103));
        goto L25
    L7:
        if (r104 != 3) goto L9;
        if (r103 != null) goto L18;
        FLogger.f375446a.i(r101, r102);
        goto L25
    L18:
        FLogger.f375446a.i(r101, a(r102, r103));
        goto L25
    L9:
        if (r104 != 4) goto L11;
        FLogger.f375446a.w(r101, r102, r103);
        goto L25
    L11:
        if (r104 != 5) goto L14;
        FLogger.f375446a.e(r101, r102, r103);
        goto L25
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
