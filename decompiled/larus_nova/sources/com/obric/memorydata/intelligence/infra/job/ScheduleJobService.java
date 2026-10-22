package com.obric.memorydata.intelligence.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* JADX INFO: loaded from: classes6.dex */
public class ScheduleJobService extends JobService {
    public ScheduleJobService() {
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r100) {
        IScheduleJobDelegate r101 = ScheduleJobRegistry.getDelegate();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onStartJob(this, r100);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r100) {
        IScheduleJobDelegate r101 = ScheduleJobRegistry.getDelegate();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onStopJob(this, r100);
    }
}
