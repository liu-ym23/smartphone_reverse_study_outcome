package com.hihonor.mcs.system.diagnosis.core;

import java.io.Serializable;
import java.time.LocalDateTime;

/* JADX INFO: loaded from: classes23.dex */
public class BasePayload implements Serializable {
    private static final long serialVersionUID = 752392153128238245L;
    private LocalDateTime timeStampBegin;
    private LocalDateTime timeStampEnd;

    public BasePayload() {
    }

    public LocalDateTime getTimeStampBegin() {
        return this.timeStampBegin;
    }

    public LocalDateTime getTimeStampEnd() {
        return this.timeStampEnd;
    }

    public void setTimeStampBegin(LocalDateTime r100) {
        this.timeStampBegin = r100;
    }

    public void setTimeStampEnd(LocalDateTime r100) {
        this.timeStampEnd = r100;
    }
}
