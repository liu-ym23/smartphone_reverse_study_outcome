package com.ss.texturerender.overlay;

import com.alipay.sdk.m.u.i;
import java.io.Serializable;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes40.dex */
public class FrameTimeQueue {
    private LinkedList<FrameTime> mTimeQueue;

    public static class FrameTime implements Serializable {
        public long pts;
        public long updateClockTime;

        public FrameTime(long r100, long r101) {
            this.pts = r100;
            this.updateClockTime = r101;
        }
    }

    public void clear() {
        this.mTimeQueue.clear();
    }

    public FrameTime getLast() {
        return this.mTimeQueue.getLast();
    }

    public int getSize() {
        return this.mTimeQueue.size();
    }

    public String toString() {
        String r100 = "";
        int r101 = 0;
    L4:
        if (r101 >= this.mTimeQueue.size()) goto L6;
        r100 = r100 + "pts[" + r101 + "]:" + this.mTimeQueue.get(r101).pts + i.f25853b;
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public FrameTimeQueue() {
        this.mTimeQueue = new LinkedList();
    }

    public void add(FrameTime r100) {
        this.mTimeQueue.offer(r100);
    }

    public FrameTime poll(long r100) {
        FrameTime r101 = null;
    L4:
        if (this.mTimeQueue.isEmpty() == true) goto L20;
        long r102 = this.mTimeQueue.element().updateClockTime;
        if (r100 > r102) goto L17;
        if (r101 == null) goto L9;
        long r103 = r101.updateClockTime;
        if (r100 <= r103) goto L17;
        if ((r100 - r103) >= (r102 - r100)) goto L16;
        return r101;
    L16:
        return this.mTimeQueue.poll();
    L9:
        return this.mTimeQueue.poll();
    L17:
        r101 = this.mTimeQueue.poll();
        if (this.mTimeQueue.isEmpty() == false) goto L4;
        return r101;
    L20:
        return null;
    }
}
