package com.ss.bytertc.engine.type;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ProblemFeedbackInfo {
    public String problemDesc;
    public List<ProblemFeedbackRoomInfo> roomInfo;

    public ProblemFeedbackRoomInfo[] getRoomInfo() {
        List<ProblemFeedbackRoomInfo> r100 = this.roomInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (ProblemFeedbackRoomInfo[]) r100.toArray(new ProblemFeedbackRoomInfo[0]);
    }

    public ProblemFeedbackInfo() {
    }

    public String getProblemDesc() {
        return this.problemDesc;
    }

    public ProblemFeedbackInfo(String r100) {
        this.problemDesc = r100;
    }
}
