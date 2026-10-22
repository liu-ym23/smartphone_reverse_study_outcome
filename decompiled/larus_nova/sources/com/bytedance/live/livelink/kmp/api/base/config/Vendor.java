package com.bytedance.live.livelink.kmp.api.base.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/config/Vendor;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BYTE", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Vendor extends Enum<Vendor> {
    public static final Vendor BYTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Vendor[] f255219a = null;
    private final String value;

    static {
        Vendor r100 = new Vendor();
        BYTE = r100;
        f255219a = new Vendor[]{r100};
    }

    public static Vendor valueOf(String r100) {
        return (Vendor) a.a(Vendor.class, r100);
    }

    public static Vendor[] values() {
        return (Vendor[]) f255219a.clone();
    }

    public Vendor() {
        super("BYTE", 0);
        this.value = "byte";
    }

    public final String getValue() {
        return this.value;
    }
}
