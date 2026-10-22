package com.obric.assistant.receive;

import android.content.Context;
import android.content.Intent;
import com.larus.receive.contract.IReceiveCustomDiff;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/receive/ObricReceiveCustomDiffImpl;", "Lcom/larus/receive/contract/IReceiveCustomDiff;", "<init>", "()V", "getName", "", "onIntercept", "", "intent", "Landroid/content/Intent;", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "currentPage", "Companion", "o_receive_extension_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReceiveCustomDiffImpl implements IReceiveCustomDiff {

    public static final class a {
    }

    static {
    }

    public ObricReceiveCustomDiffImpl() {
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final String getName() {
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L6;
        return "";
    L6:
        return "ObricReceiveCustomDiffImpl";
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ObricReceiveCustomDiffImpl", "handle, currentPage:landing");
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L5;
        return false;
    L5:
        FLogger.f375446a.i("ObricReceiveCustomDiffImpl", "onIntercept, intent:" + r100);
        return r100.getBooleanExtra("wakeup_assistant", false);
    }
}
