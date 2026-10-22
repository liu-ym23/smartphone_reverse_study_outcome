package com.obric.memorydata.intelligence.infra.job;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* JADX INFO: loaded from: classes6.dex */
public interface IScheduleJobDelegate {
    boolean onStartJob(JobService r100, JobParameters r101);

    boolean onStopJob(JobService r100, JobParameters r101);
}
