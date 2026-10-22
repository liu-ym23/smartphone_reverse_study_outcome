package com.ss.bytertc.engine.video;

import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class ExpressionDetectResult {
    public static final int MAX_COUNT = 10;
    public ExpressionDetectInfo[] detectInfo;
    public int detectResult;
    public int faceCount;

    public String toString() {
        return "ExpressionDetectResult{detectResult=" + this.detectResult + ", detectInfo=" + Arrays.toString(this.detectInfo) + '}';
    }

    public ExpressionDetectResult() {
        this.detectResult = 0;
        this.faceCount = 0;
    }
}
