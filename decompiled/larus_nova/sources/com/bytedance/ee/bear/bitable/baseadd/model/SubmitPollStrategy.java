package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitPollStrategy;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", VideoThumbInfo.KEY_INTERVAL, "", "getInterval", "()I", "setInterval", "(I)V", "maxCount", "getMaxCount", "setMaxCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitPollStrategy implements NonProguard {
    private int interval;
    private int maxCount;

    public SubmitPollStrategy() {
        this.interval = 1;
        this.maxCount = 5;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final void setInterval(int r100) {
        this.interval = r100;
    }

    public final void setMaxCount(int r100) {
        this.maxCount = r100;
    }
}
