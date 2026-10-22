package com.bytedance.ee.bear.tts.m3u8;

import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
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
        TtsToneBean r100 = null;
        TtsM3U8Bean r101 = (TtsM3U8Bean) super.clone();     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L9;
        r101 = new TtsM3U8Bean();
    L9:
        r101.taskId = this.taskId;
        r101.revisionId = this.revisionId;
        r101.downloadLink = this.downloadLink;
        r101.mainLanguageCode = this.mainLanguageCode;
        r101.expireTimeMS = this.expireTimeMS;
        r101.isServerComplete = this.isServerComplete;
        r101.serverPredictDurationMs = this.serverPredictDurationMs;
        r101.serverRealDurationMs = this.serverRealDurationMs;
        r101.isSegmentComplete = this.isSegmentComplete;
        r101.segmentFirstOffsetMs = this.segmentFirstOffsetMs;
        r101.segmentSumDurationMs = this.segmentSumDurationMs;
        r101.anchorSegmentId = this.anchorSegmentId;
        r101.anchorSegmentOffsetMs = this.anchorSegmentOffsetMs;
        TtsToneBean r102 = this.toneBean;
        if (r102 == null) goto L13;
        r100 = r102.clone();
    L13:
        r101.toneBean = r100;
        r101.rawContent = this.rawContent;
        return r101;
    L5:
        e = move-exception;
        a.e("TtsM3U8Bean", "clone, error:", e, false);
        r101 = null;
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
    public /* bridge */ /* synthetic */ Object m8334clone() throws CloneNotSupportedException {
        return clone();
    }
}
