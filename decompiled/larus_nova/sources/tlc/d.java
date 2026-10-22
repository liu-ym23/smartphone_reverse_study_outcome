package tlc;

/* JADX INFO: loaded from: classes36.dex */
public interface d {
    long getDelayDispatchMs();

    int getGeneralMessageType();

    int getIntType();

    int getMessageFrom();

    long getMessageId();

    String getMessageMethod();

    long getRoomId();

    boolean isFromFirstRequest();

    boolean isGlobalMessage();

    boolean needMonitor();

    void setConsumeTime(long r100);

    void setDecodeEndTime(long r100);

    void setDecodeStartTime(long r100);

    void setEnqueueDispatchTime(long r100);

    void setHttpSendTime(long r100);

    void setIsFromFirstRequest(boolean r100);

    void setIsInsert(boolean r100);

    void setMessageMethod(String r100);

    void setReceiveTime(long r100);
}
