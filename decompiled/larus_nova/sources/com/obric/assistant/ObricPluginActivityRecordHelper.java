package com.obric.assistant;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/ObricPluginActivityRecordHelper;", "Lcom/obric/assistant/IObricPluginActivityRecordHelper;", "<init>", "()V", "onPluginActivityResume", "", "activity", "", "onPluginActivityPause", "onPluginActivityStop", "isPluginForeground", "", "cancelBackgroundResetJob", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPluginActivityRecordHelper implements IObricPluginActivityRecordHelper {
    public ObricPluginActivityRecordHelper() {
    }

    @Override // com.obric.assistant.IObricPluginActivityRecordHelper
    public final void b() {
        Job r100 = ObricActivityManager.f385129a;
        FLogger.f375446a.d("ObricActivityManager", "cancelBackgroundResetJob");
        Job r101 = ObricActivityManager.f385129a;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        ObricActivityManager.f385129a = null;
    }

    @Override // com.obric.assistant.IObricPluginActivityRecordHelper
    public final void c() {
        Job r100 = ObricActivityManager.f385129a;
        ObricActivityManager.f385130b--;
        if (ObricActivityManager.f385130b != 0) goto L6;
        ObricActivityManager.f385133e.onAppBackground();
        return;
    }

    @Override // com.obric.assistant.IObricPluginActivityRecordHelper
    public final boolean e() {
        Job r100 = ObricActivityManager.f385129a;
        if (ObricActivityManager.f385130b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.IObricPluginActivityRecordHelper
    public final void d() {
        Job r100 = ObricActivityManager.f385129a;
    }

    @Override // com.obric.assistant.IObricPluginActivityRecordHelper
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Job r101 = ObricActivityManager.f385129a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (ObricActivityManager.f385130b != 0) goto L5;
        ObricActivityManager.f385133e.onAppForeground();
    L5:
        ObricActivityManager.f385130b++;
    }
}
