package com.ss.ttm.player;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems;
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        public long getDuration() {
            return this.mDuration;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public SidxItem(int r100, long r101, long r102, long r103, long r104) {
            this.mIndex = r100;
            this.mOffset = r101;
            this.mTimestamp = r102;
            this.mDuration = r103;
            this.mSize = r104;
        }
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public SidxItem getItem(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.mItems.size()) goto L6;
        return null;
    L6:
        return (SidxItem) ListProtector.get(this.mItems, r100);
    }

    public void addItem(int r110, long r111, long r112, long r113, long r210) {
        this.mItems.add(new SidxItem(r110, r111, r112, r113, r210));
    }

    public SidxListObject(int r100, int r101, int r102, int r103, long r104, String r105) {
        this.mMediaType = r100;
        this.mTotalNum = r101;
        this.mStartIndex = r102;
        this.mEndIndex = r103;
        this.mBitrate = r104;
        this.mFileId = r105;
        this.mItems = new ArrayList();
    }
}
