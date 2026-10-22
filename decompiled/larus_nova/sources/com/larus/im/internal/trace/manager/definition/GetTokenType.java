package com.larus.im.internal.trace.manager.definition;

import com.bytedance.pia.core.metrics.ErrorType;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/GetTokenType;", "", "definition", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;IJLjava/lang/String;)V", "getDefinition", "()J", "getDesc", "()Ljava/lang/String;", "CACHE", "PREFETCH", "REQUEST", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GetTokenType extends Enum<GetTokenType> {
    public static final GetTokenType CACHE = null;
    public static final GetTokenType PREFETCH = null;
    public static final GetTokenType REQUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetTokenType[] f350159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350160b = null;
    private final long definition;
    private final String desc;

    public static EnumEntries<GetTokenType> getEntries() {
        return f350160b;
    }

    static {
        GetTokenType r100 = new GetTokenType("CACHE", 0, 0, "cache");
        CACHE = r100;
        GetTokenType r101 = new GetTokenType("PREFETCH", 1, 1, ErrorType.PREFETCH);
        PREFETCH = r101;
        GetTokenType r102 = new GetTokenType("REQUEST", 2, 2, "request");
        REQUEST = r102;
        GetTokenType[] r103 = {r100, r101, r102};
        f350159a = r103;
        f350160b = EnumEntriesKt.enumEntries(r103);
    }

    public static GetTokenType[] values() {
        return (GetTokenType[]) f350159a.clone();
    }

    public final long getDefinition() {
        return this.definition;
    }

    public final String getDesc() {
        return this.desc;
    }

    public static GetTokenType valueOf(String r100) {
        return (GetTokenType) a.a(GetTokenType.class, r100);
    }

    public GetTokenType(String r100, int r101, long r102, String r103) {
        super(r100, r101);
        this.definition = r102;
        this.desc = r103;
    }
}
