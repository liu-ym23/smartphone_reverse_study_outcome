package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class JobScheduler {
    static final String QUEUE_TIME_KEY = "queueTime";
    private final Runnable mDoJobRunnable;
    EncodedImage mEncodedImage;
    private final Executor mExecutor;
    private final JobRunnable mJobRunnable;
    long mJobStartTime;
    JobState mJobState;
    long mJobSubmitTime;
    private final int mMinimumJobIntervalMs;
    int mStatus;
    private final Runnable mSubmitJobRunnable;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.JobScheduler$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = null;

        static {
            int[] r100 = new int[JobState.values().length];
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = r100;
            r100[JobState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING_AND_PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface JobRunnable {
        void run(EncodedImage r100, int r101);
    }

    public static class JobStartExecutorSupplier {
        private static ScheduledExecutorService sJobStarterExecutor;

        public JobStartExecutorSupplier() {
        }

        public static ScheduledExecutorService get() {
            if (sJobStarterExecutor != null) goto L6;
            sJobStarterExecutor = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("JobScheduler$JobStartExecutorSupplier"));
        L6:
            return sJobStarterExecutor;
        }
    }

    public static final enum JobState extends Enum<JobState> {
        private static final /* synthetic */ JobState[] $VALUES = null;
        public static final JobState IDLE = null;
        public static final JobState QUEUED = null;
        public static final JobState RUNNING = null;
        public static final JobState RUNNING_AND_PENDING = null;

        static {
            JobState r100 = new JobState("IDLE", 0);
            IDLE = r100;
            JobState r101 = new JobState("QUEUED", 1);
            QUEUED = r101;
            JobState r102 = new JobState("RUNNING", 2);
            RUNNING = r102;
            JobState r103 = new JobState("RUNNING_AND_PENDING", 3);
            RUNNING_AND_PENDING = r103;
            $VALUES = new JobState[]{r100, r101, r102, r103};
        }

        public static JobState[] values() {
            return (JobState[]) $VALUES.clone();
        }

        public static JobState valueOf(String r100) {
            return (JobState) Enum.valueOf(JobState.class, r100);
        }

        private JobState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class PriorityJobRunnable implements JobRunnable {
        private Priority mPriority;

        public Priority getPriority() {
            return this.mPriority;
        }

        public PriorityJobRunnable(Priority r100) {
            this.mPriority = r100;
        }
    }

    public void clearJob() {
        monitor-enter(this);
        EncodedImage r100 = this.mEncodedImage;     // Catch: Throwable -> L7
        this.mEncodedImage = null;     // Catch: Throwable -> L7
        this.mStatus = 0;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        EncodedImage.closeSafely(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized long getQueuedTime() {
        monitor-enter(this);
        long r100 = this.mJobStartTime - this.mJobSubmitTime;
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private void submitJob() {
        this.mExecutor.execute(this.mDoJobRunnable);
    }

    private void doJob() {
        long r100 = SystemClock.uptimeMillis();
        monitor-enter(this);
        EncodedImage r101 = this.mEncodedImage;     // Catch: Throwable -> L14
        int r102 = this.mStatus;     // Catch: Throwable -> L14
        this.mEncodedImage = null;     // Catch: Throwable -> L14
        this.mStatus = 0;     // Catch: Throwable -> L14
        this.mJobState = JobState.RUNNING;     // Catch: Throwable -> L14
        this.mJobStartTime = r100;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        EncodedImage.closeSafely(r101);
        onJobFinished();
        throw th;
    L7:
        if (shouldProcess(r101, r102) == false) goto L9;
        this.mJobRunnable.run(r101, r102);     // Catch: Throwable -> L11
    L9:
        EncodedImage.closeSafely(r101);
        onJobFinished();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void onJobFinished() {
        long r100 = SystemClock.uptimeMillis();
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mJobState != JobState.RUNNING_AND_PENDING) goto L7;
        long r101 = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), r100);     // Catch: Throwable -> L12
        this.mJobSubmitTime = r100;     // Catch: Throwable -> L12
        this.mJobState = JobState.QUEUED;     // Catch: Throwable -> L12
        boolean r102 = true;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r102 == false) goto L17;
        enqueueJob(r101 - r100);
        return;
    L17:
        return;
    L7:
        this.mJobState = JobState.IDLE;     // Catch: Throwable -> L12
        r101 = 0;
        r102 = false;
        goto L8
    }

    public boolean scheduleJob() {
        long r100 = SystemClock.uptimeMillis();
        monitor-enter(this);
        boolean r101 = false;
        if (shouldProcess(this.mEncodedImage, this.mStatus) == true) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L8:
        int r102 = AnonymousClass4.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];     // Catch: Throwable -> L20
        if (r102 != 1) goto L11;
        long r103 = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), r100);     // Catch: Throwable -> L20
        this.mJobSubmitTime = r100;     // Catch: Throwable -> L20
        this.mJobState = JobState.QUEUED;     // Catch: Throwable -> L20
        r101 = true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r101 == false) goto L19;
        enqueueJob(r103 - r100);
    L19:
        return true;
    L11:
        if (r102 != 3) goto L14;
        this.mJobState = JobState.RUNNING_AND_PENDING;     // Catch: Throwable -> L20
    L14:
        r103 = 0;
    L20:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(JobScheduler r100) {
        r100.doJob();
    }

    public static /* synthetic */ void access$100(JobScheduler r100) {
        r100.submitJob();
    }

    private void enqueueJob(long r100) {
        if (r100 <= 0) goto L5;
        JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, r100, TimeUnit.MILLISECONDS);
        return;
    L5:
        this.mSubmitJobRunnable.run();
    }

    private static boolean shouldProcess(EncodedImage r100, int r101) {
        if (BaseConsumer.isLast(r101) == false) goto L5;
    L10:
        return true;
    L5:
        if (BaseConsumer.statusHasFlag(r101, 4) == true) goto L10;
        if (EncodedImage.isValid(r100) == true) goto L10;
        return false;
    }

    public boolean updateJob(EncodedImage r100, int r101) {
        if (shouldProcess(r100, r101) == true) goto L6;
        return false;
    L6:
        monitor-enter(this);
        EncodedImage r102 = this.mEncodedImage;     // Catch: Throwable -> L11
        this.mEncodedImage = EncodedImage.cloneOrNull(r100);     // Catch: Throwable -> L11
        this.mStatus = r101;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        EncodedImage.closeSafely(r102);
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    public JobScheduler(Executor r100, JobRunnable r101, int r102) {
        this.mExecutor = r100;
        this.mJobRunnable = r101;
        this.mMinimumJobIntervalMs = r102;
        if ((r101 instanceof PriorityJobRunnable) == false) goto L5;
        final int r103 = Priority.getIntPriorityValue(((PriorityJobRunnable) r101).getPriority());
        this.mDoJobRunnable = new AnonymousClass1(this, r103);
    L6:
        this.mSubmitJobRunnable = new AnonymousClass3(this);
        this.mEncodedImage = null;
        this.mStatus = 0;
        this.mJobState = JobState.IDLE;
        this.mJobSubmitTime = 0;
        this.mJobStartTime = 0;
        return;
    L5:
        this.mDoJobRunnable = new AnonymousClass2(this);
        goto L6
    }
}
