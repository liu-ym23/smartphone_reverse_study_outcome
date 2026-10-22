package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/voicecall/api/bean/CommandType;", "", "<init>", "()V", "commandType", "", "getCommandType$annotations", "getCommandType", "()I", "setCommandType", "(I)V", "param", "Lcom/larus/voicecall/api/bean/ChatParam;", "getParam", "()Lcom/larus/voicecall/api/bean/ChatParam;", "setParam", "(Lcom/larus/voicecall/api/bean/ChatParam;)V", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommandType {

    @SerializedName("command_type")
    private int commandType;
    private ChatParam param;

    @CommandStatus
    public static /* synthetic */ void getCommandType$annotations() {
    }

    public CommandType() {
        this.commandType = -1;
    }

    public final int getCommandType() {
        return this.commandType;
    }

    public final ChatParam getParam() {
        return this.param;
    }

    public final void setCommandType(int r100) {
        this.commandType = r100;
    }

    public final void setParam(ChatParam r100) {
        this.param = r100;
    }
}
