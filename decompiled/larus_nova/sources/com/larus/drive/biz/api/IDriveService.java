package com.larus.drive.biz.api;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g79.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/larus/drive/biz/api/IDriveService;", "", "createDriveManageFragment", "Landroidx/fragment/app/Fragment;", "enterFrom", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/drive/biz/api/DriveEnterContext;", "preloadDriveManagePage", "Lcom/larus/drive/biz/api/DrivePreloadToken;", "scene", "Lcom/larus/drive/biz/api/DrivePreloadScene;", "clearDrivePreloadCache", "", "clearDriveUploadTasks", "getCurrentDrivePreviousPage", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f341017a = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/drive/biz/api/IDriveService$Companion;", "Lcom/larus/drive/biz/api/IDriveService;", "<init>", "()V", "clearDrivePreloadCache", "", "clearDriveUploadTasks", "createDriveManageFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/drive/biz/api/DriveEnterContext;", "enterFrom", "", "getCurrentDrivePreviousPage", "preloadDriveManagePage", "Lcom/larus/drive/biz/api/DrivePreloadToken;", "scene", "Lcom/larus/drive/biz/api/DrivePreloadScene;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IDriveService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f341018c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDriveService f341019b;

        static {
            f341018c = new Companion();
        }

        @Override // com.larus.drive.biz.api.IDriveService
        public final void h() {
            this.f341019b.h();
        }

        @Override // com.larus.drive.biz.api.IDriveService
        public final Fragment i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterFrom");
            return this.f341019b.i(r100);
        }

        @Override // com.larus.drive.biz.api.IDriveService
        public final String j() {
            return this.f341019b.j();
        }

        @Override // com.larus.drive.biz.api.IDriveService
        public final a k(DrivePreloadScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            return this.f341019b.k(r100);
        }

        private Companion() {
            this.f341019b = (IDriveService) ServiceManager.get().getService(IDriveService.class);
        }
    }

    static {
        f341017a = Companion.f341018c;
    }

    void h();

    Fragment i(String r100);

    String j();

    a k(DrivePreloadScene r100);
}
