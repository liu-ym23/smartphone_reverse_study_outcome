package e77;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;
import java.util.concurrent.atomic.AtomicBoolean;
import v67.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends BaseJson implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f471197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f471198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProcessEnum f471199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f471200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f471201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f471202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n77.b f471203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f471204h;

    public final void c() {
        f.b("ProcessManagerService", "[initSettingsInternal]mDelayStartChildProcessSettingsModel:" + this.f471203g);
        if (this.f471203g != null) goto L11;
        com.ss.android.pushmanager.setting.b.b().getClass();
        this.f471203g = com.ss.android.pushmanager.setting.b.d().h();
        boolean r100 = PushServiceManager.get().getIAllianceService().depthsInMainProcess(this.f471198b);
        f.b("ProcessManagerService", "[initSettingsInternal]depthsInMainProcess:" + r100 + " mDelayStartChildProcessMode:" + this.f471202f);
        if (this.f471202f != (-1)) goto L9;
        if (r100 == false) goto L8;
        this.f471202f = 3;
        goto L9
    L8:
        this.f471202f = this.f471203g.f518206a;
    L9:
        this.f471197a = this.f471203g.f518207b;
        init();
        return;
    }

    public final void init() {
        if (this.f471202f != 0) goto L5;
        boolean r100 = true;
    L6:
        this.f471200d = r100;
        if (r100 == false) goto L9;
        this.f471199c = ProcessEnum.PUSH;
    L10:
        f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService mAllowStartChildProcess is " + this.f471200d + " because mDelayStartChildProcessMode is " + this.f471202f);
        return;
    L9:
        this.f471199c = ProcessEnum.MAIN;
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    public final void b() {
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost() == true) goto L6;
        c();
        return;
    }

    public c(Context r100) {
        this.f471197a = 300000;
        this.f471200d = true;
        this.f471201e = false;
        this.f471202f = -1;
        this.f471204h = new AtomicBoolean(false);
        this.f471198b = r100;
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost() == false) goto L6;
        c();
    L6:
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.disableAutoStartChildProcess() == false) goto L8;
        f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerServiceset mDelayStartChildProcessMode to DELAY_UNTIL_HOST_START because com.bytedance.common.push.interfaze.IPushCommonConfiguration.disableAutoStartChildProcess is true");
        this.f471202f = 3;
    L8:
        init();
    }
}
