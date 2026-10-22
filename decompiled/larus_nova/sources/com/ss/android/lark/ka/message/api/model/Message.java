package com.ss.android.lark.ka.message.api.model;

/* JADX INFO: loaded from: classes36.dex */
public class Message {
    private final IMessageBody messageBody;
    private final MessageType messageType;

    public IMessageBody getMessageBody() {
        return this.messageBody;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public Message(MessageType r100, IMessageBody r101) {
        this.messageType = r100;
        this.messageBody = r101;
    }
}
