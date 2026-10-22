package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/chat/PushMainBotOptConfig;", "", "enableUseMainBotLocalConv", "", "<init>", "(Z)V", "getEnableUseMainBotLocalConv", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l0 {

    @SerializedName("enable_use_main_bot_local_conv")
    private final boolean enableUseMainBotLocalConv;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L9;
        return false;
    L9:
        if (this.enableUseMainBotLocalConv == ((l0) r100).enableUseMainBotLocalConv) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.enableUseMainBotLocalConv == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "PushMainBotOptConfig(enableUseMainBotLocalConv=" + this.enableUseMainBotLocalConv + ')';
    }

    public final boolean a() {
        return this.enableUseMainBotLocalConv;
    }

    public l0(int r100) {
        this.enableUseMainBotLocalConv = false;
    }
}
