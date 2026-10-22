package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.p.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.MessageAckEvent$MessageState;
import com.bytedance.common.wschannel.utils.Utils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;
    public static WsChannelMsg EMPTY;
    private int channelId;
    private boolean isAckMsg;
    private long logId;
    private String logInfo;
    private int method;
    private List<MsgHeader> msgHeaders;
    private String msgId;
    private NewMsgTimeHolder newMsgTimeHolder;
    private byte[] payload;
    private String payloadEncoding;
    private String payloadType;
    public transient long receiveDataFromIpcTs;
    private ComponentName replayToComponentName;
    private long seqId;
    private String serverTiming;
    private int service;
    private MessageAckEvent$MessageState state;
    private String uuid;

    public static final class Builder {
        private Map<String, String> headers;
        private long logId;
        private final int mChannelId;
        private int method;
        private byte[] payload;
        private String payloadEncoding;
        private String payloadType;
        private ComponentName replyComponentName;
        private long seqId;
        private int service;

        public WsChannelMsg build() {
            if (this.mChannelId <= 0) goto L23;
            if (this.service < 0) goto L21;
            if (this.method <= 0) goto L19;
            if (this.payload == null) goto L17;
            ArrayList r100 = new ArrayList();
            Iterator<Map.Entry<String, String>> r101 = this.headers.entrySet().iterator();
        L12:
            if (r101.hasNext() == false) goto L15;
            Map.Entry<String, String> r102 = r101.next();
            MsgHeader r103 = new MsgHeader();
            r103.setKey(r102.getKey());
            r103.setValue(r102.getValue());
            r100.add(r103);
            goto L12
        L15:
            return new WsChannelMsg(this.mChannelId, this.seqId, this.logId, this.service, this.method, r100, this.payloadEncoding, this.payloadType, this.payload, this.replyComponentName);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public Builder(int r100) {
            this.headers = new HashMap();
            this.payloadType = "";
            this.payloadEncoding = "";
            this.mChannelId = r100;
        }

        public static Builder create(int r100) {
            return new Builder(r100);
        }

        public Builder setLogId(long r100) {
            this.logId = r100;
            return this;
        }

        public Builder setMethod(int r100) {
            this.method = r100;
            return this;
        }

        public Builder setPayload(byte[] r100) {
            this.payload = r100;
            return this;
        }

        public Builder setPayloadEncoding(String r100) {
            this.payloadEncoding = r100;
            return this;
        }

        public Builder setPayloadType(String r100) {
            this.payloadType = r100;
            return this;
        }

        public Builder setReplyComponentName(ComponentName r100) {
            this.replyComponentName = r100;
            return this;
        }

        public Builder setSeqId(long r100) {
            this.seqId = r100;
            return this;
        }

        public Builder setService(int r100) {
            this.service = r100;
            return this;
        }

        public Builder addMsgHeader(String r100, String r101) {
            this.headers.put(r100, r101);
            return this;
        }
    }

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        String key;
        String value;

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setValue(String r100) {
            this.value = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.key);
            r100.writeString(this.value);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
        EMPTY = new WsChannelMsg();
    }

    public byte[] getPayload() {
        if (this.payload != null) goto L6;
        this.payload = new byte[1];
    L6:
        return this.payload;
    }

    public Map<String, String> toMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("seqId", String.valueOf(this.seqId));
        r100.put("logId", String.valueOf(this.logId));
        r100.put("service", String.valueOf(this.service));
        r100.put(e.f25671s, String.valueOf(this.method));
        r100.put("payloadEncoding", this.payloadEncoding);
        r100.put("payloadType", this.payloadType);
        r100.put(WsConstants.KEY_PAYLOAD_MD5, Utils.byte2HexStr(MessageDigest.getInstance("MD5").digest(this.payload), ""));     // Catch: NoSuchAlgorithmException -> L5
    L7:
        r100.put(RemoteMessageConst.Notification.CHANNEL_ID, String.valueOf(this.channelId));
        Iterator<MsgHeader> r101 = this.msgHeaders.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        MsgHeader r102 = r101.next();
        r100.put(r102.key, r102.value);
        goto L9
    L11:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + new ArrayList(this.msgHeaders) + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    public WsChannelMsg() {
        this.state = MessageAckEvent$MessageState.Default;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public long getLogId() {
        return this.logId;
    }

    public String getLogInfo() {
        return this.logInfo;
    }

    public int getMethod() {
        return this.method;
    }

    public List<MsgHeader> getMsgHeaders() {
        return this.msgHeaders;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public NewMsgTimeHolder getNewMsgTimeHolder() {
        return this.newMsgTimeHolder;
    }

    public String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public String getPayloadType() {
        return this.payloadType;
    }

    public ComponentName getReplayToComponentName() {
        return this.replayToComponentName;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public String getServerTiming() {
        return this.serverTiming;
    }

    public int getService() {
        return this.service;
    }

    public MessageAckEvent$MessageState getState() {
        return this.state;
    }

    public String getUUID() {
        return this.uuid;
    }

    public boolean isAckMsg() {
        return this.isAckMsg;
    }

    public WsChannelMsg(Parcel r100) {
        this.state = MessageAckEvent$MessageState.Default;
        this.seqId = r100.readLong();
        this.logId = r100.readLong();
        this.service = r100.readInt();
        this.method = r100.readInt();
        this.msgHeaders = r100.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r100.readString();
        this.payloadType = r100.readString();
        this.payload = r100.createByteArray();
        this.replayToComponentName = (ComponentName) r100.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = r100.readInt();
        this.uuid = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.isAckMsg = r101;
        this.state = MessageAckEvent$MessageState.valueOf(r100.readInt());
        this.newMsgTimeHolder = (NewMsgTimeHolder) r100.readParcelable(NewMsgTimeHolder.class.getClassLoader());
        this.logInfo = r100.readString();
        this.serverTiming = r100.readString();
        this.msgId = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setChannelId(int r100) {
        this.channelId = r100;
    }

    public void setIsAckMsg(boolean r100) {
        this.isAckMsg = r100;
    }

    public void setLogId(long r100) {
        this.logId = r100;
    }

    public void setLogInfo(String r100) {
        this.logInfo = r100;
    }

    public void setMethod(int r100) {
        this.method = r100;
    }

    public void setMsgHeaders(List<MsgHeader> r100) {
        this.msgHeaders = r100;
    }

    public void setMsgId(String r100) {
        this.msgId = r100;
    }

    public void setNewMsgTimeHolder(NewMsgTimeHolder r100) {
        this.newMsgTimeHolder = r100;
    }

    public void setPayload(byte[] r100) {
        this.payload = r100;
    }

    public void setPayloadEncoding(String r100) {
        this.payloadEncoding = r100;
    }

    public void setPayloadType(String r100) {
        this.payloadType = r100;
    }

    public void setReplayToComponentName(ComponentName r100) {
        this.replayToComponentName = r100;
    }

    public void setSeqId(long r100) {
        this.seqId = r100;
    }

    public void setServerTiming(String r100) {
        this.serverTiming = r100;
    }

    public void setService(int r100) {
        this.service = r100;
    }

    public void setState(MessageAckEvent$MessageState r100) {
        this.state = r100;
    }

    public void setUUID(String r100) {
        this.uuid = r100;
    }

    public WsChannelMsg(WsChannelMsg r100) {
        this.state = MessageAckEvent$MessageState.Default;
        setSeqId(r100.getSeqId());
        setLogId(r100.getLogId());
        setService(r100.getService());
        setMethod(r100.getMethod());
        setMsgHeaders(r100.getMsgHeaders());
        setPayload(r100.getPayload());
        setPayloadEncoding(r100.getPayloadEncoding());
        setPayloadType(r100.getPayloadType());
        setChannelId(r100.getChannelId());
        setReplayToComponentName(r100.getReplayToComponentName());
        setNewMsgTimeHolder(r100.getNewMsgTimeHolder());
        setIsAckMsg(r100.isAckMsg());
        setUUID(r100.getUUID());
        setState(r100.getState());
        setLogInfo(r100.logInfo);
        setServerTiming(r100.serverTiming);
        setMsgId(r100.msgId);
    }

    public void addHeader(String r100, String r101) {
        MsgHeader r102 = new MsgHeader();
        r102.setKey(r100);
        r102.setValue(r101);
        this.msgHeaders.add(r102);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.seqId);
        r100.writeLong(this.logId);
        r100.writeInt(this.service);
        r100.writeInt(this.method);
        r100.writeTypedList(this.msgHeaders);
        r100.writeString(this.payloadEncoding);
        r100.writeString(this.payloadType);
        r100.writeByteArray(this.payload);
        r100.writeParcelable(this.replayToComponentName, r101);
        r100.writeInt(this.channelId);
        r100.writeString(this.uuid);
        r100.writeByte(this.isAckMsg ? 1 : 0);
        r100.writeInt(this.state.getTypeValue());
        r100.writeParcelable(this.newMsgTimeHolder, r101);
        r100.writeString(this.logInfo);
        r100.writeString(this.serverTiming);
        r100.writeString(this.msgId);
    }

    public WsChannelMsg(int r100, int r101, int r102, String r103, boolean r104) {
        this.state = MessageAckEvent$MessageState.Default;
        this.channelId = r100;
        this.service = r101;
        this.method = r102;
        this.uuid = r103;
        this.isAckMsg = r104;
    }

    public WsChannelMsg(int r100, long r101, long r102, int r103, int r104, List<MsgHeader> r105, String r110, String r111, byte[] r112, ComponentName r113) {
        this.state = MessageAckEvent$MessageState.Default;
        this.channelId = r100;
        this.seqId = r101;
        this.logId = r102;
        this.service = r103;
        this.method = r104;
        this.msgHeaders = r105;
        this.payloadEncoding = r110;
        this.payloadType = r111;
        this.payload = r112;
        this.replayToComponentName = r113;
    }
}
