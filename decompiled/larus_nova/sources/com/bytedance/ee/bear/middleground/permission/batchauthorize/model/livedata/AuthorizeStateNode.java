package com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public class AuthorizeStateNode implements Serializable {
    private int hasPermissionCount;
    private int noPermissionCount;
    private BatchAuthorizeState state;

    public static final enum BatchAuthorizeState extends Enum<BatchAuthorizeState> {
        public static final BatchAuthorizeState MODE_ALL_BATCH = null;
        public static final BatchAuthorizeState MODE_ALL_DISBATCH = null;
        public static final BatchAuthorizeState MODE_UNABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BatchAuthorizeState[] f233142a = null;

        static {
            BatchAuthorizeState r100 = new BatchAuthorizeState("MODE_ALL_BATCH", 0);
            MODE_ALL_BATCH = r100;
            BatchAuthorizeState r101 = new BatchAuthorizeState("MODE_ALL_DISBATCH", 1);
            MODE_ALL_DISBATCH = r101;
            BatchAuthorizeState r102 = new BatchAuthorizeState("MODE_UNABLE", 2);
            MODE_UNABLE = r102;
            f233142a = new BatchAuthorizeState[]{r100, r101, r102};
        }

        public static BatchAuthorizeState[] values() {
            return (BatchAuthorizeState[]) f233142a.clone();
        }

        public static BatchAuthorizeState valueOf(String r100) {
            return (BatchAuthorizeState) a.a(BatchAuthorizeState.class, r100);
        }

        public BatchAuthorizeState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AuthorizeStateNode() {
    }

    public int getHasPermissionCount() {
        return this.hasPermissionCount;
    }

    public int getNoPermissionCount() {
        return this.noPermissionCount;
    }

    public BatchAuthorizeState getState() {
        return this.state;
    }

    public void setHasPermissionCount(int r100) {
        this.hasPermissionCount = r100;
    }

    public void setNoPermissionCount(int r100) {
        this.noPermissionCount = r100;
    }

    public void setState(BatchAuthorizeState r100) {
        this.state = r100;
    }
}
