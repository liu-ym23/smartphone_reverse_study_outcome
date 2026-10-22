package kc2;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c implements t {
    private String WRDSSubKey;
    private long WRDSVersion;
    private m0 baseMessage;
    private long consumeTime;
    private final boolean currUserIsAnchor;
    private long decodeEndTime;
    private long decodeStartTime;
    private long enqueueDispatchTime;
    private int generalMessageType;
    private long httpSendTime;
    private boolean isFromFirstRequest;
    private boolean isInsert;
    private boolean isLocalInsertMsg;
    private boolean isTooMuchMsg;
    private boolean isWRDSMessage;
    private long localTimestamp;
    private Map<String, String> messageExtra;
    private int messageFrom;
    private String messageMethod;
    private long receiveTime;
    private transient long timestamp;

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean canText() {
        return false;
    }

    @Override // tlc.d
    public long getDelayDispatchMs() {
        return 0;
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 0;
    }

    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isFirstHistoryMessage() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isFromOtherIntercomRoom() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public void setIsFirstHistoryMessage(boolean r100) {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        return false;
    }

    @Override // tlc.d
    public long getMessageId() {
        m0 r100 = this.baseMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMessageId();
    }

    @Override // tlc.d
    public long getRoomId() {
        m0 r100 = this.baseMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getRoomId();
    }

    @Override // xlc.b
    public String getWRDSKey() {
        m0 r100 = this.baseMessage;
        if (r100 == null) goto L6;
        String r101 = r100.getMethod();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // tlc.d
    public boolean isGlobalMessage() {
        m0 r100 = this.baseMessage;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getRoomId() != (-1)) goto L7;
        return true;
    }

    @Override // tlc.d
    public boolean needMonitor() {
        m0 r100 = this.baseMessage;
        if (r100 != null) goto L5;
    L6:
        m0 r101 = this.baseMessage;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.getMonitor() != 2) goto L11;
        return true;
    L5:
        if (r100.getMonitor() != 1) goto L6;
        return true;
    }

    public c() {
        this.messageMethod = "";
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean currUserIsAnchor() {
        return this.currUserIsAnchor;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public m0 getBaseMessage() {
        return this.baseMessage;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getConsumeTime() {
        return this.consumeTime;
    }

    public final boolean getCurrUserIsAnchor() {
        return this.currUserIsAnchor;
    }

    @Override // tlc.d
    public int getGeneralMessageType() {
        return this.generalMessageType;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getHttpSendTime() {
        return this.httpSendTime;
    }

    public long getLocalTimestamp() {
        return this.localTimestamp;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public Map<String, String> getMessageExtra() {
        return this.messageExtra;
    }

    @Override // tlc.d
    public int getMessageFrom() {
        return this.messageFrom;
    }

    @Override // tlc.d
    public String getMessageMethod() {
        return this.messageMethod;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getReceiveTime() {
        return this.receiveTime;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // xlc.b
    public String getWRDSSubKey() {
        return this.WRDSSubKey;
    }

    @Override // xlc.b
    public long getWRDSVersion() {
        return this.WRDSVersion;
    }

    @Override // tlc.d
    public boolean isFromFirstRequest() {
        return this.isFromFirstRequest;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isInsert() {
        return this.isInsert;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isTooMuchMsg() {
        return this.isTooMuchMsg;
    }

    @Override // xlc.b
    public boolean isWRDSMessage() {
        return this.isWRDSMessage;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isCurrentRoom(long r100) {
        m0 r101 = this.baseMessage;
        if (r101 == null) goto L5;
        long r102 = r101.getRoomId();
    L7:
        if (r100 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r100 != r102) goto L11;
        return true;
    L5:
        r102 = 0;
        goto L7
    }

    public void setBaseMessage(m0 r100) {
        this.baseMessage = r100;
    }

    @Override // tlc.d
    public void setConsumeTime(long r100) {
        this.consumeTime = r100;
    }

    @Override // tlc.d
    public void setDecodeEndTime(long r100) {
        this.decodeEndTime = r100;
    }

    @Override // tlc.d
    public void setDecodeStartTime(long r100) {
        this.decodeStartTime = r100;
    }

    @Override // tlc.d
    public void setEnqueueDispatchTime(long r100) {
        this.enqueueDispatchTime = r100;
    }

    @Override // tlc.d
    public void setHttpSendTime(long r100) {
        this.httpSendTime = r100;
    }

    @Override // tlc.d
    public void setIsFromFirstRequest(boolean r100) {
        this.isFromFirstRequest = r100;
    }

    @Override // tlc.d
    public void setIsInsert(boolean r100) {
        this.isInsert = r100;
    }

    public void setLocalInsertMsg(boolean r100) {
        this.isLocalInsertMsg = r100;
    }

    @Override // tlc.d
    public void setMessageMethod(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.messageMethod = r100;
    }

    @Override // tlc.d
    public void setReceiveTime(long r100) {
        this.receiveTime = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public void setTooMuchMsg(boolean r100) {
        this.isTooMuchMsg = r100;
    }

    @Override // xlc.b
    public void setWRDSMessage(boolean r100) {
        this.isWRDSMessage = r100;
    }

    @Override // xlc.b
    public void setWRDSSubKey(String r100) {
        this.WRDSSubKey = r100;
    }

    @Override // xlc.b
    public void setWRDSVersion(long r100) {
        this.WRDSVersion = r100;
    }
}
