package com.bytedance.ee.bear.doccomponent.api.entity;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tRF\u0010\r\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000ej\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/doccomponent/api/entity/ComponentInvokeResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "command", "", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", EventConstant.Key.MODULE, "getModule", "setModule", WsConstants.KEY_PAYLOAD, "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "getPayload", "()Ljava/util/HashMap;", "setPayload", "(Ljava/util/HashMap;)V", "callbackId", "getCallbackId", "setCallbackId", "toString", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComponentInvokeResult implements NonProguard {
    private String callbackId;
    private String command;
    private String module;
    private HashMap<String, ? extends Serializable> payload;

    public ComponentInvokeResult() {
    }

    public String toString() {
        return "ComponentInvokeResult(command=" + this.command + ", module=" + this.module + ", payload=" + this.payload + ", callbackId=" + this.callbackId + ')';
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getModule() {
        return this.module;
    }

    public final HashMap<String, ? extends Serializable> getPayload() {
        return this.payload;
    }

    public final void setCallbackId(String r100) {
        this.callbackId = r100;
    }

    public final void setCommand(String r100) {
        this.command = r100;
    }

    public final void setModule(String r100) {
        this.module = r100;
    }

    public final void setPayload(HashMap<String, ? extends Serializable> r100) {
        this.payload = r100;
    }
}
