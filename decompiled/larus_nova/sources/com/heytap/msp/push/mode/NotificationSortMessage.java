package com.heytap.msp.push.mode;

/* JADX INFO: loaded from: classes23.dex */
public class NotificationSortMessage implements Comparable<NotificationSortMessage> {
    private int autoDelete;
    private String group;
    private int importantLevel;
    private boolean isMcs;
    private String messageId;
    private int notifyId;
    private long postTime;
    private String statisticData;

    public NotificationSortMessage(String r100, int r110, int r111, boolean r112, long r113, int r114, String r115) {
        this(r100, r110, r111, r112, r113, r115);
        this.notifyId = r114;
    }

    public NotificationSortMessage(String r100, int r101, int r102, boolean r103, long r104, String r105) {
        this.messageId = r100;
        this.importantLevel = r101;
        this.autoDelete = r102;
        this.isMcs = r103;
        this.postTime = r104;
        this.statisticData = r105;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(NotificationSortMessage r100) {
        if (r100.getPostTime() >= this.postTime) goto L6;
        return 1;
    L6:
        if (r100.getPostTime() != this.postTime) goto L8;
        return 0;
    L8:
        return -1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(NotificationSortMessage r100) {
        return compareTo2(r100);
    }

    public int getAutoDelete() {
        return this.autoDelete;
    }

    public String getGroup() {
        return this.group;
    }

    public int getImportantLevel() {
        return this.importantLevel;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public long getPostTime() {
        return this.postTime;
    }

    public String getStatisticData() {
        return this.statisticData;
    }

    public boolean isMcs() {
        return this.isMcs;
    }

    public void setGroup(String r100) {
        this.group = r100;
    }
}
