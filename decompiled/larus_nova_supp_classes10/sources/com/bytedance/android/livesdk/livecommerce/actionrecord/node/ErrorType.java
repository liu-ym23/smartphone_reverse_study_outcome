package com.bytedance.android.livesdk.livecommerce.actionrecord.node;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/node/ErrorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INTERNAL", "NETWORK", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType INTERNAL = null;
    public static final ErrorType NETWORK = null;
    public static final /* synthetic */ ErrorType[] a = null;
    private final String value;

    static {
        ErrorType r1 = new ErrorType("INTERNAL", 0, "client_error");
        INTERNAL = r1;
        ErrorType r2 = new ErrorType("NETWORK", 1, "network_error");
        NETWORK = r2;
        a = new ErrorType[]{r1, r2};
    }

    public static ErrorType valueOf(String r1) {
        return (ErrorType) a.a(ErrorType.class, r1);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ErrorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
