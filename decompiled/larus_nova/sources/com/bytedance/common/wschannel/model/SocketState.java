package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;
    public int channelId;
    public int channelType;
    public int connectionState;
    public int connectionType;
    public String connectionUrl;
    public String error;
    public int errorCode;
    private boolean privateProtocolEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ChannelType getChannelType() {
        return ChannelType.of(this.channelType);
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("channel_id", this.channelId);     // Catch: JSONException -> L9
        r100.put("type", this.connectionType);     // Catch: JSONException -> L9
        r100.put("state", this.connectionState);     // Catch: JSONException -> L9
        r100.put("url", this.connectionUrl);     // Catch: JSONException -> L9
        r100.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);     // Catch: JSONException -> L9
        r100.put("error", this.error);     // Catch: JSONException -> L9
        r100.put("error_code", this.errorCode);     // Catch: JSONException -> L9
        if (this.privateProtocolEnabled == false) goto L6;
        int r101 = 1;
    L7:
        r100.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, r101);     // Catch: JSONException -> L9
    L11:
        return r100;
    L6:
        r101 = 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String toString() {
        return "SocketState{connectionType=" + this.connectionType + ", connectionState=" + this.connectionState + ", connectionUrl='" + this.connectionUrl + "', channelId=" + this.channelId + ", channelType=" + this.channelType + ", error='" + this.error + "', privateProtocol=" + this.privateProtocolEnabled + "'}";
    }

    public SocketState() {
    }

    public int getChannelId() {
        return this.channelId;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public boolean isPrivateProtocolEnabled() {
        return this.privateProtocolEnabled;
    }

    public SocketState(Parcel r100) {
        this.connectionType = r100.readInt();
        this.connectionState = r100.readInt();
        this.connectionUrl = r100.readString();
        this.channelId = r100.readInt();
        this.channelType = r100.readInt();
        this.error = r100.readString();
        this.errorCode = r100.readInt();
        if (r100.readInt() <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.privateProtocolEnabled = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static SocketState fromJson(JSONObject r100) {
        SocketState r101 = new SocketState();
        r101.channelId = r100.optInt("channel_id", Integer.MIN_VALUE);
        r101.connectionType = r100.optInt("type", -1);
        r101.connectionState = r100.optInt("state", -1);
        r101.connectionUrl = r100.optString("url", "");
        r101.channelType = r100.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r101.error = r100.optString("error", "");
        r101.errorCode = r100.optInt("error_code");
        boolean r102 = false;
        if (r100.optInt(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 0) <= 0) goto L5;
        r102 = true;
    L5:
        r101.privateProtocolEnabled = r102;
        return r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.connectionType);
        r100.writeInt(this.connectionState);
        r100.writeString(this.connectionUrl);
        r100.writeInt(this.channelId);
        r100.writeInt(this.channelType);
        r100.writeString(this.error);
        r100.writeInt(this.errorCode);
        r100.writeInt(this.privateProtocolEnabled ? 1 : 0);
    }
}
