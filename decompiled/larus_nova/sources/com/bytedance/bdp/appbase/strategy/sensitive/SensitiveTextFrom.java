package com.bytedance.bdp.appbase.strategy.sensitive;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/strategy/sensitive/SensitiveTextFrom;", "", "", "textFrom", "Ljava/lang/String;", "getTextFrom", "()Ljava/lang/String;", "PAGE", "QRCODE", "MODAL", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum SensitiveTextFrom extends Enum<SensitiveTextFrom> {
    public static final SensitiveTextFrom MODAL = null;
    public static final SensitiveTextFrom PAGE = null;
    public static final SensitiveTextFrom QRCODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SensitiveTextFrom[] f201046a = null;
    private final String textFrom;

    static {
        SensitiveTextFrom r100 = new SensitiveTextFrom("PAGE", 0, "page_ctx");
        PAGE = r100;
        SensitiveTextFrom r101 = new SensitiveTextFrom("QRCODE", 1, "qrcode_ctx");
        QRCODE = r101;
        SensitiveTextFrom r102 = new SensitiveTextFrom("MODAL", 2, "modal_ctx");
        MODAL = r102;
        f201046a = new SensitiveTextFrom[]{r100, r101, r102};
    }

    public static SensitiveTextFrom valueOf(String r100) {
        return (SensitiveTextFrom) r27.a.a(SensitiveTextFrom.class, r100);
    }

    public static SensitiveTextFrom[] values() {
        return (SensitiveTextFrom[]) f201046a.clone();
    }

    public final String getTextFrom() {
        return this.textFrom;
    }

    public SensitiveTextFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.textFrom = r102;
    }
}
