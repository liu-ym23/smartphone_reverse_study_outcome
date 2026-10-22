package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/chat/ObricWindowMessageBubbleStyleConfig;", "", "colorToken", "", "<init>", "(Ljava/lang/String;)V", "getColorToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowMessageBubbleStyleConfig {

    @SerializedName("color_token")
    private final String colorToken;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricWindowMessageBubbleStyleConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObricWindowMessageBubbleStyleConfig copy$default(ObricWindowMessageBubbleStyleConfig r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.colorToken;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.colorToken;
    }

    public final ObricWindowMessageBubbleStyleConfig copy(String r100) {
        return new ObricWindowMessageBubbleStyleConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricWindowMessageBubbleStyleConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.colorToken, ((ObricWindowMessageBubbleStyleConfig) r100).colorToken) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.colorToken;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ObricWindowMessageBubbleStyleConfig(colorToken=" + this.colorToken + ')';
    }

    public final String getColorToken() {
        return this.colorToken;
    }

    public ObricWindowMessageBubbleStyleConfig(String r100) {
        this.colorToken = r100;
    }

    public /* synthetic */ ObricWindowMessageBubbleStyleConfig(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "#1AFFFFFF";
    L5:
        this(r100);
    }
}
