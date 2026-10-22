package hx5;

import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private NetworkAsyncTaskType mTaskType;
    private TimeUnit mTimeUnit;

    public boolean isLoop() {
        if (this.mLoopInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a() {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public NetworkAsyncTaskType getTaskType() {
        return this.mTaskType;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public a(long r100) {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = r100;
    }

    public void setTaskType(NetworkAsyncTaskType r100) {
        this.mTaskType = r100;
    }

    public a(long r100, long r101) {
        this(r101);
        this.mInitialDelay = r100;
    }

    public a(long r100, long r101, TimeUnit r102) {
        this(r100, r101);
        this.mTimeUnit = r102;
    }
}
