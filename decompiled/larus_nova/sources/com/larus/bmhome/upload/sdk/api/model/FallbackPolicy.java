package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/FallbackPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Enabled", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FallbackPolicy extends Enum<FallbackPolicy> {
    public static final FallbackPolicy Disabled = null;
    public static final FallbackPolicy Enabled = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FallbackPolicy[] f314812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314813b = null;

    public static EnumEntries<FallbackPolicy> getEntries() {
        return f314813b;
    }

    static {
        FallbackPolicy r100 = new FallbackPolicy("Enabled", 0);
        Enabled = r100;
        FallbackPolicy r101 = new FallbackPolicy("Disabled", 1);
        Disabled = r101;
        FallbackPolicy[] r102 = {r100, r101};
        f314812a = r102;
        f314813b = EnumEntriesKt.enumEntries(r102);
    }

    public static FallbackPolicy[] values() {
        return (FallbackPolicy[]) f314812a.clone();
    }

    public static FallbackPolicy valueOf(String r100) {
        return (FallbackPolicy) a.a(FallbackPolicy.class, r100);
    }

    public FallbackPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
