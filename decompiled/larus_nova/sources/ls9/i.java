package ls9;

import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.project.create.CreateProjectPanelFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements IPcDevicePanelService.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreateProjectPanelFragment f510567a;

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.b
    public final void a() {
        CreateProjectPanelFragment r100 = this.f510567a;
        int r101 = CreateProjectPanelFragment.f367005m;
        r100.aa0("cancel");
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.b
    public final void b() {
        CreateProjectPanelFragment r100 = this.f510567a;
        r100.f367008f = null;
        r100.f367009g = null;
        r100.Z90();
        this.f510567a.aa0("cancel");
    }

    public i(CreateProjectPanelFragment r100) {
        this.f510567a = r100;
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.b
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "folderName");
        Intrinsics.checkNotNullParameter(r101, "folderPath");
        FLogger.f375446a.i("CreateProjectPanel", "onFolderSelected nameLength=" + r100.length());
        CreateProjectPanelFragment r102 = this.f510567a;
        r102.f367008f = r100;
        r102.f367009g = r101;
        r102.Z90();
        this.f510567a.aa0("success");
    }
}
