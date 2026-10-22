package com.bytedance.apm.agent.instrumentation.transaction;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TxState {
    private static final AgentLog LOG = null;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private long endTime;
    private int errorCode;
    private JSONObject extraData;
    private String httpMethod;
    private String rawUrl;
    private long startTime;
    private State state;
    private int statusCode;
    private TransactionData transactionData;
    private String url;
    private String wanType;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMPLETE = null;
        public static final State READY = null;
        public static final State SENT = null;

        static {
            State r0 = new State("READY", 0);
            READY = r0;
            State r1 = new State("SENT", 1);
            SENT = r1;
            State r3 = new State("COMPLETE", 2);
            COMPLETE = r3;
            $VALUES = new State[]{r0, r1, r3};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }
    }

    private TransactionData toTransactionData() {
        if (isComplete() == true) goto L5;
        LOG.warning("toTransactionData() called on incomplete TransactionState");
    L5:
        String r4 = this.url;
        if (r4 != null) goto L10;
        LOG.error("Attempted to convert TransactionData TransactionState instance with no URL into TransactionData TransactionData");
        return null;
    L10:
        if (this.transactionData != null) goto L13;
        TransactionData r1 = new TransactionData(r4, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.httpMethod, this.extraData);
        this.transactionData = r1;
        r1.setRequestEnd(this.endTime);
        this.transactionData.setErrorCode(this.errorCode);
    L13:
        return this.transactionData;
    }

    public TransactionData end() {
        addAssistData("startTime", this.startTime + "");
        if (isComplete() == true) goto L6;
        this.state = State.COMPLETE;
        this.endTime = System.currentTimeMillis();
    L6:
        return toTransactionData();
    }

    public boolean isComplete() {
        if (this.state.ordinal() < State.COMPLETE.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSent() {
        if (this.state.ordinal() < State.SENT.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return " StartTime " + String.valueOf(this.startTime) + " BytesReceived " + String.valueOf(this.bytesReceived) + " BytesSent " + String.valueOf(this.bytesSent) + " Url " + this.url;
    }

    static {
        LOG = AgentLogManager.getAgentLog();
    }

    public TxState() {
        this.carrier = CommentPublishScene.UNKNOWN;
        this.wanType = CommentPublishScene.UNKNOWN;
        this.state = State.READY;
        this.extraData = new JSONObject();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getReceivedBytes() {
        return this.bytesReceived;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBytesReceived(long r2) {
        if (isComplete() == true) goto L5;
        this.bytesReceived = r2;
        return;
    L5:
        LOG.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setBytesSent(long r2) {
        if (isComplete() == true) goto L5;
        this.bytesSent = r2;
        this.state = State.SENT;
        return;
    L5:
        LOG.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setCarrier(String r3) {
        if (isSent() == true) goto L5;
        this.carrier = r3;
        return;
    L5:
        LOG.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setErrorCode(int r3) {
        if (isComplete() == true) goto L5;
        this.errorCode = r3;
        return;
    L5:
        TransactionData r0 = this.transactionData;
        if (r0 == null) goto L8;
        r0.setErrorCode(r3);
    L8:
        LOG.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setMethod(String r3) {
        if (isSent() == true) goto L5;
        this.httpMethod = r3;
        return;
    L5:
        LOG.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setStartTime(long r1) {
        this.startTime = r1;
    }

    public void setStatusCode(int r3) {
        if (isComplete() == true) goto L6;
        this.statusCode = r3;
        return;
    L6:
        if (this.statusCode != 0) goto L9;
        if (r3 == 0) goto L9;
        this.statusCode = r3;
    L9:
        LOG.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setUrl(String r4) {
        if (this.rawUrl != null) goto L5;
        this.rawUrl = r4;
    L5:
        String r0 = null;
        if (r4 != null) goto L21;
    L13:
        if (r0 != null) goto L16;
        return;
    L16:
        if (isSent() == true) goto L18;
        this.url = r0;
        return;
    L18:
        LOG.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
        return;
    L21:
        URL r1 = new URL(r4);     // Catch: MalformedURLException -> L20
        StringBuffer r5 = new StringBuffer();
        r5.append(r1.getProtocol());
        r5.append("://");
        r5.append(r1.getHost());
        if (r1.getPort() == (-1)) goto L12;
        r5.append(":");
        r5.append(r1.getPort());
    L12:
        r5.append(r1.getPath());
        r0 = r5.toString();
        goto L13
    }

    public void setWanType(String r3) {
        if (isSent() == true) goto L5;
        this.wanType = r3;
        return;
    L5:
        LOG.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void addAssistData(String r4, String r5) {
        if (isComplete() == false) goto L10;
        LOG.warning("addAssistData(...) called on TransactionState in " + this.state.toString() + " state");
    L10:
        this.extraData.put(r4, r5);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        LOG.error("Caught error while addAssistData: ", e);
    }
}
