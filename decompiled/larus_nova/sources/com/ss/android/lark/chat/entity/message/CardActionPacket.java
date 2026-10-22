package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public class CardActionPacket implements Serializable {
    private String cid;
    private CardAction.Parameters parameters;
    private ByteString payload;

    public CardActionPacket() {
    }

    public String getCid() {
        return this.cid;
    }

    public CardAction.Parameters getParameters() {
        return this.parameters;
    }

    public ByteString getPayload() {
        return this.payload;
    }

    public void setCid(String r100) {
        this.cid = r100;
    }

    public void setParameters(CardAction.Parameters r100) {
        this.parameters = r100;
    }

    public void setPayload(ByteString r100) {
        this.payload = r100;
    }
}
