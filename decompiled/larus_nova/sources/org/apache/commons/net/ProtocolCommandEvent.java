package org.apache.commons.net;

import java.util.EventObject;

/* JADX INFO: loaded from: classes42.dex */
public class ProtocolCommandEvent extends EventObject {
    private static final long serialVersionUID = 403743538418947240L;
    private final String __command;
    private final boolean __isCommand;
    private final String __message;
    private final int __replyCode;

    public boolean isReply() {
        return !isCommand();
    }

    public String getCommand() {
        return this.__command;
    }

    public String getMessage() {
        return this.__message;
    }

    public int getReplyCode() {
        return this.__replyCode;
    }

    public boolean isCommand() {
        return this.__isCommand;
    }

    public ProtocolCommandEvent(Object r100, int r101, String r102) {
        super(r100);
        this.__replyCode = r101;
        this.__message = r102;
        this.__isCommand = false;
        this.__command = null;
    }

    public ProtocolCommandEvent(Object r100, String r101, String r102) {
        super(r100);
        this.__replyCode = 0;
        this.__message = r102;
        this.__isCommand = true;
        this.__command = r101;
    }
}
