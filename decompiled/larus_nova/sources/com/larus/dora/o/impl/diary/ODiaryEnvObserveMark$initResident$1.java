package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryEnvObserveMark$initResident$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryEnvObserveMark$initResident$1 extends BroadcastReceiver {
    public ODiaryEnvObserveMark$initResident$1() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getAction();
    L6:
        if (Intrinsics.areEqual(r102, "action.DEVICE_UNBIND") == true) goto L8;
        return;
    L8:
        String r103 = r101.getStringExtra("mac");
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        FLogger.f375446a.w("ODiaryEnvMark", "unbind without mac, skip clear");
        return;
    L19:
        FLogger.f375446a.i("ODiaryEnvMark", "device unbind, clear diary env mark");
        IDoraPageConfig r105 = d0.a();
        if (r105 == null) goto L23;
        r105.h(r103);
        return;
    L23:
        return;
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
        goto L16
    L4:
        r102 = null;
        goto L6
    }
}
