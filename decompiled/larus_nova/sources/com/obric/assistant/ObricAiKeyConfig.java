package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/ObricAiKeyConfig;", "", "aiKeyDownTimeout", "", "<init>", "(J)V", "getAiKeyDownTimeout", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAiKeyConfig {

    @SerializedName("ai_key_down_timeout")
    private final long aiKeyDownTimeout;

    public ObricAiKeyConfig() {
        long r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ ObricAiKeyConfig copy$default(ObricAiKeyConfig r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.aiKeyDownTimeout;
    L6:
        return r100.copy(r101);
    }

    public final long component1() {
        return this.aiKeyDownTimeout;
    }

    public final ObricAiKeyConfig copy(long r100) {
        return new ObricAiKeyConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAiKeyConfig) == true) goto L9;
        return false;
    L9:
        if (this.aiKeyDownTimeout == ((ObricAiKeyConfig) r100).aiKeyDownTimeout) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        long r100 = this.aiKeyDownTimeout;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toString() {
        return "ObricAiKeyConfig(aiKeyDownTimeout=" + this.aiKeyDownTimeout + ')';
    }

    public final long getAiKeyDownTimeout() {
        return this.aiKeyDownTimeout;
    }

    public ObricAiKeyConfig(long r100) {
        this.aiKeyDownTimeout = r100;
    }

    public /* synthetic */ ObricAiKeyConfig(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = TimeUnit.MINUTES.toMillis(3);
    L5:
        this(r100);
    }
}
