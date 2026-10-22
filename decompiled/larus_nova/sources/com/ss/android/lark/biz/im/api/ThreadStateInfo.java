package com.ss.android.lark.biz.im.api;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class ThreadStateInfo implements Serializable, y28.b<ThreadStateInfo> {
    private String operatorId;
    private ThreadState state;
    private Long updateTimeMs;

    public static final enum ThreadState extends Enum<ThreadState> {
        public static final ThreadState CLOSED = null;
        public static final ThreadState OPEN = null;
        public static final ThreadState UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ThreadState[] f409896a = null;
        private int value;

        static {
            ThreadState r100 = new ThreadState("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ThreadState r101 = new ThreadState("OPEN", 1, 1);
            OPEN = r101;
            ThreadState r102 = new ThreadState(ErrorCode.CLOSED, 2, 2);
            CLOSED = r102;
            f409896a = new ThreadState[]{r100, r101, r102};
        }

        public static ThreadState[] values() {
            return (ThreadState[]) f409896a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ThreadState forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return CLOSED;
        L11:
            return OPEN;
        }

        public static ThreadState valueOf(String r100) {
            return (ThreadState) r27.a.a(ThreadState.class, r100);
        }

        public static ThreadState valueOf(int r100) {
            return forNumber(r100);
        }

        public ThreadState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public boolean isItemSame(ThreadStateInfo r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public ThreadState getState() {
        return this.state;
    }

    public Long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public boolean isContentSame(ThreadStateInfo r100) {
        if (this.state != r100.state) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((ThreadStateInfo) r100);
    }

    public void setOperatorId(String r100) {
        this.operatorId = r100;
    }

    public void setState(ThreadState r100) {
        this.state = r100;
    }

    public void setUpdateTimeMs(Long r100) {
        this.updateTimeMs = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((ThreadStateInfo) r100);
    }

    public ThreadStateInfo(ThreadState r100, String r101, Long r102) {
        this.state = r100;
        this.operatorId = r101;
        this.updateTimeMs = r102;
    }
}
