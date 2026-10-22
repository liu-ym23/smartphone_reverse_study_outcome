package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class ALogConfig {
    private String bufferDirPath;
    private int cacheFileSizeInKB;
    private boolean compress;
    private Context context;
    private boolean enableOffloadInAllProcess;
    private boolean enableOffloadInAllThread;
    private boolean encrypt;
    private int level;
    private String logDirPath;
    private int logFileExpDays;
    private boolean mainThreadSpeedUp;
    private int maxDirSize;
    private boolean newCompression;
    private boolean newThreadPoolImplementation;
    private boolean offloadMainThreadWrite;
    private int perSize;
    private String pubKey;
    private float subProcessMaxDirSizeRatio;

    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f406441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f406442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f406443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f406444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f406445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f406446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f406447g;

        /* JADX WARN: Multi-variable type inference failed */
        public final ALogConfig a() {
            String r100 = null;
            ALogConfig r101 = new ALogConfig(0 == true ? 1 : 0);
            r101.setContext(this.f406441a);
            r101.setLogFileExpDays(14);
            r101.setMaxDirSize(this.f406442b);
            r101.setSubProcessMaxDirSizeRatio(0.1f);
            r101.setPerSize(this.f406443c);
            if (TextUtils.isEmpty(null) == false) goto L5;
            r100 = wra.a.a(this.f406441a);
        L5:
            r101.setBufferDirPath(r100);
            if (TextUtils.isEmpty(this.f406444d) == false) goto L11;
            PolarisFileWrapper r102 = new PolarisFileWrapper(this.f406441a.getFilesDir(), LogUtil.DIR_TAIL);
            if (r102.exists() == true) goto L10;
            r102.mkdir();
        L10:
            String r103 = r102.getAbsolutePath();
        L12:
            r101.setLogDirPath(r103);
            r101.setCompress(true);
            r101.setEncrypt(true);
            r101.setLevel(3);
            r101.setPubKey("fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f");
            r101.setMainThreadSpeedUp(true);
            r101.setOffloadMainThreadWrite(this.f406445e);
            r101.setEnableOffloadInAllProcess(this.f406446f);
            r101.setEnableOffloadInAllThread(false);
            r101.setNewThreadPoolImplementation(this.f406447g);
            r101.enableNewCompression(false);
            r101.setCacheFileSizeInKB(64);
            return r101;
        L11:
            r103 = this.f406444d;
            goto L12
        }

        public b(Context r100) {
            this.f406442b = 20971520;
            this.f406443c = 1048576;
            this.f406445e = false;
            this.f406446f = false;
            this.f406447g = false;
            if (r100 == null) goto L10;
            Context r101 = r100.getApplicationContext();
            if (r101 == null) goto L7;
            r100 = r101;
        L7:
            this.f406441a = r100;
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }
    }

    private ALogConfig() {
    }

    public boolean enableOffloadInAllProcess() {
        return this.enableOffloadInAllProcess;
    }

    public boolean enableOffloadInAllThread() {
        return this.enableOffloadInAllThread;
    }

    public String getBufferDirPath() {
        return this.bufferDirPath;
    }

    public int getCacheFileSizeInKB() {
        return this.cacheFileSizeInKB;
    }

    public Context getContext() {
        return this.context;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLogDirPath() {
        return this.logDirPath;
    }

    public int getLogFileExpDays() {
        return this.logFileExpDays;
    }

    public int getMaxDirSize() {
        return this.maxDirSize;
    }

    public int getPerSize() {
        return this.perSize;
    }

    public String getPubKey() {
        return this.pubKey;
    }

    public float getSubProcessMaxDirSizeRatio() {
        return this.subProcessMaxDirSizeRatio;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public boolean isEnableNewCompression() {
        return this.newCompression;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public boolean isMainThreadSpeedUp() {
        return this.mainThreadSpeedUp;
    }

    public boolean isNewThreadPoolImplementation() {
        return this.newThreadPoolImplementation;
    }

    public boolean isOffloadMainThreadWrite() {
        return this.offloadMainThreadWrite;
    }

    public /* synthetic */ ALogConfig(a r100) {
        this();
    }

    public void enableNewCompression(boolean r100) {
        this.newCompression = r100;
    }

    public void setBufferDirPath(String r100) {
        this.bufferDirPath = r100;
    }

    public void setCacheFileSizeInKB(int r100) {
        this.cacheFileSizeInKB = r100;
    }

    public void setCompress(boolean r100) {
        this.compress = r100;
    }

    public void setContext(Context r100) {
        this.context = r100;
    }

    public void setEnableOffloadInAllProcess(boolean r100) {
        this.enableOffloadInAllProcess = r100;
    }

    public void setEnableOffloadInAllThread(boolean r100) {
        this.enableOffloadInAllThread = r100;
    }

    public void setEncrypt(boolean r100) {
        this.encrypt = r100;
    }

    public void setLevel(int r100) {
        this.level = r100;
    }

    public void setLogDirPath(String r100) {
        this.logDirPath = r100;
    }

    public void setLogFileExpDays(int r100) {
        this.logFileExpDays = r100;
    }

    public void setMainThreadSpeedUp(boolean r100) {
        this.mainThreadSpeedUp = r100;
    }

    public void setMaxDirSize(int r100) {
        this.maxDirSize = r100;
    }

    public void setNewThreadPoolImplementation(boolean r100) {
        this.newThreadPoolImplementation = r100;
    }

    public void setOffloadMainThreadWrite(boolean r100) {
        this.offloadMainThreadWrite = r100;
    }

    public void setPerSize(int r100) {
        this.perSize = r100;
    }

    public void setPubKey(String r100) {
        this.pubKey = r100;
    }

    public void setSubProcessMaxDirSizeRatio(float r100) {
        this.subProcessMaxDirSizeRatio = r100;
    }
}
