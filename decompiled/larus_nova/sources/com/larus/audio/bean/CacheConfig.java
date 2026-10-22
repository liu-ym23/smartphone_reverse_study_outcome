package com.larus.audio.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/audio/bean/CacheConfig;", "Ljava/io/Serializable;", "textType", "", "useCache", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getTextType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUseCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "msgOwnerId", "", "getMsgOwnerId", "()Ljava/lang/String;", "setMsgOwnerId", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheConfig implements Serializable {
    private String msgOwnerId;

    @SerializedName(a.KEY_TEXT_TYPE)
    private final Integer textType;

    @SerializedName("use_cache")
    private final Boolean useCache;

    /* JADX WARN: Multi-variable type inference failed */
    public CacheConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getMsgOwnerId() {
        return this.msgOwnerId;
    }

    public final Integer getTextType() {
        return this.textType;
    }

    public final Boolean getUseCache() {
        return this.useCache;
    }

    public final void setMsgOwnerId(String r100) {
        this.msgOwnerId = r100;
    }

    public CacheConfig(Integer r100, Boolean r101) {
        this.textType = r100;
        this.useCache = r101;
        this.msgOwnerId = "";
    }

    public /* synthetic */ CacheConfig(Integer r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
