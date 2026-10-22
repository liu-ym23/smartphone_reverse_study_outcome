package com.bytedance.bdp.appbase.settings.dao;

import android.content.Context;
import com.bytedance.bdp.appbase.settings.SettingsModel;
import com.bytedance.bdp.bdpbase.util.f;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import g94.b;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 &2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0005J\b\u0010\u0012\u001a\u00020\fH\u0014R\u001b\u0010\u0017\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/bdp/appbase/settings/dao/BdpSettingsDao;", "", "", "readFileString", "content", "", "writeFileString", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "bdpAppId", "Ljava/io/File;", "createSettingFile", "Lcom/bytedance/bdp/appbase/settings/SettingsModel;", "loadSettingsModel", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "saveSettingsModel", "getSettingFilePath", "clear", "emptyModel", "mFile$delegate", "Lkotlin/Lazy;", "getMFile", "()Ljava/io/File;", "mFile", "Lcom/bytedance/bdp/appbase/settings/dao/LockObject;", "mFileLock$delegate", "getMFileLock", "()Lcom/bytedance/bdp/appbase/settings/dao/LockObject;", "mFileLock", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mBdpAppId", "Ljava/lang/String;", "getMBdpAppId", "()Ljava/lang/String;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public class BdpSettingsDao {
    private static final String BASE_DIR_PATH = "bdp/settings";
    public static final a Companion = null;
    private static final String TAG = "BdpSettingsDao";
    private static final long TIME_OUT = 200;
    private final Context context;
    private final String mBdpAppId;
    private final Lazy mFile$delegate;
    private final Lazy mFileLock$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final File getMFile() {
        return (File) this.mFile$delegate.getValue();
    }

    public final LockObject getMFileLock() {
        return (LockObject) this.mFileLock$delegate.getValue();
    }

    public final boolean clear() {
        return writeFileString("");
    }

    public SettingsModel emptyModel() {
        return new SettingsModel(0, "", new JSONObject(), new JSONObject(), 0);
    }

    private final String readFileString() {
        if (getMFileLock().tryLock(200) == true) goto L18;
        b.b(TAG, new Object[]{"read lock failed: " + this.mBdpAppId});
        return null;
    L18:
        String r100 = f.c(new PolarisFileInputStreamWrapper(getMFile()));     // Catch: Throwable -> L9 Exception -> L11
        getMFileLock().unlock();
        return r100;
    L11:
        e = move-exception;
        b.b(TAG, new Object[]{"read", e});     // Catch: Throwable -> L9
        getMFileLock().unlock();
        return null;
    L9:
        th = move-exception;
        getMFileLock().unlock();
        throw th;
    }

    public final String getSettingFilePath() {
        return getMFile().getAbsolutePath();
    }

    public SettingsModel loadSettingsModel() {
        String r100 = readFileString();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        b.d(TAG, new Object[]{"read empty"});
        return emptyModel();
    L12:
        SettingsModel.Companion.getClass();
        SettingsModel r102 = SettingsModel.a.a(r100);
        if (r102 == null) goto L15;
        return r102;
    L15:
        return emptyModel();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getMBdpAppId() {
        return this.mBdpAppId;
    }

    private final boolean writeFileString(String r100) {
        if (getMFileLock().tryLock(200) == true) goto L18;
        b.b(TAG, new Object[]{"loadSettingsModel lock failed", this.mBdpAppId});
        return false;
    L18:
        boolean r101 = f.f(getMFile().getAbsolutePath(), r100);     // Catch: Throwable -> L9 Exception -> L11
        getMFileLock().unlock();
        return r101;
    L11:
        e = move-exception;
        b.b(TAG, new Object[]{"write", e});     // Catch: Throwable -> L9
        getMFileLock().unlock();
        return false;
    L9:
        th = move-exception;
        getMFileLock().unlock();
        throw th;
    }

    public boolean saveSettingsModel(SettingsModel r100) {
        return writeFileString(r100.toJson().toString());
    }

    public BdpSettingsDao(Context r100, String r101) {
        this.context = r100;
        this.mBdpAppId = r101;
        this.mFile$delegate = LazyKt.lazy(new BdpSettingsDao$mFile$2(this));
        this.mFileLock$delegate = LazyKt.lazy(new BdpSettingsDao$mFileLock$2(this));
    }

    private final File createSettingFile(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), "bdp/settings/" + r101 + ".settings");
        if (r102.exists() == false) goto L13;
        return r102;
    L13:
        File r103 = r102.getParentFile();     // Catch: Exception -> L10
        if (r103 == null) goto L8;
        r103.mkdirs();     // Catch: Exception -> L10
    L8:
        r102.createNewFile();     // Catch: Exception -> L10
    L12:
        return r102;
    L10:
        e = move-exception;
        b.b(TAG, new Object[]{"newFile", e});
        goto L12
    }

    public static final /* synthetic */ File access$createSettingFile(BdpSettingsDao r100, Context r101, String r102) {
        return r100.createSettingFile(r101, r102);
    }
}
