package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/RoutePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceResourceCenter", "ForceUploadAuthToken", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RoutePolicy extends Enum<RoutePolicy> {
    public static final RoutePolicy Auto = null;
    public static final RoutePolicy ForceResourceCenter = null;
    public static final RoutePolicy ForceUploadAuthToken = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoutePolicy[] f314818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314819b = null;

    public static EnumEntries<RoutePolicy> getEntries() {
        return f314819b;
    }

    static {
        RoutePolicy r100 = new RoutePolicy("Auto", 0);
        Auto = r100;
        RoutePolicy r101 = new RoutePolicy("ForceResourceCenter", 1);
        ForceResourceCenter = r101;
        RoutePolicy r102 = new RoutePolicy("ForceUploadAuthToken", 2);
        ForceUploadAuthToken = r102;
        RoutePolicy[] r103 = {r100, r101, r102};
        f314818a = r103;
        f314819b = EnumEntriesKt.enumEntries(r103);
    }

    public static RoutePolicy[] values() {
        return (RoutePolicy[]) f314818a.clone();
    }

    public static RoutePolicy valueOf(String r100) {
        return (RoutePolicy) a.a(RoutePolicy.class, r100);
    }

    public RoutePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
