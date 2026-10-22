package com.larksuite.rucket.job.base;

import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes24.dex */
public interface a<P extends RucketJob<?>> {
    void setNextJob(P r100);

    void setPrevJob(P r100);
}
