package com.bytedance.ee.bear.doccomponent.api.entity;

import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007RF\u0010\u000f\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/doccomponent/api/entity/DocComponentBizEvent;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "command", "", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", "module", "getModule", "setModule", "callbackId", "getCallbackId", "payload", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "getPayload", "()Ljava/util/HashMap;", "setPayload", "(Ljava/util/HashMap;)V", "callBack", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getCallBack", "()Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "setCallBack", "(Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "toString", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocComponentBizEvent implements NonProguard {
    private transient m callBack;
    private final String callbackId;
    private String command;
    private String module;
    private HashMap<String, ? extends Serializable> payload;

    public DocComponentBizEvent() {
    }

    public String toString() {
        return "DocComponentBizEvent(command=" + this.command + ", module=" + this.module + ", callbackId=" + this.callbackId + ", payload=" + this.payload + ')';
    }

    public final m getCallBack() {
        return this.callBack;
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

    public final void setCallBack(m r1) {
        this.callBack = r1;
    }

    public final void setCommand(String r1) {
        this.command = r1;
    }

    public final void setModule(String r1) {
        this.module = r1;
    }

    public final void setPayload(HashMap<String, ? extends Serializable> r1) {
        this.payload = r1;
    }
}
