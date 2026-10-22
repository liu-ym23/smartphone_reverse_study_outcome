package com.larus.home.impl.route;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/home/impl/route/ServiceBotRouteDecision;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE_NORMAL_ROUTE", "OPEN_SERVICE_BOT", "FALLBACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ServiceBotRouteDecision extends Enum<ServiceBotRouteDecision> {
    public static final ServiceBotRouteDecision CONTINUE_NORMAL_ROUTE = null;
    public static final ServiceBotRouteDecision FALLBACK = null;
    public static final ServiceBotRouteDecision OPEN_SERVICE_BOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ServiceBotRouteDecision[] f346055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346056b = null;

    public static EnumEntries<ServiceBotRouteDecision> getEntries() {
        return f346056b;
    }

    static {
        ServiceBotRouteDecision r100 = new ServiceBotRouteDecision("CONTINUE_NORMAL_ROUTE", 0);
        CONTINUE_NORMAL_ROUTE = r100;
        ServiceBotRouteDecision r101 = new ServiceBotRouteDecision("OPEN_SERVICE_BOT", 1);
        OPEN_SERVICE_BOT = r101;
        ServiceBotRouteDecision r102 = new ServiceBotRouteDecision("FALLBACK", 2);
        FALLBACK = r102;
        ServiceBotRouteDecision[] r103 = {r100, r101, r102};
        f346055a = r103;
        f346056b = EnumEntriesKt.enumEntries(r103);
    }

    public static ServiceBotRouteDecision[] values() {
        return (ServiceBotRouteDecision[]) f346055a.clone();
    }

    public static ServiceBotRouteDecision valueOf(String r100) {
        return (ServiceBotRouteDecision) r27.a.a(ServiceBotRouteDecision.class, r100);
    }

    public ServiceBotRouteDecision(String r100, int r101) {
        super(r100, r101);
    }
}
