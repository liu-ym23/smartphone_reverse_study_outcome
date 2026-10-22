package com.ss.android.lark.biz.im.api;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class UrgentInfo implements Comparable, Cloneable, Serializable, y28.b<UrgentInfo> {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f409898id;
    private boolean isClosed;
    private boolean isMuted;
    private String messageId;
    private long sendTime;

    public static final enum Status extends Enum<Status> {
        public static final Status ACK_ME = null;
        public static final Status ME_ACK = null;
        public static final Status ME_CREATE = null;
        public static final Status UNKNOWN = null;
        public static final Status URGENT_ME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f409899a = null;
        private int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ME_CREATE", 1, 1);
            ME_CREATE = r101;
            Status r102 = new Status("ME_ACK", 2, 2);
            ME_ACK = r102;
            Status r103 = new Status("URGENT_ME", 3, 3);
            URGENT_ME = r103;
            Status r104 = new Status("ACK_ME", 4, 4);
            ACK_ME = r104;
            f409899a = new Status[]{r100, r101, r102, r103, r104};
        }

        public static Status[] values() {
            return (Status[]) f409899a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return UNKNOWN;
        L13:
            return ACK_ME;
        L15:
            return URGENT_ME;
        L17:
            return ME_ACK;
        L19:
            return ME_CREATE;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public UrgentInfo() {
    }

    public String toString() {
        return "UrgentInfo{id='" + this.f409898id + "', messageId='" + this.messageId + "', isClosed=" + this.isClosed + ", isMuted=" + this.isMuted + '}';
    }

    public String getId() {
        return this.f409898id;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        if ((r100 instanceof UrgentInfo) == false) goto L13;
        UrgentInfo r101 = (UrgentInfo) r100;
        if (getSendTime() <= r101.getSendTime()) goto L9;
        return -1;
    L9:
        if (getSendTime() != r101.getSendTime()) goto L11;
        return 0;
    L11:
        return 1;
    L13:
        return 0;
    }

    public boolean isContentSame(UrgentInfo r100) {
        if (this.sendTime == r100.sendTime) goto L5;
    L13:
        return false;
    L5:
        if (this.isClosed != r100.isClosed) goto L13;
        if (this.isMuted != r100.isMuted) goto L13;
        if (Objects.equals(this.f409898id, r100.f409898id) == false) goto L13;
        if (Objects.equals(this.messageId, r100.messageId) == false) goto L13;
        return true;
    }

    public boolean isItemSame(UrgentInfo r100) {
        return Objects.equals(this.f409898id, r100.f409898id);
    }

    public void setClosed(boolean r100) {
        this.isClosed = r100;
    }

    public void setId(String r100) {
        this.f409898id = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setMuted(boolean r100) {
        this.isMuted = r100;
    }

    public void setSendTime(long r100) {
        this.sendTime = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((UrgentInfo) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((UrgentInfo) r100);
    }
}
