package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import wra.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    public static class b {
        public final Context a;
        public int b;
        public int c;
        public String d;
        public boolean e;
        public boolean f;
        public boolean g;

        public final ALogConfig a() {
            String r1 = null;
            ALogConfig r0 = new ALogConfig(r1);
            r0.setContext(this.a);
            r0.setLogFileExpDays(14);
            r0.setMaxDirSize(this.b);
            r0.setSubProcessMaxDirSizeRatio(0.1f);
            r0.setPerSize(this.c);
            if (TextUtils.isEmpty(null) == false) goto L5;
            r1 = a.a(this.a);
        L5:
            r0.setBufferDirPath(r1);
            if (TextUtils.isEmpty(this.d) == false) goto L11;
            PolarisFileWrapper r2 = new PolarisFileWrapper(this.a.getFilesDir(), "logs");
            if (r2.exists() == true) goto L10;
            r2.mkdir();
        L10:
            String r3 = r2.getAbsolutePath();
        L12:
            r0.setLogDirPath(r3);
            r0.setCompress(true);
            r0.setEncrypt(true);
            r0.setLevel(3);
            r0.setPubKey("fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f");
            r0.setMainThreadSpeedUp(true);
            r0.setOffloadMainThreadWrite(this.e);
            r0.setEnableOffloadInAllProcess(this.f);
            r0.setEnableOffloadInAllThread(false);
            r0.setNewThreadPoolImplementation(this.g);
            r0.enableNewCompression(false);
            r0.setCacheFileSizeInKB(64);
            return r0;
        L11:
            r3 = this.d;
            goto L12
        }

        public b(Context r2) {
            this.b = 20971520;
            this.c = 1048576;
            this.e = false;
            this.f = false;
            this.g = false;
            if (r2 == null) goto L10;
            Context r0 = r2.getApplicationContext();
            if (r0 == null) goto L7;
            r2 = r0;
        L7:
            this.a = r2;
            return;
        L10:
            throw new RuntimeException("context must not be null");
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

    public /* synthetic */ ALogConfig(a r1) {
        this();
    }

    public void enableNewCompression(boolean r1) {
        this.newCompression = r1;
    }

    public void setBufferDirPath(String r1) {
        this.bufferDirPath = r1;
    }

    public void setCacheFileSizeInKB(int r1) {
        this.cacheFileSizeInKB = r1;
    }

    public void setCompress(boolean r1) {
        this.compress = r1;
    }

    public void setContext(Context r1) {
        this.context = r1;
    }

    public void setEnableOffloadInAllProcess(boolean r1) {
        this.enableOffloadInAllProcess = r1;
    }

    public void setEnableOffloadInAllThread(boolean r1) {
        this.enableOffloadInAllThread = r1;
    }

    public void setEncrypt(boolean r1) {
        this.encrypt = r1;
    }

    public void setLevel(int r1) {
        this.level = r1;
    }

    public void setLogDirPath(String r1) {
        this.logDirPath = r1;
    }

    public void setLogFileExpDays(int r1) {
        this.logFileExpDays = r1;
    }

    public void setMainThreadSpeedUp(boolean r1) {
        this.mainThreadSpeedUp = r1;
    }

    public void setMaxDirSize(int r1) {
        this.maxDirSize = r1;
    }

    public void setNewThreadPoolImplementation(boolean r1) {
        this.newThreadPoolImplementation = r1;
    }

    public void setOffloadMainThreadWrite(boolean r1) {
        this.offloadMainThreadWrite = r1;
    }

    public void setPerSize(int r1) {
        this.perSize = r1;
    }

    public void setPubKey(String r1) {
        this.pubKey = r1;
    }

    public void setSubProcessMaxDirSizeRatio(float r1) {
        this.subProcessMaxDirSizeRatio = r1;
    }
}
