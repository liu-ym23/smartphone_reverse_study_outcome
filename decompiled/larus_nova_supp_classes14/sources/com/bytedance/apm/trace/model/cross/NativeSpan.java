package com.bytedance.apm.trace.model.cross;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import dt3.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class NativeSpan {
    private long finishTime;
    private boolean isErrorSpan;
    private boolean isFinish;
    private String parentId;
    private String referenceId;
    private String spanId;
    private String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public a parseToSpan(gt3.a r2) {
        if (this.isFinish == true) goto L5;
        return null;
    L5:
        CastLongProtector.parseLong(this.spanId);
        throw null;
    }

    public NativeSpan(String r1, String r2, String r3, String r4, long r5, long r7, String r9, HashMap<String, String> r10, boolean r11, boolean r12) {
        this.spanName = r1;
        this.spanId = r2;
        this.parentId = r3;
        this.referenceId = r4;
        this.startTime = r5;
        this.finishTime = r7;
        this.threadName = r9;
        this.tags = r10;
        this.isErrorSpan = r11;
        this.isFinish = r12;
    }
}
