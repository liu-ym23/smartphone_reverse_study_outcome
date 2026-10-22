package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class Segment {
    private static final String TAG = "Segment";
    int competitor;
    private final AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private JSONObject jsonObject;
    volatile SegmentReader owner;
    private final long startOffset;

    public interface JsonKey {
        public static final String CURRENT = "cu";
        public static final String END = "en";
        public static final String START = "st";
    }

    public void decreaseCompetitor() {
        this.competitor--;
    }

    public long getCurrentOffset() {
        long r100 = this.currentOffset.get();
        long r101 = this.endOffset;
        if (r101 <= 0) goto L7;
        long r102 = r101 + 1;
        if (r100 <= r102) goto L7;
        return r102;
    L7:
        return r100;
    }

    public long getCurrentOffsetRead() {
        SegmentReader r100 = this.owner;
        if (r100 == null) goto L8;
        long r101 = r100.getCurSegmentReadOffset();
        if (r101 <= this.currentOffsetRead) goto L8;
        return r101;
    L8:
        return this.currentOffsetRead;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long r100 = this.endOffset;
        if (r100 >= this.startOffset) goto L5;
        return -1;
    L5:
        return (r100 - this.currentOffset.get()) + 1;
    }

    public long getRemainReadBytes() {
        long r100 = this.endOffset;
        if (r100 >= this.startOffset) goto L5;
        return -1;
    L5:
        return (r100 - getCurrentOffsetRead()) + 1;
    }

    public void increaseCompetitor() {
        this.competitor++;
    }

    public boolean isDownloaded() {
        if (this.endOffset >= this.startOffset) goto L5;
    L7:
        return false;
    L5:
        if (this.currentOffset.get() <= this.endOffset) goto L7;
        return true;
    }

    public boolean isReadFinish() {
        if (this.endOffset >= this.startOffset) goto L5;
    L7:
        return false;
    L5:
        if (getCurrentOffsetRead() <= this.endOffset) goto L7;
        return true;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r100 = this.jsonObject;
        if (r100 != null) goto L5;
        r100 = new JSONObject();
        this.jsonObject = r100;
    L5:
        r100.put(JsonKey.START, getStartOffset());
        r100.put(JsonKey.CURRENT, getCurrentOffset());
        r100.put("en", getEndOffset());
        return r100;
    }

    public String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + this.currentOffset + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + '}';
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public int getCompetitor() {
        return this.competitor;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public int getIndex() {
        return this.index;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public Segment(JSONObject r100) {
        this.currentOffset = new AtomicLong();
        this.competitor = 0;
        this.startOffset = r100.optLong(JsonKey.START);
        setEndOffset(r100.optLong("en"));
        setCurrentOffset(r100.optLong(JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }

    public static String toString(List<Segment> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L15;
        Collections.sort(r100, new AnonymousClass1());
        StringBuilder r101 = new StringBuilder();
        Iterator<Segment> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r101.append(r102.next());
        r101.append("\r\n");
        goto L8
    L11:
        return r101.toString();
    L15:
        return null;
    }

    public void increaseCurrentOffset(long r100) {
        this.currentOffset.addAndGet(r100);
    }

    public void setCompetitor(int r100) {
        this.competitor = r100;
    }

    public void setCurrentOffset(long r100) {
        long r101 = this.startOffset;
        if (r100 >= r101) goto L5;
        r100 = r101;
    L5:
        long r102 = this.endOffset;
        if (r102 <= 0) goto L10;
        long r103 = r102 + 1;
        if (r100 <= r103) goto L10;
        r100 = r103;
    L10:
        this.currentOffset.set(r100);
    }

    public void setCurrentOffsetRead(long r100) {
        if (r100 < this.currentOffset.get()) goto L6;
        this.currentOffsetRead = r100;
        return;
    }

    public void setEndOffset(long r100) {
        if (r100 < this.startOffset) goto L6;
        this.endOffset = r100;
        return;
    L6:
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "setEndOffset", "EndOffset = " + r100 + ", segment = " + this);
    L9:
        if (r100 != (-1)) goto L13;
        this.endOffset = r100;
        return;
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    public Segment(Segment r100) {
        AtomicLong r101 = new AtomicLong();
        this.currentOffset = r101;
        this.competitor = 0;
        this.startOffset = r100.startOffset;
        this.endOffset = r100.endOffset;
        r101.set(r100.currentOffset.get());
        this.currentOffsetRead = r101.get();
        this.index = r100.index;
    }

    public Segment(long r100) {
        this(r100, -1);
    }

    public Segment(long r100, long r101) {
        AtomicLong r102 = new AtomicLong();
        this.currentOffset = r102;
        this.competitor = 0;
        this.startOffset = r100;
        r102.set(r100);
        this.currentOffsetRead = r100;
        if (r101 < r100) goto L5;
        this.endOffset = r101;
        return;
    L5:
        this.endOffset = -1;
    }
}
