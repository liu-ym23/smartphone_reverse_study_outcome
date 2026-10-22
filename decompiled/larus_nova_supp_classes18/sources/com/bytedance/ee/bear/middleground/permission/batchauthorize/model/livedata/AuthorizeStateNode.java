package com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AuthorizeStateNode implements Serializable {
    private int hasPermissionCount;
    private int noPermissionCount;
    private BatchAuthorizeState state;

    public static final enum BatchAuthorizeState extends Enum<BatchAuthorizeState> {
        public static final BatchAuthorizeState MODE_ALL_BATCH = null;
        public static final BatchAuthorizeState MODE_ALL_DISBATCH = null;
        public static final BatchAuthorizeState MODE_UNABLE = null;
        public static final /* synthetic */ BatchAuthorizeState[] a = null;

        static {
            BatchAuthorizeState r0 = new BatchAuthorizeState("MODE_ALL_BATCH", 0);
            MODE_ALL_BATCH = r0;
            BatchAuthorizeState r1 = new BatchAuthorizeState("MODE_ALL_DISBATCH", 1);
            MODE_ALL_DISBATCH = r1;
            BatchAuthorizeState r3 = new BatchAuthorizeState("MODE_UNABLE", 2);
            MODE_UNABLE = r3;
            a = new BatchAuthorizeState[]{r0, r1, r3};
        }

        public static BatchAuthorizeState[] values() {
            return (BatchAuthorizeState[]) a.clone();
        }

        public static BatchAuthorizeState valueOf(String r1) {
            return (BatchAuthorizeState) a.a(BatchAuthorizeState.class, r1);
        }

        public BatchAuthorizeState(String r1, int r2) {
            super(r1, r2);
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

    public void setHasPermissionCount(int r1) {
        this.hasPermissionCount = r1;
    }

    public void setNoPermissionCount(int r1) {
        this.noPermissionCount = r1;
    }

    public void setState(BatchAuthorizeState r1) {
        this.state = r1;
    }
}
