package com.bytedance.mira.log;

/* JADX INFO: loaded from: classes21.dex */
public class JobWatcher {
    private String mJobTag;
    private long mLast;
    private long mStart;
    private String mTag;
    private String mWatcherName;

    public long getDuration() {
        return System.currentTimeMillis() - this.mStart;
    }

    public long finish(String r110) {
        long r100 = System.currentTimeMillis() - this.mLast;
        long r101 = System.currentTimeMillis() - this.mStart;
        MiraLogger.i(this.mTag, this.mJobTag + String.format(" watcher[%s]-%s cost=%s, total=%s", new Object[]{this.mWatcherName, r110, Long.valueOf(r100), Long.valueOf(r101)}));
        return r101;
    }

    public long jobFinish(String r100) {
        long r101 = System.currentTimeMillis() - this.mStart;
        MiraLogger.i(this.mTag, this.mJobTag + String.format(" watcher[%s] cost=%s", new Object[]{r100, Long.valueOf(r101)}));
        return r101;
    }

    public long record(String r100) {
        long r101 = System.currentTimeMillis() - this.mLast;
        MiraLogger.i(this.mTag, this.mJobTag + String.format(" watcher[%s]-%s cost=%s", new Object[]{this.mWatcherName, r100, Long.valueOf(r101)}));
        this.mLast = System.currentTimeMillis();
        return r101;
    }

    private JobWatcher(String r100, String r101) {
        this.mTag = r100;
        this.mJobTag = r101;
        this.mStart = System.currentTimeMillis();
    }

    public static JobWatcher start(String r100, String r101) {
        return new JobWatcher(r100, r101);
    }

    private JobWatcher(String r100, String r101, String r102) {
        this.mTag = r100;
        this.mJobTag = r101;
        this.mWatcherName = r102;
        long r103 = System.currentTimeMillis();
        this.mLast = r103;
        this.mStart = r103;
        MiraLogger.i(this.mTag, this.mJobTag + String.format(" watcher[%s]-start", new Object[]{r102}));
    }

    public static JobWatcher start(String r100, String r101, String r102) {
        return new JobWatcher(r100, r101, r102);
    }
}
