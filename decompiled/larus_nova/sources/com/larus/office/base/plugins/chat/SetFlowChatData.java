package com.larus.office.base.plugins.chat;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/office/base/plugins/chat/SetFlowChatData;", "Ljava/io/Serializable;", "<init>", "()V", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetFlowChatData implements Serializable {

    @SerializedName("visible")
    private boolean visible;

    public SetFlowChatData() {
    }

    public String toString() {
        return "SetFlowChatData@" + hashCode() + "{visible: " + this.visible + '}';
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean r100) {
        this.visible = r100;
    }
}
