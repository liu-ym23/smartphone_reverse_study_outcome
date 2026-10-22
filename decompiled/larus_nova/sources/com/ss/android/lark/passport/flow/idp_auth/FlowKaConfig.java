package com.ss.android.lark.passport.flow.idp_auth;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaConfig;", "Ljava/io/Serializable;", "<init>", "()V", "external", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExternal", "()Ljava/util/HashMap;", "setExternal", "(Ljava/util/HashMap;)V", "internal", "Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaInternalData;", "getInternal", "()Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaInternalData;", "setInternal", "(Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaInternalData;)V", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowKaConfig implements Serializable {
    private HashMap<String, Object> external;
    private FlowKaInternalData internal;

    public FlowKaConfig() {
    }

    public final HashMap<String, Object> getExternal() {
        return this.external;
    }

    public final FlowKaInternalData getInternal() {
        return this.internal;
    }

    public final void setExternal(HashMap<String, Object> r100) {
        this.external = r100;
    }

    public final void setInternal(FlowKaInternalData r100) {
        this.internal = r100;
    }
}
