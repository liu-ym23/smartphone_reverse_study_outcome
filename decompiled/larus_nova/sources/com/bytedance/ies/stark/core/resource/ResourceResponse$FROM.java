package com.bytedance.ies.stark.core.resource;

import com.amap.api.services.cloud.CloudSearch;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"com/bytedance/ies/stark/core/resource/ResourceResponse$FROM", "", "Lcom/bytedance/ies/stark/core/resource/ResourceResponse$FROM;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BUILTIN", "GECKO", "GECKO_UPDATE", "CDN", "CDN_CACHE", AccountType.LOCAL, FlowDoraWifiScene.OTHER, "MISSING", "PRELOADED", "stark-api_release"}, k = 1, mv = {1, 7, 1})
public final enum ResourceResponse$FROM extends Enum<ResourceResponse$FROM> {
    public static final ResourceResponse$FROM BUILTIN = null;
    public static final ResourceResponse$FROM CDN = null;
    public static final ResourceResponse$FROM CDN_CACHE = null;
    public static final ResourceResponse$FROM GECKO = null;
    public static final ResourceResponse$FROM GECKO_UPDATE = null;
    public static final ResourceResponse$FROM LOCAL = null;
    public static final ResourceResponse$FROM MISSING = null;
    public static final ResourceResponse$FROM OTHER = null;
    public static final ResourceResponse$FROM PRELOADED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceResponse$FROM[] f248624a = null;
    private final String value;

    public static ResourceResponse$FROM valueOf(String r100) {
        return (ResourceResponse$FROM) r27.a.a(ResourceResponse$FROM.class, r100);
    }

    public static ResourceResponse$FROM[] values() {
        return (ResourceResponse$FROM[]) f248624a.clone();
    }

    static {
        ResourceResponse$FROM r100 = new ResourceResponse$FROM("BUILTIN", 0, "Builtin");
        BUILTIN = r100;
        ResourceResponse$FROM r101 = new ResourceResponse$FROM("GECKO", 1, "Gecko");
        GECKO = r101;
        ResourceResponse$FROM r102 = new ResourceResponse$FROM("GECKO_UPDATE", 2, "Gecko Update");
        GECKO_UPDATE = r102;
        ResourceResponse$FROM r103 = new ResourceResponse$FROM("CDN", 3, "CDN");
        CDN = r103;
        ResourceResponse$FROM r104 = new ResourceResponse$FROM("CDN_CACHE", 4, "CDN Cache");
        CDN_CACHE = r104;
        ResourceResponse$FROM r105 = new ResourceResponse$FROM(AccountType.LOCAL, 5, CloudSearch.SearchBound.LOCAL_SHAPE);
        LOCAL = r105;
        ResourceResponse$FROM r110 = new ResourceResponse$FROM(FlowDoraWifiScene.OTHER, 6, "Other");
        OTHER = r110;
        ResourceResponse$FROM r111 = new ResourceResponse$FROM("MISSING", 7, "Missing");
        MISSING = r111;
        ResourceResponse$FROM r112 = new ResourceResponse$FROM("PRELOADED", 8, "Preloaded");
        PRELOADED = r112;
        f248624a = new ResourceResponse$FROM[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final String getValue() {
        return this.value;
    }

    public ResourceResponse$FROM(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
