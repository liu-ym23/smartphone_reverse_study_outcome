package com.bytedance.bdp.bdpplatform.service.info;

import android.app.Application;
import android.content.pm.PackageManager;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;

/* JADX INFO: loaded from: classes3.dex */
public class BdpInfoServiceImpl implements BdpInfoService {

    /* JADX INFO: loaded from: classes11.dex */
    public class a implements lb4.a {
        @Override // lb4.a
        public final String getAppId() {
            return "";
        }

        @Override // lb4.a
        public final String getAppName() {
            return "";
        }

        @Override // lb4.a
        public final String getChannel() {
            return "";
        }

        @Override // lb4.a
        public final String getDeviceId(String r100) {
            return "";
        }

        @Override // lb4.a
        public final String getDevicePlatform() {
            return "";
        }

        @Override // lb4.a
        public final long getHostStartUpElapsedRealtime() {
            return -1;
        }

        @Override // lb4.a
        public final String getInstallId() {
            return "";
        }

        @Override // lb4.a
        public final String getOsVersion() {
            return "";
        }

        @Override // lb4.a
        public final String getPluginVersion() {
            return "";
        }

        @Override // lb4.a
        public final String getUpdateVersionCode() {
            return "";
        }

        @Override // lb4.a
        public final String getVersionCode() {
            return "";
        }

        @Override // lb4.a
        public final String getVersionName() {
            return "";
        }

        public a() {
        }
    }

    public BdpInfoServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService
    public final void B() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService
    public final lb4.a getHostInfo() {
        return new a();
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService
    public final boolean isDebugMode() {
        Application r100 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
        PackageManager r101 = r100.getPackageManager();
        if ((r101.getApplicationInfo(r100.getPackageName(), 0).flags & 2) != 0) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }
}
