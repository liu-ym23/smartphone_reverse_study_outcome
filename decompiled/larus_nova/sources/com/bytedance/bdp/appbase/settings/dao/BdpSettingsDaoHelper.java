package com.bytedance.bdp.appbase.settings.dao;

import com.bytedance.bdp.appbase.settings.SettingsModel;
import com.bytedance.bdp.bdpbase.util.f;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import g94.b;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/dao/BdpSettingsDaoHelper;", "", "()V", "FLAG_TMP", "", "TAG", "TIME_OUT", "", "createSettingTmpFile", "Ljava/io/File;", "settingsDao", "Lcom/bytedance/bdp/appbase/settings/dao/BdpSettingsDao;", "data", "Lcom/bytedance/bdp/appbase/settings/SettingsModel;", "readSettingTmpFileString", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class BdpSettingsDaoHelper {
    private static final String FLAG_TMP = "tmp";
    public static final BdpSettingsDaoHelper INSTANCE = null;
    private static final String TAG = "BdpSettingsDaoHelper";
    private static final long TIME_OUT = 200;

    private BdpSettingsDaoHelper() {
    }

    static {
        INSTANCE = new BdpSettingsDaoHelper();
    }

    public final String readSettingTmpFileString(BdpSettingsDao r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getSettingFilePath() + DefaultDiskStorage.FileType.TEMP);
        LockObject.Companion.getClass();
        LockObject r102 = LockObject.a.a(r101);
        if (r102.tryLock(200) == true) goto L22;
        b.b(TAG, new Object[]{"read settingModelTmpFile lock failed: " + r101.getName()});
        return null;
    L22:
        if (r101.exists() == true) goto L23;
        r102.unlock();
        return null;
    L23:
        String r103 = f.c(new PolarisFileInputStreamWrapper(r101));     // Catch: Throwable -> L13 Exception -> L15
        r102.unlock();
        return r103;
    L15:
        e = move-exception;
        b.b(TAG, new Object[]{"readSettingTmpFileString", e});     // Catch: Throwable -> L13
        r102.unlock();
        return null;
    L13:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public final File createSettingTmpFile(BdpSettingsDao r100, SettingsModel r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getSettingFilePath() + DefaultDiskStorage.FileType.TEMP);
        LockObject.Companion.getClass();
        LockObject r103 = LockObject.a.a(r102);
        if (r103.tryLock(200) == true) goto L10;
        b.b(TAG, new Object[]{"write settingModelTmpFile lock failed: " + r102.getName()});
        return null;
    L10:
        if (r102.exists() == false) goto L23;
        r102.delete();
    L23:
        r102.createNewFile();     // Catch: Throwable -> L14 Exception -> L16
        f.f(r102.getAbsolutePath(), r101.toJson().toString());     // Catch: Throwable -> L14 Exception -> L16
    L19:
        r103.unlock();
        return r102;
    L16:
        e = move-exception;
        b.b(TAG, new Object[]{"newFile", e});     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r103.unlock();
        throw th;
    }
}
