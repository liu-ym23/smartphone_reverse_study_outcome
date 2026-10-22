package com.bytedance.awemeopen.infra.plugs.settings.dao;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsModel;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\fH\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/dao/AoSettingsDao;", "", "", "readFileString", "content", "", "writeFileString", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "bdpAppId", "Ljava/io/File;", "createSettingFile", "Lcom/bytedance/awemeopen/infra/plugs/settings/SettingsModel;", "loadSettingsModel", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "saveSettingsModel", "clear", "emptyModel", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mBdpAppId", "Ljava/lang/String;", "getMBdpAppId", "()Ljava/lang/String;", "mFile$delegate", "Lkotlin/Lazy;", "getMFile", "()Ljava/io/File;", "mFile", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getRwLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1})
public class AoSettingsDao {
    private static final String BASE_DIR_PATH = "awemeopen/settings";
    public static final a Companion = null;
    private static final String TAG = "AoSettingsDao";
    private static final long TIME_OUT = 500;
    private final Context context;
    private final String mBdpAppId;
    private final Lazy mFile$delegate;
    private final ReentrantReadWriteLock rwLock;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final synchronized String readFileString() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        if (this.rwLock.readLock().tryLock(500, TimeUnit.MILLISECONDS) == true) goto L26;
        AoLogger.c(TAG, new Object[]{"read lock failed: " + this.mBdpAppId});     // Catch: Throwable -> L22
        AoNpthService r100 = AoExceptionReporter.f198706a;     // Catch: Throwable -> L22
        AoExceptionReporter.b(ErrorPriority.f198712p2, TAG, "readFileString_lock", "wait_timeout", 16);     // Catch: Throwable -> L22
        monitor-exit(this);
        return null;
    L26:
        String r101 = f.b(new PolarisFileInputStreamWrapper(getMFile()));     // Catch: Throwable -> L13 Exception -> L15
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r101;
    L15:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"read", e});     // Catch: Throwable -> L13
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        return null;
    L13:
        th = move-exception;
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    }

    public final boolean clear() {
        return writeFileString("");
    }

    public SettingsModel emptyModel() {
        return new SettingsModel(0, new JSONObject());
    }

    public final File getMFile() {
        return (File) this.mFile$delegate.getValue();
    }

    public SettingsModel loadSettingsModel() {
        String r100 = readFileString();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        AoLogger.g(TAG, new Object[]{"read empty"});
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

    public final ReentrantReadWriteLock getRwLock() {
        return this.rwLock;
    }

    private final boolean writeFileString(String r100) {
        if (this.rwLock.writeLock().tryLock(500, TimeUnit.MILLISECONDS) == true) goto L18;
        AoLogger.c(TAG, new Object[]{"loadSettingsModel lock failed", this.mBdpAppId});
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198712p2, TAG, "writeFileString_lock", "wait_timeout", 16);
        return false;
    L18:
        boolean r102 = f.d(getMFile().getAbsolutePath(), r100);     // Catch: Throwable -> L9 Exception -> L11
        this.rwLock.writeLock().unlock();
        return r102;
    L11:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"write", e});     // Catch: Throwable -> L9
        this.rwLock.writeLock().unlock();
        return false;
    L9:
        th = move-exception;
        this.rwLock.writeLock().unlock();
        throw th;
    }

    public boolean saveSettingsModel(SettingsModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return writeFileString(r100.toJson().toString());
    }

    public AoSettingsDao(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mBdpAppId");
        this.context = r100;
        this.mBdpAppId = r101;
        this.mFile$delegate = LazyKt.lazy(new AoSettingsDao$mFile$2(this));
        this.rwLock = new ReentrantReadWriteLock();
    }

    private final File createSettingFile(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), "awemeopen/settings/" + r101 + ".settings");
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
        AoLogger.c(TAG, new Object[]{"newFile", e});
        goto L12
    }

    public static final /* synthetic */ File access$createSettingFile(AoSettingsDao r100, Context r101, String r102) {
        return r100.createSettingFile(r101, r102);
    }
}
