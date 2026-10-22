package com.bytedance.caijing.sdk.infra.base.api.trip.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/TripTaxiStatisticEvent;", "", "MAP_INIT_COMPLETE", "MAP_TOUCHED", "VIEW_RENDER", "UNKNOWN", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum TripTaxiStatisticEvent extends Enum<TripTaxiStatisticEvent> {
    public static final TripTaxiStatisticEvent MAP_INIT_COMPLETE = null;
    public static final TripTaxiStatisticEvent MAP_TOUCHED = null;
    public static final TripTaxiStatisticEvent UNKNOWN = null;
    public static final TripTaxiStatisticEvent VIEW_RENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TripTaxiStatisticEvent[] f202251a = null;

    public static TripTaxiStatisticEvent valueOf(String r100) {
        return (TripTaxiStatisticEvent) a.a(TripTaxiStatisticEvent.class, r100);
    }

    public static TripTaxiStatisticEvent[] values() {
        return (TripTaxiStatisticEvent[]) f202251a.clone();
    }

    static {
        TripTaxiStatisticEvent r100 = new TripTaxiStatisticEvent("MAP_INIT_COMPLETE", 0);
        MAP_INIT_COMPLETE = r100;
        TripTaxiStatisticEvent r101 = new TripTaxiStatisticEvent("MAP_TOUCHED", 1);
        MAP_TOUCHED = r101;
        TripTaxiStatisticEvent r102 = new TripTaxiStatisticEvent("VIEW_RENDER", 2);
        VIEW_RENDER = r102;
        TripTaxiStatisticEvent r103 = new TripTaxiStatisticEvent("UNKNOWN", 3);
        UNKNOWN = r103;
        f202251a = new TripTaxiStatisticEvent[]{r100, r101, r102, r103};
    }

    public TripTaxiStatisticEvent(String r100, int r101) {
        super(r100, r101);
    }
}
