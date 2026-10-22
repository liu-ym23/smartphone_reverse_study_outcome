package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "", "", "value", "I", "getValue", "()I", "DISABLE", "REPORT_ONLY", "CHECK", "TOGGLE_OFF", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum RequestCheckAction extends Enum<RequestCheckAction> {
    public static final RequestCheckAction CHECK = null;
    public static final RequestCheckAction DISABLE = null;
    public static final RequestCheckAction REPORT_ONLY = null;
    public static final RequestCheckAction TOGGLE_OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestCheckAction[] f269830a = null;
    private final int value;

    public static RequestCheckAction valueOf(String r100) {
        return (RequestCheckAction) a.a(RequestCheckAction.class, r100);
    }

    public static RequestCheckAction[] values() {
        return (RequestCheckAction[]) f269830a.clone();
    }

    static {
        RequestCheckAction r100 = new RequestCheckAction("DISABLE", 0, 0);
        DISABLE = r100;
        RequestCheckAction r101 = new RequestCheckAction("REPORT_ONLY", 1, 1);
        REPORT_ONLY = r101;
        RequestCheckAction r102 = new RequestCheckAction("CHECK", 2, 2);
        CHECK = r102;
        RequestCheckAction r103 = new RequestCheckAction("TOGGLE_OFF", 3, 99);
        TOGGLE_OFF = r103;
        f269830a = new RequestCheckAction[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public RequestCheckAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
