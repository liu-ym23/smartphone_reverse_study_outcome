package com.bytedance.locallife.pdp.action;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/pdp/action/JSBroadcastType;", "", "", "type", "I", "getType", "()I", "OPEN_RATE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum JSBroadcastType extends Enum<JSBroadcastType> {
    public static final JSBroadcastType OPEN_RATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSBroadcastType[] f260887a = null;
    private final int type;

    public static JSBroadcastType valueOf(String r100) {
        return (JSBroadcastType) a.a(JSBroadcastType.class, r100);
    }

    public static JSBroadcastType[] values() {
        return (JSBroadcastType[]) f260887a.clone();
    }

    static {
        JSBroadcastType r100 = new JSBroadcastType();
        OPEN_RATE = r100;
        f260887a = new JSBroadcastType[]{r100};
    }

    public JSBroadcastType() {
        super("OPEN_RATE", 0);
        this.type = 1;
    }

    public final int getType() {
        return this.type;
    }
}
