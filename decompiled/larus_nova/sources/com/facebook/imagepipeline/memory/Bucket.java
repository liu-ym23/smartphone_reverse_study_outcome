package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class Bucket<V> {
    private static final String TAG = "BUCKET";
    private final boolean mFixBucketsReinitialization;
    final Queue mFreeList;
    private int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public void decrementInUseCount() {
        if (this.mInUseLength <= 0) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100);
        this.mInUseLength--;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public int getFreeListSize() {
        return this.mFreeList.size();
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public boolean isMaxLengthExceeded() {
        if ((this.mInUseLength + getFreeListSize()) <= this.mMaxLength) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public V pop() {
        return (V) this.mFreeList.poll();
    }

    @Nullable
    public V get() {
        V r100 = pop();
        if (r100 == null) goto L5;
        this.mInUseLength++;
    L5:
        return r100;
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }

    public void addToFreeList(V r100) {
        this.mFreeList.add(r100);
    }

    public void release(V r100) {
        Preconditions.checkNotNull(r100);
        boolean r101 = false;
        if (this.mFixBucketsReinitialization == true) goto L5;
        int r102 = this.mInUseLength;
        if (r102 <= 0) goto L11;
        this.mInUseLength = r102 - 1;
        addToFreeList(r100);
        return;
    L11:
        FLog.e(TAG, "Tried to release value %s from an empty bucket!", new Object[]{r100});
        return;
    L5:
        if (this.mInUseLength <= 0) goto L7;
        r101 = true;
    L7:
        Preconditions.checkState(r101);
        this.mInUseLength--;
        addToFreeList(r100);
    }

    public Bucket(int r100, int r101, int r102, boolean r103) {
        boolean r104 = true;
        if (r100 <= 0) goto L5;
        boolean r105 = true;
    L6:
        Preconditions.checkState(r105);
        if (r101 < 0) goto L9;
        boolean r106 = true;
    L10:
        Preconditions.checkState(r106);
        if (r102 >= 0) goto L14;
        r104 = false;
    L14:
        Preconditions.checkState(r104);
        this.mItemSize = r100;
        this.mMaxLength = r101;
        this.mFreeList = new LinkedList();
        this.mInUseLength = r102;
        this.mFixBucketsReinitialization = r103;
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
