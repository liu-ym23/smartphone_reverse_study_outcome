package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/chat/MessageTrackThreadConfig;", "", "messageTrackThreshold", "", "<init>", "(I)V", "getMessageTrackThreshold", "()I", "setMessageTrackThreshold", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageTrackThreadConfig {

    @SerializedName("message_track_threshold")
    private int messageTrackThreshold;

    public MessageTrackThreadConfig() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ MessageTrackThreadConfig copy$default(MessageTrackThreadConfig r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.messageTrackThreshold;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.messageTrackThreshold;
    }

    public final MessageTrackThreadConfig copy(int r100) {
        return new MessageTrackThreadConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageTrackThreadConfig) == true) goto L9;
        return false;
    L9:
        if (this.messageTrackThreshold == ((MessageTrackThreadConfig) r100).messageTrackThreshold) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.messageTrackThreshold;
    }

    public String toString() {
        return "MessageTrackThreadConfig(messageTrackThreshold=" + this.messageTrackThreshold + ')';
    }

    public final int getMessageTrackThreshold() {
        return this.messageTrackThreshold;
    }

    public MessageTrackThreadConfig(int r100) {
        this.messageTrackThreshold = r100;
    }

    public final void setMessageTrackThreshold(int r100) {
        this.messageTrackThreshold = r100;
    }

    public /* synthetic */ MessageTrackThreadConfig(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 1000;
    L5:
        this(r100);
    }
}
