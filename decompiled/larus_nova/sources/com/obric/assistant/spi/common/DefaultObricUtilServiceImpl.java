package com.obric.assistant.spi.common;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/common/DefaultObricUtilServiceImpl;", "Lcom/obric/assistant/spi/common/IObricUtilService;", "<init>", "()V", "getLaunchMethod", "", "checkAsync", "", "isCheckPassed", "", "onUserActionBlocked", "showToastIfAppIsBackground", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toast", "duration", "", "isImeLaunchedByApp", "viewGroup", "Landroid/view/ViewGroup;", "physicalScreenWidthPixels", "(Landroid/content/Context;)Ljava/lang/Integer;", "getPassportSdkVersion", "isDarkModeDefaultFollowSys", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricUtilServiceImpl implements IObricUtilService {

    public static final class a {
    }

    static {
    }

    public DefaultObricUtilServiceImpl() {
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final String a() {
        return "other";
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean c() {
        return true;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "toast");
        return false;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean e() {
        return false;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final void g() {
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final Integer h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
