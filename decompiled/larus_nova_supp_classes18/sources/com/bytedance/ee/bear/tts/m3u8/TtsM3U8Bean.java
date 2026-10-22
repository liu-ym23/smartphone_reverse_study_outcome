package com.bytedance.ee.bear.tts.m3u8;

import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TtsM3U8Bean implements Serializable, Cloneable {
    public String anchorSegmentId;
    public long anchorSegmentOffsetMs;
    public String downloadLink;
    public long expireTimeMS;
    public boolean isSegmentComplete;
    public boolean isServerComplete;
    public String mainLanguageCode;
    public String rawContent;
    public int revisionId;
    public long segmentFirstOffsetMs;
    public long segmentSumDurationMs;
    public long serverPredictDurationMs;
    public long serverRealDurationMs;
    public String taskId;
    public TtsToneBean toneBean;

    public TtsM3U8Bean clone() {
        TtsToneBean r0 = null;
        TtsM3U8Bean r1 = (TtsM3U8Bean) super.clone();     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L9;
        r1 = new TtsM3U8Bean();
    L9:
        r1.taskId = this.taskId;
        r1.revisionId = this.revisionId;
        r1.downloadLink = this.downloadLink;
        r1.mainLanguageCode = this.mainLanguageCode;
        r1.expireTimeMS = this.expireTimeMS;
        r1.isServerComplete = this.isServerComplete;
        r1.serverPredictDurationMs = this.serverPredictDurationMs;
        r1.serverRealDurationMs = this.serverRealDurationMs;
        r1.isSegmentComplete = this.isSegmentComplete;
        r1.segmentFirstOffsetMs = this.segmentFirstOffsetMs;
        r1.segmentSumDurationMs = this.segmentSumDurationMs;
        r1.anchorSegmentId = this.anchorSegmentId;
        r1.anchorSegmentOffsetMs = this.anchorSegmentOffsetMs;
        TtsToneBean r2 = this.toneBean;
        if (r2 == null) goto L13;
        r0 = r2.clone();
    L13:
        r1.toneBean = r0;
        r1.rawContent = this.rawContent;
        return r1;
    L5:
        e = move-exception;
        a.e("TtsM3U8Bean", "clone, error:", e, false);
        r1 = null;
        goto L7
    }

    public TtsM3U8Bean() {
        this.taskId = "";
        this.revisionId = 0;
        this.downloadLink = null;
        this.mainLanguageCode = "";
        this.expireTimeMS = 0;
        this.isServerComplete = false;
        this.serverPredictDurationMs = 0;
        this.serverRealDurationMs = 0;
        this.isSegmentComplete = false;
        this.segmentFirstOffsetMs = 0;
        this.segmentSumDurationMs = 0;
        this.anchorSegmentId = null;
        this.anchorSegmentOffsetMs = 0;
        this.toneBean = null;
        this.rawContent = null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m622clone() throws CloneNotSupportedException {
        return clone();
    }
}
